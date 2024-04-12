package com.hundsun.ufg.bankgate.cmbc.enums;

import com.hundsun.ufg.bankgate.response.cmbc.AccountMatchResponse;
import com.hundsun.ufg.bankgate.response.cmbc.BatchAccountMatchResponse;
import com.hundsun.ufg.bankgate.response.cmbc.BatchTransferMatchResponse;
import com.hundsun.ufg.bankgate.response.cmbc.CloseAccountResultResponse;
import com.hundsun.ufg.bankgate.response.cmbc.CommonMsgResponse;
import com.hundsun.ufg.bankgate.response.cmbc.OpenAccountApplyResponse;
import com.hundsun.ufg.bankgate.response.cmbc.OpenAccountResultResponse;
import com.hundsun.ufg.bankgate.response.cmbc.TransferInResponse;
import com.hundsun.ufg.bankgate.response.cmbc.TransferMatchResponse;
import com.hundsun.ufg.bankgate.response.cmbc.TransferOutApplyResponse;
import com.hundsun.ufg.bankgate.response.cmbc.TransferOutResultResponse;

/**
 * 
 * 项目名称：uf3.0<br>
 * 类名称：EnumDstServ <br>
 * 类描述： 本系统银行目标服务码 <br>
 */
public enum EnumDstServ {
	
	ACCOUNT_MATCH("BSDB301", AccountMatchResponse.class, "接收到券商“银证转账协议对账”申请后，银行将对应协议信息返回给券商"),
	BATCH_ACCOUNT_MATCH("BSDB401", BatchAccountMatchResponse.class, "银行返回“银证协议”批量对账记录信息至券商"),
	BATCH_TRANSFER_MATCH("BSDB402", BatchTransferMatchResponse.class, "银行返回“银证转账”批量记录信息"),
	CLOSE_ACCOUNT("BSDB204", CloseAccountResultResponse.class, "民生银行接收到客户解除券商银证转账协议的申请后，通过此接口把该申请发送至券商审批"),
	COMMON_MSG("BSDB004", CommonMsgResponse.class, "1.返回交易过程中遇到的异常信息;2.接口 BSDS001,BSDS002,BSDS003 的处理结果，银行通过此接口返回给券商。 "),
	OPEN_ACCOUNT_APPLY("BSDB201", OpenAccountApplyResponse.class, "民生银行接收到客户开通银证转账协议的申请后，银行会对资料做合法性检查，检查通过后，通过此接口发送该开通申请至券商"),
	OPEN_ACCOUNT_RESULT("BSDB202", OpenAccountResultResponse.class, "民生银行接收到券商通过BSDS201返回的审批成功的结果后，会做银证转账关联，并通过此接口发送最终银证转账协议开通成功/失败结果至券商。"),
	TRANSFER_IN("BSDB101", TransferInResponse.class, "客户通过网银发起银证转账，把交易指令通过此接口发送至券商。"),
	TRANSFER_MATCH("BSDB302", TransferMatchResponse.class, "接收到券商“银证转账金融流水对账”申请后，银行将对应金融流水信息返回给券商"),
	TRANSFER_OUT_APPLY("BSDB102", TransferOutApplyResponse.class, "民生银行收到客户券商转银行的申请后，把该申请通过此接口发送至券商审批"),
	TRANSFER_OUT_RESULT("BSDB104", TransferOutResultResponse.class, "民生银行接收到券商对“券转银”的审批同意的结果后，进行相应的转账处理，并将结果通过此接口发送至券商");
	
	private String code;
	
	private Class<?> clazz;
	
	private String desc;

	EnumDstServ(String code, Class<?> clazz, String desc) {
		this.code = code;
		this.clazz = clazz;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public Class<?> getClazz() {
		return clazz;
	}
	
	/**
	 * 根据银行目标服务码取得对应枚举
	 * @param code
	 * @return
	 */
	public static EnumDstServ getByCode(String code) {
		if (code == null) {
			return null;
		}

		for (EnumDstServ enumDstServ : values()) {
			if (enumDstServ.getCode().equals(code)) {
				return enumDstServ;
			}
		}

		return null;
	}
}
