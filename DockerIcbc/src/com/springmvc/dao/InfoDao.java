package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.DockerInfo;
import com.springmvc.model.addcontent.NetworkSite;
import com.springmvc.model.addcontent.Site;

public interface InfoDao {
	/**
	 * 添加mysql新信息
	 * @param info
	 * @return
	 */
	public int insertInfo(DockerInfo info);
	/**
	 * 查询mysql信息
	 * @return
	 */
	public List selectInfo();
	/**
	 * 查询网段信息
	 * @return
	 */
	public List selectSegment(NetworkSite mv);
	/**
	 * 删除实例信息
	 * @return
	 */
	public int deletePod(String str);
	
	

}
