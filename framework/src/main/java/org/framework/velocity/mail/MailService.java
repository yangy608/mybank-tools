package org.framework.velocity.mail;

import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;
/**
 * @description 邮件发送类
 * @author yangy
 * @version 1.0
 * @date 2012-07-19
 */
public class MailService {
	public Logger log = LoggerFactory.getLogger(MailService.class);
	public final static ResourceBundle rb = ResourceBundle.getBundle("org/framework/velocity/mail/msg");
	private VelocityEngine velocityEngine;
	private JavaMailSender mailSender;

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendCalculateReport(final Map<String,Object> model,final String vmfile,final String subject,final String[] mailTo,final String mailFrom,final String[] files) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,"UTF-8");//可添加多个附件
				//MimeMessageHelper message = new MimeMessageHelper(mimeMessage);//不可添加多个附件

				message.setFrom(new InternetAddress(mailFrom,rb.getString("mail.nickname"))); 
				message.setTo(mailTo);
				message.setSubject(subject);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,vmfile,"UTF-8", model);
				message.setText(text, true);
				
				
	            //将发送的内容赋值给MimeMessageHelper,后面的true表示内容解析成html
	            //如果您不想解析文本内容，可以使用false或者不添加这项
				if(null != files){
		            FileSystemResource file;
		            for(String s:files)//添加附件
		            {
		               file = new FileSystemResource(new File(s));//读取附件
//		            	   message.addInline("myLogo", new ClassPathResource("img/mylogo.gif"));
//		                   message.addAttachment("myDocument.pdf", new ClassPathResource("doc/myDocument.pdf"));
		            	   message.addAttachment(s, file);//向email中添加附件
		              
		            }
				}


	            
			}
		};

		try {
			mailSender.send(preparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
