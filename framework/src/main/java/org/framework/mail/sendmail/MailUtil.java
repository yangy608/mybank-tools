package org.framework.mail.sendmail;

import java.io.UnsupportedEncodingException;

public class MailUtil {
	
	
	//发送短信
	public static void sendMail(String content)  {
		
		MailSenderInfo mailInfo = new MailSenderInfo();   
		mailInfo.setMailServerHost("smtp.163.com");   
		mailInfo.setMailServerPort("25");   
		mailInfo.setValidate(true);   
		mailInfo.setUserName("yyong413@163.com");   
		mailInfo.setPassword("443EDDF0D278BA95");
		mailInfo.setFromAddress("yyong413@163.com");   
		mailInfo.setToAddress("4500715@qq.com");   
		mailInfo.setReceivers("30298036@qq.com,75648606@qq.com".split(","));
		mailInfo.setSubject(content);   
		mailInfo.setContent(content);   

		try {
			SimpleMailSender.sendHtmlMail(mailInfo);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("192.168.122:/home/gaojh/apache-tomcat-6.0.37.80未启动");
	}

}
