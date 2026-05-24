package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbb extends zzac.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzha zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbb(zzac zzacVar, com.google.android.gms.measurement.internal.zzha zzhaVar) {
        super(zzacVar);
        this.zzd = zzacVar;
        this.zzc = zzhaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        for (int i = 0; i < this.zzd.zzf.size(); i++) {
            if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                Log.w(this.zzd.zzc, "OnEventListener already registered.");
                return;
            }
        }
        zzac.zzb zzbVar = new zzac.zzb(this.zzc);
        this.zzd.zzf.add(new Pair(this.zzc, zzbVar));
        this.zzd.zzr.registerOnMeasurementEventListener(zzbVar);
    }
}
