package com.hundsun.ufg.bankgate.cmbc.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.codec.CmbcDecoder;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerAccountMatchHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerBatchAccountMatchHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerBatchTransferMatchHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerCloseAccountResultHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerCommonMsgHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerOpenAccountApplyHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerOpenAccountResultHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerTransferInResultHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerTransferMatchHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerTransferOutApplyHandler;
import com.hundsun.ufg.bankgate.cmbc.handler.ServerTransferOutResultHandler;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author huangsk20406
 * @create 2019-09-05 16:06
 */
@Component
@SuppressWarnings("deprecation")
public class ServerHandlerInitializer extends ChannelInitializer<Channel> {

	@Autowired
	private ServerConnectHandler serverConnectHandler;
	
	@Autowired
	private ServerCommonMsgHandler serverCommonMsgHandler;
	
	@Autowired
	private ServerOpenAccountApplyHandler serverOpenAccountApplyHandler;
	
	@Autowired
	private ServerOpenAccountResultHandler serverOpenAccountResultHandler;
	
	@Autowired
	private ServerTransferInResultHandler serverTransferInResultHandler;
	
	@Autowired
	private ServerTransferOutApplyHandler serverTransferOutApplyHandler;
	
	@Autowired
	private ServerTransferOutResultHandler serverTransferOutResultHandler;
	
	@Autowired
	private ServerCloseAccountResultHandler serverCloseAccountResultHandler;
	
	@Autowired
	private ServerAccountMatchHandler serverAccountMatchHandler;
	
	@Autowired
	private ServerTransferMatchHandler serverTransferMatchHandler;
	
	@Autowired
	private ServerBatchAccountMatchHandler serverBatchAccountMatchHandler;
	
	@Autowired
	private ServerBatchTransferMatchHandler serverBatchTransferMatchHandler;
	
	@Autowired
	private CMBCDecryptKit bankCMBCDecryptKit;
	
	@Autowired
	private StringEncoder stringEncoder;
	
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                //空闲检测
                .addLast(new ServerIdleStateHandler())
                .addLast(stringEncoder)
                .addLast(new CmbcDecoder(bankCMBCDecryptKit))
                .addLast(serverCommonMsgHandler)
                .addLast(serverOpenAccountApplyHandler)
                .addLast(serverOpenAccountResultHandler)
                .addLast(serverTransferInResultHandler)
                .addLast(serverTransferOutApplyHandler)
                .addLast(serverTransferOutResultHandler)
                .addLast(serverCloseAccountResultHandler)
                .addLast(serverAccountMatchHandler)
                .addLast(serverTransferMatchHandler)
                .addLast(serverBatchAccountMatchHandler)
                .addLast(serverBatchTransferMatchHandler)
                .addLast(serverConnectHandler);
    }
}
