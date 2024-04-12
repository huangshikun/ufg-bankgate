package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.TransferInResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 客户通过网银发起银证转账，把交易指令通过此接口发送至券商。
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerTransferInResultHandler extends AbstractServerHandler<TransferInResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TransferInResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.transferIn(rsp);
	}
}
