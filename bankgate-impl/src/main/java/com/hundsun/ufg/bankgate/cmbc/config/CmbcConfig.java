package com.hundsun.ufg.bankgate.cmbc.config;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import cfca.sadk.cmbc.tools.DecryptKitException;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.Data;

/**
 * @author huangsk20406
 * @create 2019-09-02 16:06
 */
@Data
@Configuration
@SuppressWarnings("deprecation")
public class CmbcConfig {
	
	public static final String MSG_TYPE_REQ = "REQ";
	
	public static final String MSG_TYPE_RSP = "RSP";
	
    @Value("${cmbc.bankId}")
    private String bankId;
    
    @Value("${cmbc.reqSys}")
    private String reqSys;
    
    @Value("${cmbc.chnlId}")
    private String chnlId;
    
    @Value("${cmbc.dstApp}")
    private String dstApp;
    
    @Value("${cmbc.userId}")
    private String userId;
    
    @Value("${cmbc.termNo}")
    private String termNo;
    
    @Value("${cmbc.locale}")
    private String locale;
    
    @Value("${cmbc.bank.sm2}")
    private String bankSm2;
    
    @Value("${cmbc.file.password}")
    private String filePassword;
    
    @Value("${cmbc.client.cer}")
    private String clientCer;
    
    @Value("${cmbc.client.sm2}")
    private String clientSm2;
    
    @Value("${cmbc.bank.cer}")
    private String bankCer;
    
//	@Bean
//    public CMBCDecryptKit clientCMBCDecryptKit() throws DecryptKitException {
//    	CMBCDecryptKit cmbcDecryptKit = new CMBCDecryptKit();
//    	cmbcDecryptKit.Initialize(bankSm2, filePassword, clientCer);
//    	return cmbcDecryptKit;
//    }
    
    @Bean
    public CMBCDecryptKit bankCMBCDecryptKit() throws DecryptKitException {
    	CMBCDecryptKit cmbcDecryptKit = new CMBCDecryptKit();
    	cmbcDecryptKit.Initialize(clientSm2, filePassword, bankCer);
    	return cmbcDecryptKit;
    }
    
//    @Bean
//    public CmbcDecoder cmbcDecoder() throws DecryptKitException {
//    	return new CmbcDecoder(bankCMBCDecryptKit());
//    }
    
    @Bean
    public StringEncoder stringEncoder() {
    	return new StringEncoder(CharsetUtil.UTF_8);
    }
    
    @PreDestroy
    public void destory() throws DecryptKitException {
//    	clientCMBCDecryptKit().Uninitialize();
    	bankCMBCDecryptKit().Uninitialize();
    }
}
