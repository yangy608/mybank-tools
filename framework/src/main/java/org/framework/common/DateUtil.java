package org.framework.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


/**
 * @description 日期工具类
 * @author yangy
 * @version 1.0
 * @date 2012-07-19
 */
public class DateUtil {

	/**
	 * 获取当前日期和时间
	 * 
	 * @param
	 * @return
	 */
	public static String getLocalDateTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 获取当前日期和时间
	 * 
	 * @param
	 * @return
	 */
	public static String getCurrentDateTime() {
		return new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	/**
	 * 将限定格式的日期转换为long
	 * 
	 * @param
	 * @return
	 * @throws ParseException 
	 */
	public static long paserDateTime(String time) throws ParseException {
		return new java.text.SimpleDateFormat("yyyyMMddHHmmss").parse(time).getTime();
	}

	/**
	 * 获取当前日期
	 * 
	 * @param
	 * @return
	 */
	public static String getCurrentDate() {
		return new java.text.SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	/**
	 * 获取当前时间
	 * 
	 * @param
	 * @return
	 */
	public static String getCurrentTime() {
		return new java.text.SimpleDateFormat("HHmmss").format(new Date());
	}

	/**
	 * 获取明天的日期
	 * 
	 * @return Calendar 昨天的日期
	 **/
	public static String getTomorrow() {
		return new java.text.SimpleDateFormat("yyyyMMdd").format(getDate(null, Calendar.DATE, 1).getTime());
	}
	
	/**
	 * 获取昨天的日期
	 * 
	 * @return Calendar 昨天的日期
	 **/
	public static String getYesterday() {
		return new java.text.SimpleDateFormat("yyyyMMdd").format(getLastday().getTime());
	}

	/**
	 * 获取昨天的日期
	 * 
	 * @return Calendar 昨天的日期
	 **/
	public static Calendar getLastday() {
		return getDate(null, Calendar.DATE, -1);
	}

	/**
	 * 获取转动后的时间
	 * 
	 * @param c
	 *            　待转动的时间
	 * @param tfield
	 *            转动的字段
	 * @param off
	 *            转动的偏移量
	 **/
	public static Calendar getDate(Calendar c, int tfield, int off) {
		if (c == null)
			c = Calendar.getInstance();
		c.add(tfield, off); // roll不偏移更大的转动字段 日时不偏移月 月时不偏移年
		return c;
	}

	/**
	 * 合法日期判断
	 * 
	 * @param date
	 *            　日期(20120228 或 2012-02-28 或 2012/02/28)
	 **/
	public static boolean validate(String date) {
		if (date.length() == 8) {
			date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		}
		if (date.length() == 10 && date.indexOf("/") != -1) {
			date = date.replace("/", "-");
		}
		Pattern patterndate = Pattern.compile("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");
		if (!patterndate.matcher(date).matches()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
	 * 
	 * @param dateString
	 *            需要转换为timestamp的字符串
	 * @return dataTime timestamp
	 */
	public final static java.util.Date string2Time(String dateString) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设定格式
		dateFormat.setLenient(false);
		java.util.Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * method 将字符串类型的日期转换为一个Date（java.sql.Date）
	 * 
	 * @param dateString
	 *            需要转换为Date的字符串
	 * @return dataTime Date
	 */
	public final static java.sql.Date string2SqlDate(String dateString) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		dateFormat.setLenient(false);
		java.util.Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// java.sql.Date dateTime = new java.sql.Date(date.getTime());// sql类型
		return new java.sql.Date(date.getTime());
	}

	public final static java.util.Date string2Date(String dateString) {
		if(StringUtil.isEmpty(dateString)) return null;
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		java.util.Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 记录考勤， 记录迟到、早退时间
	public static String getState() {
		String state = "正常";
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		try {
			Date d1 = df.parse("08:00:00");
			Date d2 = df.parse(df.format(d));
			Date d3 = df.parse("18:00:00");

			int t1 = (int) d1.getTime();
			int t2 = (int) d2.getTime();
			int t3 = (int) d3.getTime();
			if (t2 < t1) {

				long between = (t1 - t2) / 1000;// 除以1000是为了转换成秒
				long hour1 = between % (24 * 3600) / 3600;
				long minute1 = between % 3600 / 60;

				state = "迟到 ：" + hour1 + "时" + minute1 + "分";

			} else if (t2 < t3) {
				long between = (t3 - t2) / 1000;// 除以1000是为了转换成秒
				long hour1 = between % (24 * 3600) / 3600;
				long minute1 = between % 3600 / 60;
				state = "早退 ：" + hour1 + "时" + minute1 + "分";
			}
			return state;
		} catch (Exception e) {
			return state;
		}

	}

	/**
	 * 日期类型转为yyyy-MM-dd格式
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		if(date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			return sdf.format(date);
		}catch(Exception e){
			return "";
		}
	}
	
	/**
	 * yyyy-MM-dd转为yyyyMMdd格式
	 * 
	 * @param date
	 * @return
	 */
	public static String string2String(String date) {
		if(date == null || date.equals(""))
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try{
			return sdf.format(sdf2.parse(date));
		}catch(Exception e){
			return "";
		}
	}
	
	/**
	 * 时间转为yyyyMM格式
	 * @param date
	 * @return
	 */
	public static String timestamp2String(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		try{
			return sdf.format(date);
		}catch(Exception e){
			return "";
		}
	}
	

	/**
	 * 日期类型转为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param date
	 * @return
	 */
	public static String date2timeString(Date date) {
		if(date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			return sdf.format(date);
		}catch(Exception e){
			return "";
		}
	}
	
	public static String date2timeBeginString(Date date) {
		if(date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		try{
			return sdf.format(date);
		}catch(Exception e){
			return "";
		}
	}
	
	/**
	 * 将20120202 格式的日期转化成 2012-02-02
	 * 
	 */
	public static String convertDateStr(String date) {
		if (date.length() == 8) {
			date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		}
		return date;
	}

}
