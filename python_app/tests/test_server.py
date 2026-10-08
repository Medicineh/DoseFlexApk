import json
import os
import sys
import tempfile
import threading
import unittest
import urllib.error
import urllib.request

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import main  # noqa: E402
from dose_store import DoseStore  # noqa: E402


class ServerTest(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        store = DoseStore(os.path.join(self.tmp.name, "doses.json"))
        self.server = main.make_server(port=0, store=store, backups=lambda: self.tmp.name)
        self.base = f"http://127.0.0.1:{self.server.server_address[1]}"
        threading.Thread(target=self.server.serve_forever, daemon=True).start()

    def tearDown(self):
        self.server.shutdown()
        self.server.server_close()
        self.tmp.cleanup()

    def call(self, method, path, body=None):
        data = None if body is None else json.dumps(body).encode()
        req = urllib.request.Request(self.base + path, data=data, method=method,
                                     headers={"Content-Type": "application/json"})
        try:
            with urllib.request.urlopen(req) as res:
                return res.status, res.read()
        except urllib.error.HTTPError as e:
            return e.code, e.read()

    def test_index_page(self):
        status, body = self.call("GET", "/")
        self.assertEqual(status, 200)
        self.assertIn(b"<title>Dose</title>", body)

    def test_path_traversal_blocked(self):
        status, _ = self.call("GET", "/../main.py")
        self.assertEqual(status, 404)

    def test_add_list_delete(self):
        status, body = self.call("POST", "/api/doses",
                                 {"substance": "Cafeína", "amount": "100", "unit": "mg"})
        self.assertEqual(status, 200)
        state = json.loads(body)
        self.assertEqual(state["summary"][0]["substance"], "Cafeína")
        dose_id = state["doses"][0]["id"]
        status, body = self.call("DELETE", "/api/doses/" + dose_id)
        self.assertEqual(status, 200)
        self.assertEqual(json.loads(body)["doses"], [])
        status, _ = self.call("DELETE", "/api/doses/" + dose_id)
        self.assertEqual(status, 404)

    def test_add_invalid(self):
        status, body = self.call("POST", "/api/doses", {"substance": "", "amount": "1"})
        self.assertEqual(status, 400)
        self.assertIn("error", json.loads(body))

    def test_export_then_import(self):
        self.call("POST", "/api/doses", {"substance": "A", "amount": "1"})
        status, body = self.call("POST", "/api/export", {})
        self.assertEqual(status, 200)
        self.assertTrue(os.path.exists(json.loads(body)["path"]))
        status, body = self.call("POST", "/api/import", {})
        self.assertEqual(status, 200)
        self.assertEqual(json.loads(body)["added"], 0)

    def test_import_without_backup(self):
        status, _ = self.call("POST", "/api/import", {})
        self.assertEqual(status, 404)

    def test_telemetry_endpoints(self):
        self.assertEqual(self.call("POST", "/api/log", {"name": "x"})[0], 200)
        self.assertEqual(json.loads(self.call("GET", "/api/fcm")[1]), {"token": ""})


if __name__ == "__main__":
    unittest.main()
