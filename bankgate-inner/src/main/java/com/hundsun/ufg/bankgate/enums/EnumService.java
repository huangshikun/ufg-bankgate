package com.hundsun.ufg.bankgate.enums;

/**
 * 
 * 项目名称：uf3.0<br>
 * 类名称：EnumService <br>
 * 类描述： 本系统银行服务码 <br>
 */
public enum EnumService {
	
	ACCOUNT_MATCH("AccountMatch", "接收券商“银证转账协议对账申请”"),
	TRANSFER_MATCH("TransferMatch", "券商发送“银证转账金融对账申请”至民生"),
	OPEN_ACCOUNT_AUDIT("OpenAccountAudit", "券商返回“开通银证转账协议申请”的审批结果"),
	TRANSFER_OUT_AUDIT_PASSIVE("TransferOutAuditPassive", "券商(被动方)发送“券商转银行审批结果” 给民生银行(主动方)"),
	SIGN_IN("SignIn", "签到"),
	SIGN_OUT("SignOut", "签退"),
	MODIFY_PASSWORD("ModifyPassword", "修改密码"),
	COMMON_MSG("CommonMsg", "通用消息返回"),
	TRANSFER_OUT_AUDIT_INITIATIVE("TransferOutAuditInitiative", "券商(主动方)发送“券商转银行审批结果” 给民生银行(被动方)"),
	CLOSE_ACCOUNT("CloseAccount", "券商发送“关闭银证转账协议申请”至银行"),
	BATCH_ACCOUNT_MATCH("BatchAccountMatch", "券商发起“银证协议”批量对账申请"),
	BATCH_TRANSFER_MATCH("BatchTransferMatch", "券商发起“银证转账”批量对账申请");
	
	private String service;
	
	private String desc;

	EnumService(String service, String desc) {
		this.service = service;
		this.desc = desc;
	}

	public String getService() {
		return service;
	}

	public String getDesc() {
		return desc;
	}
}
