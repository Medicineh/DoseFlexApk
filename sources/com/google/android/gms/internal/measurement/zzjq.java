package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjq implements zzjr {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Long> zzd;

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.sdk.dynamite.allow_remote_dynamite", false);
        zzb = zzcwVar.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzcwVar.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzcwVar.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }
}
