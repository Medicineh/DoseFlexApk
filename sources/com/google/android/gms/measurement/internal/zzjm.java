package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjm implements Runnable {
    private final /* synthetic */ zzjf zza;

    zzjm(zzjf zzjfVar) {
        this.zza = zzjfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzin.zza(this.zza.zza, (zzel) null);
        this.zza.zza.zzan();
    }
}
