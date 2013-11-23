package org.framework.mail.replymail;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ReplyMail {
 
     private static final String HOST_NAME = "pop.qq.com";
     private static final String SEND_HOST_NAME = "smtp.qq.com";
     private static final String PASSWORD = "xy19850111xy";
//     private static final String EMAIL_FROM = "flyingsam@qq.com";
     private static final String USER_NAME = "75648606@qq.com";
     private static final String PROTOCOL = "pop3";
//     private static final String SEND_PROTOCOL = "smtp";
     
     public static void listMail() throws Exception {
         Properties props = new Properties();
         props.put("mail.smtp.host", SEND_HOST_NAME);
         props.put("mail.pop.host", HOST_NAME);
         props.put("mail.transport.protocol","smtp");
         props.put("mail.smtp.auth", "true");
 
         
         Session session = Session.getDefaultInstance(props, new SimpleAuthenticator(USER_NAME, PASSWORD));     
         Store store = session.getStore(ReplyMail.PROTOCOL);   
         store.connect(HOST_NAME, USER_NAME, PASSWORD);
         Folder folder = store.getFolder("INBOX");
         folder.open(Folder.READ_ONLY);  
         Message[] messages = folder.getMessages();   
         InternetAddress address;   
         for (int i = messages.length-1; i >= 0; i--) {   
             address = (InternetAddress)messages[i].getFrom()[0];   
             if(address != null) {   
                 System.out.println(address.getPersonal());   
             } 
             if (null != address && "秋天的童话".equals(address.getPersonal())) {   
                 System.out.println("第" + i + "个：" + messages[i].getSubject());   
                 MimeMessage replyMessage = (MimeMessage) messages[i].reply(false);   
  //                replyMessage.setFrom(new InternetAddress(EMAIL_FROM));
  
                 replyMessage.setRecipients(MimeMessage.RecipientType.TO, address.getAddress());
                 replyMessage.setText("这是回复邮件，不知道能否成功！");  
                 replyMessage.saveChanges();
                 Transport transport = session.getTransport("smtp");
                 transport.connect(SEND_HOST_NAME,  USER_NAME, PASSWORD);
                 transport.send(replyMessage);
                 System.out.println("回复成功");                
             }   
         } 
         folder.close(true);   
         store.close();
     }
     
     public static void main(String[] args) {
         try {
             ReplyMail.listMail();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
 }
