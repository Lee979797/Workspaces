package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Bzjg;

/**    
 * IBzjgService.java Create on 2008-9-16 ����10:38:57   
 *
 * 
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface IBzjgService {
	/**
	 * ��Ӳ���
	 * @param bzjg
	 * @return
	 */
	Object saveBzjg(Bzjg bzjg);

	/**
	 * �������в���
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
	 * �޸Ĳ�����Ϣ
	 * @param bzjg
	 * @return
	 * @throws Exception 
	 */
	boolean updateBzjg(Bzjg bzjg) throws Exception;

	/**
	 * ɾ����
	 * 
	 * @param bzjgId
	 * @return
	 */
	boolean deleteBzjg(Integer bzjgId);

	/**
	 * ��ݹ�˾�������в���
	 *
	 * @param page
	 * @return
	 */
	Page findBzjgByCenter(Page page);
}
 