package org.framework.mail.sendmail;

import java.io.UnsupportedEncodingException;

/********************************************************************
 * Copyright    :   Bank Technologies Co., Ltd. 2013-2013
 * 
 * Filename     :   Send.java
 * Author       :   YY
 * Date         :   2013-8-9
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/

public class Send {

	/**
	 *  @Description: TODO
	 *  @param  @param args
	 *  @return void
	 *  @throws 
	 *  @author YY
	 *  @date   2013-8-9 下午1:20:30
	 */
	public static void main(String[] args) {

		MailSenderInfo mailInfo = new MailSenderInfo();   
		mailInfo.setMailServerHost("smtp.163.com");   
		mailInfo.setMailServerPort("25");   
		mailInfo.setValidate(true);   
		mailInfo.setUserName("yyong413@163.com");   
		mailInfo.setPassword("443EDDF0D278BA95");
		mailInfo.setFromAddress("yyong413@163.com");   
		mailInfo.setToAddress("4500715@qq.com");   
		mailInfo.setSubject("设置邮箱标题");   
		mailInfo.setContent("设置邮箱内容");   

		try {
			SimpleMailSender.sendHtmlMail(mailInfo);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


	}


}
