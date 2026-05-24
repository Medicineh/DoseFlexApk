package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbj extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzac.zzd zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbj(zzac.zzd zzdVar, Activity activity) {
        super(zzac.this);
        this.zzd = zzdVar;
        this.zzc = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        zzac.this.zzr.onActivityStarted(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
