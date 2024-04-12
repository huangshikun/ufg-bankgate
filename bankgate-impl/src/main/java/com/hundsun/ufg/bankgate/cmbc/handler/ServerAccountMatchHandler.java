package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.AccountMatchResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 接收到券商“银证转账协议对账”申请后，银行将对应协议信息返回给券商
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerAccountMatchHandler extends AbstractServerHandler<AccountMatchResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, AccountMatchResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.accountMatch(rsp);
	}
}
