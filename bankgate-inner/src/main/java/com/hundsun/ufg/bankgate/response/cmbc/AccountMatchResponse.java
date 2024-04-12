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
public class AccountMatchResponse extends BankResponse  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 交易日期
	 */
	@XmlAttribute(name = "TraDat", required = true)
	private String traDat;
	
	/**
	 * 协议编号
	 */
	@XmlAttribute(name = "AgrNo", required = true)
	private String agrNo;
	
	/**
	 * 状态
	 */
	@XmlAttribute(name = "Status", required = true)
	private String status;
	
	/**
	 * 券商编号
	 */
	@XmlAttribute(name = "SDNo", required = true)
	private String sdNo;
	
	/**
	 * 客户证券号码
	 */
	@XmlAttribute(name = "SecAc", required = true)
	private String secAc;
	
	/**
	 * 客户银行账号
	 */
	@XmlAttribute(name = "CusAc", required = true)
	private String cusAc;
	
	/**
	 * 对账日期
	 */
	@XmlAttribute(name = "AcCkDt", required = true)
	private String acCkDt;
}
