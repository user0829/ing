package com.springmvc.service;

import java.util.List;

import com.springmvc.model.DockerInfo;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.Site;


public interface InfoService {



		public int insertInfo(DockerInfo info);
		public List selectInfo();
		public List selectSegment(NetworkSite mv);
		public int deletePod(String str);

}
