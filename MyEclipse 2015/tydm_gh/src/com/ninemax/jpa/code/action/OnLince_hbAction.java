package com.ninemax.jpa.code.action;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.ninemax.jpa.code.bus.Online_hbBus;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.bus.TSpBus;
import com.ninemax.jpa.code.bus.TjgdmBus;
import com.ninemax.jpa.code.bus.WsbzXbBus;
import com.ninemax.jpa.code.model.AppJgdmsb;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.code.model.WXb;
import com.ninemax.jpa.code.model.Wgs;
import com.ninemax.jpa.code.model.Wnj;
import com.ninemax.jpa.code.model.Wzcyh;
import com.ninemax.jpa.code.model.vo.OnLineVO;
import com.ninemax.jpa.code.model.vo.TjgdmOnLineVO;
import com.ninemax.jpa.code.model.vo.TxnrVO;
import com.ninemax.jpa.code.model.vo.Wba;
import com.ninemax.jpa.code.model.vo.Wzx;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理湖北省网上系统数据.
 * User: TengWuChao
 * Date: 2014-05-12
 */
public class OnLince_hbAction extends ActionSupport implements SessionAware{

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
    private Online_hbBus online_hbBus;
    private TjgdmBus tjgdmBus;
    private WsbzXbBus wsbzBus;
    private TJgdmSaveBus saveBus;
    private TSpBus tSpBus;
    
    private String jgmc;
    
    
    private Integer back;
    
    
    private String fn;
    
    private AppJgdmsb appJgdmsb;
    
    private String spnoxxnr="";

  

	public OnLince_hbAction() {
        online_hbBus = new Online_hbBus();
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
        currentPath = "/product/jsp/online/SP100100_hb.jsp";
        return this.SUCCESS;
    }

    public String jdChoose() {
        currentPath = "/product/jsp/online/SP100101_hb.jsp";
        return this.SUCCESS;
    }

    public String list(){
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        currentPath = "/product/jsp/online/SPQuerylist_hb_new.jsp";
        list = online_hbBus.getOnlineList(ywlx,dm,user,"0",pageno, rowNumsView, pages);
        return this.SUCCESS;
    }
    public String test(){
//    	currentPath = "/product/jsp/online/test.jsp";
//    	ActionContext.getContext().put("ZCH", "330226000105628");
//    	UrlClient nHttpClient=new UrlClient();
//    	//String resstring=(String)nHttpClient.GetUrlSource("http://221.136.70.252/gsweb/lawcasedlg/get_gs_dlg.jsp?ZCH=330226000105628");
//    	String resstring=(String)nHttpClient.GetUrlSource("http://115.238.160.26/gsweb/lawcasedlg/get_gs_dlg.jsp?ZCH=330226000105628");
//    	System.out.println(resstring);
    	return this.SUCCESS;
    }
    
    public String jdList(){
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        currentPath = "/product/jsp/online/JDQuerylist_hb_new.jsp";
        //4 挂失业务 5备案业务 6注销 其它 新办里面的业务
        list = online_hbBus.getOnlineList(ywlx,dm,user,"1",pageno, rowNumsView, pages);
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
        
        wnjList = online_hbBus.getNjList(dm,user,zt,pageno, rowNumsView, pages);
        
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
    
        
        online_hbBus.nbUpdate(dm,id,uDate);
        
        return this.SUCCESS;
    	
    }
    
    
    public String ndbg_print() throws SQLException {
    	currentPath = "/product/jsp/online/ndbg_print.jsp";
    	TjgdmBus bus=new TjgdmBus();
    	Online_hbBus online=new Online_hbBus();
    	
    	jgdm=bus.findById(dm);
    	wnj=online.getNj(id);
    	
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
      
			calendar2.setTime(jgdm.getZfrq());
        calendar2.add(Calendar.DAY_OF_YEAR, -30);
        if (calendar.getTime().after(calendar2.getTime())) {
        	message="您应于Y年X月到代码窗口办理换证".replace("X", calendar2.get(calendar.MONTH)+2 + "").replace("Y", calendar2.get(Calendar.YEAR) + "");
            //isPrint = false;
           
        }else{
        	calendar2.setTime(jgdm.getNjqx());
        	message="您应于Y年X月进行年度报告".replace("X", calendar2.get(calendar.MONTH)+1 + "").replace("Y", calendar2.get(Calendar.YEAR)+1 + "");
        	
        }
    	
    
    	 return this.SUCCESS;

    }
    

