package com.hundsun.ufg.bankgate.cmbc.enums;

public enum EnumCmbcMsg {

	RECEIVE_SUCCESS("00000000", "接收成功");
	
//	WAIT_BUYER_PAY("WAIT_BUYER_PAY", "交易创建，等待买家付款"),
//	TRADE_SUCCESS("TRADE_SUCCESS", "交易支付成功"),
//	TRADE_FINISHED("TRADE_FINISHED", "交易结束，不可退款"),
//    TRADE_CLOSED("TRADE_CLOSED", "未付款交易超时关闭，或支付完成后全额退款"),
//
//    REFUND_PROCESSING("REFUND_PROCESSING", "退款处理中"),
//    REFUND_SUCCESS("REFUND_SUCCESS", "退款处理成功"),
//    REFUND_FAIL("REFUND_FAIL", "退款失败"),
//
//    SYSTEM_ERROR("ACQ.SYSTEM_ERROR", "系统错误"),
//    INVALID_PARAMETER("ACQ.INVALID_PARAMETER", "参数无效"),
//    TRADE_NOT_EXIST("ACQ.TRADE_NOT_EXIST", "查询的交易不存在"),
//	
//    Y("Y", "本次退款发生了资金变化"),
	
	private String code;
	private String msg;

	private EnumCmbcMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
