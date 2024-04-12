package com.hundsun.ufg.bankgate.response.cmbc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

/**
 * 民生银行转账bean
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class TraRecordResponse implements Serializable {
    
	private static final long serialVersionUID = 2303553045388732289L;
	
	/**
	 * 任务类型
	 */
	@XmlAttribute(name = "TskTyp", required = true)
	private String tskTyp;
	
	/**
	 * 任务状态
	 */
	@XmlAttribute(name = "TskSts", required = true)
	private String tskSts;
	
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
	 * 币种
	 */
	@XmlAttribute(name = "Ccy", required = true)
	private String ccy;
	
	/**
	 * 交易金额
	 */
	@XmlAttribute(name = "Amt", required = true)
	private String amt;
	
	/**
	 * 交易日期
	 */
	@XmlAttribute(name = "TraDat", required = true)
	private String traDat;
	
	/**
	 * 业务流水号
	 */
	@XmlAttribute(name = "OrgRefNo", required = true)
	private String orgRefNo;
	
	/**
	 * 对账日期
	 */
	@XmlAttribute(name = "AcCkDt", required = true)
	private String acCkDt;
}
