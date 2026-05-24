package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgl implements Runnable {
    private final /* synthetic */ zzkn zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgc zzc;

    zzgl(zzgc zzgcVar, zzkn zzknVar, zzm zzmVar) {
        this.zzc = zzgcVar;
        this.zza = zzknVar;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
