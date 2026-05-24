package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlw implements zzde<zzlz> {
    private static zzlw zza = new zzlw();
    private final zzde<zzlz> zzb;

    public static long zzb() {
        return ((zzlz) zza.zza()).zza();
    }

    private zzlw(zzde<zzlz> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzlw() {
        this(zzdh.zza(new zzly()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzlz zza() {
        return this.zzb.zza();
    }
}
