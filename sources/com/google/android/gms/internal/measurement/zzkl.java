package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkl implements zzde<zzkk> {
    private static zzkl zza = new zzkl();
    private final zzde<zzkk> zzb;

    public static boolean zzb() {
        return ((zzkk) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkk) zza.zza()).zzb();
    }

    private zzkl(zzde<zzkk> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzkl() {
        this(zzdh.zza(new zzkn()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkk zza() {
        return this.zzb.zza();
    }
}
