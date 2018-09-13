package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;

public interface IZgbmService {
	
	List findAll();
	
	Page findByPage(Page page);
	
	String findMcByDm(String code);
}

