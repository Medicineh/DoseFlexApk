package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgj implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgc zzc;

    zzgj(zzgc zzgcVar, zzaq zzaqVar, String str) {
        this.zzc = zzgcVar;
        this.zza = zzaqVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
