package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkh implements zzke {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzcwVar.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzcwVar.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzcwVar.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
