package com.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.model.DockerInfo;
import com.springmvc.model.addcontent.CharacterSet;
import com.springmvc.model.addcontent.DbaManager;
import com.springmvc.model.addcontent.DepartManager;
import com.springmvc.model.addcontent.MysqlVersion;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.ResponseData;
import com.springmvc.model.addcontent.Site;
import com.springmvc.service.CommonService;
import com.springmvc.util.HttpClientUtil;
import com.springmvc.util.JacksonUtil;
import com.springmvc.util.Result;

@Controller
@RequestMapping("/managerInfo")
public class ManagerInfo {
	public static Logger log = Logger.getLogger(ManagerInfo.class);
	@Autowired
	private CommonService manaService;
	private Result result=new Result();
	
	
	
	
	@RequestMapping("/addMysqlVersion")
	@ResponseBody
	public Result addMysqlVersion(HttpServletRequest request,HttpServletResponse response){
		String data=request.getParameter("data");
		try {
			MysqlVersion info=JacksonUtil.readValue(data, MysqlVersion.class);
			int saveResault=manaService.addMysql(info);
			if(saveResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping("/addCharSet")
	@ResponseBody
	public Result addCharSet(HttpServletRequest request,HttpServletResponse response){
		
		String data=request.getParameter("data");
		try {
			CharacterSet info=JacksonUtil.readValue(data, CharacterSet.class);
			int saveResault=manaService.addCharSet(info);
			if(saveResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("/addDbaManager")
	@ResponseBody
	public Result addDbaManager(HttpServletRequest request,HttpServletResponse response){
		
		String data=request.getParameter("data");
		try {
			DbaManager info=JacksonUtil.readValue(data, DbaManager.class);
			int saveResault=manaService.addDbaPerson(info);
			if(saveResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		
		return result;
	}
	@RequestMapping("/addSiteInfo")
	@ResponseBody
	public Result addSiteInfo(HttpServletRequest request,HttpServletResponse response){
		
		String data=request.getParameter("data");
		try {
			Site info=JacksonUtil.readValue(data, Site.class);
			int saveResault=manaService.addSiteInfo(info);
			if(saveResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("/addPartManager")
	@ResponseBody
	public Result addPartManager(HttpServletRequest request,HttpServletResponse response){
		
		String data=request.getParameter("data");
		try {
			DepartManager info=JacksonUtil.readValue(data, DepartManager.class);
			int saveResault=manaService.addPartManager(info);
			if(saveResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("/addColony")
	@ResponseBody
	public Result addColony(HttpServletRequest request,HttpServletResponse response){
		
		String data=request.getParameter("data");
		try {
			NetworkSite info=JacksonUtil.readValue(data, NetworkSite.class);
			/*String httpUrl="http://84.10.100.117:8181/networks";
			String jsonParam = this.getJsonParam(data);
			ResponseData networkPost = HttpClientUtil.sendHttpPost(httpUrl, jsonParam);
			
			
			if(networkPost.getStatus()==HttpStatus.SC_CREATED){
				int saveResault=manaService.addColony(info);
				if(saveResault>0&&networkPost.getStatus()==HttpStatus.SC_CREATED){
					result.setErrCode(1);
				}else{
					result.setErrCode(0);
				}
			}*/
			int saveResault=manaService.addColony(info);
			if(saveResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
			
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			result.setErrCode(0);
		}
		
		return result;
	}
	
	@RequestMapping("/deleteInfo")
	@ResponseBody
	public Result deleteInfo(HttpServletRequest request,HttpServletResponse response){
		
		String data=request.getParameter("data");
		String flag=request.getParameter("flag");
		try {
			int deleteResault=deleteData(flag,data);
			if(deleteResault>0){
				result.setErrCode(1);
			}else{
				result.setErrCode(0);
			}
		} catch (JsonParseException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (IOException e) {
			result.setErrCode(0);
			e.printStackTrace();
		} catch (Exception e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		
		return result;
	}
	
	private   int deleteData(String flag,String data) throws Exception{
		int returnValue=0;
		if("1".equals(flag)){
			MysqlVersion info=JacksonUtil.readValue(data, MysqlVersion.class);
			returnValue=manaService.deleteMysqlInfo(info);
		}else if("2".equals(flag)){
			CharacterSet info=JacksonUtil.readValue(data, CharacterSet.class);
			returnValue=manaService.deleteCharInfo(info);
		}else if("3".equals(flag)){
			DbaManager info=JacksonUtil.readValue(data, DbaManager.class);
			returnValue=manaService.deleteDbaInfo(info);
		}else if("4".equals(flag)){
			DepartManager info=JacksonUtil.readValue(data, DepartManager.class);
			returnValue=manaService.deleteDepartInfo(info);
		}else if("5".equals(flag)){
			Site info=JacksonUtil.readValue(data, Site.class);
			returnValue=manaService.deleteSiteInfo(info);
		}else if("6".equals(flag)){
			NetworkSite info=JacksonUtil.readValue(data, NetworkSite.class);
			/*String httpUrl="http://84.10.100.117:8181/networks/"+info.getSite();
			ResponseData returnObj = HttpClientUtil.sendHttpDelete(httpUrl);
			if(returnObj.getStatus()==204) {
				returnValue=manaService.deleteNetworkSite(info);
			}*/
			returnValue=manaService.deleteNetworkSite(info);
			
		}
		
		return returnValue;
	}
	private String getJsonParam(String data){
		
		JSONObject json = JSONObject.parseObject(data);
		StringBuffer buff=new StringBuffer();
		buff.append("{");
		buff.append("\"name\":");
		buff.append("\""+json.get("site")+"\",");
		buff.append("\"startIP\":");
		buff.append("\""+json.get("startIp")+"\",");
		buff.append("\"endIP\":");
		buff.append("\""+json.get("endIp")+"\",");
		buff.append("\"route\":");
		buff.append("\""+json.get("route")+"\",");
		buff.append("\"mask\":");
		buff.append(json.get("mask")+",");
		buff.append("\"vlan\":");
		buff.append(json.get("vlan"));
        buff.append("}");
		
		return buff.toString();
		
	}
	
	

}
