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

import org.apache.commons.httpclient.HttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrRemote {

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
		//http://192.168.1.230/mybankGateway/solr
		SolrServer solrServer = new CommonsHttpSolrServer("http://192.168.1.122:8080/solr/core0", client);
		//SolrServer solrServer = new CommonsHttpSolrServer("http://192.168.1.230:8081/solr/core0", client);
		SolrQuery query = new SolrQuery();
		//query.setQuery("bank_name:工商银行  AND bank_address:合肥");
		//query.setQuery("product_intergal:[0 TO 10000000]");
		//query.setQuery("bank_name:36");
		//query.setQuery("type:201 AND salefromdate:[* TO 2010-01-10] AND saletodate:[2010-01-10 TO *] AND checkstatus:1");
		query.setQuery(" type:201 ");
//		query.setHighlight(true);
//		query.setHighlightSimplePre("<font color=\"red\">");
//		query.setHighlightSimplePost("</font>");
//		query.setParam("hl.fl", "productname,productdesc");
		//query.setStart(0);
		//query.setRows(10000);

		QueryResponse queryResponse = solrServer.query(query);
		System.err.println("返回串:" + queryResponse);
		
		SolrDocumentList docs = queryResponse.getResults();
		long num = docs.getNumFound();
		System.err.println("总条数:" + num);
		
		

		Iterator<SolrDocument> iter = docs.iterator();
		while (iter.hasNext()) {
			SolrDocument resultDoc = iter.next();

			String profitrate = (String) resultDoc.getFieldValue("profitrate");
			String saletodate = (String) resultDoc.getFieldValue("saletodate");
//			int id=(Integer) resultDoc.getFieldValue("productid");

			System.err.println(profitrate+"|"+saletodate);
			
//			if(queryResponse.getHighlighting().get("productdesc")!=null){
//                System.out.println(queryResponse.getHighlighting().get(id).get("productname"));
//                System.out.println(queryResponse.getHighlighting().get(id).get("productdesc"));
//            }


		}

	}

}
