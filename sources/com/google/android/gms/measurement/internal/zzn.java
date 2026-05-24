package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzn {
    private final zzfx zza;

    public zzn(zzfx zzfxVar) {
        this.zza = zzfxVar;
    }

    final void zza() {
        this.zza.zzq().zzd();
        if (zzd()) {
            if (zzc()) {
                this.zza.zzc().zzw.zza(null);
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.SOURCE, "(not set)");
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.zza.zzh().zza("auto", "_cmpx", bundle);
            } else {
                String strZza = this.zza.zzc().zzw.zza();
                if (TextUtils.isEmpty(strZza)) {
                    this.zza.zzr().zzg().zza("Cache still valid but referrer not found");
                } else {
                    long jZza = ((this.zza.zzc().zzx.zza() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strZza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jZza);
                    this.zza.zzh().zza((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.zza.zzc().zzw.zza(null);
            }
            this.zza.zzc().zzx.zza(0L);
        }
    }

    final void zza(String str, Bundle bundle) {
        String string;
        this.zza.zzq().zzd();
        if (this.zza.zzab()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.zza.zzc().zzw.zza(string);
        this.zza.zzc().zzx.zza(this.zza.zzm().currentTimeMillis());
    }

    final void zzb() {
        if (zzd() && zzc()) {
            this.zza.zzc().zzw.zza(null);
        }
    }

    private final boolean zzc() {
        return zzd() && this.zza.zzm().currentTimeMillis() - this.zza.zzc().zzx.zza() > this.zza.zzb().zza((String) null, zzas.zzcq);
    }

    private final boolean zzd() {
        return this.zza.zzc().zzx.zza() > 0;
    }
}
