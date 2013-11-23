package org.framework.redis.jedis;

import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisBase {  
  
    private static StringRedisTemplate template;  
  
    /** 
     * @return the template 
     */  
    public static StringRedisTemplate getTemplate() {  
        return template;  
    }  
  
    /** 
     * @param template the template to set 
     */  
    public void setTemplate(StringRedisTemplate template) {  
        this.template = template;  
    }  
  
}