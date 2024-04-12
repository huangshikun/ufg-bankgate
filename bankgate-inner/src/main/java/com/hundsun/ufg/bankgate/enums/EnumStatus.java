package com.hundsun.ufg.bankgate.enums;

/**
 * 银行网关的处理状态
 * @author huangsk20406
 */
public enum EnumStatus {

	SUCCESS("SUCCESS", "成功"), FAILURE("FAILURE", "失败"), UNKNOW("UNKNOW", "未知");
	
	private String code;
	
	private String desc;

	EnumStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static EnumStatus getByCode(String code) {
		if (code == null) {
			return null;
		}
		
		for (EnumStatus type : values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		
		return null;
	}
}
