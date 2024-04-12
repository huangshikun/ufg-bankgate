package com.hundsun.ufg.bankgate.response.cmbc;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
public class BatchAccountMatchResponse extends BankResponse  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 批次总数
	 */
	@XmlAttribute(name = "BthCnt", required = true)
	private String bthCnt;
	
	/**
	 * 当前批次号
	 */
	@XmlAttribute(name = "BthNo", required = true)
	private String bthNo;
	
	/**
	 * 本批笔数
	 */
	@XmlAttribute(name = "CurRecCnt", required = true)
	private String curRecCnt;
	
	/**
	 * 总笔数
	 */
	@XmlAttribute(name = "TotRecCnt", required = true)
	private String totRecCnt;
	
	/**
	 * 对账日期
	 */
	@XmlAttribute(name = "AcCkDt", required = true)
	private String acCkDt;
	
	/**
	 * 协议集合
	 */
	@XmlElement(name = "AgrRecord", required = true)
	private List<AgrRecordResponse> recordList;
}
