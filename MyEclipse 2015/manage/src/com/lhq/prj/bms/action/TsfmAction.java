package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Tsfm;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.service.ITsfmService;


/**
 * TsfmAction.java Create on 2008-9-16 ����10:35:18
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TsfmAction extends BaseAction {
	private ITsfmService tsfmService;
	private Tsfm tsfm;
	private boolean success;
	private Page page;
	private Integer id;
	private String qsdm;
	private String jzdm;
	private Integer dmsl;
	private String fmtype;
	private String fmjgdm;
	private String fmjgmc;
	private String fpbzjg;
	private String flag;
	private Date lrsj;
	private Integer userid;
	private String username;
	private String name;
	private String note;
	private String errMsg;


	public String saveTsfm() {
		
		qsdm= getRequest().getParameter("qsdm");
		jzdm= getRequest().getParameter("jzdm");
		fmtype= getRequest().getParameter("fmtype");
		fmjgdm= getRequest().getParameter("fmjgdm");
		fmjgmc= getRequest().getParameter("fmjgmc");
		fpbzjg= getRequest().getParameter("fpbzjg");
		note=getRequest().getParameter("note");
		
		Long qsdm1=null;
		Long jzdm1=null;
		
		String qsdmQ = qsdm.substring(0, 1);
		String qsdmH = qsdm.substring(1, qsdm.length());
		System.out.println(qsdmQ+" "+qsdmH+"检测是否首位为字母"+qsdmQ.matches("[a-zA-Z]"));
		if(qsdmQ.matches("[a-zA-Z]")){
			qsdm1 = Long.valueOf(qsdmH);
		}else{
			qsdm1 = Long.valueOf(qsdm);
		}
		
		String jzdmQ = jzdm.substring(0, 1);
		String jzdmH = jzdm.substring(1, jzdm.length());
		if(jzdmQ.matches("[a-zA-Z]")){
			jzdm1 = Long.valueOf(jzdmH);
		}else{
			jzdm1 = Long.valueOf(jzdm);
		}
		
		//Long qsdm1 = Long.valueOf(qsdm);
		//Long jzdm1 = Long.valueOf(jzdm);
		dmsl=(int)(jzdm1-qsdm1+1);
		
		User user = (User) getSession().getAttribute("user");
		Integer strUserid=user.getUserId();
		String strUsername=user.getUserName();
		String strName=user.getEmplName();
		String strCenterid= user.getCenterCode();;
		
		Tsfm tsfm = new Tsfm();
		tsfm.setId(id);
		tsfm.setCenterid(strCenterid);
		tsfm.setQsdm(qsdm);
		tsfm.setJzdm(jzdm);
		tsfm.setFmtype(fmtype);
		tsfm.setFmjgdm(fmjgdm);
		tsfm.setFmjgmc(fmjgmc);
		tsfm.setDmsl(dmsl);
		tsfm.setFpbzjg(fpbzjg);
		tsfm.setUserid(strUserid);
		tsfm.setUsername(strUsername);
		tsfm.setName(strName);
		tsfm.setLrsj(new Date());
		tsfm.setFlag("1");
		tsfm.setNote(note);

		id = (Integer) tsfmService.saveTsfm(tsfm);
		if (id != null) {
			success = true;
		}else{
			errMsg = "分发代码已存在！";
		}
		return SUCCESS;
	}

	/**
	 * ��ݷֹ�˾���Ҳ���
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findTsfmByCenter() {
		String strCenterId = getRequest().getParameter("centerId");
		Center center = new Center();
		if(strCenterId != null && !"".equals(strCenterId)){
			center.setCenterId(Integer.valueOf(strCenterId));
		}
		List conditions = new ArrayList();
		conditions.add(center);
		page = new Page();
		page.setConditions(conditions);
		page = tsfmService.findTsfmByCenter(page);
		return SUCCESS;
	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllTsfm() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = tsfmService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * @return
	 */
	public String deleteTsfm() {
		String strTsfmId = getRequest().getParameter("id");
		if (strTsfmId != null && !"".equals(strTsfmId)) {
			success = tsfmService.deleteTsfm(Integer.valueOf(strTsfmId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public String updateTsfm() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strTsfmId = getRequest().getParameter("id");
		if (strTsfmId != null && !"".equals(strTsfmId)) {
			Tsfm tsfm = new Tsfm();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//tsfm.setCenterId(Integer.valueOf(strCenterId));
			}
			//tsfm.setTsfmId(Integer.valueOf(strTsfmId));
			MyUtils.invokeSetMethod(fieldName, tsfm, new Object[] { fieldValue });
			success = tsfmService.updateTsfm(tsfm);
		}
		return SUCCESS;
	}

	//无用，可删除
	public String fpTsfm() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strTsfmId = getRequest().getParameter("id");
		if (strTsfmId != null && !"".equals(strTsfmId)) {
			Tsfm tsfm = new Tsfm();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//tsfm.setCenterId(Integer.valueOf(strCenterId));
			}
			//tsfm.setTsfmId(Integer.valueOf(strTsfmId));
			MyUtils.invokeSetMethod(fieldName, tsfm, new Object[] { fieldValue });
			success = tsfmService.updateTsfm(tsfm);
		}
		return SUCCESS;
	}

	public Tsfm getTsfm() {
		return tsfm;
	}

	public void setTsfm(Tsfm tsfm) {
		this.tsfm = tsfm;
	}

	public void setTsfmService(ITsfmService tsfmService) {
		this.tsfmService = tsfmService;
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

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
