package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjh implements zzde<zzjg> {
    private static zzjh zza = new zzjh();
    private final zzde<zzjg> zzb;

    public static boolean zzb() {
        return ((zzjg) zza.zza()).zza();
    }

    public static long zzc() {
        return ((zzjg) zza.zza()).zzb();
    }

    private zzjh(zzde<zzjg> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzjh() {
        this(zzdh.zza(new zzjj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzjg zza() {
        return this.zzb.zza();
    }
}
