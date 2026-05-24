package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzp implements Transformer {
    static final Transformer zza = new zzp();

    private zzp() {
    }

    @Override // com.google.android.datatransport.Transformer
    public final Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
