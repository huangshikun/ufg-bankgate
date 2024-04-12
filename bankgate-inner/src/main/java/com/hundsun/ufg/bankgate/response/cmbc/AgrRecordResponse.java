package com.hundsun.ufg.bankgate.response.cmbc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

/**
 * 民生银行协议bean
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class AgrRecordResponse implements Serializable {
    
	private static final long serialVersionUID = 2303553045388732289L;
	
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
	 * 交易状态
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
