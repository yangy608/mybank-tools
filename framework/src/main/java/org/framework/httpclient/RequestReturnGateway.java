package org.framework.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class RequestReturnGateway {

	public static void main(String[] args) throws Exception {
		
		//String msm = msm();
		//System.err.println(msm);
		String mobile = "1f47502ce6ed0455854f944e89709589018e2d112ec6bc0116e4f148a02ea2f94fd162f84507c4c87f6cfe378a506128fc664d8ebf527f98b580a76135fd2483f7534213ad2528b70b3e5d112d9cb1f369320356b6527f6cc729af6bebda6f310bf80d8e6102568b734a767288806bc9024ac3e80c1761382ad532d8d8ad99e3";
		String cardNO = "";//"7fceaa1ef321085cda450549755d3836182f6d22734eb880d53886871011ca2b8118ebe7e7e08d1682a3c412dd5d2b728098d4323180d68e1e01926eed6113524fd53bbf34c5d56e3382512fbbf2a04b5b68f4667160d30f0e92879ea705c82f8a6eea446af73da8b281ef48aadf803b5cc8b329d138c5d4d0e44e37920849fc";//"8100510090000144";
		String pin 	  = "2ddc1f4c16fa35df70295d80e68db2614f7b2cab83b9519f0a5025a2f4bd34e5a15058f81e1ebf672ff6fb633537667ba5cef03ad865c12dadf15837bd72b517b5af4e9b3e023850db2f9d34296359d5aafc7a213cc1d229769917d342d38b6f6a83d6e8e1e23cd8711d6c00fa5f8da7150d7cd5a7cfd50df3a1ce5402ccce0b";//"888888";
		String code   = "198047";
		String token  = "700363";
		System.err.println(login(cardNO, pin, mobile, code, token));;

		

	}

	public static String msm() throws Exception {

		String _url = "http://localhost:8080/miugogateway/gateway";
		BufferedReader in = null;
		try {
			// 定义HttpClient
			HttpClient client = new DefaultHttpClient();
			// client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

			// 实例化HTTP方法
			HttpPost request = new HttpPost(_url);

			// 创建名/值组列表
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			String mobile = "1f47502ce6ed0455854f944e89709589018e2d112ec6bc0116e4f148a02ea2f94fd162f84507c4c87f6cfe378a506128fc664d8ebf527f98b580a76135fd2483f7534213ad2528b70b3e5d112d9cb1f369320356b6527f6cc729af6bebda6f310bf80d8e6102568b734a767288806bc9024ac3e80c1761382ad532d8d8ad99e3";
			String to_sign = "mobile=" + mobile;
			parameters.add(new BasicNameValuePair("service", "sms"));
			parameters.add(new BasicNameValuePair("mobile", mobile));
			parameters.add(new BasicNameValuePair("sign_type", "MD5"));
			parameters.add(new BasicNameValuePair("sign", to_sign));

			// 创建UrlEncodedFormEntity对象
			UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters);
			request.setEntity(formEntiry);
			// 执行请求
			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			return sb.toString();

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}

	}
	
	
	
	public static String login(String cardNO,String pin,String mobile,String code,String token) throws Exception {

		String _url = "http://localhost:8080/miugogateway/gateway";
		BufferedReader in = null;
		try {
			// 定义HttpClient
			HttpClient client = new DefaultHttpClient();
			// client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

			// 实例化HTTP方法
			HttpPost request = new HttpPost(_url);

			// 创建名/值组列表
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("service", "login"));
			String to_sign = "";
			
			//卡号登录
			if(!StringUtils.isEmpty(cardNO)){
				parameters.add(new BasicNameValuePair("cardNO", cardNO));
				parameters.add(new BasicNameValuePair("pin", pin));
				to_sign = "cardNO="+cardNO+"&pin"+pin;
			}
			//手机登录
			else{
				parameters.add(new BasicNameValuePair("mobile", mobile));
				parameters.add(new BasicNameValuePair("code", code));
				parameters.add(new BasicNameValuePair("token", token));
				to_sign = "mobile="+mobile+"&code="+code+"&token"+token;
			}

			parameters.add(new BasicNameValuePair("sign_type", "MD5"));
			parameters.add(new BasicNameValuePair("sign", to_sign));
			parameters.add(new BasicNameValuePair("notify_url", "http://163.com"));
			parameters.add(new BasicNameValuePair("return_url", "http://163.com"));

			// 创建UrlEncodedFormEntity对象
			UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(parameters);
			request.setEntity(formEntiry);
			// 执行请求
			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			return sb.toString();

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}

	}
}
