package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.SysConfig;

/**
 * IXzqhDao.java Create on 2013-4-18 下午03:16:37
 * 
 * 系统参数设置  持久层接口
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author yangqi
 * @version 1.0
 */
public interface ISysConfigDao {

	/**
	 * 保存一个参数信息到数据库
	 * 
	 * @param pzjg
	 * @return
	 */
	public Object saveSysConfig(SysConfig sysConfig);

	/**
	 * 查找所有参数信息
	 * 
	 * @return
	 */
	public List findAll();
	
	public SysConfig findById(Integer configId);
	
	public List findByPage(Page page);


	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * @param page ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * 修改参数信息
	 * 
	 * @param pzjg
	 * @return
	 * @throws Exception
	 */
	public Integer update(SysConfig sysConfig) throws Exception;

	/**
	 * 根据id删除参数
	 * 
	 * @param pzjgdm
	 * @return
	 */
	public Integer deleteById(Integer configId);
	
	public String findMcByDm(String configCode);
}
