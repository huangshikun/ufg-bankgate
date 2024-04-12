package com.hundsun.ufg.bankgate.service.base;

import com.hundsun.ufg.bankgate.enums.EnumMsg;
import com.hundsun.ufg.bankgate.enums.EnumStatus;
import com.hundsun.ufg.bankgate.request.base.BankRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;
import com.hundsun.ufg.base.AppContext;

public abstract class AbstractBankService implements BankService {

	@Override
	public <T extends BankRequest> BankResponse send(T bankRequest) {
		// 1.取得执行器
		String serviceName = bankRequest.getBankCode().toLowerCase() + bankRequest.getService() + BankService.EXECUTOR_SERVICE;
		@SuppressWarnings("unchecked")
		ExecutorService<T> handlerService = AppContext.getBean(serviceName, ExecutorService.class);
		if (null == handlerService) {
			BankResponse response = new BankResponse();
			response.setReturnStatus(EnumStatus.FAILURE.getCode());
			response.setReturnCode(EnumMsg.BANK_UNSUPPORTED.getCode());
			response.setReturnMsg(EnumMsg.BANK_UNSUPPORTED.getMsg());
			return response;
		}

		// 2.根据请求信息获取报文
		return handlerService.execute(bankRequest);
	}
}
