package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzt extends zza implements zzr {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void initialize(IObjectWrapper iObjectWrapper, zzaa zzaaVar, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        zzb.zza(parcelA_, zzaaVar);
        parcelA_.writeLong(j);
        zzb(1, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb.zza(parcelA_, bundle);
        zzb.zza(parcelA_, z);
        zzb.zza(parcelA_, z2);
        parcelA_.writeLong(j);
        zzb(2, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzsVar, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb.zza(parcelA_, bundle);
        zzb.zza(parcelA_, zzsVar);
        parcelA_.writeLong(j);
        zzb(3, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb.zza(parcelA_, iObjectWrapper);
        zzb.zza(parcelA_, z);
        parcelA_.writeLong(j);
        zzb(4, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb.zza(parcelA_, z);
        zzb.zza(parcelA_, zzsVar);
        zzb(5, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        zzb.zza(parcelA_, zzsVar);
        zzb(6, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeLong(j);
        zzb(7, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, bundle);
        parcelA_.writeLong(j);
        zzb(8, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb.zza(parcelA_, bundle);
        zzb(9, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzb.zza(parcelA_, zzsVar);
        zzb(10, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, z);
        parcelA_.writeLong(j);
        zzb(11, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeLong(j);
        zzb(12, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeLong(j);
        zzb(13, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeLong(j);
        zzb(14, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        parcelA_.writeLong(j);
        zzb(15, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getCurrentScreenName(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(16, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getCurrentScreenClass(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(17, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setInstanceIdProvider(zzy zzyVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzyVar);
        zzb(18, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getCachedAppInstanceId(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(19, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getAppInstanceId(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(20, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getGmpAppId(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(21, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void generateEventId(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(22, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeLong(j);
        zzb(23, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeLong(j);
        zzb(24, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        parcelA_.writeLong(j);
        zzb(25, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        parcelA_.writeLong(j);
        zzb(26, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        zzb.zza(parcelA_, bundle);
        parcelA_.writeLong(j);
        zzb(27, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        parcelA_.writeLong(j);
        zzb(28, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        parcelA_.writeLong(j);
        zzb(29, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        parcelA_.writeLong(j);
        zzb(30, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzsVar, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, iObjectWrapper);
        zzb.zza(parcelA_, zzsVar);
        parcelA_.writeLong(j);
        zzb(31, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void performAction(Bundle bundle, zzs zzsVar, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, bundle);
        zzb.zza(parcelA_, zzsVar);
        parcelA_.writeLong(j);
        zzb(32, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeInt(i);
        parcelA_.writeString(str);
        zzb.zza(parcelA_, iObjectWrapper);
        zzb.zza(parcelA_, iObjectWrapper2);
        zzb.zza(parcelA_, iObjectWrapper3);
        zzb(33, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setEventInterceptor(zzx zzxVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzxVar);
        zzb(34, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void registerOnMeasurementEventListener(zzx zzxVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzxVar);
        zzb(35, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void unregisterOnMeasurementEventListener(zzx zzxVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzxVar);
        zzb(36, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void initForTests(Map map) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeMap(map);
        zzb(37, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getTestFlag(zzs zzsVar, int i) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        parcelA_.writeInt(i);
        zzb(38, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, z);
        zzb(39, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void isDataCollectionEnabled(zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, zzsVar);
        zzb(40, parcelA_);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel parcelA_ = a_();
        zzb.zza(parcelA_, bundle);
        zzb(42, parcelA_);
    }
}
