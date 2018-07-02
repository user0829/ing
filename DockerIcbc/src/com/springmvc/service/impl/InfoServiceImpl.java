package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.InfoDao;
import com.springmvc.model.DockerInfo;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.Site;
import com.springmvc.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;

	public int insertInfo(DockerInfo info) {

		return infoDao.insertInfo(info);
	}

	public List selectInfo() {
		return infoDao.selectInfo();
	}

	public List selectSegment(NetworkSite mv) {
		return infoDao.selectSegment(mv);
	}

	public int deletePod(String str) {
		return infoDao.deletePod(str);
	}
	


}
