package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziv implements Runnable {
    private final /* synthetic */ zzii zza;
    private final /* synthetic */ zzin zzb;

    zziv(zzin zzinVar, zzii zziiVar) {
        this.zzb = zzinVar;
        this.zza = zziiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzb.zzb;
        if (zzelVar == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzelVar.zza(0L, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzelVar.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
