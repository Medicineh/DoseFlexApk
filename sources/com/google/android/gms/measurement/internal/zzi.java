package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzi implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzw().zza(this.zza);
    }
}
