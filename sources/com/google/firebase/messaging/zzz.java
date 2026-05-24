package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class zzz {
    private static final Pattern zza = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private final String zzb;
    private final String zzc;
    private final String zzd;

    private zzz(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str));
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !zza.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", strSubstring, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        this.zzb = strSubstring;
        this.zzc = str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("!");
        sb.append(str2);
        this.zzd = sb.toString();
    }

    public static zzz zza(String str) {
        return new zzz("S", str);
    }

    public static zzz zzb(String str) {
        return new zzz("U", str);
    }

    static zzz zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new zzz(strArrSplit[0], strArrSplit[1]);
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzz)) {
            return false;
        }
        zzz zzzVar = (zzz) obj;
        return this.zzb.equals(zzzVar.zzb) && this.zzc.equals(zzzVar.zzc);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zzb);
    }
}
