package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzer extends zzgr {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    zzer(zzfx zzfxVar) {
        super(zzfxVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    protected final boolean zze() {
        return false;
    }

    private final boolean zzg() {
        zzu();
        return this.zzz.zzl() && this.zzz.zzr().zza(3);
    }

    protected final String zza(String str) {
        if (str == null) {
            return null;
        }
        return !zzg() ? str : zza(str, zzgw.zzb, zzgw.zza, zza);
    }

    protected final String zzb(String str) {
        if (str == null) {
            return null;
        }
        return !zzg() ? str : zza(str, zzgv.zzb, zzgv.zza, zzb);
    }

    protected final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return "experiment_id(" + str + ")";
        }
        return zza(str, zzgy.zzb, zzgy.zza, zzc);
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzko.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    protected final String zza(zzaq zzaqVar) {
        String strZza = null;
        if (zzaqVar == null) {
            return null;
        }
        if (!zzg()) {
            return zzaqVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzaqVar.zzc);
        sb.append(",name=");
        sb.append(zza(zzaqVar.zza));
        sb.append(",params=");
        zzal zzalVar = zzaqVar.zzb;
        if (zzalVar != null) {
            if (!zzg()) {
                strZza = zzalVar.toString();
            } else {
                strZza = zza(zzalVar.zzb());
            }
        }
        sb.append(strZza);
        return sb.toString();
    }

    protected final String zza(Bundle bundle) {
        String strValueOf;
        if (bundle == null) {
            return null;
        }
        if (!zzg()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zzb(str));
            sb.append("=");
            if (com.google.android.gms.internal.measurement.zzjt.zzb() && zzt().zza(zzas.zzce)) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    strValueOf = zza(new Object[]{obj});
                } else if (obj instanceof Object[]) {
                    strValueOf = zza((Object[]) obj);
                } else if (obj instanceof ArrayList) {
                    strValueOf = zza(((ArrayList) obj).toArray());
                } else {
                    strValueOf = String.valueOf(obj);
                }
                sb.append(strValueOf);
            } else {
                sb.append(bundle.get(str));
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    private final String zza(Object[] objArr) {
        String strValueOf;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                strValueOf = zza((Bundle) obj);
            } else {
                strValueOf = String.valueOf(obj);
            }
            if (strValueOf != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strValueOf);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }
}
