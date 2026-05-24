package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzlj;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzq {
    zzfx zza = null;
    private Map<Integer, zzha> zzb = new ArrayMap();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    class zza implements zzgx {
        private com.google.android.gms.internal.measurement.zzx zza;

        zza(com.google.android.gms.internal.measurement.zzx zzxVar) {
            this.zza = zzxVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgx
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    class zzb implements zzha {
        private com.google.android.gms.internal.measurement.zzx zza;

        zzb(com.google.android.gms.internal.measurement.zzx zzxVar) {
            this.zza = zzxVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzha
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzaa zzaaVar, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfx zzfxVar = this.zza;
        if (zzfxVar == null) {
            this.zza = zzfx.zza(context, zzaaVar, Long.valueOf(j));
        } else {
            zzfxVar.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzd(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzb(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzsVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        zza(zzsVar, this.zza.zzh().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        zza(zzsVar, this.zza.zzh().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        zza(zzsVar, this.zza.zzh().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzi(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        zza(zzsVar, this.zza.zzh().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void generateEventId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzsVar, this.zza.zzi().zzg());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzs zzsVar, long j) throws RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzq().zza(new zzh(this, zzsVar, new zzaq(str2, new zzal(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzs zzsVar, long j) throws RemoteException {
        zza();
        zzhx zzhxVar = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzhxVar != null) {
            this.zza.zzh().zzab();
            zzhxVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzsVar.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzs zzsVar, long j) throws RemoteException {
        zza();
        zzsVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzk(this, zzsVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzr().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzx zzxVar) throws RemoteException {
        zza();
        zzhc zzhcVarZzh = this.zza.zzh();
        zza zzaVar = new zza(zzxVar);
        zzhcVarZzh.zzb();
        zzhcVarZzh.zzw();
        zzhcVarZzh.zzq().zza(new zzhm(zzhcVarZzh, zzaVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzx zzxVar) throws RemoteException {
        zza();
        zzha zzbVar = this.zzb.get(Integer.valueOf(zzxVar.zza()));
        if (zzbVar == null) {
            zzbVar = new zzb(zzxVar);
            this.zzb.put(Integer.valueOf(zzxVar.zza()), zzbVar);
        }
        this.zza.zzh().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzx zzxVar) throws RemoteException {
        zza();
        zzha zzhaVarRemove = this.zzb.remove(Integer.valueOf(zzxVar.zza()));
        if (zzhaVarRemove == null) {
            zzhaVarRemove = new zzb(zzxVar);
        }
        this.zza.zzh().zzb(zzhaVarRemove);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzy zzyVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzj(this, zzsVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getTestFlag(com.google.android.gms.internal.measurement.zzs zzsVar, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzsVar, this.zza.zzh().zzad());
            return;
        }
        if (i == 1) {
            this.zza.zzi().zza(zzsVar, this.zza.zzh().zzae().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzi().zza(zzsVar, this.zza.zzh().zzaf().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzi().zza(zzsVar, this.zza.zzh().zzac().booleanValue());
                return;
            }
        }
        zzko zzkoVarZzi = this.zza.zzi();
        double dDoubleValue = this.zza.zzh().zzag().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzsVar.zza(bundle);
        } catch (RemoteException e) {
            zzkoVarZzi.zzz.zzr().zzi().zza("Error returning double value to wrapper", e);
        }
    }

    private final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str) {
        this.zza.zzi().zza(zzsVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.zza.zzh().zzb(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzl(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        final zzhc zzhcVarZzh = this.zza.zzh();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzhcVarZzh.zzq().zza(new Runnable(zzhcVarZzh, bundle2) { // from class: com.google.android.gms.measurement.internal.zzhb
            private final zzhc zza;
            private final Bundle zzb;

            {
                this.zza = zzhcVarZzh;
                this.zzb = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzhc zzhcVar = this.zza;
                Bundle bundle3 = this.zzb;
                if (zzlj.zzb() && zzhcVar.zzt().zza(zzas.zzcn)) {
                    if (bundle3 == null) {
                        zzhcVar.zzs().zzy.zza(new Bundle());
                        return;
                    }
                    Bundle bundleZza = zzhcVar.zzs().zzy.zza();
                    for (String str : bundle3.keySet()) {
                        Object obj = bundle3.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            zzhcVar.zzp();
                            if (zzko.zza(obj)) {
                                zzhcVar.zzp().zza(27, (String) null, (String) null, 0);
                            }
                            zzhcVar.zzr().zzk().zza("Invalid default event parameter type. Name, value", str, obj);
                        } else if (zzko.zze(str)) {
                            zzhcVar.zzr().zzk().zza("Invalid default event parameter name. Name", str);
                        } else if (obj == null) {
                            bundleZza.remove(str);
                        } else if (zzhcVar.zzp().zza("param", str, 100, obj)) {
                            zzhcVar.zzp().zza(bundleZza, str, obj);
                        }
                    }
                    zzhcVar.zzp();
                    if (zzko.zza(bundleZza, zzhcVar.zzt().zze())) {
                        zzhcVar.zzp().zza(26, (String) null, (String) null, 0);
                        zzhcVar.zzr().zzk().zza("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                    zzhcVar.zzs().zzy.zza(bundleZza);
                }
            }
        });
    }
}
