package com.hundsun.ufg.bankgate.test;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import cfca.sadk.cmbc.tools.DecryptKitException;
import cmbc.cfca.util.Base64;

@SuppressWarnings("deprecation")
public final class ClientDecrypt{

    public static void main(String[] args) throws DecryptKitException {            	
        //解密+验签
        String cmbcEnvelopeBase64Text = "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";
        String userPrivateFile1 = "F:/certs/cmbc/client/GxzqCmbc.sm2";
        String userPrivateFilePassword1 = "111111";
        String cmbcPublicCertFile1 = "F:/certs/cmbc/bank/CmbcGxzq.cer";
        
        CMBCDecryptKit decryptKit1 = new CMBCDecryptKit();
        int result1 = decryptKit1.Initialize(userPrivateFile1, userPrivateFilePassword1, cmbcPublicCertFile1);
        System.out.println("initialize result: " + result1);
        
        // 调用工具类，返回解密验签结果，base64格式
        String userSourceBase64Text = decryptKit1.DecryptAndVerifyMessage(cmbcEnvelopeBase64Text);
        System.out.println("source data:" + new String(Base64.decode(userSourceBase64Text)));
    }
}
