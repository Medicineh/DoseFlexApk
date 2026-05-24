package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzax extends zzac.zza {
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzac zzh;
    private final /* synthetic */ int zzc = 5;
    private final /* synthetic */ Object zzf = null;
    private final /* synthetic */ Object zzg = null;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzax(zzac zzacVar, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.zzh = zzacVar;
        this.zzd = str;
        this.zze = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzh.zzr.logHealthData(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), ObjectWrapper.wrap(this.zzf), ObjectWrapper.wrap(this.zzg));
    }
}
