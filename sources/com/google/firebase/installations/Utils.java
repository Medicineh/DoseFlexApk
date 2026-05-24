package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* JADX INFO: loaded from: classes.dex */
class Utils {
    private static final String APP_ID_IDENTIFICATION_SUBSTRING = ":";
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);
    private static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");

    Utils() {
    }

    public boolean isAuthTokenExpired(PersistedInstallationEntry persistedInstallationEntry) {
        return TextUtils.isEmpty(persistedInstallationEntry.getAuthToken()) || persistedInstallationEntry.getTokenCreationEpochInSecs() + persistedInstallationEntry.getExpiresInSecs() < currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
    }

    public long currentTimeInSecs() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    static boolean isValidAppIdFormat(String str) {
        return str.contains(APP_ID_IDENTIFICATION_SUBSTRING);
    }

    static boolean isValidApiKeyFormat(String str) {
        return API_KEY_FORMAT.matcher(str).matches();
    }
}
