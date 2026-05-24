package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzen extends com.google.android.gms.internal.measurement.zza implements zzel {
    zzen(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzaq zzaqVar, zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzaqVar);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        zzb(1, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzkn zzknVar, zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzknVar);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        zzb(2, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        zzb(4, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzaq zzaqVar, String str, String str2) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzaqVar);
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb(5, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zzb(zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        zzb(6, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkn> zza(zzm zzmVar, boolean z) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, z);
        Parcel parcelZza = zza(7, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzkn.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final byte[] zza(zzaq zzaqVar, String str) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzaqVar);
        parcelA_.writeString(str);
        Parcel parcelZza = zza(9, parcelA_);
        byte[] bArrCreateByteArray = parcelZza.createByteArray();
        parcelZza.recycle();
        return bArrCreateByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeLong(j);
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeString(str3);
        zzb(10, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final String zzc(zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        Parcel parcelZza = zza(11, parcelA_);
        String string = parcelZza.readString();
        parcelZza.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzy zzyVar, zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzyVar);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        zzb(12, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzy zzyVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzyVar);
        zzb(13, parcelA_);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkn> zza(String str, String str2, boolean z, zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, z);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        Parcel parcelZza = zza(14, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzkn.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkn> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeString(str3);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, z);
        Parcel parcelZza = zza(15, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzkn.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzy> zza(String str, String str2, zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        Parcel parcelZza = zza(16, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzy.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzy> zza(String str, String str2, String str3) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeString(str3);
        Parcel parcelZza = zza(17, parcelA_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzy.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zzd(zzm zzmVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.measurement.zzb.zza(parcelA_, zzmVar);
        zzb(18, parcelA_);
    }
}
