package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjg implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zze;
    private final /* synthetic */ zzin zzf;

    zzjg(zzin zzinVar, String str, String str2, boolean z, zzm zzmVar, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzf = zzinVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzmVar;
        this.zze = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzel zzelVar = this.zzf.zzb;
            if (zzelVar == null) {
                this.zzf.zzr().zzf().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Bundle bundleZza = zzko.zza(zzelVar.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzak();
            this.zzf.zzp().zza(this.zze, bundleZza);
        } catch (RemoteException e) {
            this.zzf.zzr().zzf().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzp().zza(this.zze, bundle);
        }
    }
}
