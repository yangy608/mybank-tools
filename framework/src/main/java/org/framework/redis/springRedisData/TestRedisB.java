package org.framework.redis.springRedisData;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 简单的测试用例
 * 
 * @author oyhk
 * 
 */
public class TestRedisB {
	ApplicationContext app = new ClassPathXmlApplicationContext(new String[] { "classpath:/jedis/spring-redis-data.xml" });
	// 这里已经配置好,属于一个redis的服务接口
	RedisService redisService = (RedisService) app.getBean("redisService");

	/**
	 * 往list1中添加三条记录
	 */
	@Test
	public void lpush() {
		long result = redisService.lpush("list1", new String[] { "list1.1", "list1.2", "list1.3" });
		System.out.println(result);
		// 这里是junit的断言,简单的测试用例,如果不抛出异常,证明添加数据到列表成功
	}

	/**
	 * 查看从0开始到10的位置的数据
	 */
	@Test
	public void lrange() {
		List results = redisService.lrange("list2", 0, 10);
		System.out.println(results);
		Assert.assertNotNull(results);
	}

	/**
	 * 从左边的开始元素出队列
	 */
	@Test
	public void lpop() {
		String result = redisService.lpop("list1");
		System.out.println(result);
		Assert.assertNotNull(result);
	}

	/**
	 * 从右边的开始元素出队列
	 */
	@Test
	public void rpop() {
		String result = redisService.rpop("list1");
		System.out.println(result);
		Assert.assertNotNull(result);
	}

	/**
	 * 指定的列表中,指定的位置元素修改值
	 */
	@Test
	public void lset() {
		String result = redisService.lset("list1", 1, "list1.3");
		System.out.println(result);
		Assert.assertEquals("OK", result);
	}

	/**
	 * 删除指定列表中1个值为list1.3的元素
	 */
	@Test
	public void lrem() {
		long result = redisService.lrem("list1", 1, "list1.3");
		System.out.println(result);
		Assert.assertEquals(1L, result);
	}

	/**
	 * 从指定的列表右边出队,添加到目的列表中 -->>注意:这个方法必须源list有数据,那么目的list你可以随便起个名
	 * 
	 */
	@Test
	public void rpoppush() {
		String result = redisService.rpoppush("list1", "list2");
		System.out.println(result);
		Assert.assertNotNull(result);
	}
}