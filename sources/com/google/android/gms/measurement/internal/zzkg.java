package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class zzkg implements zzgu {
    private static volatile zzkg zza;
    private zzfr zzb;
    private zzfa zzc;
    private zzab zzd;
    private zzfd zze;
    private zzkc zzf;
    private zzq zzg;
    private final zzkk zzh;
    private zzig zzi;
    private final zzfx zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    class zza implements zzad {
        zzbw.zzg zza;
        List<Long> zzb;
        List<zzbw.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzad
        public final void zza(zzbw.zzg zzgVar) {
            Preconditions.checkNotNull(zzgVar);
            this.zza = zzgVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzad
        public final boolean zza(long j, zzbw.zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzcVar)) {
                return false;
            }
            long jZzbn = this.zzd + ((long) zzcVar.zzbn());
            if (jZzbn >= Math.max(0, zzas.zzh.zza(null).intValue())) {
                return false;
            }
            this.zzd = jZzbn;
            this.zzc.add(zzcVar);
            this.zzb.add(Long.valueOf(j));
            return this.zzc.size() < Math.max(1, zzas.zzi.zza(null).intValue());
        }

        private static long zza(zzbw.zzc zzcVar) {
            return ((zzcVar.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkg zzkgVar, zzkf zzkfVar) {
            this();
        }
    }

    public static zzkg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkg.class) {
                if (zza == null) {
                    zza = new zzkg(new zzkl(context));
                }
            }
        }
        return zza;
    }

    private zzkg(zzkl zzklVar) {
        this(zzklVar, null);
    }

    private zzkg(zzkl zzklVar, zzfx zzfxVar) {
        this.zzk = false;
        Preconditions.checkNotNull(zzklVar);
        this.zzj = zzfx.zza(zzklVar.zza, null, null);
        this.zzx = -1L;
        zzkk zzkkVar = new zzkk(this);
        zzkkVar.zzal();
        this.zzh = zzkkVar;
        zzfa zzfaVar = new zzfa(this);
        zzfaVar.zzal();
        this.zzc = zzfaVar;
        zzfr zzfrVar = new zzfr(this);
        zzfrVar.zzal();
        this.zzb = zzfrVar;
        this.zzj.zzq().zza(new zzkf(this, zzklVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzkl zzklVar) {
        this.zzj.zzq().zzd();
        zzab zzabVar = new zzab(this);
        zzabVar.zzal();
        this.zzd = zzabVar;
        this.zzj.zzb().zza(this.zzb);
        zzq zzqVar = new zzq(this);
        zzqVar.zzal();
        this.zzg = zzqVar;
        zzig zzigVar = new zzig(this);
        zzigVar.zzal();
        this.zzi = zzigVar;
        zzkc zzkcVar = new zzkc(this);
        zzkcVar.zzal();
        this.zzf = zzkcVar;
        this.zze = new zzfd(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    protected final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzv zzu() {
        return this.zzj.zzu();
    }

    public final zzaa zzb() {
        return this.zzj.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzet zzr() {
        return this.zzj.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzfu zzq() {
        return this.zzj.zzq();
    }

    public final zzfr zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzfa zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzab zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfd zzt() {
        zzfd zzfdVar = this.zze;
        if (zzfdVar != null) {
            return zzfdVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkc zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzq zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzig zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkk zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzer zzi() {
        return this.zzj.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final Context zzn() {
        return this.zzj.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzko zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkd zzkdVar) {
        if (zzkdVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkdVar.zzaj()) {
            return;
        }
        String strValueOf = String.valueOf(zzkdVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    private final long zzx() {
        long jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzff zzffVarZzc = this.zzj.zzc();
        zzffVarZzc.zzaa();
        zzffVarZzc.zzd();
        long jZza = zzffVarZzc.zzg.zza();
        if (jZza == 0) {
            jZza = 1 + ((long) zzffVarZzc.zzp().zzh().nextInt(86400000));
            zzffVarZzc.zzg.zza(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    final void zza(zzaq zzaqVar, String str) {
        zzg zzgVarZzb = zze().zzb(str);
        if (zzgVarZzb == null || TextUtils.isEmpty(zzgVarZzb.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzb = zzb(zzgVarZzb);
        if (boolZzb == null) {
            if (!"_ui".equals(zzaqVar.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzet.zza(str));
            }
        } else if (!boolZzb.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzet.zza(str));
            return;
        }
        zza(zzaqVar, new zzm(str, zzgVarZzb.zze(), zzgVarZzb.zzl(), zzgVarZzb.zzm(), zzgVarZzb.zzn(), zzgVarZzb.zzo(), zzgVarZzb.zzp(), (String) null, zzgVarZzb.zzr(), false, zzgVarZzb.zzi(), zzgVarZzb.zzae(), 0L, 0, zzgVarZzb.zzaf(), zzgVarZzb.zzag(), false, zzgVarZzb.zzf(), zzgVarZzb.zzah(), zzgVarZzb.zzq(), zzgVarZzb.zzai(), (zzle.zzb() && this.zzj.zzb().zze(zzgVarZzb.zzc(), zzas.zzbo)) ? zzgVarZzb.zzg() : null));
    }

    final void zza(zzaq zzaqVar, zzm zzmVar) {
        List<zzy> listZza;
        List<zzy> listZza2;
        List<zzy> listZza3;
        zzaq zzaqVar2 = zzaqVar;
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzw();
        zzk();
        String str = zzmVar.zza;
        long j = zzaqVar2.zzd;
        zzh();
        if (zzkk.zza(zzaqVar, zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            if (this.zzj.zzb().zze(str, zzas.zzbc) && zzmVar.zzu != null) {
                if (zzmVar.zzu.contains(zzaqVar2.zza)) {
                    Bundle bundleZzb = zzaqVar2.zzb.zzb();
                    bundleZzb.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.zza, new zzal(bundleZzb), zzaqVar2.zzc, zzaqVar2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.zza, zzaqVar2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzab zzabVarZze = zze();
                Preconditions.checkNotEmpty(str);
                zzabVarZze.zzd();
                zzabVarZze.zzak();
                if (j < 0) {
                    zzabVarZze.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzet.zza(str), Long.valueOf(j));
                    listZza = Collections.emptyList();
                } else {
                    listZza = zzabVarZze.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzy zzyVar : listZza) {
                    if (zzyVar != null) {
                        this.zzj.zzr().zzx().zza("User property timed out", zzyVar.zza, this.zzj.zzj().zzc(zzyVar.zzc.zza), zzyVar.zzc.zza());
                        if (zzyVar.zzg != null) {
                            zzb(new zzaq(zzyVar.zzg, j), zzmVar);
                        }
                        zze().zze(str, zzyVar.zzc.zza);
                    }
                }
                zzab zzabVarZze2 = zze();
                Preconditions.checkNotEmpty(str);
                zzabVarZze2.zzd();
                zzabVarZze2.zzak();
                if (j < 0) {
                    zzabVarZze2.zzr().zzi().zza("Invalid time querying expired conditional properties", zzet.zza(str), Long.valueOf(j));
                    listZza2 = Collections.emptyList();
                } else {
                    listZza2 = zzabVarZze2.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listZza2.size());
                for (zzy zzyVar2 : listZza2) {
                    if (zzyVar2 != null) {
                        this.zzj.zzr().zzx().zza("User property expired", zzyVar2.zza, this.zzj.zzj().zzc(zzyVar2.zzc.zza), zzyVar2.zzc.zza());
                        zze().zzb(str, zzyVar2.zzc.zza);
                        if (zzyVar2.zzk != null) {
                            arrayList.add(zzyVar2.zzk);
                        }
                        zze().zze(str, zzyVar2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzb(new zzaq((zzaq) obj, j), zzmVar);
                }
                zzab zzabVarZze3 = zze();
                String str2 = zzaqVar2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzabVarZze3.zzd();
                zzabVarZze3.zzak();
                if (j < 0) {
                    zzabVarZze3.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzet.zza(str), zzabVarZze3.zzo().zza(str2), Long.valueOf(j));
                    listZza3 = Collections.emptyList();
                } else {
                    listZza3 = zzabVarZze3.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(listZza3.size());
                for (zzy zzyVar3 : listZza3) {
                    if (zzyVar3 != null) {
                        zzkn zzknVar = zzyVar3.zzc;
                        zzkp zzkpVar = new zzkp(zzyVar3.zza, zzyVar3.zzb, zzknVar.zza, j, zzknVar.zza());
                        if (zze().zza(zzkpVar)) {
                            this.zzj.zzr().zzx().zza("User property triggered", zzyVar3.zza, this.zzj.zzj().zzc(zzkpVar.zzc), zzkpVar.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzet.zza(zzyVar3.zza), this.zzj.zzj().zzc(zzkpVar.zzc), zzkpVar.zze);
                        }
                        if (zzyVar3.zzi != null) {
                            arrayList3.add(zzyVar3.zzi);
                        }
                        zzyVar3.zzc = new zzkn(zzkpVar);
                        zzyVar3.zze = true;
                        zze().zza(zzyVar3);
                    }
                }
                zzb(zzaqVar2, zzmVar);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzb(new zzaq((zzaq) obj2, j), zzmVar);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03cd A[Catch: all -> 0x09f9, TRY_LEAVE, TryCatch #0 {all -> 0x09f9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:83:0x0276, B:85:0x0280, B:87:0x028e, B:92:0x02bf, B:94:0x02c5, B:96:0x02d3, B:98:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:114:0x038c, B:116:0x0396, B:120:0x03cd, B:124:0x03df, B:126:0x03f3, B:128:0x0403, B:130:0x0414, B:132:0x0446, B:134:0x044b, B:135:0x0464, B:139:0x0475, B:141:0x0489, B:143:0x048e, B:144:0x04a7, B:148:0x04ca, B:152:0x04ef, B:153:0x0508, B:156:0x0517, B:159:0x053a, B:160:0x0556, B:162:0x0560, B:164:0x056c, B:166:0x0572, B:167:0x057d, B:169:0x0589, B:170:0x05a0, B:172:0x05c7, B:175:0x05e0, B:178:0x0624, B:180:0x064c, B:182:0x0686, B:183:0x068b, B:185:0x0693, B:186:0x0698, B:188:0x06a0, B:189:0x06a5, B:191:0x06ae, B:192:0x06b4, B:194:0x06c1, B:195:0x06c6, B:197:0x06cc, B:199:0x06dc, B:201:0x06e6, B:203:0x06ee, B:204:0x06f3, B:206:0x06fd, B:208:0x0707, B:210:0x070f, B:216:0x072c, B:218:0x0734, B:219:0x0739, B:221:0x074e, B:223:0x0758, B:224:0x075b, B:226:0x0769, B:228:0x0773, B:230:0x0777, B:232:0x0782, B:244:0x07f0, B:246:0x0838, B:247:0x083d, B:249:0x0845, B:251:0x084e, B:252:0x0853, B:254:0x085f, B:256:0x08c3, B:257:0x08c8, B:258:0x08d4, B:260:0x08de, B:261:0x08e5, B:263:0x08ef, B:264:0x08f6, B:265:0x0901, B:267:0x0907, B:269:0x0938, B:270:0x0948, B:272:0x0950, B:273:0x0956, B:275:0x095c, B:284:0x09a4, B:286:0x09aa, B:289:0x09c6, B:278:0x096a, B:280:0x098f, B:288:0x09ae, B:233:0x078e, B:235:0x07a0, B:237:0x07a4, B:239:0x07b6, B:243:0x07ed, B:240:0x07d0, B:242:0x07d6, B:211:0x0715, B:213:0x071f, B:215:0x0727, B:179:0x063e, B:107:0x0325, B:108:0x0343, B:113:0x0371, B:112:0x0360, B:99:0x02e4, B:90:0x0298, B:91:0x02b5), top: B:296:0x01e7, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x09aa A[Catch: all -> 0x09f9, TryCatch #0 {all -> 0x09f9, blocks: (B:48:0x01e7, B:50:0x01f0, B:54:0x0201, B:58:0x020f, B:60:0x0219, B:65:0x0225, B:72:0x0237, B:75:0x0243, B:77:0x025a, B:83:0x0276, B:85:0x0280, B:87:0x028e, B:92:0x02bf, B:94:0x02c5, B:96:0x02d3, B:98:0x02df, B:100:0x02e9, B:102:0x02f4, B:105:0x02fb, B:114:0x038c, B:116:0x0396, B:120:0x03cd, B:124:0x03df, B:126:0x03f3, B:128:0x0403, B:130:0x0414, B:132:0x0446, B:134:0x044b, B:135:0x0464, B:139:0x0475, B:141:0x0489, B:143:0x048e, B:144:0x04a7, B:148:0x04ca, B:152:0x04ef, B:153:0x0508, B:156:0x0517, B:159:0x053a, B:160:0x0556, B:162:0x0560, B:164:0x056c, B:166:0x0572, B:167:0x057d, B:169:0x0589, B:170:0x05a0, B:172:0x05c7, B:175:0x05e0, B:178:0x0624, B:180:0x064c, B:182:0x0686, B:183:0x068b, B:185:0x0693, B:186:0x0698, B:188:0x06a0, B:189:0x06a5, B:191:0x06ae, B:192:0x06b4, B:194:0x06c1, B:195:0x06c6, B:197:0x06cc, B:199:0x06dc, B:201:0x06e6, B:203:0x06ee, B:204:0x06f3, B:206:0x06fd, B:208:0x0707, B:210:0x070f, B:216:0x072c, B:218:0x0734, B:219:0x0739, B:221:0x074e, B:223:0x0758, B:224:0x075b, B:226:0x0769, B:228:0x0773, B:230:0x0777, B:232:0x0782, B:244:0x07f0, B:246:0x0838, B:247:0x083d, B:249:0x0845, B:251:0x084e, B:252:0x0853, B:254:0x085f, B:256:0x08c3, B:257:0x08c8, B:258:0x08d4, B:260:0x08de, B:261:0x08e5, B:263:0x08ef, B:264:0x08f6, B:265:0x0901, B:267:0x0907, B:269:0x0938, B:270:0x0948, B:272:0x0950, B:273:0x0956, B:275:0x095c, B:284:0x09a4, B:286:0x09aa, B:289:0x09c6, B:278:0x096a, B:280:0x098f, B:288:0x09ae, B:233:0x078e, B:235:0x07a0, B:237:0x07a4, B:239:0x07b6, B:243:0x07ed, B:240:0x07d0, B:242:0x07d6, B:211:0x0715, B:213:0x071f, B:215:0x0727, B:179:0x063e, B:107:0x0325, B:108:0x0343, B:113:0x0371, B:112:0x0360, B:99:0x02e4, B:90:0x0298, B:91:0x02b5), top: B:296:0x01e7, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(com.google.android.gms.measurement.internal.zzaq r30, com.google.android.gms.measurement.internal.zzm r31) {
        /*
            Method dump skipped, instruction units count: 2565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzb(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzm):void");
    }

    final void zzl() {
        zzg zzgVarZzb;
        String strZzad;
        zzw();
        zzk();
        this.zzs = true;
        try {
            this.zzj.zzu();
            Boolean boolZzag = this.zzj.zzw().zzag();
            if (boolZzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
                return;
            }
            if (boolZzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                return;
            }
            if (this.zzm > 0) {
                zzz();
                return;
            }
            zzw();
            if (this.zzv != null) {
                this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                return;
            }
            if (!zzd().zzf()) {
                this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                zzz();
                return;
            }
            long jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
            int iZzb = this.zzj.zzb().zzb(null, zzas.zzap);
            long jZzv = jCurrentTimeMillis - zzaa.zzv();
            for (int i = 0; i < iZzb && zza((String) null, jZzv); i++) {
            }
            long jZza = this.zzj.zzc().zzc.zza();
            if (jZza != 0) {
                this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
            }
            String strD_ = zze().d_();
            if (!TextUtils.isEmpty(strD_)) {
                if (this.zzx == -1) {
                    this.zzx = zze().zzaa();
                }
                List<Pair<zzbw.zzg, Long>> listZza = zze().zza(strD_, this.zzj.zzb().zzb(strD_, zzas.zzf), Math.max(0, this.zzj.zzb().zzb(strD_, zzas.zzg)));
                if (!listZza.isEmpty()) {
                    Iterator<Pair<zzbw.zzg, Long>> it = listZza.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strZzad = null;
                            break;
                        }
                        zzbw.zzg zzgVar = (zzbw.zzg) it.next().first;
                        if (!TextUtils.isEmpty(zzgVar.zzad())) {
                            strZzad = zzgVar.zzad();
                            break;
                        }
                    }
                    if (strZzad != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= listZza.size()) {
                                break;
                            }
                            zzbw.zzg zzgVar2 = (zzbw.zzg) listZza.get(i2).first;
                            if (!TextUtils.isEmpty(zzgVar2.zzad()) && !zzgVar2.zzad().equals(strZzad)) {
                                listZza = listZza.subList(0, i2);
                                break;
                            }
                            i2++;
                        }
                    }
                    zzbw.zzf.zza zzaVarZzb = zzbw.zzf.zzb();
                    int size = listZza.size();
                    ArrayList arrayList = new ArrayList(listZza.size());
                    boolean zZzf = this.zzj.zzb().zzf(strD_);
                    for (int i3 = 0; i3 < size; i3++) {
                        zzbw.zzg.zza zzaVarZzbm = ((zzbw.zzg) listZza.get(i3).first).zzbm();
                        arrayList.add((Long) listZza.get(i3).second);
                        zzbw.zzg.zza zzaVarZza = zzaVarZzbm.zzg(this.zzj.zzb().zzf()).zza(jCurrentTimeMillis);
                        this.zzj.zzu();
                        zzaVarZza.zzb(false);
                        if (!zZzf) {
                            zzaVarZzbm.zzn();
                        }
                        if (this.zzj.zzb().zze(strD_, zzas.zzay)) {
                            zzaVarZzbm.zzl(zzh().zza(((zzbw.zzg) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu())).zzbi()));
                        }
                        zzaVarZzb.zza(zzaVarZzbm);
                    }
                    String strZza = this.zzj.zzr().zza(2) ? zzh().zza((zzbw.zzf) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzb.zzu())) : null;
                    zzh();
                    byte[] bArrZzbi = ((zzbw.zzf) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzb.zzu())).zzbi();
                    String strZza2 = zzas.zzp.zza(null);
                    try {
                        URL url = new URL(strZza2);
                        Preconditions.checkArgument(!arrayList.isEmpty());
                        if (this.zzv != null) {
                            this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                        } else {
                            this.zzv = new ArrayList(arrayList);
                        }
                        this.zzj.zzc().zzd.zza(jCurrentTimeMillis);
                        this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", size > 0 ? zzaVarZzb.zza(0).zzx() : "?", Integer.valueOf(bArrZzbi.length), strZza);
                        this.zzr = true;
                        zzfa zzfaVarZzd = zzd();
                        zzki zzkiVar = new zzki(this, strD_);
                        zzfaVarZzd.zzd();
                        zzfaVarZzd.zzak();
                        Preconditions.checkNotNull(url);
                        Preconditions.checkNotNull(bArrZzbi);
                        Preconditions.checkNotNull(zzkiVar);
                        zzfaVarZzd.zzq().zzb(new zzfe(zzfaVarZzd, strD_, url, bArrZzbi, null, zzkiVar));
                    } catch (MalformedURLException unused) {
                        this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzet.zza(strD_), strZza2);
                    }
                }
            } else {
                this.zzx = -1L;
                String strZza3 = zze().zza(jCurrentTimeMillis - zzaa.zzv());
                if (!TextUtils.isEmpty(strZza3) && (zzgVarZzb = zze().zzb(strZza3)) != null) {
                    zza(zzgVarZzb);
                }
            }
        } finally {
            this.zzs = false;
            zzaa();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0255 A[Catch: all -> 0x0f61, TRY_ENTER, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x025c A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x026a A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05b3 A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x068a A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0831 A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x08e5 A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0b9e A[Catch: all -> 0x0f61, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0bb1  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0bb4 A[Catch: all -> 0x0f61, TRY_LEAVE, TryCatch #2 {all -> 0x0f61, blocks: (B:3:0x000d, B:23:0x0086, B:102:0x0258, B:104:0x025c, B:110:0x026a, B:111:0x0293, B:114:0x02ab, B:117:0x02d3, B:119:0x030a, B:125:0x0320, B:127:0x032a, B:309:0x08ac, B:129:0x0350, B:132:0x0368, B:161:0x03cb, B:164:0x03d5, B:166:0x03e3, B:171:0x0434, B:167:0x0404, B:169:0x0413, B:175:0x0441, B:178:0x047a, B:180:0x04ab, B:182:0x04df, B:184:0x04e5, B:187:0x04f1, B:189:0x0526, B:190:0x0543, B:192:0x0549, B:194:0x0557, B:198:0x056d, B:195:0x0562, B:201:0x0574, B:203:0x057a, B:204:0x0598, B:206:0x05b3, B:207:0x05bf, B:210:0x05c9, B:216:0x05ec, B:213:0x05db, B:219:0x05f2, B:221:0x05fe, B:223:0x060a, B:239:0x0659, B:242:0x0676, B:244:0x068a, B:246:0x0697, B:249:0x06aa, B:251:0x06bc, B:253:0x06ca, B:298:0x0831, B:300:0x083b, B:302:0x0841, B:303:0x085b, B:305:0x086f, B:306:0x0889, B:308:0x0892, B:258:0x06f0, B:260:0x0700, B:263:0x0715, B:265:0x0727, B:267:0x0735, B:270:0x0748, B:272:0x0760, B:274:0x076c, B:277:0x077f, B:279:0x0793, B:281:0x07de, B:283:0x07e5, B:285:0x07eb, B:287:0x07f6, B:289:0x07fd, B:291:0x0803, B:293:0x080e, B:294:0x081f, B:227:0x062b, B:231:0x063f, B:233:0x0645, B:236:0x0650, B:139:0x038a, B:142:0x0394, B:145:0x039e, B:314:0x08c6, B:316:0x08d4, B:318:0x08dd, B:329:0x090f, B:319:0x08e5, B:321:0x08ee, B:323:0x08f4, B:326:0x0900, B:328:0x090a, B:332:0x0916, B:333:0x0922, B:335:0x0928, B:341:0x0941, B:342:0x094c, B:347:0x0959, B:351:0x0980, B:353:0x099f, B:355:0x09ad, B:357:0x09b3, B:359:0x09bd, B:360:0x09ef, B:362:0x09f5, B:364:0x0a03, B:368:0x0a0e, B:365:0x0a08, B:369:0x0a11, B:371:0x0a23, B:372:0x0a26, B:380:0x0a98, B:382:0x0ab4, B:383:0x0ac5, B:385:0x0ac9, B:387:0x0ad5, B:388:0x0ade, B:390:0x0ae2, B:392:0x0aea, B:393:0x0af9, B:394:0x0b04, B:400:0x0b44, B:401:0x0b4c, B:403:0x0b52, B:405:0x0b64, B:407:0x0b68, B:421:0x0b9e, B:424:0x0bb4, B:409:0x0b76, B:411:0x0b7a, B:413:0x0b84, B:415:0x0b88, B:348:0x095e, B:350:0x0964, B:49:0x0124, B:64:0x01bc, B:73:0x01f6, B:81:0x0215, B:87:0x022e, B:101:0x0255, B:41:0x00dd, B:52:0x012d), top: B:557:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0bdb A[Catch: all -> 0x0d97, TRY_ENTER, TryCatch #5 {all -> 0x0d97, blocks: (B:374:0x0a63, B:375:0x0a78, B:377:0x0a7e, B:468:0x0d57, B:396:0x0b0e, B:426:0x0bdb, B:428:0x0be7, B:430:0x0bfb, B:431:0x0c39, B:435:0x0c52, B:437:0x0c59, B:439:0x0c6a, B:441:0x0c6e, B:443:0x0c72, B:445:0x0c76, B:446:0x0c82, B:447:0x0c87, B:449:0x0c8d, B:451:0x0cad, B:452:0x0cb6, B:467:0x0d54, B:453:0x0cc9, B:455:0x0cd0, B:459:0x0cf4, B:461:0x0d20, B:462:0x0d2e, B:463:0x0d3e, B:465:0x0d44, B:456:0x0cdb, B:469:0x0d61, B:471:0x0d6e, B:472:0x0d75, B:473:0x0d7d, B:475:0x0d83), top: B:562:0x0a63 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0111 A[Catch: SQLiteException -> 0x0232, all -> 0x0f55, TRY_LEAVE, TryCatch #4 {all -> 0x0f55, blocks: (B:9:0x0035, B:20:0x007e, B:25:0x008b, B:26:0x008f, B:45:0x00ea, B:47:0x0111, B:51:0x0129, B:52:0x012d, B:53:0x013f, B:55:0x0145, B:56:0x0156, B:58:0x0162, B:60:0x0188, B:62:0x01a9, B:67:0x01c2, B:68:0x01cb, B:70:0x01d6, B:78:0x020d, B:77:0x01fc, B:59:0x0179, B:85:0x021b, B:99:0x0242, B:38:0x00d5, B:43:0x00e2), top: B:561:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129 A[Catch: SQLiteException -> 0x0232, all -> 0x0f55, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0f55, blocks: (B:9:0x0035, B:20:0x007e, B:25:0x008b, B:26:0x008f, B:45:0x00ea, B:47:0x0111, B:51:0x0129, B:52:0x012d, B:53:0x013f, B:55:0x0145, B:56:0x0156, B:58:0x0162, B:60:0x0188, B:62:0x01a9, B:67:0x01c2, B:68:0x01cb, B:70:0x01d6, B:78:0x020d, B:77:0x01fc, B:59:0x0179, B:85:0x021b, B:99:0x0242, B:38:0x00d5, B:43:0x00e2), top: B:561:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0f44  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0f5b A[Catch: all -> 0x0f5f, TRY_ENTER, TryCatch #11 {all -> 0x0f5f, blocks: (B:481:0x0da1, B:483:0x0db3, B:484:0x0db6, B:486:0x0dc8, B:506:0x0e3d, B:508:0x0e43, B:510:0x0e58, B:513:0x0e5f, B:518:0x0e92, B:514:0x0e67, B:516:0x0e73, B:517:0x0e79, B:519:0x0ea3, B:520:0x0eba, B:523:0x0ec2, B:524:0x0ec7, B:525:0x0ed7, B:527:0x0ef1, B:528:0x0f0a, B:529:0x0f12, B:534:0x0f34, B:533:0x0f23, B:487:0x0de2, B:489:0x0de8, B:491:0x0df2, B:493:0x0df9, B:499:0x0e09, B:501:0x0e10, B:503:0x0e2f, B:505:0x0e36, B:504:0x0e33, B:500:0x0e0d, B:492:0x0df6, B:538:0x0f45, B:544:0x0f5b, B:545:0x0f5e), top: B:569:0x0027, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:610:? A[Catch: all -> 0x0f5f, SYNTHETIC, TRY_LEAVE, TryCatch #11 {all -> 0x0f5f, blocks: (B:481:0x0da1, B:483:0x0db3, B:484:0x0db6, B:486:0x0dc8, B:506:0x0e3d, B:508:0x0e43, B:510:0x0e58, B:513:0x0e5f, B:518:0x0e92, B:514:0x0e67, B:516:0x0e73, B:517:0x0e79, B:519:0x0ea3, B:520:0x0eba, B:523:0x0ec2, B:524:0x0ec7, B:525:0x0ed7, B:527:0x0ef1, B:528:0x0f0a, B:529:0x0f12, B:534:0x0f34, B:533:0x0f23, B:487:0x0de2, B:489:0x0de8, B:491:0x0df2, B:493:0x0df9, B:499:0x0e09, B:501:0x0e10, B:503:0x0e2f, B:505:0x0e36, B:504:0x0e33, B:500:0x0e0d, B:492:0x0df6, B:538:0x0f45, B:544:0x0f5b, B:545:0x0f5e), top: B:569:0x0027, inners: #9 }] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.measurement.internal.zzkf] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zza(java.lang.String r44, long r45) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(java.lang.String, long):boolean");
    }

    private static void zza(zzbw.zzg.zza zzaVar) {
        zzaVar.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zzaVar.zzb(); i++) {
            zzbw.zzc zzcVarZzb = zzaVar.zzb(i);
            if (zzcVarZzb.zze() < zzaVar.zzf()) {
                zzaVar.zzb(zzcVarZzb.zze());
            }
            if (zzcVarZzb.zze() > zzaVar.zzg()) {
                zzaVar.zzc(zzcVarZzb.zze());
            }
        }
    }

    private final void zza(zzbw.zzg.zza zzaVar, long j, boolean z) {
        zzkp zzkpVar;
        String str = z ? "_se" : "_lte";
        zzkp zzkpVarZzc = zze().zzc(zzaVar.zzj(), str);
        if (zzkpVarZzc == null || zzkpVarZzc.zze == null) {
            zzkpVar = new zzkp(zzaVar.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkpVar = new zzkp(zzaVar.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzkpVarZzc.zze).longValue() + j));
        }
        zzbw.zzk zzkVar = (zzbw.zzk) ((com.google.android.gms.internal.measurement.zzfi) zzbw.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzkpVar.zze).longValue()).zzu());
        boolean z2 = false;
        int iZza = zzkk.zza(zzaVar, str);
        if (iZza >= 0) {
            zzaVar.zza(iZza, zzkVar);
            z2 = true;
        }
        if (!z2) {
            zzaVar.zza(zzkVar);
        }
        if (j > 0) {
            zze().zza(zzkpVar);
            this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkpVar.zze);
        }
    }

    private final boolean zza(zzbw.zzc.zza zzaVar, zzbw.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzbw.zze zzeVarZza = zzkk.zza((zzbw.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzaVar.zzu()), "_sc");
        String strZzd = zzeVarZza == null ? null : zzeVarZza.zzd();
        zzh();
        zzbw.zze zzeVarZza2 = zzkk.zza((zzbw.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzaVar2.zzu()), "_pc");
        String strZzd2 = zzeVarZza2 != null ? zzeVarZza2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        zzb(zzaVar, zzaVar2);
        return true;
    }

    private final void zzb(zzbw.zzc.zza zzaVar, zzbw.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzbw.zze zzeVarZza = zzkk.zza((zzbw.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzaVar.zzu()), "_et");
        if (!zzeVarZza.zze() || zzeVarZza.zzf() <= 0) {
            return;
        }
        long jZzf = zzeVarZza.zzf();
        zzh();
        zzbw.zze zzeVarZza2 = zzkk.zza((zzbw.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzaVar2.zzu()), "_et");
        if (zzeVarZza2 != null && zzeVarZza2.zzf() > 0) {
            jZzf += zzeVarZza2.zzf();
        }
        zzh().zza(zzaVar2, "_et", Long.valueOf(jZzf));
        zzh().zza(zzaVar, "_fr", (Object) 1L);
    }

    private static void zza(zzbw.zzc.zza zzaVar, String str) {
        List<zzbw.zze> listZza = zzaVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(listZza.get(i).zzb())) {
                zzaVar.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbw.zzc.zza zzaVar, int i, String str) {
        List<zzbw.zze> listZza = zzaVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(listZza.get(i2).zzb())) {
                return;
            }
        }
        zzaVar.zza((zzbw.zze) ((com.google.android.gms.internal.measurement.zzfi) zzbw.zze.zzk().zza("_err").zza(Long.valueOf(i).longValue()).zzu())).zza((zzbw.zze) ((com.google.android.gms.internal.measurement.zzfi) zzbw.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzr = false;
                zzaa();
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0L);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long l : list) {
                        try {
                            zzab zzabVarZze = zze();
                            long jLongValue = l.longValue();
                            zzabVarZze.zzd();
                            zzabVarZze.zzak();
                            try {
                                if (zzabVarZze.c_().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zzabVarZze.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (zzd().zzf() && zzy()) {
                        zzl();
                    } else {
                        this.zzx = -1L;
                        zzz();
                    }
                    this.zzm = 0L;
                } catch (Throwable th2) {
                    zze().zzh();
                    throw th2;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503 && i != 429) {
                z = false;
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzg zzgVar) {
        ArrayMap arrayMap;
        zzw();
        if (zzle.zzb() && this.zzj.zzb().zze(zzgVar.zzc(), zzas.zzbo)) {
            if (TextUtils.isEmpty(zzgVar.zze()) && TextUtils.isEmpty(zzgVar.zzg()) && TextUtils.isEmpty(zzgVar.zzf())) {
                zza(zzgVar.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzgVar.zze()) && TextUtils.isEmpty(zzgVar.zzf())) {
            zza(zzgVar.zzc(), 204, null, null, null);
            return;
        }
        String strZza = this.zzj.zzb().zza(zzgVar);
        try {
            URL url = new URL(strZza);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzgVar.zzc());
            zzbt.zzb zzbVarZza = zzc().zza(zzgVar.zzc());
            String strZzb = zzc().zzb(zzgVar.zzc());
            if (zzbVarZza == null || TextUtils.isEmpty(strZzb)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", strZzb);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfa zzfaVarZzd = zzd();
            String strZzc = zzgVar.zzc();
            zzkh zzkhVar = new zzkh(this);
            zzfaVarZzd.zzd();
            zzfaVarZzd.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkhVar);
            zzfaVarZzd.zzq().zzb(new zzfe(zzfaVarZzd, strZzc, url, null, arrayMap, zzkhVar));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzet.zza(zzgVar.zzc()), strZza);
        }
    }

    final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzw();
        zzk();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzq = false;
                zzaa();
            }
        }
        this.zzj.zzr().zzx().zza("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zze().zzf();
        try {
            zzg zzgVarZzb = zze().zzb(str);
            boolean z = true;
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzgVarZzb == null) {
                this.zzj.zzr().zzi().zza("App does not exist in onConfigFetched. appId", zzet.zza(str));
            } else if (z2 || i == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i == 404 || i == 304) {
                    if (zzc().zza(str) == null && !zzc().zza(str, null, null)) {
                        return;
                    }
                } else if (!zzc().zza(str, bArr, str2)) {
                    return;
                }
                zzgVarZzb.zzh(this.zzj.zzm().currentTimeMillis());
                zze().zza(zzgVarZzb);
                if (i == 404) {
                    this.zzj.zzr().zzk().zza("Config not found. Using empty config. appId", str);
                } else {
                    this.zzj.zzr().zzx().zza("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzd().zzf() && zzy()) {
                    zzl();
                } else {
                    zzz();
                }
            } else {
                zzgVarZzb.zzi(this.zzj.zzm().currentTimeMillis());
                zze().zza(zzgVarZzb);
                this.zzj.zzr().zzx().zza("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzc().zzc(str);
                this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
                if (i != 503 && i != 429) {
                    z = false;
                }
                if (z) {
                    this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
                }
                zzz();
            }
            zze().b_();
        } finally {
            zze().zzh();
        }
    }

    private final void zzz() {
        long jMax;
        long jMax2;
        zzw();
        zzk();
        if (this.zzm > 0) {
            long jAbs = 3600000 - Math.abs(this.zzj.zzm().elapsedRealtime() - this.zzm);
            if (jAbs > 0) {
                this.zzj.zzr().zzx().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzt().zzb();
                zzv().zzf();
                return;
            }
            this.zzm = 0L;
        }
        if (!this.zzj.zzag() || !zzy()) {
            this.zzj.zzr().zzx().zza("Nothing to upload or uploading impossible");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        long jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
        long jMax3 = Math.max(0L, zzas.zzz.zza(null).longValue());
        boolean z = zze().zzz() || zze().zzk();
        if (z) {
            String strZzw = this.zzj.zzb().zzw();
            if (!TextUtils.isEmpty(strZzw) && !".none.".equals(strZzw)) {
                jMax = Math.max(0L, zzas.zzu.zza(null).longValue());
            } else {
                jMax = Math.max(0L, zzas.zzt.zza(null).longValue());
            }
        } else {
            jMax = Math.max(0L, zzas.zzs.zza(null).longValue());
        }
        long jZza = this.zzj.zzc().zzc.zza();
        long jZza2 = this.zzj.zzc().zzd.zza();
        long j = jMax;
        long jMax4 = Math.max(zze().zzw(), zze().zzx());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jAbs3, jAbs4);
            jMax2 = jAbs2 + jMax3;
            if (z && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + j;
            }
            if (!zzh().zza(jMax5, j)) {
                jMax2 = jMax5 + j;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                for (int i = 0; i < Math.min(20, Math.max(0, zzas.zzab.zza(null).intValue())); i++) {
                    jMax2 += Math.max(0L, zzas.zzaa.zza(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                }
                jMax2 = 0;
            }
        }
        if (jMax2 == 0) {
            this.zzj.zzr().zzx().zza("Next upload time is 0");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        if (!zzd().zzf()) {
            this.zzj.zzr().zzx().zza("No network");
            zzt().zza();
            zzv().zzf();
            return;
        }
        long jZza3 = this.zzj.zzc().zze.zza();
        long jMax6 = Math.max(0L, zzas.zzq.zza(null).longValue());
        if (!zzh().zza(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzt().zzb();
        long jCurrentTimeMillis2 = jMax2 - this.zzj.zzm().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            jCurrentTimeMillis2 = Math.max(0L, zzas.zzv.zza(null).longValue());
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        this.zzj.zzr().zzx().zza("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzv().zza(jCurrentTimeMillis2);
    }

    final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.zzn.clear();
    }

    private final Boolean zzb(zzg zzgVar) {
        try {
            if (zzgVar.zzm() != -2147483648L) {
                if (zzgVar.zzm() == Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzgVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzgVar.zzc(), 0).versionName;
                if (zzgVar.zzl() != null && zzgVar.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    final void zzo() {
        zzw();
        zzk();
        if (this.zzl) {
            return;
        }
        this.zzl = true;
        if (zzab()) {
            int iZza = zza(this.zzu);
            int iZzaf = this.zzj.zzy().zzaf();
            zzw();
            if (iZza > iZzaf) {
                this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzaf));
            } else if (iZza < iZzaf) {
                if (zza(iZzaf, this.zzu)) {
                    this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzaf));
                } else {
                    this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzaf));
                }
            }
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (this.zzj.zzb().zza(zzas.zzbm) && (fileLock = this.zzt) != null && fileLock.isValid()) {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzu = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzt = fileLockTryLock;
            if (fileLockTryLock != null) {
                this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                return true;
            }
            this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
            return false;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int i = fileChannel.read(byteBufferAllocate);
            if (i == 4) {
                byteBufferAllocate.flip();
                return byteBufferAllocate.getInt();
            }
            if (i != -1) {
                this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(i));
            }
            return 0;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzj.zzb().zza(zzas.zzbz) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(byteBufferAllocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    final void zza(zzm zzmVar) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzab zzabVarZze = zze();
        String str = zzmVar.zza;
        Preconditions.checkNotEmpty(str);
        zzabVarZze.zzd();
        zzabVarZze.zzak();
        try {
            SQLiteDatabase sQLiteDatabaseC_ = zzabVarZze.c_();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseC_.delete("apps", "app_id=?", strArr) + 0 + sQLiteDatabaseC_.delete("events", "app_id=?", strArr) + sQLiteDatabaseC_.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseC_.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseC_.delete("queue", "app_id=?", strArr) + sQLiteDatabaseC_.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseC_.delete("main_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzabVarZze.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzabVarZze.zzr().zzf().zza("Error resetting analytics data. appId, error", zzet.zza(str), e);
        }
        if (zzmVar.zzh) {
            zzb(zzmVar);
        }
    }

    final void zza(zzkn zzknVar, zzm zzmVar) {
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            int iZzc = this.zzj.zzi().zzc(zzknVar.zza);
            if (iZzc != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzmVar.zza, iZzc, "_ev", zzko.zza(zzknVar.zza, 24, true), zzknVar.zza != null ? zzknVar.zza.length() : 0);
                return;
            }
            int iZzb = this.zzj.zzi().zzb(zzknVar.zza, zzknVar.zza());
            if (iZzb != 0) {
                this.zzj.zzi();
                String strZza = zzko.zza(zzknVar.zza, 24, true);
                Object objZza = zzknVar.zza();
                this.zzj.zzi().zza(zzmVar.zza, iZzb, "_ev", strZza, (objZza == null || !((objZza instanceof String) || (objZza instanceof CharSequence))) ? 0 : String.valueOf(objZza).length());
                return;
            }
            Object objZzc = this.zzj.zzi().zzc(zzknVar.zza, zzknVar.zza());
            if (objZzc == null) {
                return;
            }
            if ("_sid".equals(zzknVar.zza)) {
                long j = zzknVar.zzb;
                String str = zzknVar.zze;
                long jLongValue = 0;
                zzkp zzkpVarZzc = zze().zzc(zzmVar.zza, "_sno");
                if (zzkpVarZzc != null && (zzkpVarZzc.zze instanceof Long)) {
                    jLongValue = ((Long) zzkpVarZzc.zze).longValue();
                } else {
                    if (zzkpVarZzc != null) {
                        this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzkpVarZzc.zze);
                    }
                    zzam zzamVarZza = zze().zza(zzmVar.zza, "_s");
                    if (zzamVarZza != null) {
                        jLongValue = zzamVarZza.zzc;
                        this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                    }
                }
                zza(new zzkn("_sno", j, Long.valueOf(jLongValue + 1), str), zzmVar);
            }
            zzkp zzkpVar = new zzkp(zzmVar.zza, zzknVar.zze, zzknVar.zza, zzknVar.zzb, objZzc);
            this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzkpVar.zzc), objZzc);
            zze().zzf();
            try {
                zzc(zzmVar);
                boolean zZza = zze().zza(zzkpVar);
                zze().b_();
                if (!zZza) {
                    this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzkpVar.zzc), zzkpVar.zze);
                    this.zzj.zzi().zza(zzmVar.zza, 9, (String) null, (String) null, 0);
                }
            } finally {
                zze().zzh();
            }
        }
    }

    final void zzb(zzkn zzknVar, zzm zzmVar) {
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            if ("_npa".equals(zzknVar.zza) && zzmVar.zzs != null) {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkn("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzmVar.zzs.booleanValue() ? 1L : 0L), "auto"), zzmVar);
                return;
            }
            this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzknVar.zza));
            zze().zzf();
            try {
                zzc(zzmVar);
                zze().zzb(zzmVar.zza, zzknVar.zza);
                zze().b_();
                this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzknVar.zza));
            } finally {
                zze().zzh();
            }
        }
    }

    final void zza(zzkd zzkdVar) {
        this.zzo++;
    }

    final void zzp() {
        this.zzp++;
    }

    final zzfx zzs() {
        return this.zzj;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205 A[Catch: all -> 0x04b8, TryCatch #1 {all -> 0x04b8, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01a4, B:54:0x01b7, B:57:0x01cb, B:59:0x01d6, B:64:0x01e5, B:66:0x01ed, B:68:0x01f3, B:72:0x0202, B:74:0x0205, B:76:0x0229, B:78:0x022e, B:84:0x024e, B:87:0x0262, B:89:0x0285, B:90:0x0293, B:92:0x02c6, B:94:0x02ce, B:96:0x02d2, B:97:0x02d5, B:99:0x02f6, B:138:0x03d2, B:139:0x03d5, B:150:0x0446, B:152:0x0456, B:154:0x0470, B:155:0x0477, B:159:0x04a9, B:101:0x030f, B:106:0x033a, B:108:0x0342, B:110:0x034c, B:114:0x0360, B:118:0x036e, B:122:0x0379, B:125:0x038b, B:130:0x03b6, B:132:0x03bc, B:133:0x03c1, B:135:0x03c7, B:128:0x039e, B:115:0x0366, B:104:0x0322, B:142:0x03ed, B:144:0x0423, B:146:0x042b, B:148:0x042f, B:149:0x0432, B:156:0x048c, B:158:0x0490, B:81:0x023e, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzb(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            Method dump skipped, instruction units count: 1219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzb(com.google.android.gms.measurement.internal.zzm):void");
    }

    private final zzm zza(String str) {
        zzg zzgVarZzb = zze().zzb(str);
        if (zzgVarZzb == null || TextUtils.isEmpty(zzgVarZzb.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzb = zzb(zzgVarZzb);
        if (boolZzb != null && !boolZzb.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzet.zza(str));
            return null;
        }
        return new zzm(str, zzgVarZzb.zze(), zzgVarZzb.zzl(), zzgVarZzb.zzm(), zzgVarZzb.zzn(), zzgVarZzb.zzo(), zzgVarZzb.zzp(), (String) null, zzgVarZzb.zzr(), false, zzgVarZzb.zzi(), zzgVarZzb.zzae(), 0L, 0, zzgVarZzb.zzaf(), zzgVarZzb.zzag(), false, zzgVarZzb.zzf(), zzgVarZzb.zzah(), zzgVarZzb.zzq(), zzgVarZzb.zzai(), (zzle.zzb() && this.zzj.zzb().zze(str, zzas.zzbo)) ? zzgVarZzb.zzg() : null);
    }

    final void zza(zzy zzyVar) {
        zzm zzmVarZza = zza(zzyVar.zza);
        if (zzmVarZza != null) {
            zza(zzyVar, zzmVarZza);
        }
    }

    final void zza(zzy zzyVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzyVar);
        Preconditions.checkNotEmpty(zzyVar.zza);
        Preconditions.checkNotNull(zzyVar.zzb);
        Preconditions.checkNotNull(zzyVar.zzc);
        Preconditions.checkNotEmpty(zzyVar.zzc.zza);
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            zzy zzyVar2 = new zzy(zzyVar);
            boolean z = false;
            zzyVar2.zze = false;
            zze().zzf();
            try {
                zzy zzyVarZzd = zze().zzd(zzyVar2.zza, zzyVar2.zzc.zza);
                if (zzyVarZzd != null && !zzyVarZzd.zzb.equals(zzyVar2.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzyVar2.zzc.zza), zzyVar2.zzb, zzyVarZzd.zzb);
                }
                if (zzyVarZzd != null && zzyVarZzd.zze) {
                    zzyVar2.zzb = zzyVarZzd.zzb;
                    zzyVar2.zzd = zzyVarZzd.zzd;
                    zzyVar2.zzh = zzyVarZzd.zzh;
                    zzyVar2.zzf = zzyVarZzd.zzf;
                    zzyVar2.zzi = zzyVarZzd.zzi;
                    zzyVar2.zze = zzyVarZzd.zze;
                    zzyVar2.zzc = new zzkn(zzyVar2.zzc.zza, zzyVarZzd.zzc.zzb, zzyVar2.zzc.zza(), zzyVarZzd.zzc.zze);
                } else if (TextUtils.isEmpty(zzyVar2.zzf)) {
                    zzyVar2.zzc = new zzkn(zzyVar2.zzc.zza, zzyVar2.zzd, zzyVar2.zzc.zza(), zzyVar2.zzc.zze);
                    zzyVar2.zze = true;
                    z = true;
                }
                if (zzyVar2.zze) {
                    zzkn zzknVar = zzyVar2.zzc;
                    zzkp zzkpVar = new zzkp(zzyVar2.zza, zzyVar2.zzb, zzknVar.zza, zzknVar.zzb, zzknVar.zza());
                    if (zze().zza(zzkpVar)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzyVar2.zza, this.zzj.zzj().zzc(zzkpVar.zzc), zzkpVar.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzet.zza(zzyVar2.zza), this.zzj.zzj().zzc(zzkpVar.zzc), zzkpVar.zze);
                    }
                    if (z && zzyVar2.zzi != null) {
                        zzb(new zzaq(zzyVar2.zzi, zzyVar2.zzd), zzmVar);
                    }
                }
                if (zze().zza(zzyVar2)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzyVar2.zza, this.zzj.zzj().zzc(zzyVar2.zzc.zza), zzyVar2.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzet.zza(zzyVar2.zza), this.zzj.zzj().zzc(zzyVar2.zzc.zza), zzyVar2.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    final void zzb(zzy zzyVar) {
        zzm zzmVarZza = zza(zzyVar.zza);
        if (zzmVarZza != null) {
            zzb(zzyVar, zzmVarZza);
        }
    }

    final void zzb(zzy zzyVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzyVar);
        Preconditions.checkNotEmpty(zzyVar.zza);
        Preconditions.checkNotNull(zzyVar.zzc);
        Preconditions.checkNotEmpty(zzyVar.zzc.zza);
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            zze().zzf();
            try {
                zzc(zzmVar);
                zzy zzyVarZzd = zze().zzd(zzyVar.zza, zzyVar.zzc.zza);
                if (zzyVarZzd != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzyVar.zza, this.zzj.zzj().zzc(zzyVar.zzc.zza));
                    zze().zze(zzyVar.zza, zzyVar.zzc.zza);
                    if (zzyVarZzd.zze) {
                        zze().zzb(zzyVar.zza, zzyVar.zzc.zza);
                    }
                    if (zzyVar.zzk != null) {
                        zzb(this.zzj.zzi().zza(zzyVar.zza, zzyVar.zzk.zza, zzyVar.zzk.zzb != null ? zzyVar.zzk.zzb.zzb() : null, zzyVarZzd.zzb, zzyVar.zzk.zzd, true, false), zzmVar);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzet.zza(zzyVar.zza), this.zzj.zzj().zzc(zzyVar.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.zzg zza(com.google.android.gms.measurement.internal.zzm r9, com.google.android.gms.measurement.internal.zzg r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(com.google.android.gms.measurement.internal.zzm, com.google.android.gms.measurement.internal.zzg, java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    final zzg zzc(zzm zzmVar) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzg zzgVarZzb = zze().zzb(zzmVar.zza);
        String strZzb = this.zzj.zzc().zzb(zzmVar.zza);
        if (com.google.android.gms.internal.measurement.zzkr.zzb() && this.zzj.zzb().zza(zzas.zzbu)) {
            if (zzgVarZzb == null) {
                zzgVarZzb = new zzg(this.zzj, zzmVar.zza);
                zzgVarZzb.zza(this.zzj.zzi().zzk());
                zzgVarZzb.zze(strZzb);
            } else if (!strZzb.equals(zzgVarZzb.zzh())) {
                zzgVarZzb.zze(strZzb);
                zzgVarZzb.zza(this.zzj.zzi().zzk());
            }
            zzgVarZzb.zzb(zzmVar.zzb);
            zzgVarZzb.zzc(zzmVar.zzr);
            if (zzle.zzb() && this.zzj.zzb().zze(zzgVarZzb.zzc(), zzas.zzbo)) {
                zzgVarZzb.zzd(zzmVar.zzv);
            }
            if (!TextUtils.isEmpty(zzmVar.zzk)) {
                zzgVarZzb.zzf(zzmVar.zzk);
            }
            if (zzmVar.zze != 0) {
                zzgVarZzb.zzd(zzmVar.zze);
            }
            if (!TextUtils.isEmpty(zzmVar.zzc)) {
                zzgVarZzb.zzg(zzmVar.zzc);
            }
            zzgVarZzb.zzc(zzmVar.zzj);
            if (zzmVar.zzd != null) {
                zzgVarZzb.zzh(zzmVar.zzd);
            }
            zzgVarZzb.zze(zzmVar.zzf);
            zzgVarZzb.zza(zzmVar.zzh);
            if (!TextUtils.isEmpty(zzmVar.zzg)) {
                zzgVarZzb.zzi(zzmVar.zzg);
            }
            if (!this.zzj.zzb().zza(zzas.zzcm)) {
                zzgVarZzb.zzp(zzmVar.zzl);
            }
            zzgVarZzb.zzb(zzmVar.zzo);
            zzgVarZzb.zzc(zzmVar.zzp);
            zzgVarZzb.zza(zzmVar.zzs);
            zzgVarZzb.zzf(zzmVar.zzt);
            if (zzgVarZzb.zza()) {
                zze().zza(zzgVarZzb);
            }
            return zzgVarZzb;
        }
        return zza(zzmVar, zzgVarZzb, strZzb);
    }

    final String zzd(zzm zzmVar) {
        try {
            return (String) this.zzj.zzq().zza(new zzkj(this, zzmVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzet.zza(zzmVar.zza), e);
            return null;
        }
    }

    final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzm zzmVar) {
        return (zzle.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzas.zzbo)) ? (TextUtils.isEmpty(zzmVar.zzb) && TextUtils.isEmpty(zzmVar.zzv) && TextUtils.isEmpty(zzmVar.zzr)) ? false : true : (TextUtils.isEmpty(zzmVar.zzb) && TextUtils.isEmpty(zzmVar.zzr)) ? false : true;
    }
}
