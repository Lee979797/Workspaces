package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;

public interface ICenterDao {

	/**
	 * ����һ����˾ʵ�嵽��ݿ�
	 * 
	 * @param center
	 *            ��˾ʵ��
	 * @return ����id
	 */
	public Object saveCenter(Center center);

	/**
	 * �������зֹ�˾
	 * @return
	 */
	public List findAll();

	/**
	 * ��ҳ����
	 * @param page ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * @param page ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * �޸Ĺ�˾��Ϣ
	 * @param c
	 * @return
	 * @throws Exception 
	 */
	public Integer update(Center c) throws Exception;

	/**
	 * ���idɾ��ֹ�˾
	 * 
	 * @param centerId
	 * @return
	 */
	public Integer deleteById(Integer centerId);
}
