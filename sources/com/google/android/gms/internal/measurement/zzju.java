package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzju implements zzde<zzjx> {
    private static zzju zza = new zzju();
    private final zzde<zzjx> zzb;

    public static boolean zzb() {
        return ((zzjx) zza.zza()).zza();
    }

    private zzju(zzde<zzjx> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzju() {
        this(zzdh.zza(new zzjw()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzjx zza() {
        return this.zzb.zza();
    }
}
