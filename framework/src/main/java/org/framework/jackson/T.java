/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   A.java
 * Author       :   YY
 * Date         :   2013-8-24
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/

package org.framework.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class T {

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws IOException
	 * @throws
	 * @author YY
	 * @date 2013-8-24 下午2:53:00
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		List<Request> l = new ArrayList<Request>();
		Request r1 = new Request();
		Request r2 = new Request();
		RequestJson r = new RequestJson();
		r1.setKey("all");
		r1.setVal("工作");
		r2.setKey("type");
		r2.setVal("102-201");
		l.add(r1);
		l.add(r2);
		r.setParam(l);
		r.setStart("0");
		r.setRow("10");
		r.setSort("all");
		String result = null;
		try {
			result = mapper.writeValueAsString(r);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.err.println(result);
		System.err.println(mapper.writeValueAsString(l));


		
		
		
		
		//json转 list bean
		String jsostr = "{\"sort\":\"all\",\"start\":\"0\",\"row\":\"10\",\"param\":[{\"key\":\"all\",\"val\":\"工作\"},{\"key\":\"type\",\"val\":\"102-201\"}]}";
		try {
			RequestJson rj = mapper.readValue(jsostr, RequestJson.class);
			System.err.println(rj.getParam().get(0).getKey());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		//json转 list map
		List<Map<String,String>> hashMap = mapper.readValue("", new TypeReference<List<Map<String,String>>>(){});
		for (Object object : hashMap) {
			Map<String,String> map = (Map<String,String>) object;
			System.err.println(map.get("keyword")+"|"+map.get("times"));
		}
		
		String a = "[{\"key\":\"all\",\"val\":\"工作\"},{\"key\":\"type\",\"val\":\"102,102,201\"}]";
		List<LinkedHashMap<String, Object>> list = mapper.readValue(a, List.class);
		System.err.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			Set<String> set = map.keySet();
			for (Iterator<String> it = set.iterator(); it.hasNext();) {
				String key = it.next();
				System.out.println(key + ":" + map.get(key));
			}
		}

	}

}
