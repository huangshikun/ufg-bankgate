package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.TransferOutApplyResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 民生银行收到客户券商转银行的申请后，把该申请通过此接口发送至券商审批
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerTransferOutApplyHandler extends AbstractServerHandler<TransferOutApplyResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TransferOutApplyResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.transferOutApply(rsp);
	}
}
