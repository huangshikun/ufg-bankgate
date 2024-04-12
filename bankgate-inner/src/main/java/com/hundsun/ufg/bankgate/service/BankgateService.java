/**
 * 系统名称: UFG
 * 模块名称: account.biz.message
 * 类  名  称: ConnectionConfigService.java
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改人员                    修改说明 <br>
 * ============  ============================================
 * studio-auto      创建	  
 * ============  ============================================
 */
package com.hundsun.ufg.bankgate.service;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import com.hundsun.ufg.bankgate.response.base.BankResponse;

/**
 * 银行网关服务接口
 * @author huangsk20406
 * @create 2019-09-05 10:50
 */
@CloudService(validation = true)
public interface BankgateService {

	/**
	 * 调用银行服务
	 * @param request
	 * @return
	 */
	@CloudFunction(value = "bankgate.bankService", apiUrl = "/bankService")
	BankResponse bankService(Object request);
}