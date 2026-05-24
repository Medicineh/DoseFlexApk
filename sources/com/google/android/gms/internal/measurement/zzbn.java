package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbn extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzp zzd;
    private final /* synthetic */ zzac.zzd zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbn(zzac.zzd zzdVar, Activity activity, zzp zzpVar) {
        super(zzac.this);
        this.zze = zzdVar;
        this.zzc = activity;
        this.zzd = zzpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        zzac.this.zzr.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
