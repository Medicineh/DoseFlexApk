package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgc extends zzeo {
    private final zzkg zza;
    private Boolean zzb;
    private String zzc;

    public zzgc(zzkg zzkgVar) {
        this(zzkgVar, null);
    }

    private zzgc(zzkg zzkgVar, String str) {
        Preconditions.checkNotNull(zzkgVar);
        this.zza = zzkgVar;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zzb(zzm zzmVar) {
        zzb(zzmVar, false);
        zza(new zzgb(this, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzaq zzaqVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzaqVar);
        zzb(zzmVar, false);
        zza(new zzgk(this, zzaqVar, zzmVar));
    }

    final zzaq zzb(zzaq zzaqVar, zzm zzmVar) {
        boolean z = false;
        if ("_cmp".equals(zzaqVar.zza) && zzaqVar.zzb != null && zzaqVar.zzb.zza() != 0) {
            String strZzd = zzaqVar.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(strZzd) && (("referrer broadcast".equals(strZzd) || "referrer API".equals(strZzd)) && this.zza.zzb().zze(zzmVar.zza, zzas.zzar))) {
                z = true;
            }
        }
        if (!z) {
            return zzaqVar;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzaqVar.toString());
        return new zzaq("_cmpx", zzaqVar.zzb, zzaqVar.zzc, zzaqVar.zzd);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzaq zzaqVar, String str, String str2) {
        Preconditions.checkNotNull(zzaqVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzgj(this, zzaqVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final byte[] zza(zzaq zzaqVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaqVar);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzaqVar.zza));
        long jNanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgm(this, zzaqVar, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzet.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzaqVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzet.zza(str), this.zza.zzi().zza(zzaqVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzkn zzknVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzknVar);
        zzb(zzmVar, false);
        zza(new zzgl(this, zzknVar, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkn> zza(zzm zzmVar, boolean z) {
        zzb(zzmVar, false);
        try {
            List<zzkp> list = (List) this.zza.zzq().zza(new zzgo(this, zzmVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkp zzkpVar : list) {
                if (z || !zzko.zze(zzkpVar.zzc)) {
                    arrayList.add(new zzkn(zzkpVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user properties. appId", zzet.zza(zzmVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzm zzmVar) {
        zzb(zzmVar, false);
        zza(new zzgn(this, zzmVar));
    }

    private final void zzb(zzm zzmVar, boolean z) {
        Preconditions.checkNotNull(zzmVar);
        zza(zzmVar.zza, false);
        this.zza.zzj().zza(zzmVar.zzb, zzmVar.zzr, zzmVar.zzv);
    }

    private final void zza(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzr().zzf().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    this.zzb = Boolean.valueOf("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzet.zza(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(long j, String str, String str2, String str3) {
        zza(new zzgq(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final String zzc(zzm zzmVar) {
        zzb(zzmVar, false);
        return this.zza.zzd(zzmVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzy zzyVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzyVar);
        Preconditions.checkNotNull(zzyVar.zzc);
        zzb(zzmVar, false);
        zzy zzyVar2 = new zzy(zzyVar);
        zzyVar2.zza = zzmVar.zza;
        zza(new zzgp(this, zzyVar2, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zza(zzy zzyVar) {
        Preconditions.checkNotNull(zzyVar);
        Preconditions.checkNotNull(zzyVar.zzc);
        zza(zzyVar.zza, true);
        zza(new zzge(this, new zzy(zzyVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkn> zza(String str, String str2, boolean z, zzm zzmVar) {
        zzb(zzmVar, false);
        try {
            List<zzkp> list = (List) this.zza.zzq().zza(new zzgd(this, zzmVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkp zzkpVar : list) {
                if (z || !zzko.zze(zzkpVar.zzc)) {
                    arrayList.add(new zzkn(zzkpVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to query user properties. appId", zzet.zza(zzmVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkn> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzkp> list = (List) this.zza.zzq().zza(new zzgg(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkp zzkpVar : list) {
                if (z || !zzko.zze(zzkpVar.zzc)) {
                    arrayList.add(new zzkn(zzkpVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user properties as. appId", zzet.zza(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzy> zza(String str, String str2, zzm zzmVar) {
        zzb(zzmVar, false);
        try {
            return (List) this.zza.zzq().zza(new zzgf(this, zzmVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzy> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgi(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void zzd(zzm zzmVar) {
        zza(zzmVar.zza, false);
        zza(new zzgh(this, zzmVar));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }
}
