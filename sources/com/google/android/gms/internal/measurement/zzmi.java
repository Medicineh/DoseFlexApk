package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmi implements zzde<zzml> {
    private static zzmi zza = new zzmi();
    private final zzde<zzml> zzb;

    public static boolean zzb() {
        return ((zzml) zza.zza()).zza();
    }

    private zzmi(zzde<zzml> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmi() {
        this(zzdh.zza(new zzmk()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzml zza() {
        return this.zzb.zza();
    }
}