    /**
     * 挂失审批
     * @return
     */
    public String gsSp(){
        currentPath = "/product/jsp/online/gsSp.jsp";
        getStatus();
        jgdm = tjgdmBus.findById(dm);
        djhs = online_hbBus.getDjhs(dm);
        session.put("djhs", djhs);
        if(djhs==null){
            currentPath = "/product/jsp/online/prompt.jsp";
            prompt = "机构代码（"+dm+")无网上预约挂失的证书,无法进行证书确认挂失操作！";
        }
        infos = online_hbBus.getXbclInfo(id);
        wgs = online_hbBus.getWgs(id);
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
        infos = online_hbBus.getXbclInfo(id);
        wba = online_hbBus.getWba(id);
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
        infos = online_hbBus.getZxclInfo(dm);
        wzx = online_hbBus.getWzx(id);
        return this.SUCCESS;
    }

    
    public String xbJd(){
        //网上业务新办
    	 if("0".equals(ywlx)){
             currentPath = "/product/jsp/online/addinfomationOnline.jsp";
             appJgdmsb= this.online_hbBus.find(id);
             jgdmSave=new TJgdmSave();
             BeanUtilsEx.copyProperties(jgdmSave, appJgdmsb);
             jgdmSave.setTbrxm(appJgdmsb.getTbr());
             jgdmSave.setTbrsfzh(appJgdmsb.getTbrzjhm());
             jgdmSave.setTbrlxfs(appJgdmsb.getTbrmobile());
             jgdmSave.setFbsl(appJgdmsb.getSqfbsl());
             jgdmSave.setFkbz(appJgdmsb.getQtxxcp());
             jgdmSave.setFksl(1);
             jgdmSave.setMemo(appJgdmsb.getTbrbz());
             jgdmSave.setBak4(appJgdmsb.getBlcode());//这里把appJgdmsb表内的blcode值存入jgdmSave的back4内,以便保存成功时更新appJgdmsb表
         }

        return this.SUCCESS;
    }

