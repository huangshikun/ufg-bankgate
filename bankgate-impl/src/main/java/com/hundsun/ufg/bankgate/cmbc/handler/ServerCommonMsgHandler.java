package com.hundsun.ufg.bankgate.cmbc.handler;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.server.AbstractServerHandler;
import com.hundsun.ufg.bankgate.response.cmbc.CommonMsgResponse;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * 1.返回交易过程中遇到的异常信息
 * 2.接口 BSDS001,BSDS002,BSDS003 的处理结果，银行通过此接口返回给券商。 
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@ChannelHandler.Sharable
public class ServerCommonMsgHandler extends AbstractServerHandler<CommonMsgResponse> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, CommonMsgResponse rsp) throws Exception {
		super.channelRead0(ctx, rsp);
		cmbcService.commonMsg(rsp);
	}
}
