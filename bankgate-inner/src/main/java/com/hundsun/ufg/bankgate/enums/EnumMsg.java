package com.hundsun.ufg.bankgate.enums;

public enum EnumMsg {
	
    LACK_PARAMS("LACK_PARAMS", "缺少参数"),
    BANK_UNSUPPORTED("BANK_UNSUPPORTED", "渠道未支持"),
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),
	TIMEOUT("TIMEOUT", "链接超时");
	
	private String code;
	private String msg;

	EnumMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static EnumMsg getByCode(String code) {
        if (null == code) {
            return null;
        }
        
        for (EnumMsg message : values()) {
            if (message.getCode().equals(code)) {
                return message;
            }
        }
        
        return null;
    }
}
