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

import java.net.MalformedURLException;
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

public class SolrLocate {

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
		
		
		//获取高亮还是有问题
		HttpClient client = new HttpClient();
		SolrServer solrServer = new CommonsHttpSolrServer("http://localhost:8081/solr/core0", client);
		SolrQuery query = new SolrQuery();
		//query.setQuery("product_intergal:[0 TO 10000000]");
		//query.setQuery("product_id:36");
		query.setQuery(" type:201 AND basemoney:[0.03 TO 100000]");

		//query.setQuery("type:101");
//		query.setHighlight(true);
//		query.setHighlightSimplePre("<font color=\"red\">");
//		query.setHighlightSimplePost("</font>");
//		query.setParam("hl.fl", "name,address");
		//query.setStart(0);
		//query.setRows(10000);
		//query.setSortField("id", SolrQuery.ORDER.asc);

		QueryResponse queryResponse = solrServer.query(query);
		//System.err.println("返回串:" + queryResponse);

		SolrDocumentList docs = queryResponse.getResults();
		long num = docs.getNumFound();
		System.err.println("总条数:" + num);
		
		

		Iterator<SolrDocument> iter = docs.iterator();
		while (iter.hasNext()) {
			SolrDocument resultDoc = iter.next();

			
			int id=(Integer) resultDoc.getFieldValue("product_id");
			Double product_rate = (Double) resultDoc.getFieldValue("product_rate");
			//String address = (String) resultDoc.getFieldValue("address");

			System.err.println(id+"||"+product_rate);
			//System.err.print(name+"_");
			//System.err.println(address);
			
			
//			Map<String, Map<String, List<String>>> hightlight = queryResponse.getHighlighting();
//			if(queryResponse.getHighlighting().get(id)!=null){
//                System.out.println(queryResponse.getHighlighting().get(id).get("name"));
//            }


		}

	}

}
