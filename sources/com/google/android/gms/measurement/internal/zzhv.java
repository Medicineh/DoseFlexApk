package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhv implements Runnable {
    private final /* synthetic */ zzhc zza;

    zzhv(zzhc zzhcVar) {
        this.zza = zzhcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
