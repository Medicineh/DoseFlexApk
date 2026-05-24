package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfw<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzfu> zza;

    private zzfw(Map.Entry<K, zzfu> entry) {
        this.zza = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzfu.zza();
    }

    public final zzfu zza() {
        return this.zza.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzgt)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zza.getValue().zza((zzgt) obj);
    }
}
