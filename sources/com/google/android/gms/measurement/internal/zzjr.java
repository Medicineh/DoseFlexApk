package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjr implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjs zzb;

    zzjr(zzjs zzjsVar, long j) {
        this.zzb = zzjsVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
