package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziu implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzin zzc;

    zziu(zzin zzinVar, AtomicReference atomicReference, zzm zzmVar) {
        this.zzc = zzinVar;
        this.zza = atomicReference;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.zza) {
            try {
                try {
                    zzelVar = this.zzc.zzb;
                } catch (RemoteException e) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
                }
                if (zzelVar == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                    return;
                }
                this.zza.set(zzelVar.zzc(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzf().zza(str);
                    this.zzc.zzs().zzj.zza(str);
                }
                this.zzc.zzak();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
