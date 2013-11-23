package org.framework.memcached;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



public class T4 {

	public final static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:memcached.xml");
	static MemcachedClient memcachedClient =(MemcachedClient)ac.getBean("memcachedClient");

	//Set
	//第一个是存储的 key 名称，
	//第二个是 expire 时间（单位秒） ，超过这个时间 ,memcached 将这个数据替换出去， 0 表示永久存储（默认是一个月） ，
	//第三个参数就是实际存储的数据，可以是任意的 java 可序列化类型 。
	
	public static void main(String[] args) {

		try {
			TsVO vo1 = new TsVO();
			vo1.setA("1111");
			vo1.setB(2222);
			vo1.setC(3333);
			
			//增加
			memcachedClient.set("hello", 0, vo1);
			TsVO vo2 = memcachedClient.get("hello");
			System.out.println("hello=" + vo2.getA());

			//删除
			memcachedClient.delete("hello");
			
			
			TsVO vo3 = memcachedClient.get("hello");
			System.out.println("hello=" + vo3.getA());
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
