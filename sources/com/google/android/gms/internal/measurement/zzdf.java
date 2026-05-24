package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdf<T> extends zzdd<T> {
    private final T zza;

    zzdf(T t) {
        this.zza = t;
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public final T zzb() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdf) {
            return this.zza.equals(((zzdf) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
