package com.springmvc.service;

import java.util.List;

import com.springmvc.model.addcontent.CharacterSet;
import com.springmvc.model.addcontent.DbaManager;
import com.springmvc.model.addcontent.DepartManager;
import com.springmvc.model.addcontent.MysqlVersion;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.Site;

public interface CommonService {

	public List selectChar();
	public List seletMysql();
	public List selectPerformance();
	public List selectOsVersion();
	public List selectDbaManager();
	public List selectDpartManager();
	public List selectSiteCluster();
	public List selectSiteNetwork();
	public int addMysql(MysqlVersion mv);
	public int addCharSet(CharacterSet mv);
	public int addDbaPerson(DbaManager mv);
	public int addPartManager(DepartManager mv);
	public int addSiteInfo(Site mv);
	public int addColony(NetworkSite mv);
	public int deleteMysqlInfo(MysqlVersion mv);
	public int deleteCharInfo(CharacterSet mv);
	public int deleteDbaInfo(DbaManager mv);
	public int deleteDepartInfo(DepartManager mv);
	public int deleteSiteInfo(Site mv);
	public int deleteNetworkSite(NetworkSite mv);

}
