package com.hundsun.ufg.bankgate.deploy;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.common.web.CloudServletInitializer;

@CloudApplication(scanBasePackages = { "com.hundsun.ufg.base.config", "com.hundsun.ufg.base" })
public class Provider extends CloudServletInitializer {
	public static void main(String[] args) {
		CloudBootstrap.run(Provider.class, args);
	}
}
