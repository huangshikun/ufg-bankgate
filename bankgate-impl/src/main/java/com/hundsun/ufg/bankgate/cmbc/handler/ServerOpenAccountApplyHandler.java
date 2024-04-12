package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.OpenAccountApplyResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 民生银行接收到客户开通银证转账协议的申请后，银行会对资料做合法性检查，检查通过后，通过此接口发送该开通申请至券商
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerOpenAccountApplyHandler extends AbstractServerHandler<OpenAccountApplyResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, OpenAccountApplyResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.openAccountApply(rsp);
	}
}
