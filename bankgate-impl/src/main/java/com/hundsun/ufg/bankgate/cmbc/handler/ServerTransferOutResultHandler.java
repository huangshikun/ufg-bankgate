package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.TransferOutResultResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 民生银行接收到券商对“券转银”的审批同意的结果后，进行相应的转账处理，并将结果通过此接口发送至券商
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerTransferOutResultHandler extends AbstractServerHandler<TransferOutResultResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TransferOutResultResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.transferOutResult(rsp);
	}
}
