package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzj implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzsVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
