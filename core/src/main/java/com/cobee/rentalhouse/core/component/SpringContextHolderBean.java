package com.cobee.rentalhouse.core.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class SpringContextHolderBean implements ApplicationContextAware, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolderBean.class);

	private static ApplicationContext applicationContext = null;

	@Override
	public void destroy() throws Exception {
		SpringContextHolderBean.clearHolder();
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		SpringContextHolderBean.applicationContext = ctx;
	}

	/**
	 * 清除SpringContextHolder中的ApplicationContext为Null.
	 */
	public static void clearHolder() {
		if (logger.isDebugEnabled()) {
			logger.debug("清除SpringContextHolderBean中的ApplicationContext:" + applicationContext);
		}
		applicationContext = null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		if (applicationContext == null)
		{
			throw new IllegalStateException("applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolderBean.");
		}
		return (T) applicationContext.getBean(name);
	}
	
	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		if (applicationContext == null)
		{
			throw new IllegalStateException("applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolderBean.");
		}
		return applicationContext.getBean(requiredType);
	}

}
