package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlg implements zzlh {
    private static final zzcq<Boolean> zza = new zzcw(zzcr.zza("com.google.android.gms.measurement")).zza("measurement.ga.ga_app_id", false);

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
