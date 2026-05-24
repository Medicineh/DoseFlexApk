package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkb extends zzai {
    private final /* synthetic */ zzkg zza;
    private final /* synthetic */ zzkc zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkb(zzkc zzkcVar, zzgu zzguVar, zzkg zzkgVar) {
        super(zzguVar);
        this.zzb = zzkcVar;
        this.zza = zzkgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzai
    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
