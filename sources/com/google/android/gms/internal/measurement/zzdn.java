package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdn {
    private final ConcurrentHashMap<zzdm, List<Throwable>> zza = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzb = new ReferenceQueue<>();

    zzdn() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> referencePoll = this.zzb.poll();
        while (referencePoll != null) {
            this.zza.remove(referencePoll);
            referencePoll = this.zzb.poll();
        }
        List<Throwable> list = this.zza.get(new zzdm(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.zza.putIfAbsent(new zzdm(th, this.zzb), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
