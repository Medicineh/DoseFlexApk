package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzav extends zzac.zza {
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ zzac zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzav(zzac zzacVar, zzp zzpVar) {
        super(zzacVar);
        this.zzd = zzacVar;
        this.zzc = zzpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzd.zzr.getCurrentScreenClass(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
