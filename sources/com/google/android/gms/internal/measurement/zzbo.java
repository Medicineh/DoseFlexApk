package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbo {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zza extends zzfi<zza, C0005zza> implements zzgv {
        private static final zza zzi;
        private static volatile zzhc<zza> zzj;
        private int zzc;
        private int zzd;
        private zzfq<zze> zze = zzbq();
        private zzfq<zzb> zzf = zzbq();
        private boolean zzg;
        private boolean zzh;

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class C0005zza extends zzfi.zzb<zza, C0005zza> implements zzgv {
            private C0005zza() {
                super(zza.zzi);
            }

            public final int zza() {
                return ((zza) this.zza).zzd();
            }

            public final zze zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final C0005zza zza(int i, zze.zza zzaVar) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zze) ((zzfi) zzaVar.zzu()));
                return this;
            }

            public final int zzb() {
                return ((zza) this.zza).zzf();
            }

            public final zzb zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            public final C0005zza zza(int i, zzb.zza zzaVar) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zzb) ((zzfi) zzaVar.zzu()));
                return this;
            }

            /* synthetic */ C0005zza(zzbp zzbpVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<zze> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final zze zza(int i) {
            return this.zze.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zze zzeVar) {
            zzeVar.getClass();
            zzfq<zze> zzfqVar = this.zze;
            if (!zzfqVar.zza()) {
                this.zze = zzfi.zza(zzfqVar);
            }
            this.zze.set(i, zzeVar);
        }

        public final List<zzb> zze() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzf.size();
        }

        public final zzb zzb(int i) {
            return this.zzf.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzb zzbVar) {
            zzbVar.getClass();
            zzfq<zzb> zzfqVar = this.zzf;
            if (!zzfqVar.zza()) {
                this.zzf = zzfi.zza(zzfqVar);
            }
            this.zzf.set(i, zzbVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbp zzbpVar = null;
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0005zza(zzbpVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhc<zza> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzj;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzi);
                                zzj = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zzaVar = new zza();
            zzi = zzaVar;
            zzfi.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzb extends zzfi<zzb, zza> implements zzgv {
        private static final zzb zzl;
        private static volatile zzhc<zzb> zzm;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzfq<zzc> zzf = zzbq();
        private boolean zzg;
        private zzd zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzb, zza> implements zzgv {
            private zza() {
                super(zzb.zzl);
            }

            public final String zza() {
                return ((zzb) this.zza).zzc();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final int zzb() {
                return ((zzb) this.zza).zze();
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zzc zzcVar) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, zzcVar);
                return this;
            }

            /* synthetic */ zza(zzbp zzbpVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final List<zzc> zzd() {
            return this.zzf;
        }

        public final int zze() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzfq<zzc> zzfqVar = this.zzf;
            if (!zzfqVar.zza()) {
                this.zzf = zzfi.zza(zzfqVar);
            }
            this.zzf.set(i, zzcVar);
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final zzd zzg() {
            zzd zzdVar = this.zzh;
            return zzdVar == null ? zzd.zzk() : zzdVar;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public final boolean zzi() {
            return this.zzj;
        }

        public final boolean zzj() {
            return (this.zzc & 64) != 0;
        }

        public final boolean zzk() {
            return this.zzk;
        }

        public static zza zzl() {
            return zzl.zzbk();
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbp zzbpVar = null;
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbpVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhc<zzb> zzaVar = zzm;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzm;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzl);
                                zzm = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzl = zzbVar;
            zzfi.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzd extends zzfi<zzd, zzb> implements zzgv {
        private static final zzd zzi;
        private static volatile zzhc<zzd> zzj;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public enum zza implements zzfn {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);

            private static final zzfm<zza> zzf = new zzbr();
            private final int zzg;

            @Override // com.google.android.gms.internal.measurement.zzfn
            public final int zza() {
                return this.zzg;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzfp zzb() {
                return zzbq.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            zza(int i) {
                this.zzg = i;
            }
        }

        private zzd() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zzb extends zzfi.zzb<zzd, zzb> implements zzgv {
            private zzb() {
                super(zzd.zzi);
            }

            /* synthetic */ zzb(zzbp zzbpVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zza zzb() {
            zza zzaVarZza = zza.zza(this.zzd);
            return zzaVarZza == null ? zza.UNKNOWN_COMPARISON_TYPE : zzaVarZza;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final boolean zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final String zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final String zzj() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbp zzbpVar = null;
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(zzbpVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhc<zzd> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zzd.class) {
                            zzaVar = zzj;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzi);
                                zzj = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzd zzk() {
            return zzi;
        }

        static {
            zzd zzdVar = new zzd();
            zzi = zzdVar;
            zzfi.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzf extends zzfi<zzf, zza> implements zzgv {
        private static final zzf zzh;
        private static volatile zzhc<zzf> zzi;
        private int zzc;
        private int zzd;
        private boolean zzf;
        private String zze = "";
        private zzfq<String> zzg = zzfi.zzbq();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public enum zzb implements zzfn {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);

            private static final zzfm<zzb> zzh = new zzbs();
            private final int zzi;

            @Override // com.google.android.gms.internal.measurement.zzfn
            public final int zza() {
                return this.zzi;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzfp zzb() {
                return zzbu.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            zzb(int i) {
                this.zzi = i;
            }
        }

        private zzf() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzf, zza> implements zzgv {
            private zza() {
                super(zzf.zzh);
            }

            /* synthetic */ zza(zzbp zzbpVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzb zzb() {
            zzb zzbVarZza = zzb.zza(this.zzd);
            return zzbVarZza == null ? zzb.UNKNOWN_MATCH_TYPE : zzbVarZza;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final List<String> zzg() {
            return this.zzg;
        }

        public final int zzh() {
            return this.zzg.size();
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbp zzbpVar = null;
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzbpVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zzf> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zzf.class) {
                            zzaVar = zzi;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzh);
                                zzi = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzf zzi() {
            return zzh;
        }

        static {
            zzf zzfVar = new zzf();
            zzh = zzfVar;
            zzfi.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzc extends zzfi<zzc, zza> implements zzgv {
        private static final zzc zzh;
        private static volatile zzhc<zzc> zzi;
        private int zzc;
        private zzf zzd;
        private zzd zze;
        private boolean zzf;
        private String zzg = "";

        private zzc() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzc, zza> implements zzgv {
            private zza() {
                super(zzc.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbp zzbpVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzf zzb() {
            zzf zzfVar = this.zzd;
            return zzfVar == null ? zzf.zzi() : zzfVar;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final zzd zzd() {
            zzd zzdVar = this.zze;
            return zzdVar == null ? zzd.zzk() : zzdVar;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbp zzbpVar = null;
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbpVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zzc> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzi;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzh);
                                zzi = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzc zzi() {
            return zzh;
        }

        static {
            zzc zzcVar = new zzc();
            zzh = zzcVar;
            zzfi.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zze extends zzfi<zze, zza> implements zzgv {
        private static final zze zzj;
        private static volatile zzhc<zze> zzk;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzc zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

        private zze() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zze, zza> implements zzgv {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbp zzbpVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final zzc zzd() {
            zzc zzcVar = this.zzf;
            return zzcVar == null ? zzc.zzi() : zzcVar;
        }

        public final boolean zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zzc & 32) != 0;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public static zza zzi() {
            return zzj.zzbk();
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbp zzbpVar = null;
            switch (zzbp.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzbpVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhc<zze> zzaVar = zzk;
                    if (zzaVar == null) {
                        synchronized (zze.class) {
                            zzaVar = zzk;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzj);
                                zzk = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zze zzeVar = new zze();
            zzj = zzeVar;
            zzfi.zza((Class<zze>) zze.class, zzeVar);
        }
    }
}
