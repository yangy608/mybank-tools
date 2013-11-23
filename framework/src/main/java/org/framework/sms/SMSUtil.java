package org.framework.sms;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class SMSUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SMSUtil.class);
	private static final ResourceBundle rb = ResourceBundle.getBundle("msg");
	private static final String sms_url = rb.getString("org/framework/sms/sms_url");
	private static final String sms_id  = rb.getString("sms_id");
	private static final String sms_pwd = rb.getString("sms_pwd");
	
	
	public static String sendMessage(String phoneno,String phonemsg)  {
			WmgwLocator wmgwLocator = new WmgwLocator();
			String strArgs[] = new String[6];
			strArgs[0] = sms_id;
			strArgs[1] = sms_pwd;
			strArgs[2] = phoneno;
			strArgs[3] = phonemsg;
			strArgs[4] = String.valueOf(phoneno.split(",").length);
			strArgs[5] = "*";
			try {
				return wmgwLocator.getwmgwSoap(new URL(sms_url)).mongateCsSpSendSmsNew(strArgs[0], strArgs[1], strArgs[2], strArgs[3], Integer.valueOf(strArgs[4]).intValue(), strArgs[5]);
			} catch (Exception e) {
				logger.error("发送短信失败"+e);
			}
			return phonemsg; 
		}
	

	
	
	public static String[] getReplyMessage(){
		
		String[] replyArr = null ;
		WmgwLocator wmgwLocator = new WmgwLocator();
		String strArgs[] = new String[10];
		strArgs[0] = sms_id;
		strArgs[1] = sms_pwd;

		try {
			replyArr = wmgwLocator.getwmgwSoap(new URL(sms_url)).mongateCsGetSmsExEx(strArgs[0], strArgs[1]);
		} catch (Exception e) {
			logger.error("获取短信回复失败"+e);
		} 
		return replyArr;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			System.err.println(sendMessage("13809240169", "发送时间3:山东平度金沟子村决定不再拆迁陈宝成房屋山东平度金沟子村决定不再拆山东平度金沟子村决定不再拆迁陈宝成房屋山东平度金沟子村决定不再拆"+(new SimpleDateFormat("HH:mm:ss")).format(new Date())));
		}
	}

}
