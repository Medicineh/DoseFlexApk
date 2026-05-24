package io.doseapp.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.kobakei.ratethisapp.RateThisApp;
import im.delight.android.webview.AdvancedWebView;
import io.doseapp.android.ui.UIManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements AdvancedWebView.Listener {
    private static final int CREATE_FILE = 1;
    private byte[] decodedFile;
    private boolean isOffline;
    private AdvancedWebView mWebView;
    private LinearLayout offlineContainer;
    private SwipeRefreshLayout swipeRefreshLayout;
    private UIManager uiManager;
    private WindowActivity windowActivity;
    private String TAG = "MainActivity";
    private Integer OPEN_DOCUMENT_REQUEST_CODE = 51;
    private String LAST_OPENED_URI_KEY = "io.doseapp.android.pref.LAST_OPENED_URI_KEY";

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        AdvancedWebView advancedWebView = (AdvancedWebView) findViewById(R.id.webView);
        this.mWebView = advancedWebView;
        advancedWebView.setListener(this, this);
        this.isOffline = false;
        this.uiManager = new UIManager(this);
        this.mWebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        this.mWebView.getSettings().setAllowFileAccess(true);
        this.mWebView.getSettings().setAppCacheEnabled(true);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: io.doseapp.android.MainActivity.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.i(MainActivity.this.TAG, "Console message " + consoleMessage.message());
                return super.onConsoleMessage(consoleMessage);
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: io.doseapp.android.MainActivity.2
            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                Log.i(MainActivity.this.TAG, "received error http");
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                MainActivity.this.setOffline(true);
            }

            @Override // android.webkit.WebViewClient
            @Deprecated
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Log.i(MainActivity.this.TAG, "received error d");
                if (Build.VERSION.SDK_INT < 23) {
                    MainActivity.this.setOffline(true);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Log.i(MainActivity.this.TAG, "received error");
                if (Build.VERSION.SDK_INT >= 23) {
                    if (webView.getUrl().equals(webResourceRequest.getUrl().toString())) {
                        MainActivity.this.setOffline(true);
                    }
                }
            }
        });
        this.mWebView.addJavascriptInterface(new WebAppInterface(this, this), "Android");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.green);
        this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: io.doseapp.android.MainActivity.3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MainActivity.this.mWebView.reload();
            }
        });
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.addPermittedHostname("localhost");
        this.mWebView.loadUrl(Constants.WEBAPP_URL);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.offlineContainer);
        this.offlineContainer = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: io.doseapp.android.MainActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.mWebView.loadUrl(Constants.WEBAPP_URL);
            }
        });
        this.uiManager.changeRecentAppsIcon();
        RateThisApp.Config config = new RateThisApp.Config(7, 10);
        config.setMessage(R.string.rate_message);
        RateThisApp.init(config);
        RateThisApp.onCreate(this);
        RateThisApp.showRateDialogIfNeeded(this);
    }

    public void setOffline(boolean z) {
        Log.i(this.TAG, "Set offline " + z);
        if (z) {
            this.uiManager.setLoadingProgress(100);
            this.mWebView.setVisibility(4);
            this.offlineContainer.setVisibility(0);
            this.isOffline = true;
            return;
        }
        this.mWebView.setVisibility(0);
        this.offlineContainer.setVisibility(4);
        this.isOffline = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mWebView.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.mWebView.onPause();
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mWebView.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        super.onActivityResult(i, i2, intent);
        this.mWebView.onActivityResult(i, i2, intent);
        Log.i(this.TAG, "onActivityResult");
        if (i2 == -1 && i == 1 && intent != null && (data = intent.getData()) != null) {
            alterDocument(data, this.decodedFile);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mWebView.onBackPressed()) {
            Log.i(this.TAG, "back pressed");
            super.onBackPressed();
        }
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onPageStarted(String str, Bitmap bitmap) {
        Log.i(this.TAG, "pageStarted" + str);
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onPageFinished(String str) {
        Log.i(this.TAG, "pageFinished" + str);
        this.swipeRefreshLayout.setRefreshing(false);
        if (this.isOffline) {
            setOffline(false);
        }
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onPageError(int i, String str, String str2) {
        Log.i(this.TAG, "pageError" + i + str + str2);
        this.swipeRefreshLayout.setRefreshing(false);
        setOffline(true);
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onDownloadRequested(String str, String str2, String str3, long j, String str4, String str5) {
        Log.i("SUGGESTED", str2);
        Log.i("URL", str);
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(strArr, 0);
        }
        Log.i("PERM", str);
        if (str.startsWith("data:")) {
            saveBackup(str);
        } else {
            AdvancedWebView.handleDownload(this, str, str2);
        }
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onExternalPageRequest(String str) {
        Log.i("EXTERNAL URL", str);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private boolean openFile() {
        Log.i(this.TAG, "Open");
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/json");
        intent.putExtra("android.intent.extra.TITLE", "dose-backup-" + System.currentTimeMillis() + ".json");
        startActivityForResult(intent, 1);
        Log.i(this.TAG, "Open Finished");
        return true;
    }

    private void alterDocument(Uri uri, byte[] bArr) {
        Log.i(this.TAG, "Alter" + uri.toString() + bArr.toString());
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = getContentResolver().openFileDescriptor(uri, "w");
            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            parcelFileDescriptorOpenFileDescriptor.close();
            Log.i(this.TAG, "Alter Finished");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void saveBackup(String str) {
        try {
            this.decodedFile = URLDecoder.decode(str.substring(str.indexOf(",") + 1), "UTF-8").getBytes();
            Boolean.valueOf(openFile());
        } catch (IOException e) {
            Log.w("ExternalStorage", "Error writing", e);
            Toast.makeText(getApplicationContext(), "Failed to save", 1).show();
        }
    }
}
