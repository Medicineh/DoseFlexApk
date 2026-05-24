package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcp {
    public static zzdd<zzcm> zza(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && ((str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            z = true;
        }
        if (!z) {
            return zzdd.zzc();
        }
        if (zzcd.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzdd<File> zzddVarZzb = zzb(context);
        return zzddVarZzb.zza() ? zzdd.zza(zza(zzddVarZzb.zzb())) : zzdd.zzc();
    }

    private static zzdd<File> zzb(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? zzdd.zza(file) : zzdd.zzc();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return zzdd.zzc();
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static zzcm zza(File file) {
        BufferedReader bufferedReader;
        HashMap map;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                map = new HashMap();
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] strArrSplit = line.split(" ", 3);
                if (strArrSplit.length != 3) {
                    String strValueOf = String.valueOf(line);
                    Log.e("HermeticFileOverrides", strValueOf.length() != 0 ? "Invalid: ".concat(strValueOf) : new String("Invalid: "));
                } else {
                    String str = strArrSplit[0];
                    String strDecode = Uri.decode(strArrSplit[1]);
                    String strDecode2 = Uri.decode(strArrSplit[2]);
                    if (!map.containsKey(str)) {
                        map.put(str, new HashMap());
                    }
                    ((Map) map.get(str)).put(strDecode, strDecode2);
                }
            } else {
                String strValueOf2 = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf2).length() + 7);
                sb.append("Parsed ");
                sb.append(strValueOf2);
                Log.i("HermeticFileOverrides", sb.toString());
                zzcm zzcmVar = new zzcm(map);
                bufferedReader.close();
                return zzcmVar;
            }
            throw new RuntimeException(e);
        }
    }
}
