package com.hundsun.ufg.bankgate.cmbc.future;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcRequest;
import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * @author huangsk20406
 * @create 2019-09-03 15:50
 */
@Component
public class SyncWrite {

	public CmbcResponse writeAndSync(final Channel channel, final CmbcRequest request, final long timeout)
			throws Exception {

		if (channel == null) {
			throw new NullPointerException("channel");
		}
		if (request == null) {
			throw new NullPointerException("request");
		}
		if (timeout <= 0) {
			throw new IllegalArgumentException("timeout <= 0");
		}

		WriteFuture<CmbcResponse> future = new SyncWriteFuture(request.getRefNo());
		CmbcResponse response = doWriteAndSync(channel, request, timeout, future);
		return response;
	}

	private CmbcResponse doWriteAndSync(final Channel channel, final CmbcRequest request, final long timeout,
			final WriteFuture<CmbcResponse> writeFuture) throws Exception {
		
		SyncWriteMap.SYNCKEY.put(request.getRefNo(), writeFuture);
		
		channel.writeAndFlush(request).addListener(new ChannelFutureListener() {
			public void operationComplete(ChannelFuture future) throws Exception {
				writeFuture.setWriteResult(future.isSuccess());
				writeFuture.setCause(future.cause());
				// 失败移除
				if (!writeFuture.isWriteSuccess()) {
					SyncWriteMap.SYNCKEY.remove(writeFuture.requestId());
				}
			}
		});

		CmbcResponse response = writeFuture.get(timeout, TimeUnit.MILLISECONDS);
		if (response == null) {
			if (writeFuture.isTimeout()) {
				throw new TimeoutException();
			} else {
				// write exception
				throw new Exception(writeFuture.cause());
			}
		}
		
		SyncWriteMap.SYNCKEY.remove(request.getRefNo());
		return response;
	}

}
