package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkg implements zzde<zzkj> {
    private static zzkg zza = new zzkg();
    private final zzde<zzkj> zzb;

    public static boolean zzb() {
        return ((zzkj) zza.zza()).zza();
    }

    private zzkg(zzde<zzkj> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzkg() {
        this(zzdh.zza(new zzki()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzkj zza() {
        return this.zzb.zza();
    }
}
