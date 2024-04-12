package com.hundsun.ufg.bankgate.cmbc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.codec.CmbcDecoder;
import com.hundsun.ufg.bankgate.cmbc.codec.CmbcEncoder;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author huangsk20406
 * @create 2019-09-02 16:03
 */
@Component
@DependsOn({"heartbeatHandler", "clientHandler"})
@SuppressWarnings("deprecation")
public class ClientHandlerInitilizer extends ChannelInitializer<Channel> {
	
	@Autowired
	private HeartbeatHandler heartbeatHandler;
	
	@Autowired
	private ClientHandler clientHandler;
	
	@Autowired
	private CMBCDecryptKit cmbcDecryptKit;
	
	@Autowired
	private StringEncoder stringEncoder;
	
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new IdleStateHandler(0, 30, 0))
                .addLast(new CmbcEncoder())
                .addLast(stringEncoder)
//                .addLast(new StringEncoder(CharsetUtil.UTF_8))
                .addLast(new CmbcDecoder(cmbcDecryptKit))
                .addLast(heartbeatHandler)
//        		.addLast(execGroup, new EqmServerHandler())
                .addLast(clientHandler);
    }
}
