package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziz implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzaq zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzin zzf;

    zziz(zzin zzinVar, boolean z, boolean z2, zzaq zzaqVar, zzm zzmVar, String str) {
        this.zzf = zzinVar;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzaqVar;
        this.zzd = zzmVar;
        this.zze = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.zzf.zzb;
        if (zzelVar == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzelVar, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzelVar.zza(this.zzc, this.zzd);
                } else {
                    zzelVar.zza(this.zzc, this.zze, this.zzf.zzr().zzy());
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzak();
    }
}
