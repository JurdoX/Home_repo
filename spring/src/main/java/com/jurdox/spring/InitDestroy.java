package com.jurdox.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InitDestroy implements InitializingBean, DisposableBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("init");		
	}
	
	public void destroy() throws Exception {
		System.out.println("destroy");		
	}
}
