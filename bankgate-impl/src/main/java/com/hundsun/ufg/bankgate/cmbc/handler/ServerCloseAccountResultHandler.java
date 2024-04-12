package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.CloseAccountResultResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 民生银行接收到客户解除券商银证转账协议的申请后，通过此接口把该申请发送至券商审批
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerCloseAccountResultHandler extends AbstractServerHandler<CloseAccountResultResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, CloseAccountResultResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.closeAccountResult(rsp);
	}
}
