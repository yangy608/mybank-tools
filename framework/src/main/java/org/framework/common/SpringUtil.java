package org.framework.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Class       ApplicationContextUtil
 * @Description 系统初始化获取applicationContext
 * @Author      YY
 * @Version     1.0
 * @Date	    2011-10-29/下午09:28:05
 */
public class SpringUtil implements ApplicationContextAware {
	/**
	 * 声明一个静态变量保存
	 */
	private static  ApplicationContext context;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext context)throws BeansException {
		this.context = (ApplicationContext) context;
	}
	
	public static ApplicationContext getContext() {
		return context;
	}

}