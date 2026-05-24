package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzab extends zzkd {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzag zzj;
    private final zzjz zzk;

    zzab(zzkg zzkgVar) {
        super(zzkgVar);
        this.zzk = new zzjz(zzm());
        this.zzj = new zzag(this, zzn(), "google_app_measurement.db");
    }

    @Override // com.google.android.gms.measurement.internal.zzkd
    protected final boolean zze() {
        return false;
    }

    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x014c: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:66:0x014c */
    public final zzam zza(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        Cursor cursor3 = null;
        try {
            try {
                cursorQuery = c_().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    long j2 = cursorQuery.getLong(1);
                    long j3 = cursorQuery.getLong(2);
                    long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    }
                    cursor2 = cursorQuery;
                    try {
                        zzam zzamVar = new zzam(str, str2, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursor2.moveToNext()) {
                            zzr().zzf().zza("Got multiple records for event aggregates, expected one. appId", zzet.zza(str));
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return zzamVar;
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursorQuery = cursor2;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
        }
        zzr().zzf().zza("Error querying events. appId", zzet.zza(str), zzo().zza(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final void zza(zzam zzamVar) {
        Preconditions.checkNotNull(zzamVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzamVar.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzamVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzamVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzamVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzamVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzamVar.zzg));
        contentValues.put("last_bundled_day", zzamVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzamVar.zzi);
        contentValues.put("last_sampling_rate", zzamVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzamVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzamVar.zzk == null || !zzamVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzet.zza(zzamVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzet.zza(zzamVar.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user property. appId", zzet.zza(str), zzo().zzc(str2), e);
        }
    }

    public final boolean zza(zzkp zzkpVar) {
        Preconditions.checkNotNull(zzkpVar);
        zzd();
        zzak();
        if (zzc(zzkpVar.zza, zzkpVar.zzc) == null) {
            if (zzko.zza(zzkpVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkpVar.zza}) >= zzt().zzc(zzkpVar.zza)) {
                    return false;
                }
            } else if (!"_npa".equals(zzkpVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkpVar.zza, zzkpVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkpVar.zza);
        contentValues.put("origin", zzkpVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzkpVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkpVar.zzd));
        zza(contentValues, "value", zzkpVar.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzet.zza(zzkpVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzet.zza(zzkpVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzkp zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzd()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.c_()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            if (r3 != 0) goto L3f
            if (r10 == 0) goto L3e
            r10.close()
        L3e:
            return r9
        L3f:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzkp r0 = new com.google.android.gms.measurement.internal.zzkp     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            if (r1 == 0) goto L6e
            com.google.android.gms.measurement.internal.zzet r1 = r18.zzr()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
        L6e:
            if (r10 == 0) goto L73
            r10.close()
        L73:
            return r0
        L74:
            r0 = move-exception
            goto L86
        L76:
            r0 = move-exception
            r11 = r18
            goto La6
        L7a:
            r0 = move-exception
            r11 = r18
            goto L86
        L7e:
            r0 = move-exception
            r11 = r18
            goto La7
        L82:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L86:
            com.google.android.gms.measurement.internal.zzet r1 = r18.zzr()     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch: java.lang.Throwable -> La5
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza(r19)     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzer r4 = r18.zzo()     // Catch: java.lang.Throwable -> La5
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> La5
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La5
            if (r10 == 0) goto La4
            r10.close()
        La4:
            return r9
        La5:
            r0 = move-exception
        La6:
            r9 = r10
        La7:
            if (r9 == 0) goto Lac
            r9.close()
        Lac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkp");
    }

    public final List<zzkp> zza(String str) throws Throwable {
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursorQuery = c_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return arrayList;
                    }
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursorQuery.getLong(2);
                        Object objZza = zza(cursorQuery, 3);
                        if (objZza == null) {
                            zzr().zzf().zza("Read invalid user property value, ignoring it. appId", zzet.zza(str));
                        } else {
                            arrayList.add(new zzkp(str, str2, string, j, objZza));
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error querying user properties. appId", zzet.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
            th = th;
            cursor = cursorQuery;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0090, code lost:
    
        zzr().zzf().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkp> zza(java.lang.String r22, java.lang.String r23, java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zza(zzy zzyVar) {
        Preconditions.checkNotNull(zzyVar);
        zzd();
        zzak();
        if (zzc(zzyVar.zza, zzyVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzyVar.zza}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzyVar.zza);
        contentValues.put("origin", zzyVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzyVar.zzc.zza);
        zza(contentValues, "value", zzyVar.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzyVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzyVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzyVar.zzh));
        zzp();
        contentValues.put("timed_out_event", zzko.zza((Parcelable) zzyVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzyVar.zzd));
        zzp();
        contentValues.put("triggered_event", zzko.zza((Parcelable) zzyVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzyVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzyVar.zzj));
        zzp();
        contentValues.put("expired_event", zzko.zza((Parcelable) zzyVar.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzet.zza(zzyVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzet.zza(zzyVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzy zzd(java.lang.String r30, java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzy");
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzet.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    public final List<zzy> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
    
        zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzy> zza(java.lang.String r25, java.lang.String[] r26) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzg zzb(java.lang.String r35) {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    public final void zza(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzc());
        contentValues.put("app_instance_id", zzgVar.zzd());
        contentValues.put("gmp_app_id", zzgVar.zze());
        contentValues.put("resettable_device_id_hash", zzgVar.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzk()));
        contentValues.put("app_version", zzgVar.zzl());
        contentValues.put("app_store", zzgVar.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzr()));
        contentValues.put("day", Long.valueOf(zzgVar.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzm()));
        contentValues.put("firebase_instance_id", zzgVar.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzaa()));
        contentValues.put("health_monitor_sample", zzgVar.zzac());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzgVar.zzag()));
        contentValues.put("admob_app_id", zzgVar.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzq()));
        if (zzgVar.zzai() != null) {
            if (zzgVar.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzgVar.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzgVar.zzai()));
            }
        }
        if (zzle.zzb() && zzt().zze(zzgVar.zzc(), zzas.zzbo)) {
            contentValues.put("ga_app_id", zzgVar.zzg());
        }
        try {
            SQLiteDatabase sQLiteDatabaseC_ = c_();
            if (sQLiteDatabaseC_.update("apps", contentValues, "app_id = ?", new String[]{zzgVar.zzc()}) == 0 && sQLiteDatabaseC_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzet.zza(zzgVar.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzet.zza(zzgVar.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzas.zzo))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzet.zza(str), e);
            return 0L;
        }
    }

    public final zzae zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1L, false, false, z3, false, z5);
    }

    public final zzae zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzae zzaeVar = new zzae();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseC_ = c_();
                Cursor cursorQuery = sQLiteDatabaseC_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzet.zza(str));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzaeVar;
                }
                if (cursorQuery.getLong(0) == j) {
                    zzaeVar.zzb = cursorQuery.getLong(1);
                    zzaeVar.zza = cursorQuery.getLong(2);
                    zzaeVar.zzc = cursorQuery.getLong(3);
                    zzaeVar.zzd = cursorQuery.getLong(4);
                    zzaeVar.zze = cursorQuery.getLong(5);
                }
                if (z) {
                    zzaeVar.zzb += j2;
                }
                if (z2) {
                    zzaeVar.zza += j2;
                }
                if (z3) {
                    zzaeVar.zzc += j2;
                }
                if (z4) {
                    zzaeVar.zzd += j2;
                }
                if (z5) {
                    zzaeVar.zze += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaeVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzaeVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaeVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaeVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaeVar.zze));
                sQLiteDatabaseC_.update("apps", contentValues, "app_id=?", strArr);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return zzaeVar;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error updating daily counts. appId", zzet.zza(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaeVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final byte[] zzd(String str) throws Throwable {
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        Cursor cursor = null;
        try {
            cursorQuery = c_().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    if (cursorQuery.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for app config, expected one. appId", zzet.zza(str));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return blob;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error querying remote config. appId", zzet.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
            th = th;
            cursor = cursorQuery;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public final boolean zza(zzbw.zzg zzgVar, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        Preconditions.checkState(zzgVar.zzk());
        zzv();
        long jCurrentTimeMillis = zzm().currentTimeMillis();
        if (zzgVar.zzl() < jCurrentTimeMillis - zzaa.zzk() || zzgVar.zzl() > zzaa.zzk() + jCurrentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzet.zza(zzgVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgVar.zzl()));
        }
        try {
            byte[] bArrZzc = zzg().zzc(zzgVar.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(bArrZzc.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zzl()));
            contentValues.put("data", bArrZzc);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzba()));
            }
            try {
                if (c_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzet.zza(zzgVar.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzet.zza(zzgVar.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzet.zza(zzgVar.zzx()), e2);
            return false;
        }
    }

    public final String d_() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = c_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            th = th2;
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final List<Pair<zzbw.zzg, Long>> zza(String str, int i, int i2) {
        byte[] bArrZzb;
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzbw.zzg, Long>> listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrZzb = zzg().zzb(cursorQuery.getBlob(1));
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to unzip queued bundle. appId", zzet.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && bArrZzb.length + length > i2) {
                        break;
                    }
                    try {
                        zzbw.zzg.zza zzaVar = (zzbw.zzg.zza) zzkk.zza(zzbw.zzg.zzbf(), bArrZzb);
                        if (!cursorQuery.isNull(2)) {
                            zzaVar.zzi(cursorQuery.getInt(2));
                        }
                        length += bArrZzb.length;
                        arrayList.add(Pair.create((zzbw.zzg) ((com.google.android.gms.internal.measurement.zzfi) zzaVar.zzu()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzet.zza(str), e2);
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                } while (length <= i2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzr().zzf().zza("Error querying bundles. appId", zzet.zza(str), e3);
                List<Pair<zzbw.zzg, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final void zzv() {
        int iDelete;
        zzd();
        zzak();
        if (zzam()) {
            long jZza = zzs().zzf.zza();
            long jElapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzas.zzx.zza(null).longValue()) {
                zzs().zzf.zza(jElapsedRealtime);
                zzd();
                zzak();
                if (!zzam() || (iDelete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzaa.zzk())})) <= 0) {
                    return;
                }
                zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb2.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseC_ = c_();
                StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseC_.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbo.zzb zzbVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzc())) {
            zzr().zzi().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzet.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbi = zzbVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzc());
        contentValues.put("session_scoped", zzbVar.zzj() ? Boolean.valueOf(zzbVar.zzk()) : null);
        contentValues.put("data", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzet.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzet.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbo.zze zzeVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzc())) {
            zzr().zzi().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzet.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbi = zzeVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null);
        contentValues.put("property_name", zzeVar.zzc());
        contentValues.put("session_scoped", zzeVar.zzg() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzet.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzet.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbo.zzb>> zzf(java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzbo$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbo.zzb.zzl()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgs r1 = com.google.android.gms.measurement.internal.zzkk.zza(r2, r1)     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzbo$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbo.zzb.zza) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgt r1 = r1.zzu()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzbo$zzb r1 = (com.google.android.gms.internal.measurement.zzbo.zzb) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r3 != 0) goto L74
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L74:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            goto L8a
        L78:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzet r2 = r12.zzr()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L8a:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            if (r14 == 0) goto L95
            r14.close()
        L95:
            return r0
        L96:
            r0 = move-exception
            goto L9c
        L98:
            r13 = move-exception
            goto Lb5
        L9a:
            r0 = move-exception
            r14 = r9
        L9c:
            com.google.android.gms.measurement.internal.zzet r1 = r12.zzr()     // Catch: java.lang.Throwable -> Lb3
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza(r13)     // Catch: java.lang.Throwable -> Lb3
            r1.zza(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb3
            if (r14 == 0) goto Lb2
            r14.close()
        Lb2:
            return r9
        Lb3:
            r13 = move-exception
            r9 = r14
        Lb5:
            if (r9 == 0) goto Lba
            r9.close()
        Lba:
            goto Lbc
        Lbb:
            throw r13
        Lbc:
            goto Lbb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    final Map<Integer, List<zzbo.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzbo.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzbo.zzb zzbVar = (zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfi) ((zzbo.zzb.zza) zzkk.zza(zzbo.zzb.zzl(), cursorQuery.getBlob(1))).zzu());
                        if (zzbVar.zzf()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge filter. appId", zzet.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzet.zza(str), e2);
            Map<Integer, List<zzbo.zzb>> mapEmptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return mapEmptyMap2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbo.zze>> zzg(java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzbo$zze$zza r2 = com.google.android.gms.internal.measurement.zzbo.zze.zzi()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgs r1 = com.google.android.gms.measurement.internal.zzkk.zza(r2, r1)     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzbo$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbo.zze.zza) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzgt r1 = r1.zzu()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.internal.measurement.zzbo$zze r1 = (com.google.android.gms.internal.measurement.zzbo.zze) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r3 != 0) goto L74
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L74:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            goto L8a
        L78:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzet r2 = r12.zzr()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
        L8a:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lb3
            if (r1 != 0) goto L42
            if (r14 == 0) goto L95
            r14.close()
        L95:
            return r0
        L96:
            r0 = move-exception
            goto L9c
        L98:
            r13 = move-exception
            goto Lb5
        L9a:
            r0 = move-exception
            r14 = r9
        L9c:
            com.google.android.gms.measurement.internal.zzet r1 = r12.zzr()     // Catch: java.lang.Throwable -> Lb3
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza(r13)     // Catch: java.lang.Throwable -> Lb3
            r1.zza(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb3
            if (r14 == 0) goto Lb2
            r14.close()
        Lb2:
            return r9
        Lb3:
            r13 = move-exception
            r9 = r14
        Lb5:
            if (r9 == 0) goto Lba
            r9.close()
        Lba:
            goto Lbc
        Lbb:
            throw r13
        Lbc:
            goto Lbb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzak()
            r7.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6b
        L67:
            r8 = move-exception
            goto L84
        L69:
            r0 = move-exception
            r1 = r2
        L6b:
            com.google.android.gms.measurement.internal.zzet r3 = r7.zzr()     // Catch: java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza(r8)     // Catch: java.lang.Throwable -> L82
            r3.zza(r4, r8, r0)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L81
            r1.close()
        L81:
            return r2
        L82:
            r8 = move-exception
            r2 = r1
        L84:
            if (r2 == 0) goto L89
            r2.close()
        L89:
            goto L8b
        L8a:
            throw r8
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzf(java.lang.String):java.util.Map");
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zzt().zzb(str, zzas.zzae)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 140);
            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb2.append(string);
            sb2.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseC_.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzet.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzbw.zzi> zzg(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            r11.zzak()
            r11.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r10 = 0
            r4[r10] = r12     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r1 != 0) goto L33
            if (r0 == 0) goto L32
            r0.close()
        L32:
            return r8
        L33:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
        L38:
            int r2 = r0.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            byte[] r3 = r0.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r4 = com.google.android.gms.internal.measurement.zzbw.zzi.zzi()     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzgs r3 = com.google.android.gms.measurement.internal.zzkk.zza(r4, r3)     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzbw.zzi.zza) r3     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzgt r3 = r3.zzu()     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzfi r3 = (com.google.android.gms.internal.measurement.zzfi) r3     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.internal.measurement.zzbw$zzi r3 = (com.google.android.gms.internal.measurement.zzbw.zzi) r3     // Catch: java.io.IOException -> L5a android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            goto L70
        L5a:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzet r4 = r11.zzr()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r4.zza(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
        L70:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r2 != 0) goto L38
            if (r0 == 0) goto L7b
            r0.close()
        L7b:
            return r1
        L7c:
            r1 = move-exception
            goto L82
        L7e:
            r12 = move-exception
            goto L9b
        L80:
            r1 = move-exception
            r0 = r8
        L82:
            com.google.android.gms.measurement.internal.zzet r2 = r11.zzr()     // Catch: java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza(r12)     // Catch: java.lang.Throwable -> L99
            r2.zza(r3, r12, r1)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L98
            r0.close()
        L98:
            return r8
        L99:
            r12 = move-exception
            r8 = r0
        L9b:
            if (r8 == 0) goto La0
            r8.close()
        La0:
            goto La2
        La1:
            throw r12
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzg(java.lang.String):java.util.Map");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    protected final long zzh(String str, String str2) throws Throwable {
        long jZza;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    jZza = zza(sb.toString(), new String[]{str}, -1L);
                } catch (SQLiteException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabaseC_.endTransaction();
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
        }
        if (jZza == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("first_open_count", (Integer) 0);
            contentValues.put("previous_install_count", (Integer) 0);
            if (sQLiteDatabaseC_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert column (got -1). appId", zzet.zza(str), str2);
                sQLiteDatabaseC_.endTransaction();
                return -1L;
            }
            jZza = 0;
            zzr().zzf().zza("Error inserting column. appId", zzet.zza(str), str2, e);
            sQLiteDatabaseC_.endTransaction();
            return j;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put(str2, Long.valueOf(1 + jZza));
            if (sQLiteDatabaseC_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                zzr().zzf().zza("Failed to update column (got 0). appId", zzet.zza(str), str2);
                sQLiteDatabaseC_.endTransaction();
                return -1L;
            }
            sQLiteDatabaseC_.setTransactionSuccessful();
            sQLiteDatabaseC_.endTransaction();
            return jZza;
        } catch (SQLiteException e3) {
            e = e3;
            j = jZza;
        }
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zza(zzbw.zzg zzgVar) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        byte[] bArrZzbi = zzgVar.zzbi();
        long jZza = zzg().zza(bArrZzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbi);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzet.zza(zzgVar.zzx()), e);
            throw e;
        }
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.zzd()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.c_()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzet r6 = r4.zzr()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzx()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            com.google.android.gms.measurement.internal.zzet r1 = r4.zzr()     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(long):java.lang.String");
    }

    public final long zzaa() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzbw.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzr()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzx()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r4 = com.google.android.gms.internal.measurement.zzbw.zzc.zzj()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgs r2 = com.google.android.gms.measurement.internal.zzkk.zza(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgt r2 = r2.zzu()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzet r3 = r7.zzr()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7d
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            r1 = r0
        L7d:
            com.google.android.gms.measurement.internal.zzet r9 = r7.zzr()     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzf()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            return r0
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            if (r0 == 0) goto L97
            r0.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzbw.zzc zzcVar) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbi = zzcVar.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(bArrZzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzet.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzet.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzaj zzajVar, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzajVar);
        Preconditions.checkNotEmpty(zzajVar.zza);
        zzbw.zzc.zza zzaVarZzb = zzbw.zzc.zzj().zzb(zzajVar.zzd);
        for (String str : zzajVar.zze) {
            zzbw.zze.zza zzaVarZza = zzbw.zze.zzk().zza(str);
            zzg().zza(zzaVarZza, zzajVar.zze.zza(str));
            zzaVarZzb.zza(zzaVarZza);
        }
        byte[] bArrZzbi = ((zzbw.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzb.zzu())).zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzajVar.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzajVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzajVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzet.zza(zzajVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzet.zza(zzajVar.zza), e);
            return false;
        }
    }

    final void zza(String str, List<zzbo.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbo.zza.C0005zza c0005zzaZzbm = list.get(i).zzbm();
            if (c0005zzaZzbm.zzb() != 0) {
                for (int i2 = 0; i2 < c0005zzaZzbm.zzb(); i2++) {
                    zzbo.zzb.zza zzaVarZzbm = c0005zzaZzbm.zzb(i2).zzbm();
                    zzbo.zzb.zza zzaVar = (zzbo.zzb.zza) ((zzfi.zzb) zzaVarZzbm.clone());
                    String strZzb = zzgw.zzb(zzaVarZzbm.zza());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzaVarZzbm.zzb(); i3++) {
                        zzbo.zzc zzcVarZza = zzaVarZzbm.zza(i3);
                        String strZza = zzgv.zza(zzcVarZza.zzh());
                        if (strZza != null) {
                            zzaVar.zza(i3, (zzbo.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzcVarZza.zzbm().zza(strZza).zzu()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        c0005zzaZzbm = c0005zzaZzbm.zza(i2, zzaVar);
                        list.set(i, (zzbo.zza) ((com.google.android.gms.internal.measurement.zzfi) c0005zzaZzbm.zzu()));
                    }
                }
            }
            if (c0005zzaZzbm.zza() != 0) {
                for (int i4 = 0; i4 < c0005zzaZzbm.zza(); i4++) {
                    zzbo.zze zzeVarZza = c0005zzaZzbm.zza(i4);
                    String strZza2 = zzgy.zza(zzeVarZza.zzc());
                    if (strZza2 != null) {
                        c0005zzaZzbm = c0005zzaZzbm.zza(i4, zzeVarZza.zzbm().zza(strZza2));
                        list.set(i, (zzbo.zza) ((com.google.android.gms.internal.measurement.zzfi) c0005zzaZzbm.zzu()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseC_2 = c_();
            sQLiteDatabaseC_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseC_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbo.zza zzaVar2 : list) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzet.zza(str));
                } else {
                    int iZzb = zzaVar2.zzb();
                    Iterator<zzbo.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzet.zza(str), Integer.valueOf(iZzb));
                                break;
                            }
                        } else {
                            Iterator<zzbo.zze> it2 = zzaVar2.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzet.zza(str), Integer.valueOf(iZzb));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbo.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, iZzb, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbo.zze> it4 = zzaVar2.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, iZzb, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseC_3 = c_();
                                        sQLiteDatabaseC_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                        sQLiteDatabaseC_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbo.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zza() ? Integer.valueOf(zzaVar3.zzb()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseC_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseC_.endTransaction();
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }
}
