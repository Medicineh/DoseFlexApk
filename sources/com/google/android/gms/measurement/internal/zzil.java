package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzil implements Runnable {
    private final /* synthetic */ zzii zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzih zzc;

    zzil(zzih zzihVar, zzii zziiVar, long j) {
        this.zzc = zzihVar;
        this.zza = zziiVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzh().zza((zzii) null);
    }
}
