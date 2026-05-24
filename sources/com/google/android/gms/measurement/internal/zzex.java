package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzex {
    public String zza;
    public String zzb;
    public long zzc;
    public Bundle zzd;

    public zzex(String str, String str2, Bundle bundle, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle == null ? new Bundle() : bundle;
        this.zzc = j;
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zza;
        String strValueOf = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(strValueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(strValueOf);
        return sb.toString();
    }
}
