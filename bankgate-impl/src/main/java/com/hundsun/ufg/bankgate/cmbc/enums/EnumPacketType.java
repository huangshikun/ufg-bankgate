package com.hundsun.ufg.bankgate.cmbc.enums;

public enum EnumPacketType {
	
	CONNECT_BUILD(0, "连接建立"),
	CONNECT_CLEAN(1, "连接清理"),
	HEARTBEAT_KEEPALIVE(2, "心跳保活"),
	REQUEST_RECEIVE(3, "请求接收"),
	RECEIVE_SUCCESS(4, "接收成功");
	
    private int code;
    
    private String name;

	private EnumPacketType(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public int getCode() {
		return code;
	}
}
