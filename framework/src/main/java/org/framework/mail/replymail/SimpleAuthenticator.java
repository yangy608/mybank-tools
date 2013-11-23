package org.framework.mail.replymail;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SimpleAuthenticator extends Authenticator {
     
     private String username;
     
     private String password;
     
     public SimpleAuthenticator(String username, String password) {
         this.username = username;
         this.password = password;
     }
 
     public PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(this.username, this.password);
 
     }
     
 } 
