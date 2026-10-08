import os
import sys
import unittest
import tempfile

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from dose_store import DoseStore, format_elapsed  # noqa: E402


class DoseStoreTest(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        self.path = os.path.join(self.tmp.name, "doses.json")

    def tearDown(self):
        self.tmp.cleanup()

    def test_add_persists(self):
        store = DoseStore(self.path)
        store.add("Cafeína", "100", "mg", timestamp=1000)
        reloaded = DoseStore(self.path)
        self.assertEqual(len(reloaded.doses), 1)
        self.assertEqual(reloaded.doses[0]["substance"], "Cafeína")
        self.assertEqual(reloaded.doses[0]["amount"], 100.0)

    def test_add_accepts_comma_decimal(self):
        store = DoseStore(self.path)
        dose = store.add("X", "2,5", "ml")
        self.assertEqual(dose["amount"], 2.5)

    def test_add_rejects_bad_input(self):
        store = DoseStore(self.path)
        with self.assertRaises(ValueError):
            store.add("", "10", "mg")
        with self.assertRaises(ValueError):
            store.add("X", "0", "mg")
        with self.assertRaises(ValueError):
            store.add("X", "abc", "mg")

    def test_delete(self):
        store = DoseStore(self.path)
        dose = store.add("X", "1", "mg")
        self.assertTrue(store.delete(dose["id"]))
        self.assertFalse(store.delete(dose["id"]))
        self.assertEqual(DoseStore(self.path).doses, [])

    def test_summary_window(self):
        store = DoseStore(self.path)
        now = 100000
        store.add("X", "10", "mg", timestamp=now - 3600)
        store.add("X", "5", "mg", timestamp=now - 25 * 3600)
        store.add("Y", "1", "g", timestamp=now - 60)
        summary = store.summary(now=now)
        self.assertEqual(summary["X"]["total_window"], 10)
        self.assertEqual(summary["X"]["last"], now - 3600)
        self.assertEqual(summary["Y"]["total_window"], 1)

    def test_sorted_newest_first(self):
        store = DoseStore(self.path)
        store.add("A", "1", "mg", timestamp=1)
        store.add("B", "1", "mg", timestamp=3)
        store.add("C", "1", "mg", timestamp=2)
        self.assertEqual([d["substance"] for d in store.sorted_doses()], ["B", "C", "A"])

    def test_export_import_no_duplicates(self):
        store = DoseStore(self.path)
        store.add("A", "1", "mg", timestamp=1)
        backup = os.path.join(self.tmp.name, "backup", "b.json")
        store.export_backup(backup)

        other = DoseStore(os.path.join(self.tmp.name, "other.json"))
        self.assertEqual(other.import_backup(backup), 1)
        self.assertEqual(other.import_backup(backup), 0)
        self.assertEqual(len(other.doses), 1)

    def test_import_skips_invalid_entries(self):
        backup = os.path.join(self.tmp.name, "bad.json")
        with open(backup, "w", encoding="utf-8") as f:
            f.write('{"doses": [{"substance": "A"}, '
                    '{"id": "1", "substance": "B", "amount": 2, "timestamp": 5}]}')
        store = DoseStore(self.path)
        self.assertEqual(store.import_backup(backup), 1)
        self.assertEqual(store.doses[0]["substance"], "B")

    def test_format_elapsed(self):
        self.assertEqual(format_elapsed(59), "0 min")
        self.assertEqual(format_elapsed(3 * 3600 + 120), "3 h 2 min")
        self.assertEqual(format_elapsed(26 * 3600), "1 d 2 h")


if __name__ == "__main__":
    unittest.main()
