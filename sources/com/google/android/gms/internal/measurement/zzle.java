package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzle implements zzde<zzlh> {
    private static zzle zza = new zzle();
    private final zzde<zzlh> zzb;

    public static boolean zzb() {
        return ((zzlh) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlh) zza.zza()).zzb();
    }

    private zzle(zzde<zzlh> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzle() {
        this(zzdh.zza(new zzlg()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzlh zza() {
        return this.zzb.zza();
    }
}
