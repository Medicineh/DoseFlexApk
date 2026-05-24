package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjk implements Runnable {
    private final /* synthetic */ zzel zza;
    private final /* synthetic */ zzjf zzb;

    zzjk(zzjf zzjfVar, zzel zzelVar) {
        this.zzb = zzjfVar;
        this.zza = zzelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            zzjf.zza(this.zzb, false);
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
