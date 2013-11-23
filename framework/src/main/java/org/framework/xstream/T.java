/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   T.java
 * Author       :   YY
 * Date         :   2013-8-29
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.xstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class T {

	/**
	 *  @Description: TODO
	 *  @param  @param args
	 *  @return void
	 *  @throws 
	 *  @author YY
	 *  @date   2013-8-29 上午10:46:45
	 */
	public static void main(String[] args) {
		//VO转xml
		
		XStream xstream = new XStream(new DomDriver()); 
		TVO v = new TVO();
		v.setParam1(1);
		v.setParam2(2);
		v.setParam3("3");
		v.setParam4(new Date());
		
		//xstream.alias("生日", Birthday.class);
		
		//根重命名
		xstream.alias("tvo", TVO.class);
		//属性重命名        
		//xstream.aliasField("邮件", TVO.class, "param1");        
		//包重命名        
		xstream.aliasPackage("co", "xstream");
		
		String xmkstr = xstream.toXML(v);
		
		System.err.println(xmkstr);
		
		
		
     
		//转的时候也需要
		xstream.alias("tvo", TVO.class);
			TVO stu = (TVO) xstream.fromXML(xmkstr);
			System.err.println(stu.getParam1());

		
	}

}
