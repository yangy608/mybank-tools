package org.framework.redis.jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;



public class RedisTest {

	public final static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:jedis/jedis1.xml");
	static ShardedJedisPool shardedjedispool =(ShardedJedisPool)ac.getBean("shardedJedisPool");
	static ShardedJedis jedis =  shardedjedispool.getResource();  
	
	public static void main(String[] args) throws InterruptedException {
		jedis.set("name1","minxr");
		//jedis.del("name1");
        //jedis.setex("name", 10, "min");//通过此方法，可以指定key的存活（有效时间） 时间为秒   
        //Thread.sleep(5000);//睡眠5秒后，剩余时间将为<=5   
        //System.out.println(jedis.ttl("name"));   //输出结果为5   

		
		 List<String> list = jedis.lrange("mybank_statistics_stringing", 0, -1);
		 	System.err.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				System.err.println(list.get(i));
			}
			
			System.err.println(jedis.get("name1"));
		
		//String key ="queryProduct_{\"sort\":\"profitrate\",\"sc\":\"asc\",\"start\":\"0\",\"row\":\"10\",\"param\":[{\"key\":\"type\",\"val\":\"101\"},{\"key\":\"all\",\"val\":\"的\"},{\"key\":\"basemoney\",\"val\":\"|20000\"}]}.";
		//System.out.println(jedis.exists(key));
		//System.out.println(jedis.ttl(key));//-1 永久有效
	
	}
	
	

      

}
