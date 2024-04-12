package com.hundsun.ufg.bankgate.cmbc.future;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;

/**
 * @author huangsk20406
 * @create 2019-09-03 15:50
 */
public class SyncWriteFuture implements WriteFuture<CmbcResponse> {

	private CountDownLatch latch = new CountDownLatch(1);
	private final long begin = System.currentTimeMillis();
	private long timeout;
	private CmbcResponse response;
	private final String requestId;
	private boolean writeResult;
	private Throwable cause;
	private boolean isTimeout = false;

	public SyncWriteFuture(String requestId) {
		this.requestId = requestId;
	}

	public SyncWriteFuture(String requestId, long timeout) {
		this.requestId = requestId;
		this.timeout = timeout;
		this.writeResult = true;
		this.isTimeout = false;
	}

	public Throwable cause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public boolean isWriteSuccess() {
		return writeResult;
	}

	public void setWriteResult(boolean result) {
		this.writeResult = result;
	}

	public String requestId() {
		return requestId;
	}

	public CmbcResponse response() {
		return response;
	}

	public void setResponse(CmbcResponse response) {
		this.response = response;
		latch.countDown();
	}

	public boolean cancel(boolean mayInterruptIfRunning) {
		return true;
	}

	public boolean isCancelled() {
		return false;
	}

	public boolean isDone() {
		return false;
	}

	public CmbcResponse get() throws InterruptedException, ExecutionException {
		latch.wait();
		return response;
	}

	public CmbcResponse get(long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		if (latch.await(timeout, unit)) {
			return response;
		}
		return null;
	}

	public boolean isTimeout() {
		if (isTimeout) {
			return isTimeout;
		}
		return System.currentTimeMillis() - begin > timeout;
	}
}
