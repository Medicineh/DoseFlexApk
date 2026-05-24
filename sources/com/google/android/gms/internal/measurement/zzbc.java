package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbc extends zzac.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzha zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbc(zzac zzacVar, com.google.android.gms.measurement.internal.zzha zzhaVar) {
        super(zzacVar);
        this.zzd = zzacVar;
        this.zzc = zzhaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else {
                if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                    pair = (Pair) this.zzd.zzf.get(i);
                    break;
                }
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.zzd.zzc, "OnEventListener had not been registered.");
        } else {
            this.zzd.zzr.unregisterOnMeasurementEventListener((zzx) pair.second);
            this.zzd.zzf.remove(pair);
        }
    }
}
