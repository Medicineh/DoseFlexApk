package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzu extends zza implements zzs {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void zza(Bundle bundle) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, bundle);
        zzb(1, parcelA_);
    }
}
