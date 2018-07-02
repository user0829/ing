package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.CommonDao;
import com.springmvc.model.addcontent.CharacterSet;
import com.springmvc.model.addcontent.DbaManager;
import com.springmvc.model.addcontent.DepartManager;
import com.springmvc.model.addcontent.MysqlVersion;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.Site;
import com.springmvc.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao comDao;
	public List selectChar() {
		return comDao.selectChar();
	}

	public List seletMysql() {
		return comDao.selectMysql();
	}

	public List selectPerformance() {
		
		return comDao.selectPerformance();
	}

	public List selectOsVersion() {
		
		return comDao.selectOsVersion();
	}

	public int addMysql(MysqlVersion mv) {
		return comDao.addMysql(mv);
	}

	public int addCharSet(CharacterSet mv) {
		return comDao.addCharSet(mv);
	}

	public int addDbaPerson(DbaManager mv) {
		return comDao.addDbaPerson(mv);
	}

	public int addPartManager(DepartManager mv) {
		return comDao.addPartManager(mv);
	}

	public int deleteMysqlInfo(MysqlVersion mv) {
		return comDao.deleteMysqlInfo(mv);
	}

	public int deleteCharInfo(CharacterSet mv) {
		return comDao.deleteCharInfo(mv);
	}

	public int deleteDbaInfo(DbaManager mv) {
		return comDao.deleteDbaInfo(mv);
	}

	public int deleteDepartInfo(DepartManager mv) {
		return comDao.deleteDepartInfo(mv);
	}

	public int addSiteInfo(Site mv) {
		return comDao.addSiteInfo(mv);
	}

	public int deleteSiteInfo(Site mv) {
		return comDao.deleteSiteInfo(mv);
	}

	public List selectDbaManager() {
		return comDao.selectDbaManager();
	}

	public List selectDpartManager() {
		return comDao.selectDpartManager();
	}

	public List selectSiteCluster() {
		return comDao.selectSiteCluster();
	}

	public int addColony(NetworkSite mv) {
		return comDao.addColony(mv);
	}

	public List selectSiteNetwork() {
		return comDao.selectSiteNetwork();
	}

	public int deleteNetworkSite(NetworkSite mv) {
		return comDao.deleteNetworkSite(mv);
	}

}
