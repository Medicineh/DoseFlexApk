package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class zzir {
    public static final zzir zza = new zzir("DOUBLE", 0, zziu.DOUBLE, 1);
    public static final zzir zzb = new zzir("FLOAT", 1, zziu.FLOAT, 5);
    public static final zzir zzc = new zzir("INT64", 2, zziu.LONG, 0);
    public static final zzir zzd = new zzir("UINT64", 3, zziu.LONG, 0);
    public static final zzir zze = new zzir("INT32", 4, zziu.INT, 0);
    public static final zzir zzf = new zzir("FIXED64", 5, zziu.LONG, 1);
    public static final zzir zzg = new zzir("FIXED32", 6, zziu.INT, 5);
    public static final zzir zzh = new zzir("BOOL", 7, zziu.BOOLEAN, 0);
    public static final zzir zzi;
    public static final zzir zzj;
    public static final zzir zzk;
    public static final zzir zzl;
    public static final zzir zzm;
    public static final zzir zzn;
    public static final zzir zzo;
    public static final zzir zzp;
    public static final zzir zzq;
    public static final zzir zzr;
    private static final /* synthetic */ zzir[] zzu;
    private final zziu zzs;
    private final int zzt;

    public static zzir[] values() {
        return (zzir[]) zzu.clone();
    }

    private zzir(String str, int i, zziu zziuVar, int i2) {
        this.zzs = zziuVar;
        this.zzt = i2;
    }

    public final zziu zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzir(String str, int i, zziu zziuVar, int i2, zzio zzioVar) {
        this(str, i, zziuVar, i2);
    }

    static {
        final int i = 2;
        final int i2 = 3;
        final zziu zziuVar = zziu.STRING;
        final int i3 = 8;
        final String str = "STRING";
        zzi = new zzir(str, i3, zziuVar, i) { // from class: com.google.android.gms.internal.measurement.zziq
            {
                int i4 = 8;
                int i5 = 2;
                zzio zzioVar = null;
            }
        };
        final zziu zziuVar2 = zziu.MESSAGE;
        final int i4 = 9;
        final String str2 = "GROUP";
        zzj = new zzir(str2, i4, zziuVar2, i2) { // from class: com.google.android.gms.internal.measurement.zzit
            {
                int i5 = 9;
                int i6 = 3;
                zzio zzioVar = null;
            }
        };
        final zziu zziuVar3 = zziu.MESSAGE;
        final int i5 = 10;
        final String str3 = "MESSAGE";
        zzk = new zzir(str3, i5, zziuVar3, i) { // from class: com.google.android.gms.internal.measurement.zzis
            {
                int i6 = 10;
                int i7 = 2;
                zzio zzioVar = null;
            }
        };
        final zziu zziuVar4 = zziu.BYTE_STRING;
        final int i6 = 11;
        final String str4 = "BYTES";
        zzl = new zzir(str4, i6, zziuVar4, i) { // from class: com.google.android.gms.internal.measurement.zziv
            {
                int i7 = 11;
                int i8 = 2;
                zzio zzioVar = null;
            }
        };
        zzm = new zzir("UINT32", 12, zziu.INT, 0);
        zzn = new zzir("ENUM", 13, zziu.ENUM, 0);
        zzo = new zzir("SFIXED32", 14, zziu.INT, 5);
        zzp = new zzir("SFIXED64", 15, zziu.LONG, 1);
        zzq = new zzir("SINT32", 16, zziu.INT, 0);
        zzir zzirVar = new zzir("SINT64", 17, zziu.LONG, 0);
        zzr = zzirVar;
        zzu = new zzir[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzirVar};
    }
}
