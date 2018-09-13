package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Duty;

/**
 * IDutyDao.java Create on 2008-9-18 ����08:16:37
 * 
 * ְ��־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IDutyDao {

	/**
	 * ����һ��ְ����ݿ�
	 * 
	 * @param duty
	 * @return
	 */
	public Object saveDuty(Duty duty);

	/**
	 * ��������ְ��
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * �޸�ְ����Ϣ
	 * 
	 * @param duty
	 * @return
	 * @throws Exception
	 */
	public Integer update(Duty duty) throws Exception;

	/**
	 * ���idɾ��ְ��
	 * 
	 * @param dutyId
	 * @return
	 */
	public Integer deleteById(Integer dutyId);
	
	public List findByDutyName(Page page);
	
}
