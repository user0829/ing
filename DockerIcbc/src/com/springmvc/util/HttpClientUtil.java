package com.springmvc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.model.addcontent.ResponseData;

public class HttpClientUtil {
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_DELETE = "DELETE";

	/**
	 * log
	 */
/*	private static Logger logger = Logger.getLogger("HttpClientUtil");*/

	public static ResourceBundle resource = null;

	static {
		try {
			resource = ResourceBundle.getBundle("config/http-timeout");
		} catch (Exception e) {
		}
	}
	
	/**
	 * send GET requests
	 * 
	 * @param httpUrl
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	public static ResponseData sendHttpGet(String httpUrl) throws Exception  {
		return sendHttpGet(httpUrl, null, true);
	}

	/**
	 * send POST requests
	 * 
	 * @param httpUrl
	 * @param jsonParam
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	public static ResponseData sendHttpPost(String httpUrl, String jsonParam) throws Exception
			{
		return sendHttpPost(httpUrl, jsonParam, null, true);
	}
	
	/**
	 * send DELETE requests
	 * 
	 * @param httpUrl
	 * @param showLog
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	public static ResponseData sendHttpDelete(String httpUrl) throws Exception  {
		return sendHttpDelete(httpUrl, true);
	}
	
	/**
	 * send GET requests
	 * 
	 * @param httpUrl
	 * @param socketTimeout
	 * @param showLog
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	public static ResponseData sendHttpGet(String httpUrl, Integer socketTimeout, boolean showLog) throws Exception
			 {
		HttpGet httpGet = new HttpGet(httpUrl);
		return sendHttp(httpGet, socketTimeout, null, null, showLog);
	}
	
	/**
	 * send POST requests
	 * 
	 * @param httpUrl
	 * @param jsonParam
	 * @param socketTimeout
	 * @param showLog
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	public static ResponseData sendHttpPost(String httpUrl, String jsonParam, Integer socketTimeout, boolean showLog) throws Exception
			 {
		HttpPost httpPost = new HttpPost(httpUrl);
		if (jsonParam != null) {
			StringEntity stringEntity = new StringEntity(jsonParam, "UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
		}
		return sendHttp(httpPost, socketTimeout, null, null, showLog);
	}
	
	/**
	 * send DELETE requests
	 * 
	 * @param httpUrl
	 * @param showLog
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	public static ResponseData sendHttpDelete(String httpUrl, boolean showLog) throws Exception {
		HttpDelete httpDelete = new HttpDelete(httpUrl);
		return sendHttp(httpDelete, null, null, null, showLog);
	}
	
	
	/**
	 * sent HTTP requests
	 * 
	 * @param httpMethod
	 * @param socketTimeout
	 * @param connectTimeout
	 * @param connectionRequestTimeout
	 * @param showLog
	 * @return
	 * @throws Exception 
	 * @throws HttpConnectionException
	 * @throws HttpClientException
	 */
	private static ResponseData  sendHttp(Object httpMethod, Integer socketTimeout, Integer connectTimeout,
			Integer connectionRequestTimeout, boolean showLog) throws Exception  {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
/*
			Builder build = getBuilder(socketTimeout, connectTimeout, connectionRequestTimeout);
			RequestConfig requestConfig = build.build();*/

			//String random = PrimaryKeyUtils.getRandomCharAndNum(8);
			if (httpMethod instanceof HttpPut) {
				HttpPut httpPut = (HttpPut) httpMethod;
				//httpPut.setConfig(requestConfig);

				/*logger.info("(" + random"" + ")HTTP请求地址：" + httpPut.getURI().toString());
				logger.info("(" + random ""+ ")HTTP请求类型：" + httpPut.getMethod());*/
				System.out.println("HTTP请求地址：" + httpPut.getURI().toString());
				System.out.println("HTTP请求类型：" + httpPut.getMethod());
				String param = null;
				HttpEntity entity = httpPut.getEntity();
				if (entity != null) {
					param = ConvertStreamToString(entity.getContent());
				}
				/*logger.info("(" + random"" + ")HTTP请求参数：" + param);*/
				System.out.println("HTTP请求参数：" + param);
				response = httpClient.execute(httpPut);
			}else  if(httpMethod instanceof HttpGet) {
				HttpGet httpGet = (HttpGet) httpMethod;
				System.out.println("HTTP请求地址：" + httpGet.getURI().toString());
				System.out.println("HTTP请求类型：" + httpGet.getMethod());
				response = httpClient.execute(httpGet);
			} else if (httpMethod instanceof HttpPost) {
				HttpPost httpPost = (HttpPost) httpMethod;
				//httpPost.setConfig(requestConfig);

				/*logger.info("(" + random"" + ")HTTP请求地址：" + httpPost.getURI().toString());
				logger.info("(" + random"" + ")HTTP请求类型：" + httpPost.getMethod());*/
				System.out.println("HTTP请求地址：" + httpPost.getURI().toString());
				System.out.println("HTTP请求类型：" + httpPost.getMethod());
				
				String param = null;
				HttpEntity entity = httpPost.getEntity();
				if (entity != null) {
					param = ConvertStreamToString(entity.getContent());
				}
				//logger.info("(" + /*random*/ ""+ ")HTTP请求参数：" + param);
				System.out.println("HTTP请求参数：" + param);
				response = httpClient.execute(httpPost);
			} else if (httpMethod instanceof HttpDelete) {
				HttpDelete httpDelete = (HttpDelete) httpMethod;
/*
				logger.info("(" + random"" + ")HTTP请求地址" + httpDelete.getURI().toString());
				logger.info("(" + random ""+ ")HTTP请求参数" + httpDelete.getMethod())*/;
				System.out.println("HTTP请求地址: " + httpDelete.getURI().toString());
				System.out.println("HTTP请求参数" + httpDelete.getMethod());
				response = httpClient.execute(httpDelete);
			}

			int statusCode = response.getStatusLine().getStatusCode();
			if (showLog) {
				//logger.info("(" + /*random*/"" + ")HTTP请求状态：" + statusCode);
				System.out.println("HTTP请求状态：" + statusCode);
			}

			HttpEntity entity = response.getEntity();
			String responseContent = null;
			if (entity != null) {
				responseContent = EntityUtils.toString(entity, "UTF-8");
			}
			if (showLog) {
				if (responseContent != null && responseContent.length() > 1024) {
					//logger.info("(" + /*random*/"" + ")HTTP请求结果：请求结果大于2K，不打印\r\n");
					System.out.println("HTTP请求结果：请求结果大于2K，不打印\r\n");
				} else {
					//logger.info("(" + /*random*/"" + ")HTTP请求结果：" + responseContent + "\r\n");
					System.out.println("HTTP请求结果：" + responseContent + "\r\n");
				}
			}
			if (httpMethod instanceof HttpGet || httpMethod instanceof HttpPut) {
				if (statusCode == HttpStatus.SC_OK) {
					return RespJsonFactory.buildCreated(responseContent);
				}
			} else if (httpMethod instanceof HttpPost) {
				if (statusCode == HttpStatus.SC_CREATED) {
					//Object resJson = convertToJson(responseContent);
					RespJsonFactory.build(HttpStatus.SC_CREATED, "网络创建成功");
					return RespJsonFactory.buildCreated(responseContent);
				}
			}else if (httpMethod instanceof HttpDelete) {
				if (statusCode == HttpStatus.SC_NO_CONTENT) {
				return RespJsonFactory.build(HttpStatus.SC_NO_CONTENT, "删除成功");
			}
		}

			return RespJsonFactory.build(HttpStatus.SC_INTERNAL_SERVER_ERROR, "调用接口异常:" + formate(responseContent));
		} catch (HttpHostConnectException e) {
			throw new Exception(e.getMessage());
		} catch (SocketTimeoutException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static Builder getBuilder(Integer socketTimeout, Integer connectTimeout, Integer connectionRequestTimeout) {
		Builder build = RequestConfig.custom();
		// 从服务器获取响应数据的超时时间
		if (socketTimeout == null) {
			String time = resource.getString("http.socket.timeout");
			if (StringUtils.isNumeric(time)) {
				socketTimeout = Integer.parseInt(time);
			}
		}

		// 和服务器建立连接的超时时间
		if (connectTimeout == null) {
			String time = resource.getString("http.connect.timeout");
			if (StringUtils.isNumeric(time)) {
				connectTimeout = Integer.parseInt(time);
			}
		}

		if (connectionRequestTimeout == null) {
			String time = resource.getString("http.connection.request.timeout");
			if (StringUtils.isNumeric(time)) {
				connectionRequestTimeout = Integer.parseInt(time);
			}
		}

		if (socketTimeout != null) {
			build.setSocketTimeout(socketTimeout);
		}

		if (connectTimeout != null) {
			build.setConnectTimeout(connectTimeout);
		}

		if (connectionRequestTimeout != null) {
			build.setConnectionRequestTimeout(connectionRequestTimeout);
		}
		return build;
	}

	private static Object convertToJson(String responseContent) {
		if (responseContent.startsWith("{")) {
			return JSONObject.parseObject(responseContent);
		} else if (responseContent.startsWith("[")) {
			return JSONArray.parseArray(responseContent);
		} else {
			return null;
		}
	}

	private static String formate(String responseContent) {
		if (responseContent.startsWith("{")) {
			return JSONObject.parseObject(responseContent).getString("category");
		} else {
			return responseContent;
		}
	}

	private static String ConvertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}


}
