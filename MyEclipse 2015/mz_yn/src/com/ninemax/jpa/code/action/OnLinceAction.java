package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.global.WsbzEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.cglib.beans.BeanCopier;
import nl.justobjects.pushlet.util.Log;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-5-22
 * Time: 下午1:27
 */
public class OnLinceAction extends ActionSupport implements SessionAware{

    private Map<String, Object> session;
    private String currentPath = "";
    private String dm;
    private String ywlx;
    private String zt;
    private String id;
    private List<OnLineVO> list;
    private List<Wnj> wnjList;
    private List<Wgs> wgsList;
    private List<Wzcyh> wzcyhList;
    private String pstate = "";
    private String npstate = "";
    private String state;
    private String tjr;
    private String txnr;
    private String txbt;
    private String message;
    private String url;
    private String type;
    private TJgdmSave jgdmSave;
    private Wnj wnj;
    //登记号列表
    private List<String> djhs;
    //提醒列表
    private List<TxnrVO> txnrList;
    private TJgdm jgdm;
    private TJgdm wjgdm;
    private TjgdmOnLineVO onLineVO;
    private Wgs wgs;
    private Wba wba;
    private Wzx wzx;
    private WXb wxb;
    private Wzcyh wzcyh;
    private String djh;
    private Boolean needAudit;
    //是否已经审核
    private Boolean audit;
    //审核依据
    protected String shyj;
    //审核结果
    protected String shresult;
    //提示信息
    private String prompt;
    //新办处理
    private String[] infos;

    //分页数据
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;

    //业务类
    private OnlineBus onlineBus;
    private TjgdmBus tjgdmBus;
    private WsbzXbBus wsbzBus;
    private TJgdmSaveBus saveBus;
    private TSpBus tSpBus;
    
    private String jgmc;
    
    
    private Integer back;
    
    
    private String fn;
    
    

  

	public OnLinceAction() {
        onlineBus = new OnlineBus();
        tjgdmBus = new TjgdmBus();
        wsbzBus = new WsbzXbBus();
        saveBus = new TJgdmSaveBus();
        tSpBus = new TSpBus();
    }

    //前置审批or申报表审批
    private String opt;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String choose() {
        currentPath = "/product/jsp/online/SP100100.jsp";
        return this.SUCCESS;
    }

    public String jdChoose() {
        currentPath = "/product/jsp/online/SP100101.jsp";
        return this.SUCCESS;
    }

    public String list(){
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        currentPath = "/product/jsp/online/SPQuerylist_new.jsp";
        //4 挂失业务 5备案业务 6注销 其它 新办里面的业务
        if("4".equals(ywlx)){
            list = onlineBus.getGsList(dm,user,zt,pageno, rowNumsView, pages);
        }else if("5".equals(ywlx)){
            list = onlineBus.getBaList(dm,user,zt,pageno, rowNumsView, pages);
        }else if("6".equals(ywlx)){
            list = onlineBus.getZxList(dm,user,zt,pageno, rowNumsView, pages);
        }else{
            list = onlineBus.getXbList(dm,user,zt,ywlx,pageno, rowNumsView, pages);
        }
        return this.SUCCESS;
    }
    
