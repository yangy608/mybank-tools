package org.framework.httpclient;


/**
 * 常量类
 * @author yangy
 * @date   2012-05-23
 */
@SuppressWarnings("serial")
public class Constants {	
	
	//签名类型
	public static enum SIGN_TYPE{   
		MD5,DSA,RSA 
	} 
	
	//物流类型
	public static enum LOGISTICS_TYPE{   
		POST,    //平邮
		EMS,     //EMS
		EXPRESS  //其他快递
	}  
	
	//物流支付类型
	public static enum LOGISTICS_PAYMENT{   
		SELLER_PAY,    //卖家支付
		BUYER_PAY,      //买家支付
		BUYER_PAY_AFTER_RECEIVE //货到付款
	}
	
	//交易状态
	public static enum TRADE_STATUS{   
		WAIT_BUYER_PAY,  		 //等待买家付款
		WAIT_SELLER_SEND_GOODS,	 //买家已付款，等待卖家发货
		WAIT_BUYER_CONFIRM_GOODS,//卖家已发货，等待买家确认
		TRADE_FINISHED,			 //交易成功结束
		TRADE_CLOSED			 //交易中途关闭（已结束，未成功完成）
	}
	
	//退款状态
	public static enum refund_STATUS{   
		WAIT_SELLER_AGREE, 			//退款协议等待卖家确认中
		SELLER_REFUSE_BUYER,    	//卖家不同意协议，等待买家修改
		WAIT_BUYER_RETURN_GOODS,    //退款协议达成，等待买家退货
		WAIT_SELLER_CONFIRM_GOODS,  //等待卖家收货
		REFUND_SUCCESS, 			//退款成功
		REFUND_CLOSED 				//退款关闭
	}
	
	//标准支付宝交易错误代码
	public static enum ERROR_CODE{   
		ILLEGAL_PAYMENT_TYPE, 			//非法的支付类型
		ILLEGAL_FEE_PARAM,				//金额参数传递混乱
		PRODUCT_NOT_EXIST,				//产品类型不存在
		EXPARTNER_INFO_UNCORRECT,		//传入商户接口信息不正确
		TRADE_DATA_MATCH_ERROR,			//交易信息真实性有误
		LOGISTICS_CHOOSE_ERROR,			//物流信息真实性错误
		ILLEGAL_REQUEST,				//无效请求
		SELLER_NOT_EXIST,				//交易卖家不存在
		SELLER_NOT_IN_SPECIFIED_SELLERS,//卖家不在指定的商户限制卖家中
		SELF_TIMEOUT_NOT_SUPPORT,		//商户和支付宝未签署支付超时协议
		TRADE_BUYER_NOT_MATCH,			//输入的买家与交易买家不匹配
		TRADE_SELLER_NOT_MATCH,			//输入的卖家与交易卖家不匹配
		TOTAL_FEE_LESSEQUAL_ZERO,		 //交易总额小于等于0
		MAX_MONEY_COMPANY_TO_INDIVIDUAL, //公司账户给个人账户付款，单笔金额不得大于5万元
		EXTERFACE_INVOKE_CONTEXT_EXPIRED,//外部接口调用上下文过期
		ILLEGAL_LOGISTICS_FORMAT,		 //物流信息定义错误
		
		ILLEGAL_SIGN,				//签名不正确
		ILLEGAL_DYN_MD5_KEY,		//动态密钥信息错误
		ILLEGAL_ENCRYPT,			//加密不正确
		ILLEGAL_ARGUMENT,			//参数不正确
		ILLEGAL_SERVICE,			//参数不正确
		ILLEGAL_USER,				//用户ID不正确
		ILLEGAL_PARTNER,			//合作伙伴ID不正确
		ILLEGAL_EXTERFACE,			//接口配置不正确
		ILLEGAL_PARTNER_EXTERFACE,	//合作伙伴接口信息不正确
		ILLEGAL_SECURITY_PROFILE,	//未找到匹配的密钥配置
		ILLEGAL_AGENT,				//代理ID不正确
		ILLEGAL_SIGN_TYPE,			//签名类型不正确
		HAS_NO_PRIVILEGE,			//无权访问
		SYSTEM_ERROR,				//支付宝系统错误
		SESSION_TIMEOUT,			//session超时
		ILLEGAL_REQUEST_REFERER,	//防钓鱼检查不支持该请求来源
		ILLEGAL_ANTI_PHISHING_KEY,	//防钓鱼检查非法时间戳参数
		ANTI_PHISHING_KEY_TIMEOUT,	//防钓鱼检查时间戳超时
		ILLEGAL_EXTER_INVOKE_IP,	//防钓鱼检查非法外部调用IP
		ILLEGAL_ACCESS_SWITCH_SYSTEM//partner不允许访问该类型的系统
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public enum Color {   
	    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);   
	    // 成员变量   
	    private String name;   
	    private int index;   
	    // 构造方法   
	    private Color(String name, int index) {   
	        this.name = name;   
	        this.index = index;   
	    }   
	    // 普通方法   
	    public static String getName(int index) {   
	        for (Color c : Color.values()) {   
	            if (c.getIndex() == index) {   
	                return c.name;   
	            }   
	        }   
	        return null;   
	    }   
	    // get set 方法   
	    public String getName() {   
	        return name;   
	    }   
	    public void setName(String name) {   
	        this.name = name;   
	    }   
	    public int getIndex() {   
	        return index;   
	    }   
	    public void setIndex(int index) {   
	        this.index = index;   
	    }   
	}  

	



}
