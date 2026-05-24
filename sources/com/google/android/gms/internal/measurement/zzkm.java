package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkm implements zzde<zzkp> {
    private static zzkm zza = new zzkm();
    private final zzde<zzkp> zzb;

    public static boolean zzb() {
        return ((zzkp) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkp) zza.zza()).zzb();
    }

    private zzkm(zzde<zzkp> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzkm() {
        this(zzdh.zza(new zzko()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkp zza() {
        return this.zzb.zza();
    }
}
