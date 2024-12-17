package mt;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: 01B3 */
public class Log952E92 extends Thread {
    private static final ThreadLocal PARAMETER_BUFFER = new ThreadLocal();
    private static final LinkedBlockingQueue QUEUE = new LinkedBlockingQueue();
    private static final SimpleDateFormat TIME_FORMAT1 = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final SimpleDateFormat TIME_FORMAT2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    static {
        Log952E92 log952E92 = new Log952E92();
        log952E92.setDaemon(true);
        log952E92.start();
    }

    public static void a(char c) {
        String valueOf = String.valueOf(c);
        Log3FA212.a((Object) valueOf);
        LogEB28DF.a((Object) valueOf);
        Log390828.a((Object) valueOf);
        z(valueOf);
    }

    public static void b() {
        ThreadLocal threadLocal = PARAMETER_BUFFER;
        z(((StringBuilder) threadLocal.get()).toString());
        threadLocal.remove();
    }

    public static void b1(char c) {
        x("Parameter1: " + c);
    }

    public static void b1(double d) {
        x("Parameter1: " + d);
    }

    public static void b1(float f) {
        x("Parameter1: " + f);
    }

    public static void b1(int i) {
        x("Parameter1: " + i);
    }

    public static void b1(long j) {
        x("Parameter1: " + j);
    }

    public static void b1(boolean z) {
        x("Parameter1: " + z);
    }

    public static void b2(char c) {
        x("Parameter2: " + c);
    }

    public static void b2(double d) {
        x("Parameter2: " + d);
    }

    public static void b2(float f) {
        x("Parameter2: " + f);
    }

    public static void b2(int i) {
        x("Parameter2: " + i);
    }

    public static void b2(long j) {
        x("Parameter2: " + j);
    }

    public static void b2(boolean z) {
        x("Parameter2: " + z);
    }

    public static void b3(char c) {
        x("Parameter3: " + c);
    }

    public static void b3(double d) {
        x("Parameter3: " + d);
    }

    public static void b3(float f) {
        x("Parameter3: " + f);
    }

    public static void b3(int i) {
        x("Parameter3: " + i);
    }

    public static void b3(long j) {
        x("Parameter3: " + j);
    }

    public static void b3(boolean z) {
        x("Parameter3: " + z);
    }

    public static void b4(char c) {
        x("Parameter4: " + c);
    }

    public static void b4(double d) {
        x("Parameter4: " + d);
    }

    public static void b4(float f) {
        x("Parameter4: " + f);
    }

    public static void b4(int i) {
        x("Parameter4: " + i);
    }

    public static void b4(long j) {
        x("Parameter4: " + j);
    }

    public static void b4(boolean z) {
        x("Parameter4: " + z);
    }

    public static void b5(char c) {
        x("Parameter5: " + c);
    }

    public static void b5(double d) {
        x("Parameter5: " + d);
    }

    public static void b5(float f) {
        x("Parameter5: " + f);
    }

    public static void b5(int i) {
        x("Parameter5: " + i);
    }

    public static void b5(long j) {
        x("Parameter5: " + j);
    }

    public static void b5(boolean z) {
        x("Parameter5: " + z);
    }

    public static void b6(char c) {
        x("Parameter6: " + c);
    }

    public static void b6(double d) {
        x("Parameter6: " + d);
    }

    public static void b6(float f) {
        x("Parameter6: " + f);
    }

    public static void b6(int i) {
        x("Parameter6: " + i);
    }

    public static void b6(long j) {
        x("Parameter6: " + j);
    }

    public static void b6(boolean z) {
        x("Parameter6: " + z);
    }

    private static void x(String str) {
        ThreadLocal threadLocal = PARAMETER_BUFFER;
        StringBuilder sb = (StringBuilder) threadLocal.get();
        if (sb == null) {
            sb = new StringBuilder();
            threadLocal.set(sb);
        }
        if (sb.length() > 0) {
            sb.append(10);
        }
        sb.append(str);
    }

    private static void z(String str) {
        String str2 = "[TIME] [CLASS]\n->[METHOD]([LOCATION])\n[RESULT]\n--------------------\n";
        if (str2.contains("[TIME]")) {
            str2 = str2.replace("[TIME]", TIME_FORMAT1.format(Long.valueOf(System.currentTimeMillis())));
        }
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String fileName = stackTraceElement.getFileName();
        if (fileName == null) {
            fileName = "Unknown Source";
        }
        int lineNumber = stackTraceElement.getLineNumber();
        if (lineNumber >= 0) {
            fileName = fileName + ":" + lineNumber;
        }
        QUEUE.offer(str2.replace("[RESULT]", str).replace("[CLASS]", stackTraceElement.getClassName()).replace("[METHOD]", stackTraceElement.getMethodName()).replace("[LOCATION]", fileName));
    }

