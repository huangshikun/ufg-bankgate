package com.hundsun.ufg.bankgate.cmbc.enums;

public enum EnumMsgType {
	
	REQ("REQ", "请求"),
	RSP("RSP", "响应");
	
    private String code;
    
    private String name;

	private EnumMsgType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public String getCode() {
		return code;
	}
}
