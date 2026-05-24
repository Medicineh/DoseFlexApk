package io.doseapp.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import io.doseapp.android.Constants;
import io.doseapp.android.R;

/* JADX INFO: loaded from: classes.dex */
public class UIManager {
    private Activity activity;
    private LinearLayout offlineContainer;
    private boolean pageLoaded = false;
    private ProgressBar progressBar;
    private ProgressBar progressSpinner;
    private WebView webView;

    public UIManager(Activity activity) {
        this.activity = activity;
        this.progressBar = (ProgressBar) activity.findViewById(R.id.progressBarBottom);
        this.progressSpinner = (ProgressBar) activity.findViewById(R.id.progressSpinner);
        this.offlineContainer = (LinearLayout) activity.findViewById(R.id.offlineContainer);
        this.webView = (WebView) activity.findViewById(R.id.webView);
        this.offlineContainer.setOnClickListener(new View.OnClickListener() { // from class: io.doseapp.android.ui.UIManager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UIManager.this.webView.loadUrl(Constants.WEBAPP_URL);
                UIManager.this.setOffline(false);
            }
        });
    }

    public void setLoadingProgress(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.progressBar.setProgress(i, true);
        } else {
            this.progressBar.setProgress(i);
        }
        if (i >= 0 && i < 100) {
            this.progressBar.setVisibility(0);
        } else {
            this.progressBar.setVisibility(4);
        }
        if (i < Constants.PROGRESS_THRESHOLD || this.pageLoaded) {
            return;
        }
        setLoading(false);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.progressSpinner.setVisibility(0);
            this.webView.animate().translationX(Constants.SLIDE_EFFECT).alpha(0.5f).setInterpolator(new AccelerateInterpolator()).start();
        } else {
            this.webView.setTranslationX(Constants.SLIDE_EFFECT * (-1));
            this.webView.animate().translationX(0.0f).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).start();
            this.progressSpinner.setVisibility(4);
        }
        this.pageLoaded = !z;
    }

    public void setOffline(boolean z) {
        if (z) {
            setLoadingProgress(100);
            this.webView.setVisibility(4);
            this.offlineContainer.setVisibility(0);
        } else {
            this.webView.setVisibility(0);
            this.offlineContainer.setVisibility(4);
        }
    }

    public void changeRecentAppsIcon() {
        if (Build.VERSION.SDK_INT >= 21) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.activity.getResources(), R.drawable.ic_appbar);
            TypedValue typedValue = new TypedValue();
            this.activity.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            this.activity.setTaskDescription(new ActivityManager.TaskDescription(this.activity.getResources().getString(R.string.app_name), bitmapDecodeResource, typedValue.data));
            bitmapDecodeResource.recycle();
        }
    }
}
