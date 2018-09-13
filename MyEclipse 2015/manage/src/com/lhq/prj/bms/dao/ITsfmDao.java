package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Tsfm;

/**
 * ITsfmDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���Ź���־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface ITsfmDao {
	/**
	 * ����һ������ʵ�嵽��ݿ�
	 * 
	 * @param tsfm
	 *            ����ʵ��
	 * @return ����id
	 */
	public Object saveTsfm(Tsfm tsfm);

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
	 * @param tsfm
	 * @return
	 * @throws Exception
	 */
	public Integer update(Tsfm tsfm) throws Exception;

	/**
	 * ���idɾ����
	 * 
	 * @param tsfmId
	 * @return
	 */
	public Integer deleteById(Integer tsfmId);

	/**
	 * ��ݷֹ�˾�Ҳ���
	 *
	 * @param center
	 * @return
	 */
	public List findTsfmByCenter(Center center);
}
