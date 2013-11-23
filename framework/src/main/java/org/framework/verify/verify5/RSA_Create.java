package org.framework.verify.verify5;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSA_Create{
      public static void main(String args[]) throws Exception{
    	  
    	  
           //创建密钥对生成器，指定加密和解密算法为RSA
           KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
           //指定密钥的长度，初始化密钥对生成器
           kpg.initialize(2048);
           //生成密钥对
           KeyPair kp=kpg.genKeyPair();
           //获取公钥
           PublicKey pbkey=kp.getPublic();
           //获取私钥
           PrivateKey prkey=kp.getPrivate();
        
           //保存公钥到文件(公钥加密 给别人)
           FileOutputStream     f1=new FileOutputStream("c:\\Miugo_Private.pfx");
           ObjectOutputStream b1=new     ObjectOutputStream(f1);
            b1.writeObject(pbkey);
        
           //保存私钥到文件(私钥解密 给自己)
           FileOutputStream     f2=new FileOutputStream("c:\\Miugo_Public.cer");
           ObjectOutputStream b2=new     ObjectOutputStream(f2);
           b2.writeObject(prkey);
      }
}