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
public class TransferMatchResponse extends BankResponse  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 任务类型
	 */
	@XmlAttribute(name = "TskTyp", required = true)
	private String tskTyp;
	
	/**
	 * 交易状态
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
