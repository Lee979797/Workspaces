package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;

public interface ICenterService {
	
	/**
	 * ��ӷֹ�˾
	 * @param center
	 * @return
	 */
	Object saveCenter(Center center);

	/**
	 * �������зֹ�˾
	 * @return
	 */
	List findAll();

	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸Ĺ�˾��Ϣ
	 * @param c
	 * @return
	 * @throws Exception 
	 */
	boolean updateCenter(Center c) throws Exception;

	/**
	 * ɾ��ֹ�˾
	 * 
	 * @param centerId
	 * @return
	 */
	boolean deleteCenter(Integer centerId);
	

}
