package com.hundsun.ufg.bankgate.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.ufg.bankgate.enums.EnumMsg;
import com.hundsun.ufg.bankgate.enums.EnumStatus;
import com.hundsun.ufg.bankgate.request.base.BankRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;
import com.hundsun.ufg.bankgate.service.BankgateService;
import com.hundsun.ufg.bankgate.service.base.BankService;
import com.hundsun.ufg.base.BaseService;

import lombok.extern.slf4j.Slf4j;

/**
 * 银行网关的对外统一接口
 * @author huangsk20406
 * @create 2019-09-05 10:50
 */
@CloudComponent
@Slf4j
public class BankgateServiceImpl extends BaseService implements BankgateService {
	
//	@Value("${system.dev.mode}")
//	private boolean devMode;
	
	@Autowired
	private Map<String, BankService> bankServiceMap = new HashMap<>();
	
	@Override
	public BankResponse bankService(Object request) {
		log.info("银行网关收到请求报文:[{}]", request.toString());
		
		BankRequest bankRequest = (BankRequest) request;
		BankResponse bankResponse = null;
		
//		if (devMode) {
//			logger.info("银行网关开发模式system.dev.mode：{}", devMode);
//			bankResponse = new BankResponse();
//			bankResponse.setReturnStatus(EnumBankStatus.SUCCESS.getCode());
//	        bankResponse.setReturnCode(EnumInfoMessage.MSG_0000.getCode());
//	        bankResponse.setReturnMsg(EnumInfoMessage.MSG_0000.getMessage());
//	        return bankResponse;
//		}

		// 1.获取渠道的执行器
		BankService bankService = bankServiceMap.get(bankRequest.getBankCode().toLowerCase() + "BankService");
		if (bankService == null) {
			bankResponse = new BankResponse();
			bankResponse.setReturnStatus(EnumStatus.FAILURE.getCode());
			bankResponse.setReturnCode(EnumMsg.BANK_UNSUPPORTED.getCode());
			bankResponse.setReturnMsg(EnumMsg.BANK_UNSUPPORTED.getMsg());
			log.error("银行渠道:[{}]未支持", bankRequest.getBankCode());
			return bankResponse;
		}
		
		bankResponse = bankService.send(bankRequest);
		log.info("银行网关返回响应报文:[{}]", bankResponse.toString());
		return bankResponse;
	}
}
