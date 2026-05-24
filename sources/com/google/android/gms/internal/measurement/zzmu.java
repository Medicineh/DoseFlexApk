package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmu implements zzde<zzmx> {
    private static zzmu zza = new zzmu();
    private final zzde<zzmx> zzb;

    public static boolean zzb() {
        return ((zzmx) zza.zza()).zza();
    }

    private zzmu(zzde<zzmx> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmu() {
        this(zzdh.zza(new zzmw()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzmx zza() {
        return this.zzb.zza();
    }
}
