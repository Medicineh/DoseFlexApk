package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhw implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhc zzb;

    zzhw(zzhc zzhcVar, boolean z) {
        this.zzb = zzhcVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zZzab = this.zzb.zzz.zzab();
        boolean zZzaa = this.zzb.zzz.zzaa();
        this.zzb.zzz.zza(this.zza);
        if (zZzaa == this.zza) {
            this.zzb.zzz.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzz.zzab() == zZzab || this.zzb.zzz.zzab() != this.zzb.zzz.zzaa()) {
            this.zzb.zzz.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zZzab));
        }
        this.zzb.zzam();
    }
}
