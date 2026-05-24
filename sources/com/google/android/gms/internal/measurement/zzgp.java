package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgp implements zzgm {
    zzgp() {
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final Map<?, ?> zza(Object obj) {
        return (zzgn) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final zzgk<?, ?> zzf(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final Map<?, ?> zzb(Object obj) {
        return (zzgn) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final boolean zzc(Object obj) {
        return !((zzgn) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final Object zzd(Object obj) {
        ((zzgn) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final Object zze(Object obj) {
        return zzgn.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final Object zza(Object obj, Object obj2) {
        zzgn zzgnVarZzb = (zzgn) obj;
        zzgn zzgnVar = (zzgn) obj2;
        if (!zzgnVar.isEmpty()) {
            if (!zzgnVarZzb.zzd()) {
                zzgnVarZzb = zzgnVarZzb.zzb();
            }
            zzgnVarZzb.zza(zzgnVar);
        }
        return zzgnVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final int zza(int i, Object obj, Object obj2) {
        zzgn zzgnVar = (zzgn) obj;
        if (zzgnVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgnVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
