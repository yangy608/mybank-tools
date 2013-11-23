/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   Main.java
 * Author       :   YY
 * Date         :   2013-10-24
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.velocity.sms;

import java.text.MessageFormat;

public class Main {

	/**
	 *  @Description: TODO
	 *  @param  @param args
	 *  @return void
	 *  @throws 
	 *  @author YY
	 *  @date   2013-10-24 下午3:24:29
	 */
	public static void main(String[] args) {

		System.err.println(getSMSStr("1{0}2是{1}", "a","b"));

	}
	// 第二之后为占位符
	public static String getSMSStr(String resourceStr ,String... str) {
		//String resourceStr = RB.getString(resourceId);
		String result = MessageFormat.format(resourceStr,str);
		return result;
	}
}
