package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.dao.TBgkDAO;
import com.ninemax.jpa.code.dao.TZsDAO;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-21
 * Time: 下午5:29
 */
public class PrintRequisitionAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String currentPath = "";
    private List<TjgdmVO> list;
    private List<TjgdmVO> jgdmList;
    private List<TQzjgdm> qzjgdmList;
    private List<TFzdm> fzdmList;
    private List<TYwlc> ywlcList;

    
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;
    private String orderbyColum;
    private String orderbyMethod;

    private TJgdmSaveBus saveBus;
    private TFzdmBus fzdmBus;
    private TjgdmBus tjgdmBus;
    private TQzjgdmBus tQzjgdmBus;
    private SerialBus serialBus;
    private TywlcBus ywlcBus;

    private TJgdm tjgdm;
    private TJgdmSave jgdmSave;
    private TFzdm fzdm;
    private TQzjgdm qzjgdm;

    private String id;
    private String jgdm;
    private String jgmc;
    private String bzjgdm;
    private String resultMessage;

    private String gslsh;
    //是否开启业务流程
    private boolean isYwlc;
    private String ywlsh = "";
    private String type;
    private String need;

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public PrintRequisitionAction() {
        saveBus = new TJgdmSaveBus();
        fzdmBus = new TFzdmBus();
        tjgdmBus = new TjgdmBus();
        tQzjgdmBus = new TQzjgdmBus();
        serialBus = new SerialBus();
        ywlcBus = new TywlcBus();
    }


    public String list() {
        User user = (User) session.get("sysUser");
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        currentPath = "/product/jsp/requisition/preCodeFormList.jsp";
        if (pages == null){
        	pages = new clsPageComponent();
        	}
        if(jgmc==null&&jgdm==null){
        	return this.SUCCESS;
        }
        Map<String, String> params = new HashedMap();
        params.put("djblx", "2");
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        if (!clsStringTool.isEmpty(ywlsh)) {
            params.put("ywlsh", ywlsh);
        }
        /*if(isYwlc){
            currentPath = "/product/jsp/requisition/preCodeFormYwlcList.jsp";
            ywlcList = ywlcBus.listNewYwlc("2","受理",params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        }else*/
        list = saveBus.listTjgdmSave(user, "2", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        if(list!=null&&list.size()==1){
        	printPage();
        }
        return this.SUCCESS;
    }

    
    
    public String gsList() {
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/requisition/gsFormList.jsp";
        
        if (pages == null){
        	pages = new clsPageComponent();
        	}
        if(jgmc==null&&jgdm==null){
        	return this.SUCCESS;
        }
        Map<String, String> params = new HashedMap();
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
        	params.put("jgdm", jgdm);
        }
        jgdmList = tjgdmBus.listTjgdm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        if(jgdmList!=null&&jgdmList.size()==1){
        	gsPrintForm();
        }
        return this.SUCCESS;
    }

    public String bgList() {
        currentPath = "/product/jsp/requisition/bgFormList.jsp";
        return this.SUCCESS;
    }

    /**
     * 迁址通知到列表
     *
     * @return
     */
    public String qzList() {
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/requisition/qzFormList.jsp";
        if (pages == null){
        	pages = new clsPageComponent();
        	}
        if(jgmc==null&&jgdm==null){
        	return this.SUCCESS;
        }
        Map<String, String> params = new HashedMap();
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        qzjgdmList = tQzjgdmBus.listQzTjgdm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        if(qzjgdmList!=null&&qzjgdmList.size()==1){
        	qzPrintForm();
        }
        return this.SUCCESS;
    }

    /**
     * 注销通知到列表
     *
     * @return
     */
    public String fzList() {
    	
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/requisition/fzFormList.jsp";
        if (pages == null){
        	pages = new clsPageComponent();
        	}
        if(jgmc==null&&jgdm==null){
        	return this.SUCCESS;
        }
        Map<String, String> params = new HashedMap();
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        fzdmList = fzdmBus.listFzTjgdm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        if(fzdmList!=null&&fzdmList.size()==1){
        	fzPrintForm();
        }
        return this.SUCCESS;
    }

    public String printPage() {
        currentPath = "/product/jsp/requisition/preCodeFormPrint.jsp";
        jgdmSave = saveBus.findByJgdm(jgdm);
        if (jgdmSave == null) {
            jgdmSave = saveBus.findByJgdm(jgdm);
        }
        if (jgdmSave == null) {
            currentPath = "/bsweb/requisition_list.action";
        }
        return this.SUCCESS;
    }


    public String gsPrintForm() {
        currentPath = "/product/jsp/requisition/preGsFormPrint.jsp";
        tjgdm = tjgdmBus.findById(jgdm);
        if (tjgdm == null) {
            currentPath = "/bsweb/requisition_gsList.action";
        } else {
            gslsh = serialBus.getLsh("100000", "2");
            serialBus.updateLsh(1, "100000", "2");
        }
        return this.SUCCESS;
    }

    public String bgPrintForm() {
        currentPath = "/product/jsp/requisition/preBgFormPrint.jsp";
        EntityManager em = EntityManagerHelper.getEntityManager();
        tjgdm = em.find(TJgdm.class, jgdm);
        em.clear();
        if (tjgdm == null) {
            currentPath = "/bsweb/requisition_bgList";
            resultMessage = "查询的机构代码不存在！";
        } else {

            List<TZs> zss = em.createQuery("select model from TZs model where model.jgdm=?1 and model.zstype=?2 order by  model.fzsj desc").setParameter(1, jgdm).setParameter(2, "0").getResultList();
            if (zss != null && !zss.isEmpty()) {
                tjgdm.setZslsh(zss.get(0).getDjh());
            }
            List<TBgk> bgks = em.createQuery("select model from TBgk model where model.jgdm='" + tjgdm.getJgdm() + "' order by model.lastdate desc").getResultList();
            if (bgks != null && !bgks.isEmpty()) {
                tjgdm.setJgdz(bgks.get(0).getJgmc());
            } else {
                tjgdm.setJgdz(tjgdm.getJgmc());
            }
            em.clear();
        }
        EntityManagerHelper.closeEntityManager();
        return this.SUCCESS;
    }

    public String viewgsPage() {
        currentPath = "/product/jsp/requisition/gsView.jsp";
        tjgdm = tjgdmBus.findById(jgdm);
        if (tjgdm == null) {
            currentPath = "/bsweb/requisition_gsList.action";
        } else {
            gslsh = serialBus.getLsh("100000", "2");
            serialBus.updateLsh(1, "100000", "2");
        }
        return this.SUCCESS;
    }

    public String viewQzPage() {
        currentPath = "/product/jsp/requisition/qzView.jsp";
        qzjgdm = tQzjgdmBus.getQzjgdm(jgdm);
        if (qzjgdm == null) {
            currentPath = "/bsweb/requisition_qzList.action";
        }
        return this.SUCCESS;
    }

    public String viewFzPage() {
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/requisition/fzView.jsp";
        fzdm = fzdmBus.getFzdm(jgdm, user.getBzjgdm());
        if (fzdm == null) {
            currentPath = "/bsweb/requisition_fzList.action";
        }
        return this.SUCCESS;
    }

    public String fzPrintForm() {
        currentPath = "/product/jsp/requisition/preFzFormPrint.jsp";
        fzdm = fzdmBus.findById(jgdm);
        if (fzdm == null) {
            currentPath = "/bsweb/requisition_fzList.action";
        }
        return this.SUCCESS;
    }

    public String qzPrintForm() {
        currentPath = "/product/jsp/requisition/preQzFormPrint.jsp";
        qzjgdm = tQzjgdmBus.getQzjgdm(jgdm);
        if (qzjgdm == null) {
            currentPath = "/bsweb/requisition_qzList.action";
        }
        return this.SUCCESS;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public List<TjgdmVO> getList() {
        return list;
    }

    public void setList(List<TjgdmVO> list) {
        this.list = list;
    }

    public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
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

    public String getOrderbyColum() {
        return orderbyColum;
    }

    public void setOrderbyColum(String orderbyColum) {
        this.orderbyColum = orderbyColum;
    }

    public String getOrderbyMethod() {
        return orderbyMethod;
    }

    public void setOrderbyMethod(String orderbyMethod) {
        this.orderbyMethod = orderbyMethod;
    }

    public TJgdmSave getJgdmSave() {
        return jgdmSave;
    }

    public void setJgdmSave(TJgdmSave jgdmSave) {
        this.jgdmSave = jgdmSave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public TJgdm getTjgdm() {
        return tjgdm;
    }

    public void setTjgdm(TJgdm tjgdm) {
        this.tjgdm = tjgdm;
    }

    public TFzdm getFzdm() {
        return fzdm;
    }

    public void setFzdm(TFzdm fzdm) {
        this.fzdm = fzdm;
    }

    public TQzjgdm getQzjgdm() {
        return qzjgdm;
    }

    public void setQzjgdm(TQzjgdm qzjgdm) {
        this.qzjgdm = qzjgdm;
    }

    public String getGslsh() {
        return gslsh;
    }

    public void setGslsh(String gslsh) {
        this.gslsh = gslsh;
    }

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<TjgdmVO> getJgdmList() {
        return jgdmList;
    }

    public void setJgdmList(List<TjgdmVO> jgdmList) {
        this.jgdmList = jgdmList;
    }

    public List<TQzjgdm> getQzjgdmList() {
        return qzjgdmList;
    }

    public void setQzjgdmList(List<TQzjgdm> qzjgdmList) {
        this.qzjgdmList = qzjgdmList;
    }

    public List<TFzdm> getFzdmList() {
        return fzdmList;
    }

    public void setFzdmList(List<TFzdm> fzdmList) {
        this.fzdmList = fzdmList;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    public boolean isYwlc() {
        return isYwlc;
    }

    public void setYwlc(boolean ywlc) {
        isYwlc = ywlc;
    }

    public List<TYwlc> getYwlcList() {
        return ywlcList;
    }

    public void setYwlcList(List<TYwlc> ywlcList) {
        this.ywlcList = ywlcList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
}
