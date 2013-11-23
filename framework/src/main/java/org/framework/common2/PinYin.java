package org.framework.common2;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

//将汉字转换为拼音
public class PinYin {

	public static String getPingYin(String src) {
		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				} else
					t4 += java.lang.Character.toString(t1[i]);
			}
			// System.out.println(t4);
			return t4;
		} catch (BadHanyuPinyinOutputFormatCombination e1) {
			e1.printStackTrace();
		}
		return t4;
	}

	// 返回中文的首字母
	public static String getPinYinHeadChar(String str) {
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

	// 将字符串转移为ASCII码
	public static String getCnASCII(String cnStr) {
		StringBuffer strBuf = new StringBuffer();
		byte[] bGBK = cnStr.getBytes();
		for (int i = 0; i < bGBK.length; i++) {
			// System.out.println(Integer.toHexString(bGBK[i]&0xff));
			strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
		}
		return strBuf.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String cnStr = "广州"; 
//		System.out.println(getPinYinHeadChar(cnStr)+"/"+getPingYin(cnStr)); 
		
		System.err.println(getPingYin("北京         "));
		System.err.println(getPingYin("广州         "));
		System.err.println(getPingYin("上海         "));
		System.err.println(getPingYin("深圳         "));
		System.err.println(getPingYin("天津         "));
		System.err.println(getPingYin("乌鲁木齐       "));
		System.err.println(getPingYin("西安         "));
		System.err.println(getPingYin("成都         "));
		System.err.println(getPingYin("重庆         "));
		System.err.println(getPingYin("福州         "));
		System.err.println(getPingYin("杭州         "));
		System.err.println(getPingYin("昆明         "));
		System.err.println(getPingYin("沈阳         "));
		System.err.println(getPingYin("武汉         "));
		System.err.println(getPingYin("厦门         "));
		System.err.println(getPingYin("郑州         "));
		System.err.println(getPingYin("长沙         "));
		System.err.println(getPingYin("大连         "));
		System.err.println(getPingYin("海口         "));
		System.err.println(getPingYin("南京         "));
		System.err.println(getPingYin("青岛         "));
		System.err.println(getPingYin("三亚         "));
		System.err.println(getPingYin("太原         "));
		System.err.println(getPingYin("温州         "));
		System.err.println(getPingYin("桂林         "));
		System.err.println(getPingYin("贵阳         "));
		System.err.println(getPingYin("哈尔滨        "));
		System.err.println(getPingYin("济南         "));
		System.err.println(getPingYin("南昌         "));
		System.err.println(getPingYin("宁波         "));
		System.err.println(getPingYin("塔城         "));
		System.err.println(getPingYin("无锡         "));
		System.err.println(getPingYin("西双版纳       "));
		System.err.println(getPingYin("烟台         "));
		System.err.println(getPingYin("银川         "));
		System.err.println(getPingYin("张家界        "));
		System.err.println(getPingYin("珠海         "));
		System.err.println(getPingYin("长春         "));
		System.err.println(getPingYin("佛山         "));
		System.err.println(getPingYin("合肥         "));
		System.err.println(getPingYin("呼和浩特       "));
		System.err.println(getPingYin("泉州(晋江)     "));
		System.err.println(getPingYin("九寨沟        "));
		System.err.println(getPingYin("兰州         "));
		System.err.println(getPingYin("拉萨         "));
		System.err.println(getPingYin("丽江         "));
		System.err.println(getPingYin("南宁         "));
		System.err.println(getPingYin("汕头(揭阳)     "));
		System.err.println(getPingYin("韶关         "));
		System.err.println(getPingYin("石家庄        "));
		System.err.println(getPingYin("威海         "));
		System.err.println(getPingYin("武夷山        "));
		System.err.println(getPingYin("西昌         "));
		System.err.println(getPingYin("西宁         "));
		System.err.println(getPingYin("徐州         "));
		System.err.println(getPingYin("延吉         "));
		System.err.println(getPingYin("宜昌         "));
		System.err.println(getPingYin("伊宁         "));
		System.err.println(getPinYinHeadChar("义乌         "));
		System.err.println(getPinYinHeadChar("运城         "));
		System.err.println(getPinYinHeadChar("湛江         "));
		System.err.println(getPinYinHeadChar("舟山         "));
		System.err.println(getPinYinHeadChar("阿勒泰        "));
		System.err.println(getPinYinHeadChar("包头         "));
		System.err.println(getPinYinHeadChar("常州         "));
		System.err.println(getPinYinHeadChar("大理         "));
		System.err.println(getPinYinHeadChar("迪庆(香格里拉)   "));
		System.err.println(getPinYinHeadChar("敦煌         "));
		System.err.println(getPinYinHeadChar("恩施         "));
		System.err.println(getPinYinHeadChar("海拉尔        "));
		System.err.println(getPinYinHeadChar("黄山         "));
		System.err.println(getPinYinHeadChar("台州（黄岩）     "));
		System.err.println(getPinYinHeadChar("喀什         "));
		System.err.println(getPinYinHeadChar("临沂         "));
		System.err.println(getPinYinHeadChar("柳州         "));
		System.err.println(getPinYinHeadChar("芒市         "));
		System.err.println(getPinYinHeadChar("绵阳         "));
		System.err.println(getPinYinHeadChar("攀枝花        "));
		System.err.println(getPinYinHeadChar("万州         "));
		System.err.println(getPinYinHeadChar("襄樊(襄阳)     "));
		System.err.println(getPinYinHeadChar("宜宾         "));
		System.err.println(getPinYinHeadChar("榆林         "));
		System.err.println(getPinYinHeadChar("长白山        "));
		System.err.println(getPinYinHeadChar("大庆         "));
		System.err.println(getPinYinHeadChar("北海         "));
		System.err.println(getPinYinHeadChar("常德         "));
		System.err.println(getPinYinHeadChar("长治         "));
		System.err.println(getPinYinHeadChar("和田         "));
		System.err.println(getPinYinHeadChar("景德镇        "));
		System.err.println(getPinYinHeadChar("库尔勒        "));
		System.err.println(getPinYinHeadChar("连云港        "));
		System.err.println(getPinYinHeadChar("临沧         "));
		System.err.println(getPinYinHeadChar("洛阳         "));
		System.err.println(getPinYinHeadChar("泸州         "));
		System.err.println(getPinYinHeadChar("满洲里        "));
		System.err.println(getPinYinHeadChar("牡丹江        "));
		System.err.println(getPinYinHeadChar("南通         "));
		System.err.println(getPinYinHeadChar("沙市         "));
		System.err.println(getPinYinHeadChar("思茅         "));
		System.err.println(getPinYinHeadChar("苏州         "));
		System.err.println(getPinYinHeadChar("通化         "));
		System.err.println(getPinYinHeadChar("通辽         "));
		System.err.println(getPinYinHeadChar("铜仁         "));
		System.err.println(getPinYinHeadChar("乌兰浩特       "));
		System.err.println(getPinYinHeadChar("潍坊         "));
		System.err.println(getPinYinHeadChar("乌海         "));
		System.err.println(getPinYinHeadChar("芜湖         "));
		System.err.println(getPinYinHeadChar("梧州         "));
		System.err.println(getPinYinHeadChar("锡林浩特       "));
		System.err.println(getPinYinHeadChar("兴城         "));
		System.err.println(getPinYinHeadChar("兴宁         "));
		System.err.println(getPinYinHeadChar("邢台         "));
		System.err.println(getPinYinHeadChar("延安         "));
		System.err.println(getPinYinHeadChar("盐城         "));
		System.err.println(getPinYinHeadChar("宜兰         "));
		System.err.println(getPinYinHeadChar("永州         "));
		System.err.println(getPinYinHeadChar("元谋         "));
		System.err.println(getPinYinHeadChar("怀化         "));
		System.err.println(getPinYinHeadChar("昭通         "));
		System.err.println(getPinYinHeadChar("遵义         "));
		System.err.println(getPinYinHeadChar("邯郸         "));
		System.err.println(getPinYinHeadChar("兴义         "));
		System.err.println(getPinYinHeadChar("广元         "));
		System.err.println(getPinYinHeadChar("阜阳         "));
		System.err.println(getPinYinHeadChar("林芝         "));
		System.err.println(getPinYinHeadChar("漠河         "));
		System.err.println(getPinYinHeadChar("天水         "));
		System.err.println(getPinYinHeadChar("喀呐斯        "));
		System.err.println(getPinYinHeadChar("黎平         "));
		System.err.println(getPinYinHeadChar("腾冲         "));
		System.err.println(getPinYinHeadChar("康定         "));
		System.err.println(getPinYinHeadChar("百色         "));
		System.err.println(getPinYinHeadChar("玉树         "));
		System.err.println(getPinYinHeadChar("荔波         "));
		System.err.println(getPinYinHeadChar("伊春         "));
		System.err.println(getPinYinHeadChar("鸡西         "));
		System.err.println(getPinYinHeadChar("二连浩特       "));
		System.err.println(getPinYinHeadChar("那拉提        "));
		System.err.println(getPinYinHeadChar("固原         "));
		System.err.println(getPinYinHeadChar("阿里         "));
		System.err.println(getPinYinHeadChar("唐山         "));
		System.err.println(getPinYinHeadChar("淮安         "));
		System.err.println(getPinYinHeadChar("博乐         "));
		System.err.println(getPinYinHeadChar("日喀则        "));
		System.err.println(getPinYinHeadChar("中卫         "));
		System.err.println(getPinYinHeadChar("金昌         "));
		System.err.println(getPinYinHeadChar("文山         "));
		System.err.println(getPinYinHeadChar("阿尔山        "));
		System.err.println(getPinYinHeadChar("黔江         "));
		System.err.println(getPinYinHeadChar("扬州         "));
		System.err.println(getPinYinHeadChar("巴彦淖尔       "));
		System.err.println(getPinYinHeadChar("张掖         "));
		System.err.println(getPinYinHeadChar("加格达奇       "));
		System.err.println(getPinYinHeadChar("阿克苏        "));
		System.err.println(getPinYinHeadChar("安康         "));
		System.err.println(getPinYinHeadChar("安庆         "));
		System.err.println(getPinYinHeadChar("鞍山         "));
		System.err.println(getPinYinHeadChar("安顺         "));
		System.err.println(getPinYinHeadChar("安阳         "));
		System.err.println(getPinYinHeadChar("保山         "));
		System.err.println(getPinYinHeadChar("蚌埠         "));
		System.err.println(getPinYinHeadChar("长海         "));
		System.err.println(getPinYinHeadChar("朝阳         "));
		System.err.println(getPinYinHeadChar("昌都         "));
		System.err.println(getPinYinHeadChar("赤峰         "));
		System.err.println(getPinYinHeadChar("丹东         "));
		System.err.println(getPinYinHeadChar("大同         "));
		System.err.println(getPinYinHeadChar("达州（达县）     "));
		System.err.println(getPinYinHeadChar("东营         "));
		System.err.println(getPinYinHeadChar("鄂尔多斯       "));
		System.err.println(getPinYinHeadChar("富蕴         "));
		System.err.println(getPinYinHeadChar("赣州         "));
		System.err.println(getPinYinHeadChar("格尔木        "));
		System.err.println(getPinYinHeadChar("广汉         "));
		System.err.println(getPinYinHeadChar("哈密         "));
		System.err.println(getPinYinHeadChar("汉中         "));
		System.err.println(getPinYinHeadChar("黑河         "));
		System.err.println(getPinYinHeadChar("衡阳         "));
		System.err.println(getPinYinHeadChar("徽州         "));
		System.err.println(getPinYinHeadChar("佳木斯        "));
		System.err.println(getPinYinHeadChar("嘉峪关        "));
		System.err.println(getPinYinHeadChar("吉林         "));
		System.err.println(getPinYinHeadChar("井冈山        "));
		System.err.println(getPinYinHeadChar("济宁         "));
		System.err.println(getPinYinHeadChar("锦州         "));
		System.err.println(getPinYinHeadChar("九江         "));
		System.err.println(getPinYinHeadChar("酒泉         "));
		System.err.println(getPinYinHeadChar("克拉玛依       "));
		System.err.println(getPinYinHeadChar("库车         "));
		System.err.println(getPinYinHeadChar("连城         "));
		System.err.println(getPinYinHeadChar("梁平         "));
		System.err.println(getPinYinHeadChar("林西         "));
		System.err.println(getPinYinHeadChar("庐山         "));
		System.err.println(getPinYinHeadChar("梅县         "));
		System.err.println(getPinYinHeadChar("南充         "));
		System.err.println(getPinYinHeadChar("南阳         "));
		System.err.println(getPinYinHeadChar("且末         "));
		System.err.println(getPinYinHeadChar("庆阳         "));
		System.err.println(getPinYinHeadChar("秦皇岛        "));
		System.err.println(getPinYinHeadChar("齐齐哈尔       "));
		System.err.println(getPinYinHeadChar("衢州         "));
		System.err.println(getPinYinHeadChar("鄯善         "));
		System.err.println(getPinYinHeadChar("吐鲁番        "));


	}

}
