/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   Snippet.java
 * Author       :   YY
 * Date         :   2013-10-12
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/

package org.framework.gzip;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

public class Snippet {
	
	
	/**
	 * 
	 * @author YY
	 * @version [V1.0, 2013-10-12]
	 * @see
	 * @since
	 */

	@Test
	public void testGzip() {
		System.err.println("返回乱码证明已经加入gzip压缩");
		HttpClient httpClient = new HttpClient();
		//GetMethod getMethod = new GetMethod("http://localhost:8081/mybank-enterprise/");
		GetMethod getMethod = new GetMethod("http://192.168.1.122");
		//GetMethod getMethod = new GetMethod("http://180.153.97.67:8080/mybank-enterprise/");
		try {
			getMethod.addRequestHeader("accept-encoding", "gzip,deflate");
			getMethod.addRequestHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; Alexa Toolbar; Maxthon 2.0)");
			int result = httpClient.executeMethod(getMethod);
			if (result == 200) {
				System.out.println("response大小是=============>"+getMethod.getResponseContentLength());
				String html = getMethod.getResponseBodyAsString();
				System.out.println("html内容是=================>"+html);
				System.out.println("html大小是=================>"+html.getBytes().length);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
	}
}
