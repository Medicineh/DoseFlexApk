package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfi.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzfi<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdq<MessageType, BuilderType> {
    private static Map<Object, zzfi<?, ?>> zzd = new ConcurrentHashMap();
    protected zzid zzb = zzid.zza();
    private int zzc = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class zza<T extends zzfi<T, ?>> extends zzdu<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    static final class zzc implements zzfd<zzc> {
        @Override // com.google.android.gms.internal.measurement.zzfd
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        public final zzir zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        public final zziu zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        public final zzgs zza(zzgs zzgsVar, zzgt zzgtVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        public final zzgy zza(zzgy zzgyVar, zzgy zzgyVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class zzf<ContainingType extends zzgt, Type> extends zzew<ContainingType, Type> {
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfi<MessageType, BuilderType> implements zzgv {
        protected zzfb<zzc> zzc = zzfb.zza();

        final zzfb<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzfb) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzgu.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzhe.zza().zza(this).zza(this);
        return this.zza;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class zzb<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzds<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zze.zzd, null, null);
        }

        protected void zzq() {
            MessageType messagetype = (MessageType) this.zza.zza(zze.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzgv
        public final boolean zzbl() {
            return zzfi.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzgs
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public MessageType zzt() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzhe.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzgs
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public final MessageType zzu() {
            MessageType messagetype = (MessageType) zzt();
            if (messagetype.zzbl()) {
                return messagetype;
            }
            throw new zzib(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzds
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhe.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzev zzevVar) throws zzft {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzhe.zza().zza(this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzdy(zzevVar));
                return this;
            } catch (zzft e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzft.zza();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzds
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzel zzelVar, zzev zzevVar) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzhe.zza().zza(this.zza).zza(this.zza, zzeq.zza(zzelVar), zzevVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzds
        public final /* synthetic */ zzds zza(byte[] bArr, int i, int i2, zzev zzevVar) throws zzft {
            return zzb(bArr, 0, i2, zzevVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzds
        public final /* synthetic */ zzds zza(byte[] bArr, int i, int i2) throws zzft {
            return zzb(bArr, 0, i2, zzev.zza());
        }

        @Override // com.google.android.gms.internal.measurement.zzds
        /* JADX INFO: renamed from: zzp */
        public final /* synthetic */ zzds clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzgv
        public final /* synthetic */ zzgt zzbt() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzds
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzfi) zzt());
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhe.zza().zza(this).zza(this, (zzfi) obj);
        }
        return false;
    }

    protected final <MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbk() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgv
    public final boolean zzbl() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbm() {
        BuilderType buildertype = (BuilderType) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzdq
    final int zzbj() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzdq
    final void zzc(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final void zza(zzes zzesVar) throws IOException {
        zzhe.zza().zza(this).zza(this, zzeu.zza(zzesVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final int zzbn() {
        if (this.zzc == -1) {
            this.zzc = zzhe.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzfi<?, ?>> T zza(Class<T> cls) {
        zzfi<?, ?> zzfiVar = zzd.get(cls);
        if (zzfiVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfiVar = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfiVar == null) {
            zzfiVar = (T) ((zzfi) zzig.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (zzfiVar == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzfiVar);
        }
        return (T) zzfiVar;
    }

    protected static <T extends zzfi<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzgt zzgtVar, String str, Object[] objArr) {
        return new zzhg(zzgtVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzfi<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzhe.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    protected static zzfo zzbo() {
        return zzfl.zzd();
    }

    protected static zzfr zzbp() {
        return zzgh.zzd();
    }

    protected static zzfr zza(zzfr zzfrVar) {
        int size = zzfrVar.size();
        return zzfrVar.zza(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzfq<E> zzbq() {
        return zzhh.zzd();
    }

    protected static <E> zzfq<E> zza(zzfq<E> zzfqVar) {
        int size = zzfqVar.size();
        return zzfqVar.zza(size == 0 ? 10 : size << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final /* synthetic */ zzgs zzbr() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final /* synthetic */ zzgs zzbs() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgv
    public final /* synthetic */ zzgt zzbt() {
        return (zzfi) zza(zze.zzf, (Object) null, (Object) null);
    }
}
