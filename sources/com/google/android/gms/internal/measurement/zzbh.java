package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbh extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ Bundle zzd;
    private final /* synthetic */ zzac.zzd zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbh(zzac.zzd zzdVar, Activity activity, Bundle bundle) {
        super(zzac.this);
        this.zze = zzdVar;
        this.zzc = activity;
        this.zzd = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        zzac.this.zzr.onActivityCreated(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
