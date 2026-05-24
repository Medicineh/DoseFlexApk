package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzao extends zzac.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzgx zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzao(zzac zzacVar, com.google.android.gms.measurement.internal.zzgx zzgxVar) {
        super(zzacVar);
        this.zzd = zzacVar;
        this.zzc = zzgxVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzd.zzr.setEventInterceptor(new zzac.zzc(this.zzc));
    }
}
