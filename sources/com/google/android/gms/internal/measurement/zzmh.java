package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmh implements zzde<zzmg> {
    private static zzmh zza = new zzmh();
    private final zzde<zzmg> zzb;

    public static boolean zzb() {
        return ((zzmg) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzmg) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzmg) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzmg) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzmg) zza.zza()).zze();
    }

    private zzmh(zzde<zzmg> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmh() {
        this(zzdh.zza(new zzmj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzmg zza() {
        return this.zzb.zza();
    }
}
