package org.framework.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @description 字符操作工具类
 * @author yangy
 * @version 1.0
 * @date 2012-07-19
 */
public class StringUtil {

	private static int count10 = 0;
	private static int count18 = 0;
	private static int count20 = 0;

	// 分割字符串
	public static String[] split(String str, String token) {
		return StringUtils.splitPreserveAllTokens(str, token);
	}

	// 是否为空
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	// 补位
	public static String formatString(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				// sb.append(str).append("0");//右补0
				str = sb.toString();
				strLen = str.length();
			}
		} else {
			str = str.substring(0, strLength);
		}
		return str;
	}
	
	//生成6位的随机数
	public static String createSerial6() {
		SimpleDateFormat sdf = new SimpleDateFormat("mmssSSS");
		String subStr = sdf.format(new Date()).substring(1, 7);
		return subStr;
	}

	// 生产18位序列号
	public static String createSerial18() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		// 序列自加
		count18++;
		if (count18 == 1000) {
			count18 = 0;
		}
		String par = formatString(String.valueOf(count18), 3);
		return sdf.format(new Date()) + par;
	}

	// 生产20位序列号
	public static String createSerial20() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		// 序列自加
		count20++;
		if (count20 == 100000) {
			count20 = 0;
		}
		String par = formatString(String.valueOf(count20), 5);
		return sdf.format(new Date()) + par;
	}

	// 为空时返回默认值
	public static String getDefultStr(String str) {
		if (str == null || str.length() == 0 || ("null").equals(str)) {
			return "";
		} else {
			return str;
		}
	}

	// 为空时返回默认值
	public static String getDefultStr(Object obj) {
		String result = null;
		if (obj == null) {
			result = "";
		} else {
			String str = String.valueOf(obj);
			if (str == null || str.length() == 0 || ("null").equals(str)) {
				result = "";
			} else {
				result = str;
			}
		}
		return result;
	}

	// 截取2个标示符之间的字符串
	public static String substring(String str, String open, String close) {
		if ((str == null) || (open == null) || (close == null)) {
			return null;
		}
		int start = str.indexOf(open);
		if (start != -1) {
			int end = str.indexOf(close, start + open.length());
			if (end != -1) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}

	public static boolean isPositiveAmount(String amount) {
		boolean flag = false;
		try {

			BigDecimal b = new BigDecimal(amount);
			if (b.doubleValue() > 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public static boolean isPositiveNumber(String number) {
		boolean flag = false;
		try {
			if (Integer.valueOf(number).intValue() > 0)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	// 格式化金额
	public static String formatAmount(String amount) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(new BigDecimal(amount));
	}
	//将单位为元的String转为分
	public static String parseYuanToFen(String yuan){
		if(yuan == null) return null;
		int i = yuan.lastIndexOf(".");
		if(i != -1){
			StringBuffer sb = new StringBuffer("");
			sb.append(yuan.substring(0, i));
			int j = yuan.length()-1 - i;
			switch(j){
				case 2: sb.append(yuan.substring(i+1, i+3));break;
				case 1: sb.append(yuan.substring(i+1, i+2)).append("0");break;
				case 0: sb.append("00");break;
				default: sb.append(yuan.substring(i+1, i+3));
			}
			return sb.toString();
			
		}else return yuan+"00";
	}

	// 获取根路径
	public static String getRootPath() {
		return System.getProperty("miugoCSS.root");
	}

	// 生产10位序列号
	public static String createSeq10() {
		SimpleDateFormat sdf = new SimpleDateFormat("mmssSSS");
		// 序列自加
		count10++;
		if (count10 == 1000) {
			count10 = 0;
		}
		String par = formatString(String.valueOf(count10), 3);
		return sdf.format(new Date()) + par;
	}

	// 对字符串进行转码
	public static String transcoding(String str) {
		if(null != str){
			try {
				return new String(str.getBytes(Constant.RB.getString("getBytes_encoding")),"UTF-8").trim();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			str="";
		}
		return str;
	}
	
	// 对字符串进行转码
	public static String transcodingFromUTF8ToISO(String str) {
		if(null != str){
			try {
				return new String(str.getBytes("UTF-8"),"ISO8859-1").trim();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			str="";
		}
		return str;
	}
	
	/**
	 * 得到文件的后缀
	 * @author 荣琪
	 * @createDate 2012年10月16日14:57:07
	 * @param fileName
	 * @return
	 */
	public static String getExt(String fileName){
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * 讲字符串的首字母大写
	 * @author 乐生
	 * @createDate 2012年10月26日17:38:08
	 * @param str
	 * @return
	 */
	public static String upperCaseFirstChar(String str){
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1, str.length()));
		return sb.toString();
	}
	
	/**
	 * 金额加减
	 */
	public static String subtract(String front,String back){
		BigDecimal bigDecimal1 = new BigDecimal(front);
		BigDecimal bigDecimal2 = new BigDecimal(back);
		return bigDecimal1.subtract(bigDecimal2).toString();
				
	}
	
	/**
	 * 返回地区map
	 * @return
	 */
	public static Map<String, String> getDistirct(){
		Map<String,String> districts = new HashMap<String,String>();
		districts.put("110000:北京市","110101:东城区&110102:西城区&110103:崇文区&110104:宣武区&110105:朝阳区&110106:丰台区&110107:石景山区&110108:海淀区&110109:门头沟区&110111:房山区&110112:通州区&110113:顺义区&110114:昌平区&110115:大兴区&110116:怀柔区&110117:平谷区&110228:密云县&110229:延庆县"); 
		districts.put("120000:天津市","120101:和平区&120102:河东区&120103:河西区&120104:南开区&120105:河北区&120106:红桥区&120107:塘沽区&120108:汉沽区&120109:大港区&120110:东丽区&120111:西青区&120112:津南区&120113:北辰区&120114:武清区&120115:宝坻区&120221:宁河县&120223:静海县&120225:蓟　县"); 
		districts.put("130000:河北省","130100:石家庄市&130200:唐山市&130300:秦皇岛市&130400:邯郸市&130500:邢台市&130600:保定市&130700:张家口市&130800:承德市&130900:沧州市&131000:廊坊市&131100:衡水市"); 
		districts.put("140000:山西省","140100:太原市&140200:大同市&140300:阳泉市&140400:长治市&140500:晋城市&140600:朔州市&140700:晋中市&140800:运城市&140900:忻州市&141000:临汾市&142300:吕梁地区"); 
		districts.put("150000:内蒙古自治区","150100:呼和浩特市&150200:包头市&150300:乌海市&150400:赤峰市&150500:通辽市&150600:鄂尔多斯市&150700:呼伦贝尔市&152200:兴安盟&152500:锡林郭勒盟&152600:乌兰察布盟&152800:巴彦淖尔盟&152900:阿拉善盟"); 
		districts.put("210000:辽宁省","210100:沈阳市&210200:大连市&210300:鞍山市&210400:抚顺市&210500:本溪市&210600:丹东市&210700:锦州市&210800:营口市&210900:阜新市&211000:辽阳市&211100:盘锦市&211200:铁岭市&211300:朝阳市&211400:葫芦岛市"); 
		districts.put("220000:吉林省","220100:长春市&220200:吉林市&220300:四平市&220400:辽源市&220500:通化市&220600:白山市&220700:松原市&220800:白城市&222400:延边朝鲜族自治州"); 
		districts.put("230000:黑龙江省","230100:哈尔滨市&230200:齐齐哈尔市&230300:鸡西市&230400:鹤岗市&230500:双鸭山市&230600:大庆市&230700:伊春市&230800:佳木斯市&230900:七台河市&231000:牡丹江市&231100:黑河市&231200:绥化市&232700:大兴安岭地区"); 
		districts.put("310000:上海市","310101:黄浦区&310103:卢湾区&310104:徐汇区&310105:长宁区&310106:静安区&310107:普陀区&310108:闸北区&310109:虹口区&310110:杨浦区&310112:闵行区&310113:宝山区&310114:嘉定区&310115:浦东新区&310116:金山区&310117:松江区&310118:青浦区&310119:南汇区&310120:奉贤区&310230:崇明县"); 
		districts.put("320000:江苏省","320100:南京市&320200:无锡市&320300:徐州市&320400:常州市&320500:苏州市&320600:南通市&320700:连云港市&320800:淮安市&320900:盐城市&321000:扬州市&321100:镇江市&321200:泰州市&321300:宿迁市"); 
		districts.put("330000:浙江省","330100:杭州市&330200:宁波市&330300:温州市&330400:嘉兴市&330500:湖州市&330600:绍兴市&330700:金华市&330800:衢州市&330900:舟山市&331000:台州市&331100:丽水市"); 
		districts.put("340000:安徽省","340100:合肥市&340200:芜湖市&340300:蚌埠市&340400:淮南市&340500:马鞍山市&340600:淮北市&340700:铜陵市&340800:安庆市&341000:黄山市&341100:滁州市&341200:阜阳市&341300:宿州市&341400:巢湖市&341500:六安市&341600:亳州市&341700:池州市&341800:宣城市"); 
		districts.put("350000:福建省","350100:福州市&350200:厦门市&350300:莆田市&350400:三明市&350500:泉州市&350600:漳州市&350700:南平市&350800:龙岩市&350900:宁德市"); 
		districts.put("360000:江西省","360100:南昌市&360200:景德镇市&360300:萍乡市&360400:九江市&360500:新余市&360600:鹰潭市&360700:赣州市&360800:吉安市&360900:宜春市&361000:抚州市&361100:上饶市"); 
		districts.put("370000:山东省","370100:济南市&370200:青岛市&370300:淄博市&370400:枣庄市&370500:东营市&370600:烟台市&370700:潍坊市&370800:济宁市&370900:泰安市&371000:威海市&371100:日照市&371200:莱芜市&371300:临沂市&371400:德州市&371500:聊城市&371600:滨州市&371700:荷泽市"); 
		districts.put("410000:河南省","410100:郑州市&410200:开封市&410300:洛阳市&410400:平顶山市&410500:安阳市&410600:鹤壁市&410700:新乡市&410800:焦作市&410900:濮阳市&411000:许昌市&411100:漯河市&411200:三门峡市&411300:南阳市&411400:商丘市&411500:信阳市&411600:周口市&411700:驻马店市"); 
		districts.put("420000:湖北省","420100:武汉市&420200:黄石市&420300:十堰市&420500:宜昌市&420600:襄樊市&420700:鄂州市&420900:孝感市&421000:荆州市&421100:黄冈市&421200:咸宁市&421300:随州市&422800:恩施土家族苗族自治州");
		districts.put("430000:湖南省","430100:长沙市&430200:株洲市&430300:湘潭市&430400:衡阳市&430500:邵阳市&430600:岳阳市&430700:常德市&430800:张家界市&430900:益阳市&431000:郴州市&431100:永州市&431200:怀化市&431300:娄底市&433100:湘西土家族苗族自治州"); 
		districts.put("440000:广东省","440100:广州市&440200:韶关市&440300:深圳市&440400:珠海市&440500:汕头市&440600:佛山市&440700:江门市&440800:湛江市&440900:茂名市&441200:肇庆市&441300:惠州市&441400:梅州市&441500:汕尾市&441600:河源市&441700:阳江市&441800:清远市&441900:东莞市&442000:中山市&445100:潮州市&445200:揭阳市&445300:云浮市"); 
		districts.put("450000:广西壮族自治区","450100:南宁市&450200:柳州市&450300:桂林市&450400:梧州市&450500:北海市&450600:防城港市&450700:钦州市&450800:贵港市&450900:玉林市&451000:百色市&451100:贺州市&451200:河池市&451300:来宾市&451400:崇左市"); 
		districts.put("460000:海南省","460100:海口市&460200:三亚市"); 
		districts.put("500000:重庆市","500101:万州区&500102:涪陵区&500103:渝中区&500104:大渡口区&500105:江北区&500106:沙坪坝区&500107:九龙坡区&500108:南岸区&500109:北碚区&500110:万盛区&500111:双桥区&500112:渝北区&500113:巴南区&500114:黔江区&500115:长寿区&500116:江津区&500117:合川区&500118:永川区&500119:南川区&500222:綦江县&500223:潼南县&500224:铜梁县&500225:大足县&500226:荣昌县&500227:璧山县&500228:梁平县&500229:城口县&500230:丰都县&500231:垫江县&500232:武隆县&500233:忠　县&500234:开　县&500235:云阳县&500236:奉节县&500237:巫山县&500238:巫溪县&500240:石柱土家族自治县&500241:秀山土家族苗族自治县&500242:酉阳土家族苗族自治县&500243:彭水苗族土家族自治县"); 
		districts.put("510000:四川省","510100:成都市&510300:自贡市&510400:攀枝花市&510500:泸州市&510600:德阳市&510700:绵阳市&510800:广元市&510900:遂宁市&511000:内江市&511100:乐山市&511300:南充市&511400:眉山市&511500:宜宾市&511600:广安市&511700:达州市&511800:雅安市&511900:巴中市&512000:资阳市&513200:阿坝藏族羌族自治州&513300:甘孜藏族自治州&513400:凉山彝族自治州"); 
		districts.put("520000:贵州省","520100:贵阳市&520200:六盘水市&520300:遵义市&520400:安顺市&522200:铜仁地区&522300:黔西南布依族苗族自治州&522400:毕节地区&522600:黔东南苗族侗族自治州&522700:黔南布依族苗族自治州"); 
		districts.put("530000:云南省","530100:昆明市&530300:曲靖市&530400:玉溪市&530500:保山市&530600:昭通市&530700:丽江市&532300:楚雄彝族自治州&532500:红河哈尼族彝族自治州&532600:文山壮族苗族自治州&532700:思茅地区&532800:西双版纳傣族自治州&532900:大理白族自治州&533100:德宏傣族景颇族自治州&533300:怒江傈僳族自治州&533400:迪庆藏族自治州&533500:临沧地区");
		districts.put("540000:西藏自治区","540100:拉萨市&542100:昌都地区&542200:山南地区&542300:日喀则地区&542400:那曲地区&542500:阿里地区&542600:林芝地区"); 
		districts.put("610000:陕西省","610100:西安市&610200:铜川市&610300:宝鸡市&610400:咸阳市&610500:渭南市&610600:延安市&610700:汉中市&610800:榆林市&610900:安康市&611000:商洛市"); 
		districts.put("620000:甘肃省","620100:兰州市&620200:嘉峪关市&620300:金昌市&620400:白银市&620500:天水市&620600:武威市&620700:张掖市&620800:平凉市&620900:酒泉市&621000:庆阳市&621100:定西市&622600:陇南地区&622900:临夏回族自治州&623000:甘南藏族自治州"); 
		districts.put("640000:宁夏回族自治区","640100:银川市&640200:石嘴山市&640300:吴忠市&640400:固原市"); 
		districts.put("630000:青海省","630100:西宁市&632100:海东地区&632200:海北藏族自治州&632300:黄南藏族自治州&632500:海南藏族自治州&632600:果洛藏族自治州&632700:玉树藏族自治州&632800:海西蒙古族藏族自治州"); 
		districts.put("650000:新疆维吾尔自治区","650100:乌鲁木齐市&650200:克拉玛依市&652100:吐鲁番地区&652200:哈密地区&652300:昌吉回族自治州&652700:博尔塔拉蒙古自治州&652800:巴音郭楞蒙古自治州&652900:阿克苏地区&653000:克孜勒柯尔克孜自治州&653100:喀什地区&653200:和田地区&654000:伊犁哈萨克自治州&654200:塔城地区&654300:阿勒泰地区"); 
		districts.put("710000:台湾省","台湾"); 
		districts.put("810000:香港特别行政区","香港"); 
		districts.put("820000:澳门特别行政区","澳门"); 
		return districts;
	}
	
	/**
	 * 金额格式转化：从分转化成元
	 * @author 荣琪
	 * @date 2012年11月20日11:17:41
	 * @param resourceId
	 * @param str
	 * @return
	 */
	public static String formatAmountFromFenToYuan(String amount){
		BigDecimal bigDecimal = new BigDecimal(amount);
		bigDecimal = bigDecimal.divide(new BigDecimal("100"));
		return bigDecimal.toString();
	}
	
	/**
	 * 金额格式转化：从元转化为分
	 * @author 荣琪
	 * @date 2012年11月20日11:17:41
	 * @param resourceId
	 * @param str
	 * @return
	 */
	public static String formatAmountFromYuanToFen(String amount){
		BigDecimal bigDecimal = new BigDecimal(amount);
		bigDecimal = bigDecimal.multiply(new BigDecimal("100"));
		bigDecimal = bigDecimal.setScale(0, RoundingMode.HALF_UP);
		return bigDecimal.toString();
	}
	
	// 获取到短信信息
	// 第一参数为你要获取的资源文件id
	// 第二之后为占位符
	public static String getSMSStr(String resourceId ,String... str) {
		String resourceStr = Constant.RB.getString(resourceId);
		String result = MessageFormat.format(resourceStr,str);
		return result;
	}
	
	/**
	 * 隐藏妙购卡中的中间8位
	 * @author 荣琪
	 * @date 2012年12月26日15:19:06
	 */
	public static String hideMiugoCardNo(String cardNo){
		String result = "";
		if(cardNo==null || "".equals(cardNo) || "null".equals(cardNo)){
			return result;
		}else{
			if(cardNo.length()!=16){
				return cardNo;
			}else{
				result = cardNo.substring(0, 4)+"********"+cardNo.substring(12, 16);
				return result;
			}
		}
	}
	
	/**
	 * 隐藏手机号的中间4位
	 * @author 荣琪
	 * @date 2012年12月26日15:19:06
	 */
	public static String hidePhoneNo(String phone){
		String result = "";
		if(phone==null || "".equals(phone) || "null".equals(phone)){
			return phone;
		}else{
			if(phone.length()!= 11){
				return phone;
			}else{
				result = phone.substring(0, 3)+"****"+phone.substring(7, 11);
				return result;
			}
		}
	}
	
	public static void main(String[] args) {
//		 System.out.print(divide("33", "7"));
		 System.out.print(formatAmountFromFenToYuan("10"));
	}
	
	/**
	 * 判断卡号的类型
	 * @param cardNo
	 * @return
	 */
	public static String judgeCardType(String cardNo) {
		if(cardNo.length() != 16) return "卡号的长度不对";//卡号为16位
		String typeStr = cardNo.substring(6, 8);//截取第七和第八个字符判断
		if(typeStr.equals("18")){//个人卡
			return Constant.CART_TYPE_PS;
		}else if(typeStr.equals("28")||typeStr.equals("58")){//商户卡
			return Constant.CART_TYPE_MC;
		}else if(typeStr.equals("38")||typeStr.equals("68")){//企业卡
			return Constant.CART_TYPE_CO;
		}else{//未知卡类型
			return Constant.CART_TYPE_UK;
		}
		
	}
}
