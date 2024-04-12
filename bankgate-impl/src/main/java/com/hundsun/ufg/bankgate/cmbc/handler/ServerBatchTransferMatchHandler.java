package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.BatchTransferMatchResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 银行返回“银证转账”批量记录信息
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerBatchTransferMatchHandler extends AbstractServerHandler<BatchTransferMatchResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BatchTransferMatchResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.batchTransferMatch(rsp);
	}
}
