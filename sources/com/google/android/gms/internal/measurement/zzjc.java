package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjc implements zzde<zzjf> {
    private static zzjc zza = new zzjc();
    private final zzde<zzjf> zzb;

    public static boolean zzb() {
        return ((zzjf) zza.zza()).zza();
    }

    private zzjc(zzde<zzjf> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzjc() {
        this(zzdh.zza(new zzje()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzjf zza() {
        return this.zzb.zza();
    }
}
