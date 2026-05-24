package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgg implements zzhl {
    private static final zzgq zzb = new zzgj();
    private final zzgq zza;

    public zzgg() {
        this(new zzgi(zzfj.zza(), zza()));
    }

    private zzgg(zzgq zzgqVar) {
        this.zza = (zzgq) zzfk.zza(zzgqVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.measurement.zzhl
    public final <T> zzhi<T> zza(Class<T> cls) {
        zzhk.zza((Class<?>) cls);
        zzgr zzgrVarZzb = this.zza.zzb(cls);
        if (zzgrVarZzb.zzb()) {
            if (zzfi.class.isAssignableFrom(cls)) {
                return zzgz.zza(zzhk.zzc(), zzey.zza(), zzgrVarZzb.zzc());
            }
            return zzgz.zza(zzhk.zza(), zzey.zzb(), zzgrVarZzb.zzc());
        }
        if (zzfi.class.isAssignableFrom(cls)) {
            if (zza(zzgrVarZzb)) {
                return zzgx.zza(cls, zzgrVarZzb, zzhd.zzb(), zzgd.zzb(), zzhk.zzc(), zzey.zza(), zzgo.zzb());
            }
            return zzgx.zza(cls, zzgrVarZzb, zzhd.zzb(), zzgd.zzb(), zzhk.zzc(), (zzex<?>) null, zzgo.zzb());
        }
        if (zza(zzgrVarZzb)) {
            return zzgx.zza(cls, zzgrVarZzb, zzhd.zza(), zzgd.zza(), zzhk.zza(), zzey.zzb(), zzgo.zza());
        }
        return zzgx.zza(cls, zzgrVarZzb, zzhd.zza(), zzgd.zza(), zzhk.zzb(), (zzex<?>) null, zzgo.zza());
    }

    private static boolean zza(zzgr zzgrVar) {
        return zzgrVar.zza() == zzfi.zze.zzh;
    }

    private static zzgq zza() {
        try {
            return (zzgq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
