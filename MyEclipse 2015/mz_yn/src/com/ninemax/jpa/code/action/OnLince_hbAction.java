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
 * �������ʡ����ϵͳ����.
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
    //�ǼǺ��б�
    private List<String> djhs;
    //�����б�
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
    //�Ƿ��Ѿ����
    private Boolean audit;
    //�������
    protected String shyj;
    //��˽��
    protected String shresult;
    //��ʾ��Ϣ
    private String prompt;
    //�°촦��
    private String[] infos;

    //��ҳ����
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;

    //ҵ����
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

    //ǰ������or�걨������
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
        //4 ��ʧҵ�� 5����ҵ�� 6ע�� ���� �°������ҵ��
        list = online_hbBus.getOnlineList(ywlx,dm,user,"1",pageno, rowNumsView, pages);
        return this.SUCCESS;
    }
    
    
    
    /**
     * ����걨
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
     * ��������걨
     * @return
     */
    public String nbUpdate(){
    	message="����걨���³ɹ���";
		User user = (User) session.get("sysUser");
		if (pages == null)
			pages = new clsPageComponent();
		currentPath = "/product/jsp/online/success.jsp";
		TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
		// 1�Ƕ������ 0�ǰ�֤���ڼ�һ��
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
        	message="��Ӧ��Y��X�µ����봰�ڰ���֤".replace("X", calendar2.get(calendar.MONTH)+2 + "").replace("Y", calendar2.get(Calendar.YEAR) + "");
            //isPrint = false;
           
        }else{
        	calendar2.setTime(jgdm.getNjqx());
        	message="��Ӧ��Y��X�½�����ȱ���".replace("X", calendar2.get(calendar.MONTH)+1 + "").replace("Y", calendar2.get(Calendar.YEAR)+1 + "");
        	
        }
    	
    
    	 return this.SUCCESS;

    }
    

    /**
     * ��ʧ����
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
            prompt = "�������루"+dm+")������ԤԼ��ʧ��֤��,�޷�����֤��ȷ�Ϲ�ʧ������";
        }
        infos = online_hbBus.getXbclInfo(id);
        wgs = online_hbBus.getWgs(id);
        return this.SUCCESS;
    }

    /**
     * ��������
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
     * ע������
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
        //����ҵ���°�
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
             jgdmSave.setBak4(appJgdmsb.getBlcode());//�����appJgdmsb���ڵ�blcodeֵ����jgdmSave��back4��,�Ա㱣��ɹ�ʱ����appJgdmsb��
         }

        return this.SUCCESS;
    }

    /**
     * �°�����
     */
    public String xbSp(){
        //�״��°�
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
     * ����ͨ��  lrr��Ϊ1
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
	            message = "�°���˳ɹ�!";
	        }
	        if("1".equals(ywlx)){
	            message = "�����˳ɹ�!";
	        }
	        if("2".equals(ywlx)){
	            message = "�����˳ɹ�!";
	        }
	        if("3".equals(ywlx)){
	            message = "��֤��˳ɹ�!";
	        }
	        if("4".equals(ywlx)){
	            message = "��ʧ��˳ɹ�!";
	        }
	        if("5".equals(ywlx)){
	            message = "������˳ɹ�!";
	        }
	        if("6".equals(ywlx)){
	            message = "ע����˳ɹ�!";
	        }
        }else{
        	message = "���ʧ��!";
        }
        return this.SUCCESS;
    }
    /**
     * ������ͨ�� lrr��Ϊ3
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
    			message = "("+jgmc+")�°�ҵ��,�����Ϊ��ͨ��!";
    		}
    		if("1".equals(ywlx)){
    			message = "("+dm+")���ҵ��,�����Ϊ��ͨ��!";
    		}
    		if("2".equals(ywlx)){
    			message = "("+dm+")���ҵ��,�����Ϊ��ͨ��!";
    		}
    		if("3".equals(ywlx)){
    			message = "("+dm+")��֤ҵ��,�����Ϊ��ͨ��!";
    		}
    		if("4".equals(ywlx)){
    			message = "("+dm+")��ʧҵ��,�����Ϊ��ͨ��!";
    		}
    		if("5".equals(ywlx)){
    			message = "������˳ɹ�!";
    		}
    		if("6".equals(ywlx)){
    			message = "("+dm+")ע��ҵ��,�����Ϊ��ͨ��!";
    		}
    	}else{
    		message = "���ʧ��!";
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
                message = "��ӳɹ�!";
            }else
                message = "���ʧ��!";
            currentPath=url;
            return SUCCESS;
        }else if("delete".equals(fn)){
            boolean flag = online_hbBus.delSpNote(txbt, userName);
            if(flag){
                message = "ɾ���ɹ�!";
            }else
                message = "ɾ��ʧ��!��������Ϊ�ϼ���������";
            currentPath=url;
            return SUCCESS;
        }else{
            if(clsStringTool.isEmpty(id)){
                message = "�Ƿ���������������µ�¼!";
            }else{
                boolean flag = false;
                if("0".equals(ywlx)){
                    flag = online_hbBus.updateXB(id,state,session);
                    message = "�°���˳ɹ�!";
                }
                if("1".equals(ywlx)){
                    flag = online_hbBus.updateNJ(id,state,dm,session);
                    message = "�����˳ɹ�!";
                }
                if("2".equals(ywlx)){
                    flag = online_hbBus.updateBG(id,state,dm,session);
                    message = "�����˳ɹ�!";
                }
                if("3".equals(ywlx)){
                    flag = online_hbBus.updateHZ(id,state,dm,session);
                    message = "��֤��˳ɹ�!";
                }
                if("4".equals(ywlx)){
                    flag = online_hbBus.updateGS(id,state,dm,session);
                    message = "��ʧ��˳ɹ�!";
                }
                if("5".equals(ywlx)){
                    flag = online_hbBus.updateBA(id,state,dm,session);
                    message = "������˳ɹ�!";
                }
                if("6".equals(ywlx)){
                    flag = online_hbBus.updateZX(id,state,dm,session);
                    message = "ע����˳ɹ�!";
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
