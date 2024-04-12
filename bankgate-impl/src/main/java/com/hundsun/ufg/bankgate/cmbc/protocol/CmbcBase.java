package com.hundsun.ufg.bankgate.cmbc.protocol;

import com.hundsun.ufg.bankgate.cmbc.enums.EnumPacketType;

import lombok.Data;

/**
 * 
 * @author huangsk20406
 * @create 2019-09-03 10:48
 */
@Data
public abstract class CmbcBase {
	
//	private String head;
	
	private String body;
	
	private EnumPacketType packetTypeEnum;
}
