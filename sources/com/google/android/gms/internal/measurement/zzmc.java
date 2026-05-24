package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmc implements zzde<zzmf> {
    private static zzmc zza = new zzmc();
    private final zzde<zzmf> zzb;

    public static boolean zzb() {
        return ((zzmf) zza.zza()).zza();
    }

    private zzmc(zzde<zzmf> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmc() {
        this(zzdh.zza(new zzme()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzmf zza() {
        return this.zzb.zza();
    }
}
