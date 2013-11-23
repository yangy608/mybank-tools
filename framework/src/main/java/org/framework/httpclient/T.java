package org.framework.httpclient;

import java.math.BigDecimal;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.err.println(MD5.getEncodeString("888888"));
//		BigDecimal a = new BigDecimal("11.11");
//		BigDecimal b = a.multiply(new BigDecimal(100));
//		System.err.println(b);
		BigDecimal b = new BigDecimal("1111111111111111111").divide(new BigDecimal(100));
		double bal = Double.parseDouble("123123123")/100;
		System.err.println(String.valueOf(b));
	}

}
