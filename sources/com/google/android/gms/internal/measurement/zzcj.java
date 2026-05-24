package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzcj {
    public static <V> V zza(zzci<V> zzciVar) {
        try {
            return zzciVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzciVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
