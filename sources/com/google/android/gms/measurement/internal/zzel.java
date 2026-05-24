package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public interface zzel extends IInterface {
    List<zzkn> zza(zzm zzmVar, boolean z) throws RemoteException;

    List<zzy> zza(String str, String str2, zzm zzmVar) throws RemoteException;

    List<zzy> zza(String str, String str2, String str3) throws RemoteException;

    List<zzkn> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzkn> zza(String str, String str2, boolean z, zzm zzmVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzaq zzaqVar, zzm zzmVar) throws RemoteException;

    void zza(zzaq zzaqVar, String str, String str2) throws RemoteException;

    void zza(zzkn zzknVar, zzm zzmVar) throws RemoteException;

    void zza(zzm zzmVar) throws RemoteException;

    void zza(zzy zzyVar) throws RemoteException;

    void zza(zzy zzyVar, zzm zzmVar) throws RemoteException;

    byte[] zza(zzaq zzaqVar, String str) throws RemoteException;

    void zzb(zzm zzmVar) throws RemoteException;

    String zzc(zzm zzmVar) throws RemoteException;

    void zzd(zzm zzmVar) throws RemoteException;
}
