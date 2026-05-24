package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjj implements zzjg {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final long zzb() {
        return zzb.zzc().longValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.sdk.attribution.cache", true);
        zzb = zzcwVar.zza("measurement.sdk.attribution.cache.ttl", 604800000L);
    }
}
