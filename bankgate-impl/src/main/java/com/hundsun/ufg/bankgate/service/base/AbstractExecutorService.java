package com.hundsun.ufg.bankgate.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.ufg.bankgate.cmbc.client.Client;
import com.hundsun.ufg.bankgate.cmbc.config.CmbcConfig;
import com.hundsun.ufg.bankgate.cmbc.protocol.CmbcRequest;
import com.hundsun.ufg.bankgate.enums.EnumMsg;
import com.hundsun.ufg.bankgate.enums.EnumStatus;
import com.hundsun.ufg.bankgate.request.base.BankRequest;
import com.hundsun.ufg.bankgate.response.base.BankResponse;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import cfca.sadk.cmbc.tools.DecryptKitException;
import cmbc.cfca.util.Base64;

@SuppressWarnings("deprecation")
public abstract class AbstractExecutorService<T extends BankRequest> implements ExecutorService<T> {

	@Autowired
	protected CMBCDecryptKit cmbcDecryptKit;
	
	@Autowired
	protected Client client;
	
	@Autowired
	protected CmbcConfig cmbcConfig;
	
	@Override
	public BankResponse execute(T bankRequest) {
		BankResponse bankResponse = new BankResponse();

		// 1.检查参数
		String returnMsg = checkParam(bankRequest);
		if (null != returnMsg) {
			bankResponse.setReturnStatus(EnumStatus.FAILURE.getCode());
			bankResponse.setReturnCode(EnumMsg.LACK_PARAMS.getCode());
			bankResponse.setReturnMsg(returnMsg);
			return bankResponse;
		}
		
		// 2.生成报文并且发送
		sendMessage(bankRequest, bankResponse);
		
		// 3.设置返回状态
		setReturnStatus(bankResponse);
		return bankResponse;
	}
	
	@Override
	public String checkParam(T bankRequest) {
		return null;
	}

	@Override
	public void setReturnStatus(BankResponse bankResponse) {}
	
	protected CmbcRequest getCmbcRequest(T bankRequest) {
		CmbcRequest cmbcRequest = new CmbcRequest();
		cmbcRequest.setBankId(cmbcConfig.getBankId());
		cmbcRequest.setMsgType(CmbcConfig.MSG_TYPE_REQ);
		cmbcRequest.setReqSys(cmbcConfig.getReqSys());
		cmbcRequest.setChnlId(cmbcConfig.getChnlId());
		cmbcRequest.setDstApp(cmbcConfig.getDstApp());
		cmbcRequest.setTxDate(bankRequest.getRequestDate());
		cmbcRequest.setTxTime(bankRequest.getRequestTime());
		cmbcRequest.setRefNo(bankRequest.getOutTradeNo());
		cmbcRequest.setUserId(cmbcConfig.getUserId());
		cmbcRequest.setTermNo(cmbcConfig.getTermNo());
		cmbcRequest.setLocale(cmbcConfig.getLocale());
		cmbcRequest.setRequest(bankRequest);
		return cmbcRequest;
	}
	
	protected String getCmbcBody(String xml) throws DecryptKitException {
		return cmbcConfig.getBankId() + cmbcConfig.getReqSys() + cmbcDecryptKit.SignAndEncryptMessage(new String(Base64.encode(xml.getBytes())));
	}
}