    public void run() {
        FileOutputStream fileOutputStream = null;
        IOException iOException = null;
        try {
            File file = new File("[SDCARD]/MT2/logs/[PACKAGE]-[TIME].log".replace("[SDCARD]", Environment.getExternalStorageDirectory().getPath()).replace("[PACKAGE]", "com.rhmsoft.codeund98532").replace("[TIME]", TIME_FORMAT2.format(Long.valueOf(System.currentTimeMillis()))).replace('\\', '/').replace("//", "/"));
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            fileOutputStream = new FileOutputStream(file, true);
        } catch (IOException e) {
            e.printStackTrace();
            iOException = e;
        }
        if (fileOutputStream == null) {
            try {
                File file2 = new File("/data/data/com.rhmsoft.codeund98532/logs");
                File file3 = new File(file2, TIME_FORMAT2.format(Long.valueOf(System.currentTimeMillis())) + ".log");
                file2.mkdirs();
                fileOutputStream = new FileOutputStream(file3);
            } catch (IOException e2) {
                e2.printStackTrace();
                throw new RuntimeException(iOException);
            }
        }
        try {
            Charset defaultCharset = Charset.defaultCharset();
            while (true) {
                LinkedBlockingQueue linkedBlockingQueue = QUEUE;
                fileOutputStream.write(((String) linkedBlockingQueue.take()).getBytes(defaultCharset));
                if (linkedBlockingQueue.isEmpty()) {
                    fileOutputStream.flush();
                }
            }
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void a(double d) {
        String valueOf = String.valueOf(d);
        Log3FA212.a((Object) valueOf);
        LogEB28DF.a((Object) valueOf);
        Log390828.a((Object) valueOf);
        z(valueOf);
    }

    public static void a(float f) {
        String valueOf = String.valueOf(f);
        Log3FA212.a((Object) valueOf);
        LogEB28DF.a((Object) valueOf);
        Log390828.a((Object) valueOf);
        z(valueOf);
    }

    public static void a(int i) {
        String valueOf = String.valueOf(i);
        Log3FA212.a((Object) valueOf);
        LogEB28DF.a((Object) valueOf);
        Log390828.a((Object) valueOf);
        z(valueOf);
    }

    public static void a(long j) {
        String valueOf = String.valueOf(j);
        Log3FA212.a((Object) valueOf);
        LogEB28DF.a((Object) valueOf);
        Log390828.a((Object) valueOf);
        z(valueOf);
    }

    public static void a(Object obj) {
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        z(y);
    }

    public static void a(boolean z) {
        String valueOf = String.valueOf(z);
        Log3FA212.a((Object) valueOf);
        LogEB28DF.a((Object) valueOf);
        Log390828.a((Object) valueOf);
        z(valueOf);
    }

    public static void b1(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter1: ");
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        sb.append(y);
        x(sb.toString());
    }

    public static void b2(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter2: ");
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        sb.append(y);
        x(sb.toString());
    }

    public static void b3(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter3: ");
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        sb.append(y);
        x(sb.toString());
    }

    public static void b4(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter4: ");
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        sb.append(y);
        x(sb.toString());
    }

    public static void b5(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter5: ");
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        sb.append(y);
        x(sb.toString());
    }

    public static void b6(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter6: ");
        String y = y(obj);
        Log3FA212.a((Object) y);
        LogEB28DF.a((Object) y);
        Log390828.a((Object) y);
        sb.append(y);
        x(sb.toString());
    }

    public static void printStackTrace() {
        String stackTraceString = Log.getStackTraceString(new Exception("InjectedLog.printStackTrace"));
        Log3FA212.a((Object) stackTraceString);
        LogEB28DF.a((Object) stackTraceString);
        Log390828.a((Object) stackTraceString);
        z(stackTraceString);
    }

    private static String y(Object obj) {
        if (obj == null) {
            return "null";
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            return obj.toString();
        }
        if (cls == byte[].class) {
            String arrays = Arrays.toString((byte[]) obj);
            Log3FA212.a((Object) arrays);
            LogEB28DF.a((Object) arrays);
            Log390828.a((Object) arrays);
            return arrays;
        } else if (cls == short[].class) {
            String arrays2 = Arrays.toString((short[]) obj);
            Log3FA212.a((Object) arrays2);
            LogEB28DF.a((Object) arrays2);
            Log390828.a((Object) arrays2);
            return arrays2;
        } else if (cls == int[].class) {
            String arrays3 = Arrays.toString((int[]) obj);
            Log3FA212.a((Object) arrays3);
            LogEB28DF.a((Object) arrays3);
            Log390828.a((Object) arrays3);
            return arrays3;
        } else if (cls == long[].class) {
            String arrays4 = Arrays.toString((long[]) obj);
            Log3FA212.a((Object) arrays4);
            LogEB28DF.a((Object) arrays4);
            Log390828.a((Object) arrays4);
            return arrays4;
        } else if (cls == char[].class) {
            String arrays5 = Arrays.toString((char[]) obj);
            Log3FA212.a((Object) arrays5);
            LogEB28DF.a((Object) arrays5);
            Log390828.a((Object) arrays5);
            return arrays5;
        } else if (cls == float[].class) {
            String arrays6 = Arrays.toString((float[]) obj);
            Log3FA212.a((Object) arrays6);
            LogEB28DF.a((Object) arrays6);
            Log390828.a((Object) arrays6);
            return arrays6;
        } else if (cls == double[].class) {
            String arrays7 = Arrays.toString((double[]) obj);
            Log3FA212.a((Object) arrays7);
            LogEB28DF.a((Object) arrays7);
            Log390828.a((Object) arrays7);
            return arrays7;
        } else if (cls == boolean[].class) {
            String arrays8 = Arrays.toString((boolean[]) obj);
            Log3FA212.a((Object) arrays8);
            LogEB28DF.a((Object) arrays8);
            Log390828.a((Object) arrays8);
            return arrays8;
        } else {
            String deepToString = Arrays.deepToString((Object[]) obj);
            Log3FA212.a((Object) deepToString);
            LogEB28DF.a((Object) deepToString);
            Log390828.a((Object) deepToString);
            return deepToString;
        }
    }
}
