package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjo implements zzde<zzjr> {
    private static zzjo zza = new zzjo();
    private final zzde<zzjr> zzb;

    public static boolean zzb() {
        return ((zzjr) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjr) zza.zza()).zzb();
    }

    private zzjo(zzde<zzjr> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzjo() {
        this(zzdh.zza(new zzjq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzjr zza() {
        return this.zzb.zza();
    }
}
