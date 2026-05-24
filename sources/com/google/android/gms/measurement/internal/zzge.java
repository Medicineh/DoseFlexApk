package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzge implements Runnable {
    private final /* synthetic */ zzy zza;
    private final /* synthetic */ zzgc zzb;

    zzge(zzgc zzgcVar, zzy zzyVar) {
        this.zzb = zzgcVar;
        this.zza = zzyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
