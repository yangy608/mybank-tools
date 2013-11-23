package org.framework.redis.jedis;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class JedisPool {
	private static redis.clients.jedis.JedisPool pool;  
	public  final static redis.clients.jedis.JedisPool getInstance(){
		if(pool == null){
		    try {
				ResourceBundle bundle = ResourceBundle.getBundle("jedis/jedis2");  
				if (bundle == null) {  
				    throw new IllegalArgumentException("properties is not found!");  
				}  
				JedisPoolConfig config = new JedisPoolConfig();  
				config.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));  
				config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));  
				config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));  
				config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));  
				config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));  
				pool = new redis.clients.jedis.JedisPool(config, bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")));
				
				//加上这个可以做一致性哈希，关联2个缓存服务器
//				JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle.getString("redis1.ip"), Integer.valueOf(bundle.getString("redis.port"))); 
//				jedisShardInfo1.setPassword("redis.360buy");
//				JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle.getString("redis2.ip"), Integer.valueOf(bundle.getString("redis.port")));  
//				jedisShardInfo2.setPassword("redis.360buy");
//				List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();  
//				list.add(jedisShardInfo1);  
//				list.add(jedisShardInfo2);  
//				//一致性哈希
//				ShardedJedisPool pool=new ShardedJedisPool(config, list, Hashing.MURMUR_HASH,Sharded.DEFAULT_KEY_TAG_PATTERN);


		
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return pool;
	} 
}

