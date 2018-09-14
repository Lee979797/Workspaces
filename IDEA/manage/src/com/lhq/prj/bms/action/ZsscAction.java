package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Zssc;
import com.lhq.prj.bms.service.IZsscService;


/**
 * ZsscAction.java Create on 2008-9-16 ����10:35:18
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ZsscAction extends BaseAction {
	private IZsscService zsscService;
	private Zssc zssc;
	private boolean success;
	private Page page;
	private Integer id;
	
	private String qsbh;
	private String jzbh;
	private String zstype;
	private Integer zssl;
	private String fpbzjg;
	private Date lrsj;
	private String note;

	public String saveZssc() {
		qsbh= getRequest().getParameter("qsbh");
		jzbh= getRequest().getParameter("jzbh");
		zstype= getRequest().getParameter("zstype");
		fpbzjg= getRequest().getParameter("fpbzjg");
		note=getRequest().getParameter("ssds");
		Long qsbh1 = Long.valueOf(qsbh);
		Long jzbh1 = Long.valueOf(jzbh);
		zssl=(int)(jzbh1-qsbh1+1);
		
		Zssc zssc = new Zssc();
		zssc.setId(id);
		zssc.setQsbh(qsbh);
		zssc.setJzbh(jzbh);
		zssc.setZstype(zstype);
		zssc.setZssl(zssl);
		zssc.setFpbzjg(fpbzjg);
		zssc.setLrsj(new Date());
		zssc.setFlag("1");
		zssc.setNote(note);

		id = (Integer) zsscService.saveZssc(zssc);
		if (id != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * ��ݷֹ�˾���Ҳ���
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findZsscByCenter() {
		String strCenterId = getRequest().getParameter("centerId");
		Center center = new Center();
		if(strCenterId != null && !"".equals(strCenterId)){
			center.setCenterId(Integer.valueOf(strCenterId));
		}
		List conditions = new ArrayList();
		conditions.add(center);
		page = new Page();
		page.setConditions(conditions);
		page = zsscService.findZsscByCenter(page);
		return SUCCESS;
	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllZssc() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		User user = (User) getSession().getAttribute("user");
		if(!user.getBzjgCode().equals(user.getCenterCode())){
			page.setBzjgdm(user.getBzjgCode());
		}
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = zsscService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * @return
	 */
	public String deleteZssc() {
		String strZsscId = getRequest().getParameter("id");
		if (strZsscId != null && !"".equals(strZsscId)) {
			success = zsscService.deleteZssc(Integer.valueOf(strZsscId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public String updateZssc() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strZsscId = getRequest().getParameter("id");
		if (strZsscId != null && !"".equals(strZsscId)) {
			Zssc zssc = new Zssc();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//zssc.setCenterId(Integer.valueOf(strCenterId));
			}
			//zssc.setZsscId(Integer.valueOf(strZsscId));
			MyUtils.invokeSetMethod(fieldName, zssc, new Object[] { fieldValue });
			success = zsscService.updateZssc(zssc);
		}
		return SUCCESS;
	}

	//无用，可删除
	public String fpZssc() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strZsscId = getRequest().getParameter("id");
		if (strZsscId != null && !"".equals(strZsscId)) {
			Zssc zssc = new Zssc();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//zssc.setCenterId(Integer.valueOf(strCenterId));
			}
			//zssc.setZsscId(Integer.valueOf(strZsscId));
			MyUtils.invokeSetMethod(fieldName, zssc, new Object[] { fieldValue });
			success = zsscService.updateZssc(zssc);
		}
		return SUCCESS;
	}

	public Zssc getZssc() {
		return zssc;
	}

	public void setZssc(Zssc zssc) {
		this.zssc = zssc;
	}

	public void setZsscService(IZsscService zsscService) {
		this.zsscService = zsscService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
