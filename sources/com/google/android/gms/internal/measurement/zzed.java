package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzed implements zzef {
    private zzed() {
    }

    @Override // com.google.android.gms.internal.measurement.zzef
    public final byte[] zza(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* synthetic */ zzed(zzec zzecVar) {
        this();
    }
}
