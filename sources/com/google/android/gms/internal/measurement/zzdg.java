package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdg<T> implements zzde<T>, Serializable {
    private final zzde<T> zza;
    private volatile transient boolean zzb;

    @NullableDecl
    private transient T zzc;

    zzdg(zzde<T> zzdeVar) {
        this.zza = (zzde) zzdc.zza(zzdeVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T tZza = this.zza.zza();
                    this.zzc = tZza;
                    this.zzb = true;
                    return tZza;
                }
            }
        }
        return this.zzc;
    }

    public final String toString() {
        Object string;
        if (this.zzb) {
            String strValueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.zza;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
