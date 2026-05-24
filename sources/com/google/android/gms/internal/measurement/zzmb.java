package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmb implements zzde<zzma> {
    private static zzmb zza = new zzmb();
    private final zzde<zzma> zzb;

    public static boolean zzb() {
        return ((zzma) zza.zza()).zza();
    }

    private zzmb(zzde<zzma> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmb() {
        this(zzdh.zza(new zzmd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzma zza() {
        return this.zzb.zza();
    }
}
