package io.doseapp.android;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes.dex */
public class WebAppInterface {
    public Context mContext;
    public MainActivity mainActivity;

    WebAppInterface(Context context, MainActivity mainActivity) {
        this.mContext = context;
        this.mainActivity = mainActivity;
    }

    @JavascriptInterface
    public void logEvent(String str, String str2, String str3, Integer num) {
        Log.i("ANAL", "Telemetry disabled; dropping event " + str);
    }

    @JavascriptInterface
    public void share(String str) {
        Log.i("ANAL", "Share" + str);
    }

    @JavascriptInterface
    public String getFCM() {
        return "";
    }
}
