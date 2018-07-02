package com.springmvc.util;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class Result {
	private String msg;
	private boolean result;
	private int errCode;//0失败，1成功
	private List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
}
