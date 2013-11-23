package org.framework.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



public class RequestReturn {
	
	public static void main(String[] args) throws Exception {


		String _url = "http://192.168.1.249:8080/miugogate/GateWay";
		BufferedReader in = null;

			// 定义HttpClient
			HttpClient client = new DefaultHttpClient();

			// 实例化HTTP方法
			HttpPost request = new HttpPost(_url);

			// 创建名/值组列表
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("service","login_httpclient")); //订购预售权回调标记
			parameters.add(new BasicNameValuePair("name","miugobuyadmin"));
			parameters.add(new BasicNameValuePair("pass",  "21218CCA77804D2BA1922C33E0151105"));
			parameters.add(new BasicNameValuePair("tid",  "112"));
			parameters.add(new BasicNameValuePair("sign",  "AF1D88DEC705C49CA13F33F67FCB2D3A"));

			// 创建UrlEncodedFormEntity对象
			UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters);
			//UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters);
			request.setEntity(formEntiry);
			// 执行请求
			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer();
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			System.err.println(sb.toString());

	

	
	}
	
	
}
