package com.hundsun.ufg.bankgate.response.cmbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hundsun.ufg.bankgate.response.base.BankResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author huangsk20406
 * @create 2019-09-03 10:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@XmlRootElement(name = "DO-MESSAGE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class CommonMsgResponse extends BankResponse  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 原交易业务流水号
	 */
	@XmlAttribute(name = "OrgRefNo", required = true)
	private String orgRefNo;
	
	/**
	 * 原服务码
	 */
	@XmlAttribute(name = "OrgItfNo", required = true)
	private String orgItfNo;
	
	/**
	 * 消息类型
	 */
	@XmlAttribute(name = "MsgTyp", required = true)
	private String msgTyp;
	
	/**
	 * 错误码
	 */
	@XmlAttribute(name = "MsgCod", required = true)
	private String msgCod;
	
	/**
	 * 错误原因
	 */
	@XmlAttribute(name = "MsgInfo")
	private String msgInfo;
}
