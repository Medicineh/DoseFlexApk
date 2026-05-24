package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkc implements zzkd {
    private static final zzcq<Boolean> zza = new zzcw(zzcr.zza("com.google.android.gms.measurement")).zza("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
