package org.framework.encode;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @class       PBECoder
 * @description 对称加密算法：基于口令加密-PBE算法实现 
 * 				使用java6提供的PBEWITHMD5andDES算法进行展示 
 * @author      YY
 * @version     1.0
 * @date	    2011-11-27/上午12:20:50
 */
public class PBECoder {  
      
    /** 
     * JAVA6支持以下任意一种算法 
     * PBEWITHMD5ANDDES 
     * PBEWITHMD5ANDTRIPLEDES 
     * PBEWITHSHAANDDESEDE 
     * PBEWITHSHA1ANDRC2_40 
     * PBKDF2WITHHMACSHA1 
     * */  
    public static final String ALGORITHM="PBEWITHMD5andDES";  
      
    /** 
     * 迭代次数 
     * */  
    public static final int ITERATION_COUNT=100;
    public static final String EQUALTO="=";
      
    /** 
     * 盐初始化 
     * 盐长度必须为8字节 
     * @return  byte[]   盐 
     * */  
    public static byte[] initSalt() throws Exception{  
        //实例化安全随机数   
        SecureRandom random=new SecureRandom();  
        return random.generateSeed(8);  
    }  
      
    /** 
     * 转换密钥 
     * @param  password  密码 
     * @return Key       密钥 
     * */  
    private static Key toKey(String password) throws Exception{  
        PBEKeySpec keySpec=new PBEKeySpec(password.toCharArray());  
        SecretKeyFactory keyFactory=SecretKeyFactory.getInstance(ALGORITHM);  
        SecretKey secretKey=keyFactory.generateSecret(keySpec);          
        return secretKey;  
    }  
    /** 
     * 加密 
     * @param  data     待加密数据 
     * @param  password 密码 
     * @param  salt     盐 
     * @return byte[]   加密数据 
     *  
     * */  
    public static byte[] encrypt(byte[] data,String password,byte[] salt) throws Exception{  
        Key key=toKey(password);  
        PBEParameterSpec paramSpec=new PBEParameterSpec(salt,ITERATION_COUNT);  
        Cipher cipher=Cipher.getInstance(ALGORITHM);  
        cipher.init(Cipher.ENCRYPT_MODE, key,paramSpec);  
        return cipher.doFinal(data);  
    }  
    /** 
     * 解密 
     * @param  data     待解密数据 
     * @param  password 密码 
     * @param  salt     盐 
     * @return byte[]   解密数据 
     *  
     * */  
    public static byte[] decrypt(byte[] data,String password,byte[] salt) throws Exception{  
        Key key=toKey(password);  
        PBEParameterSpec paramSpec=new PBEParameterSpec(salt,ITERATION_COUNT);  
        Cipher cipher=Cipher.getInstance(ALGORITHM);  
        cipher.init(Cipher.DECRYPT_MODE, key,paramSpec);  
        return cipher.doFinal(data);  
    }   
    
	/**
	 * @Description       PEB加密(大文本，不固定长度)
	 * @param   data      需要加密的字符串
	 * @return  salt      加密的盐值(必须为ASCII值)
	 */
	public static String PBEEncrypt(String data,String salt) {
		byte[] random=null;
		byte[] result = null;
		try{ 
			random=PBECoder.initSalt();
			result=PBECoder.encrypt(data.getBytes(), salt, random);  
		}catch(Exception e){
			e.printStackTrace();
		}	
		StringBuffer bf=new StringBuffer();
		String randomStr=Base64.encodeBase64String(random);
		bf.append(randomStr.substring(0,11))
		  .append(Base64.encodeBase64String(result));
		return bf.toString();
	}
	
	/**
	 * @Description       PEB解密(大文本，不固定长度)
	 * @param   data      需要加密的字符串
	 * @return  salt      加密的盐值(必须为ASCII值)
	 */
	public static String PBEDecrypt(String data,String salt) {
		byte[] result = null;
		try {
			StringBuffer bf=new StringBuffer();
			bf.append(data.substring(0,11))
			  .append(EQUALTO);
			byte[] random=Base64.decodeBase64(bf.toString());
			byte[] newdata=Base64.decodeBase64(data.substring(11));
			result = PBECoder.decrypt(newdata, salt, random);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(result);  
        
	}	
//    public static void main(String[] args) throws Exception {  
//        //待加密数据   
//        String str="PBE";  
//        //设定的口令密码   
//        String password="azsxdc";  
//          
//        System.out.println("原文：/t"+str);  
//        System.out.println("密码：/t"+password);  
//          
//        //初始化盐   
//        byte[] salt=PBECoder.initSalt();  
//        System.err.println(salt);
//        System.out.println("盐：/t"+Base64.encodeBase64String(salt));  
//        //加密数据   
//        byte[] data=PBECoder.encrypt(str.getBytes(), password, salt);  
//        System.out.println("加密后：/t"+Base64.encodeBase64String(data));  
//        //解密数据   
//        data=PBECoder.decrypt(data, password, salt);  
//        System.out.println("解密后："+new String(data));  
//    }  
}  