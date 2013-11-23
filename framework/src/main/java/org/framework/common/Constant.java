package org.framework.common;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Constant {
	
	public final static ResourceBundle RB = ResourceBundle.getBundle("msg");
	
	//卡号类型
	/** 未知卡 */
	public static final String CART_TYPE_UK = "04";
	/** 个人卡 */
	public static final String CART_TYPE_PS = "00";
	/** 商户卡 */
	public static final String CART_TYPE_MC = "01";
	/** 企业卡 */
	public static final String CART_TYPE_CO = "02";
	
	//页面显示条数
	public static int    PAGE_SIZE = 10;
	public static int PAGE_SIZE_10 = 10;
	public static int PAGE_SIZE_8 = 8;
	public static String PASSWORD  = "888888"; //商户默认密码
	
	/**
	 * 测试和生产的标志
	 */
	public static String product_env_flag_test = "0";
	public static String product_env_flag_product = "1";
	
	/**
	 * 命名空间
	 */
	public static String NAMESPACE_ENTERPRISE = "enterprise";
	public static String NAMESPACE_MERCHANT = "merchant";
	
	/**
	 * 登录状态
	 * 0 = 成功
	 */
	public static String LOGIN_SUSSESS = "0";
	
	public static String SESSION_USERINFO = "session_userinfo";   //session中存放的user
	public static String SESSION_LOGINUSERINFO = "session_loginuserinfo";   //session中存放的loginuser
	public static String SESSION_ROLEINFO = "session_roleinfo";   //session中存放的role
	public static String SESSION_RESOURCEINFO = "session_resourceinfo";//session中存放的resource
	public static String SESSION_IPADDRESS = "session_ipaddress";   //session中存放的登录用户ip地址
	public static String USER_DISABLE = "0"; //用户禁用状态
	public static String USER_ENABLE  = "1"; //用户激活状态
	
	public static String SEPARATOR  = "┆";   //分隔符
	//用户操作类型
	public static String OPERATORTYPE_OTHER   = "其他"; 
	public static String OPERATORTYPE_ADD     = "增加"; 
	public static String OPERATORTYPE_DELETE  = "删除";
	public static String OPERATORTYPE_UPDATE  = "修改";
	public static String OPERATORTYPE_SELECT  = "查询";
	//需要拦截的非法字符
	public static String VALIDATE_STRING="┆'┆\"" +
										 "┆http://┆www." +
			   							 "┆execute┆insert┆select┆delete┆update┆declare" +
			                             "┆alert┆confirm┆prompt┆";
	/**
	 * 系统类型
	 * 1=妙购一卡通后台
	 * 2=企业服务系统
	 * 3=商户服务系统
	 */
	public static String SYSTEM_TYPE_HGGLXT = "1";
	public static String SYSTEM_TYPE_QYFUXT = "2";
	public static String SYSTEM_TYPE_SHFUXT = "3";
	
	/**
	 * 日志类型
	 * OPERLOG_TYPE_0=其他
	 * OPERLOG_TYPE_1=增加
	 * OPERLOG_TYPE_2=删除
	 * OPERLOG_TYPE_3=修改
	 * OPERLOG_TYPE_4=查询
	 * OPERLOG_TYPE_5=金额类交易
	 */
	public static String OPERLOG_TYPE_0 = "0";// 其他日志类型(注解方式)
	public static String OPERLOG_TYPE_1 = "1";// 增加(注解方式)
	public static String OPERLOG_TYPE_2 = "2";// 删除(注解方式)
	public static String OPERLOG_TYPE_3 = "3";// 修改(注解方式)
	public static String OPERLOG_TYPE_4 = "4";// 查询(注解方式)
	public static String OPERLOG_TYPE_5 = "5";// 金额类交易(调用baseService记录数据库)
	public static Map<String,String> OPERLOG_TYPE_MAP= new HashMap<String,String>();
	static{
		OPERLOG_TYPE_MAP.put(OPERLOG_TYPE_0, "其他");
		OPERLOG_TYPE_MAP.put(OPERLOG_TYPE_1, "增加");
		OPERLOG_TYPE_MAP.put(OPERLOG_TYPE_2, "删除");
		OPERLOG_TYPE_MAP.put(OPERLOG_TYPE_3, "修改");
		OPERLOG_TYPE_MAP.put(OPERLOG_TYPE_4, "查询");
		OPERLOG_TYPE_MAP.put(OPERLOG_TYPE_5, "金额类交易");
	}
	
	public static String SUBTYPE_RESETCARD_PWD = "1";
	public static String SUBTYPE_UNLOCK_CARD = "2";
	
	/**
	 * 角色信息
	 * 1=管理员
	 * 2=商户
	 * 3=门店
	 * 4=企业
	 * 5=外接商户
	 */
	public static String USER_ROLE_GLY = "1";
	public static String USER_ROLE_SH = "2";
	public static String USER_ROLE_MD = "3";
	public static String USER_ROLE_QY = "4";
	public static String USER_ROLE_WJSH = "5";
	
	public static Map<String,String> USER_ROLE_Map= new HashMap<String,String>();
	static{
		USER_ROLE_Map.put(USER_ROLE_GLY, "管理员");
		USER_ROLE_Map.put(USER_ROLE_SH, "商户");
		USER_ROLE_Map.put(USER_ROLE_MD, "门店");
		USER_ROLE_Map.put(USER_ROLE_QY, "企业");
		USER_ROLE_Map.put(USER_ROLE_WJSH, "外接商户");
	}
	
	
	
	
	/**
	 * 企业证件类型
	 * 01=营业执照号
	 * 02=税务登记证号
	 * 03=组织机构代码证
	 */
	public static String CERT_TYPE_YYZZ = "01";
	public static String CERT_TYPE_SSDJZ = "02";
	public static String CERT_TYPE_ZZJGDM = "03";
	public static Map<String,String> CERT_TYPE_MAP= new HashMap<String,String>();
	static{
		CERT_TYPE_MAP.put(CERT_TYPE_YYZZ, "营业执照");
		CERT_TYPE_MAP.put(CERT_TYPE_SSDJZ, "税务登记证");
		CERT_TYPE_MAP.put(CERT_TYPE_ZZJGDM, "组织机构代码证");
	}
	
	/**
	 * 联系人证件类型
	 * 	01=身份证
	 *	02=军官证
	 *	03=护照
	 *	04=回乡证
	 *	05=台胞证
	 *	06=警官证
	 *	99=其他证件
	 *	0X=非实名制卡
	 */
	public static String ID_TYPE_SFZ = "01";
	public static String ID_TYPE_JUNGZ = "02";
	public static String ID_TYPE_HZ = "03";
	public static String ID_TYPE_HXZ = "04";
	public static String ID_TYPE_TBZ = "05";
	public static String ID_TYPE_JINGZ = "06";
	public static String ID_TYPE_QTZJ = "99";
	public static String ID_TYPE_FSMZK = "0X";
	public static Map<String,String> ID_TYPE_MAP= new HashMap<String,String>();
	static{
		ID_TYPE_MAP.put(ID_TYPE_SFZ, "身份证");
		ID_TYPE_MAP.put(ID_TYPE_JUNGZ, "军官证");
		ID_TYPE_MAP.put(ID_TYPE_HZ, "护照");
		ID_TYPE_MAP.put(ID_TYPE_HXZ, "回乡证");
		ID_TYPE_MAP.put(ID_TYPE_TBZ, "台胞证");
		ID_TYPE_MAP.put(ID_TYPE_JINGZ, "警官证");
		ID_TYPE_MAP.put(ID_TYPE_QTZJ, "其他证件");
		ID_TYPE_MAP.put(ID_TYPE_FSMZK, "非实名制卡");
	}
	
	/**
	 * 审核状态
	 * 00=待审核
	 * 01=部分审核通过
	 * 02=审核通过
	 * 03=审核不通过
	 */
	public static String SHZT_DSH = "00";
	public static String SHZT_BFSHTG = "01";
	public static String SHZT_SHTG = "02";
	public static String SHZT_SHBTG = "03";
	public static Map<String,String> SHZT_MAP= new HashMap<String,String>();
	static{
		SHZT_MAP.put(SHZT_DSH, "待审核");
		SHZT_MAP.put(SHZT_BFSHTG, "部分审核通过");
		SHZT_MAP.put(SHZT_SHTG, "审核通过");
		SHZT_MAP.put(SHZT_SHBTG, "审核不通过");
	}
	
	/**
	 * 注册状态
	 * 00=待注册
	 * 01=部分注册成功
	 * 02=注册成功
	 * 03=注册失败
	 */
	public static String ZCZT_DZC = "00";
	public static String ZCZT_BFZCCG = "01";
	public static String ZCZT_ZCCG = "02";
	public static String ZCZT_ZCSB = "03";
	public static Map<String,String> ZCZT_MAP= new HashMap<String,String>();
	static{
		ZCZT_MAP.put(ZCZT_DZC, "待注册");
		ZCZT_MAP.put(ZCZT_BFZCCG, "部分注册成功");
		ZCZT_MAP.put(ZCZT_ZCCG, "注册成功");
		ZCZT_MAP.put(ZCZT_ZCSB, "注册失败");
	}
	
	/**
	 * T_INF_ACCOUNT的账户类型
	 * 00=通用个人账户
	 * 01=商户账户
	 */
	public static String T_INF_ACCOUNT_ACCT_TYPE_GR="00";//通用个人账户
	public static String T_INF_ACCOUNT_ACCT_TYPE_SH="01";//商户账户
	
	/**
	 * T_INF_ACCOUNT的账户描述
	 * shzh=商户账户
	 */
	public static String T_INF_ACCOUNT_ACCT_ACCT_DSP_SHZH = "商户账户";//商户账户
	
	/**
	 * T_INF_ACCOUNT的账户隶属机构
	 */
	public static String T_INF_ACCOUNT_ACCT_AFFILIATION= "10000000001";
	
	/**
	 * T_INF_ACCOUNT的账户状态
	 * 0=正常
	 */
	public static String T_INF_ACCOUNT_ACCT_STAT_ZC = "0";//正常
	
	/**
	 * T_INF_MCHNT_ACCOUNT的绑定状态
	 * 1=已绑定
	 * 0=未绑定
	 */
	public static String T_INF_MCHNT_ACCOUNT_YBD = "1";
	public static String T_INF_MCHNT_ACCOUNT_WBD = "0";
	
	/**
	 * 注册类型
	 * 01=商户
	 * 02=企业
	 */
	public static String REG_TYPE_CO = "02";
	public static String REG_TYPE_MCHNT = "01";
	
	/**
	 * 有效标志
	 * 0=无效
	 * 1=有效
	 */
	public static String VALID_FLAG_INVALID = "0";
	public static String VALID_FLAG_VALID = "1";
	
	/**
	 * 代扣标志
	 * 0=否
	 * 1=是
	 */
	public static String DK_YES = "0";
	public static String DK_NO = "1";
	
	/**
	 * 扣费状态
	 * 00= 未扣费
	 * 01= 部分扣费成功
	 * 02= 扣费成功
	 * 03= 扣费失败
	 */
	public static String KFZT_WKF = "00";
	public static String KFZT_KFBFCG = "01";
	public static String KFZT_KFCG = "02";
	public static String KFZT_KFSB = "04";
	public static Map<String,String> KFZT_MAP= new HashMap<String,String>();
	static{
		KFZT_MAP.put(KFZT_WKF, "未扣费");
		KFZT_MAP.put(KFZT_KFBFCG, "部分扣费成功");
		KFZT_MAP.put(KFZT_KFCG, "扣费成功");
		KFZT_MAP.put(KFZT_KFSB, "扣费失败");
	}
	
	/**
	 * 审核复核状态 用于交易记录审核
	 * 0=未审核
	 * 1=审核不通过
	 * 2=已审核
	 * 3=已复核
	 * 4=复核不通过
	 */
	public static String SHFHZT_WSH = "0";
	public static String SHFHZT_SHBTG = "1";
	public static String SHFHZT_YSH = "2";
	public static String SHFHZT_YFH = "3";
	public static String SHFHZT_FHBTG = "4";
	public static Map<String,String> SHFHZT_MAP= new HashMap<String,String>();
	static{
		SHFHZT_MAP.put(SHFHZT_WSH, "未审核");
		SHFHZT_MAP.put(SHFHZT_SHBTG, "审核不通过");
		SHFHZT_MAP.put(SHFHZT_YSH, "已审核");
		SHFHZT_MAP.put(SHFHZT_YFH, "已复核");
		SHFHZT_MAP.put(SHFHZT_FHBTG, "复核不通过");
	}
	/**
	 * 交易记录账前审核状态
	 * 0=初始状态
	 * 1=审核状态
	 */
	public static String TRSHZT_CSZT="0";
	public static String TRSHZT_SHTG="1";
	
	/**
	 * 优惠券发放类型   D-日 W-周 M-月 E 一次性发放
	 */
	public static String FFLX_YCX="E";
	public static String FFLX_AR="D";
	public static String FFLX_AZ="W";
	public static String FFLX_AY="M";
	public static Map<String,String> FFLX_MAP= new HashMap<String,String>();
	static{
		FFLX_MAP.put(FFLX_YCX, "一次性发放");
		FFLX_MAP.put(FFLX_AR, "按日");
		FFLX_MAP.put(FFLX_AZ, "按周");
		FFLX_MAP.put(FFLX_AY, "按月");
	}
	
	/**
	 * 优惠券消费方式：00=交易金额百分比 01=固定金额
	 */
	public static String XFFS_BFB = "2";
	public static String XFFS_GDJE = "1";
	public static Map<String, String> XFFS_MAP = new HashMap<String, String>();
	static{
		XFFS_MAP.put(XFFS_BFB, "交易金额百分比");
		XFFS_MAP.put(XFFS_GDJE, "固定金额");
	}
	
	/**
	 * 优惠券发放标识  0-不允许(通过实时完成) 1-允许 2-已经完成
	 */
	public static String FFBZ_YWC = "2";
	public static String FFBZ_YX = "1";
	public static String FFBZ_BYX = "0";
	public static Map<String, String> FFBZ_MAP = new HashMap<String, String>();
	static{
		FFBZ_MAP.put(FFBZ_YWC, "已完成 ");
		FFBZ_MAP.put(FFBZ_YX, "允许");
		FFBZ_MAP.put(FFBZ_BYX, "不允许");
	}
	
	/**
	 * 交易类型
	 * 9004 = 信用卡还款
	 * 9101 = 商户提现
	 * 9102 = 转账汇款
	 * 7555 = 退款
	 */
	public static String TRAN_TYPE_XYKHK_9004 = "9004";
	public static String TRAN_TYPE_SHTX_9101 = "9101";
	public static String TRAN_TYPE_ZZHK_9102 = "9102";
	public static String TRAN_TYPE_TK_7555 = "7555";
	public static Map<String, String> TRAN_TYPE_MAP = new HashMap<String, String>();
	static{
		TRAN_TYPE_MAP.put(TRAN_TYPE_XYKHK_9004, "信用卡还款");
		TRAN_TYPE_MAP.put(TRAN_TYPE_SHTX_9101, "商户提现");
		TRAN_TYPE_MAP.put(TRAN_TYPE_ZZHK_9102, "转账汇款");
		TRAN_TYPE_MAP.put(TRAN_TYPE_TK_7555, "退款");
	}
	
	/**
	 * 订单状态
	 * 0 = 交易中
	 * 1 = 交易成功
	 * 2 = 交易失败
	 * 11 = 交易成功
	 * 22 = 交易失败
	 * 9  = 退款
	 * -1 = 找不到此订单
	 */
	public static String ORDER_STATE_CZZ = "0";
	public static String ORDER_STATE_CZCG = "1";
	public static String ORDER_STATE_CZSB = "2";
	public static String ORDER_STATE_CZCG11 = "11";
	public static String ORDER_STATE_CZSB22 = "22";
	public static String ORDER_STATE_TK = "9";
	public static String ORDER_STATE_WCDD = "-1";
	public static Map<String, String> ORDER_STATE_MAP = new HashMap<String, String>();
	static{
		ORDER_STATE_MAP.put(ORDER_STATE_CZZ, "交易中");
		ORDER_STATE_MAP.put(ORDER_STATE_CZCG, "交易成功");
		ORDER_STATE_MAP.put(ORDER_STATE_CZSB, "交易失败");
		ORDER_STATE_MAP.put(ORDER_STATE_CZCG11, "交易成功");
		ORDER_STATE_MAP.put(ORDER_STATE_CZSB22, "交易失败");
		ORDER_STATE_MAP.put(ORDER_STATE_TK, "退款");
		ORDER_STATE_MAP.put(ORDER_STATE_WCDD, "找不到此订单");
	}
	
	/**
	 * 交易记录订单状态
	 * 6 = 待发货
	 * 0 = 已发货
	 * 4 = 已收货
	 * 3 = 已退款
	 * 5 = 已退货
	 * 99  = 异常
	 */
	public static String TRAN_ORDER_STATE_DFH = "6";
	public static String TRAN_ORDER_STATE_YFH = "0";
	public static String TRAN_ORDER_STATE_YSH = "4";
	public static String TRAN_ORDER_STATE_YTK = "3";
	public static String TRAN_ORDER_STATE_YTH = "5";
	public static String TRAN_ORDER_STATE_YYZT = "99";
	public static Map<String, String> TRAN_ORDER_STATE_MAP = new HashMap<String, String>();
	static{
		TRAN_ORDER_STATE_MAP.put(TRAN_ORDER_STATE_DFH, "待发货");
		TRAN_ORDER_STATE_MAP.put(TRAN_ORDER_STATE_YFH, "已发货");
		TRAN_ORDER_STATE_MAP.put(TRAN_ORDER_STATE_YSH, "已收货");
		TRAN_ORDER_STATE_MAP.put(TRAN_ORDER_STATE_YTK, "已退款");
		TRAN_ORDER_STATE_MAP.put(TRAN_ORDER_STATE_YTH, "已退货");
		TRAN_ORDER_STATE_MAP.put(TRAN_ORDER_STATE_YYZT, "异常");
	}
	/**
	 * 认证状态：0初始1审核通过2审核不通过3复核不通过4账户金额发送失败5账户金额发送成功
	 */
	public static String RZZT_CS = "0";
	public static String RZZT_SHTG = "1";
	public static String RZZT_SHBTG = "2";
	public static String RZZT_FHBTG = "3";
	public static String RZZT_JEFSSB = "4";
	public static String RZZT_JEFSCG = "5";
	public static Map<String, String> RZZT_MAP = new HashMap<String, String>();
	static{
		RZZT_MAP.put(RZZT_CS, "未认证");
		RZZT_MAP.put(RZZT_SHTG, "已认证");
		RZZT_MAP.put(RZZT_SHBTG, "认证不通过");
		RZZT_MAP.put(RZZT_FHBTG, "拒绝认证");
		RZZT_MAP.put(RZZT_JEFSSB, "金额发送失败");
		RZZT_MAP.put(RZZT_JEFSCG, "金额发送成功");
	}
	
	
	/**
	 * 积分类型
	 */
	public static String POINT_TYPE_PCSC = "A";
	public static String POINT_TYPE_DSSC = "B";
	public static String POINT_TYPE_DHJF = "C";
	public static String POINT_TYPE_BYJF = "D";
	public static Map<String, String> POINT_TYPE_MAP = new HashMap<String, String>();
	static{
		POINT_TYPE_MAP.put(POINT_TYPE_PCSC, "妙购PC商城");
		POINT_TYPE_MAP.put(POINT_TYPE_DSSC, "妙购电视商城");
		POINT_TYPE_MAP.put(POINT_TYPE_DHJF, "导航积分");
		POINT_TYPE_MAP.put(POINT_TYPE_BYJF, "81电视或PC");
	}
	public static Map<String, Map<String, String>> POINT_SUB_TYPE_MAP = new HashMap<String, Map<String, String>>();
	static{
		Map<String, String> MIUGO_PCMAP = new HashMap<String, String>();
			MIUGO_PCMAP.put("01", "注册送积分");
			MIUGO_PCMAP.put("02", "每天登录一次送积分");
			MIUGO_PCMAP.put("03", "看视频送积分");
			MIUGO_PCMAP.put("04", "每笔订单交易完成送积分");
			MIUGO_PCMAP.put("05", "手机充值送积分");
			MIUGO_PCMAP.put("06", "邀请好友注册送积分");
			MIUGO_PCMAP.put("07", "订单转发分享送积分");
			MIUGO_PCMAP.put("08", "用户生日送积分");
		Map<String, String> MIUGO_DSMAP = new HashMap<String, String>();
			MIUGO_DSMAP.put("01", "注册送积分");
			MIUGO_DSMAP.put("02", "每天登录一次送积分");
			MIUGO_DSMAP.put("03", "看视频送积分");
			MIUGO_DSMAP.put("04", "每笔订单交易完成送积分");
			MIUGO_DSMAP.put("05", "手机充值送积分");
			MIUGO_DSMAP.put("06", "邀请好友注册送积分");
			MIUGO_DSMAP.put("07", "订单转发分享送积分");
			MIUGO_DSMAP.put("08", "用户生日送积分");
		Map<String, String> DHJF_MAP = new HashMap<String, String>();
			DHJF_MAP.put("01", "注册送积分");
			DHJF_MAP.put("02", "每天签到送积分");
			DHJF_MAP.put("03", "浏览商户送分");
			DHJF_MAP.put("04", "邀请好友注册送积分");
			DHJF_MAP.put("05", "转发分享送积分");
			DHJF_MAP.put("06", "推广送分");
		Map<String, String> BY_MAP = new HashMap<String, String>();
			BY_MAP.put("01", "注册送积分");
			BY_MAP.put("02", "每天登录一次送积分");
			BY_MAP.put("03", "看视频送积分");
			BY_MAP.put("04", "每笔订单交易完成送积分");
			BY_MAP.put("05", "手机充值送积分");
			BY_MAP.put("06", "邀请好友注册送积分");
			BY_MAP.put("07", "订单转发分享送积分");
			BY_MAP.put("08", "用户生日送积分");
		
		POINT_SUB_TYPE_MAP.put(POINT_TYPE_PCSC, MIUGO_PCMAP);
		POINT_SUB_TYPE_MAP.put(POINT_TYPE_DSSC, MIUGO_DSMAP);
		POINT_SUB_TYPE_MAP.put(POINT_TYPE_DHJF, DHJF_MAP);
		POINT_SUB_TYPE_MAP.put(POINT_TYPE_BYJF, BY_MAP);
	}
	
	
	/**
	 * 制卡录入状态
	 * 00 = 未录入
	 * 01 = 部分录入
	 * 02 = 录入成功
	 * 03 = 重复记录
	 */
	public static String ZKLR_WLR = "00";
	public static String ZKLR_BFLR = "01";
	public static String ZKLR_LRCG = "02";
	public static String ZKLR_CFJL = "03";
	public static Map<String, String> ZKLR_MAP = new HashMap<String, String>();
	static{
		ZKLR_MAP.put(ZKLR_WLR, "未录入");
		ZKLR_MAP.put(ZKLR_BFLR, "部分录入");
		ZKLR_MAP.put(ZKLR_LRCG, "录入成功");
		ZKLR_MAP.put(ZKLR_CFJL, "重复记录");
	}
	
	
}
