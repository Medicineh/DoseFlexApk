package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzh implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    private final /* synthetic */ zzaq zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar, zzaq zzaqVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzsVar;
        this.zzb = zzaqVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
