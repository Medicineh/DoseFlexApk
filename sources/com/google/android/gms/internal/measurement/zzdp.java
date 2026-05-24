package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdp extends zzdk {
    zzdp() {
    }

    @Override // com.google.android.gms.internal.measurement.zzdk
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
