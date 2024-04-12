package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.TransferMatchResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 接收到券商“银证转账金融流水对账”申请后，银行将对应金融流水信息返回给券商
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerTransferMatchHandler extends AbstractServerHandler<TransferMatchResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TransferMatchResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.transferMatch(rsp);
	}
}
