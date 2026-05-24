package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkf implements Runnable {
    private final /* synthetic */ zzkl zza;
    private final /* synthetic */ zzkg zzb;

    zzkf(zzkg zzkgVar, zzkl zzklVar) {
        this.zzb = zzkgVar;
        this.zza = zzklVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
