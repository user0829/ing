package com.springmvc.model;

public class DockerInfo {
	private String systemName;
	private String site;
	private String subSystem;
	private String subSystemCode;
	private String disasterLevel;
	private String deployment;
	private String performanceNeed;
	private int instances;
	private String mysqlVersion;
	private int portNum;
	private String characterSet;
	private String networkSection;
	private String osVersion;
	private int dataVolume;
	private int logVolume;
	private int tempVolume;
	private int backupVolume;
	private String databaseDomainName;
	private String createrId;
	private String createTime;
	private String backupTiming;
	
	private String hostIp;//主机节点
	private String podIp;//数据库ip
	private String startTime;//数据库容器生成时间
	private String containerId;//容器id
	
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
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSubSystem() {
		return subSystem;
	}
	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}
	public String getSubSystemCode() {
		return subSystemCode;
	}
	public void setSubSystemCode(String subSystemCode) {
		this.subSystemCode = subSystemCode;
	}
	public String getDisasterLevel() {
		return disasterLevel;
	}
	public void setDisasterLevel(String disasterLevel) {
		this.disasterLevel = disasterLevel;
	}
	public String getDeployment() {
		return deployment;
	}
	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}
	public String getPerformanceNeed() {
		return performanceNeed;
	}
	public void setPerformanceNeed(String performanceNeed) {
		this.performanceNeed = performanceNeed;
	}

	public int getInstances() {
		return instances;
	}
	public void setInstances(int instances) {
		this.instances = instances;
	}
	public String getMysqlVersion() {
		return mysqlVersion;
	}
	public void setMysqlVersion(String mysqlVersion) {
		this.mysqlVersion = mysqlVersion;
	}
	
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	public String getCharacterSet() {
		return characterSet;
	}
	public void setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
	}
	public String getNetworkSection() {
		return networkSection;
	}
	public void setNetworkSection(String networkSection) {
		this.networkSection = networkSection;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public int getDataVolume() {
		return dataVolume;
	}
	public void setDataVolume(int dataVolume) {
		this.dataVolume = dataVolume;
	}
	public int getLogVolume() {
		return logVolume;
	}
	public void setLogVolume(int logVolume) {
		this.logVolume = logVolume;
	}
	public int getTempVolume() {
		return tempVolume;
	}
	public void setTempVolume(int tempVolume) {
		this.tempVolume = tempVolume;
	}
	public int getBackupVolume() {
		return backupVolume;
	}
	public void setBackupVolume(int backupVolume) {
		this.backupVolume = backupVolume;
	}
	public String getDatabaseDomainName() {
		return databaseDomainName;
	}
	public void setDatabaseDomainName(String databaseDomainName) {
		this.databaseDomainName = databaseDomainName;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBackupTiming() {
		return backupTiming;
	}
	public void setBackupTiming(String backupTiming) {
		this.backupTiming = backupTiming;
	}
	
	
	
}
