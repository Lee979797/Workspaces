package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.KeyLog;

/**
 * IKeyLogDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���Ź���־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IKeyLogDao {
	/**
	 * ����һ������ʵ�嵽��ݿ�
	 * 
	 * @param keyLog
	 *            ����ʵ��
	 * @return ����id
	 */
	public Object saveKeyLog(KeyLog keyLog);

	/**
	 * �������в���
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * ��ҳ����
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * �޸Ĳ�����Ϣ
	 * 
	 * @param keyLog
	 * @return
	 * @throws Exception
	 */
	public Integer update(KeyLog keyLog) throws Exception;

	/**
	 * ���idɾ����
	 * 
	 * @param keyLogId
	 * @return
	 */
	public Integer deleteById(Integer keyLogId);

	/**
	 * ��ݷֹ�˾�Ҳ���
	 *
	 * @param center
	 * @return
	 */
	public List findKeyLogByCenter(Center center);
}
