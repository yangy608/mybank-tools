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

public class T1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.1.249:12000 192.168.1.249:12000"), new int[] {1,1});

		// 设置连接池大小，即客户端个数
		builder.setConnectionPoolSize(50);

		// 宕机报警
		builder.setFailureMode(true);

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
			try {
				// 设置/获取
				memcachedClient.set("zlex", 36000, "set/get");
				System.err.println("set/get" + memcachedClient.get("zlex"));

				// 替换
				memcachedClient.replace("zlex", 36000, "replace");
				System.err.println("replace" + memcachedClient.get("zlex"));

				// 移除
				memcachedClient.delete("zlex");
				System.err.println(memcachedClient.get("zlex"));
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (memcachedClient != null) {
				try {
					memcachedClient.shutdown();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
