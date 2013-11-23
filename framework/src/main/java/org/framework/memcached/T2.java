package org.framework.memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class T2  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.1.249:12000"));
		// 使用二进制文件  
	    builder.setCommandFactory(new BinaryCommandFactory());  
	    // 使用一致性哈希算法（Consistent Hash Strategy）  
	    builder.setSessionLocator(new KetamaMemcachedSessionLocator());  
	    // 使用序列化传输编码  
	    builder.setTranscoder(new SerializingTranscoder());  
	    // 进行数据压缩，大于1KB时进行压缩  
	    builder.getTranscoder().setCompressionThreshold(1024); 
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = builder.build();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


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


		} catch (MemcachedException e) {

			System.err.println("MemcachedClient operation fail");

			e.printStackTrace();

		} catch (TimeoutException e) {

			System.err.println("MemcachedClient operation timeout");

			e.printStackTrace();

		} catch (InterruptedException e) {

			// ignore

		}

		try {

			memcachedClient.shutdown();

		} catch (IOException e) {

			System.err.println("Shutdown MemcachedClient fail");

			e.printStackTrace();

		}

	}

}
