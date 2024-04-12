package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.BatchAccountMatchResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 银行返回“银证协议”批量对账记录信息至券商
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerBatchAccountMatchHandler extends AbstractServerHandler<BatchAccountMatchResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BatchAccountMatchResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.batchAccountMatch(rsp);
	}
}
