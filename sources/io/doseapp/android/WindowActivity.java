package io.doseapp.android;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import im.delight.android.webview.AdvancedWebView;

/* JADX INFO: loaded from: classes.dex */
class WindowActivity extends AppCompatActivity implements AdvancedWebView.Listener {
    private AdvancedWebView mWebView;

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onExternalPageRequest(String str) {
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onPageError(int i, String str, String str2) {
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onPageFinished(String str) {
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onPageStarted(String str, Bitmap bitmap) {
    }

    WindowActivity() {
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
        super.onActivityResult(i, i2, intent);
        this.mWebView.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mWebView.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // im.delight.android.webview.AdvancedWebView.Listener
    public void onDownloadRequested(String str, String str2, String str3, long j, String str4, String str5) {
        AdvancedWebView.handleDownload(this, str, str2);
    }
}
