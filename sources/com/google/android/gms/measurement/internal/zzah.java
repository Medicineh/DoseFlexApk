package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzah implements Runnable {
    private final /* synthetic */ zzgu zza;
    private final /* synthetic */ zzai zzb;

    zzah(zzai zzaiVar, zzgu zzguVar) {
        this.zzb = zzaiVar;
        this.zza = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzu();
        if (zzv.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zZzb = this.zzb.zzb();
        zzai.zza(this.zzb, 0L);
        if (zZzb) {
            this.zzb.zza();
        }
    }
}
