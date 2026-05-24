package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjq implements Runnable {
    private final /* synthetic */ zzkg zza;
    private final /* synthetic */ Runnable zzb;

    zzjq(zzjl zzjlVar, zzkg zzkgVar, Runnable runnable) {
        this.zza = zzkgVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
