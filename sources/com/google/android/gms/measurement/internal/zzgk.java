package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgk implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgc zzc;

    zzgk(zzgc zzgcVar, zzaq zzaqVar, zzm zzmVar) {
        this.zzc = zzgcVar;
        this.zza = zzaqVar;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaq zzaqVarZzb = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzaqVarZzb, this.zzb);
    }
}
