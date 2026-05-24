package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhg implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhc zzb;

    zzhg(zzhc zzhcVar, long j) {
        this.zzb = zzhcVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs().zzl.zza(this.zza);
        this.zzb.zzr().zzw().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
