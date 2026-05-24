package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmt implements zzde<zzms> {
    private static zzmt zza = new zzmt();
    private final zzde<zzms> zzb;

    public static boolean zzb() {
        return ((zzms) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzms) zza.zza()).zzb();
    }

    private zzmt(zzde<zzms> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmt() {
        this(zzdh.zza(new zzmv()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzms zza() {
        return this.zzb.zza();
    }
}
