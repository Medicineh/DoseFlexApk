package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzir implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzin zzb;

    zzir(zzin zzinVar, zzm zzmVar) {
        this.zzb = zzinVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzb.zzb;
        if (zzelVar == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzelVar.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzak();
    }
}
