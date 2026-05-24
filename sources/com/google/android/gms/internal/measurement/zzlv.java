package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlv implements zzde<zzlu> {
    private static zzlv zza = new zzlv();
    private final zzde<zzlu> zzb;

    public static boolean zzb() {
        return ((zzlu) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlu) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlu) zza.zza()).zzc();
    }

    private zzlv(zzde<zzlu> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzlv() {
        this(zzdh.zza(new zzlx()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzlu zza() {
        return this.zzb.zza();
    }
}
