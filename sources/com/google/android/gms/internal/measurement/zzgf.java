package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgf extends zzgd {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgf() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzgd
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.measurement.zzgd
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzig.zzf(obj, j);
        if (list instanceof zzga) {
            objUnmodifiableList = ((zzga) list).g_();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzhf) && (list instanceof zzfq)) {
                zzfq zzfqVar = (zzfq) list;
                if (zzfqVar.zza()) {
                    zzfqVar.h_();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzig.zza(obj, j, objUnmodifiableList);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        Object obj2;
        List<L> arrayList;
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            if (listZzc instanceof zzga) {
                arrayList = new zzgb(i);
            } else if ((listZzc instanceof zzhf) && (listZzc instanceof zzfq)) {
                arrayList = ((zzfq) listZzc).zza(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzig.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(listZzc.size() + i);
            arrayList2.addAll(listZzc);
            zzig.zza(obj, j, arrayList2);
            obj2 = arrayList2;
        } else if (listZzc instanceof zzif) {
            zzgb zzgbVar = new zzgb(listZzc.size() + i);
            zzgbVar.addAll((zzif) listZzc);
            zzig.zza(obj, j, zzgbVar);
            obj2 = zzgbVar;
        } else {
            if (!(listZzc instanceof zzhf) || !(listZzc instanceof zzfq)) {
                return listZzc;
            }
            zzfq zzfqVar = (zzfq) listZzc;
            if (zzfqVar.zza()) {
                return listZzc;
            }
            zzfq zzfqVarZza = zzfqVar.zza(listZzc.size() + i);
            zzig.zza(obj, j, zzfqVarZza);
            return zzfqVarZza;
        }
        return (List<L>) obj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgd
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzig.zza(obj, j, listZzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzig.zzf(obj, j);
    }
}
