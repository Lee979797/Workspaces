package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.service.ICenterService;

@SuppressWarnings("serial")
public class CenterAction extends BaseAction {

	private ICenterService centerService;

	private boolean success;

	private Center center;

	private Page page;

	private Integer centerId;

	/**
	 * ��ӷֹ�˾
	 * 
	 * @return
	 */
	public String saveCenter() {
		centerId = (Integer) centerService.saveCenter(center);
		if (centerId != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	/**
	 * �������й�˾
	 * 
	 * @return
	 */
	public String findAll(){
		page = new Page();
		page.setRoot(centerService.findAll());
		return SUCCESS;
	}

	/**
	 * ���������ҳ���ҹ�˾
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findAllCenter() {
		String strCondition = getRequest().getParameter("conditions");	//��ô��ݹ����Ĳ���,��������ÿո����
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); // ʵ���ҳ����
		page.setConditions(conditions);// ���ò�ѯ����
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = centerService.findByPage(page);
		if (null != page.getRoot()) {
			page.setSuccess(true);
		}
		return SUCCESS;
	}

	/**
	 * ɾ��˾
	 * 
	 * @return
	 */
	public String deleteCenter() {
		String strCenterId = getRequest().getParameter("centerId");
		if (strCenterId != null && !"".equals(strCenterId)) {
			success = centerService.deleteCenter(Integer.valueOf(strCenterId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĺ�˾ָ���ֶε�ֵ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCenter() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strCenterId = getRequest().getParameter("centerId");
		if (strCenterId != null && !"".equals(strCenterId)) {
			Center c = new Center();
			c.setCenterId(Integer.valueOf(strCenterId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = centerService.updateCenter(c);
		}
		return SUCCESS;
	}
	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public void setCenterService(ICenterService centerService) {
		this.centerService = centerService;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
