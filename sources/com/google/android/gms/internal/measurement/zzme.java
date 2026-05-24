package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzme implements zzmf {
    private static final zzcq<Boolean> zza = new zzcw(zzcr.zza("com.google.android.gms.measurement")).zza("measurement.config.string.always_update_disk_on_set", true);

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
