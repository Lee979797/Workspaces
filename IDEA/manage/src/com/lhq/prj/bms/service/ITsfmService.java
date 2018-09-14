package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.CodeDetail;
import com.lhq.prj.bms.po.Tsfm;

/**    
 * ITsfmService.java Create on 2008-9-16 ����10:38:57   
 *
 * 
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface ITsfmService {
	/**
	 * ��Ӳ���
	 * @param tsfm
	 * @return
	 */
	Object saveTsfm(Tsfm tsfm);

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
	 * @param tsfm
	 * @return
	 * @throws Exception 
	 */
	boolean updateTsfm(Tsfm tsfm) throws Exception;

	/**
	 * ɾ����
	 * 
	 * @param tsfmId
	 * @return
	 */
	boolean deleteTsfm(Integer tsfmId);

	/**
	 * ��ݹ�˾�������в���
	 *
	 * @param page
	 * @return
	 */
	Page findTsfmByCenter(Page page);
	
	//取码
}
 