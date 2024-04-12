package com.hundsun.ufg.bankgate.cmbc.future;

import java.util.concurrent.Future;

import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcResponse;

/**
 * @author huangsk20406
 * @create 2019-09-03 15:50
 */
public interface WriteFuture<T> extends Future<T> {

	Throwable cause();

	void setCause(Throwable cause);

	boolean isWriteSuccess();

	void setWriteResult(boolean result);

	String requestId();

	T response();

	void setResponse(CmbcResponse response);

	boolean isTimeout();

}
