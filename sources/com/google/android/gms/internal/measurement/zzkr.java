package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkr implements zzde<zzkq> {
    private static zzkr zza = new zzkr();
    private final zzde<zzkq> zzb;

    public static boolean zzb() {
        return ((zzkq) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkq) zza.zza()).zzb();
    }

    private zzkr(zzde<zzkq> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzkr() {
        this(zzdh.zza(new zzkt()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkq zza() {
        return this.zzb.zza();
    }
}
