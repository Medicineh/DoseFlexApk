package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzeo extends com.google.android.gms.internal.measurement.zzc implements zzel {
    public zzeo() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzaq) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzaq.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzkn) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzkn.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzaq) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzaq.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkn> listZza = zza((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR), com.google.android.gms.internal.measurement.zzb.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza);
                return true;
            case 9:
                byte[] bArrZza = zza((zzaq) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZza);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String strZzc = zzc((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strZzc);
                return true;
            case 12:
                zza((zzy) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzy.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zza((zzy) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkn> listZza2 = zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.zza(parcel), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza2);
                return true;
            case 15:
                List<zzkn> listZza3 = zza(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza3);
                return true;
            case 16:
                List<zzy> listZza4 = zza(parcel.readString(), parcel.readString(), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza4);
                return true;
            case 17:
                List<zzy> listZza5 = zza(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza5);
                return true;
            case 18:
                zzd((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
