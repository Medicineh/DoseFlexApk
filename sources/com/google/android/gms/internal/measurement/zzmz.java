package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmz implements zzde<zzmy> {
    private static zzmz zza = new zzmz();
    private final zzde<zzmy> zzb;

    public static boolean zzb() {
        return ((zzmy) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmy) zza.zza()).zzb();
    }

    private zzmz(zzde<zzmy> zzdeVar) {
        this.zzb = zzdh.zza((zzde) zzdeVar);
    }

    public zzmz() {
        this(zzdh.zza(new zznb()));
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final /* synthetic */ zzmy zza() {
        return this.zzb.zza();
    }
}
