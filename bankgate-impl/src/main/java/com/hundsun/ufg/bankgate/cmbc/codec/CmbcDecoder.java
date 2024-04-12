package com.hundsun.ufg.bankgate.cmbc.codec;

import java.util.List;

import com.hundsun.ufg.bankgate.cmbc.enums.EnumDstServ;
import com.hundsun.ufg.bankgate.cmbc.enums.EnumPacketType;
import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;
import com.hundsun.ufg.bankgate.cmbc.util.JaxbUtil;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import cmbc.cfca.util.Base64;
import cn.hutool.core.util.StrUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * 民生银行解码器
 *
 * @author huangsk20406
 * @create 2019-09-03 11:19
 */
@Slf4j
@SuppressWarnings("deprecation")
public class CmbcDecoder extends ByteToMessageDecoder {
	
	private CMBCDecryptKit cmbcDecryptKit;
	
	public CmbcDecoder(CMBCDecryptKit cmbcDecryptKit) {
		this.cmbcDecryptKit = cmbcDecryptKit;
	}

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 8) {
            log.info("数据包长度小于协议头长度");
            return;
        }
        in.markReaderIndex();
        byte[] data = null;
        // 连接建立/清理
        byte c = in.readByte();
        if (c == 84) {
        	if (in.readableBytes() < 18) {
        		in.resetReaderIndex();
        		return;
        	}
        	
        	CmbcResponse baseResponse = new CmbcResponse();
        	c = in.readByte();
        	in.skipBytes(2);
        	data = new byte[15];
        	in.readBytes(data);
        	baseResponse.setBody(new String(data));
        	if (c == 82) {
        		log.info("收到客户端连接建立报文:[{}]", baseResponse.getBody());
        		baseResponse.setPacketTypeEnum(EnumPacketType.CONNECT_BUILD);
        	} else {
        		log.info("收到客户端连接清理报文:[{}]", baseResponse.getBody());
        		baseResponse.setPacketTypeEnum(EnumPacketType.CONNECT_CLEAN);
        	}
        	out.add(baseResponse);
        	return;
        }
        
        in.resetReaderIndex();
        data = new byte[8];
        in.readBytes(data);
        
//        int length = NumberUtil.toInt(data);
        int length = Integer.parseInt(new String(data));
        // 响应成功
        if (length == 0) {
//        	BaseResponse baseResponse = new BaseResponse();
//        	baseResponse.setReturnCode(CmbcMessageEnum.RECEIVE_SUCCESS.getCode());
//        	baseResponse.setPacketTypeEnum(PacketTypeEnum.RECEIVE_SUCCESS);
//        	out.add(baseResponse);
        	log.info("收到请求接收成功:[00000000]");
        	return;
        }
        
        // 我们读到的消息体长度为0，这是不应该出现的情况，这里出现这情况，关闭连接。
        if (length < 0) {
        	ctx.close();
        }
        
        // 读到的消息体长度如果小于我们传送过来的消息长度，则resetReaderIndex. 这个配合markReaderIndex使用的。把readIndex重置到mark的地方
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }

        data = new byte[length];
        in.readBytes(data);

        String body = new String(data);
    	if (length == 26) {
    		log.info("收到客户端心跳报文:[{}]", body);
//    		baseResponse.setPacketTypeEnum(PacketTypeEnum.HEARTBEAT_KEEPALIVE);
    		return;
    	}
    	
		log.info("收到客户端请求报文:[{}]", body);
		// 解码
		String xml = new String(Base64.decode(cmbcDecryptKit.DecryptAndVerifyMessage(body.substring(9))));
		log.info("请求密文解码:[{}]", xml);
		CmbcResponse baseResponse = JaxbUtil.xmlToBean(xml, CmbcResponse.class, EnumDstServ.getByCode(StrUtil.subBetween(xml, "DstServ=\"", "\"")).getClazz());
//		baseResponse.setBody(body);
//		baseResponse.setPacketTypeEnum(EnumPacketType.REQUEST_RECEIVE);
		out.add(baseResponse.getResponse());
    }
}
