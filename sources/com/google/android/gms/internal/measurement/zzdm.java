package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdm extends WeakReference<Throwable> {
    private final int zza;

    public zzdm(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zza = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzdm zzdmVar = (zzdm) obj;
            if (this.zza == zzdmVar.zza && get() == zzdmVar.get()) {
                return true;
            }
        }
        return false;
    }
}
