package org.framework.httpclient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class T1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		try {

			URL url = new URL("https://www.miugopay.com/miugogate/gateway?service=unifiedLogin&mchntLoginUserName=miugobuyadmin&mchntLoginPwd=21218CCA77804D2BA1922C33E0151105&charset=utf-8&signType=MD5&sign=BE1938CA5FBBCD8BD2BEED0135B96420&token=20130304175557255110&caic=000000000000041");

			System.setProperty("java.protocol.handler.pkgs", "javax.net.ssl");
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					return urlHostName.equals(session.getPeerHost());
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			TrustManager[] tm = { new SSLTrust() };

			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
