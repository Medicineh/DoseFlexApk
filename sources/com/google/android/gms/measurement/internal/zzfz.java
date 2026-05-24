package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfz implements Runnable {
    private final /* synthetic */ zzgz zza;
    private final /* synthetic */ zzfx zzb;

    zzfz(zzfx zzfxVar, zzgz zzgzVar) {
        this.zzb = zzfxVar;
        this.zza = zzgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
