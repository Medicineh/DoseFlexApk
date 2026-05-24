package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjd implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzm zzf;
    private final /* synthetic */ zzin zzg;

    zzjd(zzin zzinVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzmVar) {
        this.zzg = zzinVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.zza) {
            try {
                try {
                    zzelVar = this.zzg.zzb;
                } catch (RemoteException e) {
                    this.zzg.zzr().zzf().zza("(legacy) Failed to get user properties; remote exception", zzet.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                }
                if (zzelVar == null) {
                    this.zzg.zzr().zzf().zza("(legacy) Failed to get user properties; not connected to service", zzet.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    this.zza.set(zzelVar.zza(this.zzc, this.zzd, this.zze, this.zzf));
                } else {
                    this.zza.set(zzelVar.zza(this.zzb, this.zzc, this.zzd, this.zze));
                }
                this.zzg.zzak();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
