/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   R.java
 * Author       :   YY
 * Date         :   2013-8-24
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.jackson;

import java.util.List;

public class RequestJson {
	private String sort;
	private String start;
	private String row;
	private List<Request> param;
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public List<Request> getParam() {
		return param;
	}
	public void setParam(List<Request> param) {
		this.param = param;
	}
	
}
