package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzku implements zzkv {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;

    @Override // com.google.android.gms.internal.measurement.zzkv
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkv
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzcwVar.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzcwVar.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }
}
