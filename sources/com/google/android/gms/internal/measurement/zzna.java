package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzna implements zzde<zznd> {
    private static zzna zza = new zzna();
    private final zzde<zznd> zzb;

    public static boolean zzb() {
        return ((zznd) zza.zza()).zza();
    }

    private zzna(zzde<zznd> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzna() {
        this(zzdh.zza(new zznc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zznd zza() {
        return this.zzb.zza();
    }
}
