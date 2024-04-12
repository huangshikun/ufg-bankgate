package com.hundsun.ufg.bankgate.cmbc.codec;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcRequest;

import cn.hutool.core.util.StrUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 民生银行编码器
 * @author huangsk20406
 * @create 2019-09-03 10:55
 */
public class CmbcEncoder extends MessageToByteEncoder<CmbcRequest> {

	@Override
	protected void encode(ChannelHandlerContext ctx, CmbcRequest msg, ByteBuf out) throws Exception {
		out.writeBytes(StrUtil.padPre(String.valueOf(msg.getBody().length()), 8, '0').getBytes());
		out.writeBytes(msg.getBody().getBytes());
	}
}