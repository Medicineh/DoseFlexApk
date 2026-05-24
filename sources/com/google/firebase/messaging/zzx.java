package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class zzx {
    private final SharedPreferences zza;
    private final String zzb;
    private final String zzc;
    private final Executor zze;
    private final ArrayDeque<String> zzd = new ArrayDeque<>();
    private boolean zzf = false;

    private zzx(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.zza = sharedPreferences;
        this.zzb = str;
        this.zzc = str2;
        this.zze = executor;
    }

    static zzx zza(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        zzx zzxVar = new zzx(sharedPreferences, str, str2, executor);
        synchronized (zzxVar.zzd) {
            zzxVar.zzd.clear();
            String string = zzxVar.zza.getString(zzxVar.zzb, "");
            if (!TextUtils.isEmpty(string) && string.contains(zzxVar.zzc)) {
                String[] strArrSplit = string.split(zzxVar.zzc, -1);
                if (strArrSplit.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str3 : strArrSplit) {
                    if (!TextUtils.isEmpty(str3)) {
                        zzxVar.zzd.add(str3);
                    }
                }
            }
        }
        return zzxVar;
    }

    public final boolean zza(String str) {
        boolean zZza;
        if (TextUtils.isEmpty(str) || str.contains(this.zzc)) {
            return false;
        }
        synchronized (this.zzd) {
            zZza = zza(this.zzd.add(str));
        }
        return zZza;
    }

    private final boolean zza(boolean z) {
        if (z) {
            this.zze.execute(new Runnable(this) { // from class: com.google.firebase.messaging.zzw
                private final zzx zza;

                {
                    this.zza = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        }
        return z;
    }

    public final boolean zza(Object obj) {
        boolean zZza;
        synchronized (this.zzd) {
            zZza = zza(this.zzd.remove(obj));
        }
        return zZza;
    }

    public final String zza() {
        String strPeek;
        synchronized (this.zzd) {
            strPeek = this.zzd.peek();
        }
        return strPeek;
    }

    final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            SharedPreferences.Editor editorEdit = this.zza.edit();
            String str = this.zzb;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.zzd.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(this.zzc);
            }
            editorEdit.putString(str, sb.toString()).commit();
        }
    }
}
