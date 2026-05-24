package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzio implements Runnable {
    private final /* synthetic */ zzih zza;

    zzio(zzih zzihVar) {
        this.zza = zzihVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih.zza(this.zza, (zzii) null);
    }
}
