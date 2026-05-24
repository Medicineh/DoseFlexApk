package io.doseapp.android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public class WebAppInterface {
    private FirebaseAnalytics analytics;
    public Context mContext;
    public MainActivity mainActivity;

    WebAppInterface(Context context, FirebaseAnalytics firebaseAnalytics, MainActivity mainActivity) {
        this.mContext = context;
        this.analytics = firebaseAnalytics;
        this.mainActivity = mainActivity;
    }

    @JavascriptInterface
    public void logEvent(String str, String str2, String str3, Integer num) {
        Log.i("ANAL", "LOG EVENT" + str + str2 + str3);
        Bundle bundle = new Bundle();
        bundle.putString("label", str3);
        bundle.putString("category", str2);
        this.analytics.logEvent(str, bundle);
    }

    @JavascriptInterface
    public void share(String str) {
        Log.i("ANAL", "Share" + str);
    }

    @JavascriptInterface
    public String getFCM() {
        return this.mainActivity.fcmToken;
    }
}
