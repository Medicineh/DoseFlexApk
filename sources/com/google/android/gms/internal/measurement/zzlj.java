package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlj implements zzde<zzli> {
    private static zzlj zza = new zzlj();
    private final zzde<zzli> zzb;

    public static boolean zzb() {
        return ((zzli) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzli) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzli) zza.zza()).zzc();
    }

    private zzlj(zzde<zzli> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzlj() {
        this(zzdh.zza(new zzll()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzli zza() {
        return this.zzb.zza();
    }
}
