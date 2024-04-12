package com.hundsun.ufg.bankgate.cmbc.service;

import org.springframework.stereotype.Service;

import com.hundsun.ufg.bankgate.cmbc.enums.EnumCmbcMsg;
import com.hundsun.ufg.bankgate.cmbc.enums.EnumCmbcService;
import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcRequest;
import com.hundsun.ufg.bankgate.cmbc.util.JaxbUtil;
import com.hundsun.ufg.bankgate.enums.EnumMsg;
import com.hundsun.ufg.bankgate.enums.EnumStatus;
import com.hundsun.ufg.bankgate.request.cmbc.OpenAccountAuditRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;
import com.hundsun.ufg.bankgate.service.base.AbstractExecutorService;

import lombok.extern.slf4j.Slf4j;

/**
 * 民生开户审批
 */
@Service
@Slf4j
public class CmbcOpenAccountAuditExecutorService extends AbstractExecutorService<OpenAccountAuditRequest> {

	@Override
	public void sendMessage(OpenAccountAuditRequest bankRequest, BankResponse bankResponse) {
		CmbcRequest cmbcRequest = super.getCmbcRequest(bankRequest);
		cmbcRequest.setDstServ(EnumCmbcService.OPEN_ACCOUNT_AUDIT.getCode());
		try {
			String xml = JaxbUtil.beanToXml(cmbcRequest);
			log.info("民生银行开户审批请求XML报文:[{}]", xml);
			cmbcRequest.setBody(super.getCmbcBody(xml));
			client.sendMsg(cmbcRequest);
			bankResponse.setReturnStatus(EnumStatus.UNKNOW.getCode());
			bankResponse.setReturnCode(EnumCmbcMsg.RECEIVE_SUCCESS.getCode());
			bankResponse.setReturnMsg(EnumCmbcMsg.RECEIVE_SUCCESS.getMsg());
		} catch (Exception e) {
			bankResponse.setReturnStatus(EnumStatus.FAILURE.getCode());
			bankResponse.setReturnCode(EnumMsg.SYSTEM_ERROR.getCode());
			bankResponse.setReturnMsg(EnumMsg.SYSTEM_ERROR.getMsg());
			log.error("民生银行开户审批异常", e);
		}
	}
}
