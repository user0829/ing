package com.springmvc.model.addcontent;

public class Site {
	private String site;//站点名称
	private String apiServerIp;//连接接口IP
	private String port;//接口端口号
	private String remark;//备注信息
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getApiServerIp() {
		return apiServerIp;
	}
	public void setApiServerIp(String apiServerIp) {
		this.apiServerIp = apiServerIp;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
