package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzls implements zzlt {
    private static final zzcq<Long> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;
    private static final zzcq<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzcwVar.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzcwVar.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzcwVar.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzcwVar.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
