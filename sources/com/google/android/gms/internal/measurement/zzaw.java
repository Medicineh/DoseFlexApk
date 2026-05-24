package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzaw extends zzac.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzp zzd;
    private final /* synthetic */ zzac zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaw(zzac zzacVar, Bundle bundle, zzp zzpVar) {
        super(zzacVar);
        this.zze = zzacVar;
        this.zzc = bundle;
        this.zzd = zzpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zze.zzr.performAction(this.zzc, this.zzd, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    protected final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
