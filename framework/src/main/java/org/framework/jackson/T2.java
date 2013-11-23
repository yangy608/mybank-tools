/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   T2.java
 * Author       :   YY
 * Date         :   2013-8-25
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.jackson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class T2 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
//		/gateway/queryBankInfo?jsonStr={"bank_name":"人民银行","bank_address":"无极"}
		//Map 转 Json
		Map m = new HashMap();
		m.put("result_no", "custNo");
		m.put("result_description", "productId");

		try {
			System.err.println(mapper.writeValueAsString(m));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		//Json 转 Map
		String jsonStr = "{\"a1\":\"1\",\"a2\":\"2\"}";
		try {
			Map hashMap = mapper.readValue(jsonStr, new TypeReference<Map<String,Object>>(){});
			System.err.println(hashMap.get("a1"));
			System.err.println(hashMap.get("a2"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
