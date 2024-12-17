package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 4, 0})
/* compiled from: JvmOkio.kt */
final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream input2, Timeout timeout2) {
        Intrinsics.checkNotNullParameter(input2, "input");
        Intrinsics.checkNotNullParameter(timeout2, "timeout");
        this.input = input2;
        this.timeout = timeout2;
    }

    public void close() {
        this.input.close();
    }

    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount == 0) {
            return 0;
        }
        if (byteCount >= 0) {
            try {
                this.timeout.throwIfReached();
                Segment writableSegment$okio = sink.writableSegment$okio(1);
                int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(byteCount, (long) (8192 - writableSegment$okio.limit)));
                if (read != -1) {
                    writableSegment$okio.limit += read;
                    sink.setSize$okio(sink.size() + ((long) read));
                    return (long) read;
                } else if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1;
                } else {
                    sink.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1;
                }
            } catch (AssertionError e) {
                if (Okio.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
