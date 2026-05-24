package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzik implements Runnable {
    private final /* synthetic */ zzii zza;
    private final /* synthetic */ zzii zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzih zze;

    zzik(zzih zzihVar, zzii zziiVar, zzii zziiVar2, long j, boolean z) {
        this.zze = zzihVar;
        this.zza = zziiVar;
        this.zzb = zziiVar2;
        this.zzc = j;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
