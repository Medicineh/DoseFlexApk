package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzix extends zzai {
    private final /* synthetic */ zzin zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzix(zzin zzinVar, zzgu zzguVar) {
        super(zzguVar);
        this.zza = zzinVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzai
    public final void zza() {
        this.zza.zzr().zzi().zza("Tasks have been queued for a long time");
    }
}
