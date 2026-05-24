package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzky implements zzde<zzlb> {
    private static zzky zza = new zzky();
    private final zzde<zzlb> zzb;

    public static boolean zzb() {
        return ((zzlb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlb) zza.zza()).zzb();
    }

    private zzky(zzde<zzlb> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzky() {
        this(zzdh.zza(new zzla()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzlb zza() {
        return this.zzb.zza();
    }
}
