package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Bzjg;

/**
 * IBzjgDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���Ź���־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IBzjgDao {
	/**
	 * ����һ������ʵ�嵽��ݿ�
	 * 
	 * @param bzjg
	 *            ����ʵ��
	 * @return ����id
	 */
	public Object saveBzjg(Bzjg bzjg);

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
	 * @param bzjg
	 * @return
	 * @throws Exception
	 */
	public Integer update(Bzjg bzjg) throws Exception;

	/**
	 * ���idɾ����
	 * 
	 * @param bzjgId
	 * @return
	 */
	public Integer deleteById(Integer bzjgId);

	/**
	 * ��ݷֹ�˾�Ҳ���
	 *
	 * @param center
	 * @return
	 */
	public List findBzjgByCenter(Center center);
	
	public Bzjg findByBzjgdm(String bzjgCode);
}
