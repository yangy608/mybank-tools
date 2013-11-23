/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   GetVelocity.java
 * Author       :   YY
 * Date         :   2013-10-24
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.velocity.mail;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class GetVelocity {

	public final static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:org/framework/velocity/mail/mail.xml");
	public final static VelocityEngine velocityEngine =(VelocityEngine)ac.getBean("velocityEngine");
	
	public static void main(String[] args) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		//邮件模版需要传入的参数
		model.put("register_code", "1");
		model.put("register_name", "2");
		
		String vmfile = "org/framework/velocity/mail/RetPassword.vm";
		
		
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,vmfile,"UTF-8", model);

		System.err.println(text);
		
		//Template t  = (Template)velocityEngine.getTemplate(vmfile,"UTF-8");
	
	
	}


}
