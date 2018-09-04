package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.dao.TQzjgdmDAO;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: liuzy
 * Date: 13-9-2
 * Time: 下午14:35
 */
public class GsAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(GsAction.class);
    private static Object lock = new Object();
    private static GsBus gsBus = null;
    private Map<String, Object> session;
    private String currentPath;
    private String resultMsg;
    String zt=null;
    //注册号
    private String dzch;
    private String cwybs;
    private String jgdmcode;
    //是否开启业务流程
    private boolean isYwlc;
    //标识工商数据和代码数据不匹配需要换证
    private String card;
    private String gslx;
    private String source;
    

    private List<Qiye> qiyeList;
    private TJgdmSave jgdmSave;
    private Qiye qiye;
    private TJgdm tjgdm;
    private TJgdm jgdm;


    public GsAction() {
        if (gsBus == null) {
            gsBus = new GsBus();
        }
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    //验证工商注册号数据
    public String search() {

        currentPath = "/product/jsp/certificate/gsSearch.jsp";
        qiyeList = gsBus.findByZch(dzch);
        if (qiyeList != null && qiyeList.size() > 0) {
            gslx = "qy";
        } else {
            List<Gtgsh> gtList = gsBus.findGtByZch(dzch);
            if (gtList != null && gtList.size() > 0) {
                qiyeList = new ArrayList<Qiye>();
                for (Gtgsh gt : gtList) {
                    Qiye qy = new Qiye();
                    BeanUtilsEx.copyProperties(qy, gt);
                    qiyeList.add(qy);
                }
                gslx = "gt";
            } else {
                resultMsg = "该企业未在工商登记！<br/>营业执照发证日期是否为当天？<br/>当前时间" + DateUtil.dateToStr(new Date());
            }
        }
        return this.SUCCESS;
    }

    //提取工商数据
    public String findGs() {
        currentPath = "/product/jsp/certificate/addinfomationEnter.jsp";
        jgdmSave = gsBus.findGsTojgdm(cwybs, gslx);
        if (source.equals("outerIn")) {
            currentPath = "/product/jsp/changeBZAddress/outerIn.jsp";
            jgdmSave.setJgdm(jgdmcode);
            jgdm = new TJgdm();
            BeanUtilsEx.copyProperties(jgdm, jgdmSave);
        }

        return this.SUCCESS;
    }

    //通过注册号提取工商数据
    public String findGsByZch() {

        currentPath = "/product/jsp/dailybusiness/gsData.jsp";
        TjgdmBus jgdmBus = new TjgdmBus();
        if (source.equals("innerIn")) {
            List<TQzjgdm> tjList = new TQzjgdmDAO().findByProperty("jgdm", jgdmcode);
            if (tjList != null && tjList.size() > 0) {
                tjgdm = new TJgdm();
                BeanUtilsEx.copyProperties(tjgdm, tjList.get(0));
            }
        } else {
            tjgdm = jgdmBus.findById(jgdmcode);
        }
        if (tjgdm.getJglx().trim().matches("[bB]")) {
            List<Gtgsh> gtList = gsBus.findGtByZch(dzch);
            if (!gtList.isEmpty()) {
                qiyeList = new ArrayList<Qiye>();
                for (Gtgsh gt : gtList) {
                    qiye = new Qiye();
                    BeanUtilsEx.copyProperties(qiye, gt);
                    qiyeList.add(qiye);
                }
            }

        } else {
            qiyeList = gsBus.findByZch(dzch);
        }
        
        if (qiyeList != null && qiyeList.size() > 0) {
        	for(Qiye q:qiyeList){
        		if("正常".equals(q.getCdqzt().trim())){
        			zt="正常";
        		}
        	}
        	if(zt==null){
        		zt="吊销";
        	}
        	
        } else {
            resultMsg = "该企业未在工商登记！";
        }
        return this.SUCCESS;
    }

    //工商数据和代码库数据对比
    public String gsVsBsData() {
        currentPath = "/product/jsp/dailybusiness/gsData.jsp";

        TjgdmBus jgdmBus = new TjgdmBus();
        if (source.equals("innerIn")) {
            List<TQzjgdm> tjList = new TQzjgdmDAO().findByProperty("jgdm", jgdmcode);
            if (tjList != null && tjList.size() > 0) {
                tjgdm = new TJgdm();
                BeanUtilsEx.copyProperties(tjgdm, tjList.get(0));
            }
        } else {
            tjgdm = jgdmBus.findById(jgdmcode);
        }
        if (tjgdm != null) {
            if (tjgdm.getJglx().trim().matches("[bB]")) {
                List<Gtgsh> gtList = gsBus.findGtByZch(dzch);
                if (gtList != null && gtList.size() > 0) {
                    Gtgsh gt = gtList.get(0);
                    qiye = new Qiye();
                    BeanUtilsEx.copyProperties(qiye, gt);
                  }
            } else {
                List<Qiye> qyList = gsBus.findByZch(dzch);
                if (qyList != null && qyList.size() > 0) {
                    qiye = qyList.get(0);

                }
            }


            if (source.equals("check") && !tjgdm.getFddbr().equals(qiye.getVchrXm()) && !tjgdm.getJgdz().equals(qiye.getVzs()) && !tjgdm.getJgmc().equals(qiye.getVqymc())) {
                card = "changeCard";
            }
        }
        return SUCCESS;
    }

    public String getDzch() {
        return dzch;
    }

    public void setDzch(String dzch) {
        this.dzch = dzch;
    }

    public boolean isYwlc() {
        return isYwlc;
    }

    public void setYwlc(boolean ywlc) {
        isYwlc = ywlc;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public List<Qiye> getQiyeList() {
        return qiyeList;
    }

    public void setQiyeList(List<Qiye> qiyeList) {
        this.qiyeList = qiyeList;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public TJgdmSave getJgdmSave() {
        return jgdmSave;
    }

    public void setJgdmSave(TJgdmSave jgdmSave) {
        this.jgdmSave = jgdmSave;
    }

    public String getCwybs() {
        return cwybs;
    }

    public void setCwybs(String cwybs) {
        this.cwybs = cwybs;
    }

    public String getJgdmcode() {
        return jgdmcode;
    }

    public void setJgdmcode(String jgdmcode) {
        this.jgdmcode = jgdmcode;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public TJgdm getTjgdm() {
        return tjgdm;
    }

    public void setTjgdm(TJgdm tjgdm) {
        this.tjgdm = tjgdm;
    }

    public Qiye getQiye() {
        return qiye;
    }

    public void setQiye(Qiye qiye) {
        this.qiye = qiye;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getGslx() {
        return gslx;
    }

    public void setGslx(String gslx) {
        this.gslx = gslx;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}
    
}
