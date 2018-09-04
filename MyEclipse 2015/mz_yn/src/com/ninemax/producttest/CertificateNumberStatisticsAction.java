package com.ninemax.producttest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import sun.jdbc.rowset.CachedRowSet;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.code.model.Model;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.TZsbhb;
import com.ninemax.jpa.code.model.TZsbhbId;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CertificateNumberStatisticsAction extends ActionSupport implements
		SessionAware {
	private static final String path = "/product/jsp/codenumber/";
	private String currentPath = "";
	private String returnXml = "";
	private String jgdmString = "";
	private CertificateNumberStatisticsDao certificateNumberStatisticsDao = new CertificateNumberStatisticsDao();
	private Map<String, Object> map;
	HttpServletRequest request = ServletActionContext.getRequest();
//	private Page page = (Page) request.getAttribute("page");
	private Page page;
	private List list = new ArrayList();
	final StringBuffer sBuffer = new StringBuffer();
	private List<Model> models;
    private Date startDate;
    private Date endDate;
    private String ssbzjg;
    private Map<String, Object> session;
    private Map<String, String> zrxzqhMap;
	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	public static String getPath() {
		return path;
	}

	public String getReturnXml() {
		return returnXml;
	}

	public void setReturnXml(String returnXml) {
		this.returnXml = returnXml;
	}

	
	public String getJgdmString() {
		return jgdmString;
	}

	public void setJgdmString(String jgdmString) {
		this.jgdmString = jgdmString;
	}

	public String TypeStatistics() {
		return new ActionUtils() {
			@SuppressWarnings("unchecked")
			@Override
			protected void excute() throws Exception {
//				  User user = (User) map.get("sysUser");
//	                if (zsbhb == null) {
//	                    zsbhb = new TZsbhb();
//	                    zsbhb.setId(new TZsbhbId());
//	                } else if (zsbhb.getId() == null) {
//	                    zsbhb.setId(new TZsbhbId());
//	                }
//	                if (page == null) {
//	                    page = new Page();
//	                    page.setOrderByField("fpsj");
//	                    page.setOrderByType("desc");
//	                }
//	                String xzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getXzqh();
//	                String ds = InitSysParams.scCenterMap.get(xzqh);
//	                if (ds != null) {
//	                    ds = xzqh.substring(0, 2);
//	                } else {
//	                    ds = xzqh.substring(0, 4);
//	                }
//	                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by zs." + page.getOrderByField() + " " + page.getOrderByType()) : "";
//	                String sql = " from TZsbhb zs where  zs.ssds like '" + ds + "%' and  zs.ssbzjg is not null ";
//	                if (!(zsbhb.getId().getZsbh() == null || "".equals(zsbhb.getId().getZsbh()))) {
//	                    sql += "  and zs.id.zsbh like '%" + zsbhb.getId().getZsbh() + "%'";
//	                }
//	                if (!(zsbhb.getSsbzjg() == null || "".equals(zsbhb.getSsbzjg()))) {
//	                    sql += "  and zs.ssbzjg='" + zsbhb.getSsbzjg() + "'";
//	                }
//	                if (!(zsbhb.getFlag()== null || "".equals(zsbhb.getFlag()))) {
//	                    sql += "  and zs.flag='" + zsbhb.getFlag() + "'";
//	                }
//	                if (startDate != null) {
//	                    sql += " and zs.fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
//	                }
//	                if (endDate != null) {
//	                    sql += " and zs.fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
//	                }
//				String ssbzjg = (String) request.getAttribute("ssbzjg");//办证机构
//				Date startDate = (Date) request.getAttribute("startDate");//开始日期
//				Date endDate = (Date) request.getAttribute("endDate");//开始日期
//				page = (Page) request.getAttribute("page");//开始日期
				
//				User user = (User) session.get("sysUser");
//				 zrxzqhMap = new TreeMap<String, String>(
//	                        new Comparator<String>() {
//	                            public int compare(String obj1, String obj2) {
//	                                if (obj1 == null)
//	                                    return -1;
//	                                return obj1.compareTo(obj2);
//	                            }
//	                        }
//	                );
//				   Pattern p = Pattern.compile("(.*[1-9]+)");
//	                Matcher m = p.matcher(user.getBzjgdm());
//	                String filter = m.find() ? m.group() : user.getBzjgdm();
//	                for (Map.Entry<String, String> entry : InitSysParams.zrxzqhMap.entrySet()) {
//	                    if (entry.getKey().startsWith(filter)) {
//	                        zrxzqhMap.put(entry.getKey(), entry.getValue());
//	                    }
//	                }
				if (page == null) {
                    page = new Page();
					page.setOrderByField("fpsj");
	                page.setOrderByType("desc");
				}
				String orderBy = "";
				if(!isNotNull(page.getOrderByField()))
					orderBy += " order by t." +page.getOrderByField() +" "+ page.getOrderByType();
				sBuffer.append("select t.ssbzjg,convert(varchar(20),t.fpsj,120) fpsj,t.zslx,");
				sBuffer.append("coalesce(case t.flag when 1 then count(t.flag) end,0) as enableCount,");
				sBuffer.append("coalesce(CASE t.flag when 2 THEN COUNT(t.flag) end,0) as lossCount");
				sBuffer.append(",coalesce(count(t.zslx),0) as certificateCount from t_zsbhb t where t.ssbzjg is not NULL ");
				if(!isNotNull(ssbzjg))
					sBuffer.append(" and t.ssbzjg = ").append(ssbzjg);
				if (startDate != null) {
					sBuffer.append(" and t.fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ");
                }
                if (endDate != null) {
                	sBuffer.append(" and t.fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ");
                }
                sBuffer.append(" GROUP BY t.flag,t.ssbzjg,convert(varchar(20),t.fpsj,120),t.zslx");
				System.out.println("证书数量统计查询语句:"+sBuffer + orderBy);
				  models = new ArrayList<Model>();
	               List<Object []> li =  em.createNativeQuery(sBuffer.toString() + orderBy)
	                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
	                        .getResultList();
	               for(int i = 0;i<li.size();i++){
	            	   Model model = new Model();
	                    model.setColumn1(String.valueOf(li.get(i)[0]));
	                    model.setColumn2(String.valueOf(li.get(i)[1]));
//	                    if(!isNotNull(String.valueOf(li.get(i)[1])))
//	                    	model.setFpsjDate(DateUtil.strToDate("yyyy-MM-dd", String.valueOf(li.get(i)[1])));
//	                    else
//	                    	model.setFpsjDate(null);
	                    model.setColumn3(String.valueOf(li.get(i)[2]));
	                    model.setColumn4(String.valueOf(li.get(i)[3]));
	                    model.setColumn5(String.valueOf(li.get(i)[4]));
	                    model.setColumn6(String.valueOf(li.get(i)[5]));
	                    models.add(model);
	               }
//				DataAccess dataObject = new DataAccess();
//				  CachedRowSet cs = dataObject.query(sBuffer.toString() + orderBy);
//	                while (cs.next()) {
//	                    Model model = new Model();
//	                    model.setColumn1(cs.getString("ssbzjg"));
//	                    model.setColumn2(cs.getString("fpsj"));
//	                    model.setColumn3(cs.getString("zslx"));
//	                    model.setColumn4(cs.getString("enableCount"));
//	                    model.setColumn5(cs.getString("lossCount"));
//	                    model.setColumn6(cs.getString("certificateCount"));
//	                    models.add(model);
//	                }
	                page.setTotalRecord(((Integer) em.createNativeQuery("select count(tab.fpsj) from (" + sBuffer.toString()+") tab")
	                        .getResultList().get(0)));
	                currentPath = path + "number_statistics.jsp";
//	                request.setAttribute("page", page);
//	                request.setAttribute("ssbzjg", ssbzjg);
//	                request.setAttribute("startDate", startDate);
//	                request.setAttribute("endDate", endDate);
	                request.setAttribute("list", models);
			}
		}.template();
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public static boolean isNotNull(Object obj){
		if(null != obj && !obj.equals(""))
			return false;
		else 
			return true;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSsbzjg() {
		return ssbzjg;
	}

	public void setSsbzjg(String ssbzjg) {
		this.ssbzjg = ssbzjg;
	}

	public Map<String, String> getZrxzqhMap() {
		return zrxzqhMap;
	}

	public void setZrxzqhMap(Map<String, String> zrxzqhMap) {
		this.zrxzqhMap = zrxzqhMap;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
