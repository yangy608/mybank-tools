package org.framework.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class T11 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		try {
			String url1 = "http://61.143.160.150:8080/smshttp?act=sendmsg&unitid=1852&username=lhjr&passwd=123456&msg="+URLEncoder.encode("今天天气很好啊")+"&phone=13809240169&port=&sendtime=2013-07-08 12:00:00";
			URL url = new URL(url1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "gbk"));
			StringBuffer sb = new StringBuffer();
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			System.err.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
