package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjv implements zzjs {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Long> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;
    private static final zzcq<Boolean> zze;
    private static final zzcq<Boolean> zzf;
    private static final zzcq<Boolean> zzg;

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zze() {
        return zze.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zzf() {
        return zzf.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final boolean zzg() {
        return zzg.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.gold.enhanced_ecommerce.format_logs", false);
        zzb = zzcwVar.zza("measurement.id.gold.enhanced_ecommerce.service", 0L);
        zzc = zzcwVar.zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        zzd = zzcwVar.zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        zze = zzcwVar.zza("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        zzf = zzcwVar.zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        zzg = zzcwVar.zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }
}
