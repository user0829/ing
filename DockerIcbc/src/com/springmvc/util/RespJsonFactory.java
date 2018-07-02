package com.springmvc.util;


import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.model.addcontent.ResponseData;

public class  RespJsonFactory {
	
	
	private static ResponseData res=new ResponseData();
	public static ResponseData buildCreated(String obj){
		res.setReturnData(obj);
		return res;
	}
	
	public static ResponseData build(int status,String content){
		res.setStatus(status);
		res.setErrString(content);
		return res;
	}
}
