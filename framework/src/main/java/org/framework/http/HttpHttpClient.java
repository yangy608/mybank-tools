package org.framework.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;



public class HttpHttpClient {
	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.err.println(sdf.format(new Date()));

		//String _url = "http://202.105.135.53/sms1860/interface/smssend02.aspx";
		String _url = "http://121.101.221.34:8888/sms.aspx";
		BufferedReader in = null;

		// 定义HttpClient
		HttpClient client = new DefaultHttpClient();

		// 实例化HTTP方法
		HttpPost request = new HttpPost(_url);
	
			// 创建名/值组列表
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
//			parameters.add(new BasicNameValuePair("account","s064")); //订购预售权回调标记
//			parameters.add(new BasicNameValuePair("password","110830"));
//			parameters.add(new BasicNameValuePair("mobile",  "18621745516,13809240169,18124264158"));
//			parameters.add(new BasicNameValuePair("content",  "短信发送时间："+sdf.format(new Date())+",请查看收到时间确定用了多久"));
//			parameters.add(new BasicNameValuePair("port",  "0001"));
			
			
			parameters.add(new BasicNameValuePair("userid","1672")); //订购预售权回调标记
			parameters.add(new BasicNameValuePair("account","jkcs51"));
			parameters.add(new BasicNameValuePair("password",  "jkcs518899"));
			parameters.add(new BasicNameValuePair("mobile",  "18621745516,13809240169,18124264158"));
			parameters.add(new BasicNameValuePair("content",  "短信发送时间："+sdf.format(new Date())+",请查看收到时间确定用了多久"));
			
			parameters.add(new BasicNameValuePair("sendTime",  sdf.format(new Date())));
			parameters.add(new BasicNameValuePair("action",  "send"));
			parameters.add(new BasicNameValuePair("extno",  "0001"));

			// 创建UrlEncodedFormEntity对象
			UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters,"GBK");
			request.setEntity(formEntiry);
			// 执行请求
			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"GBK"));
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
