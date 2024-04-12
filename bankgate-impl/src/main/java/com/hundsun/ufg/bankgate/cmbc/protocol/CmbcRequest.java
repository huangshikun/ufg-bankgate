package com.hundsun.ufg.bankgate.cmbc.protocol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hundsun.ufg.bankgate.request.base.BankRequest;

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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DO-DATA")
@XmlType
public class CmbcRequest extends CmbcBase {
	
	/**
	 * 分行号
	 */
	@XmlAttribute(name = "BankId", required = true)
	private String bankId;
	
	/**
	 * 报文类型
	 */
	@XmlAttribute(name = "MsgType", required = true)
	private String msgType;
	
	/**
	 * 请求系统
	 */
	@XmlAttribute(name = "ReqSys", required = true)
	private String reqSys;
	
	/**
	 * 渠道系统标识
	 */
	@XmlAttribute(name = "ChnlId", required = true)
	private String chnlId;
	
	/**
	 * 目标应用
	 */
	@XmlAttribute(name = "DstApp", required = true)
	private String dstApp;
	
	/**
	 * 目标服务
	 */
	@XmlAttribute(name = "DstServ", required = true)
	private String dstServ;
	
	/**
	 * 请求日期
	 */
	@XmlAttribute(name = "TxDate", required = true)
	private String txDate;
	
	/**
	 * 请求时间
	 */
	@XmlAttribute(name = "TxTime", required = true)
	private String txTime;
	
	/**
	 * 报文ID
	 */
	@XmlAttribute(name = "RefNo", required = true)
	private String refNo;
	
	/**
	 * 用户ID
	 */
	@XmlAttribute(name = "UserId", required = true)
	private String userId;
	
	/**
	 * 终端号
	 */
	@XmlAttribute(name = "TermNo", required = true)
	private String termNo;
	
	/**
	 * 语言标识
	 */
	@XmlAttribute(name = "Locale", required = true)
	private String locale;
	
	/**
	 * 标识报文体私有区域
	 */
	@XmlElementRef
	private BankRequest request;
}
