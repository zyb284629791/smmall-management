package com.yancey.smmall.management.common.response;


public enum ExceptionEnums {
	
	
	ConversionNotSupportedException(-1,"服务器内部数字格式转换出错"),
	HttpMessageNotWritableException(-1,"服务器内部内错"),
	HttpMediaTypeNotSupportedException(-1,"不支持媒体格式"),
	HttpMediaTypeNotAcceptableException(-1,"不支持媒体格式"),
	HttpRequestMethodNotSupportedException(-1,"请求方式错误"),
	NoSuchRequestHandlingMethodException(-1,"请求路径错误"),
	TypeMismatchException(-1,"类型匹配异常"),
	HttpMessageNotReadableException(-1,"错误参数格式"),
	IllegalArgumentException(-1,"非法参数异常"),
	IllegalStateException(-1,"非法状态异常"),
	MaxUploadSizeExceededException(-1,"文件上传超过最大阀值"),
	MissingServletRequestParameterException(-1,"servlet请求参数错误"),
	SystemDealException(-1,"系统内部处理出错");
	
	
	
	private ExceptionEnums(Integer errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public Integer errCode;
	
    public String errMsg;

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

  

	

}
