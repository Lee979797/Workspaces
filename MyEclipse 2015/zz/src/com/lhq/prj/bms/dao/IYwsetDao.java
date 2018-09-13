package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Ywset;

/**
 * IYwsetDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���Ź���־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IYwsetDao {
	/**
	 * ����һ������ʵ�嵽��ݿ�
	 * 
	 * @param ywset
	 *            ����ʵ��
	 * @return ����id
	 */
	public Object saveYwset(Ywset ywset);

	/**
	 * �������в���
	 * 
	 * @return
	 */
	public List findAll(Ywset ys);

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
	 * @param ywset
	 * @return
	 * @throws Exception
	 */
	public Integer update(Ywset ywset) throws Exception;

	/**
	 * ���idɾ����
	 * 
	 * @param ywsetId
	 * @return
	 */
	public Integer deleteById(Integer ywsetId);

	/**
	 * ��ݷֹ�˾�Ҳ���
	 *
	 * @param center
	 * @return
	 */
	public List findYwsetByBzjg(String bzjgdm);
	
	public List findYwsetByNotBzjg(String bzjgdm);

}
