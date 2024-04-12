package com.hundsun.ufg.bankgate.enums;

/**
 * 银行枚举
 */
public enum EnumBank {

	CMBC("CMBC", "民生银行");

	private String code;
	private String name;

	EnumBank(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	/**
	 * 根据银行的代码取得银行枚举
	 * @param code
	 * @return
	 */
	public static EnumBank getByBankCode(String code) {
		if (code == null) {
			return null;
		}

		for (EnumBank enumBank : values()) {
			if (enumBank.getCode().equalsIgnoreCase(code)) {
				return enumBank;
			}
		}

		return null;
	}
}
