package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjb implements zzde<zzja> {
    private static zzjb zza = new zzjb();
    private final zzde<zzja> zzb;

    public static boolean zzb() {
        return ((zzja) zza.zza()).zza();
    }

    private zzjb(zzde<zzja> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzjb() {
        this(zzdh.zza(new zzjd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzja zza() {
        return this.zzb.zza();
    }
}
