package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlq implements zzde<zzlt> {
    private static zzlq zza = new zzlq();
    private final zzde<zzlt> zzb;

    public static boolean zzb() {
        return ((zzlt) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlt) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlt) zza.zza()).zzc();
    }

    private zzlq(zzde<zzlt> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzlq() {
        this(zzdh.zza(new zzls()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzlt zza() {
        return this.zzb.zza();
    }
}
