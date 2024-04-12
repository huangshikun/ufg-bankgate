package com.hundsun.ufg.bankgate.cmbc.service;

import org.springframework.stereotype.Service;

import com.hundsun.ufg.bankgate.cmbc.enums.EnumCmbcMsg;
import com.hundsun.ufg.bankgate.cmbc.enums.EnumCmbcService;
import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcRequest;
import com.hundsun.ufg.bankgate.cmbc.util.JaxbUtil;
import com.hundsun.ufg.bankgate.enums.EnumMsg;
import com.hundsun.ufg.bankgate.enums.EnumStatus;
import com.hundsun.ufg.bankgate.request.cmbc.TransferMatchRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;
import com.hundsun.ufg.bankgate.service.base.AbstractExecutorService;

import lombok.extern.slf4j.Slf4j;

/**
 * 民生转账对账
 */
@Service
@Slf4j
public class CmbcTransferMatchExecutorService extends AbstractExecutorService<TransferMatchRequest> {

	@Override
	public void sendMessage(TransferMatchRequest bankRequest, BankResponse bankResponse) {
		CmbcRequest cmbcRequest = super.getCmbcRequest(bankRequest);
		cmbcRequest.setDstServ(EnumCmbcService.TRANSFER_MATCH.getCode());
		try {
			String xml = JaxbUtil.beanToXml(cmbcRequest);
			log.info("民生银行转账对账请求XML报文:[{}]", xml);
			cmbcRequest.setBody(super.getCmbcBody(xml));
			client.sendMsg(cmbcRequest);
			bankResponse.setReturnStatus(EnumStatus.UNKNOW.getCode());
			bankResponse.setReturnCode(EnumCmbcMsg.RECEIVE_SUCCESS.getCode());
			bankResponse.setReturnMsg(EnumCmbcMsg.RECEIVE_SUCCESS.getMsg());
		} catch (Exception e) {
			bankResponse.setReturnStatus(EnumStatus.FAILURE.getCode());
			bankResponse.setReturnCode(EnumMsg.SYSTEM_ERROR.getCode());
			bankResponse.setReturnMsg(EnumMsg.SYSTEM_ERROR.getMsg());
			log.error("民生银行转账对账异常", e);
		}
	}
}
