package org.framework.verify.verify2;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSA_Encrypt {

	//用私钥加密
	public static String encryption(String str){
		try {
			str = Base64.encodeBase64String(str.getBytes("UTF-8"));
			//FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "/cert/Android_Public.cer");
			ClassLoader cl = RSA_Encrypt.class.getClassLoader();
			InputStream f = cl.getResourceAsStream("com/miugo/core/verify2/miugosecurity.pfx");
			ObjectInputStream b = new ObjectInputStream(f);
			RSAPublicKey pbk = (RSAPublicKey) b.readObject();
			BigInteger e = pbk.getPublicExponent();
			BigInteger n = pbk.getModulus();
			byte ptext[] = str.getBytes("UTF-8");
			BigInteger m = new BigInteger(ptext);
			BigInteger c = m.modPow(e, n);
			return c.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}
