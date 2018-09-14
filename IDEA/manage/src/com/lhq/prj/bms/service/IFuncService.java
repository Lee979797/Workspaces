package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.po.Func;

/**
 * IFuncService.java Create on 2008-9-18 ����08:11:19
 * 
 * ְ�����ҵ���ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IFuncService {

	/**
	 * ���ְ��
	 * 
	 * @param func
	 * @return
	 */
	Object saveFunc(Func func);

	/**
	 * ��������ְ��
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * �޸�ְ����Ϣ
	 * 
	 * @param func
	 * @return
	 * @throws Exception
	 */
	boolean updateFunc(Func func) throws Exception;

	/**
	 * ɾ��ְ��
	 * 
	 * @param funcId
	 * @return
	 */
	boolean deleteFunc(Integer funcId);
}
