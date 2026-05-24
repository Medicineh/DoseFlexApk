package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzip implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkn zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzin zzd;

    zzip(zzin zzinVar, boolean z, zzkn zzknVar, zzm zzmVar) {
        this.zzd = zzinVar;
        this.zza = z;
        this.zzb = zzknVar;
        this.zzc = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzd.zzb;
        if (zzelVar == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
        } else {
            this.zzd.zza(zzelVar, this.zza ? null : this.zzb, this.zzc);
            this.zzd.zzak();
        }
    }
}
