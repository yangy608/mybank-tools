package org.framework.verify.verify0;

public class CertUtil {

	/**
	 * 对字符串进行签名
	 * 
	 * @param TobeSigned 需要进行签名的字符串
	 * @param KeyFile    PFX证书文件路径
	 * @param PassWord   私钥保护密码
	 * @return 签名成功返回true(从LastResult属性获取结果)，失败返回false(从LastErrMsg属性获取失败原因)
	 */
	public static String SignMsg(final String TobeSigned, final String KeyFile, final String PassWord) throws Exception {
		CryptNoRestrict cryptNoRestrict = new CryptNoRestrict();
		cryptNoRestrict.SignMsg(TobeSigned, KeyFile, PassWord);
		return cryptNoRestrict.lastSignMsg;
	}

	/**
	 * 对字符串进行签名
	 * @param TobeSigned   需要进行签名的字符串
	 * @return
	 * @throws Exception
	 */
	public static String SignMsg(final String TobeSigned) throws Exception {
		CryptNoRestrict cryptNoRestrict = new CryptNoRestrict();
		String KeyFile = "com/miugo/core/verify0/mall-sign.pfx";
		String PassWord = "mgcore";
		cryptNoRestrict.SignMsg(TobeSigned, KeyFile, PassWord);
		return cryptNoRestrict.lastSignMsg;
	}

	/**
	 * 验证签名
	 * 
	 * @param TobeVerified 待验证签名的密文
	 * @param PlainText    待验证签名的明文
	 * @param CertFile     签名者公钥证书
	 * @return 验证成功返回true，失败返回false(从LastErrMsg属性获取失败原因)
	 */
	public static boolean VerifyMsg(String TobeVerified, String PlainText, String CertFile) throws Exception {
		CryptNoRestrict cryptNoRestrict = new CryptNoRestrict();
		return cryptNoRestrict.VerifyMsg(TobeVerified, PlainText, CertFile);
	}

	/**
	 * 验证签名
	 * @param TobeVerified   待验证签名的密文
	 * @param PlainText      待验证签名的明文
	 * @return
	 * @throws Exception
	 */
	public static boolean VerifyMsg(String TobeVerified, String PlainText) throws Exception {
		CryptNoRestrict cryptNoRestrict = new CryptNoRestrict();
		return cryptNoRestrict.VerifyMsg(TobeVerified, PlainText, "com/miugo/core/verify0/core-vali.cer");
	}

}
