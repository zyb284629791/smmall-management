package com.yancey.smmall.management.common.response;

public enum HttpResponseEnum {

	SUCCESS(200, "服务端保存成功！"), 

	 /**
	  *  账户不存在
	 */
	ACCOUNT_NOT_FOUND(-1, "账户不存在"),
	
	/**
	 * 账户密码错误
	 */
	ACCOUNT_PASSWORD_ERROR(-1, "账户密码错误"),
	
	/**
	 * 网络繁忙,请稍后重试
	 */
	NETWORK_ERROR(-1, "网络繁忙,请稍后重试"),
	
	/**
	 * 系统错误,请联系管理员
	 */
	SYSTEM_ERROR(-1, "系统错误,请联系管理员"),
	
	/**
	 * {0}数据没找到
	 */
	DATA_NOT_FOUND(-1, "{0}数据没找到"),

	
	/**
	 * 参数错误
	 */
	PARAMETERS_ERROR(-1,"参数错误"),
	
	/**
	 * 参数缺失,{0}不允许为空
	 */
	PARAMETERS_MISSING(-1, "参数缺失,{0}不允许为空"),
	
	/**
	 * 必填参数缺失
	 */
	REQUIRED_PARAMETERS_MISSING(-1, "必填参数缺失"),
	
	/**
	 * 参数非法
	 */
	ILLEGAL_PARAMETERS(-1, "参数非法"),
	
	/**
	 * 数据已存在
	 */
	DATA_EXISTING(-1, "数据已存在"),
	
	/**
	 * 无权访问
	 */
	NO_DATA_ACCESS(-1, "无数据访问权限"),
	
	/**
	 * 系统默认参数,无权限更改更改
	 */
	SYSTEM_DEFAULT_PARAMS(-1, "系统默认参数,无权限更改更改"),
	
	/**
	 * 客户端请求频繁,请稍后重试
	 */
	CLIENT_REQUEST_VISIT_FREQUENTLY(-1, "请求频繁,请稍后重试"),

	ORDER_ID_EMPTY(1, "orderId不能为空！"),

	/**
	 *  司机端 - 登录/注册 - start
	 */
	/**
	 * 参数格式错误
	 */
	DRIVER_DATA_FORMAT_ERROR(30100, "参数格式错误"),
	/**
	 * token失效，请重新登陆
	 */
	DRIVER_MOBILE_LOGIN_101(30101, "验证失败，请重新登陆"),
	/**
	 * 账号已在别处登录
	 */
	DRIVER_MOBILE_LOGIN_102(30102, "您的账号已在别处登录"),
	/**
	 * 账号已在别处登录
	 */
	DRIVER_SEND_VALIDATE_CODE_FAIL(30103, "登录验证码发送失败"),
	/**
	 * 验证码过期
	 */
	DRIVER_VALIDATE_CODE_OUT_OF_DATE(30104, "验证码过期"),
	/**
	 * 验证码错误
	 */
	DRIVER_VALIDATE_CODE_ERROR(30105, "验证码错误"),
	/**
	 * 司机登录失败
	 */
	DRIVER_LOGIN_FAIL(30106, "司机登录失败"),
	/**
	 * 司机退出失败
	 */
	DRIVER_LOGOUT_FAIL(30107, "司机退出失败"),
	/**
	 * 保存登录日志失败
	 */
	DRIVER_SAVE_LOGIN_LOG_FAIL(30107, "保存登录日志失败"),
	/**
	 * 保存车辆信息失败
	 */
	DRIVER_SAVE_PERSONAL_INFO_FAIL(30108, "保存车辆信息失败"),
	/**
	 * 保存车辆信息失败
	 */
	DRIVER_SAVE_VEHICLE_INFO_FAIL(30109, "保存车辆信息失败"),
	/**
	 * 保存结算账号信息失败
	 */
	DRIVER_SAVE_BANK_INFO_FAIL(301010, "保存结算账号信息失败"),
	/**
	 * 司机数据未找到
	 */
	DRIVER_DATA_NOT_FOUND(301011, "司机数据未找到"),
	/**
	 * 更新设备信息失败
	 */
	DRIVER_UPDATE_DEVICE_INFO_FAIL(301012, "更新设备信息失败"),

	/**
	 *  司机端 - 登录/注册 - end
	 */


	/**
	 * 会话超时
	 */
	SESSION_TIME_OUT(-1, "会话超时"),
	OPERATION_SUCCESS(0, "操作成功"),
	AUTHENTICATION_NAME_ERROR(-2,"身份验证-名字错误"),
	AUTHENTICATION_ID_ERROR(-3,"身份验证-身份证错误");
	 

	public Integer code;

	public String message;
	
	/***
	 * 中控端编码10000
	 * 乘客端 编码20000
	 * 司机端编码30000
	 * ERP编码40000
	 * 钱包编码50000
	 * **/

	private HttpResponseEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static HttpResponseEnum getCode(int code) {
		for (HttpResponseEnum httpResponseEnum : values()) {
			if (httpResponseEnum.getCode() == code) {
				return httpResponseEnum;
			}
		}
		throw new RuntimeException("没有找到对应的枚举");
	}
}
