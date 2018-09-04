package com.ninemax.jpa.code.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ninemax.jpa.code.model.Certificate;
import com.ninemax.jpa.code.model.Consignee;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 发证登记
 * @author LiuPeng
 * 2014-2-11 下午06:07:38
 */
public class CertificateAction extends ActionSupport implements SessionAware {

	private String currentPath;
	private static final String path = "/product/jsp/consignee/";
	private Map<String, Object> session;
	private Page page;
	private List<Certificate> cerList;

	private Certificate certificate;
	private String newPath;
	/**
	 * 添加发证信息
	 * @return
	 */
	public String addCer(){
		return new ActionUtils() {
			
			@Override
			protected void excute() throws Exception {
				em.persist(certificate);
				newPath="/bsweb/cerAction_list.action";
				
				em.clear();
				currentPath=path+"conSuccess.jsp";
				
			}
		}.nSyTemplate();
	}
	
	
	/**
	 * 搜索发证信息
	 * @return
	 */
	public String search(){
		return new ActionUtils(){
			protected void excute() throws Exception {
				certificate=em.find(Certificate.class, certificate.getSerialNumber());
				currentPath=path+"searchcertificate.jsp";
				em.clear();
				
			}
			
		}.nSyTemplate();
	}
	
	
	/**
	 * 显示发证列表
	 * @return
	 */
	public String list(){
		return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (certificate == null) {
                	certificate = new Certificate();
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("serialNumber");
                    page.setOrderByType("desc");
               
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "";
                    sql = " from  Certificate model where " + ("admin".equals(getUser().getUserName()) ? "  1=1  " : sql());

                if (certificate.getJgdm() != null && !certificate.getJgdm().equals("")) {
                    sql += " and model.jgdm like '%" + certificate.getJgdm() + "%'";
                } else {

                  if (certificate.getOperator() != null && !"".equals(certificate.getOperator())) {
                        sql += " and model.operator ='" + certificate.getOperator().trim() + "'";
                    }
                  if (certificate.getSerialNumber() != null && !"".equals(certificate.getSerialNumber())) {
                      sql += " and model.serialNumber ='" + certificate.getSerialNumber() + "'";
                  }
                  if (certificate.getWsbzSerial() != null && !"".equals(certificate.getWsbzSerial())) {
                      sql += " and model.wsbzSerial ='" + certificate.getWsbzSerial().trim() + "'";
                  }
                    /*if (startDate != null) {
                        sql += " and model.createTime >= '" + DateUtil.dateToStr(startDate) + "'";
                    }
                    if (task.getCreateTime() != null) {
                        Date end = DateUtil.dayAfter(task.getCreateTime(), 1);
                        sql += " and model.createTime < '" + DateUtil.dateToStr(end) + "'";
                    }
                    if (task.getCompleTime() != null) {
                        sql += " and model.compleTime >= '" + DateUtil.dateToStr(task.getCompleTime()) + "'";
                    }
                    if (endDate != null) {
                        Date end = DateUtil.dayAfter(endDate, 1);
                        sql += " and model.compleTime < '" + DateUtil.dateToStr(end) + "'";
                    }*/
                }

                cerList = em.createQuery("select model " + sql + orderBy)
                            .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
             

                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                em.clear();

                currentPath = path + "cerList.jsp";
            }
        }.nSyTemplate();
	}
	public String getCurrentPath() {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Certificate> getCerList() {
		return cerList;
	}
	public void setCerList(List<Certificate> cerList) {
		this.cerList = cerList;
	}
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	public static String getPath() {
		return path;
	}

	public String getNewPath() {
		return newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}
	
	
	
	

}
