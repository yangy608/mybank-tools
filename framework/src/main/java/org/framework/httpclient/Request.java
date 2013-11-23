package org.framework.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Request {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws JsonProcessingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Map m = new HashMap();
		m.put("p1", "123");
		m.put("p2", "456");

		HttpClient httpClient = new DefaultHttpClient(); 
		HttpPost post = new HttpPost("http://localhost:8080/HelperWeb/Request"); 
		StringEntity se = new StringEntity(mapper.writeValueAsString(m),"UTF-8"); 
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json")); 
		post.setEntity(se); 
		try { httpClient.execute(post); }
		catch (ClientProtocolException e) { e.printStackTrace(); } 
		catch (IOException e) { e.printStackTrace(); }

	}

}
