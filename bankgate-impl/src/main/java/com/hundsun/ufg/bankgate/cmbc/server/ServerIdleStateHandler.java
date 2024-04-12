package com.hundsun.ufg.bankgate.cmbc.server;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 空闲检测
 *
 * @author huangsk20406
 * @create 2019-09-05 16:21
 */
@Slf4j
//@Component
public class ServerIdleStateHandler extends IdleStateHandler {
    /**
     * 设置空闲检测时间为 30s
     */
    private static final long READER_IDLE_TIME = 60L;
    
    public ServerIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        log.info("{} 秒内没有读取到数据,关闭连接", READER_IDLE_TIME);
        ctx.channel().close();
    }
	
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    	log.info("连接:[{}]关闭", ctx.toString());
        super.channelInactive(ctx);
    }
}
