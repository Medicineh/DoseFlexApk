package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzfi;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbt {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zza extends zzfi<zza, C0006zza> implements zzgv {
        private static final zza zzh;
        private static volatile zzhc<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzbt$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class C0006zza extends zzfi.zzb<zza, C0006zza> implements zzgv {
            private C0006zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final C0006zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0006zza(zzbv zzbvVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbv zzbvVar = null;
            switch (zzbv.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0006zza(zzbvVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhc<zza> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
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

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zzfi.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzb extends zzfi<zzb, zza> implements zzgv {
        private static final zzb zzl;
        private static volatile zzhc<zzb> zzm;
        private int zzc;
        private long zzd;
        private int zzf;
        private boolean zzk;
        private String zze = "";
        private zzfq<zzc> zzg = zzbq();
        private zzfq<zza> zzh = zzbq();
        private zzfq<zzbo.zza> zzi = zzbq();
        private String zzj = "";

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzb, zza> implements zzgv {
            private zza() {
                super(zzb.zzl);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0006zza c0006zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzfi) c0006zza.zzu()));
                return this;
            }

            public final List<zzbo.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzbv zzbvVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final zza zza(int i) {
            return this.zzh.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zza zzaVar) {
            zzaVar.getClass();
            zzfq<zza> zzfqVar = this.zzh;
            if (!zzfqVar.zza()) {
                this.zzh = zzfi.zza(zzfqVar);
            }
            this.zzh.set(i, zzaVar);
        }

        public final List<zzbo.zza> zzg() {
            return this.zzi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzbq();
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public static zza zzi() {
            return zzl.zzbk();
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbv zzbvVar = null;
            switch (zzbv.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbvVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbo.zza.class, "zzj", "zzk"});
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

        public static zzb zzj() {
            return zzl;
        }

        static {
            zzb zzbVar = new zzb();
            zzl = zzbVar;
            zzfi.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class zzc extends zzfi<zzc, zza> implements zzgv {
        private static final zzc zzf;
        private static volatile zzhc<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzc() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
        public static final class zza extends zzfi.zzb<zzc, zza> implements zzgv {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbv zzbvVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzfi
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbv zzbvVar = null;
            switch (zzbv.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbvVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhc<zzc> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzg;
                            if (zzaVar == null) {
                                zzaVar = new zzfi.zza<>(zzf);
                                zzg = zzaVar;
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
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzfi.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }
}
