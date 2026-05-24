package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzaj extends zzac.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzac zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaj(zzac zzacVar, Activity activity, String str, String str2) {
        super(zzacVar);
        this.zzf = zzacVar;
        this.zzc = activity;
        this.zzd = str;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzf.zzr.setCurrentScreen(ObjectWrapper.wrap(this.zzc), this.zzd, this.zze, this.zza);
    }
}
