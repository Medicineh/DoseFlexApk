package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjn implements zzde<zzjm> {
    private static zzjn zza = new zzjn();
    private final zzde<zzjm> zzb;

    public static boolean zzb() {
        return ((zzjm) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjm) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzjm) zza.zza()).zzc();
    }

    private zzjn(zzde<zzjm> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzjn() {
        this(zzdh.zza(new zzjp()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzjm zza() {
        return this.zzb.zza();
    }
}
