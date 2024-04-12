package com.hundsun.ufg.bankgate.request.cmbc;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
@XmlRootElement(name = "DO-MESSAGE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class TransferOutAuditPassiveRequest extends BankRequest  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 申请业务的交易流水号
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "OrgRefNo", required = true)
	private String orgRefNo;
	
	/**
	 * 券商编号
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "SDNo", required = true)
	private String sdNo;
	
	/**
	 * 客户证券号码
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "SecAc", required = true)
	private String secAc;
	
	/**
	 * 客户银行账号
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "CusAc", required = true)
	private String cusAc;
	
	/**
	 * 币种
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "Ccy", required = true)
	private String ccy;
	
	/**
	 * 交易金额
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "Amt", required = true)
	private String amt;
	
	/**
	 * 审批结果
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "AprSts", required = true)
	private String aprSts;
	
	/**
	 * 拒绝代码
	 */
	@XmlAttribute(name = "RejCod")
	private String rejCod;
}
