package org.framework.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpJava {

	
	public static void main(String[] args) throws UnsupportedEncodingException {

		String url1 = "http://180.153.97.67:8080/mybankGateway/gateway/statistics?jsonStr={\"custNo\":\"custNo\",\"deviceId\":\"1*2*3\",\"productId\":\"productId\"}";
		//String url1 = "http://180.153.97.67:8080/mybankGateway/gateway/queryBankInfo?jsonStr={\"bank_name\":\"人民银行\",\"bank_address\":\"无极\"}";
		//String b = "http://180.153.97.67:8080/mybankGateway/gateway/queryProduct?query="+"{\"sort\":\"type\",\"sc\":\"desc\",\"start\":\"0\",\"row\":\"15\",\"param\":[{\"key\":\"type\",\"val\":\"101\"}]}";
		try {			
			URL url = new URL(url1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
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
