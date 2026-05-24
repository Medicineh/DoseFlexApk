package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzll implements zzli {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.client.global_params.dev", false);
        zzb = zzcwVar.zza("measurement.service.global_params", false);
    }
}
