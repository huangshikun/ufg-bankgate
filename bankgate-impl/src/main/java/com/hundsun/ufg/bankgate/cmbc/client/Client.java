package com.hundsun.ufg.bankgate.cmbc.client;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcRequest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangsk20406
 * @create 2019-09-02 16:08
 */
@Component
@Slf4j
public class Client  {
	
    private EventLoopGroup group = new NioEventLoopGroup();
    
    @Value("${cmbc.port}")
    private int port;
    
    @Value("${cmbc.host}")
    private String host;
    
//    @Autowired
//    private SyncWrite syncWrite;
    
    @Autowired
    private ClientHandlerInitilizer clientHandlerInitilizer;
    
    private SocketChannel socketChannel;

//    public BaseResponse sendMsg(BaseRequest req) {
//    	try {
//			syncWrite.writeAndSync(socketChannel, req, 10000L);
//		} catch (Exception e) {
//			log.error("", e);
//		}
//    	
//    	return null;
//    }
    
    public void sendMsg(CmbcRequest req) {
		socketChannel.writeAndFlush(req);
    }

    @PostConstruct
    public void start()  {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(clientHandlerInitilizer);
        ChannelFuture future = bootstrap.connect();
        // 客户端断线重连逻辑
        future.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                log.info("连接Netty服务端成功");
            } else {
                log.info("连接失败，进行断线重连");
                channelFuture.channel().eventLoop().schedule(() -> start(), 30L, TimeUnit.SECONDS);
            }
        });
        socketChannel = (SocketChannel) future.channel();
    }
    
    @PreDestroy
    public void destory() throws InterruptedException {
    	group.shutdownGracefully().sync();
        log.info("关闭客户端Netty");
    }
}
