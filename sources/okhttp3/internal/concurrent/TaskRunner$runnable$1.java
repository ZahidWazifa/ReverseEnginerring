package okhttp3.internal.concurrent;

import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mt.Log390828;
import mt.Log3FA212;
import mt.Log952E92;
import mt.LogEB28DF;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: 01CC */
public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    TaskRunner$runnable$1(TaskRunner this$02) {
        this.this$0 = this$02;
    }

    public void run() {
        Task awaitTaskToRun;
        while (true) {
            synchronized (this.this$0) {
                awaitTaskToRun = this.this$0.awaitTaskToRun();
            }
            if (awaitTaskToRun != null) {
                Task task = awaitTaskToRun;
                TaskQueue queue$okhttp = task.getQueue$okhttp();
                Intrinsics.checkNotNull(queue$okhttp);
                long j = -1;
                boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                if (isLoggable) {
                    j = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                    TaskLoggerKt.log(task, queue$okhttp, "starting");
                }
                try {
                    this.this$0.runTask(task);
                    Unit unit = Unit.INSTANCE;
                    if (isLoggable) {
                        StringBuilder append = new StringBuilder().append("finished run in ");
                        String formatDuration = TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j);
                        Log3FA212.a((Object) formatDuration);
                        LogEB28DF.a((Object) formatDuration);
                        Log390828.a((Object) formatDuration);
                        Log952E92.a((Object) formatDuration);
                        TaskLoggerKt.log(task, queue$okhttp, append.append(formatDuration).toString());
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        long nanoTime = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j;
                        if (0 != 0) {
                            StringBuilder append2 = new StringBuilder().append("finished run in ");
                            String formatDuration2 = TaskLoggerKt.formatDuration(nanoTime);
                            Log3FA212.a((Object) formatDuration2);
                            LogEB28DF.a((Object) formatDuration2);
                            Log390828.a((Object) formatDuration2);
                            Log952E92.a((Object) formatDuration2);
                            TaskLoggerKt.log(task, queue$okhttp, append2.append(formatDuration2).toString());
                        } else {
                            StringBuilder append3 = new StringBuilder().append("failed a run in ");
                            String formatDuration3 = TaskLoggerKt.formatDuration(nanoTime);
                            Log3FA212.a((Object) formatDuration3);
                            LogEB28DF.a((Object) formatDuration3);
                            Log390828.a((Object) formatDuration3);
                            Log952E92.a((Object) formatDuration3);
                            TaskLoggerKt.log(task, queue$okhttp, append3.append(formatDuration3).toString());
                        }
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
