/**
 *
 */
package com.ninemax.jpa.code.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import sun.jdbc.rowset.CachedRowSet;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.dao.tjgdm.clsTjgdmDAO;
import com.ninemax.jpa.code.bus.AjaxBus;
import com.ninemax.jpa.code.bus.TFzdmBus;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.bus.TZrxzqhBus;
import com.ninemax.jpa.code.bus.TjgdmBus;
import com.ninemax.jpa.code.model.Field;
import com.ninemax.jpa.code.model.Model;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.TBgk;
import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TFzr;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.code.model.Ttable;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.CheckCode;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.ExcelUtils;
import com.ninemax.jpa.util.IDCardUtil;
import com.ninemax.jpa.util.UserPropertiesData;
import com.ninemax.jpa.util.clsPageComponent;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yanzh
 */
public class StatisticsAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(StatisticsAction.class);
    private static final String path = "/product/jsp/statistics/";
    private Map<String, Object> session;
    private String currentPath;
    private String fileName;
    private String message;
    private String title;
    private String source;
    private TJgdm jgdm;
    private TJgdm jgdm2;
    private String dmStatus;
    private List<TJgdm> jgdms;
    private List<Ttable> ttables;
    private Page page;

    private String sqlwhere;
    private String order;
    private Integer year;
    private Integer month;
    private Integer day;
    private String columnName;
    private Map<String, List<Model>> modelMaps;
    private Map<String, Map> mapMap;
    private List<Model> models;
    private List<Field> fields;
    private List<TBgk> bgks;
    private TBgk bgk;
    private TBgk bgk2;
    private String sns;
    private Date startDate;
    private Date endDate;

    private String database;
    private String ywlx;
    private Boolean type;
    private String json;

    private String zsbh;
    Map<String, String> bzjgdmMap;
    
    private TZrxzqhBus zrxzqhBus;
    
    private List<TFzr> listFzr;
    private TJgdmSaveBus saveBus;
    private String jglx;
    
    
    //20170704  lvwei   ---start---
    private String tyshxydm;
    private String memo1;
    private String jgmc;
    private String xzqh;
    
    private String tyshxydm_new;
    

    public String getTyshxydm_new() {
		return tyshxydm_new;
	}

	public void setTyshxydm_new(String tyshxydm_new) {
		this.tyshxydm_new = tyshxydm_new;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getTyshxydm() {
		return tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	//20170704  lvwei   ---end---

	/**
     *  add by ZSL 20160917
     */
    private Integer rowNumsView = 20;
    private Integer pageno = 1;
    private clsPageComponent pages;
    private List<TJgdm> tjgdms;
    //接收改变状态参数
    private String arr;
    

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
    }
    public List<TJgdm> getTjgdms() {
        return tjgdms;
    }

    public void setTjgdms(List<TJgdm> tjgdms) {
        this.tjgdms = tjgdms;
    }
    
    public StatisticsAction() {
    	if(saveBus==null){
    		 saveBus = new TJgdmSaveBus();
    	}
    	zrxzqhBus=new TZrxzqhBus();
    	 
    }
    

    public Integer getRowNumsView() {
		return rowNumsView;
	}

	public void setRowNumsView(Integer rowNumsView) {
		this.rowNumsView = rowNumsView;
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public String search() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                excutec(em);


            }
        }.template();
    }

    private void excutec(EntityManager em) { 
    	/*if ("bydate".equals(source)) {
            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据查询");
            setSource("_date");
            currentPath = path + "search_date.jsp";
        }*/
        if ("bydm".equals(source)) {
            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 按代码查询");
            setSource("_dm");
            currentPath = path + "search_dm.jsp";
        }
        if ("bymc".equals(source)) {
            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 按名称查询");
            setSource("_mc");
          	User user = (User) session.get("sysUser");
        	bzjgdmMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            if (obj1 == null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    }
            );
            Pattern p = Pattern.compile("(.*[1-9]+)");
            Matcher m = p.matcher(user.getBzjgdm());
            String filter = m.find() ? m.group() : user.getBzjgdm();
            //去除代码限制
            for (Map.Entry<String, String> entry : InitSysParams.bzjgdmMap.entrySet()) {
                //if (entry.getKey().startsWith(filter)) {
                	bzjgdmMap.put(entry.getKey(), entry.getValue());
                //}
            }
            currentPath = path + "search_mc.jsp";
        }
        if ("multitype".equals(source)) {
            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 多条件查询");
            setSource("_multi");
            ttables = em.createQuery("select model from Ttable model  order by model.sn").getResultList();
/*            ttables = em.createQuery("select model from Ttable model where model.tablecode=:tablecode order by model.sn")
            .setParameter("tablecode", "t_jgdm").getResultList();
*/            fields = new ArrayList<Field>();
            for (Ttable ttable : ttables) {
                fields.add(new Field(ttable.getColumncode(), ttable.getColumnname(), false));
            }
            currentPath = path + "search_multi.jsp";
        }
        if ("export".equals(source)) {
            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 ");
            setSource("_multi");
            ttables = em.createQuery("select model from Ttable model where (model.tablecode=:tablecode or model.tablecode='t_fzdm') and type != '0' order by model.sn")
                    .setParameter("tablecode", "t_jgdm").getResultList();
            fields = new ArrayList<Field>();
            for (Ttable ttable : ttables) { 
                fields.add(new Field(ttable.getColumncode(), ttable.getColumnname(), false));
            }
            currentPath = path + "export_search.jsp";
        }
        if ("import".equals(source)) {
            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导入 ");
            setSource("_multi");
            ttables = em.createQuery("select model from Ttable model where (model.tablecode=:tablecode or model.tablecode='t_fzdm') and type != '0' order by model.sn")
                    .setParameter("tablecode", "t_jgdm").getResultList();
            fields = new ArrayList<Field>();
            for (Ttable ttable : ttables) { 
                fields.add(new Field(ttable.getColumncode(), ttable.getColumnname(), false));
            }
            currentPath = path + "import_search.jsp";
        }
    }
    //按照日期区间查询   add by ZSL 20160917 
    public String show_date_original() {
   	 currentPath = path + "search_date.jsp";
      
        if (pages == null) {
            pages = new clsPageComponent();
        }
        if (pages.getOrderbyColum() != null && !"".equals(pages.getOrderbyColum())) {

        } else {
            pages.setOrderbyColum("bzrq");
            pages.setOrderbyMethod("desc");
        }


        tjgdms = new ArrayList<TJgdm>();
    /*    request.setAttribute("pages", pages);
        request.setAttribute("tjgdms",tjgdms);
        request.setAttribute("hello", "hello");*/
        return this.SUCCESS;
	}
    
    public String show_date() {
    	 currentPath = path + "search_date.jsp";
       
         if (pages == null) {
             pages = new clsPageComponent();
         }
         if (pages.getOrderbyColum() != null && !"".equals(pages.getOrderbyColum())) {

         } else {
             pages.setOrderbyColum("bzrq");
             pages.setOrderbyMethod("desc");
         }
         User user = (User) session.get("sysUser");
         String userName=user.getUserName();


         tjgdms = saveBus.jgsjPage(userName,startDate,endDate,rowNumsView,pageno,pages);
         return this.SUCCESS;
	}
    public void change_status(){
    	if(arr!=null){
    		String [] tyshxydm=arr.split(",");
        	String message=saveBus.changeStatus(tyshxydm);
    	}
    }

    
	public String show_dm() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());
				// 机构代码表

				if(dm!=null){
					jglx=dm.getJglx();
					jgdm = dm;
				}
				
				setMessage("代码主表");
				em.clear();
                //机构代码表
                if (dm == null) {
                    if (database != null && database.equals(TJgdmSave.class.getName())) {
                        TJgdmSave dmsave = em.find(TJgdmSave.class, Integer.valueOf(jgdm.getJgdm().trim()));
                        if (dmsave != null) {
                            setMessage("代码临时表");
                            BeanUtilsEx.copyProperties(jgdm, dmsave);
                            setDmStatus("临时表");
                            setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 代码详细");
                            jglx=jgdm.getJglx();
                        }
                        currentPath = path + "show.jsp";
                        return;
                    }
                    //机构代码临时表
                    TFzdm fzdm = null;
                    fzdm = em.find(TFzdm.class, jgdm.getTyshxydm());

                    //机构代码注销表
                    if (fzdm != null){
                        setMessage("代码注销表");
                        BeanUtilsEx.copyProperties(jgdm, fzdm);
                        if(fzdm.getFzrq()!=null){
                        	
                        	jgdm.setMemo2(DateUtil.dateToStr(fzdm.getFzrq(), "yyyy-MM-dd"));
                        }
                        setDmStatus(DateUtil.dateToStr(fzdm.getFzrq()));
                        jglx=jgdm.getJglx();
                    }else{
                    	
                    	currentPath = path + "search_dm.jsp";
                    	message="查无数据！";
                    	return;
                    }

                    
                }
                
                listFzr= saveBus.fzrList(jgdm.getTyshxydm());
                
				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 代码详细");
				currentPath = path + "show.jsp";
			}
		}.template();
	}

    /**
     * 按照名称查询机构代码
     *
     * @return
     */
    public String show_mc() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
            	
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("desc");
                }
                TJgdm dm = new TJgdm();
                if (TJgdm.class.getName().equals(database)) {
                    jgdms = getList();
                    page.setTotalRecord(getCount());
                    setMessage("机构代码表");
                } else if (TFzdm.class.getName().equals(database)) {
                    List<TFzdm> fzdms = getList();
                    page.setTotalRecord(getCount());
                    setMessage("代码注销表");
                    jgdms = new ArrayList<TJgdm>();
                    for (TFzdm bgk : fzdms) {
                        dm = new TJgdm();
                        BeanUtilsEx.copyProperties(dm, bgk);
                        //dm.setFzrq(bgk.getFzrq());
                        jgdms.add(dm);
                    }
                } else if (TBgk.class.getName().equals(database)) {
                    //机构代码注销表
                    List<TBgk> bgks = null;
                    bgks = getList();
                    page.setTotalRecord(getCount());
                    setMessage("代码当日变更表");
                    jgdms = new ArrayList<TJgdm>();
                    for (TBgk bgk : bgks) {
                        dm = new TJgdm();
                        BeanUtilsEx.copyProperties(dm, bgk);
                        dm.setLry(bgk.getLry());
                        jgdms.add(dm);
                    }
                }
                
                setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 按名称查询");
                currentPath = path + "list_mc.jsp";
                setSource("show_mc");

            }

            private int getCount() {
            	User user = (User) session.get("sysUser"); 
                String sql = "select  count (model) from " + database + " model  where  model.jgmc like '%" + jgdm.getJgmc() + "%' " ;
                if(jgdm.getBzjgdm()!=null&&!jgdm.getBzjgdm().equals("")){
            	   sql+= "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
               }
                        //((jgdm.getBzjgdm() == null || jgdm.getBzjgdm().equals("*")) ? "" : " and  model.bzjgdm='" + jgdm.getBzjgdm() + "' ");
                return ((Long) em.createQuery(sql).getResultList().get(0)).intValue();
            }
 
            private List getList() {
            	User user = (User) session.get("sysUser");
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "select model from " + database + " model  where  model.jgmc like '%" + jgdm.getJgmc() + "%' " ;
                if(jgdm.getBzjgdm()!=null&&!jgdm.getBzjgdm().equals("")){
             	   sql+= "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
                }
                         sql+= orderBy; 
                return em.createQuery(sql)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
            }
        }.template();
    }

    /**
     * 多条件查询
     *
     * @return
     */
    public String show_multi() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 多条件查询");
                setSource("show_multi");
                String bzjgdm = user.getBzjgdm().trim();
                if (user.getBzjgdm().trim().endsWith("0000")) {
                    bzjgdm = user.getBzjgdm().trim().substring(0, 2);
                } else if (user.getBzjgdm().trim().endsWith("00")) {
                    bzjgdm = user.getBzjgdm().trim().substring(0, 4);
                }
                if (database != null && !"".equals(database)) {
                    if (page == null)
                        page = new Page();
                    try {
                        sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll("&lt;", "<");
                        List list=null;
                        
                        if("admin".equals(user.getUserName())){
                        	list = em.createQuery("select model from " + database + " model  "
                        			+ " where " + sqlwhere + order)
                                    .setFirstResult(page.getStartRecord())
                                    .setMaxResults(page.getPageSize())
                                    .getResultList();
                        }else{
                        	list = em.createQuery("select model from " + database + " model  "
                        			+ " where  model.bzjgdm like ('" + bzjgdm + "%')  "
                        			+ " and (" + sqlwhere + ") " + order)
                        			.setFirstResult(page.getStartRecord())
                        			.setMaxResults(page.getPageSize())
                        			.getResultList();
                        }
                        
                        
                        
                        List<Map<Object, Object>> dataMaps = new ArrayList<Map<Object, Object>>();
                        for (Object obj : list) {
                            dataMaps.add(BeanUtilsEx.describe(obj));
                        }
                        for (Field field : fields) {
                            if (field != null && field.isSelect()) {
                                page.makeShowAttribute(field.getDm(), field.getName(), Page.AttributeType.show);
                            }

                        }
                        page.setDataMaps(dataMaps);
                        if("admin".equals(user.getUserName())){
                        	page.setTotalRecord(((Long) em.createQuery("select count(model)  from " + database + " model  where " + sqlwhere)
                                    .getResultList().get(0)).intValue());
                        }else{
                        	page.setTotalRecord(((Long) em.createQuery("select count(model)  from " + database + " model  where model.bzjgdm like ('" + bzjgdm + "%') and (" + sqlwhere+")")
                        			.getResultList().get(0)).intValue());
                        }
                    } catch (Exception e) {
                        log.error(StatisticsAction.class, e);
                        setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 多条件查询");
                        setSource("_multi");
                        setMessage("输入的查询语句有问题请重新输入！");
                        ttables = em.createQuery("select model from Ttable model where model.tablecode=:tablecode or model.tablecode='t_fzdm' order by model.sn")
                                .setParameter("tablecode", "t_jgdm").getResultList();
                        fields = new ArrayList<Field>();
                        for (Ttable ttable : ttables) {
                            fields.add(new Field(ttable.getColumncode(), ttable.getColumnname(), false));
                        }
                        currentPath = path + "search_multi.jsp";
                        return;
                    }
                }
                currentPath = path + "list.jsp";
            }
        }.nSyTemplate();
    }

    
    
    private File xls ;
	private String xlsFileName ;
	private String xlsContentType ;


	public File getXls() {
		return xls;
	}
	public void setXls(File xls) {
		this.xls = xls;
	}
	public String getXlsFileName() {
		return xlsFileName;
	}
	public void setXlsFileName(String xlsFileName) {
		this.xlsFileName = xlsFileName;
	}
	public String getXlsContentType() {
		return xlsContentType;
	}
	public void setXlsContentType(String xlsContentType) {
		this.xlsContentType = xlsContentType;
	}
	/**
	 * 删除注销表中的机构
	 * @return
	 */
	public String dm_delete(){
		return new ActionUtils() {
			
			@Override
			protected void excute() throws Exception {
				TFzdmBus tfzbus = new TFzdmBus();
				clsTjgdmDAO tjDao = new clsTjgdmDAO();
				/*TjgdmBus tbus = new TjgdmBus();
				clsTjgdmDAO tjDao = new clsTjgdmDAO();*/
				TFzdm tfzdm = tfzbus.findById(tyshxydm.trim());
				if(tfzdm == null){
					ServletActionContext.getRequest().setAttribute("mes", "查无此18位码的机构");
					currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";
					return;
				}
				String mes = new String();
				if(tjDao.deleteByDm(tyshxydm)){
					mes = "删除成功";
				}else{
					mes = "删除失败";
				}
				ServletActionContext.getRequest().setAttribute("mes", mes);
				currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";
			}
		}.nSyTemplate();
	}
    
	
	//lvwei 20170731 机构类型变更 -----start-------
	public String jglx_update_tyshxydm() {	
	        return new ActionUtils() {			
			@Override
			protected void excute() throws Exception {
				TjgdmBus tbus = new TjgdmBus();
				clsTjgdmDAO tjDao = new clsTjgdmDAO();
				
				TJgdm tjgdm = tbus.findById(tyshxydm.trim());
				
				if(tjgdm == null){
					ServletActionContext.getRequest().setAttribute("mes", "查无此18位码的机构");
					currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";
					return;
				}
				
				StringBuffer sb = new StringBuffer(tyshxydm.trim().substring(0, 17));
				sb.replace(1, 2, jglx);
				String new_tyshxydm =getCheckCode(sb.toString());

				tjgdm.setTyshxydm(new_tyshxydm);
				tjgdm.setJglx(jglx);	
				tbus.updateTjgdm(tjgdm);
				tjDao.deleteByTyshxydm(tyshxydm);	
				
				String mes = new String();
				
				if(tbus.updateTjgdm(tjgdm)){			
					mes = "修改成功";          
				}else{
					mes = "修改失败";
				}
				ServletActionContext.getRequest().setAttribute("mes", mes);
				currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";				
			}
		 }.nSyTemplate();		 
	}
	//lvwei 20170731 机构类型变更 -----end-------
	
	
	//lvwei 20170726 强制修改中机构删除 -----start-------
	public String delete_by_tyshxydm() {	
        return new ActionUtils() {			
		@Override
		protected void excute() throws Exception {
			clsTjgdmDAO tjDao = new clsTjgdmDAO();			
			boolean res = tjDao.deleteByTyshxydm(tyshxydm);			
			String mes = new String();
			
			if(res){			
				mes = "修改成功";          
			}else{
				mes = "修改失败";
			}
			ServletActionContext.getRequest().setAttribute("mes", mes);
			currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";			
		}
        }.nSyTemplate();		 
	}
	//lvwei 20170726 强制修改中机构删除 -----end-------
	
	//lvwei 20170801 审核 -----start-------
		public String jg_shenhe() {	
	        return new ActionUtils() {			
			@Override
			protected void excute() throws Exception {
				clsTjgdmDAO tjDao = new clsTjgdmDAO();			
				boolean res = tjDao.shenheByXzqh(xzqh);			
				String mes = new String();				
				if(res){			
					mes = "审核成功";          
				}else{
					mes = "审核失败";
				}
				ServletActionContext.getRequest().setAttribute("mes", mes);
				currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";				
			}
	        }.nSyTemplate();		 
		}
		//lvwei 20170801 审核 -----end-------
	
		//lvwei 20170801 换码 -----start-------
				public String dm_update() {	
			        return new ActionUtils() {			
					@Override
					protected void excute() throws Exception {
						TjgdmBus tbus = new TjgdmBus();
						String mes = new String();	
						clsTjgdmDAO tjDao = new clsTjgdmDAO();
						if(tbus.findById(tyshxydm)==null){
							ServletActionContext.getRequest().setAttribute("mes", "修改失败,库中没有这个码");
							currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";
							return;
						}
						
						if(!(tyshxydm_new.trim()).equals(getCheckCode(tyshxydm_new.trim().substring(0, 17)))){
							ServletActionContext.getRequest().setAttribute("mes", "修改失败,修改为的18位码不合法");
							currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";	
							return;
						}
						boolean res = tjDao.dmUpdate(tyshxydm, tyshxydm_new);			
			
						if(res){			
							mes = "修改成功";          
						}else{
							mes = "修改失败";
						}
						ServletActionContext.getRequest().setAttribute("mes", mes);
						currentPath = "/product/jsp/commonTools/standard_update_manage.jsp";				
					}
			        }.nSyTemplate();		 
				}
				//lvwei 20170801 换码 -----end-------
	
	
	
	/***
     * 批量数据导入
     * xiaruibo 20170511
     * 
     */
	
	public String import_search() {
        return new ActionUtils() {
			@SuppressWarnings("all")
			@Override
            protected void excute() throws Exception {
				System.out.println("导入excel数据开始："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
            	Workbook book = null;  
            	int count = 0;
        		try {
        			book = Workbook.getWorkbook(xls);	//创建一个新的写入工作簿
            		Sheet sheet = book.getSheet(0);		//获取Excel文件中第一个表Sheet1
            		int totalRows =sheet.getRows();		//获取总行数
            		int totalColumns =sheet.getColumns();		//获取总列数
            		Cell[] cell = sheet.getRow(0);  
//                    if(totalColumns<=0){  
//                        return ;  
//                    } 
                		
                    //读取第一行作为Map中的key  
                    List tableHeaderlist = new ArrayList();  
                    try{
                    	
                    for (int i = 0; i < totalColumns; i++) {  
//                      tableHeaderlist.add(cell[i].getContents());  不加所有字段了
                        if("统一社会信用代码".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("tyshxydm");
                        }else if("社会组织名称".equals(cell[i].getContents().toString().trim())||"名称".equals(cell[i].getContents().toString().trim())||"机构名称".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("jgmc");
                        }else if("法定代表人".equals(cell[i].getContents().toString().trim())||"负责人".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("fddbr");
                        }else if("法定代表人证件类型".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("zjlx");
                        }else if("法定代表人证件号码".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("zjhm");
                        }else if("成立日期".equals(cell[i].getContents().toString().trim())||"注册日期".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("zcrq");
                        }else if("住所".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("jgdz");
                        }else if("状态".equals(cell[i].getContents().toString().trim())){
                        	//因为数据库里没有这个字段，暂时随便添加一个key，往TJgdm里set值的时候不添加就可以了
                        	tableHeaderlist.add("zt");
                        }else if("登记证号".equals(cell[i].getContents().toString().trim())||"注册号".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("zch");
                        }else if("登记业务类型".equals(cell[i].getContents().toString().trim())){
                        	//因为数据库里没有这个字段，暂时随便添加一个key，往TJgdm里set值的时候不添加就可以了
                        	tableHeaderlist.add("ywlx");
                        }else if("最后更新日期".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("bgrq");
                        }else if("业务范围".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("jyfw");
                        }else if("注册资金".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("zczj");
                        }else if("发证机关".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("pzjgmc");
                        }else if("证书有效期限(始)".equals(cell[i].getContents().toString().trim())||"证书有效期限（始）".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("yxqxs");
                        }else if("证书有效期限(至)".equals(cell[i].getContents().toString().trim())||"证书有效期限（至）".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("yxqxe");
                        }else if("职工人数".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("lssl");
                        }else if("业务主管单位".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("zgmc");
                        }else if("慈善组织认定/登记日期".equals(cell[i].getContents().toString().trim())){
                        	//因为数据库里没有这个字段，暂时随便添加一个key，往TJgdm里set值的时候不添加就可以了
                        	tableHeaderlist.add("csrdrq");
                        }else if("慈善组织公开募捐资格获得日期".equals(cell[i].getContents().toString().trim())){
                        	//因为数据库里没有这个字段，暂时随便添加一个key，往TJgdm里set值的时候不添加就可以了
                        	tableHeaderlist.add("mjrdrq");
                        }else if("电话号码".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("dhhm");
                        }else if("经办人姓名".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("tbrxm");
                        }else if("经办人证件类型".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("tbrzjlx");
                        }else if("经办人证件号码".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("tbrsfzh");
                        }else if("经办人联系电话".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("tbrmobile");
                        }else if("行政区划".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("xzqh");
                        }else if("邮政编码".equals(cell[i].getContents().toString().trim())){
                        	tableHeaderlist.add("yzbm");
                        }else if("".equals(cell[i].getContents().toString().trim())){
                        	break;
                        }
                    } 
                    }catch (Exception e){
                    	e.printStackTrace();
                    	ServletActionContext.getRequest().setAttribute("import_info", "上传excel格式有误,请核对修改后进行导入");
                    	currentPath = path + "import_result.jsp";
                    	return;
                    }
                    
                    
                    TJgdm tjgdm = new TJgdm();
                    TJgdm tjgdm1 = new TJgdm ();
                    TjgdmBus tbus = new TjgdmBus();
                    
                    //取出TJgdm表中所有tyshxydm主键存到Set集合里，来对比Excel表中是否有重复数据
                    ArrayList tydmListAll = (ArrayList) tbus.findAllTyshxydm("select tyshxydm from t_jgdm");
                    Set tydmSet = new HashSet(tydmListAll);
                    
                    
                    //取出TJgdm表中所有jgmc存到Set集合里，来对比Excel表中是否有重复数据
                    ArrayList jgmcListAll = (ArrayList) tbus.findAllJgmc("select jgmc from t_jgdm");
                    Set jgmcSet = new HashSet(jgmcListAll);
                    
                    
                    
                   
                    List<TJgdm>error_jg_list = new ArrayList();
                    if(tableHeaderlist.size()!=27){
                    	 ServletActionContext.getRequest().setAttribute("import_info", "上传excel格式有误,请检查首行标题是否符合要求,核对修改后再进行导入");
                    	 currentPath = path + "import_result.jsp";
                    	 return;
                    }
                  
                    //将每一行数据存为Map集合
                    Map<String, String> rowData = null;                   
                    for (int i = 1; i < totalRows; i++) {  //循环次数为总行数
                        cell = sheet.getRow(i);  //获取某一行的数据
                        rowData = new LinkedHashMap(totalColumns);  
                        for (int j = 0; j < totalColumns; j++) {  //在某一行中循环总列数
                            try {
                            	rowData.put(tableHeaderlist.get(j).toString().trim(), cell[j].getContents());  
							} catch (Exception e) {
								System.out.println(cell.length);
								System.out.println("size:"+tableHeaderlist.size());
								System.out.println("出错行："+i+"，出错列："+(j+1));
							}
                        }
                        //以下这些是Excel表里提供的字段
                        
                        try{
                        if("".equals(rowData.get("tyshxydm").trim())||"null".equals(rowData.get("tyshxydm"))||rowData.get("tyshxydm")==null||rowData.get("tyshxydm").trim().length()!=18){
                            TJgdm jg = new TJgdm();
                        	jg.setTyshxydm(rowData.get("tyshxydm"));
                        	jg.setJgmc(rowData.get("jgmc"));
                        	jg.setMemo1("统一社会信用代码为空或错误");//使用memo1来代表错误信息
                        	jg.setXzqh(rowData.get("xzqh"));
                        	error_jg_list.add(jg);
                        	continue;
                        }
                        if(!(rowData.get("tyshxydm").trim()).equals(getCheckCode(rowData.get("tyshxydm").trim().substring(0, 17)))){
                            TJgdm jg = new TJgdm();
                        	jg.setTyshxydm(rowData.get("tyshxydm"));
                        	jg.setJgmc(rowData.get("jgmc"));
                        	jg.setMemo1("统一社会信用代码为空或错误");//使用memo1来代表错误信息
                        	jg.setXzqh(rowData.get("xzqh"));
                        	error_jg_list.add(jg);
                        	continue;
                        }
                        
                        
                        if("".equals(rowData.get("jgmc").trim())||"null".equals(rowData.get("jgmc"))||rowData.get("jgmc")==null){
                            TJgdm jg = new TJgdm();
                        	jg.setTyshxydm(rowData.get("tyshxydm"));
                        	jg.setJgmc(rowData.get("jgmc"));
                        	jg.setMemo1("机构名称为空");//使用memo1来代表错误信息
                        	jg.setXzqh(rowData.get("xzqh"));
                        	error_jg_list.add(jg);
                        	continue;
                        }
                        
                        if("".equals(rowData.get("xzqh").trim())||"null".equals(rowData.get("xzqh"))||rowData.get("xzqh")==null||rowData.get("xzqh").trim().length()!=6){
                            TJgdm jg = new TJgdm();
                        	jg.setTyshxydm(rowData.get("tyshxydm"));
                        	jg.setJgmc(rowData.get("jgmc"));
                        	jg.setMemo1("行政区划为空或错误");//使用memo1来代表错误信息
                        	jg.setXzqh(rowData.get("xzqh"));
                        	error_jg_list.add(jg);
                        	continue;
                        }
                        }catch (Exception e){
                        	e.printStackTrace();
                        	ServletActionContext.getRequest().setAttribute("import_info", "上传excel格式有误,请核对修改后进行导入");
                        	currentPath = path + "import_result.jsp";
                        	return;
                        }
                        
                        
                    	tjgdm.setTyshxydm(rowData.get("tyshxydm").trim());
                        tjgdm.setJgmc(rowData.get("jgmc").trim());
                        tjgdm.setFddbr(rowData.get("fddbr").trim().length()<50?rowData.get("fddbr").trim():rowData.get("fddbr").trim().substring(0, 49));
                        tjgdm.setZjlx(zjlxToId(rowData.get("zjlx").trim()));
                        tjgdm.setZjhm(rowData.get("zjhm").trim().length()<21?rowData.get("zjhm").trim():rowData.get("zjhm").trim().substring(0, 20));
                        tjgdm.setZcrq(getDate(rowData.get("zcrq").trim()));	//将字符串转换日期格式
                        tjgdm.setJgdz(rowData.get("jgdz").trim().length()<120?rowData.get("jgdz").trim():rowData.get("jgdz").trim().substring(0, 119));
                        tjgdm.setJyzt(rowData.get("zt").trim().length()<25?rowData.get("zt").trim():rowData.get("zt").trim().substring(0, 24));                       
                        tjgdm.setZch(rowData.get("zch").trim().length()<35?rowData.get("zch").trim():rowData.get("zch").trim().substring(0, 34));
                        tjgdm.setYwlx(rowData.get("ywlx").trim().length()<50?rowData.get("ywlx").trim():rowData.get("ywlx").trim().substring(0, 49));
                        tjgdm.setBgrq(getDate(rowData.get("bgrq").trim()));
                        tjgdm.setJyfw(rowData.get("jyfw").length()<1000?rowData.get("jyfw"):rowData.get("jyfw").substring(0, 999));
                        tjgdm.setZczj(strToInt_zczj(rowData.get("zczj").trim()));
                        tjgdm.setPzjgmc(rowData.get("pzjgmc").trim().length()<100?rowData.get("pzjgmc").trim():rowData.get("pzjgmc").trim().substring(0, 99));
                        tjgdm.setYxqxs(getDate(rowData.get("yxqxs").trim()));
                        
                        tjgdm.setZfrq(getDate(rowData.get("yxqxe").trim()));
                        tjgdm.setLssl(strToInt_lssl(rowData.get("lssl").trim()));
                        tjgdm.setZgmc(rowData.get("zgmc").trim().length()<100?rowData.get("zgmc").trim():rowData.get("zgmc").trim().substring(0, 99));
                        tjgdm.setCsrdrq(getDate(rowData.get("csrdrq").trim()));	//将字符串转换日期格式
                        tjgdm.setMjrdrq(getDate(rowData.get("mjrdrq").trim()));	//将字符串转换日期格式
                        tjgdm.setDhhm(rowData.get("dhhm").trim().length()<12?rowData.get("dhhm").trim():rowData.get("dhhm").trim().substring(0, 11));
                        tjgdm.setTbrxm(rowData.get("tbrxm").trim().length()<30?rowData.get("tbrxm").trim():rowData.get("tbrxm").trim().substring(0, 29));
                        tjgdm.setTbrzjlx(zjlxToId(rowData.get("tbrzjlx").trim()));
                        tjgdm.setTbrsfzh(rowData.get("tbrsfzh").trim().length()<25?rowData.get("tbrsfzh").trim():rowData.get("tbrsfzh").trim().substring(0, 24));
                        tjgdm.setTbrmobile(rowData.get("tbrmobile").trim().length()<15?rowData.get("tbrmobile").trim():rowData.get("tbrmobile").trim().substring(0, 14));
                        tjgdm.setXzqh(rowData.get("xzqh").trim().length()<7?rowData.get("xzqh").trim():rowData.get("xzqh").trim().substring(0, 6));
                        tjgdm.setYzbm(rowData.get("yzbm").trim().length()<7?rowData.get("yzbm").trim():rowData.get("yzbm").trim().substring(0, 6));
                        
                        //以下这些是必填的字段及一些需要初始化的字段
                        tjgdm.setJglx(rowData.get("tyshxydm").trim().substring(1,2));
                        tjgdm.setJgdm(rowData.get("tyshxydm").trim().substring(8,17));
                        //原来的bzjgdm是从tyshxydm里的3-8位截取的，现在不截取了，直接用xzqh作为bzjgdm，这样谁导入的数据谁就可以查询到了
//                        tjgdm.setBzjgdm(rowData.get("tyshxydm").trim().substring(2,8));
                        tjgdm.setBzjgdm(rowData.get("xzqh").trim().length()<7?rowData.get("xzqh").trim():rowData.get("xzqh").trim().substring(0, 6));
                        
                        tjgdm.setDybz("2");//打印标记设置为2，不允许证书打印和变更登记，异构系统接口导入时设置的为3
//                        tjgdm.setDflag(0);	//数据上报标记，暂时屏蔽，数据导入后未办理业务不需要上报
                        tjgdm.setLastdrsj(new Date());  //最后导入时间,如果导入成功后并办理过业务时，该字段就变为NULL了，该字段只是用来查询导入excel的时间方便修改dybz等字段
                        
                        //xiaruibo 20180228 数据导入时，给业务类型(ywlx)，经营状态(jyzt)，交换接口保存类型(savetype)赋值
                        tjgdm.setYwlx("0");	//业务类型(ywlx)：0成立，1变更，2换证，3注销，4撤销，-1删除
                        tjgdm.setJyzt("1");  //机构状态(jyzt)：1正常(存续),2注销，3撤销，-1删除
                        tjgdm.setSavetype(0); //民政部数据交换保存类型：0未传送或者传送失败，1传送成功
                        tjgdm.setLastdate(new Date());
                        
                        if(tjgdm.getYxqxs()==null||"".equals(tjgdm.getYxqxs())){
                        	tjgdm.setBzrq(getDate("1900-01-01"));//如果有效期限始为空，就默认给发证日期设置一个值
                        }else{
                        	tjgdm.setBzrq(getDate(rowData.get("yxqxs").trim()));//证书有效期限始就是发证日期
                        }
                        
                        if(tydmSet.contains(rowData.get("tyshxydm").trim())){
                        	//tyshxydm如果在库中存在,并且lastdate为null的时候才替换
                        	tjgdm1 = tbus.findById(rowData.get("tyshxydm").trim());
                        	if("".equals(tjgdm1.getLastdate())||"null".equals(tjgdm1.getLastdate())||"NULL".equals(tjgdm1.getLastdate())||tjgdm1.getLastdate()==null){
                        		tbus.updateTjgdm(tjgdm);
                        		Boolean result2 = tbus.updateTjgdm(tjgdm);
                        		if(result2){
                        			count++;
                        		}
                        	}
                        	continue;
                        }

                        if(jgmcSet.contains(rowData.get("jgmc").trim())){
                            TJgdm jg = new TJgdm();
                        	jg.setTyshxydm(rowData.get("tyshxydm"));
                        	jg.setJgmc(rowData.get("jgmc"));
                        	jg.setMemo1("机构名称已经存在系统中");//使用memo1来代表错误信息
                        	jg.setXzqh(rowData.get("xzqh"));
                        	error_jg_list.add(jg);
                        	continue;
                        }
                       
                        try{
                        	int result = tbus.AddTjgdm(tjgdm); 
                        	if(result==1){
                        		count++;
                        	} 
                        }catch (Exception e){
                        	TJgdm jg = new TJgdm();
                        	jg.setTyshxydm(rowData.get("tyshxydm"));
                        	jg.setJgmc(rowData.get("jgmc"));
                        	jg.setMemo1("数据时间格式错误");//使用memo1来代表错误信息
                        	jg.setXzqh(rowData.get("xzqh"));
                        	error_jg_list.add(jg);
                        	continue;
                        }
                     
                    }  
                    book.close();// 关闭  
                    System.out.println("导入excel数据结束："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    System.out.println("总条数："+(totalRows-1)+"条");
                    System.out.println("导入成功："+count+"条");
                    System.out.println("导入失败："+(totalRows-1-count)+"条");
  
                    StringBuffer import_info = new StringBuffer();
                  
                    import_info.append("导入excel数据结束："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                    .append("&nbsp&nbsp&nbsp&nbsp&nbsp")
                    .append("总条数："+(totalRows-1)+"条")
                    .append("&nbsp&nbsp&nbsp&nbsp&nbsp")
                    .append("导入成功："+((totalRows-1)-error_jg_list.size())+"条")
                    .append("&nbsp&nbsp&nbsp&nbsp&nbsp")
                    .append("导入失败："+(error_jg_list.size())+"条");
              
                    ServletActionContext.getRequest().setAttribute("import_info", import_info);
                    ServletActionContext.getRequest().setAttribute("error_jg_list", error_jg_list);      
        		}
        		catch (Exception e) {
					e.printStackTrace();  
				}
        		
        		
            	//------------------------------------------------------------
                setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt; 导入结果");
                setSource("show_multi");
                if (database != null && !"".equals(database)) {
                    if (page == null)
                        page = new Page();
                    User user = (User) session.get("sysUser");
                    String bzjgdm = user.getBzjgdm().trim();

                    if (user.getBzjgdm().trim().endsWith("0000")) {
                        bzjgdm = user.getBzjgdm().trim().substring(0, 2);
                    } else if (user.getBzjgdm().trim().endsWith("00")) {
                        bzjgdm = user.getBzjgdm().trim().substring(0, 4);
                    }
                    try {
                        sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll("&lt;", "<");


                        List list = em.createQuery("select model from " + database + " model  where model.bzjgdm like '" + bzjgdm + "%' and " + sqlwhere + " " + order)
                                .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                                .getResultList();
                        List<Map<Object, Object>> dataMaps = new ArrayList<Map<Object, Object>>();
                        for (Object obj : list) {
                            dataMaps.add(BeanUtilsEx.describe(obj));
                        }
                        for (Field field : fields) {
                            if (field != null && field.isSelect()) {
                                page.makeShowAttribute(field.getDm(), field.getName(), Page.AttributeType.show);
                            }

                        }
                        page.setDataMaps(dataMaps);
                        page.setTotalRecord(((Long) em.createQuery("select count(model)  from " + database + " model  where model.bzjgdm like '" + bzjgdm + "%' and  " + sqlwhere)
                                .getResultList().get(0)).intValue());
                    } catch (Exception e) {
                        setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt;查询");
                        setSource("_multi");
                        setMessage("输入的查询语句有问题请重新输入！");
                        ttables = em.createQuery("select model from Ttable model where model.tablecode=:tablecode or model.tablecode='t_fzdm' order by model.sn")
                                .setParameter("tablecode", "t_jgdm").getResultList();
                        fields = new ArrayList<Field>();
                        for (Ttable ttable : ttables) {
                            fields.add(new Field(ttable.getColumncode(), ttable.getColumnname(), false));
                        }
                        currentPath = path + "export_search.jsp";
                        return;
                    }
                }
//                currentPath = path + "list_export.jsp";
                currentPath = path + "import_result.jsp";
            }
        }.nSyTemplate();
    }
	
	
	/**
	 * 验证18位统一代码是否正确
	 */
	public static String getCheckCode(String sCode) {
        sCode = sCode.toUpperCase();
       int[] wi = {1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28};
        
        String[] strKey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H",  "J", "K", "L",
                "M", "N",  "P", "Q", "R", "T","U" ,"W",  "X","Y","0"
                };
        int i, sum = 0;

        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                30,31};
        String strCheck = "";

        Map<String, Integer> hashData = null;
        hashData = new HashMap();
        // 将机构代码中的各个字母,及其相应的值放到hashtable中
        for (int j = 0; j < strKey.length; j++) {
            hashData.put(strKey[j], values[j]);
        }
        // 按照检验算法进行运算
        for (i = 0; i < 17; i++) {
            strCheck = sCode.substring(i, i + 1);
            sum = sum + wi[i] * hashData.get(strCheck);
        }
        System.out.println("sum1:"+sum);
        sum = 31 - sum % 31;

        System.out.println("sum2:"+sum);
        
        strCheck= sCode+ strKey[sum];
        System.out.println("前17位  ："+sCode);
        System.out.println("赋码结果："+strCheck);
        return strCheck;

    }
	
	
	/**
	 * 将证件类型转换成对应的标示值
	 * xiaruibo 20170517
	 * 
	 */
	public String zjlxToId(String str){
		
		String  zjlx = null;
		if("null".equals(str)||str==null||"".equals(str.trim())){
			zjlx = "";
		}else if("身份证".equals(str)){
			zjlx = "0";
		}else if("军人证".equals(str)){
			zjlx = "1";
		}else if("警官证".equals(str)){
			zjlx = "2";
		}else if("护照".equals(str)){
			zjlx = "3";
		}else if("回乡证".equals(str)){
			zjlx = "4";
		}else if("香港证".equals(str)){
			zjlx = "5";
		}else if("台湾证".equals(str)){
			zjlx = "6";
		}else if("澳门证".equals(str)){
			zjlx = "7";
		}else if("外国ID".equals(str)){
			zjlx = "8";
		}else if("退休证".equals(str)){
			zjlx = "9";
		}else if("离休证".equals(str)){
			zjlx = "A";
		}else if("通行证".equals(str)){
			zjlx = "B";
		}else{
			zjlx = "C";
		}
		return zjlx;
		
	}
	
	/*public static void main(String[] args) {
		
		System.out.println(getDate("207.05.1"));
	}*/
	/**
	 * 将字符串转换成日期格式
	 * xiaruibo 20170517
	 * 
	 */
	public static Date getDate(String str){
		Date date=null;
		try {
			if("null".equals(str)||str==null||"".equals(str.trim())||(str.trim().length()!=10&&str.trim().length()!=9&&str.trim().length()!=8)){
				return null;
			}else{
				String res=str.trim().replace("年","-").replace("月", "-").replace("日", "").replace("/", "-").replace("//", "-").replace("///", "-").replace(".", "-").replace("..", "-").replace("...", "-").replace("、", "-").replace("O", "0");
				String[]riqi = res.split("-");
				if(riqi.length == 3&&(riqi[0].length()==1||riqi[0].length()==2)){
						StringBuffer sb = new StringBuffer();
						sb.append(riqi[2]).append("-").append(riqi[1]).append("-").append(riqi[0]);	
						res = sb.toString();
				}
				date=DateUtil.strToDate(res);
			}
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("日期格式错误");
			return null;
		}
	}
	/**
	 * 将字符串转换成Int格式
	 * xiaruibo 20170517
	 * 
	 */
	public int strToInt_lssl(String str){
		
		int i = 0;
		try {
			if("null".equals(str)||str==null||"".equals(str.trim())){
				return i;
			}else{
				str = Pattern.compile("[^0-9]").matcher(str).replaceAll("");
				if(str==null||"".equals(str.trim())){
					return i;
				}
				return Integer.parseInt(str);
			}
		} catch (Exception e) {
			System.out.println("理事人数格式错误");
			return i;
		}
		
	}
	/**
	 * 将字符串转换成Double格式
	 * xiaruibo 20170517
	 * 
	 */
	public double strToInt_zczj(String str){
		double i = 0;
		try {
			
			if("null".equals(str)||str==null||"".equals(str.trim())){
				return i;
			}else{
				str = Pattern.compile("[^0-9./]").matcher(str).replaceAll("");
				if(str==null||"".equals(str.trim())){
					return i;
				}
				return Double.parseDouble(str);
			}
		} catch (Exception e) {
			System.out.println("注册资金格式错误");
			return i;
		}
		
	}
	
	
	
	
	
    /**
     * 多条件查询
     *
     * @return
     */
    public String export_search() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt; 查询列表");
                setSource("show_multi");
                if (database != null && !"".equals(database)) {
                    if (page == null)
                        page = new Page();
                    User user = (User) session.get("sysUser");
                    String bzjgdm = user.getBzjgdm().trim();
                    //xiaruibo 20170623 如果bzjgdm为100000，国家级，不需要条件
                    if (user.getBzjgdm().trim().endsWith("100000")) {
                        bzjgdm = "";
                    } else if (user.getBzjgdm().trim().endsWith("0000")) {
                        bzjgdm = user.getBzjgdm().trim().substring(0, 2);
                    } else if (user.getBzjgdm().trim().endsWith("00")) {
                        bzjgdm = user.getBzjgdm().trim().substring(0, 4);
                    }
                    try {
                        sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll("&lt;", "<");


                        List list = em.createQuery("select model from " + database + " model  where model.bzjgdm like '" + bzjgdm + "%' and " + sqlwhere + " " + order)
                                .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                                .getResultList();
                        List<Map<Object, Object>> dataMaps = new ArrayList<Map<Object, Object>>();
                        for (Object obj : list) {
                            dataMaps.add(BeanUtilsEx.describe(obj));
                        }
                        for (Field field : fields) {
                            if (field != null && field.isSelect()) {
                                page.makeShowAttribute(field.getDm(), field.getName(), Page.AttributeType.show);
                            }

                        }
                        page.setDataMaps(dataMaps);
                        page.setTotalRecord(((Long) em.createQuery("select count(model)  from " + database + " model  where model.bzjgdm like '" + bzjgdm + "%' and  " + sqlwhere)
                                .getResultList().get(0)).intValue());
                    } catch (Exception e) {
                        setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt;查询");
                        setSource("_multi");
                        setMessage("输入的查询语句有问题请重新输入！");
                        ttables = em.createQuery("select model from Ttable model where model.tablecode=:tablecode or model.tablecode='t_fzdm' order by model.sn")
                                .setParameter("tablecode", "t_jgdm").getResultList();
                        fields = new ArrayList<Field>();
                        for (Ttable ttable : ttables) {
                            fields.add(new Field(ttable.getColumncode(), ttable.getColumnname(), false));
                        }
                        currentPath = path + "export_search.jsp";
                        return;
                    }
                }
                currentPath = path + "list_export.jsp";
            }
        }.nSyTemplate();
    }

    public String export() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (database != null && !"".equals(database)) {
                    String bzjgdm;
                    User user = (User) session.get("sysUser");
                   //xiaruibo 20170623 如果bzjgdm为100000，国家级，不需要条件
                    if (user.getBzjgdm().trim().endsWith("100000")) {
                        bzjgdm = "";
                    } else if (user.getBzjgdm().trim().endsWith("0000")) {
                        bzjgdm = user.getBzjgdm().trim().substring(0, 2);
                    } else if (user.getBzjgdm().trim().endsWith("00")) {
                        bzjgdm = user.getBzjgdm().trim().substring(0, 4);
                    } else {
                        bzjgdm = user.getBzjgdm().trim();
                    }
                    fileName = getUName();
                    sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll("&lt;", "<");
                    
                    System.out.println("+++++++++++++++++++++++++=="+UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fileName);
                    
                    if (ExcelUtils.export(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fileName, database, bzjgdm, sqlwhere, fields)) {
                        setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt; 下载");
                        currentPath = path + "download.jsp";
                        return;
                    }
                }
                setMessage("系统异常，请联系管理员！");
                currentPath = path + "download.jsp";
            }

        }.nSyTemplate();
    }
    

	public String export2() {		
		return new ActionUtils() {		
			@Override
			protected void excute() throws Exception {
	
				String[] tyshxydmArray =tyshxydm.split(",");
				String[] jgmcArray =jgmc.split(",");
				String[] memo1Array =memo1.split(",");
				String[] xzqhArray = xzqh.split(",");
				
				List<TJgdm> error_jg_list = new ArrayList();;
				
				for(int i = 0;i<jgmcArray.length;i++){
					TJgdm t = new TJgdm();
					t.setTyshxydm(tyshxydmArray[i]);
					t.setJgmc(jgmcArray[i]);
					t.setMemo1(memo1Array[i]);
					t.setXzqh(xzqhArray[i]);
					error_jg_list.add(t);
				}
				System.out.println(tyshxydmArray);
					
		    	if(!(error_jg_list == null)&& !"".equals(error_jg_list)){   		
		    		
		    		List<Field>fields = new ArrayList<Field>();
		    		fields.add(new Field("tyshxydm", "统一社会信用代码", true));
		    		fields.add(new Field("jgmc", "机构名称", true));
		    		fields.add(new Field("xzqh", "行政区划", true));
		    		fields.add(new Field("memo1", "错误原因", true));
		    		
		    		String fileName = getUName();
		    		
		    		ServletActionContext.getRequest().setAttribute("fileName", fileName);
		    		
		    		if (ExcelUtils.export(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fileName,error_jg_list , fields)) {
		        		setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt; 下载");
		                currentPath = path + "download.jsp";
		                return;
		            }
		    	}		     	
		    	setMessage("系统异常，请联系管理员！");
		        currentPath = path + "download.jsp";
			}
		}.nSyTemplate();  
    }

  
    public String download() {

        try {
            File file = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fileName);
            HttpServletResponse response = ServletActionContext.getResponse();
            OutputStream outputStream = null;
            outputStream = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);// 设定输出文件头
            response.setContentType("application/vnd.ms-excel; charset=GB2312");// 定义输出类型
            FileInputStream inputStream = new FileInputStream(file);
            response.setContentLength(Long.valueOf(file.length()).intValue());
            byte[] chars = new byte[4096];
            int len;
            while ((len = inputStream.read(chars)) != -1) {
                outputStream.write(chars, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            file.delete();
        } catch (IOException e) {
            log.error(StatisticsAction.class, e);
        }
        return null;
    }

    /**
     * 新办卡量，查询
     *
     * @return
     */
    public String list_kxxk() {
        return new ActionUtils(session) {


            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("njrq");
                    page.setOrderByType("desc");
                }
                if (startDate == null)
                    startDate = DateUtil.getFormatedDate(DateUtil.dateToStr(new Date()));
                if (endDate == null)
                    endDate = DateUtil.dayAfter(new Date(), 1);
                String sql = " from TJgdm model where model.jgdm in(select distinct kxxk.jgdm from TkKxxk kxxk where kxxk.haveDown='0' and kxxk.sqsj between ?1 and ?2 ) and bzjgdm =?3";
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by jgdm." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                jgdms = em.createQuery("select model " + sql + orderBy).setParameter(1, startDate).setParameter(2, endDate).setParameter(3, getUser().getBzjgdm())
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize()).getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).setParameter(1, startDate).setParameter(2, endDate).setParameter(3, getUser().getBzjgdm())
                        .getResultList().get(0)).intValue());
                currentPath = path + "list_kxxk.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 历史记录查询
     *
     * @return
     */
    public String list_frs() {
        return new ActionUtils() {


            @Override
            protected void excute() throws Exception {
                currentPath = path + "list_frs.jsp";
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String where = " ";
                if (jgdm != null) {
                    if (jgdm.getFddbr() != null && !"".equals(jgdm.getFddbr())) {
                        where += " and model.fddbr='" + jgdm.getFddbr() + "' ";
                    }
                    if (jgdm.getZjhm() != null && !"".equals(jgdm.getZjhm())) {
                        String card = jgdm.getFddbr().trim();
                        if (card.length() == 18)
                            card = IDCardUtil.from18to15(card);
                        if (card.length() == 15)
                            card = IDCardUtil.from15to18(19, card);
                        where += " and ( model.zjhm='" + jgdm.getFddbr().trim() + "' or model.zjhm='" + card + "' )";
                    }
                }
                if ("".equals(where.trim())) {
                    return;
                }

                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by jgdm." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                jgdms = em.createQuery("select model from TJgdm  model   where 1=1   " + where + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();

                int count = ((Long) em.createQuery("select count(model)   from TJgdm model where 1=1  " + where)
                        .getResultList().get(0)).intValue();
                List<TQzjgdm> qzjgdms = null;
                if (jgdms.size() != 0 && jgdms.size() < page.getPageSize()) {
                    qzjgdms = em.createQuery("select model from TQzjgdm  model where model.qzbz <> '2' " + where + orderBy)
                            .setFirstResult(jgdms.size()).setMaxResults(page.getPageSize() - jgdms.size()).getResultList();
                } else if (jgdms.size() == 0) {
                    qzjgdms = em.createQuery("select model from TQzjgdm  model where model.qzbz <> '2' " + where + orderBy)
                            .setFirstResult(page.getStartRecord() - count).setMaxResults(page.getPageSize() - jgdms.size()).getResultList();
                }
                if (qzjgdms != null) {
                    for (TQzjgdm qzjgdm : qzjgdms) {
                        TJgdm jgdm = new TJgdm();
                        BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                        jgdms.add(jgdm);
                    }
                }

                count += ((Long) em.createQuery("select count(model)   from TQzjgdm  model where model.qzbz <> '2' " + where)
                        .getResultList().get(0)).intValue();
                page.setTotalRecord(count);
            }
        }.nSyTemplate();
    }

    public String show_frs() {
        return new ActionUtils() {


            @Override
            protected void excute() throws Exception {
                if (sns != null && !"".equals(sns)) {
                    String[] sn = sns.split(",");
                    if (sn.length >= 1) {
                        jgdm = em.find(TJgdm.class, sn[0].trim());
                        if (jgdm == null) {
                            List<TQzjgdm> qzjgdm = em.createQuery("select model from TQzjgdm model where model.jgdm=?1").setParameter(1, sn[0].trim()).getResultList();
                            jgdm = new TJgdm();
                            if (!qzjgdm.isEmpty())
                                BeanUtilsEx.copyProperties(jgdm, qzjgdm.get(0));
                        }

                    }
                    if (sn.length >= 2) {
                        jgdm2 = em.find(TJgdm.class, sn[1].trim());
                        if (jgdm2 == null) {
                            List<TQzjgdm> qzjgdm = em.createQuery("select model from TQzjgdm model where model.jgdm=?1").setParameter(1, sn[1].trim()).getResultList();
                            jgdm2 = new TJgdm();
                            if (!qzjgdm.isEmpty())
                                BeanUtilsEx.copyProperties(jgdm2, qzjgdm.get(0));
                        }
                    } else {
                        currentPath = path + "show_fr.jsp";
                        return;
                    }
                    currentPath = path + "show_frs.jsp";

                }

            }
        }.nSyTemplate();
    }

    /**
     * 历史记录查询
     *
     * @return
     */
    public String list_bgks() {
        return new ActionUtils() {


            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by jgdm." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                bgks = em.createQuery("select model from TBgk model " + ((jgdm != null && jgdm.getJgdm() != null && !"".equals(jgdm.getJgdm())) ? " where model.jgdm like '%" + jgdm.getJgdm() + "%' " : "") + orderBy).getResultList();
                currentPath = path + "list_bgks.jsp";
            }
        }.nSyTemplate();
    }

    public String show_diff() {
        return new ActionUtils() {


            @Override
            protected void excute() throws Exception {
                if (sns != null && !"".equals(sns)) {
                    String[] sn = sns.split(",");
                    if (sn.length >= 1) {
                        if (sn[0].trim().length() == 9) {
                            jgdm = em.find(TJgdm.class, sn[0].trim());
                            bgk = new TBgk();
                            BeanUtilsEx.copyProperties(bgk, jgdm);
                        } else {
                            bgk = em.find(TBgk.class, Long.valueOf(sn[0]));
                            jgdm = new TJgdm();
                            BeanUtilsEx.copyProperties(jgdm, bgk);
                        }
                        if (sn.length >= 2) {
                            if (sn[1].trim().length() == 9) {
                                jgdm = em.find(TJgdm.class, sn[1].trim());
                                bgk2 = new TBgk();
                                BeanUtilsEx.copyProperties(bgk2, jgdm);
                            } else {
                                bgk2 = em.find(TBgk.class, Long.valueOf(sn[1]));
                            }
                        } else {
                            currentPath = path + "show_bgk.jsp";
                            return;
                        }
                    }

                    currentPath = path + "show_diff.jsp";
                }

            }
        }.nSyTemplate();
    }



    public String show_bgk() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                bgk = em.find(TBgk.class, bgk.getSn());
                jgdm = new TJgdm();
                BeanUtilsEx.copyProperties(jgdm, bgk);
                currentPath = path + "show_bgk.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 月统计机构类型
     *
     * @return
     */
    public String monthCounsc_xzqh_jglx() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (source != null && "export".equals(source)) {
                    export_type("jglx", jgdm == null ? null : jgdm.getJglx());
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按机构类型统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                excuteBy("jglx", jgdm == null ? null : jgdm.getJglx());

                setColumnName("机构类型");
                setSource("jglx");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按机构类型统计");
                currentPath = path + "monthCounsc_xzqh.jsp";
                getBzjgFenJiMap();          
                
            }
        }.nSyTemplate();
    }
    
    private void getBzjgFenJiMap(){
    	   /////////////////////////////////////////////////////        
        User user = (User) session.get("sysUser");
        String bzjgdm=user.getBzjgdm();
        //String xzqhdm = InitSysParams.system.getXzqhdm();
        String xzqhdm = "";
     //   Map<String, String> zrxzqhMap=zrxzqhBus.getMap();
        Map<String, String> zrxzqhMap=InitSysParams.bzjgdmMap;
/*        if(!bzjgdm.equals(xzqhdm)){
        	if(bzjgdm.endsWith("00")){
        		Iterator<Map.Entry<String, String>> it = zrxzqhMap.entrySet().iterator();
            	while(it.hasNext()){   
            		 Map.Entry<String, String> entry=it.next();   
            		 String key=entry.getKey();  
            		 if(!key.startsWith(bzjgdm.substring(0,4))){
            			 it.remove();
            		 }
            	}
        	}else{
        		Iterator<Map.Entry<String, String>> it = zrxzqhMap.entrySet().iterator();
            	while(it.hasNext()){   
            		 Map.Entry<String, String> entry=it.next();   
            		 String key=entry.getKey();  
            		 if(!key.equals(bzjgdm)){
            			 it.remove();
            		 }
            	}
        	}
        }*/
        ActionContext.getContext().put("bzjgMap", zrxzqhMap);
//////////////////////////////////////////////////////           
    }

    public String monthCounsc_xzqh_jglx_tu() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                excuteForJson("jglx", jgdm == null ? null : jgdm.getJglx());
                setColumnName("机构类型");
                setSource("jglx");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按机构类型统计 &gt;&gt; 信息图");
                currentPath = path + "monthCounsc_xzqh_tu.jsp";
            }
        }.nSyTemplate();
    }
    
    public String monthCounsc_xzqh_jjlx2011() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (source != null && "export".equals(source)) {
                    export_type("jglx", jgdm == null ? null : jgdm.getJjlx2011());
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济类型统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                excuteBy("jjlx2011", jgdm == null ? null : jgdm.getJjlx2011());
                setColumnName("机构类型");
                setSource("jjlx2011");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按登记类型统计");
                currentPath = path + "monthCounsc_xzqh.jsp";
                
                getBzjgFenJiMap();
                
                
            }
        }.nSyTemplate();
    }
    
    public String monthCounsc_xzqh_jjlx2016() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
            	 if (source != null && "export".equals(source)) {
                     export_type2("jglx", jgdm == null ? null : jgdm.getJjlx2011());
                     setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济类型统计 &gt;&gt; 下载");
                     currentPath = path + "download.jsp";
                     return;
                 }
                excuteBy2("jjlx2011", jgdm == null ? null : jgdm.getJjlx2011());
                setColumnName("机构类型");
                setSource("jjlx2011");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按直接登记类型统计");
                currentPath = path + "monthCounsc_xzqh_2016.jsp";
                getBzjgFenJiMap();
            }
        }.nSyTemplate();
    }
    
    private void excuteBy2(String tableColumn, String value) throws SQLException {
        User user = (User) session.get("sysUser");
        if (jgdm == null) {
            jgdm = new TJgdm();
            //jgdm.setXzqh(user.getBzjgdm());
        } else {
            if ("*".equals(jgdm.getXzqh())) {
                jgdm.setXzqh(null);
            }
            if ("*".equals(value)) {
                value = null;
            }
        }
       
        fenJi();
        models = new ArrayList<Model>();
        if (year == null || year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            day = Calendar.getInstance().get(Calendar.MONTH);
        }
        DataAccess dataObject = new DataAccess();
        String sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
        "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0 and zgmc like '%直接登记%') c " +//
        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as " + tableColumn + " from sc_bzjgdm ," +
        ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn.replace("jjlx2011", "lx")) +
        " w "+ ("jjlx2011".equals(tableColumn) ?(" where   jglx='" + (value==null?"1":value) + "' "):"" )+" ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +xzqhSql()+
        //(jgdm.getXzqh() != null ? (" and c.bzjgdm like '" + jgdm.getXzqh() + "%' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
        "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        CachedRowSet cs = dataObject.query(sql);
        while (cs.next()) {
            Model model = new Model();
            model.setColumn1(cs.getString("xzqh"));
            model.setColumn2(cs.getString(tableColumn));
            model.setCount1(cs.getInt("num"));
            models.add(model);
        }
        cs.close();

    }
    
    private void export_type2(String tableColumn, String value) throws Exception {
        User user = (User) session.get("sysUser");
        if (jgdm == null) {
            jgdm = new TJgdm();
            jgdm.setXzqh(user.getBzjgdm());
        } else {
            if ("*".equals(jgdm.getXzqh())) {
                jgdm.setXzqh(null);
            }
            if ("*".equals(value)) {
                value = null;
            }
        }
        models = new ArrayList<Model>();
        if (year == null || year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            day = Calendar.getInstance().get(Calendar.MONTH);
        }
        DataAccess dataObject = new DataAccess();
        String sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
                "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0 and zgmc like '%直接登记%') c " +
                "right join (select bzjg_id as xzqh,dm as " + tableColumn + " from sc_bzjgdm," +
                ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn) +
                ") b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +
                (jgdm.getXzqh() != null ? (" and c.bzjgdm='" + jgdm.getXzqh() + "' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
                "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        fileName = getUName();
        File file = get(fileName);
        WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
        String title = "机构代码-sheet"; // 标题
        CachedRowSet cs = dataObject.query(sql);
        int k = 0;
        int x = 0;
        int j = 0;
        Map<String, Integer> xzqhs = new HashMap<String, Integer>();
        Map<String, Integer> jglxs = new HashMap<String, Integer>();
        WritableCellFormat wcfFC = getCellFormat();
        WritableSheet sheet = book.createSheet(title, (short) 0);

        while (cs.next()) {
            String xzqh = cs.getString("xzqh").trim();
            String jglx = cs.getString(tableColumn).trim();
            Integer tempx = xzqhs.get(xzqh);
            Integer tempj = jglxs.get(jglx);
            if (tempx == null) {
                x += 1;
                tempx = x;
                xzqhs.put(xzqh, x);
                sheet.addCell(new Label(0, tempx, InitSysParams.bzjgdmMap.get(xzqh), wcfFC));
            }
            if (tempj == null) {
                j += 1;
                tempj = j;
                jglxs.put(jglx, j);
                if ("jjhy".equals(tableColumn)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap.get(jglx), wcfFC));
                }
                if ("jglx".equals(tableColumn)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap.get(jglx), wcfFC));
                }
                if ("jjlx".equals(tableColumn)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap.get(jglx), wcfFC));
                }

            }
            sheet.addCell(new Label(tempj, tempx, String.valueOf(cs.getInt("num"))));
        }
        book.write();
        book.close();
        cs.close();
    }




    private void fenJi(){
/*    	 User user = (User) session.get("sysUser");
         String bzjgdm=user.getBzjgdm();
         String xzqhdm = InitSysParams.system.getXzqhdm();
         if(jgdm==null){
        	 jgdm=new TJgdm();
         }
         if(!bzjgdm.equals(xzqhdm)){
        	 if(jgdm.getXzqh()==null||jgdm.getXzqh().equals("*")){
         	if(bzjgdm.endsWith("00")){
         		jgdm.setXzqh(bzjgdm.substring(0,4));
         	}else{
         		jgdm.setXzqh(bzjgdm);
         	}
         }
         }*/
    }

    /**
     * 按照行政区划 经济行业统计
     *
     * @return
     */
    public String counsc_xzqh_jjhy() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                DataAccess dataObject = new DataAccess();
                String sql = "";
                int length = -1;
                if (jgdm == null)
                    jgdm = new TJgdm();
                
                fenJi();
                getBzjgFenJiMap();
                if (year == null || year == 0) {
                    year = Calendar.getInstance().get(Calendar.YEAR);
                    month = Calendar.getInstance().get(Calendar.MONTH) + 1;
                    day = Calendar.getInstance().get(Calendar.MONTH);
                }
                if (jgdm.getJjhy2011() != null && !"".equals(jgdm.getJjhy2011())) {
                    length = jgdm.getJjhy2011().length();
                }
                length = length + 2;
                CachedRowSet cs;
                models = new ArrayList<Model>();
                if (type != null && type) {
                    sql = "select  xzqh,substring(njjhy, 1, " + length + ")  as jjhy, sum(num) as num,fl from  sc_jjhy " +
                            " where 1=1 " +
                            ((jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh()) || "".equals(jgdm.getXzqh())) ? "" : (" and xzqh = '" + jgdm.getXzqh() + "' ")) +
                          //  ((jgdm.getJjhy() == null || "*".equals(jgdm.getJjhy()) || "".equals(jgdm.getJjhy())) ? "" : 
                            (" and njjhy like '" + jgdm.getJjhy2011() + "%' ")+
                            ((jgdm.getJjhy2011() == null || "*".equals(jgdm.getJjhy2011()) || "".equals(jgdm.getJjhy2011())) ? "" : (" and fl = '" + jgdm.getJjhy2011() + "' ")) +
                            " group by xzqh,fl,substring(njjhy, 1," + length + ") order by xzqh,fl";
                    cs = dataObject.query(sql);
                    if (source != null && "export".equals(source)) {
                        export_RowSet(cs, "xzqh", "fl");
                        setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济行业统计 &gt;&gt; 下载");
                        currentPath = path + "download.jsp";
                        return;
                    }

                    while (cs.next()) {
                        Model model = new Model();
                        model.setColumn1(cs.getString("xzqh").trim());
                        model.setColumn2(cs.getString("jjhy").trim());
                        model.setColumn3(cs.getString("fl").trim());
                        model.setCount1(cs.getInt("num"));
                        models.add(model);
                    }
                } else {
                    sql = "select  xzqh, fl, sum(num) as num  from  sc_jjhy " +
                            " where 1=1 " +
                            ((jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh()) || "".equals(jgdm.getXzqh())) ? "" : (" and xzqh like '" + jgdm.getXzqh() + "%' ")) +
                           // ((jgdm.getJjhy() == null || "*".equals(jgdm.getJjhy()) || "".equals(jgdm.getJjhy())) ? "" : 
                            	(" and njjhy like '" + jgdm.getJjhy2011() + "%' ") +
                            ((jgdm.getJjhy2011() == null || "*".equals(jgdm.getJjhy2011()) || "".equals(jgdm.getJjhy2011())) ? "" : (" and fl = '" + jgdm.getJjhy2011() + "' ")) +
                            " group by xzqh,fl  order by xzqh,fl";
                    cs = dataObject.query(sql);
                    if (source != null && "export".equals(source)) {
                        export_RowSet(cs, "xzqh", "fl");
                        setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济行业统计 &gt;&gt; 下载");
                        currentPath = path + "download.jsp";
                        return;
                    }
                    while (cs.next()) {
                        Model model = new Model();
                        model.setColumn1(cs.getString("xzqh").trim());
                        model.setColumn3(cs.getString("fl").trim());
                        model.setCount1(cs.getInt("num"));
                        models.add(model);
                    }
                }
                cs.close();
                setColumnName("行业类型");
                setSource("jjhy");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济行业统计");
                currentPath = path + "counsc_xzqh_jjhy.jsp";
               
            }
        }.nSyTemplate();
    }

    
    /**
     * 统计时间段内行政区划每个业务的业务量
     *
     * @return
     */
    public String countDailyBus() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                //TODO
            	fenJi();
                getBzjgFenJiMap();
                if ((startDate == null) || (endDate == null)) {
                    endDate = DateUtil.strToDate(DateUtil.dateToStr(new Date()));
                    startDate = endDate;
                }
                
                Date end = DateUtil.dayAfter(endDate, 1);
                DataAccess dataObject = new DataAccess();
                modelMaps = new HashMap<String, List<Model>>();
                models = new ArrayList<Model>();
                String sql = "select b.xzqh,b.type,count(id) as num from " +
                        "(select bzjgdm as xzqh,type,id from t_czjl  where "+getTydmJglx()+"(date between '" + DateUtil.dateToStr(startDate) + "' and '" + DateUtil.dateToStr(end) + "')) c " +
                        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id,czlxdm as type from sc_bzjgdm,t_operate_type where czlxdm in('1','1A','2','3','8','KP')) b on c.xzqh = b.xzqh and c.type = b.type  where 1=1 " +xzqhSql()+    
                        ((jgdm == null || jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh())) ? "" : (" and b.xzqh like '" + jgdm.getXzqh() + "%' ")) +
                        "group by b.xzqh,b.type order by b.xzqh,b.type";
                CachedRowSet cs = dataObject.query(sql);
                if (source != null && "export".equals(source)) {
                    export_RowSet(cs, "xzqh", "type");
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                while (cs.next()) {
                    Model model = new Model();
                    model.setColumn1(cs.getString("xzqh"));
                    model.setColumn2(cs.getString("type"));
                    model.setCount1(cs.getInt("num"));
                    models.add(model);
                }
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务统计");
                currentPath = path + "countDailyBus.jsp";
            }
        }.nSyTemplate();
    }


    
    /**
     * 统计时间段内行政区划各个直接登记类型的数量
     * by:lvwei   20170420
     * 
     * @return
     */
    public String rateZjdjlxBus(){
    	 return new ActionUtils() {
             @Override
             protected void excute() throws Exception {
                 //TODO
                 if ((startDate == null) || (endDate == null)) {
                     endDate = DateUtil.strToDate(DateUtil.dateToStr(new Date()));
                     startDate = DateUtil.dayBefore(endDate, 10);
                 }
                 Date end = DateUtil.dayAfter(endDate, 1);
                 DataAccess dataObject = new DataAccess();
                 modelMaps = new HashMap<String, List<Model>>();
                 models = new ArrayList<Model>();
                 fenJi();
                 getBzjgFenJiMap();
              

                String sql = "SELECT zjdjlx AS type,COUNT(zjdjlx)AS num FROM t_jgdm "
                		+ " WHERE "
                		+ getTydmJglx() 
                		+ " zcrq between '" + DateUtil.dateToStr(startDate) + "' and '" + DateUtil.dateToStr(end) + "'"
                		+  ((jgdm == null || jgdm.getXzqh() == null || "".equals(jgdm.getXzqh())) ?(""): ("and xzqh like '" + jgdm.getXzqh() + "%' "))
                		+ "GROUP BY zjdjlx";
                
                System.out.println("jgdm.getXzqh===="+jgdm.getXzqh());
                System.out.println(sql);					
                CachedRowSet cs = dataObject.query(sql);
                
                 if (source != null && "export".equals(source)) {
                     export_RowSet(cs, "zjdjlx", "type", "rate");
                     setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务率统计 &gt;&gt; 下载");
                     currentPath = path + "download.jsp";
                     return;
                 }
                 setColumnName("直接登记类型");
               
                 for(int i = 1;i < 7;i++){
                	 Model model = new Model();
                	 model.setColumn1(String.valueOf(i));
                	 model.setCount1(0);
                	 models.add(model);
                 }
             
                 int zongji = 0;
                 while (cs.next()) {
                	 for(Model m:models){
                		if(m.getColumn1().equals(cs.getString("type"))){
                			m.setCount1(cs.getInt("num"));
                		}
                	 }             
                     zongji += cs.getInt("num");
                 }
                
                 Model model = new Model();
                 model.setColumn1("sum");
                 model.setCount1(zongji);
                 models.add(model);

                 if("2".equals(jgdm.getJglx())){
                	 models.remove(2);
                 }
                 if("3".equals(jgdm.getJglx())){
                     System.out.println("models==="+models);
                     System.out.println("集合大小="+models.size());
                	 models.remove(2);
                	 models.remove(2);
                	 models.remove(2);
                	 models.remove(2);
                 }
                 
                 setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务率统计");
                 //    currentPath = path + "rateDailyBus.jsp";
                 currentPath = path + "monthCounsc_xzqh_2016.jsp";
             }
         }.nSyTemplate(); 	
    }
 
    
    /**
     * 统计时间段内行政区划每个业务的业务量,及比例
     *
     * @return
     */
    public String rateDailyBus() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                //TODO
                if ((startDate == null) || (endDate == null)) {
                    endDate = DateUtil.strToDate(DateUtil.dateToStr(new Date()));
                    startDate = DateUtil.dayBefore(endDate, 10);
                }
                Date end = DateUtil.dayAfter(endDate, 1);
                DataAccess dataObject = new DataAccess();
                modelMaps = new HashMap<String, List<Model>>();
                models = new ArrayList<Model>();
                fenJi();
                getBzjgFenJiMap();
                String sql = "select c.xzqh,c.type,sum(num) as num,cast(cast(isnull(sum(num),0) as decimal(10,2))/cast(c.zong as decimal(10,2))*100 as decimal(10,2)) as rate from " +
                        "(select c.xzqh,c.type,count(id) as num,(select sum(1) from t_czjl where "+getTydmJglx()+"(date between '" + DateUtil.dateToStr(startDate) + "' and '" + DateUtil.dateToStr(end) + "') and xzqh in (SELECT bzjg_id as xzqh from sc_bzjgdm b where 1=1 "+xzqhSql()+") ) as zong from " +
                        "(select * from t_czjl where "+getTydmJglx()+"(date between '" + DateUtil.dateToStr(startDate) + "' and '" + DateUtil.dateToStr(end) + "')) b right join " +
                        "(select bzjg_id as xzqh,sjbzjg_id,bzjg_id,czlxdm as type from sc_bzjgdm b,t_operate_type where czlxdm in('1','2','3','8','KP')) c on c.xzqh = b.bzjgdm and c.type = b.type  where 1=1 "  +xzqhSql().replace("b.", "c.")+
                        " group by c.xzqh,c.type) c " +
                        ((jgdm == null || jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh())) ?"": (" where  c.xzqh like '" + jgdm.getXzqh() + "%' ")) +
                        " group by c.xzqh,c.type,c.zong order by c.xzqh,c.type";
                System.out.println(sql);
                CachedRowSet cs = dataObject.query(sql);
                if (source != null && "export".equals(source)) {
                    export_RowSet(cs, "xzqh", "type", "rate");
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务率统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                while (cs.next()) {
                    Model model = new Model();
                    model.setColumn1(cs.getString("xzqh"));
                    model.setColumn2(cs.getString("type"));
                    model.setCount1(cs.getInt("num"));
                    model.setRate1(cs.getDouble("rate"));
                    models.add(model);
                }
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务率统计");
                //    currentPath = path + "rateDailyBus.jsp";
                currentPath = path + "rateDailyBus.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 统计时间段内行政区划每个业务的业务量
     *
     * @return
     */
    public String countYearDailyBus() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                DataAccess dataObject = new DataAccess();
                models = new ArrayList<Model>();
                if (year == null) {
                    month = Calendar.getInstance().get(Calendar.YEAR);
                    year = month - 2;
                }
                if (jgdm == null) {
                    jgdm = new TJgdm();
                    jgdm.setXzqh(user.getBzjgdm());
                }
                
                fenJi();
                getBzjgFenJiMap();

                String sql = "select year ,xzqh,type, num  from tk_yw_year where " + " year BETWEEN " + year + " and " + month +
                        (jgdm.getXzqh() == null ? "" : " and xzqh like '" + jgdm.getXzqh() + "%'");
                CachedRowSet cs = dataObject.query(sql);
                if (source != null && "export".equals(source)) {
                    export_RowSet(cs, "xzqh", "type");
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常同期比统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                while (cs.next()) {
                    Model model = new Model();
                    model.setColumn1(cs.getString("xzqh"));
                    model.setColumn2(cs.getString("type"));
                    model.setColumn3(cs.getString("year"));
                    model.setCount1(cs.getInt("num"));
                    models.add(model);
                }
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常同期比统计");
                currentPath = path + "countYearDailyBus.jsp";
            }
        }.nSyTemplate();
    }

    public String countYearDailyBus_tu() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                DataAccess dataObject = new DataAccess();
                models = new ArrayList<Model>();
                mapMap = new HashMap<String, Map>();
                if (year == null) {
                    month = Calendar.getInstance().get(Calendar.YEAR);
                    year = month - 2;
                }
                if (jgdm == null) {
                    jgdm = new TJgdm();
                    jgdm.setXzqh(user.getBzjgdm());
                }

                String sql = "select year ,xzqh,type, num  from tk_yw_year where " + " year BETWEEN " + year + " and " + month +
                        (jgdm.getXzqh() == null ? "" : " and xzqh='" + jgdm.getXzqh() + "' order by year");
                CachedRowSet cs = dataObject.query(sql);
                String xzqh = "";
                String type = "";
                String year = "";
                while (cs.next()) {
                    xzqh = cs.getString("xzqh").trim();
                    type = cs.getString("type").trim();
                    year = cs.getString("year").trim();
                    Model model = new Model();
                    model.setColumn1(xzqh);
                    model.setColumn2(type);
                    model.setColumn3(year);
                    model.setCount1(cs.getInt("num"));
                    if (mapMap.keySet().contains("" + xzqh)) {
                        modelMaps = mapMap.get(xzqh);
                    } else {
                        modelMaps = new HashMap<String, List<Model>>();
                    }
                    if (modelMaps.keySet().contains("" + year)) {
                        models = modelMaps.get(year);
                    } else {
                        models = new ArrayList<Model>();
                    }
                    models.add(model);
                    modelMaps.put(year, models);
                    mapMap.put(xzqh, modelMaps);
                }
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常同期比统计 &gt;&gt; 信息图");
                currentPath = path + "countYearDailyBus_tu.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 日业务量统计
     *
     * @return
     */
    public String dayBusCount() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (startDate == null) {
                    startDate = Calendar.getInstance().getTime();
                }
                DataAccess dataObject = new DataAccess();
                modelMaps = new TreeMap<String, List<Model>>(
                        new Comparator<Object>() {
                            public int compare(Object obj1, Object obj2) {
                                Integer v1 = Integer.valueOf(obj1.toString());
                                Integer v2 = Integer.valueOf(obj2.toString());
                                if (v1 == null)
                                    return -1;
                                int s = v1.compareTo(v2);
                                return s;
                            }
                        }
                );
                
                fenJi();
                models = new ArrayList<Model>();
                String sql = "select c.type,count(id) as num from (select * from t_czjl where "+getTydmJglx()+((jgdm == null || jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh())) ? "" : ("xzqh like '" + jgdm.getXzqh() + "%' and "))+" datediff(day,date,'" + DateUtil.dateToStr(startDate) + "')=0 and bzjgdm in (select bzjg_id from sc_bzjgdm b where 1=1 "+xzqhSql()+")) b right join " +
                        "(select czlxdm as type from t_operate_type where czlxdm in('1','1A','2','3','8','KP')) c on c.type = b.type " +
                        " group by  c.type order by c.type";
                CachedRowSet cs = dataObject.query(sql);
                if (source != null && "export".equals(source)) {
                    export_date(cs, "type", DateUtil.dateToStr(startDate) + "日");
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                while (cs.next()) {
                    Model model = new Model();
                    model.setColumn1(cs.getString("type"));
                    model.setCount1(cs.getInt("num"));
                    models.add(model);
                }
                setColumnName(DateUtil.dateToStr(startDate) + "日");
                setSource("day");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计");
                currentPath = path + "busCount.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 周业务量统计
     *
     * @return
     */
    public String weekBusCount() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
            	fenJi();
                if (startDate == null) {
                    startDate = Calendar.getInstance().getTime();
                }
                DataAccess dataObject = new DataAccess();
                modelMaps = new TreeMap<String, List<Model>>(
                        new Comparator<Object>() {
                            public int compare(Object obj1, Object obj2) {
                                Integer v1 = Integer.valueOf(obj1.toString());
                                Integer v2 = Integer.valueOf(obj2.toString());
                                if (v1 == null)
                                    return -1;
                                int s = v1.compareTo(v2);
                                return s;
                            }
                        }
                );
                models = new ArrayList<Model>();

                String sql = "select  c.type,count(id) as num from (select * from t_czjl where "+getTydmJglx()+((jgdm == null || jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh())) ? "" : ("xzqh like '" + jgdm.getXzqh() + "%' and "))+" datediff(week,date,'" + DateUtil.dateToStr(startDate) + "')=0 and bzjgdm in (select bzjg_id from sc_bzjgdm b where 1=1 "+xzqhSql()+")) b right join " +
                        "(select czlxdm as type from t_operate_type where czlxdm in('1','1A','2','3','8','KP')) c on c.type = b.type " +
                        " group by c.type order by c.type";
                CachedRowSet cs = dataObject.query(sql);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                setColumnName(calendar.get(Calendar.YEAR) + "年第" + calendar.get(Calendar.WEEK_OF_YEAR) + "周(" + DateUtil.dateToStr(startDate) + ")");

                if (source != null && "export".equals(source)) {
                    export_date(cs, "type", getColumnName());
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                while (cs.next()) {
                    Model model = new Model();
                    model.setColumn1(cs.getString("type"));
                    model.setCount1(cs.getInt("num"));
                    models.add(model);
                }

                setSource("week");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 周业务统计");
                currentPath = path + "busCount.jsp";
            }
        }.template();
    }

    /**
     * 月业务量统计
     *
     * @return
     */
    public String monthBusCount() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
            	fenJi();
                if (year == null || year == 0) {
                    year = Calendar.getInstance().get(Calendar.YEAR);
                    month = Calendar.getInstance().get(Calendar.MONTH) + 1;
                }
                DataAccess dataObject = new DataAccess();
                modelMaps = new TreeMap<String, List<Model>>(
                        new Comparator<Object>() {
                            public int compare(Object obj1, Object obj2) {
                                Integer v1 = Integer.valueOf(obj1.toString());
                                Integer v2 = Integer.valueOf(obj2.toString());
                                if (v1 == null)
                                    return -1;
                                int s = v1.compareTo(v2);
                                return s;
                            }
                        }
                );
                models = new ArrayList<Model>();
                String sql = "select  c.type,count(id) as num from (select * from t_czjl where "+getTydmJglx()+((jgdm == null || jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh())) ? "" : ("xzqh like '" + jgdm.getXzqh() + "%' and "))+" datediff(month,date,'" + year + "-" + month + "-01')=0 and bzjgdm in (select bzjg_id from sc_bzjgdm b where 1=1 "+xzqhSql()+")) b right join " +
                        "(select czlxdm as type from t_operate_type where czlxdm in('1','1A','2','3','8','KP')) c on c.type = b.type " +
                        " group by c.type order by c.type";
                CachedRowSet cs = dataObject.query(sql);
                if (source != null && "export".equals(source)) {
                    export_date(cs, "type", month + "月份");
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                while (cs.next()) {
                    Model model = new Model();
                    model.setColumn1(cs.getString("type"));
                    model.setCount1(cs.getInt("num"));
                    models.add(model);
                }
                setColumnName(month + "月份");
                setSource("month");
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 月业务统计");
                currentPath = path + "busCount.jsp";
            }
        }.template();
    }

    /**
     * 统计库每个行政区划的业务量
     *
     * @return
     */
    public String countCodeBase_xzqh() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
            	fenJi();
                getBzjgFenJiMap();
            	
                DataAccess dataObject = new DataAccess();
                modelMaps = new HashMap<String, List<Model>>();
                if (database == null || "*".equals(database)) {
                    modelMaps.put("t_jgdm", getModels(dataObject, "t_jgdm"));
                    modelMaps.put("t_fzdm", getModels(dataObject, "t_fzdm"));
                   // modelMaps.put("t_ljdm", getModels(dataObject, "t_ljdm"));
                } else {
                    modelMaps.put(database, getModels(dataObject, database));
                }
                if (source != null && "export".equals(source)) {
                    export_Map(modelMaps);
                    setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 代码库数据统计 &gt;&gt; 下载");
                    currentPath = path + "download.jsp";
                    return;
                }
                setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 代码库数据统计");
                currentPath = path + "countCodeBase_xzqh.jsp";
            }
        }.nSyTemplate();
    }


    private List<Model> getModels(DataAccess dataObject, String database) throws Exception {
        List<Model> models = new ArrayList<Model>();
        String gb = "  group by b.bzjg_id order by b.bzjg_id";
        String sql = "select b.bzjg_id as xzqh,count(1) as num from " + database + " c  right join sc_bzjgdm b on c.bzjgdm = b.bzjg_id "+getJglx("and c.")+"  where 1=1 "+xzqhSql();
        CachedRowSet cs = null;
        if (jgdm == null || jgdm.getXzqh() == null || "*".equals(jgdm.getXzqh())) {
            sql += gb;
        } else {
            sql += " where  b.bzjg_id like '" + jgdm.getXzqh() + "%' " + gb;

        }
        cs = dataObject.query(sql);
        while (cs.next()) {
            Model model = new Model();
            model.setColumn1(cs.getString("xzqh"));
            model.setCount1(cs.getInt("num")==1?0:cs.getInt("num"));
            models.add(model);
        }
        cs.close();
        return models;
    }

    private void export_type(String tableColumn, String value) throws Exception {
        User user = (User) session.get("sysUser");
        if (jgdm == null) {
            jgdm = new TJgdm();
            jgdm.setXzqh(user.getBzjgdm());
        } else {
            if ("*".equals(jgdm.getXzqh())) {
                jgdm.setXzqh(null);
            }
            if ("*".equals(value)) {
                value = null;
            }
        }
        models = new ArrayList<Model>();
        if (year == null || year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            day = Calendar.getInstance().get(Calendar.MONTH);
        }
        DataAccess dataObject = new DataAccess();
        String sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
                "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
                "right join (select bzjg_id as xzqh,dm as " + tableColumn + " from sc_bzjgdm," +
                ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn) +
                ") b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +
                (jgdm.getXzqh() != null ? (" and c.bzjgdm='" + jgdm.getXzqh() + "' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
                "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        fileName = getUName();
        File file = get(fileName);
        WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
        String title = "机构代码-sheet"; // 标题
        CachedRowSet cs = dataObject.query(sql);
        int k = 0;
        int x = 0;
        int j = 0;
        Map<String, Integer> xzqhs = new HashMap<String, Integer>();
        Map<String, Integer> jglxs = new HashMap<String, Integer>();
        WritableCellFormat wcfFC = getCellFormat();
        WritableSheet sheet = book.createSheet(title, (short) 0);

        while (cs.next()) {
            String xzqh = cs.getString("xzqh").trim();
            String jglx = cs.getString(tableColumn).trim();
            Integer tempx = xzqhs.get(xzqh);
            Integer tempj = jglxs.get(jglx);
            if (tempx == null) {
                x += 1;
                tempx = x;
                xzqhs.put(xzqh, x);
                sheet.addCell(new Label(0, tempx, InitSysParams.bzjgdmMap.get(xzqh), wcfFC));
            }
            if (tempj == null) {
                j += 1;
                tempj = j;
                jglxs.put(jglx, j);
                if ("jjhy".equals(tableColumn)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap.get(jglx), wcfFC));
                }
                if ("jglx".equals(tableColumn)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap.get(jglx), wcfFC));
                }
                if ("jjlx".equals(tableColumn)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap.get(jglx), wcfFC));
                }

            }
            sheet.addCell(new Label(tempj, tempx, String.valueOf(cs.getInt("num"))));
        }
        book.write();
        book.close();
        cs.close();
    }

    private void export_RowSet(CachedRowSet cs, String column_x, String column_y, String... rate) throws Exception {
        fileName = getUName();
        File file = get(fileName);
        WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
        String title = "机构代码-sheet"; // 标题
        int k = 0;
        int x = 0;
        int j = 0;
        Map<String, Integer> xzqhs = new HashMap<String, Integer>();
        Map<String, Integer> jglxs = new HashMap<String, Integer>();
        WritableCellFormat wcfFC = getCellFormat();
        WritableSheet sheet = book.createSheet(title, (short) 0);
        while (cs.next()) {
            String xzqh = cs.getString(column_x).trim();
            String jglx = cs.getString(column_y).trim();
            Integer tempx = xzqhs.get(xzqh);
            Integer tempj = jglxs.get(jglx);
            if (tempx == null) {
                x += 1;
                tempx = x;
                sheet.addCell(new Label(0, tempx, InitSysParams.bzjgdmMap.get(xzqh), wcfFC));
                xzqhs.put(xzqh, x);
            }
            if (tempj == null) {
                j += 1;
                tempj = j;
                jglxs.put(jglx, j);
                if ("jjhy".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap.get(jglx), wcfFC));
                } else if ("jglx".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap.get(jglx), wcfFC));
                } else if ("jjlx".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap.get(jglx), wcfFC));
                } else if (type != null && type && "fl".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.njjhyBigMap.get(jglx), wcfFC));
                } else if ("type".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.optTypeMap.get(jglx), wcfFC));
                } else {
                    sheet.addCell(new Label(tempj, 0, jglx, wcfFC));
                }

            }
            if (rate != null && rate.length >= 1) {
                Double data = cs.getDouble(rate[0]);


                sheet.addCell(new Label(tempj, tempx, data == 0 ? "0.0" : (String.valueOf(data) + "%")));
            } else {
                sheet.addCell(new Label(tempj, tempx, String.valueOf(cs.getInt("num"))));
            }


        }
        cs.close();
        book.write();
        book.close();


    }

    private String getUName() {
        return UUID.randomUUID().toString() + ".xls";
    }

    private File get(String fileName) throws IOException {
        String tempPath = UserPropertiesData.getValueByPropertyName("tempPath");
        File file = new File(tempPath);
        if (!file.exists())
            file.mkdir();

        file = new File(tempPath + "/" + fileName);
        if (!file.exists())
            file.createNewFile();
        return file;
    }

    private WritableCellFormat getCellFormat() throws WriteException {
        WritableFont font = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD,
                false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat wcfFC = new WritableCellFormat(font);
        wcfFC.setBackground(Colour.AQUA);
        return wcfFC;
    }

    private void export_Map(Map<String, List<Model>> modelMaps) throws Exception {
        fileName = getUName();
        File file = get(fileName);
        WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
        String title = "机构代码-sheet"; // 标题
        int k = 0;
        int j = 0;
        Map<String, Integer> xzqhs = new HashMap<String, Integer>();
        WritableCellFormat wcfFC = getCellFormat();
        WritableSheet sheet = book.createSheet(title, (short) 0);
        for (Map.Entry<String, List<Model>> entry : modelMaps.entrySet()) {
            if ("t_jgdm".equals(entry.getKey())) {
                sheet.addCell(new Label(1, 0, "主库", wcfFC));
                k = 1;
            }
            if ("t_fzdm".equals(entry.getKey())) {
                sheet.addCell(new Label(2, 0, "注销库", wcfFC));
                k = 2;

            }
            if ("t_ljdm".equals(entry.getKey())) {
                sheet.addCell(new Label(3, 0, "无效库", wcfFC));
                k = 3;

            }
            for (Model model : entry.getValue()) {
                Integer xzqh = xzqhs.get(model.getColumn1());
                if (xzqh == null) {
                    j += 1;
                    xzqh = j;
                    xzqhs.put(model.getColumn1(), j);
                    sheet.addCell(new Label(0, xzqh, InitSysParams.xzqhMap.get(model.getColumn1()), wcfFC));
                }
                sheet.addCell(new Label(k, xzqh, String.valueOf(model.getCount1())));
            }
        }
        book.write();
        book.close();

    }

    private void export_date(CachedRowSet cs, String column_y, String name) throws Exception {
        fileName = getUName();
        File file = get(fileName);
        WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
        String title = "机构代码-sheet"; // 标题
        int j = 0;
        Map<String, Integer> jglxs = new HashMap<String, Integer>();
        WritableCellFormat wcfFC = getCellFormat();
        WritableSheet sheet = book.createSheet(title, (short) 0);
        sheet.addCell(new Label(0, 1, name));
        while (cs.next()) {
            String jglx = cs.getString(column_y).trim();
            Integer tempj = jglxs.get(jglx);
            if (tempj == null) {
                j += 1;
                tempj = j;
                if ("jjhy".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap.get(jglx), wcfFC));
                } else if ("jglx".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap.get(jglx), wcfFC));
                } else if ("jjlx".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap.get(jglx), wcfFC));
                } else if (type != null && type && "fl".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.njjhyBigMap.get(jglx), wcfFC));
                } else if ("type".equals(column_y)) {
                    sheet.addCell(new Label(tempj, 0, InitSysParams.optTypeMap.get(jglx), wcfFC));
                } else {
                    sheet.addCell(new Label(tempj, 0, jglx, wcfFC));
                }
            }
            sheet.addCell(new Label(tempj, 1, String.valueOf(cs.getInt("num"))));
        }
        cs.close();
        book.write();
        book.close();

    }

    private void excuteBy(String tableColumn, String value) throws SQLException {
        User user = (User) session.get("sysUser");
        if (jgdm == null) {
            jgdm = new TJgdm();
            //jgdm.setXzqh(user.getBzjgdm());
        } else {
            if ("*".equals(jgdm.getXzqh())) {
                jgdm.setXzqh(null);
            }
            if ("*".equals(value)) {
                value = null;
            }
        }
       
        fenJi();
        models = new ArrayList<Model>();
        if (year == null || year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            day = Calendar.getInstance().get(Calendar.MONTH);
        }
        DataAccess dataObject = new DataAccess();
        //下面的原版的没有权限的统计查询
        /*String sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
		        "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
		        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as " + tableColumn + " from sc_bzjgdm ," +
		        ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn.replace("jjlx2011", "lx")) +
		        " w "+ ("jjlx2011".equals(tableColumn) ?(" where   jglx='" + (value==null?"1":value) + "' "):"" )+" ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +xzqhSql()+
		        //(jgdm.getXzqh() != null ? (" and c.bzjgdm like '" + jgdm.getXzqh() + "%' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
		        "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;*/
        String sql="";
        //xiaruibo 20170606 按bzjgdm权限进行机构类型统计
        if (user.getBzjgdm().trim().endsWith("00000")) {	//国家级，查询所有
        	sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
		        "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
		        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as " + tableColumn + " from sc_bzjgdm ," +
		        ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn.replace("jjlx2011", "lx")) +
		        " w "+ ("jjlx2011".equals(tableColumn) ?(" where   jglx='" + (value==null?"1":value) + "' "):"" )+" ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +xzqhSql()+
		        //(jgdm.getXzqh() != null ? (" and c.bzjgdm like '" + jgdm.getXzqh() + "%' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
		        "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        } else if (user.getBzjgdm().trim().endsWith("0000")) {	//省级
        	sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
    	        "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
    	        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as " + tableColumn + " from sc_bzjgdm ," +
    	        ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn.replace("jjlx2011", "lx")) +
    	        " w "+ ("jjlx2011".equals(tableColumn) ?(" where   jglx='" + (value==null?"1":value) + "' and bzjg_id like '"+user.getBzjgdm().trim().substring(0, 2)+"%' "):"" )+("jglx".equals(tableColumn) ?(" where bzjg_id like '"+user.getBzjgdm().trim().substring(0, 2)+"%' "):"" )+" ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +xzqhSql()+
    	        //(jgdm.getXzqh() != null ? (" and c.bzjgdm like '" + jgdm.getXzqh() + "%' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
    	        "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        } else if (user.getBzjgdm().trim().endsWith("00")) {	//市级
        	sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
    	        "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
    	        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as " + tableColumn + " from sc_bzjgdm ," +
    	        ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn.replace("jjlx2011", "lx")) +
    	        " w "+ ("jjlx2011".equals(tableColumn) ?(" where   jglx='" + (value==null?"1":value) + "' and bzjg_id like '"+user.getBzjgdm().trim().substring(0, 4)+"%' "):"" )+("jglx".equals(tableColumn) ?(" where bzjg_id like '"+user.getBzjgdm().trim().substring(0, 4)+"%' "):"" )+" ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +xzqhSql()+
    	        //(jgdm.getXzqh() != null ? (" and c.bzjgdm like '" + jgdm.getXzqh() + "%' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
    	        "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        } else {	//县区级
        	sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
    	        "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
    	        "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as " + tableColumn + " from sc_bzjgdm ," +
    	        ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "sc_" + tableColumn.replace("jjlx2011", "lx")) +
    	        " w "+ ("jjlx2011".equals(tableColumn) ?(" where   jglx='" + (value==null?"1":value) + "' and bzjg_id like '"+user.getBzjgdm().trim()+"%' "):"" )+("jglx".equals(tableColumn) ?(" where bzjg_id like '"+user.getBzjgdm().trim()+"%' "):"" )+" ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +xzqhSql()+
    	        //(jgdm.getXzqh() != null ? (" and c.bzjgdm like '" + jgdm.getXzqh() + "%' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
    	        "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        }
        CachedRowSet cs = dataObject.query(sql);
        while (cs.next()) {
            Model model = new Model();
            model.setColumn1(cs.getString("xzqh"));
            model.setColumn2(cs.getString(tableColumn));
            model.setCount1(cs.getInt("num"));
            models.add(model);
        }
        cs.close();

    }
    
    public String xzqhSql() throws SQLException{
    	 User user = (User) session.get("sysUser");
    	 String meSql="";
         DataAccess dataObject = new DataAccess();
         String sql = "  select bzjg_id,bzjg_name,type,sjbzjg_id from sc_bzjgdm where bzjg_id='"+user.getBzjgdm()+"'  ";
         CachedRowSet cs = dataObject.query(sql);
         Model model = new Model();
         //以下的是原版的没有权限按代码库统计
         /*while (cs.next()) {
             if("1".equals(cs.getString("type"))){
             }else if("2".equals(cs.getString("type"))){
            	 meSql=" and  b.sjbzjg_id='"+cs.getString("sjbzjg_id")+"' ";
             }else if("3".equals(cs.getString("type"))){
            	 meSql="and  b.bzjg_id='"+cs.getString("bzjg_id")+"' ";
             }
         }*/
         //xiaruibo 20170620 以下是修改后的，按权限统计代码库
         while (cs.next()) {
        	 
        	 if("*".equals(cs.getString("type"))){ //国家级
        		//国家级没有条件，直接查询所有记录
             }else if("0".equals(cs.getString("type"))){ //省级
            	 meSql=" and  b.bzjg_id like '"+user.getBzjgdm().trim().substring(0, 2)+"%' ";
             }else if("1".equals(cs.getString("type"))){ //市级
            	 meSql=" and  b.bzjg_id like '"+user.getBzjgdm().trim().substring(0, 4)+"%' ";
             }else if("2".equals(cs.getString("type"))){ //县区级
            	 meSql=" and  b.bzjg_id like '"+user.getBzjgdm().trim()+"%' ";
             }
         }
         

         cs.close();
         if(jgdm!=null&&jgdm.getJglx()!=null){
        	// meSql=meSql+" and c.jglx='"+jgdm.getJglx()+"'";
         }
         return meSql;
    }

    public String getJglx(String parm){
    	if(jgdm!=null&&jgdm.getJglx()!=null&&!"*".equals(jgdm.getJglx())){
    		return " "+parm+"jglx='"+jgdm.getJglx()+"'";
        	// meSql=meSql+" and c.jglx='"+jgdm.getJglx()+"'";
         }else{
        	 return "";
         }
    }
    
    public String getTydmJglx(){
    	if(jgdm!=null&&jgdm.getJglx()!=null&&!"*".equals(jgdm.getJglx())){
    		return " "+"substring(tyshxydm,2,1)='"+jgdm.getJglx()+"'"+" and ";
    		// meSql=meSql+" and c.jglx='"+jgdm.getJglx()+"'";
    	}else{
    		return "";
    	}
    }
    
    private void excuteForJson(String tableColumn, String value) throws SQLException {
        User user = (User) session.get("sysUser");
        if (jgdm == null) {
            jgdm = new TJgdm();
            jgdm.setXzqh(user.getBzjgdm());
        } else {
            if ("*".equals(jgdm.getXzqh())) {
                jgdm.setXzqh(null);
            }

            if ("*".equals(value)) {
                value = (null);
            }
        }
        models = new ArrayList<Model>();
        if (year == null || year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            day = Calendar.getInstance().get(Calendar.MONTH);
        }
        DataAccess dataObject = new DataAccess();
        String sql = "select b.xzqh,b." + tableColumn + ",count(jgdm) as num from " +
                "(select bzjgdm," + tableColumn + ",jgdm from t_jgdm where datediff(month,lastdate,'" + year + "-" + month + "-1')=0) c " +
                "right join (select bzjg_id as xzqh,dm as " + tableColumn + " from sc_bzjgdm," +
                ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'" : "t_" + tableColumn) +
                ") b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b." + tableColumn + " where 1=1 " +
                (jgdm.getXzqh() != null ? (" and c.bzjgdm='" + jgdm.getXzqh() + "' ") : "") + (value == null ? "" : (" and c." + tableColumn + "='" + value + "' ")) +
                "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b." + tableColumn;
        CachedRowSet cs = dataObject.query(sql);
        StringBuilder Bjson = new StringBuilder("[");
        Map<String, String> jglxMap = InitSysParams.jglxMap;
        while (cs.next()) {
            String jglx = cs.getString(tableColumn).trim();
            Model model = new Model();
            model.setColumn1(cs.getString("xzqh"));
            model.setColumn2(jglx);
            model.setCount1(cs.getInt("num"));
            models.add(model);
            Bjson.append("{name:'" + jglx + "',value:'" + cs.getInt("num") + "',chinese:'" + jglxMap.get(jglx).trim() + "'},");
        }
        json = Bjson.replace(Bjson.lastIndexOf(","), Bjson.length(), "]").toString();
        cs.close();

    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<TJgdm> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TJgdm> jgdms) {
        this.jgdms = jgdms;
    }


    private String getMC() {
        String mc = "%";
        String[] mcs = jgdm.getJgmc().split("\\s+");

        for (String m : mcs) {
            mc += (m + "%");
        }
        return mc;
    }


    public List<Ttable> getTtables() {
        return ttables;
    }

    public void setTtables(List<Ttable> ttables) {
        this.ttables = ttables;
    }

    public String getSqlwhere() {
        return sqlwhere;
    }

    public void setSqlwhere(String sqlwhere) {
        this.sqlwhere = sqlwhere;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<Model> getModels() {
        return models;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Map<String, List<Model>> getModelMaps() {
        return modelMaps;
    }

    public void setModelMaps(Map<String, List<Model>> modelMaps) {
        this.modelMaps = modelMaps;
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

    public String getDatabase() {
        return database;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Map> getMapMap() {
        return mapMap;
    }

    public void setMapMap(Map<String, Map> mapMap) {
        this.mapMap = mapMap;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getJson() {

        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getZsbh() {
        return zsbh;
    }

    public void setZsbh(String zsbh) {
        this.zsbh = zsbh;
    }

    public List<TBgk> getBgks() {
        return bgks;
    }

    public void setBgks(List<TBgk> bgks) {
        this.bgks = bgks;
    }

    public TBgk getBgk() {
        return bgk;
    }

    public void setBgk(TBgk bgk) {
        this.bgk = bgk;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getDmStatus() {
        return dmStatus;
    }

    public void setDmStatus(String dmStatus) {
        this.dmStatus = dmStatus;
    }

    public TBgk getBgk2() {
        return bgk2;
    }

    public void setBgk2(TBgk bgk2) {
        this.bgk2 = bgk2;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public TJgdm getJgdm2() {
        return jgdm2;
    }

    public void setJgdm2(TJgdm jgdm2) {
        this.jgdm2 = jgdm2;
    }

	public Map<String, String> getBzjgdmMap() {
		return bzjgdmMap;
	}

	public void setBzjgdmMap(Map<String, String> bzjgdmMap) {
		this.bzjgdmMap = bzjgdmMap;
	}

	public List<TFzr> getListFzr() {
		return listFzr;
	}

	public void setListFzr(List<TFzr> listFzr) {
		this.listFzr = listFzr;
	}

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}
	
	
	
}