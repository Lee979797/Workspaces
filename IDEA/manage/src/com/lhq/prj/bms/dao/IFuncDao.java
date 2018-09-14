package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Func;

/**
 * IFuncDao.java Create on 2008-9-18 ����08:16:37
 * 
 * ְ��־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IFuncDao {

	/**
	 * ����һ��ְ����ݿ�
	 * 
	 * @param func
	 * @return
	 */
	public Object saveFunc(Func func);

	/**
	 * ��������ְ��
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * �޸�ְ����Ϣ
	 * 
	 * @param func
	 * @return
	 * @throws Exception
	 */
	public Integer update(Func func) throws Exception;

	/**
	 * ���idɾ��ְ��
	 * 
	 * @param funcId
	 * @return
	 */
	public Integer deleteById(Integer funcId);
	
	public List findByFuncCode(Page page);
	
}
