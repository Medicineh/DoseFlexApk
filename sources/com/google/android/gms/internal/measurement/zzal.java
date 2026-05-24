package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzal extends zzac.zza {
    private final /* synthetic */ zzac zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzal(zzac zzacVar) {
        super(zzacVar);
        this.zzc = zzacVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzc.zzr.resetAnalyticsData(this.zza);
    }
}
