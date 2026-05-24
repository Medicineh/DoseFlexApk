package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkx implements zzde<zzkw> {
    private static zzkx zza = new zzkx();
    private final zzde<zzkw> zzb;

    public static boolean zzb() {
        return ((zzkw) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkw) zza.zza()).zzb();
    }

    private zzkx(zzde<zzkw> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzkx() {
        this(zzdh.zza(new zzkz()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkw zza() {
        return this.zzb.zza();
    }
}
