/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   A.java
 * Author       :   YY
 * Date         :   2013-8-27
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.CXFclient;

import java.net.URL;

public class Test {

	/**
	 *  @Description: TODO
	 *  @param  @param args
	 *  @return void
	 *  @throws 
	 *  @author YY
	 *  @date   2013-8-27 下午4:04:06
	 */
	public static void main(String[] args) {
		HelloWorldImplServiceLocator wmgwLocator = new HelloWorldImplServiceLocator();
		try {
			HelloWorld helloworld = wmgwLocator.getHelloWorldImplPort(new URL("http://180.153.97.67:8080/mybankGateway/wb/helloworld"));
			System.err.println(helloworld.sayHi("你好啊"));
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			
			e.printStackTrace();
		} 
	}


}
