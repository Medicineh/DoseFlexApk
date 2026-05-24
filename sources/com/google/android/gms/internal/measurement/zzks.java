package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzks implements zzde<zzkv> {
    private static zzks zza = new zzks();
    private final zzde<zzkv> zzb;

    public static boolean zzb() {
        return ((zzkv) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkv) zza.zza()).zzb();
    }

    private zzks(zzde<zzkv> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzks() {
        this(zzdh.zza(new zzku()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkv zza() {
        return this.zzb.zza();
    }
}
