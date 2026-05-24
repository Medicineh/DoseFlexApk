package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcc implements zzcg {
    private static final Map<Uri, zzcc> zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private volatile Map<String, String> zzf;
    private final ContentObserver zzd = new zzce(this, null);
    private final Object zze = new Object();
    private final List<zzch> zzg = new ArrayList();

    private zzcc(ContentResolver contentResolver, Uri uri) {
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, this.zzd);
    }

    public static zzcc zza(ContentResolver contentResolver, Uri uri) {
        zzcc zzccVar;
        synchronized (zzcc.class) {
            zzccVar = zza.get(uri);
            if (zzccVar == null) {
                try {
                    zzcc zzccVar2 = new zzcc(contentResolver, uri);
                    try {
                        zza.put(uri, zzccVar2);
                    } catch (SecurityException unused) {
                    }
                    zzccVar = zzccVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzccVar;
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzf;
        if (mapZze == null) {
            synchronized (this.zze) {
                mapZze = this.zzf;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzf = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzcq.zza();
        }
        synchronized (this) {
            Iterator<zzch> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzcj.zza(new zzci(this) { // from class: com.google.android.gms.internal.measurement.zzcf
                    private final zzcc zza;

                    {
                        this.zza = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzci
                    public final Object zza() {
                        return this.zza.zzd();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static synchronized void zzc() {
        for (zzcc zzccVar : zza.values()) {
            zzccVar.zzb.unregisterContentObserver(zzccVar.zzd);
        }
        zza.clear();
    }

    @Override // com.google.android.gms.internal.measurement.zzcg
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    final /* synthetic */ Map zzd() {
        Map map;
        Cursor cursorQuery = this.zzb.query(this.zzc, zzh, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }
}
