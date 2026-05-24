package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhk {
    private static final Class<?> zza = zzd();
    private static final zzia<?, ?> zzb = zza(false);
    private static final zzia<?, ?> zzc = zza(true);
    private static final zzia<?, ?> zzd = new zzic();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfi.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzix zzixVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zza(i, list);
    }

    public static void zzb(int i, List<zzdz> list, zzix zzixVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzix zzixVar, zzhi zzhiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zza(i, list, zzhiVar);
    }

    public static void zzb(int i, List<?> list, zzix zzixVar, zzhi zzhiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.zzb(i, list, zzhiVar);
    }

    static int zza(List<Long> list) {
        int iZzd;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgh) {
            zzgh zzghVar = (zzgh) list;
            iZzd = 0;
            while (i < size) {
                iZzd += zzes.zzd(zzghVar.zzb(i));
                i++;
            }
        } else {
            iZzd = 0;
            while (i < size) {
                iZzd += zzes.zzd(list.get(i).longValue());
                i++;
            }
        }
        return iZzd;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzes.zze(i));
    }

    static int zzb(List<Long> list) {
        int iZze;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgh) {
            zzgh zzghVar = (zzgh) list;
            iZze = 0;
            while (i < size) {
                iZze += zzes.zze(zzghVar.zzb(i));
                i++;
            }
        } else {
            iZze = 0;
            while (i < size) {
                iZze += zzes.zze(list.get(i).longValue());
                i++;
            }
        }
        return iZze;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzes.zze(i));
    }

    static int zzc(List<Long> list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgh) {
            zzgh zzghVar = (zzgh) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzes.zzf(zzghVar.zzb(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzes.zzf(list.get(i).longValue());
                i++;
            }
        }
        return iZzf;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzes.zze(i));
    }

    static int zzd(List<Integer> list) {
        int iZzk;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzflVar = (zzfl) list;
            iZzk = 0;
            while (i < size) {
                iZzk += zzes.zzk(zzflVar.zzc(i));
                i++;
            }
        } else {
            iZzk = 0;
            while (i < size) {
                iZzk += zzes.zzk(list.get(i).intValue());
                i++;
            }
        }
        return iZzk;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzes.zze(i));
    }

    static int zze(List<Integer> list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzflVar = (zzfl) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzes.zzf(zzflVar.zzc(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzes.zzf(list.get(i).intValue());
                i++;
            }
        }
        return iZzf;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzes.zze(i));
    }

    static int zzf(List<Integer> list) {
        int iZzg;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzflVar = (zzfl) list;
            iZzg = 0;
            while (i < size) {
                iZzg += zzes.zzg(zzflVar.zzc(i));
                i++;
            }
        } else {
            iZzg = 0;
            while (i < size) {
                iZzg += zzes.zzg(list.get(i).intValue());
                i++;
            }
        }
        return iZzg;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzes.zze(i));
    }

    static int zzg(List<Integer> list) {
        int iZzh;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzflVar = (zzfl) list;
            iZzh = 0;
            while (i < size) {
                iZzh += zzes.zzh(zzflVar.zzc(i));
                i++;
            }
        } else {
            iZzh = 0;
            while (i < size) {
                iZzh += zzes.zzh(list.get(i).intValue());
                i++;
            }
        }
        return iZzh;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzes.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzes.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzes.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzes.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzes.zze(i) * size;
        if (list instanceof zzga) {
            zzga zzgaVar = (zzga) list;
            while (i2 < size) {
                Object objZzb = zzgaVar.zzb(i2);
                if (objZzb instanceof zzdz) {
                    iZzb2 = zzes.zzb((zzdz) objZzb);
                } else {
                    iZzb2 = zzes.zzb((String) objZzb);
                }
                iZze += iZzb2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdz) {
                    iZzb = zzes.zzb((zzdz) obj);
                } else {
                    iZzb = zzes.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzhi zzhiVar) {
        if (obj instanceof zzfy) {
            return zzes.zza(i, (zzfy) obj);
        }
        return zzes.zzb(i, (zzgt) obj, zzhiVar);
    }

    static int zza(int i, List<?> list, zzhi zzhiVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzes.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzfy) {
                iZza = zzes.zza((zzfy) obj);
            } else {
                iZza = zzes.zza((zzgt) obj, zzhiVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzdz> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzes.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzes.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzgt> list, zzhi zzhiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzes.zzc(i, list.get(i2), zzhiVar);
        }
        return iZzc;
    }

    public static zzia<?, ?> zza() {
        return zzb;
    }

    public static zzia<?, ?> zzb() {
        return zzc;
    }

    public static zzia<?, ?> zzc() {
        return zzd;
    }

    private static zzia<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzia) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzgm zzgmVar, T t, T t2, long j) {
        zzig.zza(t, j, zzgmVar.zza(zzig.zzf(t, j), zzig.zzf(t2, j)));
    }

    static <T, FT extends zzfd<FT>> void zza(zzex<FT> zzexVar, T t, T t2) {
        zzfb<T> zzfbVarZza = zzexVar.zza(t2);
        if (zzfbVarZza.zza.isEmpty()) {
            return;
        }
        zzexVar.zzb(t).zza((zzfb) zzfbVarZza);
    }

    static <T, UT, UB> void zza(zzia<UT, UB> zziaVar, T t, T t2) {
        zziaVar.zza(t, zziaVar.zzc(zziaVar.zzb(t), zziaVar.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfp zzfpVar, UB ub, zzia<UT, UB> zziaVar) {
        if (zzfpVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzfpVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, iIntValue, ub, zziaVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzfpVar.zza(iIntValue2)) {
                    ub = (UB) zza(i, iIntValue2, ub, zziaVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzia<UT, UB> zziaVar) {
        if (ub == null) {
            ub = zziaVar.zza();
        }
        zziaVar.zza(ub, i, i2);
        return ub;
    }
}
