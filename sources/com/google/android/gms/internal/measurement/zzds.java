package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzds;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzds<MessageType extends zzdq<MessageType, BuilderType>, BuilderType extends zzds<MessageType, BuilderType>> implements zzgs {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzel zzelVar, zzev zzevVar) throws IOException;

    @Override // 
    /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzft {
        try {
            zzel zzelVarZza = zzel.zza(bArr, 0, i2, false);
            zza(zzelVarZza, zzev.zza());
            zzelVarZza.zza(0);
            return this;
        } catch (zzft e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzev zzevVar) throws zzft {
        try {
            zzel zzelVarZza = zzel.zza(bArr, 0, i2, false);
            zza(zzelVarZza, zzevVar);
            zzelVarZza.zza(0);
            return this;
        } catch (zzft e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final /* synthetic */ zzgs zza(zzgt zzgtVar) {
        if (!zzbt().getClass().isInstance(zzgtVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzdq) zzgtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final /* synthetic */ zzgs zza(byte[] bArr, zzev zzevVar) throws zzft {
        return zza(bArr, 0, bArr.length, zzevVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final /* synthetic */ zzgs zza(byte[] bArr) throws zzft {
        return zza(bArr, 0, bArr.length);
    }
}
