package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfd zzb;

    zzfg(zzfd zzfdVar, boolean z) {
        this.zzb = zzfdVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
