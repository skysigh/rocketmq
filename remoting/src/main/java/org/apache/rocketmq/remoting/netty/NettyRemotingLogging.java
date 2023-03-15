package org.apache.rocketmq.remoting.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.atomic.AtomicLong;

public class NettyRemotingLogging extends LoggingHandler {
    private static AtomicLong id = new AtomicLong(0);

    public NettyRemotingLogging(LogLevel level) {
        super(level);
    }

    protected String format(ChannelHandlerContext ctx, String eventName) {
        return super.format(ctx, eventName) + "  顺序：" + id.incrementAndGet();
    }

    protected String format(ChannelHandlerContext ctx, String eventName, Object arg) {
        return super.format(ctx, eventName, arg) + "  顺序：" + id.incrementAndGet();
    }

    protected String format(ChannelHandlerContext ctx, String eventName, Object firstArg, Object secondArg) {
        return super.format(ctx, eventName, firstArg, secondArg) + "  顺序：" + id.incrementAndGet();
    }

}
