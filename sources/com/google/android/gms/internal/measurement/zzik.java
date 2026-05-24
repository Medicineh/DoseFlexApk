package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzik {
    zzik() {
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract int zza(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String zzb(byte[] bArr, int i, int i2) throws zzft;

    final boolean zza(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
