package com.hundsun.ufg.bankgate.test;

import javax.xml.bind.JAXBException;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import cfca.sadk.cmbc.tools.DecryptKitException;
import cmbc.cfca.util.Base64;

/**
 * 券商加密加签消息
 * @author 
 *
 */
@SuppressWarnings("deprecation")
public final class ClientEncrypt {

    public static void main(String[] args) throws DecryptKitException, JAXBException {
//    	CmbcResponse cmbcResponse = new CmbcResponse();
//    	cmbcResponse.setBankId("353");
//    	cmbcResponse.setMsgType(CmbcConfig.MSG_TYPE_REQ);
//    	cmbcResponse.setReqSys("SEHSZQ");
//    	cmbcResponse.setChnlId("SEHS01");
//    	cmbcResponse.setDstApp("IBPBSD");
//    	cmbcResponse.setDstServ(EnumCmbcService.SIGN_IN.getCode());
//    	cmbcResponse.setTxDate("20190910");
//    	cmbcResponse.setTxTime("153700");
//    	cmbcResponse.setRefNo("1234567890qwertyuiopasdfghjklzxc");
//    	cmbcResponse.setUserId("SEHSZQ01");
//    	cmbcResponse.setTermNo("000000");
//    	cmbcResponse.setLocale("EN");
    	// 登录
//    	CommonMsgResponse signInResponse = new CommonMsgResponse();
//    	signInResponse.setOrgRefNo("1234567890qwertyuiopasdfghjklzxc");
//    	signInResponse.setMsgCod("BD0012");
//    	signInResponse.setMsgInfo("用户已签到");
//    	signInResponse.setMsgTyp("E");
//    	signInResponse.setOrgItfNo("0281606");
//    	cmbcResponse.setResponse(signInResponse);
    	// 开户申请
//    	OpenAccountApplyResponse openAccountResponse = new OpenAccountApplyResponse();
//    	openAccountResponse.setAgrNo("SEXX180213000029");
//    	openAccountResponse.setCusAc("100000282");
//    	openAccountResponse.setHidNo("411528199009170711");
//    	openAccountResponse.setHidTyp("CD");
//    	openAccountResponse.setIdNo("O20170118");
//    	openAccountResponse.setIdTyp("PP");
//    	openAccountResponse.setSdNo("SEXXZQ01");
//    	openAccountResponse.setSecAc("1234567890");
//    	cmbcResponse.setResponse(openAccountResponse);
    	// 开户结果
//    	OpenAccountResultResponse openAccountResultResponse = new OpenAccountResultResponse();
//    	openAccountResultResponse.setAgrNo("SEXX180213000029");
//    	openAccountResultResponse.setCusAc("100000282");
//    	openAccountResultResponse.setHidNo("411528199009170711");
//    	openAccountResultResponse.setHidTyp("CD");
//    	openAccountResultResponse.setIdNo("O20170118");
//    	openAccountResultResponse.setIdTyp("PP");
//    	openAccountResultResponse.setSdNo("SEXXZQ01");
//    	openAccountResultResponse.setSecAc("1234567890");
//    	openAccountResultResponse.setRslFlg("Y");
//    	cmbcResponse.setResponse(openAccountResultResponse);
//    	String Ori = JaxbUtil.beanToXml(cmbcResponse);

    	//签名+加密
//    	String Ori = "<DO-DATA BankId=\"353\" ChnlId=\"BSD\" DstApp=\"SEHSZQ\" DstServ=\"BSDB402\" Locale=\"EN\" MsgType=\"REQ\" RefNo=\"5506SEHSZQBSD1702180226103849\" ReqSys=\"IBPBSD\" TermNo=\"000000\" TxDate=\"20180226\" TxTime=\"103846\" UserId=\"SEHSZQ01\"><DO-MESSAGE AcCkDt=\"20180201\" BthCnt=\"1\" BthNo=\"2018022600000001\" CurRecCnt=\"64\" TotRecCnt=\"64\"><TraRecord AcCkDt=\"20180201\" Amt=\"1005.00\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4483IBKIBP1102180201104700\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"123.00\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4493IBKIBP1101180201105429\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"126.00\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4495IBKIBP1101180201105441\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"124.00\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4497IBKIBP1101180201110049\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"126.00\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4499IBKIBP1101180201110105\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1013.12\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4503IBKIBP1101180201110138\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1013.18\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4505IBKIBP1101180201110152\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1016.66\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4509IBKIBP1101180201110425\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2001.11\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4515IBKIBP1102180201111211\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2013.12\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4519IBKIBP1102180201111226\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2014.13\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4531IBKIBP1102180201112012\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2011.12\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4536IBKIBP1102180201112641\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2013.15\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4538IBKIBP1102180201112653\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"X\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1000.11\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4557IBKIBP1102180201120421\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"X\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1000.12\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4559IBKIBP1102180201120431\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2012.13\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4571IBKIBP1102180201121606\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2013.15\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4575IBKIBP1102180201121619\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"100.00\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4582IBKIBP1102180201122712\" SecAc=\"100001062\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"300.10\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4613IBKIBP1101180201141445\" SecAc=\"505781\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"300.00\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4615IBKIBP1101180201141559\" SecAc=\"505781\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"156.19\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4640IBKIBP1101180201144951\" SecAc=\"510981\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"100.13\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4642IBKIBP1101180201145125\" SecAc=\"510981\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"3000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4646IBKIBP1102180201145248\" SecAc=\"510981\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4649IBKIBP1101180201145259\" SecAc=\"510981\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4668IBKIBP1101180201150756\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"300.00\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4670IBKIBP1101180201151329\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2020.00\" Ccy=\"USD\" CusAc=\"100001062\" OrgRefNo=\"4682IBKIBP1101180201151711\" SecAc=\"510979\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"3000.11\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4695IBKIBP1101180201154727\" SecAc=\"510880\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1500.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4733IBKIBP1101180201160524\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1600.00\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4735IBKIBP1101180201160535\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2166.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4738IBKIBP1102180201160550\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2199.00\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4741IBKIBP1102180201160601\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"100.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4753IBKIBP1101180201163909\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"3000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4761IBKIBP1102180201170842\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"4000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4766IBKIBP1102180201171143\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"5000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4772IBKIBP1102180201171826\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"800.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4777IBKIBP1102180201172138\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"X\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"900.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4783IBKIBP1102180201172443\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"200.22\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4789IBKIBP1101180201172752\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"300.22\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4791IBKIBP1101180201172804\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"900.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4793IBKIBP1102180201173001\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"900.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4799IBKIBP1102180201173135\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"X\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"900.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4807IBKIBP1102180201173821\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"900.00\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4815IBKIBP1102180201174312\" SecAc=\"505787\" TraDat=\"20180201\" TskSts=\"R\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1002.00\" Ccy=\"HKD\" CusAc=\"100001062\" OrgRefNo=\"4820IBKIBP1102180201174555\" SecAc=\"505787\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1000.00\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4841IBKIBP1102180201181148\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1011.11\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4845IBKIBP1102180201181201\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1012.13\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4847IBKIBP1102180201181212\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1013.16\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4849IBKIBP1102180201181221\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1014.19\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4851IBKIBP1102180201181232\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1018.99\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4853IBKIBP1102180201181241\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2011.11\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4855IBKIBP1102180201181253\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2016.21\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4857IBKIBP1102180201181304\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2016.45\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4859IBKIBP1102180201181315\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"4012.11\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4863IBKIBP1102180201181354\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2045.26\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4868IBKIBP1102180201181419\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"P\" TskTyp=\"STB\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1010.12\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4874IBKIBP1101180201181449\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2011.12\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4876IBKIBP1101180201181503\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2015.16\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4878IBKIBP1101180201181514\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1102.36\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4880IBKIBP1101180201181524\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"3066.33\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4882IBKIBP1101180201181535\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"2500.36\" Ccy=\"USD\" CusAc=\"100000901\" OrgRefNo=\"4884IBKIBP1101180201181551\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"5000.66\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4888IBKIBP1101180201181612\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/><TraRecord AcCkDt=\"20180201\" Amt=\"1000.23\" Ccy=\"HKD\" CusAc=\"100000901\" OrgRefNo=\"4890IBKIBP1101180201181624\" SecAc=\"505388\" TraDat=\"20180201\" TskSts=\"A\" TskTyp=\"BTS\"/></DO-MESSAGE></DO-DATA>";
//    	String Ori = "<DO-DATA BankId=\"353\" ChnlId=\"BSD\" DstApp=\"SEXXZQ\" DstServ=\"BSDB202\" Locale=\"EN\" MsgType=\"REQ\" RefNo=\"5182SEJFZQBSD1604180123185949\" ReqSys=\"IBPBSD\" TermNo=\"000000\" TxDate=\"20180123\" TxTime=\"180149\" UserId=\"SEXXZQ01\"><DO-MESSAGE AgrNo=\"SEJF180123000041\" CusAc=\"100000395\" HidNo=\"H20140124\" HidTyp=\"HD\" IdNo=\"G20170124\" IdTyp=\"PP\" RslFlg=\"Y\" SDNo=\"SEXXZQ01\" SecAc=\"100000395\"/></DO-DATA>";
    	String Ori = "<DO-DATA BankId=\"353\" ChnlId=\"BSD\" DstApp=\"SEXXZQ\" DstServ=\"BSDB202\" Locale=\"EN\" MsgType=\"REQ\" RefNo=\"5182SEJFZQBSD1604180123185949\" ReqSys=\"IBPBSD\" TermNo=\"000000\" TxDate=\"20180123\" TxTime=\"180149\" UserId=\"SEXXZQ01\"><DO-MESSAGE AgrNo=\"SEJF180123000041\" SDNo=\"SEXXZQ01\" SecAc=\"30000022\" CusAc=\"11000008519\" HidTyp=\"HD\" HidNo=\"H20140124\" IdTyp=\"ID\" IdNo=\"231004199009076201\" RslFlg=\"Y\"/></DO-DATA>";
    	String userPlainBase64Text = new String(Base64.encode(Ori.getBytes()));    	
        CMBCDecryptKit decryptKit = new CMBCDecryptKit();

        String userPrivateFile = "F:/certs/cmbc/bank/CmbcGxzq.sm2";
        String userPrivateFilePassword = "111111";
        String cmbcPublicCertFile = "F:/certs/cmbc/client/GxzqCmbc.cer";
        
//        String userPrivateFile = "F:/certs/cmbc/client/GxzqCmbc.sm2";
//        String userPrivateFilePassword = "111111";
//        String cmbcPublicCertFile = "F:/certs/cmbc/bank/CmbcGxzq.cer";

        int result = decryptKit.Initialize(userPrivateFile, userPrivateFilePassword, cmbcPublicCertFile);
        System.out.println("init result:" + result);
   
        // 调用工具类，返回签名加密结果
        String userEnvelopebase64Message = decryptKit.SignAndEncryptMessage(userPlainBase64Text);
        String result1 = "353SECABC" + userEnvelopebase64Message;
        System.out.println("sign and encrypt message:" + result1);
        System.out.println("sign and encrypt length:" + result1.length());
    }
}
