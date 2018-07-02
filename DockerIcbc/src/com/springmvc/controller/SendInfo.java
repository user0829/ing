package com.springmvc.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.model.DockerInfo;
import com.springmvc.model.addcontent.Site;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.ResponseData;
import com.springmvc.service.CommonService;
import com.springmvc.service.InfoService;
import com.springmvc.util.HttpClientUtil;
import com.springmvc.util.JacksonUtil;
import com.springmvc.util.Result;



@Controller
@RequestMapping("/sendInfo")
public class SendInfo {
	 public static Logger log = Logger.getLogger(SendInfo.class); 

	@Autowired
	private InfoService infoService;
	/*@Autowired
	private CharacterService charService;*/
	@Autowired
	private CommonService comService;
	
	private Result result=new Result();
	
	@RequestMapping("/index")
	public String getIndex(HttpServletRequest request,HttpServletResponse response){
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);
		
		return "index";
	}
	@RequestMapping("/addConfig")
	public String getAddConfig(HttpServletRequest request,HttpServletResponse response){
		List charList=comService.selectChar();
		request.setAttribute("charSet", charList);
		List mysqlList=comService.seletMysql();
		request.setAttribute("mysqlList", mysqlList);
		List indexList=comService.selectPerformance();
		request.setAttribute("indexList", indexList);
		List osList=comService.selectOsVersion();
		request.setAttribute("osList", osList);
		List siteList = comService.selectSiteCluster();
		request.setAttribute("listSite", siteList);
		return "addConfig";
	}
	@RequestMapping("/contentList")
	public String getDisplayContent(HttpServletRequest request,HttpServletResponse response){
		List listContent=null;
		List returnList=null;
		try {
			listContent=infoService.selectInfo();
			
			/*String httpUrl="http://84.10.100.117:8181/pods";
			ResponseData returnObj = HttpClientUtil.sendHttpGet(httpUrl);
			if(returnObj.getReturnData().length()>0) {
				JSONArray returnArray = JSONObject.parseArray(returnObj.getReturnData());
				//将返回数据与本地数据进行组装
				returnList = this.processArray(returnArray,listContent);
			}*/
			returnList=listContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listContent", returnList);
		return "contentList";
		
		
	}
	
	@RequestMapping("/dbaManagerment")
	public String getdbaManagerment(HttpServletRequest request,HttpServletResponse response){
		List listMysql=comService.seletMysql();
		request.setAttribute("listMysql", listMysql);
		List listChar = comService.selectChar();
		request.setAttribute("listChar", listChar);
		List listDba = comService.selectDbaManager();
		request.setAttribute("listDba", listDba);
		List listPart = comService.selectDpartManager();
		request.setAttribute("listPart", listPart);
		List listSite = comService.selectSiteCluster();
		request.setAttribute("listSite", listSite);
		List listNetwork = comService.selectSiteNetwork();
		request.setAttribute("listNetwork", listNetwork);
		
		
		return "dbaCon";
	}
	
	@RequestMapping("/logout")
	public String getLogout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		session.setAttribute("name", "");
		session.setAttribute("pass", "");
		return "login";
	}
	
	
	

	@RequestMapping("/getInfo")
	@ResponseBody
	public Result getResult(HttpServletRequest request,HttpServletResponse response){
		String content="{\"systemName\":\"password\",\"site\":\"dahetao\",\"subSystem\":\"dahetao\",\"subSystemCode\":\"dahetao\",\"disasterLevel\":\"dahetao\",\"deployment\":\"dahetao\""
				+ ",\"performanceNeed\":\"dahetao\",\"instances\":123,\"mysqlVersion\":\"dahetao\",\"portNum\":123,\"characterSet\":\"dahetao\",\"networkSection\":\"dahetao\",\"osVersion\":\"dahetao\",\"dataVolume\":123"
				+ ",\"logVolume\":\"asd\",\"tempVolume\":123,\"backupVolume\":123,\"databaseDomainName\":\"dahetao\",\"createrId\":\"dahetao\",\"createTime\":\"dahetao\",\"mysqlVersion\":\"dahetao\",\"backupTiming\":\"dahetao\"}";
		int resultValue=0;
		String data=request.getParameter("data");
		try {
			
			DockerInfo info=JacksonUtil.readValue(data, DockerInfo.class);
			/*String httpUrl="http://84.10.100.117:8181/pods";
			String jsonParam=getJsonString(data);
			ResponseData returnObj = HttpClientUtil.sendHttpPost(httpUrl, jsonParam);
			if(returnObj.getStatus()==500){
				result.setErrCode(0);
				return result;
			}
			if(returnObj.getStatus()==201) {
				resultValue=infoService.insertInfo(info);	
				if(resultValue>0){
					result.setErrCode(1);	
				}
			}*/
			
			resultValue=infoService.insertInfo(info);	
			if(resultValue>0){
				result.setErrCode(1);	
			}
			
			
		} catch (JsonParseException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			result.setErrCode(0);
		} catch (JsonMappingException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			result.setErrCode(0);
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			result.setErrCode(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	@RequestMapping("/selectSegment")
	@ResponseBody
	public Result getSelectSegment(HttpServletRequest request,HttpServletResponse response){
		String data=request.getParameter("data");
		try {
			NetworkSite info=JacksonUtil.readValue(data, NetworkSite.class);
			List listSeg = infoService.selectSegment(info);
			if(listSeg.size()>0){
				result.setList(listSeg);
				result.setErrCode(1);
			}

			
		} catch (JsonParseException e) {
			e.printStackTrace();
			result.setErrCode(0);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			result.setErrCode(0);
		} catch (IOException e) {
			e.printStackTrace();
			result.setErrCode(0);
		}
		return result;
	}
	
	
	@RequestMapping("/deletePod")
	@ResponseBody
	public Result deletePod(HttpServletRequest request,HttpServletResponse response){
		String subSystemCode=request.getParameter("subSystemCode");
		try {
			
			/*String httpUrl="http://84.10.100.117:8181/pods/"+subSystemCode;
			ResponseData returnObj = HttpClientUtil.sendHttpDelete(httpUrl);
			if(returnObj.getStatus()==204) {
				int returnValue = infoService.deletePod(subSystemCode);
				if(returnValue>0) {
					result.setErrCode(1);
				}
			}*/
			
			int returnValue = infoService.deletePod(subSystemCode);
			if(returnValue>0) {
				result.setErrCode(1);
			}

			
		} catch (Exception e) {
			result.setErrCode(0);
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	

	private String getJsonString(String data){
		
		JSONObject strData=JSONObject.parseObject(data);
		//System.out.println(strJson);
		String strJson="";
		Reader reader=null;
		try {
			reader=Resources.getResourceAsReader("conf/sendJson.txt");
			int i=0;
			while((i=reader.read())!=-1){
				strJson+=(char)i;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		JSONObject json = JSONObject.parseObject(strJson);
		//json.fluentPut("clusterName", 123);
		//处理metadata数据
		JSONObject metadata = JSONObject.parseObject(json.get("metadata").toString());
		String strMetadata=this.parseMetadata(metadata,strData);
		json=json.fluentPut("metadata", JSONObject.parseObject(strMetadata));
		//处理spec
		JSONObject spec = JSONObject.parseObject(json.get("spec").toString());
		String strSpec=this.parseSpec(spec,strData);
		json=json.fluentPut("spec", JSONObject.parseObject(strSpec));
		strJson=json.toString();
		System.out.println(strJson);
		return strJson;
		
	}
	
	private String parseMetadata(JSONObject metadata,JSONObject strData){
		
		metadata=metadata.fluentPut("name", strData.get("subSystemCode").toString());
		JSONObject labels = JSONObject.parseObject(metadata.get("labels").toString());
		labels=labels.fluentPut("network", strData.get("site").toString());
		metadata=metadata.fluentPut("labels", JSONObject.parseObject(labels.toString()));
		
		return metadata.toString();
		
	}
	
	private String parseSpec(JSONObject spec,JSONObject strData){
		String str=strData.get("performanceNeed").toString();
		String[] strArray = str.split("-");
		//获取volumes
		JSONArray volumesSplit=JSONObject.parseArray(spec.get("volumes").toString());
		String[] arrayStr= {"data","log","tmp","backup"};
		for (int i = 0; i < volumesSplit.size(); i++) {
			JSONObject volume = JSONObject.parseObject(volumesSplit.get(i).toString());
			String name = volume.get("name").toString();
			for (int j = 0; j < arrayStr.length; j++) {
				String strIndex=arrayStr[j];
				if(strIndex.equals(name)) {
					JSONObject hostPath = JSONObject.parseObject(volume.get("hostPath").toString());
					System.out.println(strData.get("subSystemCode").toString());
					String replacePath=hostPath.get("path").toString().replace("test", strData.get("subSystemCode").toString());
					hostPath=hostPath.fluentPut("path", replacePath);
					volume.fluentPut("hostPath", hostPath);
					volumesSplit.set(i,volume );
				}
			}
			
		}
		spec=spec.fluentPut("volumes", volumesSplit);
		
		//获取containers
		JSONArray containersSplit=JSONObject.parseArray(spec.get("containers").toString());
		/*for (int i = 0; i < containersSplit.size(); i++) {
			System.out.println(containersSplit.get(i).toString());
		}*/
		JSONObject name = JSONObject.parseObject(containersSplit.get(0).toString());
		System.out.println(name.get("name"));
		name=name.fluentPut("name", strData.get("subSystemCode").toString());
		containersSplit.set(0, name);
		
		//spec=spec.fluentPut("containers", containersSplit.toString());
		JSONObject resources = JSONObject.parseObject(containersSplit.get(0).toString());
		JSONObject res = JSONObject.parseObject(resources.get("resources").toString());
		JSONObject limits = JSONObject.parseObject(res.get("limits").toString());

		limits=limits.fluentPut("cpu", strArray[0].charAt(0));
		limits=limits.fluentPut("memory", strArray[1]+"i");
		
		res=res.fluentPut("limits", JSONObject.parseObject(limits.toString()));
		JSONObject requests = JSONObject.parseObject(res.get("requests").toString());
		requests=requests.fluentPut("cpu", strArray[0].charAt(0));
		requests=requests.fluentPut("memory", strArray[1]+"i");
		res=res.fluentPut("requests", JSONObject.parseObject(requests.toString()));
		resources=resources.fluentPut("resources", res);
		containersSplit.set(0, resources);
		/*System.out.println("["+containersSplit.get(0).toString()+"]");*/
		spec=spec.fluentPut("containers", containersSplit);
		
		return spec.toString();
	}
	
	private List processArray(JSONArray returnArray,List localList) {
		
		for (int i = 0; i < returnArray.size(); i++) {
			JSONObject obj = JSONObject.parseObject(returnArray.get(i).toString());
			JSONObject metadata = JSONObject.parseObject(obj.get("metadata").toString());
			String name = metadata.get("name").toString();
			JSONObject status = JSONObject.parseObject(obj.get("status").toString());
			String hostIp = status.get("hostIP").toString();
			String podIp = status.get("podIP").toString();
			String startTime = status.get("startTime").toString();
			String containerStatuses = status.get("containerStatuses").toString();
			JSONArray containerStatusesArray = JSONObject.parseArray(containerStatuses);
			JSONObject getContainerValue = JSONObject.parseObject(containerStatusesArray.get(0).toString());
			String containerId = getContainerValue.get("containerID").toString();
			for (int j = 0; j < localList.size(); j++) {
				DockerInfo docker=(DockerInfo)localList.get(j);
				if(name.equals(docker.getSubSystemCode())) {
					docker.setHostIp(hostIp);
					docker.setPodIp(podIp);
					docker.setStartTime(startTime);
					docker.setContainerId(containerId);
					localList.set(j, docker);
				}
			}
			
		}
		
		return localList;
		
	}

	
	

}

