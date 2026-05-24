package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmn implements zzde<zzmm> {
    private static zzmn zza = new zzmn();
    private final zzde<zzmm> zzb;

    public static boolean zzb() {
        return ((zzmm) zza.zza()).zza();
    }

    private zzmn(zzde<zzmm> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmn() {
        this(zzdh.zza(new zzmp()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzmm zza() {
        return this.zzb.zza();
    }
}
