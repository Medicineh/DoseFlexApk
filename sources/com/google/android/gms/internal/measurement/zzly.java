package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzly implements zzlz {
    private static final zzcq<Long> zza;
    private static final zzcq<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final long zza() {
        return zzb.zzc().longValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.id.max_bundles_per_iteration", 0L);
        zzb = zzcwVar.zza("measurement.max_bundles_per_iteration", 2L);
    }
}
