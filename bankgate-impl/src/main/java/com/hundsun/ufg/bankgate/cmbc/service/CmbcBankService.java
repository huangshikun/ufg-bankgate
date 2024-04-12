package com.hundsun.ufg.bankgate.cmbc.service;

import org.springframework.stereotype.Service;

import com.hundsun.ufg.bankgate.request.base.BankRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;
import com.hundsun.ufg.bankgate.service.base.AbstractBankService;

@Service
public class CmbcBankService extends AbstractBankService {

	@Override
	public <T extends BankRequest> BankResponse send(T bankRequest) {
		return super.send(bankRequest);
	}
}
