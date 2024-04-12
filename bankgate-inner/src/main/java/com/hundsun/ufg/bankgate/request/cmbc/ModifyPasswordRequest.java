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
public class ModifyPasswordRequest extends BankRequest  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "TlrNo", required = true)
	private String tlrNo;
	
	/**
	 * 登录密码
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "Psw", required = true)
	private String psw;
	
	/**
	 * 新登录密码
	 */
	@NotNull(message="不能为空")
	@XmlAttribute(name = "NewPsw", required = true)
	private String newPsw;
}
