package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzbe extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzac zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbe(zzac zzacVar, String str, String str2, Object obj, boolean z) {
        super(zzacVar);
        this.zzg = zzacVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = obj;
        this.zzf = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzg.zzr.setUserProperty(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), this.zzf, this.zza);
    }
}
