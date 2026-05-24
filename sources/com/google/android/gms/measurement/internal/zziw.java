package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziw implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzin zzb;

    zziw(zzin zzinVar, zzm zzmVar) {
        this.zzb = zzinVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzb.zzb;
        if (zzelVar == null) {
            this.zzb.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzelVar.zza(this.zza);
            this.zzb.zzj().zzad();
            this.zzb.zza(zzelVar, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send app launch to the service", e);
        }
    }
}
