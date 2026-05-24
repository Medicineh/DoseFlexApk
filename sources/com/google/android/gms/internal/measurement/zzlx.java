package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlx implements zzlu {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzcwVar.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
    }
}