    /**
     * 年度申报
     * @return
     */
    public String nbList(){
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        currentPath = "/product/jsp/online/SPnbQuerylist_new.jsp";
        
        wnjList = onlineBus.getNjList(dm,user,zt,pageno, rowNumsView, pages);
        
        return this.SUCCESS;
    }
    
    
    /**
     * 处理年度申报
     * @return
     */
    public String nbUpdate(){
    	message="年度申报更新成功！";
		User user = (User) session.get("sysUser");
		if (pages == null)
			pages = new clsPageComponent();
		currentPath = "/product/jsp/online/success.jsp";
		TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
		// 1是定期年检 0是办证日期加一年
		String dateLimit = "";
        if (zrxzqh != null) {
            if ("0".equals(zrxzqh.getNjfs())) {
                dateLimit = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 12);
            } else {
                dateLimit = DateUtil.addMonth(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2), 12);
            }
        }
        
        Date uDate=clsStringTool.getStringDate(dateLimit);
    
        
        onlineBus.nbUpdate(dm,id,uDate);
        
        return this.SUCCESS;
    	
    }
    
    
    public String ndbg_print() throws SQLException {
    	currentPath = "/product/jsp/online/ndbg_print.jsp";
    	TjgdmBus bus=new TjgdmBus();
    	OnlineBus online=new OnlineBus();
    	
    	jgdm=bus.findById(dm);
    	wnj=online.getNj(id);
    	
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
      
			calendar2.setTime(jgdm.getZfrq());
        calendar2.add(Calendar.DAY_OF_YEAR, -30);
        calendar3.add(Calendar.YEAR,1);
        if (calendar.getTime().after(calendar2.getTime())) {
        	message="您应于Y年X月到代码窗口办理换证".replace("X", calendar2.get(calendar.MONTH)+2 + "").replace("Y", calendar2.get(Calendar.YEAR) + "");
            //isPrint = false;
           
        }else{
        	calendar3.setTime(jgdm.getNjqx());
        	message="您应于Y年12月31日前进行年度报告".replace("Y", calendar3.get(Calendar.YEAR)+1 + "");
        	
        }
    	
    
    	 return this.SUCCESS;

    }
    
    /**
     * 网上业务修改分页列表页面
     *  TengWuChao 2014-04-11
     * @return
     */
    public String wsywList(){
    	User user = (User) session.get("sysUser");
    	if (pages == null)
    		pages = new clsPageComponent();
    	currentPath = "/product/jsp/online/wsywList.jsp";
    	//4 挂失业务 5备案业务 6注销 其它 新办里面的业务
    	list = onlineBus.getWsywList(jgmc,user,"1",ywlx,pageno, rowNumsView, pages);
    	return this.SUCCESS;
    }
    
    /**
     * 重置密码
     */
    public String initPassWord(){
    	User user = (User) session.get("sysUser");
    	if (pages == null)
    		pages = new clsPageComponent();
    	currentPath = "/product/jsp/online/PasswordList.jsp";
    	//4 挂失业务 5备案业务 6注销 其它 新办里面的业务 
    	wzcyhList = onlineBus.initPassWord(jgmc, user, dm, ywlx, pageno, rowNumsView, pages);
    	return this.SUCCESS;
    	
    }
    
    
    public String createPassWord(){
    
    	currentPath = "/bsweb/onLine_initPassWord.action";
    
    	onlineBus.createPassWord(wzcyh.getZcyhId());
    	message="重置密码成功！密码为123456";
    	return this.SUCCESS;
    	
    }
    /**
     * 跳转修改网上业务页面
     *  TengWuChao 2014-04-11
     * @return
     */
    public String toWsywUpdate(){
    	currentPath = "/product/jsp/online/wsywUpdate.jsp";
    		WXb xb = onlineBus.getWxb(id);
    		ActionContext.getContext().put("jgdm",xb );
//    		BeanUtilsEx.copyProperties(jgdm,xb);
    	return this.SUCCESS;
    }
    /**
     * 修改网上数据
     *  TengWuChao 2014-04-11
     * @return
     */
    public String wsywUpdate(){
    	EntityManager em = WsbzEntityManagerHelper.getEntityManager();
				currentPath = "/product/jsp/online/wsywList.jsp";
				EntityTransaction tx = null;
				try{
		    	if(wxb==null){
		    		wxb=new WXb();
		    	}
		    	tx = em.getTransaction();
		    	 tx.begin();
		    	BeanUtilsEx.copyProperties(wxb, jgdm);
		    	wxb.setId(Integer.valueOf(id));
		    	wxb.setDjh(djh);
		    	wxb.setZt(zt);
		    	em.merge(wxb);
//		    	em.flush();
		    	 tx.commit();
		    	ActionContext.getContext().put("message", "修改网上数据成功!");
				} catch (Exception e) {
					currentPath = "/product/jsp/online/wsywUpdate.jsp";
					ActionContext.getContext().put("message", "修改网上数据失败!");
					if (tx != null && tx.isActive()) {
		                tx.rollback();
		            }
		        } finally {
		            WsbzEntityManagerHelper.closeEntityManager();
		        }
		    	return wsywList();
    }
    

    /**
     * 挂失审批
     * @return
     */
    public String gsSp(){
        currentPath = "/product/jsp/online/gsSp.jsp";
        getStatus();
        jgdm = tjgdmBus.findById(dm);
        djhs = onlineBus.getDjhs(dm);
        session.put("djhs", djhs);
        if(djhs==null){
            currentPath = "/product/jsp/online/prompt.jsp";
            prompt = "机构代码（"+dm+")无网上预约挂失的证书,无法进行证书确认挂失操作！";
        }
        infos = onlineBus.getXbclInfo(id);
        wgs = onlineBus.getWgs(id);
        return this.SUCCESS;
    }

    /**
     * 备案审批
     * @return
     */

    public String baSp(){
        currentPath = "/product/jsp/online/baSp.jsp";
        getStatus();
        jgdm = tjgdmBus.findById(dm);
        infos = onlineBus.getXbclInfo(id);
        wba = onlineBus.getWba(id);
        return this.SUCCESS;
    }

    /**
     * 注销审批
     */
    public String zxSp(){
        currentPath = "/product/jsp/online/zxSp.jsp";
        getStatus();
        jgdm = tjgdmBus.findById(dm);
//        infos = onlineBus.getXbclInfo(id);
        infos = onlineBus.getZxclInfo(dm);
        wzx = onlineBus.getWzx(id);
        return this.SUCCESS;
    }

    public String jdList(){
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        currentPath = "/product/jsp/online/JDQuerylist_new.jsp";
        //4 挂失业务 5备案业务 6注销 其它 新办里面的业务
        if("4".equals(ywlx)){
            zt = "3";
            list = onlineBus.getGsList(dm,user,zt,pageno, rowNumsView, pages);
        }else if("5".equals(ywlx)){
            zt = "2";
            list = onlineBus.getBaList(dm,user,zt,pageno, rowNumsView, pages);
        }else if("6".equals(ywlx)){
            zt = "3";
            list = onlineBus.getZxList(dm,user,zt,pageno, rowNumsView, pages);
        }else if("0".equals(ywlx)){
            List<OnLineVO> xbs = onlineBus.getXbList(dm,user,zt,ywlx,pageno, rowNumsView, pages);
            if(xbs!=null && xbs.size()>0){
                list = new ArrayList<OnLineVO>(xbs.size());
                for(OnLineVO vo : xbs){
                    if(wsbzBus.isWsyw(vo.getDjh(),ywlx)){
                        vo.setFlag("1");
                    }else{
                        vo.setFlag("0");
                    }
                    list.add(vo);
                }
            }
        }else{
            list = onlineBus.getXbList(dm,user,zt,ywlx,pageno, rowNumsView, pages);
        }
        return this.SUCCESS;
    }
    /**
     * 年检批量通过
     * @return
     * Tengwuchao 
     * 2014-07-04
     */
    public String checkAll(){
    	
    	
            	User user = (User) session.get("sysUser");
            	EntityManager em = EntityManagerHelper.getEntityManager();
           	 EntityManager checkem = WsbzEntityManagerHelper.getEntityManager();
           	EntityTransaction tx = em.getTransaction();
           	EntityTransaction tx1 = checkem.getTransaction();
           	 try {
           	tx1.begin();
               	  String strsql = "from WXb where zt = '3'  and lb = '1' "+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and bzjgdm = '"+user.getBzjgdm()+"'  ");
               	 List<WXb> list=checkem.createQuery(strsql).getResultList();
               	checkem.createNativeQuery("update w_xb set w_xb_zt='4' where w_xb_zt = '3'"+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and w_xb_bzjgdm = '"+user.getBzjgdm()+"'  ")).executeUpdate();
               
               	 if(list!=null&&list.size()>0){
               		
               		 for (WXb xb : list) {
               			 tx.begin();
						jgdm = em.find(TJgdm.class, xb.getJgdm());

					      ///////////////
                        TBgk bgk = new TBgk();
                        BeanUtilsEx.copyProperties(bgk, jgdm);
                        bgk.setBgsj(new Date());
                        em.persist(bgk);
                        
                        
                        BeanUtilsEx.copyProperties(jgdm,xb);
                        
                        jgdm.setNjrq(new Date());
                        jgdm.setLastdate(new Date());
                        jgdm.setBgrq(new Date());
                        jgdm.setNjr(user.getUserName());
                        
                        
                        
                        jgdm.setNnjjhy(xb.getJjhy());
			            jgdm.setZgmc(xb.getZgjgmc());
			            jgdm.setJjhy("");
			            if(jgdm.getFksl()!=null && jgdm.getFksl()>0){
			                jgdm.setFkbz("1");
			            }else{
			                jgdm.setFkbz("0");
			            }
			            String jflyName = new OnlineBus().getJflyName(jgdm.getJfly());
			            jgdm.setJfly(jflyName);
                        if(jgdm.getEmail()!=null&&jgdm.getEmail().equals("null")){
                        	jgdm.setEmail(null);
                        }
                        //jgdm.setZfrq(t2.getZfrq());jgdm.setBzrq(t2.getBzrq());

                        TZrxzqh xzqh = em.find(TZrxzqh.class, user.getBzjgdm());
                        em.clear();
                        Date real;
                        if (xzqh.getNjfs().equals("0")) {
                            real = DateUtil.yearAfter(jgdm.getNjrq() == null ? new Date() : jgdm.getNjrq(), 1);
                            jgdm.setNjqx(real);
                        } else {
                            Date date = DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjqsrq().substring(0, 2) + "-" + xzqh.getNjqsrq().substring(2, 4));
                            if (date.after(new Date())) {
                                jgdm.setNjqx(DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));
                            } else {
                                jgdm.setNjqx(DateUtil.strToDate((Calendar.getInstance().get(Calendar.YEAR) + 1) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));

                            }
                        }
                        if (!InitSysParams.njjhyMap.containsKey(jgdm.getNjjhy())) {
                            message = "输入的经济行业不存在与码表中，请更正！";
                        }
                        em.merge(jgdm);
                        if(InitSysParams.system.getNjSmTask()){
                        addrw(em,SmTaskType.年检);
                        }
                        addCzjl(em, jgdm, "年检", "6", null);
                        //deleteSp(em, jgdm.getJgdm(), "12");
                        ////////////////
                        tx.commit();
                        em.clear();
					}
               		
               	 }
             	tx1.commit();
                
                //tx1.commit();
			} catch (Exception e) {
				if(tx!=null){
					tx.rollback();
				}
				if(tx1!=null){
					tx1.rollback();
				}
				// TODO: handle exception
				System.out.println("批量处理出错"+e);
				message="批量处理出错,原因"+e;
				return null;
			}finally{
				WsbzEntityManagerHelper.closeEntityManager();
				em.close();
			}
           	
			message="批量处理完成";
         	 setYwlx("1");
         	 setZt("3");
           return jdList();	
    }
    /**
     * 根据机构代码 和审核类型获取 审核处理的数据
     *
     * @param em
     * @param jgdm
     * @param type
     * @return
     */
    protected TSpdmtemp getSpdm(EntityManager em, String jgdm, String type) {
        String nameQuery = "select model from TSp model where model.jgdm='" + jgdm + "' and model.ywlx = '" + type + "' and model.flag='1' ";

        List<TSp> sps = em.createQuery(nameQuery).getResultList();
        if (sps == null || sps.isEmpty() || sps.size() > 1) {
            return null;
        }
        TSp sp = sps.get(0);
        if ("1".equals(sp.getShflag().trim())) {
            audit = true;

        } else {
            audit = false;
        }
        shyj = sp.getShreason();
        shresult = sp.getShflag().trim();
        TSpdmtemp spdm = em.find(TSpdmtemp.class, sps.get(0).getGllsh());
        return spdm;
    }
    private void addrw(EntityManager em, SmTaskType type) {
   	 User user = (User) session.get("sysUser");
       List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
               .setParameter(1, type.getValue().toString())
               .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
               .setParameter(3, jgdm.getJgdm()).getResultList();
       if (rws.isEmpty() || rws.size() <= 0) {
           TSmrw task = new TSmrw();
           BeanUtilsEx.copyProperties(task, jgdm);
           task.setId(null);
           task.setCreateTime(new Date());
           task.setStatus(false);
           task.setType(type.getValue().toString());
           task.setCzr(user.getUserName());
           em.persist(task);
       }
     /*  if (InitSysParams.system.getQzsm() == null || !InitSysParams.system.getQzsm()) {

       } else {
           List<TQzsm> rws = em.createQuery("select model from TQzsm model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ").setParameter(1, type.getValue().toString())
                   .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
                   .setParameter(3, jgdm.getJgdm()).getResultList();
           if (!rws.isEmpty() && rws.size() > 0) {
               TQzsm qzsm = rws.get(0);
               makeDfile(em, qzsm);
           }
       }*/
   }
    /**
     * 清楚对应的 不需要的审核信息
     *
     * @param em
     * @param jgdm
     * @param ywlx
     */
    protected void deleteSp(EntityManager em, String jgdm, String ywlx) {
        em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.jgdm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1')))")
                .setParameter("jgdm", jgdm).setParameter("ywlx", ywlx).executeUpdate();
        em.createQuery("update  TSp model set model.flag='2' where model.jgdm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1'))")
                .setParameter("jgdm", jgdm).setParameter("ywlx", ywlx).executeUpdate();
    }
    protected boolean addCzjl(EntityManager em, TJgdm jgdm, String memo, String type, Long lsh) {
        TCzjl czjl = new TCzjl();
        User user = (User) session.get("sysUser");
        czjl.setJgdm(jgdm.getJgdm());
        czjl.setMemo(memo);
        czjl.setName(user.getUserName());
        czjl.setType(type);
        czjl.setDate(new Date());
        czjl.setXzqh(user.getBzjgdm());
        if (lsh != null)
            czjl.setKlsh(lsh);
        try {
            em.persist(czjl);
        } catch (EnumConstantNotPresentException e) {
            return false;
        }
        return true;
    }
    
    public String xbJd(){
        //网上业务新办
        if("0".equals(ywlx)){
            jgdmSave = wsbzBus.findById(Integer.parseInt(id));
            currentPath = "/product/jsp/online/addinfomationOnline.jsp";
           /* //如果是申请表修改，并且需要重名审核并通过，需要从审核表中调用数据
                TSpdmtemp spdm = new TSpdmtempBus().getSpdm(id, "'10','11','15'");
            if (spdm != null) {
                currentPath = "/product/jsp/certificate/updateEnterInfoView.jsp";
                jgdmSave = saveBus.findById(Integer.valueOf(id));

                BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdmSave.class, false);
                copier.copy(spdm, jgdmSave, null);
                String ywType = "10";

                List<TSp> sps = tSpBus.getTspList("", ywType);
                if (sps != null && !sps.isEmpty()) {
                    shyj = sps.get(0).getShreason();
                    shresult = sps.get(0).getShflag().trim();
                }
                audit = true;
                needAudit = false;
            } else{
                    jgdmSave = wsbzBus.findById(Integer.parseInt(id));
                    currentPath = "/product/jsp/online/addinfomationOnline.jsp";
            }
*/
        }

        return this.SUCCESS;
    }

    /**
     * 新办审批
     */
    public String xbSp(){
        //首次新办
        if("0".equals(ywlx)){
            currentPath = "/product/jsp/online/xbSp.jsp";
        }
        //年检
        if("1".equals(ywlx)){
            currentPath = "/product/jsp/online/njSp.jsp";
            wjgdm = tjgdmBus.findById(dm);
            jgdm=tjgdmBus.findById(dm);
            //wjgdm=jgdm;
            //setJgdm(wjgdm);
        }
        //变更
        if("2".equals(ywlx)){
            currentPath = "/product/jsp/online/bgSp.jsp";
        }
        //换证
        if("3".equals(ywlx)){
            currentPath = "/product/jsp/online/hzSp.jsp";
        }
        getStatus();
        infos = onlineBus.getXbclInfo(id);
        wxb = onlineBus.getWxb(id);
        if(wxb!=null){
            String jflyName = onlineBus.getJflyName(wxb.getJfly());
            wxb.setJfly(jflyName);
        }
        if(jgdm==null){
            jgdm = new TJgdm();
            jgdm.setZbsl(1);
        }
        if(wxb!=null){
            if(wxb.getFksl()>0){
                jgdm.setFkbz("1");
            }else
                jgdm.setFkbz("0");
        }
        BeanCopier beanCopier = BeanCopier.create(WXb.class,TJgdm.class,false);
        beanCopier.copy(wxb,jgdm,null);
        jgdm.setNnjjhy(wxb.getJjhy());
        jgdm.setZgmc(wxb.getZgjgmc());
        jgdm.setJjhy("");
      
        return this.SUCCESS;
    }

    private void getStatus() {
        if(opt.equals("qzsp")){
            pstate = "3";
            npstate = "0";
        }else{
            pstate = "3";
            npstate = "2";
        }
    }

    public String spNote(){
        HttpServletRequest request = ServletActionContext.getRequest();
        url = request.getRequestURI();
        if (request.getQueryString() != null) {
            url = url + "?" + request.getQueryString();
        }
        currentPath = "/product/jsp/online/spNote.jsp";
        User user = (User) session.get("sysUser");
        String userName = user.getUserName();
        txnrList = onlineBus.getTxnrList(userName);
        if("4".equals(ywlx)){
            djhs = (List<String>)session.get("djhs");
            String strDjh = "";
            if(djhs!=null&&djhs.size()>0){
                for(String djh:djhs){
                    strDjh += djh.trim()+";";
                }
                strDjh = strDjh.substring(0, strDjh.length() - 1);
            }
            onLineVO = new TjgdmOnLineVO();
            onLineVO.setDjh(strDjh);
        }
        session.put("onLineVO",onLineVO);
        String jgdmmc="";
        if("4".equals(ywlx)||"5".equals(ywlx)||"6".equals(ywlx)){
             jgdmmc=onlineBus.getWxbMc(dm);
        }else{
             WXb wxb2 = onlineBus.getWxb(request.getParameter("id"));
             jgdmmc=wxb2.getJgmc();
        }
        ActionContext.getContext().put("jgdmmc", jgdmmc);
        
        return this.SUCCESS;
    }

    public String spNoteView(){
        currentPath = "/product/jsp/online/spNoteView.jsp";
        String[] strs = onlineBus.getNoteView(dm,ywlx);
        if(strs!=null&&strs.length>0){
            txbt = strs[0];
            txnr = strs[1];
        }else{
            txbt = "";
            txnr = "无提醒内容";
        }
        return this.SUCCESS;
    }


    public String spNoteHandle(){
        currentPath = "/product/jsp/online/spNotePrompt.jsp";
        User user = (User) session.get("sysUser");
        String userName = user.getUserName();
        if("save".equals(fn)){
            boolean flag = onlineBus.saveSpNote(txbt, txnr, userName);
            if(flag){
                message = "添加成功!";
            }else
                message = "添加失败!";
            currentPath=url;
            return SUCCESS;
        }else if("delete".equals(fn)){
            boolean flag = onlineBus.delSpNote(txbt, userName);
            if(flag){
                message = "删除成功!";
            }else
                message = "删除失败!提醒内容为上级机构设置";
            currentPath=url;
            return SUCCESS;
        }else{
            if(clsStringTool.isEmpty(id)){
                message = "非法请求参数，请重新登录!";
            }else{
                boolean flag = false;
                if("0".equals(ywlx)){
                    flag = onlineBus.updateXB(id,state,session);
                    message = "新办审核成功!";
                }
                if("1".equals(ywlx)){
                    flag = onlineBus.updateNJ(id,state,dm,session);
                    message = "年检审核成功!";
                }
                if("2".equals(ywlx)){
                    flag = onlineBus.updateBG(id,state,dm,session);
                    message = "变更审核成功!";
                }
                if("3".equals(ywlx)){
                    flag = onlineBus.updateHZ(id,state,dm,session);
                    message = "换证审核成功!";
                }
                if("4".equals(ywlx)){
                    flag = onlineBus.updateGS(id,state,dm,session);
                    message = "挂失审核成功!";
                }
                if("5".equals(ywlx)){
                    flag = onlineBus.updateBA(id,state,dm,session);
                    message = "备案审核成功!";
                }
                if("6".equals(ywlx)){
                    flag = onlineBus.updateZX(id,state,dm,session);
                    message = "注销审核成功!";
                }
                if(flag){
                     boolean updateFlag = onlineBus.updateData(tjr,dm,txbt,txnr,opt,userName);
                }
                if("qzsp".equals(opt)&& "2".equals(state) || "0".equals(state)){
             		zt = "1";
             	}else if("3".equals(state) || (!"qzsp".equals(opt))&&"2".equals(state)){
             		zt = "5";
             	}
                currentPath = "/product/jsp/online/auditSuccess.jsp";
            }
        }
        return this.SUCCESS;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OnLineVO> getList() {
        return list;
    }

    public void setList(List<OnLineVO> list) {
        this.list = list;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getRowNumsView() {
        return rowNumsView;
    }

    public void setRowNumsView(Integer rowNumsView) {
        this.rowNumsView = rowNumsView;
    }

    public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public List<String> getDjhs() {
        return djhs;
    }

    public void setDjhs(List<String> djhs) {
        this.djhs = djhs;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getNpstate() {
        return npstate;
    }

    public void setNpstate(String npstate) {
        this.npstate = npstate;
    }

    public String[] getInfos() {
        return infos;
    }

    public void setInfos(String[] infos) {
        this.infos = infos;
    }

    public List<Wgs> getWgsList() {
        return wgsList;
    }

    public void setWgsList(List<Wgs> wgsList) {
        this.wgsList = wgsList;
    }

    public Wgs getWgs() {
        return wgs;
    }

    public void setWgs(Wgs wgs) {
        this.wgs = wgs;
    }

    public Wba getWba() {
        return wba;
    }

    public void setWba(Wba wba) {
        this.wba = wba;
    }

    public Wzx getWzx() {
        return wzx;
    }

    public void setWzx(Wzx wzx) {
        this.wzx = wzx;
    }

    public WXb getWxb() {
        return wxb;
    }

    public void setWxb(WXb wxb) {
        this.wxb = wxb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTjr() {
        return tjr;
    }

    public void setTjr(String tjr) {
        this.tjr = tjr;
    }

    public List<TxnrVO> getTxnrList() {
        return txnrList;
    }

    public void setTxnrList(List<TxnrVO> txnrList) {
        this.txnrList = txnrList;
    }

    public TjgdmOnLineVO getOnLineVO() {
        return onLineVO;
    }

    public void setOnLineVO(TjgdmOnLineVO onLineVO) {
        this.onLineVO = onLineVO;
    }

    public String getTxbt() {
        return txbt;
    }

    public void setTxbt(String txbt) {
        this.txbt = txbt;
    }

    public String getTxnr() {
        return txnr;
    }

    public void setTxnr(String txnr) {
        this.txnr = txnr;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TJgdmSave getJgdmSave() {
        return jgdmSave;
    }

    public void setJgdmSave(TJgdmSave jgdmSave) {
        this.jgdmSave = jgdmSave;
    }

    public Boolean getNeedAudit() {
        return needAudit;
    }

    public void setNeedAudit(Boolean needAudit) {
        this.needAudit = needAudit;
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public String getShyj() {
        return shyj;
    }

    public void setShyj(String shyj) {
        this.shyj = shyj;
    }

    public String getShresult() {
        return shresult;
    }

    public void setShresult(String shresult) {
        this.shresult = shresult;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }
    public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJgmc() {
		return jgmc;
	}
	  
	public Integer getBack() {
		return back;
	}

	public void setBack(Integer back) {
		this.back = back;
	}

	public List<Wzcyh> getWzcyhList() {
		return wzcyhList;
	}

	public void setWzcyhList(List<Wzcyh> wzcyhList) {
		this.wzcyhList = wzcyhList;
	}

	public Wzcyh getWzcyh() {
		return wzcyh;
	}

	public void setWzcyh(Wzcyh wzcyh) {
		this.wzcyh = wzcyh;
	}

	public List<Wnj> getWnjList() {
		return wnjList;
	}

	public void setWnjList(List<Wnj> wnjList) {
		this.wnjList = wnjList;
	}

	public Wnj getWnj() {
		return wnj;
	}

	public void setWnj(Wnj wnj) {
		this.wnj = wnj;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public TJgdm getWjgdm() {
		return wjgdm;
	}

	public void setWjgdm(TJgdm wjgdm) {
		this.wjgdm = wjgdm;
	}

	
	

	
}
