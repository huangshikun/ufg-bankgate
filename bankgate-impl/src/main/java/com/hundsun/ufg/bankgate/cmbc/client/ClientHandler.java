package com.hundsun.ufg.bankgate.cmbc.client;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangsk20406
 * @create 2019-09-03 14:43
 */
@Component
@Slf4j
@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler<CmbcResponse> {

    /**
     * 如果服务端发生消息给客户端，下面方法进行接收消息
     *
     * @param ctx
     * @param rsp
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CmbcResponse rsp) throws Exception {
        log.info("客户端收到消息：{}", rsp.toString());
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	ctx.writeAndFlush("TRCV353000001SECABC");
    }

    /**
     * 处理异常, 一般将实现异常处理逻辑的Handler放在ChannelPipeline的最后
     * 这样确保所有入站消息都总是被处理，无论它们发生在什么位置，下面只是简单的关闭Channel并打印异常信息
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	log.error("客户端通讯异常", cause);
        ctx.close(); // TODO 异常处理
    }
}
