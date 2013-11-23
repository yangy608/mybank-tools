package org.framework.common;

import java.util.HashMap;
import java.util.Map;

public class MapConstant {
	
	/**
	 * 返回内部交易类型map
	 * @return
	 */
	public static Map<String, String> getInnerTradeTypeMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("9100", "下发文件生成");
		map.put("9002", "充值可疑调整");
		map.put("8135", "签约查询");
		map.put("8125", "签约解除");
		map.put("8115", "签约(已开户)");
		map.put("8105", "签约开户(申请)");
		map.put("7435", "账户验证");
		map.put("7425", "账户充值验证");
		map.put("7415", "设置客户卡信息");
		map.put("7405", "设置账户信息");
		map.put("7305", "获取账户信息");
		map.put("7205", "卡挂失");
		map.put("7105", "账户密码修改重置");
		map.put("7045", "联机账户主卡变更");
		map.put("7035", "联机账户解除绑定");
		map.put("7025", "联机账户绑定(一次绑定)");
		map.put("7015", "联机账户注销");
		map.put("7005", "联机账户开通(一次开户)");
		map.put("5655", "开户返款(未)");
		map.put("5555", "充值返款");
		map.put("5425", "账户充值确认");
		map.put("5205", "账户交易调整(余额减少)");
		map.put("5105", "账户退货");
		map.put("5015", "优惠券发放");
		map.put("5010", "优惠券激活");
		map.put("3605", "运费撤销/冲正");
		map.put("3350", "启用卡初始化入库");
		map.put("3205", "积分消费撤销");
		map.put("3105", "普通消费撤销");
		map.put("3035", "账户订购预授权撤销");
		map.put("2105", "普通消费冲正");
		map.put("2063", "非预充值卡售卡");
		map.put("2062", "电子现金充值");
		map.put("2061", "卡操作的授权请求");
		map.put("2035", "订购预授权冲正");
		map.put("1605", "账户运费授权");
		map.put("1435", "代收充值");
		map.put("1425", "账户充值");
		map.put("1205", "积分消费");
		map.put("1200", "积分产生");
		map.put("1105", "普通消费");
		map.put("1047", "账户订购预授权扣款");
		map.put("1045", "账户订购预授权完成");
		map.put("1035", "账户订购预授权");
		map.put("1025", "账户余额查询");
		return map;
	}
	/**
	 * 返回外部交易类型map
	 * @return
	 */
	public static Map<String, String> getOuterTradeTypeMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("9102", "转账付款");
		map.put("9101", "商户提现");
		map.put("9100", "下发文件生成");
		map.put("9012", "代扣缴费");
		map.put("9010", "影视续费");
		map.put("9009", "游戏充值");
		map.put("9008", "门票预订");
		map.put("9007", "酒店预订");
		map.put("9006", "商户注册");
		map.put("9005", "固话充值");
		map.put("9004", "信用卡还款");
		map.put("9013", "机票预订");
		map.put("9003", "机票预订");
		map.put("9002", "充值可疑调整");
		map.put("9001", "手机充值");
		map.put("8135", "签约查询");
		map.put("8125", "签约解除");
		map.put("8115", "签约(已开户)");
		map.put("8105", "签约开户(申请)");
		map.put("7435", "账户验证");
		map.put("7425", " 账户充值验证");
		map.put("7415", "设置客户卡信息");
		map.put("7405", " 设置账户信息");
		map.put("7305", " 获取账户信息");
		map.put("7225", "卡解挂失");
		map.put("7215", "卡挂失");
		map.put("7135", "账户密码重置");
		map.put("7125", "账户密码修改(交易PIN)");
		map.put("7115", "账户密码修改(查询PIN)");
		map.put("7045", "联机账户主卡变更");
		map.put("7035", " 联机账户解除绑定");
		map.put("7025", " 联机账户绑定(一次绑定)");
		map.put("7015", " 联机账户注销");
		map.put("7005", " 联机账户开通(一次开户)");
		map.put("5658", "充值返款(未)");
		map.put("5657", "账户绑定返款(未)");
		map.put("5656", "开户返款(未)");
		map.put("5559", " 充值返还优惠劵");
		map.put("5558", "充值返款");
		map.put("5557", "账户绑定返款");
		map.put("5556", "开户返款");
		map.put("5555", "充值返款");
		map.put("5225", "账户交易调整(余额减少)");
		map.put("5215", "账户交易调整(余额增加)");
		map.put("5105", " 账户退货");
		map.put("5015", "优惠券发放");
		map.put("5012", "优惠券激活(绑定)");
		map.put("5011", "优惠券激活(开户)");
		map.put("5010", "优惠券激活");
		map.put("3351", " 启用卡初始化入库");
		map.put("3350", " 未启用卡初始化入库");
		map.put("3105", "普通消费撤销");
		map.put("3035", " 账户订购预授权撤销");
		map.put("2105", " 账户消费冲正");
		map.put("2063", " 非预充值卡售卡");
		map.put("2062", " 电子现金充值");
		map.put("2061", " 卡操作的授权请求");
		map.put("2035", "账户订购预授权冲正");
		map.put("1435", "代收充值");
		map.put("1425", " 账户充值");
		map.put("1105", " 普通消费");
		map.put("1047", " 账户订购预授权扣款");
		map.put("1045", " 账户订购预授权完成");
		map.put("1035", " 账户订购预授权");
		map.put("1025", " 账户余额查询");
		return map;
	}
	
	/**
	 * 订单状态
	 * @return
	 */
	public static Map<String, String> getOrderStateMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("9", "已撤销");
		map.put("3", "失败");
		map.put("2", "已扣款");
		map.put("1", "待处理");
		map.put("0", "成功");
		return map;
	}
	/**
	 * 借贷标识
	 * @return
	 */
	public static Map<String, String> getDebtOrCredIdMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("D", "借");
		map.put("C", "贷");
		map.put("-", "无借贷");
		return map;
	}
	/**
	 * 受理渠道map
	 */
	public static Map<String, String> getAcceptChannelMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("20", "中心系统");
		map.put("11", "无线销售点终端");
		map.put("09", "固定电话");
		map.put("08", "手机设备");
		map.put("07", "个人电脑(互联网)");
		map.put("06", "银行柜台和柜面");
		map.put("03", "有线销售点终端");
		map.put("01", "自动柜员机");
		return map;
	}
	/**
	 * 应答码map
	 */
	public static Map<String, String> getResponseCodeMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("N", "无运费");
		map.put("EE00", "额外错误");
		map.put("A700", "安全处理失败");
		map.put("A100", "MAC1");
		map.put("A000", "MAC校验错");
		map.put("9900", "PIN格式错");
		map.put("9800", "操作员无效");
		map.put("9700", "终端号找不到");
		map.put("9600", "系统异常、失败");
		map.put("9400", "重复交易");
		map.put("9100", "发卡方不能操作");
		map.put("8800", "账户已启用");
		map.put("7700", "需要向网络中心签到");
		map.put("7500", "允许的输入PIN次数超限");
		map.put("6G00", "积分余额不足");
		map.put("6F00", "积分账户过期");
		map.put("6D00", "原扣款类交易已产生积分");
		map.put("6C00", "积分规则不合法");
		map.put("6B00", "积分产生规则未找到");
		map.put("6A00", "积分账户不存在");
		map.put("6800", "收到的回答太迟");
		map.put("6500", "超出取款/消费次数限制");
		map.put("6400", "原始金额不正确");
		map.put("6200", "受限制的卡");
		map.put("6100", "超出消费金额限制");
		map.put("5900", "有作弊嫌疑");
		map.put("5700", "不允许持卡人进行的交易");
		map.put("5500", "不正确的PIN");
		map.put("5400", "过期的卡");
		map.put("5200", "预授权完成金额大于预授权金额");
		map.put("5100", "资金不足");
		map.put("4100", "挂失卡");
		map.put("4000", "请求的功能尚不支持");
		map.put("3F00", "账户余额与可用余额不符");
		map.put("3E00", "账户余额不为0");
		map.put("3D00", "附卡未与主卡绑定");
		map.put("3C00", "联机账户不存在");
		map.put("3B00", "附卡不允许该交易");
		map.put("3A00", "主卡不允许该交易");
		map.put("3800", "超过允许的PIN试输入");
		map.put("3700", "账户余额密文校验错");
		map.put("3000", "报文格式错误");
		map.put("2B00", "日交易交易金额上限");
		map.put("2A00", "单笔交易金额上限");
		map.put("2500", "找不到原始交易");
		map.put("2200", "关联交易错误");
		map.put("2100", "卡未初始化");
		map.put("1G00", "无效订单");
		map.put("1F00", "订单已撤销");
		map.put("1E00", "订单已完成");
		map.put("1D00", "未输入PIN");
		map.put("1C00", "重复订单");
		map.put("1B00", "重复绑定");
		map.put("1A00", "重复开户");
		map.put("1400", "无效卡号（无此账号）");
		map.put("1300", "无效金额");
		map.put("1200", "无效的关联交易");
		map.put("1", "积分支付");
		map.put("0500", "身份认证失败");
		map.put("0300", "无效商户");
		map.put("0000", "承兑或交易成功");
		map.put("0", "账户支付");
		return map;
	}
	
	/**
	 * 账户类型
	 * @return
	 */
	public static Map<String, String> getAcctTypeMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("00", "初始账户");
		return map;
	}
	/**
	 * 优惠券使用标识
	 * @return
	 */
	public static Map<String, String> getCouponsUsedFlagMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("S", "单行业");
		map.put("M", "商户");
		map.put("A", "全行业");
		return map;
	}
	/**
	 * 优惠券消费方式
	 * @return
	 */
	public static Map<String, String> getCouponsConumeWayMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("2", "交易金额百分比");
		map.put("1", "固定金额");
		return map;
	}
	
	/**
	 * 撤销标识
	 * @return
	 */
	public static Map<String, String> getCancelFlagMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Y", "已撤销");
		map.put("N", "未撤销");
		return map;
	}

	/**
	 * 退货标识
	 * @return
	 */
	public static Map<String, String> getReturnGoodFlagMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Y", "已退货");
		map.put("N", "未退货");
		return map;
	}
	
	/**
	 * 积分产生标识
	 * @return
	 */
	public static Map<String, String> getIntegralMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Y", "已产生");
		map.put("N", "未产生");
		map.put("D", "拒绝产生");
		return map;
	}
	
}
