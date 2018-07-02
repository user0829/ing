package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.addcontent.CharacterSet;
import com.springmvc.model.addcontent.DbaManager;
import com.springmvc.model.addcontent.DepartManager;
import com.springmvc.model.addcontent.MysqlVersion;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.Site;

public interface CommonDao {

	/**
	 * 查询字符集
	 * @return
	 */
	public List selectChar();
	
	/**
	 * 查询mysql版本
	 * @return
	 */
	public List selectMysql();
	/**
	 * 查询DBA管理人员
	 * @return
	 */
	public List selectDbaManager();
	/**
	 * 查询部门管理人员
	 * @return
	 */
	public List selectDpartManager();
	/**
	 * 查询站点信息
	 * @return
	 */
	public List selectSiteCluster();
	/**
	 * 查询性能套餐
	 * @return
	 */
	public List selectPerformance();
	/**
	 * 查询操作系统
	 * @return
	 */
	public List selectOsVersion();
	/**
	 * 查询集群信息
	 * @return
	 */
	public List selectSiteNetwork();
	/**
	 * 增加mysql版本
	 * @return
	 */
	public int addMysql(MysqlVersion mv);
	/**
	 * 增加字符集
	 * @return
	 */
	public int addCharSet(CharacterSet mv);
	/**
	 * 增加dba人员
	 * @return
	 */
	public int addDbaPerson(DbaManager mv);
	/**
	 * 增加网点信息
	 * @return
	 */
	public int addSiteInfo(Site mv);
	/**
	 * 增加部门管理人员
	 * @return
	 */
	public int addPartManager(DepartManager mv);
	/**
	 * 增加部门管理人员
	 * @return
	 */
	public int addColony(NetworkSite mv);
	
	
	/**
	 * 删除mysql版本数据信息
	 * @return
	 */
	public int deleteMysqlInfo(MysqlVersion mv);
	/**
	 * 删除字符集数据信息
	 * @return
	 */
	public int deleteCharInfo(CharacterSet mv);
	/**
	 * 删除字符集数据信息
	 * @return
	 */
	public int deleteDbaInfo(DbaManager mv);
	/**
	 * 删除字符集数据信息
	 * @return
	 */
	public int deleteDepartInfo(DepartManager mv);
	/**
	 * 删除网点数据信息
	 * @return
	 */
	public int deleteSiteInfo(Site mv);
	/**
	 * 删除集群数据信息
	 * @return
	 */
	public int deleteNetworkSite(NetworkSite mv);
	
	
	
	
	
	
}
