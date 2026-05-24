package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjd implements zzja {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzja
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.androidId.delete_feature", true);
        zzb = zzcwVar.zza("measurement.log_androidId_enabled", false);
    }
}
