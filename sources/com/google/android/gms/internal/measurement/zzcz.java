package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcz implements zzcg {
    private static final Map<String, zzcz> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private volatile Map<String, ?> zze;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.zzcy
        private final zzcz zza;

        {
            this.zza = this;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.zza.zza(sharedPreferences, str);
        }
    };
    private final Object zzd = new Object();
    private final List<zzch> zzf = new ArrayList();

    static zzcz zza(Context context, String str) {
        zzcz zzczVar;
        if (!((!zzcd.zza() || str.startsWith("direct_boot:")) ? true : zzcd.zza(context))) {
            return null;
        }
        synchronized (zzcz.class) {
            zzczVar = zza.get(str);
            if (zzczVar == null) {
                zzczVar = new zzcz(zzb(context, str));
                zza.put(str, zzczVar);
            }
        }
        return zzczVar;
    }

    private static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzcd.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            return context.getSharedPreferences(str, 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private zzcz(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzcg
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zza() {
        for (zzcz zzczVar : zza.values()) {
            zzczVar.zzb.unregisterOnSharedPreferenceChangeListener(zzczVar.zzc);
        }
        zza.clear();
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzcq.zza();
        }
        synchronized (this) {
            Iterator<zzch> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }
}
