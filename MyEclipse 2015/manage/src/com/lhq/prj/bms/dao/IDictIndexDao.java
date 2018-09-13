package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.po.DictIndex;

/**
 * ISubjectDao.java Create on 2008-9-18 ����08:16:37
 * 
 * ��Ŀ�־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IDictIndexDao {

	/**
	 * ����һ����Ŀ����ݿ�
	 * 
	 * @param subject
	 * @return
	 */
	public Object saveDictIndex(DictIndex dictIndex);

	/**
	 * �������п�Ŀ
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * �޸Ŀ�Ŀ��Ϣ
	 * 
	 * @param subject
	 * @return
	 * @throws Exception
	 */
	public Integer update(DictIndex dictIndex) throws Exception;

	/**
	 * ���idɾ���Ŀ
	 * 
	 * @param subjectId
	 * @return
	 */
	public Integer deleteById(Integer subjectId);
}
