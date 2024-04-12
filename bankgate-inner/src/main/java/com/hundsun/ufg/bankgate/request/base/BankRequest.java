package com.hundsun.ufg.bankgate.request.base;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.hundsun.ufg.bankgate.request.cmbc.AccountMatchRequest;
import com.hundsun.ufg.bankgate.request.cmbc.BatchAccountMatchRequest;
import com.hundsun.ufg.bankgate.request.cmbc.BatchTransferMatchRequest;
import com.hundsun.ufg.bankgate.request.cmbc.CloseAccountRequest;
import com.hundsun.ufg.bankgate.request.cmbc.CommonMsgRequest;
import com.hundsun.ufg.bankgate.request.cmbc.ModifyPasswordRequest;
import com.hundsun.ufg.bankgate.request.cmbc.OpenAccountAuditRequest;
import com.hundsun.ufg.bankgate.request.cmbc.SignInRequest;
import com.hundsun.ufg.bankgate.request.cmbc.SignOutRequest;
import com.hundsun.ufg.bankgate.request.cmbc.TransferMatchRequest;
import com.hundsun.ufg.bankgate.request.cmbc.TransferOutAuditInitiativeRequest;
import com.hundsun.ufg.bankgate.request.cmbc.TransferOutAuditPassiveRequest;

import lombok.Data;

/**
 * 银行网关请求bean
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ SignInRequest.class, SignOutRequest.class, OpenAccountAuditRequest.class,
		TransferOutAuditPassiveRequest.class, TransferOutAuditInitiativeRequest.class, CloseAccountRequest.class,
		AccountMatchRequest.class, TransferMatchRequest.class, ModifyPasswordRequest.class, CommonMsgRequest.class, BatchAccountMatchRequest.class, BatchTransferMatchRequest.class })
public class BankRequest implements Serializable {

	private static final long serialVersionUID = 5971916287187504632L;

	/**
	 * 渠道编码：是指银行、第三方渠道的机构编码（必输项）
	 */
	@XmlTransient
	@NotNull(message="不能为空")
	private String bankCode;

	/**
	 * 交易码：用于区分绑卡、支付、代收、代付、下载对账文件等等业务（必输项）
	 */
	@XmlTransient
	@NotNull(message="不能为空")
	private String service;
	
	/** 
	 * 商户订单号，商户网站订单系统中唯一订单号(必填项)
	 */
	@XmlTransient
	@NotNull(message="不能为空")
	private String outTradeNo;

	/**
	 * 请求日期 yyyyMMdd
	 */
	@XmlTransient
	@NotNull(message="不能为空")
	private String requestDate;

	/**
	 * 请求时间 HHMMSS
	 */
	@XmlTransient
	@NotNull(message="不能为空")
	private String requestTime;
	
	/** 订单名称(支付宝-必填项) */
//	private String subject;
	
	/** 交易金额,单位为分(必填项)**/
//	private String totalAmount;
	
	/** 商品描述(可选；微信-必填项) **/
//	private String body;
	
	/** 返回地址(可选) **/
//	private String returnUrl;
	
	/** 超时时间(单位：分钟) 例如:1m 表示1分钟(可选)**/
//	private String timeoutExpress;
	
	/** 终端IP(微信-必填项)**/
//	private String spbillCreateIp;
	
	/** 交易起始时间(微信-必填项)**/
//	private Date timeStart;
	
	/** JSAPI 公众号支付;NATIVE 扫码支付;APP APP支付(微信-必填项)**/
//	private String tradeType;
	
	/** 用户标识(微信JSAPI 公众号支付-必填项)**/
//	private String openId;
	
	/**清算日期 格式：yyyyMMdd**/
//	private String billDate;
	
	/**退款单号-本次退款交易的订单号(必填)**/
//	private String outRefundNo;
	
	/** JSAPI 公众号支付;NATIVE 扫码支付;APP APP支付(微信-必填项)**/
//	private String tradeType;
}