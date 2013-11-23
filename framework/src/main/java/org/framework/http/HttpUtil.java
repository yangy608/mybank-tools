/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   HttpUtil.java
 * Author       :   YY
 * Date         :   2013-8-29
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/

package org.framework.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *  POST方式提交 可以GET方式获取 反之不可以
 *  如果先用GET方式获取 POST就获取为null
 *	@ClassName:   HttpUtil
 *	@Description: TODO
 *	@author YY
 *	@date   2013-8-30 上午10:45:59
 */
public class HttpUtil {

	public static String sendHttpClientRequest(String _url,String encoding) throws Exception {
		BufferedReader in = null;

		// 定义HttpClient
		HttpClient client = new DefaultHttpClient();

		// 实例化HTTP方法
		HttpPost request = new HttpPost(_url);

		// 创建名/值组列表
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("a", "sendmsg")); // 订购预售权回调标记
		parameters.add(new BasicNameValuePair("b", "sendmsgv")); // 订购预售权回调标记
		// 创建UrlEncodedFormEntity对象
		UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters, encoding);
		request.setEntity(formEntiry);
		// 执行请求
		HttpResponse response = client.execute(request);

//		in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), encoding));
		StringBuffer sb = new StringBuffer();
//		String line = "";
//		String NL = System.getProperty("line.separator");
//		while ((line = in.readLine()) != null) {
//			sb.append(line + NL);
//		}
//		in.close();

		return sb.toString();
	}

	// GET
	public static String sendHttpRequest(String _url, String encoding) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			int code = conn.getResponseCode();
			System.out.println("code1   " + code);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// POST
	public static String sendHttpRequest(String _url, String str, String encoding) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// http正文内，因此需要设为true, 默认情况下是false;
			conn.setDoOutput(true);
			// 设置是否从httpUrlConnection读入，默认情况下是true;
			conn.setDoInput(true);
			// Post 请求不能使用缓存
			conn.setUseCaches(false);
			// 设定传送的内容类型是可序列化的java对象
			// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
			// conn.setRequestProperty("Content-type",
			// "application/x-java-serialized-object");
			conn.setRequestMethod("POST");
			conn.getOutputStream().write(str.getBytes(encoding));
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			int code = conn.getResponseCode();
			System.out.println("code2   " + code);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10000000; i++) {
			
			
			System.err.println(i);
			sendHttpClientRequest("http://localhost:8080/mybank-customer/index.shtml","gbk");
		}
		
		
		//System.err.println(sendHttpClientRequest("http://miugobuy.com/search/getCategory5.do?pn=%E5%8C%85","gbk")); 
		 //sendHttpRequest("http://localhost:8080/mybank-interact/test/prdCallback","gbk");
		 //sendHttpRequest("http://localhost:8080/mybank-interact/test/prdCallback","gbk","啊实打实大叔大");
	}
}
