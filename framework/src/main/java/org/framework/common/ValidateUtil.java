package org.framework.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description 验证工具类
 * @author yangy
 * @version 1.0
 * @date 2012-08-16
 */
public class ValidateUtil {

	// 日期(yyyyMMdd)验证
	public static boolean valiDate(String str) {
		String pattern = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		Pattern patterndate = Pattern.compile(pattern);
		if (!patterndate.matcher(str).matches()) {
			return false;
		} else {
			return true;
		}
	}

	// 身份证验证
	public static boolean valiIdNO(String str) {
		String pattern = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
		Pattern patterndate = Pattern.compile(pattern);
		if (!patterndate.matcher(str).matches()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 用于判断字符串长度
	 * @param str
	 * @param length
	 * @return
	 */
	public static boolean validatorLength(String str, int length) {
		boolean result = true;
		if (str.length() != length){
			result = false;
		}
		return result;
	}
	
	/**
     * 判断导入的数据是否存在空值
     * @param request
     * @return
     */ 
	public static boolean validatorNull(String str) {
		return (null==str || str.trim().length()==0);
	}
	
	/**
	 * 判断是否为金钱的格式
	 * 使用正则表达式，匹配字符串的格式
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean stringMatch(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean rs = m.find();
		return rs;
	}
	/**
	 * 匹配字符串,判断是否为0
	 * 使用正则表达式，匹配字符串的格式
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean stringMatchZero(String str) {
		String regex = "^[0]+(\\.[0]+)?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean rs = m.find();
		return rs;
	}
}
