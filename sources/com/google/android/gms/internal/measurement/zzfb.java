package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfb<T extends zzfd<T>> {
    private static final zzfb zzd = new zzfb(true);
    final zzhn<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzfb() {
        this.zza = zzhn.zza(16);
    }

    private zzfb(boolean z) {
        this(zzhn.zza(0));
        zzb();
    }

    private zzfb(zzhn<T, Object> zzhnVar) {
        this.zza = zzhnVar;
        zzb();
    }

    public static <T extends zzfd<T>> zzfb<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfb) {
            return this.zza.equals(((zzfb) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfz(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfz(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfu)) {
            return obj;
        }
        return zzfu.zza();
    }

    private final void zzb(T t, Object obj) {
        if (t.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            zza(t.zzb(), obj);
        }
        if (obj instanceof zzfu) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.measurement.zzir r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzfk.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzfa.zza
            com.google.android.gms.internal.measurement.zziu r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgt
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfu
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfn
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzdz
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L4e
        L4d:
            throw r2
        L4e:
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.zza(com.google.android.gms.internal.measurement.zzir, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzfd<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zziu.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgt) it.next()).zzbl()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgt) {
                    if (!((zzgt) value).zzbl()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzfu) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfb<T> zzfbVar) {
        for (int i = 0; i < zzfbVar.zza.zzc(); i++) {
            zzb(zzfbVar.zza.zzb(i));
        }
        Iterator it = zzfbVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgy) {
            return ((zzgy) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzgt zzgtVarZzu;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfu) {
            value = zzfu.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zzfd) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() == zziu.MESSAGE) {
            Object objZza2 = zza((zzfd) key);
            if (objZza2 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (objZza2 instanceof zzgy) {
                zzgtVarZzu = key.zza((zzgy) objZza2, (zzgy) value);
            } else {
                zzgtVarZzu = key.zza(((zzgt) objZza2).zzbr(), (zzgt) value).zzu();
            }
            this.zza.put(key, zzgtVarZzu);
            return;
        }
        this.zza.put(key, zza(value));
    }

    static void zza(zzes zzesVar, zzir zzirVar, int i, Object obj) throws IOException {
        if (zzirVar == zzir.zzj) {
            zzgt zzgtVar = (zzgt) obj;
            zzfk.zza(zzgtVar);
            zzesVar.zza(i, 3);
            zzgtVar.zza(zzesVar);
            zzesVar.zza(i, 4);
        }
        zzesVar.zza(i, zzirVar.zzb());
        switch (zzfa.zzb[zzirVar.ordinal()]) {
            case 1:
                zzesVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzesVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzesVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zzesVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zzesVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zzesVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zzesVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zzesVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzgt) obj).zza(zzesVar);
                break;
            case 10:
                zzesVar.zza((zzgt) obj);
                break;
            case 11:
                if (obj instanceof zzdz) {
                    zzesVar.zza((zzdz) obj);
                } else {
                    zzesVar.zza((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzdz) {
                    zzesVar.zza((zzdz) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzesVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzesVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zzesVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zzesVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zzesVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zzesVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzfn) {
                    zzesVar.zza(((zzfn) obj).zza());
                } else {
                    zzesVar.zza(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final int zzg() {
        int iZzc = 0;
        for (int i = 0; i < this.zza.zzc(); i++) {
            iZzc += zzc(this.zza.zzb(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zziu.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzfu) {
                return zzes.zzb(entry.getKey().zza(), (zzfu) value);
            }
            return zzes.zzb(entry.getKey().zza(), (zzgt) value);
        }
        return zza((zzfd<?>) key, value);
    }

    static int zza(zzir zzirVar, int i, Object obj) {
        int iZze = zzes.zze(i);
        if (zzirVar == zzir.zzj) {
            zzfk.zza((zzgt) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zzirVar, obj);
    }

    private static int zzb(zzir zzirVar, Object obj) {
        switch (zzfa.zzb[zzirVar.ordinal()]) {
            case 1:
                return zzes.zzb(((Double) obj).doubleValue());
            case 2:
                return zzes.zzb(((Float) obj).floatValue());
            case 3:
                return zzes.zzd(((Long) obj).longValue());
            case 4:
                return zzes.zze(((Long) obj).longValue());
            case 5:
                return zzes.zzf(((Integer) obj).intValue());
            case 6:
                return zzes.zzg(((Long) obj).longValue());
            case 7:
                return zzes.zzi(((Integer) obj).intValue());
            case 8:
                return zzes.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzes.zzc((zzgt) obj);
            case 10:
                if (obj instanceof zzfu) {
                    return zzes.zza((zzfu) obj);
                }
                return zzes.zzb((zzgt) obj);
            case 11:
                if (obj instanceof zzdz) {
                    return zzes.zzb((zzdz) obj);
                }
                return zzes.zzb((String) obj);
            case 12:
                if (obj instanceof zzdz) {
                    return zzes.zzb((zzdz) obj);
                }
                return zzes.zzb((byte[]) obj);
            case 13:
                return zzes.zzg(((Integer) obj).intValue());
            case 14:
                return zzes.zzj(((Integer) obj).intValue());
            case 15:
                return zzes.zzh(((Long) obj).longValue());
            case 16:
                return zzes.zzh(((Integer) obj).intValue());
            case 17:
                return zzes.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfn) {
                    return zzes.zzk(((zzfn) obj).zza());
                }
                return zzes.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzfd<?> zzfdVar, Object obj) {
        zzir zzirVarZzb = zzfdVar.zzb();
        int iZza = zzfdVar.zza();
        if (zzfdVar.zzd()) {
            int iZza2 = 0;
            if (zzfdVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zzirVarZzb, it.next());
                }
                return zzes.zze(iZza) + iZza2 + zzes.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzirVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzirVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfb zzfbVar = new zzfb();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzfbVar.zzb((zzfd) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzfbVar.zzb((zzfd) entry.getKey(), entry.getValue());
        }
        zzfbVar.zzc = this.zzc;
        return zzfbVar;
    }
}