    /**
     * 新办审批
     */
    public String xbSp(){
        //首次新办
            currentPath = "/product/jsp/online/sp_hb.jsp";
        appJgdmsb= this.online_hbBus.find(id);
        jgdm=new TJgdm();
        BeanUtilsEx.copyProperties(jgdm, appJgdmsb);
        jgdm.setTbrxm(appJgdmsb.getTbr());
        jgdm.setTbrsfzh(appJgdmsb.getTbrzjhm());
        jgdm.setTbrlxfs(appJgdmsb.getTbrmobile());
        jgdm.setFbsl(appJgdmsb.getSqfbsl());
        jgdm.setFkbz(appJgdmsb.getQtxxcp());
        jgdm.setMemo(appJgdmsb.getTbrbz());
        jgdm.setFksl(1);
        
        
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
    /**
     * 审批通过  lrr改为1
     * @return
     */
    public String spTg(){
        HttpServletRequest request = ServletActionContext.getRequest();
        url = request.getRequestURI();
        if (request.getQueryString() != null) {
            url = url + "?" + request.getQueryString();
        }
        
        currentPath = "/bsweb/onLinehb_list.action";
       boolean b = online_hbBus.updateSpAppJgdmsb(id,"1",spnoxxnr);
        if(b){
	        if("0".equals(ywlx)){
	            message = "新办审核成功!";
	        }
	        if("1".equals(ywlx)){
	            message = "年检审核成功!";
	        }
	        if("2".equals(ywlx)){
	            message = "变更审核成功!";
	        }
	        if("3".equals(ywlx)){
	            message = "换证审核成功!";
	        }
	        if("4".equals(ywlx)){
	            message = "挂失审核成功!";
	        }
	        if("5".equals(ywlx)){
	            message = "备案审核成功!";
	        }
	        if("6".equals(ywlx)){
	            message = "注销审核成功!";
	        }
        }else{
        	message = "审核失败!";
        }
        return this.SUCCESS;
    }
    /**
     * 审批不通过 lrr改为3
     * @return
     */
    public String spBtg(){
    	HttpServletRequest request = ServletActionContext.getRequest();
    	url = request.getRequestURI();
    	if (request.getQueryString() != null) {
    		url = url + "?" + request.getQueryString();
    	}
    	
    	currentPath = "/bsweb/onLinehb_list.action";
    	boolean b = online_hbBus.updateSpAppJgdmsb(id,"3",spnoxxnr);
    	if(b){
    		if("0".equals(ywlx)){
    			message = "("+jgmc+")新办业务,已审核为不通过!";
    		}
    		if("1".equals(ywlx)){
    			message = "("+dm+")年检业务,已审核为不通过!";
    		}
    		if("2".equals(ywlx)){
    			message = "("+dm+")变更业务,已审核为不通过!";
    		}
    		if("3".equals(ywlx)){
    			message = "("+dm+")换证业务,已审核为不通过!";
    		}
    		if("4".equals(ywlx)){
    			message = "("+dm+")挂失业务,已审核为不通过!";
    		}
    		if("5".equals(ywlx)){
    			message = "备案审核成功!";
    		}
    		if("6".equals(ywlx)){
    			message = "("+dm+")注销业务,已审核为不通过!";
    		}
    	}else{
    		message = "审核失败!";
    	}
    	return this.SUCCESS;
    }

    public String spNoView(){
        currentPath = "/product/jsp/online/spNoView.jsp";
        return this.SUCCESS;
    }


    public String spNoteHandle(){
        currentPath = "/product/jsp/online/spNotePrompt.jsp";
        User user = (User) session.get("sysUser");
        String userName = user.getUserName();
        if("save".equals(fn)){
            boolean flag = online_hbBus.saveSpNote(txbt, txnr, userName);
            if(flag){
                message = "添加成功!";
            }else
                message = "添加失败!";
            currentPath=url;
            return SUCCESS;
        }else if("delete".equals(fn)){
            boolean flag = online_hbBus.delSpNote(txbt, userName);
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
                    flag = online_hbBus.updateXB(id,state,session);
                    message = "新办审核成功!";
                }
                if("1".equals(ywlx)){
                    flag = online_hbBus.updateNJ(id,state,dm,session);
                    message = "年检审核成功!";
                }
                if("2".equals(ywlx)){
                    flag = online_hbBus.updateBG(id,state,dm,session);
                    message = "变更审核成功!";
                }
                if("3".equals(ywlx)){
                    flag = online_hbBus.updateHZ(id,state,dm,session);
                    message = "换证审核成功!";
                }
                if("4".equals(ywlx)){
                    flag = online_hbBus.updateGS(id,state,dm,session);
                    message = "挂失审核成功!";
                }
                if("5".equals(ywlx)){
                    flag = online_hbBus.updateBA(id,state,dm,session);
                    message = "备案审核成功!";
                }
                if("6".equals(ywlx)){
                    flag = online_hbBus.updateZX(id,state,dm,session);
                    message = "注销审核成功!";
                }
                if(flag){
                     boolean updateFlag = online_hbBus.updateData(tjr,dm,txbt,txnr,opt,userName);
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

	public AppJgdmsb getAppJgdmsb() {
		return appJgdmsb;
	}

	public void setAppJgdmsb(AppJgdmsb appJgdmsb) {
		this.appJgdmsb = appJgdmsb;
	}

	public String getSpnoxxnr() {
		return spnoxxnr;
	}

	public void setSpnoxxnr(String spnoxxnr) {
		this.spnoxxnr = spnoxxnr;
	}

	

	
}
