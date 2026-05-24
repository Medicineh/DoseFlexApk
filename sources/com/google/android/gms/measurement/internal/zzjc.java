package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjc implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzy zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzy zze;
    private final /* synthetic */ zzin zzf;

    zzjc(zzin zzinVar, boolean z, boolean z2, zzy zzyVar, zzm zzmVar, zzy zzyVar2) {
        this.zzf = zzinVar;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzyVar;
        this.zzd = zzmVar;
        this.zze = zzyVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzf.zzb;
        if (zzelVar == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzelVar, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzelVar.zza(this.zzc, this.zzd);
                } else {
                    zzelVar.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzak();
    }
}
