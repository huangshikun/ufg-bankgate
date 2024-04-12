package com.hundsun.ufg.bankgate.response.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.Data;

/**
 * 银行网关响应bean
 */
@Data
@XmlAccessorType(XmlAccessType.NONE)
//@XmlSeeAlso({ CommonMsgResponse.class, OpenAccountApplyResponse.class, OpenAccountResultResponse.class,
//	TransferInResponse.class, TransferOutApplyResponse.class, TransferOutResultResponse.class,
//	CloseAccountResultResponse.class, AccountMatchResponse.class, TransferMatchResponse.class,
//	BatchAccountMatchResponse.class, BatchTransferMatchResponse.class })
public class BankResponse implements Serializable {
    
	private static final long serialVersionUID = 2303553045388732289L;

	/**
     * 返回状态
     */
    private String returnStatus;
    
    /**
     * 返回码
     */
    private String returnCode;
    
    /**
     * 返回消息
     */
    private String returnMsg;
    
    /**
     * 支付宝/微信预下单返回信息
     */
//    private String result;
    
    /**
	 * 银行端交易单号
	 */
//	private String tradeNo;
	
	/**
	 * 对账文件路径
	 */
//	private String filePath;
}
