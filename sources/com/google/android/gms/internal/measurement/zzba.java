package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzba extends zzac.zza {
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzac zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzba(zzac zzacVar, zzp zzpVar, int i) {
        super(zzacVar);
        this.zze = zzacVar;
        this.zzc = zzpVar;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zze.zzr.getTestFlag(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
