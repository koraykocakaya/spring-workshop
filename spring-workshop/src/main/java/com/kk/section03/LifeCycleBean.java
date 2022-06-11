package com.kk.section03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 1. Bu interfaceler yardimiyla metotlar otomatik gelecegi icin XML'de vs. tekrar metodu vermeye gerek kalmayacaktir
 * @author korayk
 */
public class LifeCycleBean implements DisposableBean, InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LifeCycleBean After initialization");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("LifeCycleBean Before destruction");
	}

}
