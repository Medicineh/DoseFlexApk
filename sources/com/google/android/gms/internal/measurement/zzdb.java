package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdb<T> extends zzdd<T> {
    static final zzdb<Object> zza = new zzdb<>();

    private zzdb() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
