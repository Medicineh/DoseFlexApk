package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcw {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;

    @Nullable
    final zzda<Context, Boolean> zzi;

    public zzcw(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzcw(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzda<Context, Boolean> zzdaVar) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcq<Long> zza(String str, long j) {
        return zzcq.zzb(this, str, j, false);
    }

    public final zzcq<Boolean> zza(String str, boolean z) {
        return zzcq.zzb(this, str, z, false);
    }

    public final zzcq<Double> zza(String str, double d) {
        return zzcq.zzb(this, str, -3.0d, false);
    }

    public final zzcq<String> zza(String str, String str2) {
        return zzcq.zzb(this, str, str2, false);
    }
}
