package com.springmvc.model.addcontent;

public class ResponseData {
	
	private int status;//状态码
	private String errString;//错误信息
	private String returnData;//返回信息
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrString() {
		return errString;
	}
	public void setErrString(String errString) {
		this.errString = errString;
	}
	public String getReturnData() {
		return returnData;
	}
	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}


}
