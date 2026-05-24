package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgn implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgc zzb;

    zzgn(zzgc zzgcVar, zzm zzmVar) {
        this.zzb = zzgcVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
