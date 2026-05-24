package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmj implements zzmg {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Double> zzb;
    private static final zzcq<Long> zzc;
    private static final zzcq<Long> zzd;
    private static final zzcq<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final long zzc() {
        return zzc.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final long zzd() {
        return zzd.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final String zze() {
        return zze.zzc();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.test.boolean_flag", false);
        zzb = zzcwVar.zza("measurement.test.double_flag", -3.0d);
        zzc = zzcwVar.zza("measurement.test.int_flag", -2L);
        zzd = zzcwVar.zza("measurement.test.long_flag", -1L);
        zze = zzcwVar.zza("measurement.test.string_flag", "---");
    }
}
