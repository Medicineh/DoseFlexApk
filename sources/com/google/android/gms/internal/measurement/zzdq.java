package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzds;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzdq<MessageType extends zzdq<MessageType, BuilderType>, BuilderType extends zzds<MessageType, BuilderType>> implements zzgt {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final zzdz zzbh() {
        try {
            zzeh zzehVarZzc = zzdz.zzc(zzbn());
            zza(zzehVarZzc.zzb());
            return zzehVarZzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] zzbi() {
        try {
            byte[] bArr = new byte[zzbn()];
            zzes zzesVarZza = zzes.zza(bArr);
            zza(zzesVarZza);
            zzesVarZza.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    int zzbj() {
        throw new UnsupportedOperationException();
    }

    void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfk.zza(iterable);
        if (iterable instanceof zzga) {
            List<?> listZzb = ((zzga) iterable).zzb();
            zzga zzgaVar = (zzga) list;
            int size = list.size();
            for (Object obj : listZzb) {
                if (obj == null) {
                    int size2 = zzgaVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = zzgaVar.size() - 1; size3 >= size; size3--) {
                        zzgaVar.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzdz) {
                    zzgaVar.zza((zzdz) obj);
                } else {
                    zzgaVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzhf) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(string2);
            }
            list.add(t);
        }
    }
}
