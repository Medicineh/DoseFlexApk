package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziy implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zzc;
    private final /* synthetic */ zzin zzd;

    zziy(zzin zzinVar, zzaq zzaqVar, String str, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzd = zzinVar;
        this.zza = zzaqVar;
        this.zzb = str;
        this.zzc = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzel zzelVar = this.zzd.zzb;
            if (zzelVar == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] bArrZza = zzelVar.zza(this.zza, this.zzb);
            this.zzd.zzak();
            this.zzd.zzp().zza(this.zzc, bArrZza);
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzp().zza(this.zzc, (byte[]) null);
        }
    }
}
