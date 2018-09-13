package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Zsly;

/**
 * IDeptDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���黹���¼�־û��ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IZslyDao {
	/**
	 * ����һ���軹��ʵ�嵽��ݿ�
	 * 
	 * @param zsly  �軹��ʵ��
	 * @return ����id
	 */
	public Object saveZsly(Zsly zsly);


	/**
	 * ��ҳ����
	 * 
	 * @param page ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * 
	 * @param page ����
	 * @return �ܼ�¼
	 */
	public int findByCount(Page page);

	/**
	 * �޸Ľ軹��Ϣ
	 * 
	 * @param zsly
	 * @return �޸ĵļ�¼��
	 * @throws Exception
	 */
	public Integer update(Zsly zsly) throws Exception;

	/**
	 * ���idɾ���¼
	 * 
	 * @param logId
	 * @return ɾ��ļ�¼��
	 */
	public Integer deleteById(Integer logId);
	
	
	public int findByZsbh(Zsly zsly);

}
