package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zziw implements zzde<zziz> {
    private static zziw zza = new zziw();
    private final zzde<zziz> zzb;

    public static boolean zzb() {
        return ((zziz) zza.zza()).zza();
    }

    private zziw(zzde<zziz> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zziw() {
        this(zzdh.zza(new zziy()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zziz zza() {
        return this.zzb.zza();
    }
}
