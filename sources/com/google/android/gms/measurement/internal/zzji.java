package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzji implements Runnable {
    private final /* synthetic */ zzel zza;
    private final /* synthetic */ zzjf zzb;

    zzji(zzjf zzjfVar, zzel zzelVar) {
        this.zzb = zzjfVar;
        this.zza = zzelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            zzjf.zza(this.zzb, false);
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzx().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
