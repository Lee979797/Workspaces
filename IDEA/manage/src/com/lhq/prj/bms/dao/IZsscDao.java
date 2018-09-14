package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Zssc;

/**
 * IZsscDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���Ź���־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IZsscDao {
	/**
	 * ����һ������ʵ�嵽��ݿ�
	 * 
	 * @param zssc
	 *            ����ʵ��
	 * @return ����id
	 */
	public Object saveZssc(Zssc zssc);

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
	 * @param zssc
	 * @return
	 * @throws Exception
	 */
	public Integer update(Zssc zssc) throws Exception;

	/**
	 * ���idɾ����
	 * 
	 * @param zsscId
	 * @return
	 */
	public Integer deleteById(Integer zsscId);

	/**
	 * ��ݷֹ�˾�Ҳ���
	 *
	 * @param center
	 * @return
	 */
	public List findZsscByCenter(Center center);
}
