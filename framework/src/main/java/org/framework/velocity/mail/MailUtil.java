package org.framework.velocity.mail;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @description 邮件发送类
 * @author yangy
 * @version 1.0
 * @date 2012-07-19
 */
public class MailUtil {
	
	public final static ResourceBundle rb = ResourceBundle.getBundle("org/framework/velocity/mail/msg");
	
	public final static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:org/framework/velocity/mail/mail.xml");
	public final static MailService mailService =(MailService)ac.getBean("mailService");
	
	
	
	// 发送重置密码邮件
		public static void sendCPwMail(String register_code,String register_name,String mail_to) {
			Map<String, Object> model = new HashMap<String, Object>();
			
			//邮件模版需要传入的参数
			model.put("register_code", register_code);
			model.put("register_name", register_name);
			//邮件模版地址
			String vmfile = "org/framework/velocity/mail/RetPassword.vm";
			//邮件标题
			String subject = "miugopay重置密码邮件";
			//收件人
			String[] mailTo = StringUtils.split(mail_to);
			//发送人
			String mailFrom = rb.getString("mail.from");
			
			//附件
			String[] files = new String[2];
			files[0] = "c:\\test.rar";
			files[1] = "c:\\test.gif";
			
			mailService.sendCalculateReport(model, vmfile, subject, mailTo, mailFrom,files);
		}
		
		
	public static void main(String[] args) {
		sendCPwMail("163.com","毛泽东","75648606@qq.com");
	}
	
	
}