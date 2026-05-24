package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzka implements zzde<zzkd> {
    private static zzka zza = new zzka();
    private final zzde<zzkd> zzb;

    public static boolean zzb() {
        return ((zzkd) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkd) zza.zza()).zzb();
    }

    private zzka(zzde<zzkd> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzka() {
        this(zzdh.zza(new zzkc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkd zza() {
        return this.zzb.zza();
    }
}
