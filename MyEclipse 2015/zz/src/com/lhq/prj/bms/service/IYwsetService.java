package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Ywset;

/**    
 * IYwsetService.java Create on 2008-9-16 ����10:38:57   
 *
 * 
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface IYwsetService {
	/**
	 * ��Ӳ���
	 * @param ywset
	 * @return
	 */
	Object saveYwset(Ywset ywset,String bzjgdm);

	/**
	 * �������в���
	 * @return
	 */
	//List findAll(String flag);

	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸Ĳ�����Ϣ
	 * @param ywset
	 * @return
	 * @throws Exception 
	 */
	boolean updateYwset(Ywset ywset,String bzjgdm) throws Exception;

	/**
	 * ɾ����
	 * 
	 * @param ywsetId
	 * @return
	 */
	boolean deleteYwset(Integer ywsetId,String bzjgdm);

	/**
	 * ��ݹ�˾�������в���
	 *
	 * @param page
	 * @return
	 */
	List findYwsetByBzjg(String bzjgdm);
	
	List findYwsetByNotBzjg(String bzjgdm);
}
 