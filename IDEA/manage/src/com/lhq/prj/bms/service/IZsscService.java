package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Zssc;

/**    
 * IZsscService.java Create on 2008-9-16 ����10:38:57   
 *
 * 
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface IZsscService {
	/**
	 * ��Ӳ���
	 * @param zssc
	 * @return
	 */
	Object saveZssc(Zssc zssc);

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
	 * @param zssc
	 * @return
	 * @throws Exception 
	 */
	boolean updateZssc(Zssc zssc) throws Exception;

	/**
	 * ɾ����
	 * 
	 * @param zsscId
	 * @return
	 */
	boolean deleteZssc(Integer zsscId);

	/**
	 * ��ݹ�˾�������в���
	 *
	 * @param page
	 * @return
	 */
	Page findZsscByCenter(Page page);
}
 