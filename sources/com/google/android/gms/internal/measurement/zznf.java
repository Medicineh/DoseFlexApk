package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zznf implements zzde<zzne> {
    private static zznf zza = new zznf();
    private final zzde<zzne> zzb;

    public static boolean zzb() {
        return ((zzne) zza.zza()).zza();
    }

    private zznf(zzde<zzne> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zznf() {
        this(zzdh.zza(new zznh()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzne zza() {
        return this.zzb.zza();
    }
}
