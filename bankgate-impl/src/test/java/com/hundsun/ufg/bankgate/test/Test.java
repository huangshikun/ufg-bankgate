package com.hundsun.ufg.bankgate.test;

import javax.xml.bind.JAXBException;

import cn.hutool.core.util.StrUtil;

public class Test {

	public static void main(String[] args) throws JAXBException {
//		CmbcRequest obj = new CmbcRequest();
//		obj.setBankId("BankId");
//		obj.setMsgType("MsgType");
//		obj.setReqSys("ReqSys");
//		obj.setChnlId("ChnlId");
//		obj.setDstApp("DstApp");
//		obj.setDstServ("DstServ");
//		obj.setTxDate("TxDate");
//		obj.setTxTime("TxTime");
//		obj.setRefNo("RefNo");
//		obj.setUserId("UserId");
//		obj.setTermNo("TermNo");
//		obj.setLocale("Locale");
//		SignInRequest singInModel = new SignInRequest();
//		singInModel.setTlrNo("11");
//		singInModel.setPsw("111");
//		obj.setRequest(singInModel);
//		String a = JaxbUtil.beanToXml(obj);
//		System.out.println(a);
//		a = "353SECABC20190910134845336".substring(9);
//		a= "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";
//		System.out.println(a.length());
		String xml = "<DO-DATA BankId=\"353\" MsgType=\"REQ\" ReqSys=\"SECABC\" ChnlId=\"000000\" DstApp=\"BSD\" DstServ=\"BSDB201\" TxDate=\"20170202\" TxTime=\"143700\" RefNo=\"HS20191017125622308\" UserId=\"ABC123\" TermNo=\"000000\" Locale=\"EN\"><DO-MESSAGE AgrNo=\"HS20191017125622308\" SDNo=\"3553ABC\" SecAc=\"11000008\" CusAc=\"11000008519\" HidTyp=\"ID\" HidNo=\"20150716000\" IdTyp=\"ID\" IdNo=\"11\" /></DO-DATA>";
//		String xml = "<DO-MESSAGE AgrNo=\"HS20191017125622308\" SDNo=\"3553ABC\" SecAc=\"11000008\" CusAc=\"11000008519\" HidTyp=\"ID\" HidNo=\"20150716000\" IdTyp=\"ID\" IdNo=\"11\" />";
//		OpenAccountApplyResponse cmbcResponse = JaxbUtil.xmlToBean(xml, OpenAccountApplyResponse.class);
//		BankResponse cmbcResponse = JaxbUtil.xmlToBean(xml, BankResponse.class);
//		CmbcResponse cmbcResponse = JaxbUtil.xmlToBean(xml, CmbcResponse.class);
		System.out.println(StrUtil.subBetween(xml, "DstServ=\"", "\""));
	}

}
