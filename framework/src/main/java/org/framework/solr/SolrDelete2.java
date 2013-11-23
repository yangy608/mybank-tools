/********************************************************************
 * Copyright    :   Bank Technologies Co., Ltd. 2013-2013
 * 
 * Filename     :   T.java
 * Author       :   YY
 * Date         :   2013-8-21
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/

package org.framework.solr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrDelete2 {

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws MalformedURLException
	 * @throws SolrServerException
	 * @throws
	 * @author YY
	 * @date 2013-8-21 上午10:51:17
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, SolrServerException {

		StringBuffer sb = new StringBuffer();
		try {
			String _url = "http://localhost:8081/solr/core2/update -jar  post.jar \"<delete><id>36</id></delete>\"";
			URL url = new URL(_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			int code = conn.getResponseCode();
			System.out.println("code1   " + code);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println( sb.toString());
	
	}

}
