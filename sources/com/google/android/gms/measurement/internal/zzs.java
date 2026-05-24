package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbw;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzs {
    private String zza;
    private boolean zzb;
    private zzbw.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzq zzh;

    private zzs(zzq zzqVar, String str) {
        this.zzh = zzqVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzs(zzq zzqVar, String str, zzbw.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzqVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zziVar;
    }

    final void zza(zzt zztVar) {
        int iZza = zztVar.zza();
        if (zztVar.zzc != null) {
            this.zze.set(iZza, zztVar.zzc.booleanValue());
        }
        if (zztVar.zzd != null) {
            this.zzd.set(iZza, zztVar.zzd.booleanValue());
        }
        if (zztVar.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zztVar.zze.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zztVar.zzf != null) {
            List<Long> arrayList = this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zztVar.zzb()) {
                arrayList.clear();
            }
            if (com.google.android.gms.internal.measurement.zzkf.zzb() && this.zzh.zzt().zzd(this.zza, zzas.zzbg) && zztVar.zzc()) {
                arrayList.clear();
            }
            if (com.google.android.gms.internal.measurement.zzkf.zzb() && this.zzh.zzt().zzd(this.zza, zzas.zzbg)) {
                long jLongValue2 = zztVar.zzf.longValue() / 1000;
                if (arrayList.contains(Long.valueOf(jLongValue2))) {
                    return;
                }
                arrayList.add(Long.valueOf(jLongValue2));
                return;
            }
            arrayList.add(Long.valueOf(zztVar.zzf.longValue() / 1000));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzbw$zza$zza, com.google.android.gms.internal.measurement.zzfi$zzb] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.google.android.gms.internal.measurement.zzbw$zzi$zza] */
    final zzbw.zza zza(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? Zzh = zzbw.zza.zzh();
        Zzh.zza(i);
        Zzh.zza(this.zzb);
        zzbw.zzi zziVar = this.zzc;
        if (zziVar != null) {
            Zzh.zza(zziVar);
        }
        ?? Zza = zzbw.zzi.zzi().zzb(zzkk.zza(this.zzd)).zza(zzkk.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            Iterator<Integer> it = this.zzf.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                arrayList.add((zzbw.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzbw.zzb.zze().zza(iIntValue).zza(this.zzf.get(Integer.valueOf(iIntValue)).longValue()).zzu()));
            }
        }
        Zza.zzc(arrayList);
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num : this.zzg.keySet()) {
                zzbw.zzj.zza zzaVarZza = zzbw.zzj.zze().zza(num.intValue());
                List<Long> list = this.zzg.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza.zza(list);
                }
                arrayList2.add((zzbw.zzj) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZza.zzu()));
            }
        }
        Zza.zzd(arrayList2);
        Zzh.zza(Zza);
        return (zzbw.zza) ((com.google.android.gms.internal.measurement.zzfi) Zzh.zzu());
    }

    /* synthetic */ zzs(zzq zzqVar, String str, zzbw.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzp zzpVar) {
        this(zzqVar, str, zziVar, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzs(zzq zzqVar, String str, zzp zzpVar) {
        this(zzqVar, str);
    }
}
