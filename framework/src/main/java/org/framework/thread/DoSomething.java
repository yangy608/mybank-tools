package org.framework.thread;
public class DoSomething implements Runnable { 
    private String name; 

    public DoSomething(String name) { 
        this.name = name; 
    } 

    public void run() { 
    	System.err.println(Constant.SESSION_isMobileDevice);
		Constant.SESSION_isMobileDevice = true;
		Constant.SESSION_isMobileDevice = true;
    } 
}