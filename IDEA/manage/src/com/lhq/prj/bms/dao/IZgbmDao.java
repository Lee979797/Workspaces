package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;

public interface IZgbmDao {

	public List findAll();
	
	public List findByPage(Page page);
	
	public int findByCount(Page page);
	
	public String findMcByDm(String code);
}
