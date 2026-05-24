package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjz implements zzde<zzjy> {
    private static zzjz zza = new zzjz();
    private final zzde<zzjy> zzb;

    public static boolean zzb() {
        return ((zzjy) zza.zza()).zza();
    }

    private zzjz(zzde<zzjy> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzjz() {
        this(zzdh.zza(new zzkb()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzjy zza() {
        return this.zzb.zza();
    }
}
