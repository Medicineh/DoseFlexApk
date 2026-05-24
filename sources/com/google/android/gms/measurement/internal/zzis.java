package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzis implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzin zzd;

    zzis(zzin zzinVar, AtomicReference atomicReference, zzm zzmVar, boolean z) {
        this.zzd = zzinVar;
        this.zza = atomicReference;
        this.zzb = zzmVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.zza) {
            try {
                try {
                    zzelVar = this.zzd.zzb;
                } catch (RemoteException e) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; remote exception", e);
                }
                if (zzelVar == null) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                this.zza.set(zzelVar.zza(this.zzb, this.zzc));
                this.zzd.zzak();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
