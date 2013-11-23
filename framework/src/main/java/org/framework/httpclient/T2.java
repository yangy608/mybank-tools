package org.framework.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class T2 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		try {

			HttpClient client = new DefaultHttpClient();
			BufferedReader in = null;
			HttpPost request = new HttpPost("http://61.143.160.150:8080/smshttp");
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("act", "sendmsg"));
			parameters.add(new BasicNameValuePair("unitid", "1852"));
			parameters.add(new BasicNameValuePair("username", "lhjr"));
			parameters.add(new BasicNameValuePair("passwd", "123456"));
			parameters.add(new BasicNameValuePair("msg", "你的验证码是：123456"));
			parameters.add(new BasicNameValuePair("phone", "13809240169,15013219330,18124264158"));
			parameters.add(new BasicNameValuePair("port", "9527"));
			parameters.add(new BasicNameValuePair("sendtime", "2013-07-08 12:00:00"));
			
//			parameters.add(new BasicNameValuePair("act", "smsrecord"));
//			parameters.add(new BasicNameValuePair("unitid", "1852"));
//			parameters.add(new BasicNameValuePair("username", "lhjr"));
//			parameters.add(new BasicNameValuePair("passwd", "123456"));

			UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters, "gbk");
			request.setEntity(formEntiry);

			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "gbk"));
			StringBuffer sb = new StringBuffer();
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}

			System.err.println(sb.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
