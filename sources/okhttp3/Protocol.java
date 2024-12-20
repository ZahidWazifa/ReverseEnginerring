package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mt.Log390828;
import mt.Log3FA212;
import mt.Log952E92;
import mt.LogEB28DF;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: Protocol.kt */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final String protocol;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: 01C2 */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final Protocol get(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            String access$getProtocol$p = Protocol.HTTP_1_0.protocol;
            Log3FA212.a((Object) access$getProtocol$p);
            LogEB28DF.a((Object) access$getProtocol$p);
            Log390828.a((Object) access$getProtocol$p);
            Log952E92.a((Object) access$getProtocol$p);
            if (Intrinsics.areEqual((Object) protocol, (Object) access$getProtocol$p)) {
                return Protocol.HTTP_1_0;
            }
            String access$getProtocol$p2 = Protocol.HTTP_1_1.protocol;
            Log3FA212.a((Object) access$getProtocol$p2);
            LogEB28DF.a((Object) access$getProtocol$p2);
            Log390828.a((Object) access$getProtocol$p2);
            Log952E92.a((Object) access$getProtocol$p2);
            if (Intrinsics.areEqual((Object) protocol, (Object) access$getProtocol$p2)) {
                return Protocol.HTTP_1_1;
            }
            String access$getProtocol$p3 = Protocol.H2_PRIOR_KNOWLEDGE.protocol;
            Log3FA212.a((Object) access$getProtocol$p3);
            LogEB28DF.a((Object) access$getProtocol$p3);
            Log390828.a((Object) access$getProtocol$p3);
            Log952E92.a((Object) access$getProtocol$p3);
            if (Intrinsics.areEqual((Object) protocol, (Object) access$getProtocol$p3)) {
                return Protocol.H2_PRIOR_KNOWLEDGE;
            }
            String access$getProtocol$p4 = Protocol.HTTP_2.protocol;
            Log3FA212.a((Object) access$getProtocol$p4);
            LogEB28DF.a((Object) access$getProtocol$p4);
            Log390828.a((Object) access$getProtocol$p4);
            Log952E92.a((Object) access$getProtocol$p4);
            if (Intrinsics.areEqual((Object) protocol, (Object) access$getProtocol$p4)) {
                return Protocol.HTTP_2;
            }
            String access$getProtocol$p5 = Protocol.SPDY_3.protocol;
            Log3FA212.a((Object) access$getProtocol$p5);
            LogEB28DF.a((Object) access$getProtocol$p5);
            Log390828.a((Object) access$getProtocol$p5);
            Log952E92.a((Object) access$getProtocol$p5);
            if (Intrinsics.areEqual((Object) protocol, (Object) access$getProtocol$p5)) {
                return Protocol.SPDY_3;
            }
            String access$getProtocol$p6 = Protocol.QUIC.protocol;
            Log3FA212.a((Object) access$getProtocol$p6);
            LogEB28DF.a((Object) access$getProtocol$p6);
            Log390828.a((Object) access$getProtocol$p6);
            Log952E92.a((Object) access$getProtocol$p6);
            if (Intrinsics.areEqual((Object) protocol, (Object) access$getProtocol$p6)) {
                return Protocol.QUIC;
            }
            throw new IOException("Unexpected protocol: " + protocol);
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Protocol(String protocol2) {
        this.protocol = protocol2;
    }

    @JvmStatic
    public static final Protocol get(String str) throws IOException {
        return Companion.get(str);
    }

    public String toString() {
        return this.protocol;
    }
}
