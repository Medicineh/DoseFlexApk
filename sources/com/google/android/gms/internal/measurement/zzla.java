package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzla implements zzlb {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Long> zzc;

    @Override // com.google.android.gms.internal.measurement.zzlb
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzcwVar.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzcwVar.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }
}
