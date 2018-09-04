package com.ninemax.jpa.code.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.struts2.interceptor.SessionAware;

import com.ninemax.jpa.code.model.Consignee;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.code.model.TSmrwwc;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.nacao.util.clsStringTool;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 收件信息
 * @author LiuPeng
 * 2014-2-11 下午06:08:50
 */
public class ConsigneeAction extends ActionSupport implements SessionAware {

	private String currentPath;
	private static final String path = "/product/jsp/consignee/";
	private Consignee consignee;
	private Page page;
	private List<Consignee> conList;
	private Map<String, Object> session;
	private String newPath;
	private String mes;

	
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * 添加收件
	 * @return
	 */
	public String addCon(){
	return	new ActionUtils() {
			
			@Override
			protected void excute() throws Exception {

				em.merge(consignee);
				String sql = "select model from Consignee model where model.jgdm=:jgdm";
				Query query = em.createQuery(sql);
                List<Consignee> con = query.setParameter("jgdm", consignee.getJgdm()).getResultList();
				mes=clsStringTool.getLsh(con.get(0).getLsh()+"", "0", 9);
                newPath="/bsweb/conAction_list.action";
                
                em.clear();
				currentPath=path+"conSuccess.jsp";
			}
		}.nSyTemplate();
	}
	
	/**
	 * 搜索收件
	 * @return
	 */
	public String search(){
		return new ActionUtils(){
			@Override
			protected void excute() throws Exception {
				consignee=em.find(Consignee.class, consignee.getLsh());
				String lsh=clsStringTool.getLsh(consignee.getLsh()+"", "0", 9);
				mes=lsh;
				em.clear();
				currentPath=path+"searchconsignee.jsp";
			}
			
		}.nSyTemplate();
	}
	
	
	/**
	 * 收件列表
	 * @return
	 */
	public String list(){
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (consignee == null) {
                	consignee = new Consignee();
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lsh");
                    page.setOrderByType("desc");
               
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "";
                    sql = " from  Consignee model where " + ("admin".equals(getUser().getUserName()) ? "  1=1  " : sql());

                if (consignee.getJgdm() != null && !consignee.getJgdm().equals("")) {
                    sql += " and model.jgdm like '%" + consignee.getJgdm() + "%'";
                } else {
                    if (consignee.getJgmc() != null && !"".equals(consignee.getJgmc())) {
                        sql += " and model.jgmc like '%" + consignee.getJgmc() + "%'";
                    }
                  if (consignee.getBzjgdm() != null && !"".equals(consignee.getBzjgdm())) {
                        sql += " and model.bzjgdm ='" + consignee.getBzjgdm().trim() + "'";
                    }
                  if (consignee.getConsigneeName() != null && !"".equals(consignee.getConsigneeName())) {
                      sql += " and model.consigneeName ='" + consignee.getConsigneeName().trim() + "'";
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

                   conList = em.createQuery("select model " + sql + orderBy)
                            .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
             

                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                em.clear();

                currentPath = path + "list.jsp";
            }
        }.nSyTemplate();
	}

	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Consignee> getConList() {
		return conList;
	}

	public void setConList(List<Consignee> conList) {
		this.conList = conList;
	}

	public static String getPath() {
		return path;
	}


	
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

	public String getNewPath() {
		return newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
	


	
	

}
