package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzja implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzin zzb;

    zzja(zzin zzinVar, zzm zzmVar) {
        this.zzb = zzinVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzb.zzb;
        if (zzelVar == null) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzelVar.zzb(this.zza);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
