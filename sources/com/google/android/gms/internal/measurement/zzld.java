package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzld implements zzde<zzlc> {
    private static zzld zza = new zzld();
    private final zzde<zzlc> zzb;

    public static boolean zzb() {
        return ((zzlc) zza.zza()).zza();
    }

    private zzld(zzde<zzlc> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzld() {
        this(zzdh.zza(new zzlf()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzlc zza() {
        return this.zzb.zza();
    }
}
