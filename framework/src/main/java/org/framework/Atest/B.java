/********************************************************************
 * Copyright    :   Shanghai Mybank Information Technology Co., Ltd.
 * 
 * Filename     :   B.java
 * Author       :   YY
 * Date         :   2013-10-22
 * Version      :   V1.00
 * Description  :   
 *
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 *******************************************************************/


package org.framework.Atest;

public class B extends A{
	public String getVal(String a){
		System.err.println("B");
		return a;
	}
	
	public static void main(String[] args) {
		A b = new A();
		b.getVal("aaaaa");
				
	}

}
