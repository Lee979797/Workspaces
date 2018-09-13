package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Jjlx;

/**
 * IXzqhDao.java Create on 2008-9-18 下午08:16:37
 * 
 * 职务持久层接口
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
public interface IJjlxDao {

	/**
	 * 保存一个职务到数据库
	 * 
	 * @param jjlx
	 * @return
	 */
	public Object saveJjlx(Jjlx jjlx);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	public List findAll();
	
	
	public List findByPage(Page page);

	
	public List findByPjjlx(String pjjlx);
	
	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * @param page ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * 修改职务信息
	 * 
	 * @param jjlx
	 * @return
	 * @throws Exception
	 */
	public Integer update(Jjlx jjlx) throws Exception;

	/**
	 * 根据id删除职务
	 * 
	 * @param jjlxdm
	 * @return
	 */
	public Integer deleteById(Integer jjlxid);

	public Jjlx findMcByDm(String code);

}
