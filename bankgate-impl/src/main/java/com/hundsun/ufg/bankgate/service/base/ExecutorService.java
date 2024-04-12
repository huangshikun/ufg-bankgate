
package com.hundsun.ufg.bankgate.service.base;

import com.hundsun.ufg.bankgate.request.base.BankRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;

/**
 * 交易中心作为客户端向招行发送消息的执行器，处理逻辑都在此接口完成
  */
public interface ExecutorService<T extends BankRequest> {
	
	BankResponse execute(T bankRequest);

	void sendMessage(T bankRequest, BankResponse bankResponse);
	
	String checkParam(T bankRequest);
	
	void setReturnStatus(BankResponse bankResponse);
}
