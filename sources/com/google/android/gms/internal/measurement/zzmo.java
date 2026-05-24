package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmo implements zzde<zzmr> {
    private static zzmo zza = new zzmo();
    private final zzde<zzmr> zzb;

    public static boolean zzb() {
        return ((zzmr) zza.zza()).zza();
    }

    private zzmo(zzde<zzmr> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmo() {
        this(zzdh.zza(new zzmq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzmr zza() {
        return this.zzb.zza();
    }
}
