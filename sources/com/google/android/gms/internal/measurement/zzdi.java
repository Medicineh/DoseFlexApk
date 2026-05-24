package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdi<T> implements zzde<T>, Serializable {

    @NullableDecl
    private final T zza;

    zzdi(@NullableDecl T t) {
        this.zza = t;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final T zza() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof zzdi)) {
            return false;
        }
        T t = this.zza;
        T t2 = ((zzdi) obj).zza;
        if (t != t2) {
            return t != null && t.equals(t2);
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
