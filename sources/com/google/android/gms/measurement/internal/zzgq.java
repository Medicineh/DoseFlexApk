package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgc zze;

    zzgq(zzgc zzgcVar, String str, String str2, String str3, long j) {
        this.zze = zzgcVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zzii) null);
        } else {
            this.zze.zza.zzs().zzv().zza(this.zzb, new zzii(this.zzc, this.zza, this.zzd));
        }
    }
}
