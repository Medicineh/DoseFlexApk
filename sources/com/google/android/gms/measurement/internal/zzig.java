package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzle;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzig extends zzkd {
    public zzig(zzkg zzkgVar) {
        super(zzkgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkd
    protected final boolean zze() {
        return false;
    }

    public final byte[] zza(zzaq zzaqVar, String str) {
        zzkp next;
        zzg zzgVar;
        zzbw.zzg.zza zzaVar;
        zzbw.zzf.zza zzaVar2;
        Bundle bundle;
        byte[] bArr;
        long j;
        zzam zzamVarZza;
        zzd();
        this.zzz.zzae();
        Preconditions.checkNotNull(zzaqVar);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str, zzas.zzax)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzaqVar.zza) && !"_iapx".equals(zzaqVar.zza)) {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str, zzaqVar.zza);
            return null;
        }
        zzbw.zzf.zza zzaVarZzb = zzbw.zzf.zzb();
        zzi().zzf();
        try {
            zzg zzgVarZzb = zzi().zzb(str);
            if (zzgVarZzb == null) {
                zzr().zzw().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzgVarZzb.zzr()) {
                zzr().zzw().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzbw.zzg.zza zzaVarZza = zzbw.zzg.zzbf().zza(1).zza("android");
            if (!TextUtils.isEmpty(zzgVarZzb.zzc())) {
                zzaVarZza.zzf(zzgVarZzb.zzc());
            }
            if (!TextUtils.isEmpty(zzgVarZzb.zzn())) {
                zzaVarZza.zze(zzgVarZzb.zzn());
            }
            if (!TextUtils.isEmpty(zzgVarZzb.zzl())) {
                zzaVarZza.zzg(zzgVarZzb.zzl());
            }
            if (zzgVarZzb.zzm() != -2147483648L) {
                zzaVarZza.zzh((int) zzgVarZzb.zzm());
            }
            zzaVarZza.zzf(zzgVarZzb.zzo()).zzk(zzgVarZzb.zzq());
            if (zzle.zzb() && zzt().zze(zzgVarZzb.zzc(), zzas.zzbo)) {
                if (!TextUtils.isEmpty(zzgVarZzb.zze())) {
                    zzaVarZza.zzk(zzgVarZzb.zze());
                } else if (!TextUtils.isEmpty(zzgVarZzb.zzg())) {
                    zzaVarZza.zzp(zzgVarZzb.zzg());
                } else if (!TextUtils.isEmpty(zzgVarZzb.zzf())) {
                    zzaVarZza.zzo(zzgVarZzb.zzf());
                }
            } else if (!TextUtils.isEmpty(zzgVarZzb.zze())) {
                zzaVarZza.zzk(zzgVarZzb.zze());
            } else if (!TextUtils.isEmpty(zzgVarZzb.zzf())) {
                zzaVarZza.zzo(zzgVarZzb.zzf());
            }
            zzaVarZza.zzh(zzgVarZzb.zzp());
            if (this.zzz.zzab() && zzt().zzf(zzaVarZza.zzj())) {
                zzaVarZza.zzj();
                if (!TextUtils.isEmpty(null)) {
                    zzaVarZza.zzn(null);
                }
            }
            Pair<String, Boolean> pairZza = zzs().zza(zzgVarZzb.zzc());
            if (zzgVarZzb.zzaf() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                zzaVarZza.zzh(zza((String) pairZza.first, Long.toString(zzaqVar.zzd)));
                if (pairZza.second != null) {
                    zzaVarZza.zza(((Boolean) pairZza.second).booleanValue());
                }
            }
            zzl().zzaa();
            zzbw.zzg.zza zzaVarZzc = zzaVarZza.zzc(Build.MODEL);
            zzl().zzaa();
            zzaVarZzc.zzb(Build.VERSION.RELEASE).zzf((int) zzl().zzf()).zzd(zzl().zzg());
            zzaVarZza.zzi(zza(zzgVarZzb.zzd(), Long.toString(zzaqVar.zzd)));
            if (!TextUtils.isEmpty(zzgVarZzb.zzi())) {
                zzaVarZza.zzl(zzgVarZzb.zzi());
            }
            String strZzc = zzgVarZzb.zzc();
            List<zzkp> listZza = zzi().zza(strZzc);
            Iterator<zzkp> it = listZza.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if ("_lte".equals(next.zzc)) {
                    break;
                }
            }
            if (next == null || next.zze == null) {
                zzkp zzkpVar = new zzkp(strZzc, "auto", "_lte", zzm().currentTimeMillis(), 0L);
                listZza.add(zzkpVar);
                zzi().zza(zzkpVar);
            }
            zzkk zzkkVarZzg = zzg();
            zzkkVarZzg.zzr().zzx().zza("Checking account type status for ad personalization signals");
            if (zzkkVarZzg.zzl().zzj()) {
                String strZzc2 = zzgVarZzb.zzc();
                if (zzgVarZzb.zzaf() && zzkkVarZzg.zzj().zze(strZzc2)) {
                    zzkkVarZzg.zzr().zzw().zza("Turning off ad personalization due to account type");
                    Iterator<zzkp> it2 = listZza.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if ("_npa".equals(it2.next().zzc)) {
                            it2.remove();
                            break;
                        }
                    }
                    listZza.add(new zzkp(strZzc2, "auto", "_npa", zzkkVarZzg.zzm().currentTimeMillis(), 1L));
                }
            }
            zzbw.zzk[] zzkVarArr = new zzbw.zzk[listZza.size()];
            for (int i = 0; i < listZza.size(); i++) {
                zzbw.zzk.zza zzaVarZza2 = zzbw.zzk.zzj().zza(listZza.get(i).zzc).zza(listZza.get(i).zzd);
                zzg().zza(zzaVarZza2, listZza.get(i).zze);
                zzkVarArr[i] = (zzbw.zzk) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZza2.zzu());
            }
            zzaVarZza.zzb(Arrays.asList(zzkVarArr));
            Bundle bundleZzb = zzaqVar.zzb.zzb();
            bundleZzb.putLong("_c", 1L);
            zzr().zzw().zza("Marking in-app purchase as real-time");
            bundleZzb.putLong("_r", 1L);
            bundleZzb.putString("_o", zzaqVar.zzc);
            if (zzp().zzf(zzaVarZza.zzj())) {
                zzp().zza(bundleZzb, "_dbg", (Object) 1L);
                zzp().zza(bundleZzb, "_r", (Object) 1L);
            }
            zzam zzamVarZza2 = zzi().zza(str, zzaqVar.zza);
            if (zzamVarZza2 == null) {
                zzgVar = zzgVarZzb;
                zzaVar = zzaVarZza;
                zzaVar2 = zzaVarZzb;
                bundle = bundleZzb;
                bArr = null;
                zzamVarZza = new zzam(str, zzaqVar.zza, 0L, 0L, zzaqVar.zzd, 0L, null, null, null, null);
                j = 0;
            } else {
                zzgVar = zzgVarZzb;
                zzaVar = zzaVarZza;
                zzaVar2 = zzaVarZzb;
                bundle = bundleZzb;
                bArr = null;
                j = zzamVarZza2.zzf;
                zzamVarZza = zzamVarZza2.zza(zzaqVar.zzd);
            }
            zzi().zza(zzamVarZza);
            zzaj zzajVar = new zzaj(this.zzz, zzaqVar.zzc, str, zzaqVar.zza, zzaqVar.zzd, j, bundle);
            zzbw.zzc.zza zzaVarZzb2 = zzbw.zzc.zzj().zza(zzajVar.zzc).zza(zzajVar.zzb).zzb(zzajVar.zzd);
            for (String str2 : zzajVar.zze) {
                zzbw.zze.zza zzaVarZza3 = zzbw.zze.zzk().zza(str2);
                zzg().zza(zzaVarZza3, zzajVar.zze.zza(str2));
                zzaVarZzb2.zza(zzaVarZza3);
            }
            zzbw.zzg.zza zzaVar3 = zzaVar;
            zzaVar3.zza(zzaVarZzb2).zza(zzbw.zzh.zza().zza(zzbw.zzd.zza().zza(zzamVarZza.zzc).zza(zzaqVar.zza)));
            zzaVar3.zzc(e_().zza(zzgVar.zzc(), Collections.emptyList(), zzaVar3.zzd(), Long.valueOf(zzaVarZzb2.zzf()), Long.valueOf(zzaVarZzb2.zzf())));
            if (zzaVarZzb2.zze()) {
                zzaVar3.zzb(zzaVarZzb2.zzf()).zzc(zzaVarZzb2.zzf());
            }
            long jZzk = zzgVar.zzk();
            if (jZzk != 0) {
                zzaVar3.zze(jZzk);
            }
            long jZzj = zzgVar.zzj();
            if (jZzj != 0) {
                zzaVar3.zzd(jZzj);
            } else if (jZzk != 0) {
                zzaVar3.zzd(jZzk);
            }
            zzgVar.zzv();
            zzaVar3.zzg((int) zzgVar.zzs()).zzg(zzt().zzf()).zza(zzm().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
            zzbw.zzf.zza zzaVar4 = zzaVar2;
            zzaVar4.zza(zzaVar3);
            zzg zzgVar2 = zzgVar;
            zzgVar2.zza(zzaVar3.zzf());
            zzgVar2.zzb(zzaVar3.zzg());
            zzi().zza(zzgVar2);
            zzi().b_();
            try {
                return zzg().zzc(((zzbw.zzf) ((com.google.android.gms.internal.measurement.zzfi) zzaVar4.zzu())).zzbi());
            } catch (IOException e) {
                zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzet.zza(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            zzr().zzw().zza("app instance id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzr().zzw().zza("Resettable device id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzi().zzh();
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
