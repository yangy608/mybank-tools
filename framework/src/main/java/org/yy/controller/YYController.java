package org.yy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.excel.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yy.base.BaseController;
import org.yy.vo.ShopVO;

/**
 * 
 * 
 * @ClassName: WXController
 * @Description: TODO
 * @author YY
 * @date 2013-8-29 下午5:35:35
 */

@Controller
@RequestMapping("/mybank")
public class YYController extends BaseController {

	// @Autowired
	// private ProductService productService;

	@RequestMapping("/mybankCallback")
	public String prdCallback(HttpServletRequest request, HttpServletResponse response) {
		System.err.println(request.getParameter("par"));
		return null;
	}

	@RequestMapping("/download")
	public String download(HttpServletRequest request, HttpServletResponse response) {
		// 生成并下载EXcel
		Map<String, Object> beans = new HashMap<String, Object>();
		//@off
		ShopVO vo1 = new ShopVO();
		ShopVO vo2 = new ShopVO();
		//@on
		vo1.setMerchantName("商户1");
		vo1.setShopCode("0001");
		vo1.setShopName("店铺1");
		vo1.setCount1(1);
		vo1.setCount2(2);
		vo1.setCount3(3);
		vo1.setCount4(4);
		vo1.setCount5(5);
		vo2.setMerchantName("商户2");
		vo2.setShopCode("0002");
		vo2.setShopName("店铺2");
		vo2.setCount1(11);
		vo2.setCount2(22);
		vo2.setCount3(33);
		vo2.setCount4(44);
		vo2.setCount5(55);
		List list =new ArrayList();
		list.add(vo1);
		list.add(vo2);
		
		beans.put("resultList", list);
		beans.put("createName", "丫丫");
		beans.put("createTime", "2012-12-12");
		ExcelUtil.doExcel("test.xlsx", "水电煤物业管理费.xls", beans, response);
		return null;
	}

}