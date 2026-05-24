package com.google.android.gms.internal.measurement;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzfi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class zzev {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzev zzc;
    private static volatile zzev zzd;
    private static final zzev zze = new zzev(true);
    private final Map<zza, zzfi.zzf<?, ?>> zzf;

    public static zzev zza() {
        zzev zzevVar = zzc;
        if (zzevVar == null) {
            synchronized (zzev.class) {
                zzevVar = zzc;
                if (zzevVar == null) {
                    zzevVar = zze;
                    zzc = zzevVar;
                }
            }
        }
        return zzevVar;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzev zzb() {
        zzev zzevVar = zzd;
        if (zzevVar != null) {
            return zzevVar;
        }
        synchronized (zzev.class) {
            zzev zzevVar2 = zzd;
            if (zzevVar2 != null) {
                return zzevVar2;
            }
            zzev zzevVarZza = zzfg.zza(zzev.class);
            zzd = zzevVarZza;
            return zzevVarZza;
        }
    }

    public final <ContainingType extends zzgt> zzfi.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzfi.zzf) this.zzf.get(new zza(containingtype, i));
    }

    zzev() {
        this.zzf = new HashMap();
    }

    private zzev(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
