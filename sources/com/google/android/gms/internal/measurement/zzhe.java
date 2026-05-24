package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhe {
    private static final zzhe zza = new zzhe();
    private final ConcurrentMap<Class<?>, zzhi<?>> zzc = new ConcurrentHashMap();
    private final zzhl zzb = new zzgg();

    public static zzhe zza() {
        return zza;
    }

    public final <T> zzhi<T> zza(Class<T> cls) {
        zzfk.zza(cls, "messageType");
        zzhi<T> zzhiVar = (zzhi) this.zzc.get(cls);
        if (zzhiVar != null) {
            return zzhiVar;
        }
        zzhi<T> zzhiVarZza = this.zzb.zza(cls);
        zzfk.zza(cls, "messageType");
        zzfk.zza(zzhiVarZza, "schema");
        zzhi<T> zzhiVar2 = (zzhi) this.zzc.putIfAbsent(cls, zzhiVarZza);
        return zzhiVar2 != null ? zzhiVar2 : zzhiVarZza;
    }

    public final <T> zzhi<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzhe() {
    }
}
