package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkn implements zzkk {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzkk
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkk
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzcwVar.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }
}
