package com.hundsun.ufg.bankgate.cmbc.enums;

import com.hundsun.ufg.bankgate.enums.EnumService;

/**
 * 
 * 项目名称：bus<br>
 * 类名称：EnumService <br>
 * 类描述： 本系统银行服务码 <br>
 */
public enum EnumCmbcService {
	
	ACCOUNT_MATCH(EnumService.ACCOUNT_MATCH, "0281103", "接收券商“银证转账协议对账申请”"),
	TRANSFER_MATCH(EnumService.TRANSFER_MATCH, "0281104", "券商发送“银证转账金融对账申请”至民生"),
	OPEN_ACCOUNT_AUDIT(EnumService.OPEN_ACCOUNT_AUDIT, "0281604", "券商返回“开通银证转账协议申请”的审批结果"),
	TRANSFER_OUT_AUDIT_PASSIVE(EnumService.TRANSFER_OUT_AUDIT_PASSIVE, "0281605", "券商(被动方)发送“券商转银行审批结果” 给民生银行(主动方)"),
	SIGN_IN(EnumService.SIGN_IN, "0281606", "签到"),
	SIGN_OUT(EnumService.SIGN_OUT, "0281607", "签退"),
	MODIFY_PASSWORD(EnumService.MODIFY_PASSWORD, "0281608", "修改密码"),
	COMMON_MSG(EnumService.COMMON_MSG, "0281609", "通用消息返回"),
	TRANSFER_OUT_AUDIT_INITIATIVE(EnumService.TRANSFER_OUT_AUDIT_INITIATIVE, "0281610", "券商(主动方)发送“券商转银行审批结果” 给民生银行(被动方)"),
	CLOSE_ACCOUNT(EnumService.CLOSE_ACCOUNT, "0281611", "券商发送“关闭银证转账协议申请”至银行"),
	BATCH_ACCOUNT_MATCH(EnumService.BATCH_ACCOUNT_MATCH, "0281701", "券商发起“银证协议”批量对账申请"),
	BATCH_TRANSFER_MATCH(EnumService.BATCH_TRANSFER_MATCH, "0281702", "券商发起“银证转账”批量对账申请");
	
	private EnumService service;
	
	private String code;
	
	private String desc;

	EnumCmbcService(EnumService service, String code, String desc) {
		this.service = service;
		this.code = code;
		this.desc = desc;
	}

	public EnumService getService() {
		return service;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
