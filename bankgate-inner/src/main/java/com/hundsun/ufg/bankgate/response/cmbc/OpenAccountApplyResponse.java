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
public class OpenAccountApplyResponse extends BankResponse  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 协议编号
	 */
	@XmlAttribute(name = "AgrNo", required = true)
	private String agrNo;
	
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
	 * 客户内地证件类型
	 */
	@XmlAttribute(name = "HidTyp", required = true)
	private String hidTyp;
	
	/**
	 * 客户内地证件号码
	 */
	@XmlAttribute(name = "HidNo", required = true)
	private String hidNo;
	
	/**
	 * 客户香港本地证件类型
	 */
	@XmlAttribute(name = "IdTyp", required = true)
	private String idTyp;
	
	/**
	 * 客户香港本地证件号码
	 */
	@XmlAttribute(name = "IdNo", required = true)
	private String idNo;
}
