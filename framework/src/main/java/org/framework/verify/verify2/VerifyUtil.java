package org.framework.verify.verify2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.framework.encode.MD5;





/**
 * 签名验签
 * 
 * @author yangy
 */
public class VerifyUtil {

	/**
	 * 签名
	 * @param str 待签名的原文
	 * @return
	 */
	public static String Sign(String original){
		return MD5.md5(getRsaStr(original));
	}
	
	
	/**
	 * 验签
	 * @param original   待验证签名的原文
	 * @param ciphertext 待验证签名的密文
	 * @return
	 */
	public static boolean VerifySign(String original,String ciphertext){
		return ciphertext.equals(MD5.md5(getRsaStr(original)));
	}

	public static String getRsaStr(String str){
		String   _str = stringInsertByInterval(str, "┆", 64);
		String[] arrayStr = _str.split("┆");
		StringBuffer sb = new StringBuffer();
		for (String string : arrayStr) {
			try {
				sb.append(RSA_Encrypt.encryption(string)).append("|");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int index = sb.lastIndexOf("|");
		if (index != -1) {
			sb.deleteCharAt(index);
		}
		return sb.toString();
		
	}
	public static String stringInsertByInterval(String original, String insertString, int interval) {
		String rtnString = original;
		if (original.length() > interval) {
			ArrayList<String> strList = new ArrayList<String>();
			Pattern p = Pattern.compile("(.{" + interval + "}|.*)");
			Matcher m = p.matcher(original);
			while (m.find()) {
				strList.add(m.group());
			}
			rtnString = join(strList, insertString);
		}
		return rtnString;
	}
	public static String join(Collection<String> collection, String separator) {
		if (collection == null) {
			return null;
		}
		return join(collection.iterator(), separator);
	}
	public static String join(Iterator<String> iterator, String separator) {
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return "";
		}
		Object first = iterator.next();
		if (!iterator.hasNext()) {
			return objectToString(first);
		}
		StringBuffer buf = new StringBuffer(256);
		if (first != null) {
			buf.append(first);
		}
		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}
	public static String objectToString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

}
