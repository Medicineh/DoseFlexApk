package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzq extends zzc implements zzr {
    public zzq() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzr asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (iInterfaceQueryLocalInterface instanceof zzr) {
            return (zzr) iInterfaceQueryLocalInterface;
        }
        return new zzt(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzs zzuVar;
        zzs zzsVar;
        zzs zzuVar2 = null;
        zzs zzuVar3 = null;
        zzs zzuVar4 = null;
        zzx zzzVar = null;
        zzx zzzVar2 = null;
        zzx zzzVar3 = null;
        zzs zzuVar5 = null;
        zzs zzuVar6 = null;
        zzs zzuVar7 = null;
        zzs zzuVar8 = null;
        zzs zzuVar9 = null;
        zzs zzuVar10 = null;
        zzy zzabVar = null;
        zzs zzuVar11 = null;
        zzs zzuVar12 = null;
        zzs zzuVar13 = null;
        zzs zzuVar14 = null;
        switch (i) {
            case 1:
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzaa) zzb.zza(parcel, zzaa.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzb.zza(parcel, Bundle.CREATOR), zzb.zza(parcel), zzb.zza(parcel), parcel.readLong());
                break;
            case 3:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) zzb.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzsVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface instanceof zzs) {
                        zzuVar = (zzs) iInterfaceQueryLocalInterface;
                    } else {
                        zzuVar = new zzu(strongBinder);
                    }
                    zzsVar = zzuVar;
                }
                logEventAndBundle(string, string2, bundle, zzsVar, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzb.zza(parcel), parcel.readLong());
                break;
            case 5:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                boolean zZza = zzb.zza(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface2 instanceof zzs) {
                        zzuVar2 = (zzs) iInterfaceQueryLocalInterface2;
                    } else {
                        zzuVar2 = new zzu(strongBinder2);
                    }
                }
                getUserProperties(string3, string4, zZza, zzuVar2);
                break;
            case 6:
                String string5 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface3 instanceof zzs) {
                        zzuVar14 = (zzs) iInterfaceQueryLocalInterface3;
                    } else {
                        zzuVar14 = new zzu(strongBinder3);
                    }
                }
                getMaxUserProperties(string5, zzuVar14);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) zzb.zza(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzb.zza(parcel, Bundle.CREATOR));
                break;
            case 10:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface4 instanceof zzs) {
                        zzuVar13 = (zzs) iInterfaceQueryLocalInterface4;
                    } else {
                        zzuVar13 = new zzu(strongBinder4);
                    }
                }
                getConditionalUserProperties(string6, string7, zzuVar13);
                break;
            case 11:
                setMeasurementEnabled(zzb.zza(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface5 instanceof zzs) {
                        zzuVar12 = (zzs) iInterfaceQueryLocalInterface5;
                    } else {
                        zzuVar12 = new zzu(strongBinder5);
                    }
                }
                getCurrentScreenName(zzuVar12);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface6 instanceof zzs) {
                        zzuVar11 = (zzs) iInterfaceQueryLocalInterface6;
                    } else {
                        zzuVar11 = new zzu(strongBinder6);
                    }
                }
                getCurrentScreenClass(zzuVar11);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (iInterfaceQueryLocalInterface7 instanceof zzy) {
                        zzabVar = (zzy) iInterfaceQueryLocalInterface7;
                    } else {
                        zzabVar = new zzab(strongBinder7);
                    }
                }
                setInstanceIdProvider(zzabVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface8 instanceof zzs) {
                        zzuVar10 = (zzs) iInterfaceQueryLocalInterface8;
                    } else {
                        zzuVar10 = new zzu(strongBinder8);
                    }
                }
                getCachedAppInstanceId(zzuVar10);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface9 instanceof zzs) {
                        zzuVar9 = (zzs) iInterfaceQueryLocalInterface9;
                    } else {
                        zzuVar9 = new zzu(strongBinder9);
                    }
                }
                getAppInstanceId(zzuVar9);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface10 instanceof zzs) {
                        zzuVar8 = (zzs) iInterfaceQueryLocalInterface10;
                    } else {
                        zzuVar8 = new zzu(strongBinder10);
                    }
                }
                getGmpAppId(zzuVar8);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface11 instanceof zzs) {
                        zzuVar7 = (zzs) iInterfaceQueryLocalInterface11;
                    } else {
                        zzuVar7 = new zzu(strongBinder11);
                    }
                }
                generateEventId(zzuVar7);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) zzb.zza(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface12 instanceof zzs) {
                        zzuVar6 = (zzs) iInterfaceQueryLocalInterface12;
                    } else {
                        zzuVar6 = new zzu(strongBinder12);
                    }
                }
                onActivitySaveInstanceState(iObjectWrapperAsInterface, zzuVar6, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzb.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface13 instanceof zzs) {
                        zzuVar5 = (zzs) iInterfaceQueryLocalInterface13;
                    } else {
                        zzuVar5 = new zzu(strongBinder13);
                    }
                }
                performAction(bundle2, zzuVar5, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface14 instanceof zzx) {
                        zzzVar3 = (zzx) iInterfaceQueryLocalInterface14;
                    } else {
                        zzzVar3 = new zzz(strongBinder14);
                    }
                }
                setEventInterceptor(zzzVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface15 instanceof zzx) {
                        zzzVar2 = (zzx) iInterfaceQueryLocalInterface15;
                    } else {
                        zzzVar2 = new zzz(strongBinder15);
                    }
                }
                registerOnMeasurementEventListener(zzzVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface16 instanceof zzx) {
                        zzzVar = (zzx) iInterfaceQueryLocalInterface16;
                    } else {
                        zzzVar = new zzz(strongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(zzzVar);
                break;
            case 37:
                initForTests(zzb.zzb(parcel));
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface17 instanceof zzs) {
                        zzuVar4 = (zzs) iInterfaceQueryLocalInterface17;
                    } else {
                        zzuVar4 = new zzu(strongBinder17);
                    }
                }
                getTestFlag(zzuVar4, parcel.readInt());
                break;
            case 39:
                setDataCollectionEnabled(zzb.zza(parcel));
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface18 instanceof zzs) {
                        zzuVar3 = (zzs) iInterfaceQueryLocalInterface18;
                    } else {
                        zzuVar3 = new zzu(strongBinder18);
                    }
                }
                isDataCollectionEnabled(zzuVar3);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) zzb.zza(parcel, Bundle.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
