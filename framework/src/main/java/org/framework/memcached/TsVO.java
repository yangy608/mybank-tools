package org.framework.memcached;

import java.io.Serializable;

public class TsVO implements Serializable{
	private String a;
	private int b;
	private long c;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public long getC() {
		return c;
	}
	public void setC(long c) {
		this.c = c;
	}

}
