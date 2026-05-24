package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzij implements Runnable {
    private final /* synthetic */ zzih zza;

    zzij(zzih zzihVar) {
        this.zza = zzihVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar = this.zza;
        zzihVar.zza = zzihVar.zzg;
    }
}
