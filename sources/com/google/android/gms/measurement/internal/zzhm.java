package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhm implements Runnable {
    private final /* synthetic */ zzgx zza;
    private final /* synthetic */ zzhc zzb;

    zzhm(zzhc zzhcVar, zzgx zzgxVar) {
        this.zzb = zzhcVar;
        this.zza = zzgxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
