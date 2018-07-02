package com.springmvc.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.model.addcontent.ResponseData;

public class Test {
	
	/*static Reader reader;
	 static{
		 try {
			reader=Resources.getResourceAsReader("conf/sendJson.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }*/
	
	public static void main(String[] args) {
		try {
			Reader reader=Resources.getResourceAsReader("conf/sendJson.txt");
			int i=0;
			String str="";
			while((i=reader.read())!=-1){
				str+=(char)i;
			}
			System.out.println(str);
			JSONObject json = JSONObject.parseObject(str);
			JSONObject metadata = JSONObject.parseObject(json.get("metadata").toString());
			parseMetadata(metadata);
			//metadata.fluentPut(key, value);
			//json=json.fluentPut("clusterName", 123);
			System.out.println(json.get("metadata").toString());
			//String httpUrl="http://localhost:8080/mysqlDocker/sendInfo/contentList.do";
			//String jsonParam=json.toJSONString();
			//ResponseData returnObj = HttpClientUtil.sendHttpPost(httpUrl, jsonParam);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static String parseMetadata(JSONObject metadata){
		
		return null;
		
	}

}
