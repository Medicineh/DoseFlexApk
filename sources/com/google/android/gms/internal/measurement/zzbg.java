package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbg extends zzac.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbg(zzac zzacVar, Bundle bundle) {
        super(zzacVar);
        this.zzd = zzacVar;
        this.zzc = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzd.zzr.setConditionalUserProperty(this.zzc, this.zza);
    }
}
