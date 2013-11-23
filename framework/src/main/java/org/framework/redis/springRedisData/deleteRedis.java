package org.framework.redis.springRedisData;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * redis spring 简单例子
 * @author hk
 *
 * 2012-12-22 上午10:40:15
 */
public class deleteRedis {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:/jedis/spring-redis-data.xml");
        //这里已经配置好,属于一个redis的服务接口
        RedisService redisService = (RedisService) app.getBean("redisService");

        //String ping = redisService.ping();//测试是否连接成功,连接成功输出PONG
        //System.out.println(ping);

        //首先,我们看下redis服务里是否有数据
        //long dbSizeStart = redisService.dbSize();
        //System.out.println(dbSizeStart);


        //dbsize
       // long dbSizeEnd = redisService.dbSize();
        //System.out.println(dbSizeEnd);

        //清空reids所有数据
        //String key ="mybank-gateway_queryIntegral_{sort:product_date,sc:desc,start:0,row:10,param:[{key:product_intergal,val:0|10000000}]}.";
        //redisService.del("testaaa");
        redisService.flushDB();
        
        
//       redisService.lpush("testaaa", "123454");
//        //redisService.lset("testaaa", 0, "12345678");
//        List<String> list = redisService.lrange("testaaa", 0, -1);
//        System.err.println(list.size());
//		for (int i = 0; i < list.size(); i++) {
//			System.err.println(list.get(i));
//		}
		
		
//		List l = new ArrayList();
//		Person p1 = new Person();
//		Person p2 = new Person();
//		p1.setId(1);
//		p1.setName("name1");
//		p2.setId(2);
//		p2.setName("name2");
//		l.add(p1);
//		l.add(p2);
		//redisService.set("aaaa", l);
		
    }
}