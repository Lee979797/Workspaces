package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.po.DictIndex;

/**
 * ISubjectService.java Create on 2008-9-21 ����03:57:53
 * 
 * ��Ŀ����ҵ���
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IDictIndexService {
	/**
	 * ��ӿ�Ŀ
	 * 
	 * @param subject
	 * @return
	 */
	Object saveDictIndex(DictIndex dictIndex);

	/**
	 * �������п�Ŀ
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * �޸Ŀ�Ŀ��Ϣ
	 * 
	 * @param subject
	 * @return
	 * @throws Exception
	 */
	boolean updateDictIndex(DictIndex dictIndex) throws Exception;

	/**
	 * ɾ���Ŀ
	 * 
	 * @param subjectId
	 * @return
	 */
	boolean deleteDictIndex(Integer subjectId);
}
