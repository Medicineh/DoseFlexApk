package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzit implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zzb;
    private final /* synthetic */ zzin zzc;

    zzit(zzin zzinVar, zzm zzmVar, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzc = zzinVar;
        this.zza = zzmVar;
        this.zzb = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzel zzelVar = this.zzc.zzb;
            if (zzelVar == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String strZzc = zzelVar.zzc(this.zza);
            if (strZzc != null) {
                this.zzc.zzf().zza(strZzc);
                this.zzc.zzs().zzj.zza(strZzc);
            }
            this.zzc.zzak();
            this.zzc.zzp().zza(this.zzb, strZzc);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}
