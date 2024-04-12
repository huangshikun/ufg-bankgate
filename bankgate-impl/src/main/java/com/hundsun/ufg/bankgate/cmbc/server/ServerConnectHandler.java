package com.hundsun.ufg.bankgate.cmbc.server;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerConnectHandler extends AbstractServerHandler<CmbcResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, CmbcResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
	}
}
