package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzht implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhc zzb;

    zzht(zzhc zzhcVar, boolean z) {
        this.zzb = zzhcVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
