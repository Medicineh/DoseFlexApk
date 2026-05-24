package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzje implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzs zzd;
    private final /* synthetic */ zzin zze;

    zzje(zzin zzinVar, String str, String str2, zzm zzmVar, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zze = zzinVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzmVar;
        this.zzd = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzel zzelVar = this.zze.zzb;
            if (zzelVar == null) {
                this.zze.zzr().zzf().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            ArrayList<Bundle> arrayListZzb = zzko.zzb(zzelVar.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzak();
            this.zze.zzp().zza(this.zzd, arrayListZzb);
        } catch (RemoteException e) {
            this.zze.zzr().zzf().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzp().zza(this.zzd, arrayList);
        }
    }
}
