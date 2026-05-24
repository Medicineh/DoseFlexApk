package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaf {
    private static Set<String> zza(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    static void zza(zzet zzetVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzetVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzetVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            if (zzetVar == null) {
                throw new IllegalArgumentException("Monitor must not be null");
            }
            Set<String> setZza = zza(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setZza.remove(str4)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                    sb.append("Table ");
                    sb.append(str);
                    sb.append(" is missing required column: ");
                    sb.append(str4);
                    throw new SQLiteException(sb.toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!setZza.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (setZza.isEmpty()) {
                return;
            }
            zzetVar.zzi().zza("Table has extra columns. table, columns", str, TextUtils.join(", ", setZza));
        } catch (SQLiteException e) {
            zzetVar.zzf().zza("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    private static boolean zza(zzet zzetVar, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzetVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return zMoveToFirst;
            } catch (SQLiteException e) {
                zzetVar.zzi().zza("Error querying for table", str, e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    static void zza(zzet zzetVar, SQLiteDatabase sQLiteDatabase) {
        if (zzetVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzetVar.zzi().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzetVar.zzi().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzetVar.zzi().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzetVar.zzi().zza("Failed to turn on database write permission for owner");
    }
}
