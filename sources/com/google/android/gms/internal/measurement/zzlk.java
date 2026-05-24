package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlk implements zzde<zzln> {
    private static zzlk zza = new zzlk();
    private final zzde<zzln> zzb;

    public static boolean zzb() {
        return ((zzln) zza.zza()).zza();
    }

    private zzlk(zzde<zzln> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzlk() {
        this(zzdh.zza(new zzlm()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzln zza() {
        return this.zzb.zza();
    }
}
