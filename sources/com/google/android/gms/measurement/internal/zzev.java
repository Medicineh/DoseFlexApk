package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzev {
    private final int zza;
    private final boolean zzb;
    private final boolean zzc;
    private final /* synthetic */ zzet zzd;

    zzev(zzet zzetVar, int i, boolean z, boolean z2) {
        this.zzd = zzetVar;
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
    }

    public final void zza(String str) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, null, null, null);
    }

    public final void zza(String str, Object obj) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, obj2, obj3);
    }
}
