package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.OpenAccountResultResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 民生银行接收到券商通过BSDS201返回的审批成功的结果后，会做银证转账关联，并通过此接口发送最终银证转账协议开通成功/失败结果至券商。
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerOpenAccountResultHandler extends AbstractServerHandler<OpenAccountResultResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, OpenAccountResultResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.openAccountResult(rsp);
	}
}
