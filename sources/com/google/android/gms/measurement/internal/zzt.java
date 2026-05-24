package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzt {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    zzt(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    abstract int zza();

    abstract boolean zzb();

    abstract boolean zzc();

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zza(String str, zzbo.zzf zzfVar, zzet zzetVar) {
        String strZzd;
        List<String> list;
        Preconditions.checkNotNull(zzfVar);
        if (str == null || !zzfVar.zza() || zzfVar.zzb() == zzbo.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzfVar.zzb() == zzbo.zzf.zzb.IN_LIST) {
            if (zzfVar.zzh() == 0) {
                return null;
            }
        } else if (!zzfVar.zzc()) {
            return null;
        }
        zzbo.zzf.zzb zzbVarZzb = zzfVar.zzb();
        boolean zZzf = zzfVar.zzf();
        if (zZzf || zzbVarZzb == zzbo.zzf.zzb.REGEXP || zzbVarZzb == zzbo.zzf.zzb.IN_LIST) {
            strZzd = zzfVar.zzd();
        } else {
            strZzd = zzfVar.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str2 = strZzd;
        if (zzfVar.zzh() == 0) {
            list = null;
        } else {
            List<String> listZzg = zzfVar.zzg();
            if (!zZzf) {
                ArrayList arrayList = new ArrayList(listZzg.size());
                Iterator<String> it = listZzg.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listZzg = Collections.unmodifiableList(arrayList);
            }
            list = listZzg;
        }
        return zza(str, zzbVarZzb, zZzf, str2, list, zzbVarZzb == zzbo.zzf.zzb.REGEXP ? str2 : null, zzetVar);
    }

    private static Boolean zza(String str, zzbo.zzf.zzb zzbVar, boolean z, String str2, List<String> list, String str3, zzet zzetVar) {
        if (str == null) {
            return null;
        }
        if (zzbVar == zzbo.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzbVar != zzbo.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzp.zza[zzbVar.ordinal()]) {
            case 1:
                try {
                } catch (PatternSyntaxException unused) {
                    if (zzetVar != null) {
                        zzetVar.zzi().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
                break;
        }
        return null;
    }

    static Boolean zza(long j, zzbo.zzd zzdVar) {
        try {
            return zza(new BigDecimal(j), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(double d, zzbo.zzd zzdVar) {
        try {
            return zza(new BigDecimal(d), zzdVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(String str, zzbo.zzd zzdVar) {
        if (!zzkk.zza(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static Boolean zza(BigDecimal bigDecimal, zzbo.zzd zzdVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzdVar);
        if (zzdVar.zza() && zzdVar.zzb() != zzbo.zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            if (zzdVar.zzb() == zzbo.zzd.zza.BETWEEN) {
                if (!zzdVar.zzg() || !zzdVar.zzi()) {
                    return null;
                }
            } else if (!zzdVar.zze()) {
                return null;
            }
            zzbo.zzd.zza zzaVarZzb = zzdVar.zzb();
            if (zzdVar.zzb() == zzbo.zzd.zza.BETWEEN) {
                if (zzkk.zza(zzdVar.zzh()) && zzkk.zza(zzdVar.zzj())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.zzh());
                        bigDecimal4 = new BigDecimal(zzdVar.zzj());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zzkk.zza(zzdVar.zzf())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.zzf());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzaVarZzb == zzbo.zzd.zza.BETWEEN) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i = zzp.zzb[zzaVarZzb.ordinal()];
            if (i == 1) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            }
            if (i == 2) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            }
            if (i == 3) {
                if (d == 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                }
                if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            if (i == 4) {
                if (bigDecimal.compareTo(bigDecimal3) != -1 && bigDecimal.compareTo(bigDecimal4) != 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }
}
