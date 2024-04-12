package com.hundsun.ufg.bankgate.cmbc.server;

import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hundsun.ufg.account.pub.service.bankgate.CmbcService;
import com.hundsun.ufg.bankgate.cmbc.enums.EnumCmbcMsg;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Slf4j
public abstract class AbstractServerHandler<T> extends SimpleChannelInboundHandler<T> {
	
	@CloudReference(targetUrl="${app.ufg_account.targetUrl}")
	protected CmbcService cmbcService;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, T rsp) throws Exception {
		log.info("服务端服务:[{}]接收响应成功", rsp.toString());
		ctx.writeAndFlush(EnumCmbcMsg.RECEIVE_SUCCESS.getCode());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// 当出现异常就关闭连接
		log.error("服务器端通讯异常", cause);
		ctx.close();
	}
}
