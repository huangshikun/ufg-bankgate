
package com.hundsun.ufg.bankgate.service.base;

import com.hundsun.ufg.bankgate.request.base.BankRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;

/**
 * 本接口主要负责与银行的通讯,消息发送器与外界联系的接口
 */
public interface BankService {
	
	String EXECUTOR_SERVICE = "ExecutorService";
	
    /**
     * 请求服务
     * @param bankRequest
     * @return
     */
	<T extends BankRequest> BankResponse send(T bankRequest);
}
