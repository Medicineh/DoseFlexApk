package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzng implements zzde<zznj> {
    private static zzng zza = new zzng();
    private final zzde<zznj> zzb;

    public static boolean zzb() {
        return ((zznj) zza.zza()).zza();
    }

    private zzng(zzde<zznj> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzng() {
        this(zzdh.zza(new zzni()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zznj zza() {
        return this.zzb.zza();
    }
}
