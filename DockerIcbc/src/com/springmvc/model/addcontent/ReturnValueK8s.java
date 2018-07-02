package com.springmvc.model.addcontent;

public class ReturnValueK8s {
	private String name;//容器名称
	private String hostIp;//主机节点
	private String podIp;//数据库ip
	private String startTime;//数据库容器生成时间
	private String containerId;//容器id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getPodIp() {
		return podIp;
	}
	public void setPodIp(String podIp) {
		this.podIp = podIp;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getContainerId() {
		return containerId;
	}
	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

}
