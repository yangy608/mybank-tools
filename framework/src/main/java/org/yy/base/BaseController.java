package org.yy.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


/**
 * 扩展ActionSupport的泛型基类
 * @author yangy
 * @param
 * @date 2010-07-29
 */
public class BaseController extends AbstractController {

	protected Logger logger = Logger.getLogger(BaseController.class);
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
}
