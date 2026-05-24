package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzem<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzek<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzem(String str, V v, V v2, zzek<V> zzekVar) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzekVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zza(V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzej.zza == null) {
            return this.zzc;
        }
        zzv zzvVar = zzej.zza;
        synchronized (zzf) {
            if (zzv.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzem zzemVar : zzas.zzcr) {
                    if (zzv.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V vZza = null;
                    try {
                        if (zzemVar.zzb != null) {
                            vZza = zzemVar.zzb.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzemVar.zzh = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzek<V> zzekVar = this.zzb;
            if (zzekVar == null) {
                zzv zzvVar2 = zzej.zza;
                return this.zzc;
            }
            try {
                return zzekVar.zza();
            } catch (IllegalStateException unused3) {
                zzv zzvVar3 = zzej.zza;
                return this.zzc;
            } catch (SecurityException unused4) {
                zzv zzvVar4 = zzej.zza;
                return this.zzc;
            }
        }
    }
}
