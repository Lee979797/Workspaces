package com.ninemax.jpa.code.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;

import net.sf.cglib.beans.BeanCopier;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jspsmart.upload.Request;
import com.ninemax.jpa.code.bus.SerialBus;
import com.ninemax.jpa.code.bus.TFzdmBus;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.bus.TQtmdkBus;
import com.ninemax.jpa.code.bus.TQzjgdmBus;
import com.ninemax.jpa.code.bus.TSpBus;
import com.ninemax.jpa.code.bus.TSpdmtempBus;
import com.ninemax.jpa.code.bus.TZsBus;
import com.ninemax.jpa.code.bus.TZsdsBus;
import com.ninemax.jpa.code.bus.TjgdmBus;
import com.ninemax.jpa.code.bus.TywlcBus;
import com.ninemax.jpa.code.bus.WsbzXbBus;
import com.ninemax.jpa.code.dao.TJgdmSaveDAO;
import com.ninemax.jpa.code.model.Gtgsh;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.Qiye;
import com.ninemax.jpa.code.model.ScZw;
import com.ninemax.jpa.code.model.TBgk;
import com.ninemax.jpa.code.model.TCfjlb;
import com.ninemax.jpa.code.model.TFddbr;
import com.ninemax.jpa.code.model.TFrjl;
import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TFzdmBs;
import com.ninemax.jpa.code.model.TFzr;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmBs;
import com.ninemax.jpa.code.model.TJgdmHis;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TJgdmdm;
import com.ninemax.jpa.code.model.TNNjjlx;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.code.model.TSp;
import com.ninemax.jpa.code.model.TSpdmtemp;
import com.ninemax.jpa.code.model.TYwlc;
import com.ninemax.jpa.code.model.TZs;
import com.ninemax.jpa.code.model.TZsds;
import com.ninemax.jpa.code.model.Wgs;
import com.ninemax.jpa.code.model.vo.TjgdmCommon;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
import com.ninemax.jpa.code.model.vo.TywlcVO;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.CodeAssignClient;
import com.ninemax.jpa.util.CommonPropertiesUtil;
import com.ninemax.jpa.util.Constants;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.PropertiesUtils;
import com.ninemax.jpa.util.TydmDemo;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import com.ninemax.tygs.bus.TyGsBus;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-6
 * Time: 上午10:08
 */
public class IssueCertificateAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(IssueCertificateAction.class);
    private Map<String, Object> session;
    private TJgdmSaveBus saveBus;
    private WsbzXbBus wsbzBus;
    private TjgdmBus jgdmBus;
    private TJgdmSave jgdmSave;  
    private TJgdm tjgdm;
    private TQzjgdm qzjgdm;
    private TFzdm fzdm;
    private TFzdmBus fzdmBus;
    private TQzjgdmBus qzjgdmBus;
    private TQtmdkBus qtmdkBus;
    private TSpBus tSpBus;
    private TywlcBus ywlcBus;
    private String currentPath = "";
    private String resultMsg = "";
    private String ywlsh = "";
    private List<TjgdmVO> list;
    private List<TjgdmVO> vList;
    private List<TjgdmVO> tjgdmList; 
    private List<TZs> zsList;
    private List<TZsds> zsdsList;
    private List<TYwlc> ywlcList;
    private List<TywlcVO> ywlcDelList;
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;
    private String orderbyColum;
    private String orderbyMethod;
    private String id;
    private String businessId;
    private List<TCfjlb> cfjlbList;
    private List<TjgdmCommon> commonList;
    private Wgs wgs;
    private static Object lock = new Object();
    //type 用于页面跳转判断是查看 修改还是校对
    private String type;
    //登记表0，其它部门赋码1，预赋码2, 换证3 申请表单修改 4
    private String formType;
    private String jgdm;
    private String jgmc;
    private String bzjgdm;
    //申请表修改或删除标示以及证书挂失模块
    private String source;
    //标示返回按钮返回何处
    private String path;
    private String checkCfjl;

    //申请表删除信息提示
    private String delMessage;
    //需要审核标记
    private Boolean needAudit;
    //是否已经审核
    private Boolean audit;
    //重名是否审核
    private Boolean repeatAudit;
    //审核类型
    protected String ywlx;
    //审核依据
    protected String shyj;
    //审核结果
    protected String shresult;
    //注册号
    private String dzch;
    //机构名称
    private String dcodeName;
    //标示其他部门赋码删除及预赋码删除 1其他部门 2 预赋码 4 申请表删除
    private String delType;
    //是否开启业务流程
    private boolean isYwlc;
    private boolean codeNameRepeat;
    private String sourceTable;
    //点击链接是否显示数据默认不显示
    private String showData;
    //重名判断
    private String nameType;
    //权限类型
    private String submitType;
    //标识是网上来的数据
    private String djblx;
    private String djh;
    private String wsBzjgdm;
    private String jglx;
    private String sslcode;
    private String bak3;
    private String tyshxydm;
    private List<TNNjjlx> jjlx;
    private List<TFddbr> listFzr;
    private TFzr fzr;
    private TFddbr tfddbr;
    private TFddbr fddbr;
    private TFrjl frjl;
    private String isdang;
    private List<ScZw> zwList;
    private List<TJgdmdm> jgdmdmList;
    private TJgdmdm jgdmdm;
    private Page page;

	public IssueCertificateAction() {
        saveBus = new TJgdmSaveBus();
        jgdmBus = new TjgdmBus();
        fzdmBus = new TFzdmBus();
        qzjgdmBus = new TQzjgdmBus();
        qtmdkBus = new TQtmdkBus();
        tSpBus = new TSpBus();
        ywlcBus = new TywlcBus();
        wsbzBus = new WsbzXbBus();
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    

  
    
    public String add() {
        //isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        User user = (User) session.get("sysUser");
        HttpServletRequest request = setValue("add");
        getDate(request, jgdmSave);
        //如果是其它部门赋码添加需要先验证机构代码是否存在
        if ("1".equals(formType)) {
           // boolean flag = qtmdkBus.existCode(jgdm, 4);
            if (false) {
                resultMsg = "codeNotExist";
                return this.SUCCESS;
            } else {
                if (saveBus.isExistJgdm(jgdm)) {
                    resultMsg = "jgdmRepeat";
                    return "repeat";
                }
            }
        }
        /*//判断重复
        if (isRepeat(request, "","add")) {
            return "repeat";
        }*/
        if(wsBzjgdm!=null&&wsBzjgdm.length()>0){
        	jgdmSave.setBzjgdm(wsBzjgdm);
        }else{
        jgdmSave.setBzjgdm(user.getBzjgdm());
        }
        //jgdmSave.setZgrs(0);
        jgdmSave.setJglx(request.getParameter("jglx"));
        System.out.println("request.getParameter(jglx)"+request.getParameter("jglx"));
        jgdmSave.setPzjgdm(user.getZrxzqu());
        jgdmSave.setPzjgmc(user.getPrintName());
        jgdmSave.setLry(user.getUserName());
        jgdmSave.setFddbr(tfddbr.getXm());
        jgdmSave.setZjhm(tfddbr.getZjhm());
        //jgdmSave.setScbzrq(jgdmSave.getBzrq());
        jgmc = jgdmSave.getJgmc();
        jgdmSave.setDjblx("0");

     /*   if (!clsStringTool.isEmpty(djblx)) {
           // jgdmSave.setDybz("0");
            //新增网上业务数据
            wsbzBus.saveWsyw(clsStringTool.convertNull(jgdmSave.getJgdm()), jgdmSave.getJgmc(), ywlx, "3", djh);
        }*/
        if ("1".equals(formType)) {
/*            TydmDemo demo = new TydmDemo();
            String lx=CommonPropertiesUtil.getValue("common.properties", "tydm");
            String xzqh=user.getZrxzqu();
            String tydmtydm=demo.getCheckCode(lx+jgdmSave.getJglx()+xzqh.trim()+jgdmSave.getJgdm());
        	
        	jgdmSave.setTyshxydm(tydmtydm);*/
        	jgdmSave.setDjblx("1");
            ywlx = "11";
            
        }
        int addResult = applyFormSave();
        //如果需要重名审核，进行审核提交
        /*if (("1".equals(formType)||"8".equals(formType))||(!clsStringTool.isEmpty(submitType) && !"0".equals(submitType))) {
            //只有添加成功才能发送请求
            if (addResult == 1) {
                //判断formType 0 是普通申请表登记；1 其他部门赋码登记；
                if ("0".equals(formType)) {
                	
                	if("5".equals(submitType)){
                		ywlx="13";
                	}else{
                		
                		ywlx = "10";
                	}
                }
                if ("1".equals(formType)) {
                    TydmDemo demo = new TydmDemo();
                    String lx=CommonPropertiesUtil.getValue("common.properties", "tydm");
                    String xzqh=user.getZrxzqu();
                    String tydmtydm=demo.getCheckCode(lx+jgdmSave.getJglx()+xzqh.trim()+jgdmSave.getJgdm());
                	
                	jgdmSave.setTyshxydm(tydmtydm);
                	if("5".equals(submitType)){
                		ywlx="13";
                	}else{
                		
                		ywlx = "11";
                	}
                }
                int result = new TSpBus().sendSaveAudit(jgdmSave, user, submitType, ywlx,jglx);
                String promptName = "";
                if ("3".equals(submitType)) {
                    promptName = "注册号，机构名称是否可以重复";
                }
                if ("1".equals(submitType)) {
                    promptName = "机构名称是否可以重复";
                }
                if ("2".equals(submitType)) {
                    promptName = "注册号是否可以重复";
                }
                if ("4".equals(submitType)) {
                    promptName = "机构名称是否可以包含‘合作社’";
                }
                if ("5".equals(submitType)) {
                    promptName = "法人是否可以重名";
                }
                if (result == 1) {
                    nameType = "revisionForbidden";
                    resultMsg = promptName + "请求已经发送给省中心。一旦省中心审核后，就可以进行校对操作！";
                }
                if (result == 0) {
                    resultMsg = promptName + "请求发送失败！";
                }
            }
        }*/
        return SUCCESS;
    }
    private void setDefault(){
    	//jgdmSave.setJglx("1");
    	jgdmSave.setJyfw("null");;
    	jgdmSave.setJjhy2011("null");;
    	jgdmSave.setJjlx2011("null");;
    	jgdmSave.setZgdm("null");;
//    	jgdmSave.setPzjgdm("");;
    	jgdmSave.setZczj(1.0);;
    	jgdmSave.setHbzl("0");;
    	jgdmSave.setBgrq(new Date());;
    	jgdmSave.setNjrq(new Date());;
    	jgdmSave.setZch("null");;
    	jgdmSave.setEmail("null");;
    	jgdmSave.setUrl("null");;
    	jgdmSave.setMobile("null");;
    	jgdmSave.setLastdate(new Date());;
    	jgdmSave.setJydz("null");;
    	jgdmSave.setJyzt("null");;
    	jgdmSave.setScjyxzqh("null");;
    	jgdmSave.setYwlx("null");;
    	jgdmSave.setHsfs("null");;
    	jgdmSave.setJhbz("null");;
    	jgdmSave.setGbrs(0);;
    	jgdmSave.setGhjs(0);;
    	jgdmSave.setGhzxdh("null");;
    	jgdmSave.setSnjylj(0.0);;
    	jgdmSave.setHhsr(0.0);;
    	jgdmSave.setLcsr(0.0);;
    	jgdmSave.setLdzj(0.0);;
    	jgdmSave.setQtzj(0.0);;
    	jgdmSave.setHjzj(0.0);;
    	jgdmSave.setBgcs(0.0);;
    	jgdmSave.setHdcs(0.0);;
    	jgdmSave.setQtcs(0.0);;
    	jgdmSave.setCdnl("0");;
    }
    private int applyFormSave() {
    	//setDefault();
    	System.out.println("------------------  "+jgdmSave);
    	
    	int result;
    	if("1".equals(jgdmSave.getJglx())||"9".equals(jgdmSave.getJglx())){
    		//申请表添加逻辑
            result = saveBus.AddTjgdmSave(jgdmSave,tfddbr,frjl);
    	}else{
    		result = 2;
    	}       
        User user = (User) session.get("sysUser");
        id = String.valueOf(jgdmSave.getId());
        String ywlsh = ""; 
        /*
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        if(isYwlc){
        if ("0".equals(formType)) {
            ywlsh = ywlcBus.updateYwlc(id, jgdmSave.getJgmc(), "1", "受理", "0", jgdmSave.getBzjgdm(),user.getUserName());
        }
        if ("1".equals(formType)) {
            ywlsh = ywlcBus.updateYwlc(id, jgdmSave.getJgmc(), "4", "受理", "0", jgdmSave.getBzjgdm(),user.getUserName());
        }
        }
        */
        if (result == 1) {
            currentPath = "/product/jsp/certificate/addSuccess.jsp";
            if ("0".equals(formType)) {
              /*  PropertiesUtils.loadFile("gsdjb");
                String tableName = (String) PropertiesUtils.getValue("table");
                String idName = (String) PropertiesUtils.getValue("Bak4");
                String sql = "update " + tableName + " set state='1' " + " where " + idName + "='" + jgdmSave.getBak4() + "'";
                EntityManager em = CheckEntityManagerHelper.getEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                CheckEntityManagerHelper.getEntityManager().createNativeQuery(sql).executeUpdate();
                tx.commit();
                CheckEntityManagerHelper.closeEntityManager();*/

                resultMsg = "机构名称：" + jgmc + " 申请表登记新增成功!";
              /*  if(!"".equals(jgdmSave.getBak4())&&jgdmSave.getBak4()!=null&&!"A".equals(jgdmSave.getBak4())){
                	TyGsBus bus=new TyGsBus();
                	bus.updateStatus(jgdmSave.getBak4());
                }*/
                if (isYwlc) {
                    resultMsg += "业务流水号:" + ywlsh;
                }
            }
            if ("1".equals(formType)) {
                resultMsg = "机构代码：" + jgdm + " 其他部门赋码新增成功!";
                if (isYwlc) {
                    resultMsg += "业务流水号:" + ywlsh;
                }
            }
        } else {
        	currentPath = "/product/jsp/certificate/addError.jsp";
        	resultMsg = "机构名称：" + jgmc + " 申请表登记失败!请确认网络状况之后重新录入.";
        }
        return result;
    }

    public String addRequisition() {
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        HttpServletRequest request = setValue("add");
        getPwDate(request, jgdmSave);
        User user = (User) session.get("sysUser");
        String xzqh = user.getBzjgdm();
        //机构名称查重
        /*String codeName = jgdmSave.getJgmc();
        String retVal = saveBus.isExistCodeName(codeName, "");
        if (!"".equals(retVal)) {
            resultMsg = "codeRepeat";
            sourceTable = retVal.split(":")[1];
            return "repeat";
        }*/
        String wjwlsh = new SerialBus().getLsh("100000", "3");
       /* jgdmSave.setWjwlsh(wjwlsh);
        jgdmSave.setJgdm(null);
        jgdmSave.setZbsl(1);
        jgdmSave.setFbsl(1);
        jgdmSave.setFkbz("0");
        jgdmSave.setFksl(0);*/
        jgdmSave.setBzjgdm(xzqh);
        jgdmSave.setLry(user.getUserName());
       // jgdmSave.setScbzrq(jgdmSave.getBzrq());
        jgmc = jgdmSave.getJgmc();
        //如果需要重名审核，进行审核提交
        if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            //判断formType 0 是普通申请表登记；1 其他部门赋码登记；2 预付码登记
            ywlx = "15";
            int result = new TSpBus().sendSaveAudit(jgdmSave, user, submitType, ywlx);
            String promptName = "";
            if ("3".equals(submitType)) {
                promptName = "注册号，机构名称是否可以重复";
            }
            if ("1".equals(submitType)) {
                promptName = "机构名称是否可以重复";
            }
            if ("2".equals(submitType)) {
                promptName = "注册号是否可以重复";
            }
            if (result == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "请求已经发送给省中心。一旦省中心审核后，就可以进行校对操作！";
            }
            if (result == 0) {
                resultMsg = promptName + "请求发送失败！";
            }
            source = "/bsweb/certificate_yfmList.action";
            currentPath = "/product/jsp/certificate/certSuccess.jsp";
        } else {
            int addResult = saveBus.AddTjgdmSavePart(jgdmSave, sslcode);
            id = String.valueOf(jgdmSave.getId());
            //String ywlsh = ywlcBus.updateYwlc(jgdmSave.getJgdm(), jgdmSave.getJgmc(), "3", "受理", "0", jgdmSave.getBzjgdm());
            if (addResult == 1) {
                id = String.valueOf(jgdmSave.getId());
                jgdm = jgdmSave.getJgdm();
                source = "/bsweb/certificate_yfmList.action";
                currentPath = "/product/jsp/certificate/certSuccess.jsp";
                resultMsg = "机构（" + jgmc + "）添加成功，预赋码（" + jgdm + "）";
                if (isYwlc) {
                    resultMsg += "业务流水号:" + ywlsh;
                }
            } else if (addResult == 2) {
                resultMsg = "NoCode";
            } else if (addResult == 3) {
                resultMsg = "CodeExist";
            } else {
                resultMsg = "failure";
            }
        }


        return this.SUCCESS;
    }
    public String addJgdm(){
    	currentPath = "/product/jsp/certificate/addinfomationEnter.jsp";
    	 EntityManager em = EntityManagerHelper.getEntityManager();
    	 
    	String sql="from TNNjjlx model where model.jglx='"+jglx+"'";
    	jjlx=em.createQuery(sql).getResultList();
    	String sql1="from ScZw model where model.jglx='"+jglx+"'";
    	zwList=em.createQuery(sql1).getResultList();
    	return this.SUCCESS;
    }
    public String updateRequisition() {
        User user = (User) session.get("sysUser");
        //不通过审核的修改直接从页面上读取数据，通过审核的修改需要从t_sp表里面读取数据
        if ((audit != null && audit) && (needAudit != null && !needAudit)) {
            jgdmSave = saveBus.findById(Integer.parseInt(id));
            jgmc = jgdmSave.getJgmc();
            TSpdmtemp spdm = new TSpdmtempBus().getSpdm((jgdm == null || jgdm.trim().length() < 9) ? id : jgdm, "15");
            BeanUtilsEx.copyProperties(jgdmSave, spdm);
            if ((jgdm == null || jgdm.trim().length() < 9)) {
                jgdmSave.setJgdm(null);
            }
        } else {
            HttpServletRequest request = setValue("update");
            getPwDate(request, jgdmSave);
        }

        //如果机构名称发生变化需要机构名称查重
        String codeName = jgdmSave.getJgmc();
        /*String retVal = saveBus.isExistCodeName(codeName, jgdm);
        if (!"".equals(retVal)) {
            resultMsg = "codeRepeat";
            sourceTable = retVal.split(":")[1];
            return "repeat";
        }*/
        //修改前去删除审核表里面此登记表对应的数据
        tSpBus.delSptempData(jgdmSave, "15");
        currentPath = "/product/jsp/certificate/updatePrompt.jsp";
        source = "yfmList";
        //如果需要重名审核，进行审核提交
        if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            ywlx = "15";
            jgmc = jgdmSave.getJgmc();
            int urRsult = new TSpBus().sendSaveAudit(jgdmSave, user, submitType, ywlx);
            String promptName = "";
            if ("3".equals(submitType)) {
                promptName = "注册号，机构名称是否可以重复";
            }
            if ("1".equals(submitType)) {
                promptName = "机构名称是否可以重复";
            }
            if ("2".equals(submitType)) {
                promptName = "注册号是否可以重复";
            }
            if (urRsult == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "请求已经发送给省中心。一旦省中心审核后，就可以进行校对操作！";
            }
            if (urRsult == 0) {
                resultMsg = promptName + "请求发送失败！";
            }
        } else {
           /* jgdmSave.setZbsl(1);
            jgdmSave.setFbsl(1);
            jgdmSave.setFkbz("0");
            jgdmSave.setFksl(0);*/
            jgmc = jgdmSave.getJgmc();
            int result = 0;
            if (jgdmSave.getJgdm() != null && !"".equals(jgdmSave.getJgdm().trim())) {
                result = saveBus.updateTjgdmSave(jgdmSave);
            } else {
                result = saveBus.AddTjgdmSavePart(jgdmSave, sslcode);
            }

            id = String.valueOf(jgdmSave.getId());
            if (result == 1) {
                resultMsg = "机构名称：" + jgmc + "赋码通知单修改成功!";
                 /*ywlcBus.updateYwlcById(String.valueOf(jgdmSave.getId()),jgdm,jgdmSave.getJgmc(),"5","预赋码修改","1",jgdmSave.getBzjgdm());*/
                
            } else {
                resultMsg = "failure";
            }
        }
        return this.SUCCESS;
    }

    public String update() {
        User user = (User) session.get("sysUser");

        //修改前去删除审核表里面此登记表对应的数据
        //formTYpe 0 普通申请表；1 其他部门赋码
        if ("0".equals(formType)) {
            ywlx = "07,13";
        }
        if ("1".equals(formType)) {
            ywlx = "11";
        }
        if ("2".equals(formType)) {
            ywlx = "15";
        }
        //不通过审核的修改直接从页面上读取数据，通过审核的修改需要从t_sp表里面读取数据
        System.out.println(jgdm);
        if (audit && !needAudit) {
            if ("0".equals(formType)) {
                jgdmSave = saveBus.findById(Integer.parseInt(jgdm.trim()));
            } else
                jgdmSave = saveBus.findByJgdm(jgdm);
            jgmc = jgdmSave.getJgmc();
            TSpdmtemp spdm = null;
            spdm = new TSpdmtempBus().getSpdm(jgdm, ywlx);
            BeanCopier beanCopier = BeanCopier.create(TSpdmtemp.class, TJgdmSave.class, false);
            beanCopier.copy(spdm, jgdmSave, null);
        } else {
            HttpServletRequest request = setValue("update");
            getDate(request, jgdmSave);
        }
        //删除审核表存在的数据
        tSpBus.delSptempData(jgdmSave, ywlx);
        //判断重复
        /*if (isRepeat(request, (jgdm == null || "".equals(jgdm)) ? id : jgdm,"update")) return "repeat";*/
        jgdmSave.setLry(user.getUserName());
        jgmc = jgdmSave.getJgmc();
        currentPath = "/product/jsp/certificate/updatePrompt.jsp";
        source = "list";
        //如果需要重名审核，进行审核提交
        if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            //如果是预赋码更新，先保存用户填写的信息,在发送请求
            if ("2".equals(formType)) {
                saveBus.updateTjgdmSave(jgdmSave);
            }
            int result = tSpBus.sendSaveAudit(jgdmSave, user, submitType, ywlx,jglx);
            String promptName = "";

            if ("3".equals(submitType)) {
                promptName = "注册号，机构名称是否可以重复";
            }
            if ("1".equals(submitType)) {
                promptName = "机构名称是否可以重复";
            }
            if ("2".equals(submitType)) {
                promptName = "注册号是否可以重复";
            }
            if (result == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "请求已经发送给省中心。一旦省中心审核后，就可以进行校对操作！";
            }
            if (result == 0) {
                resultMsg = promptName + "请求发送失败！";
            }
        } else {
            updateJgdmSave();
        }
        return this.SUCCESS;
    }


    private int updateJgdmSave() {
    	
    	/*if(jgdmSave.getBak3().equals("1")){
    		jgdmSave.setBak3("2");
    	}*/
    	jgdmSave.setFddbr(fddbr.getXm());
    	jgdmSave.setZjlx(fddbr.getZjlx());
    	jgdmSave.setZjhm(fddbr.getZjhm());
    	jgdmSave.setJglx(jglx);
        int result = saveBus.updateTjgdmSave(jgdmSave,fddbr,frjl);
        if (result == 1) {
            resultMsg = "机构名称：" + jgmc + "修改成功!";
           
           
        } else {
            resultMsg = "系统繁忙!请稍后再试!";
        }
        return result;
    }

    /**
     * 申请表修改
     * 如果是重名提交不能修改t_jgdm表，只能插入到t_sptemp表中
     *
     * @return
     */
    public String updateJgdm() {
        User user = (User) session.get("sysUser");
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            boolean flag = false;
            //不通过审核的修改直接从页面上读取数据，通过审核的修改需要从t_sp表里面读取数据
            if (audit && !needAudit) {
                tjgdm = jgdmBus.findById(tyshxydm);
                TSpdmtemp spdm = null;
                spdm = new TSpdmtempBus().getSpdm(tyshxydm, "16");
                //判断用户是否更改发卡标识及数量 ,更改返回true
                /*if (spdm.getFkbz().equals(tjgdm.getFkbz())) {
                    if (!spdm.getFksl().equals(String.valueOf(tjgdm.getFksl()))) {
                        flag = true;
                    }
                } else
                    flag = true;*/
                BeanUtilsEx.copyProperties(tjgdm, spdm);
            } else {
                flag = setJgdmValue(request);
                getJGdmDate(request, tjgdm);
                
            }
            //saveBus.AddTjgdmFzr(fzr, tjgdm.getTyshxydm());
            /*if (isRepeatTjgdm(request, (jgdm == null || "".equals(jgdm)) ? id : jgdm,"update")) return "repeat";*/
            tjgdm.setLastdate(new Date());
            tjgdm.setLry(user.getUserName());
            //lvwei 20180103 上报字段
            tjgdm.setDflag(0);
            tjgdm.setYwlx("信息修改");
            //修改前去删除审核表里面此登记表对应的数据
            tSpBus.delSptempTjgdmData(tjgdm.getTyshxydm(), "16");
            //如果需要重名审核，进行审核提交
            if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
                int result = tSpBus.sendAudit(tjgdm, user, submitType);
                String promptName = "";
                if ("3".equals(submitType)) {
                    promptName = "注册号，机构名称是否可以重复";
                }
                if ("1".equals(submitType)) {
                    promptName = "机构名称是否可以重复";
                }
                if ("2".equals(submitType)) {
                    promptName = "注册号是否可以重复";
                }
                if (result == 1) {
                    nameType = "revisionForbidden";
                    resultMsg = promptName + "请求已经发送给省中心。一旦省中心审核后，就可以进行申请表操作！";
                }
                if (result == 0) {
                    resultMsg = promptName + "请求发送失败！";
                }
                source = "/bsweb/certificate_operList.action?pageno=" + pageno + "&rowNumsView=" + rowNumsView+"&jglx="+jglx;
                currentPath = "/product/jsp/certificate/certSuccess.jsp";
            } else {
            	tjgdm.setFddbr(fddbr.getXm());
            	tjgdm.setZjlx(fddbr.getZjlx());
            	tjgdm.setZjhm(fddbr.getZjhm());
                int result = jgdmBus.updateJgdm(tjgdm, user, flag,jglx);
                if (result == 1) {
                	saveBus.updateFddbr(fddbr, tjgdm, frjl);
                    resultMsg = "申请表统一代码：（" + tjgdm.getTyshxydm() + "）修改成功";
                    source = "/bsweb/certificate_operList.action?pageno=" + pageno + "&rowNumsView=" + rowNumsView+"&jglx="+jglx;
                    currentPath = "/product/jsp/certificate/certSuccess.jsp";
                    //TYwlc ywlc = ywlcBus.findByJgdm(jgdm);
                    //ywlcBus.updateYwlc(jgdm,tjgdm.getJgmc(),String.valueOf(ywlc.getYwlclx()),"申请表修改","1",tjgdm.getBzjgdm());
                    //如果用户修改了机构名称，同步更新
                    /*if(codeNameRepeat&&!clsStringTool.isEmpty(ywlsh)){
                        ywlcBus.updateYwlcLog(ywlsh,tjgdm.getJgmc());
                    }*/
                } else {
                    resultMsg = "系统繁忙!请稍后再试!";
                }
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
        }
        return this.SUCCESS;
    }

    /**
     * 强制修改
     *
     * @return
     */
    public String forceUpdate() {
        User user = (User) session.get("sysUser");
        try {
            TBgk jgdmHis = new TBgk();
            tjgdm = jgdmBus.findById(tyshxydm);
            BeanCopier beanCopier = BeanCopier.create(TJgdm.class, TBgk.class, false);
            beanCopier.copy(tjgdm, jgdmHis, null);
            HttpServletRequest request = ServletActionContext.getRequest();
            this.bindingForm2Bean(tjgdm, request.getParameterMap());
            getJGdmDate(request, tjgdm);
            tjgdm.setLastdate(new Date());
            tjgdm.setBgrq(new Date());
            tjgdm.setLry(user.getUserName());
            tjgdm.setPzjgmc(user.getPrintName());
            tjgdm.setFddbr(fddbr.getXm());
            tjgdm.setZjhm(fddbr.getZjhm());
            tjgdm.setZjlx(fddbr.getZjlx());
            int result = jgdmBus.forceUpdate(tjgdm, jgdmHis, user);
            //saveBus.AddTjgdmFzr(fzr, tjgdm.getTyshxydm());
            if (result == 1) {
            	saveBus.updateFddbr(fddbr, tjgdm, frjl);
                resultMsg = "强制修改统一代码（" + tjgdm.getTyshxydm() + "）成功";
                if ("1".equals(type)) {
                    currentPath = "/product/jsp/certificate/forceUpdateNoZsSuccess.jsp";
                } else {
                    currentPath = "/product/jsp/certificate/forceUpdateSuccess.jsp";
                }

            } else {
                resultMsg = "系统繁忙!请稍后再试!";
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
        }
        return this.SUCCESS;
    }


    /**
     * 强制修改页面
     *
     * @return
     */
    public String forceUpdatePage() {
        tjgdm = jgdmBus.findById(jgdm);
       
        //listFzr= saveBus.fzrList(jgdm);
        if (tjgdm == null) {
            currentPath = "/product/jsp/certificate/forceUpdate.jsp";
            resultMsg = "统一代码代码（" + jgdm + "）不存在于正式库中，不能做强制修改！";
            return this.SUCCESS;
        }
        tfddbr= saveBus.fddbrList(tjgdm.getTyshxydm());
        frjl=saveBus.getFrjl(tfddbr.getLsh());
        User user = (User) session.get("sysUser");
//        if (!(user.getUserName().contains("admin") || tjgdm.getBzjgdm().equals(user.getBzjgdm()))) {
        if (false) {
            currentPath = "/product/jsp/certificate/forceUpdate.jsp";
            resultMsg = "机构代码（" + jgdm + "）不属于本办证机构管理，不能修改当前机构代码！";
            return this.SUCCESS;
        }
        if (tjgdm == null) {
            currentPath = "/product/jsp/certificate/forceUpdate.jsp";
            resultMsg = "noCode";
        } else
            currentPath = "/product/jsp/certificate/forceUpdateJgdm.jsp";
        source = "forceUpdate";
        return this.SUCCESS;
    }
    /**
     * 强制修改页面
     *
     * @return
     */
    public String forceUpdatePageNoZs() {
        tjgdm = jgdmBus.findById(jgdm);
        if (tjgdm == null) {
            currentPath = "/product/jsp/certificate/forceUpdateNoZs.jsp";
            resultMsg = "机构代码（" + jgdm + "）不存在于正式库中，不能做强制修改！";
            return this.SUCCESS;
        }
        User user = (User) session.get("sysUser");
        if (!(user.getUserName().contains("admin") || tjgdm.getBzjgdm().equals(user.getBzjgdm()))) {
            currentPath = "/product/jsp/certificate/forceUpdateNoZs.jsp";
            resultMsg = "机构代码（" + jgdm + "）不属于本办证机构管理，不能修改当前机构代码！";
            return this.SUCCESS;
        }
       /* if (!"1".equals(tjgdm.getDybz())) {
            currentPath = "/product/jsp/certificate/forceUpdateNoZs.jsp";
            resultMsg = "机构代码（" + jgdm + "）还未打印证书，请使用申请表修改功能修改！";
            return this.SUCCESS;
        }*/
        currentPath = "/product/jsp/certificate/forceUpdateJgdmNoZs.jsp";
        return this.SUCCESS;
    }

    /**
     * 换证处理
     *
     * @return
     */
   public String certChange() {
        currentPath = "/product/jsp/certificate/certChangeInfo.jsp";
        User user = (User) session.get("sysUser");
        HttpServletRequest request = ServletActionContext.getRequest();
        int result = 0;
        tjgdm = jgdmBus.findById(tyshxydm);
      //操作人员信息
        saveBus.AddTjgdmFzr(fzr, tyshxydm);
        
       /* String strFkbzOld = tjgdm.getFkbz();
        Integer strFkslOld = tjgdm.getFksl();*/
        //如果需要重名审核，进行审核提交
     /*   if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            currentPath = "/product/jsp/certificate/certSend.jsp";
            ywlx = "02";
            getJGdmDate(request, tjgdm);
            this.bindingForm2Bean(tjgdm, request.getParameterMap());
            int urRsult = new TSpBus().sendCertAudit(tjgdm, user, submitType);
            String promptName = "";
            if ("3".equals(submitType)) {
                promptName = "注册号，机构名称是否可以重复";
            }
            if ("1".equals(submitType)) {
                promptName = "机构名称是否可以重复";
            }
            if ("2".equals(submitType)) {
                promptName = "注册号是否可以重复";
            }
            if (urRsult == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "请求已经发送给省中心。一旦省中心审核后，就可以进行换证操作！";
            }
            if (urRsult == 0) {
                resultMsg = promptName + "请求发送失败！";
            }
        } *///else {
            //不通过审核的换证直接从页面上读取数据，通过审核的换证需要从t_sp表里面读取数据
            /*if (audit && !needAudit) {
                TSpdmtemp spdm = null;
                spdm = new TSpdmtempBus().getSpdm(jgdm, "02");
                BeanCopier beanCopier = BeanCopier.create(TSpdmtemp.class, TJgdm.class, false);
                beanCopier.copy(spdm, tjgdm, null);
            } else {*/
                getJGdmDate(request, tjgdm);
                this.bindingForm2Bean(tjgdm, request.getParameterMap());
            //}
         
            tjgdm.setLry(user.getUserName());
            tjgdm.setLastdate(new Date());
            tjgdm.setBgrq(new Date());
            tjgdm.setDybz("0");
            tjgdm.setPzjgmc(user.getPrintName());
            if("1".equals(tjgdm.getJglx())){
            	tjgdm.setJjlx2011("21");
            }
           /* if (!InitSysParams.njjhyMap.containsKey(tjgdm.getNjjhy())) {
                log.error("经济行业对照出错！");
                resultMsg = "输入的经济行业不存在与码表中，请更正！";
                return this.SUCCESS;
            }*/
            if("0".equals(isdang)){
            	tjgdm.setWjlyy("");
            }else{
            	tjgdm.setDzzlx("");
            	tjgdm.setDzzfzr("");
            	tjgdm.setDzzfzrzjlx("");
            	tjgdm.setDzzfzrzjhm("");
            	tjgdm.setDjlxr("");
            	tjgdm.setDjlxrzjlx("");
            	tjgdm.setDjlxrzjhm("");
            	tjgdm.setDjlxrdhhm("");
            	tjgdm.setDzzclrq(null);
            	tjgdm.setSjdzzmc("");
            	tjgdm.setZzdysl(null);
            	tjgdm.setJzdysl(null);
            }
              result = jgdmBus.certChange(user, tjgdm,jglx);
            if (result == 1) {
                resultMsg = "机构(统一代码代码：" + tyshxydm + ")换证成功!请打证!";
             
               // ywlcBus.updateYwlc2(jgdm, tjgdm.getJgmc(), "换证", "1",user.getUserName());
                //换证成功后删除审核表里面此登记表对应的数据
                //tSpBus.delSptempTjgdmData(tjgdm.getJgdm(), "02");
            } else {
                resultMsg = "换证失败，请重试!";
//                ?eturn this.ERROR;
            }
        //}

        //改网上状态
       /* if (clsStringTool.isEmpty(djh)) {
//            if(wsbzBus.isWsywByjgdm(jgdm,"3")){
            wsbzBus.updateXbByjgdm(jgdm, "3", "3", tjgdm);
            wsbzBus.delWsywByjgdm(jgdm, "3");
//            }
        } else {
//            if(wsbzBus.isWsyw(djh,"3")){
            wsbzBus.updateXb(djh, "3", "3", tjgdm);
            wsbzBus.delWsyw(djh, "3");
//            }
        }*/

        return this.SUCCESS;
    }

    public String certLostSearch() {
        currentPath = "/product/jsp/certificate/certLost.jsp";
        tjgdm = jgdmBus.findById(jgdm);
        zsList = new TZsBus().findByJgdm(jgdm, source);
        if(!("".equals(id)||id==null)){
        	wgs = wsbzBus.findWgs(id);
        }
       // 
/*        wgs = wsbzBus.findWgs(id);
        if (wgs != null) {
            String[] lshs = wgs.getZsdjh().split(",");
            zsList = new TZsBus().findBylsh(lshs);
        }*/
        return this.SUCCESS;
    }

    public String certLost() {
        currentPath = "/product/jsp/certificate/certPromptInfo.jsp";
        User user = (User) session.get("sysUser");
        HttpServletRequest request = ServletActionContext.getRequest();
        String[] djhs = request.getParameterValues("djh");
        if (djhs == null) {
            resultMsg = "noChoose";
        } else {
            String strAlldjh = "";
            tjgdm = jgdmBus.findById(jgdm);
            for (String djh1 : djhs) {
                strAlldjh = strAlldjh + djh1 + ",";
            }
            strAlldjh = strAlldjh.substring(0, strAlldjh.length() - 1);
            int result = 0;
            if ("yygs".equals(source)) {
                result = new TZsBus().dateCertLost(djhs, jgdm, user);
                if (result == 1) {
                    resultMsg = "机构代码(" + jgdm + ")证书(" + strAlldjh + ")预约挂失完毕,确认挂失后才可以打印挂失证书！";
                } else {
                    resultMsg = "写证书预约挂失信息时出错!";
                }
            }
            if ("qxgs".equals(source)) {
                result = new TZsBus().cancelCertLost(djhs, jgdm, user);
                if (result == 1) {
                    resultMsg = "机构代码(" + jgdm + ")证书(" + strAlldjh + ")取消预约挂失完毕,取消预约挂失的证书可以继续使用！";
                } else {
                    resultMsg = "写取消证书预约挂失信息时出错!";
                }
            }
            if ("qrgs".equals(source)) {
                String gsyj = request.getParameter("gsyj");
                String gsreason = request.getParameter("gsreason");
                String zfrq = request.getParameter("zfrq");
                result = new TZsBus().confirmCertLost(djhs, jgdm, user, gsyj, gsreason, zfrq);
                if (result == 1) {
                    resultMsg = "机构代码(" + jgdm + ")证书(" + strAlldjh + ")挂失完毕,原证书将无法使用!";
                } else {
                    resultMsg = "写证书确认挂失信息时出错!";
                }
                wsbzBus.updateWgs(jgdm);
            }
        }
        return this.SUCCESS;
    }

    public String delete() {
        TJgdmSave save = null;
        currentPath = "/product/jsp/certificate/promptInfo.jsp";
        int result = 0;
        if (!"2".equals(formType)) {
            if ("1".equals(formType)) {
                save = saveBus.findById(Integer.valueOf(id));
                result = saveBus.deleteElseTJgdmSave(save);
            } else {
            	save = saveBus.findById(Integer.valueOf(id));
            	 jgdm = save.getJgdm();
                 jgmc = save.getJgmc();
                 saveBus.delFddbr(id);
               
                result = saveBus.deleteTjgdmSave(Integer.valueOf(id));
                //清空审核表
                if (result == 1) {
                    tSpBus.delSptempTjgdmData(id, "10");
                }
            }
        } /*else {
            jgdm = save.getJgdm();
            jgmc = save.getJgmc();
            result = saveBus.deleteAndGetTjgdmSave(save);
        }*/
        if (result == 1) {
            resultMsg = jgmc + "删除成功!";
            //清除审核表里面该机构代码审核不通过数据
            if ("1".equals(formType)) {
                tSpBus.delSptempData(save, "08");
            }
            if ("2".equals(formType)) {
                tSpBus.delSptempData(save, "09");
            }
        } else {
            currentPath = "/product/jsp/certificate/viewPage.jsp";
            resultMsg = "failure";
        }
        //isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
     /*   if (isYwlc) {
            //申请表登记删除
            if ("0".equals(formType)) {
                ywlcBus.delYwlcData(id);
            }
            //其它部门赋码删除
            if ("1".equals(formType)) {
                ywlcBus.updateYwlcById(id, save.getJgdm(), save.getJgmc(), "4", "部门赋码删除", "2", save.getBzjgdm());
            }
            //预赋码删除
            if ("2".equals(formType)) {
                ywlcBus.updateYwlcById(id, save.getJgdm(), save.getJgmc(), "3", "预赋码删除", "2", save.getBzjgdm());
            }
        }*/
        return this.SUCCESS;
    }
/*public String webService(){
	currentPath = "/product/jsp/webService/webService.jsp";
	//System.out.println(tjgdm.getBak3().equals("123"));
	try{
        String url=CommonPropertiesUtil.getValue("common.properties", "gsurl");
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        serviceClient.getOptions().setProperty(HTTPConstants.CHUNKED, false);
        EndpointReference targetEPR = new EndpointReference(url);
        options.setTo(targetEPR);
        QName opAddEntry;
        /////////////////////////////////////////
        opAddEntry = new QName("http://loushang.ws", "addRegorg");
        
        *//**
         * 0失败；1成功
         *//*
        String str = (String)serviceClient.invokeBlocking(opAddEntry,new Object[]{tjgdm.getBak3(),tjgdm.getZch(),tjgdm.getJgdm()},  
        		new Class[]{String.class,String.class,String.class})[0];

        if(str.equals("0")){
        	System.out.println(jgdm+"++++++++++++++++++手动回传机构代码失败!");
        	resultMsg=jgdm+"+手动回传机构代码失败!";
        }
        if(str.equals("1")){
        	System.out.println(jgdm+"++++++++++++++++++手动回传机构代码成功!");
        	resultMsg=jgdm+"+手动回传机构代码失败!";
        }
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println(jgdm+"++++++++++++++++++手动回传机构代码报错:"+e);
        	resultMsg=jgdm+"+手动回传机构代码失败!";
		}
        
	return SUCCESS;
}*/
    
    public synchronized String revision() {
        User user = (User) session.get("sysUser");
        synchronized (lock) {
            jgdmSave = saveBus.findById(Integer.valueOf(id));
            currentPath = "/product/jsp/certificate/viewPage.jsp";
            String result = "5";
            result = saveBus.revision(id, formType, user,jglx,sslcode);
            if (result.contains("1")) {
                jgdm = result.split(":")[1];
                currentPath = "/product/jsp/certificate/revisionInfo.jsp";
                TJgdm dm = jgdmBus.findById(jgdm);
                tjgdm = jgdmBus.findById(jgdm);
////////////////////////////////////////////////////////////////
                //返回工商接口 
               /* if(dm.getBak4()!=null&&dm.getBak4().trim().equals("A")){
                try{
                String url=CommonPropertiesUtil.getValue("common.properties", "gsurl");
                RPCServiceClient serviceClient = new RPCServiceClient();
                Options options = serviceClient.getOptions();
                serviceClient.getOptions().setProperty(HTTPConstants.CHUNKED, false);
                EndpointReference targetEPR = new EndpointReference(url);
                options.setTo(targetEPR);
                QName opAddEntry;
                /////////////////////////////////////////
                opAddEntry = new QName("http://loushang.ws", "addRegorg");
                
                *//**
                 * 0失败；1成功
                 *//*
                String str = (String)serviceClient.invokeBlocking(opAddEntry,new Object[]{dm.getJgmc(),dm.getZch(),dm.getJgdm()},  
                		new Class[]{String.class,String.class,String.class})[0];

                if(str.equals("0"))System.out.println(jgdm+"++++++++++++++++++回传机构代码失败!");
                if(str.equals("1"))System.out.println(jgdm+"++++++++++++++++++回传机构代码成功!");
                }catch (Exception e) {
					// TODO: handle exception
                	System.out.println(jgdm+"++++++++++++++++++回传机构代码报错:"+e);
				}
                }
  //////////////////////////////////////////////////////////////
*/                
                
                /*String djh = wsbzBus.findWsywDjh(jgdmSave.getJgmc(), "0");
                if (djh != null)
                    wsbzBus.updateXb(djh, "3", "0", dm);
                wsbzBus.delWsywByjgmc(jgdmSave.getJgmc(), "0");*/
                String lshmsg="";
               /* if(jgdmSave.getBak3()!=null&&jgdmSave.getBak3().length()>15){
                	lshmsg=",业务流水号已关联为:"+jgdmSave.getBak3();
                }*/
                resultMsg = jgdmSave.getJgmc() + "校对赋码成功!统一代码是" + jgdm+lshmsg;
               
                //            }
                jgmc=jgdmSave.getJgmc();
                
                saveBus.upFzr(id, jgdm);
                /*
                if ("0".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "1", "校对赋码", "1", jgdmSave.getBzjgdm());
                }
                if ("1".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "4", "校对", "1", jgdmSave.getBzjgdm());
                }
                if ("2".equals(formType)) {
                    ywlcBus.updateYwlcByYwlsh(ywlsh, jgdm, jgmc, "3", "校对", "1", jgdmSave.getBzjgdm());
                }
                */
            } else if ("2".equals(result)) {
                resultMsg = "NoCode";
            } else if ("3".equals(result)) {
                resultMsg = "CodeExist";
            } else if ("4".equals(result)) {
                resultMsg = "DataWrong";
            } else if ("5".equals(result)) {
                resultMsg = "canNotFm";
            } else {
                resultMsg = "failure";
            }
        }
        return this.SUCCESS; 
    }
    
    
    
    
    
    
   /*备份未修改  createByZsl 2016-12-7
    * 
    *  public synchronized String revision() {
        User user = (User) session.get("sysUser");
        synchronized (lock) {
            jgdmSave = saveBus.findById(Integer.valueOf(id));
            currentPath = "/product/jsp/certificate/viewPage.jsp";
            String result = "5";
            result = saveBus.revision(id, formType, user,jglx);
            if (result.contains("1")) {
                jgdm = result.split(":")[1];
                
                currentPath = "/product/jsp/certificate/revisionInfo.jsp";
                TJgdm dm = jgdmBus.findById(jgdm);
                tjgdm = jgdmBus.findById(jgdm);
////////////////////////////////////////////////////////////////
                //返回工商接口 
                if(dm.getBak4()!=null&&dm.getBak4().trim().equals("A")){
                try{
                String url=CommonPropertiesUtil.getValue("common.properties", "gsurl");
                RPCServiceClient serviceClient = new RPCServiceClient();
                Options options = serviceClient.getOptions();
                serviceClient.getOptions().setProperty(HTTPConstants.CHUNKED, false);
                EndpointReference targetEPR = new EndpointReference(url);
                options.setTo(targetEPR);
                QName opAddEntry;
                /////////////////////////////////////////
                opAddEntry = new QName("http://loushang.ws", "addRegorg");
                
                *//**
                 * 0失败；1成功
                 *//*
                String str = (String)serviceClient.invokeBlocking(opAddEntry,new Object[]{dm.getJgmc(),dm.getZch(),dm.getJgdm()},  
                		new Class[]{String.class,String.class,String.class})[0];

                if(str.equals("0"))System.out.println(jgdm+"++++++++++++++++++回传机构代码失败!");
                if(str.equals("1"))System.out.println(jgdm+"++++++++++++++++++回传机构代码成功!");
                }catch (Exception e) {
					// TODO: handle exception
                	System.out.println(jgdm+"++++++++++++++++++回传机构代码报错:"+e);
				}
                }
  //////////////////////////////////////////////////////////////
                
                
                String djh = wsbzBus.findWsywDjh(jgdmSave.getJgmc(), "0");
                if (djh != null)
                    wsbzBus.updateXb(djh, "3", "0", dm);
                wsbzBus.delWsywByjgmc(jgdmSave.getJgmc(), "0");
                String lshmsg="";
                if(jgdmSave.getBak3()!=null&&jgdmSave.getBak3().length()>15){
                	lshmsg=",业务流水号已关联为:"+jgdmSave.getBak3();
                }
                resultMsg = jgdmSave.getJgmc() + "校对赋码成功!统一代码是" + jgdm+lshmsg;
               
                //            }
                jgmc=jgdmSave.getJgmc();
                
                saveBus.upFzr(id, jgdm);
                
                if ("0".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "1", "校对赋码", "1", jgdmSave.getBzjgdm());
                }
                if ("1".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "4", "校对", "1", jgdmSave.getBzjgdm());
                }
                if ("2".equals(formType)) {
                    ywlcBus.updateYwlcByYwlsh(ywlsh, jgdm, jgmc, "3", "校对", "1", jgdmSave.getBzjgdm());
                }
                
            } else if ("2".equals(result)) {
                resultMsg = "NoCode";
            } else if ("3".equals(result)) {
                resultMsg = "CodeExist";
            } else if ("4".equals(result)) {
                resultMsg = "DataWrong";
            } else if ("5".equals(result)) {
                resultMsg = "canNotFm";
            } else {
                resultMsg = "failure";
            }
        }
        return this.SUCCESS; 
    }*/
    public String viewPage2() {
    	currentPath = "/product/jsp/certificate/viewPage2.jsp";
    	if ("4".equals(formType)) {
    		tjgdm = jgdmBus.findById(jgdm);
    	} else {
    		jgdmSave = saveBus.findByJgdm(id);
    		if (jgdmSave == null) {
    			jgdmSave = saveBus.findById(Integer.valueOf(id));
    		}
    	}
    	return this.SUCCESS;
    }
    public synchronized String revision2() {
    	User user = (User) session.get("sysUser");
    	synchronized (lock) {
    		jgdmSave = saveBus.findById(Integer.valueOf(id));
    		currentPath = "/product/jsp/certificate/viewPage2.jsp"; 
    		String result = "5";
    		if (saveBus.canFm(Integer.valueOf(id))) {
    			result=saveBus.revision2(id, formType, user, jgdm);
    		}
    		
    		
    		if (result.contains("1")) {
    			jgdm = result.split(":")[1];
    			currentPath = "/product/jsp/certificate/revisionInfo.jsp";
    			TJgdm dm = jgdmBus.findById(jgdm);
    			String djh = wsbzBus.findWsywDjh(jgdmSave.getJgmc(), "0");
    			if (djh != null){
    				wsbzBus.updateXb(djh, "3", "0", dm);
    			wsbzBus.delWsywByjgmc(jgdmSave.getJgmc(), "0");
    			}
    			resultMsg = jgdmSave.getJgmc() + "校对赋码成功!机构代码是(" + jgdm+")";
    			
    		} else if ("2".equals(result)) {
    			resultMsg = "NoCode";
    		} else if ("3".equals(result)) {
    			resultMsg = "CodeExist";
    		} else if ("4".equals(result)) {
    			resultMsg = "DataWrong";
    		} else if ("5".equals(result)) {
    			resultMsg = "canNotFm";
    		} else {
    			resultMsg = "failure";
    		}
    	}
    	return this.SUCCESS;
    }
    private boolean setJgdmValue(HttpServletRequest request) {
        tjgdm = jgdmBus.findById(tyshxydm);
        boolean flag = false;
        //判断用户是否更改发卡标识及数量 ,更改返回true
       /* if (request.getParameter("fkbz").equals(tjgdm.getFkbz())) {
            if (!request.getParameter("fksl").equals(String.valueOf(tjgdm.getFksl()))) {
                flag = true;
            }
        } else
            flag = true;*/
        dzch = tjgdm.getZch();
        dcodeName = tjgdm.getJgmc();
        this.bindingForm2Bean(tjgdm, request.getParameterMap());
        return flag;
    }

    private HttpServletRequest setValue(String operType) {
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("sysUser");
        if ("add".equals(operType)) {
            jgdmSave = new TJgdmSave();
        } else {
            jgdmSave = saveBus.findById(Integer.valueOf(id));
            dzch = jgdmSave.getZch();
            dcodeName = jgdmSave.getJgmc();
        }
        this.bindingForm2Bean(jgdmSave, request.getParameterMap());
        //jgdmSave.setUserid(user.getUserName());
        //申请登记表0，预赋码2，其他部门赋码1
        if ("0".equals(formType)) {
            jgdmSave.setDjblx("0");
        }
        if ("1".equals(formType)) {
            jgdmSave.setDjblx("1");
        }
        if ("2".equals(formType)) {
            jgdmSave.setDjblx("2");
        }
        return request;
    }

    private boolean isRepeat(HttpServletRequest request, String codeId, String type) {
        try {
            //机构名称
            String codeName = jgdmSave.getJgmc();
            String zch = jgdmSave.getZch();
            String jglx = request.getParameter("jglx");
            //如果type为add是新增，需要判断重复;否则是更新需要根据用户是否修改机构代码或注册号判断是否需要判断重复
            if ("add".equals(type)) {
                //机构名称查重
                String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                if (!"".equals(retVal)) {
                    resultMsg = "codeRepeat";
                    sourceTable = retVal.split(":")[1];
                    return true;
                }
                //注册号查重
                String retValue = saveBus.isExistZch(zch, codeId, jglx, formType);
                if (!"".equals(retValue)) {
                    resultMsg = "zchRepeat";
                    sourceTable = retValue.split(":")[1];
                    return true;
                }
                //注销库查重
                if (fzdmBus.isJgmcAndZchRepeat(codeName, zch, codeId)) {
                    resultMsg = "fzcRepeat";
                    return true;
                }
            } else {
                if (clsStringTool.isEmpty(codeId)) {
                    codeId = "";
                } else {
                    if ("null".equals(codeId.trim())) {
                        codeId = "";
                    }
                }
                //机构名称查重
                //如果用户输入的机构名称与页面输入的机构名称相同 不需要判断重复
                if (!codeName.equals(dcodeName)) {
                    codeNameRepeat = true;
                    String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                    if (!"".equals(retVal)) {
                        resultMsg = "codeRepeat";
                        sourceTable = retVal.split(":")[1];
                        return true;
                    }
                }
                //注册号查重
                //如果用户输入的注册号与页面输入的注册号相同 不需要判断重复
                if (!zch.equals(dzch)) {
                    String retValue = saveBus.isExistZch(zch, codeId, jglx, formType);
                    if (!"".equals(retValue)) {
                        resultMsg = "zchRepeat";
                        sourceTable = retValue.split(":")[1];
                        return true;
                    }
                }
                //注销库查重
                if (!codeName.equals(dcodeName) && !zch.equals(dzch)) {
                    if (fzdmBus.isJgmcAndZchRepeat(codeName, zch, codeId)) {
                        resultMsg = "fzcRepeat";
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
        }
        return false;
    }

    private boolean isRepeatTjgdm(HttpServletRequest request, String codeId, String type) {
        try {
            //机构名称
            String codeName = tjgdm.getJgmc();
            String zch = tjgdm.getZch();
            String jglx = request.getParameter("jglx");
            //如果type为add是新增，需要判断重复;否则是更新需要根据用户是否修改机构代码或注册号判断是否需要判断重复
            if ("add".equals(type)) {
                //机构名称查重
                String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                if (!"".equals(retVal)) {
                    sourceTable = retVal.split(":")[1];
                    resultMsg = "codeRepeat";
                    return true;
                }
                //注册号查重
                String retValue = saveBus.isExistZch(zch, codeId, jglx, "");
                if (!"".equals(retValue)) {
                    resultMsg = "zchRepeat";
                    sourceTable = retValue.split(":")[1];
                    return true;
                }
                //注销库查重
                if (fzdmBus.isJgmcAndZchRepeat(codeName, zch, codeId)) {
                    resultMsg = "fzcRepeat";
                    return true;
                }
            } else {
                if (clsStringTool.isEmpty(codeId)) {
                    codeId = "";
                } else {
                    if ("null".equals(codeId.trim())) {
                        codeId = "";
                    }
                }
                //机构名称查重
                //如果用户输入的机构名称与页面输入的机构名称相同 不需要判断重复
                if (!codeName.equals(dcodeName)) {
                    codeNameRepeat = true;
                    String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                    if (!"".equals(retVal)) {
                        sourceTable = retVal.split(":")[1];
                        resultMsg = "codeRepeat";
                        return true;
                    }
                }
                //注册号查重
                //如果用户输入的注册号与页面输入的注册号相同 不需要判断重复
                if (!zch.equals(dzch)) {
                    String retValue = saveBus.isExistZch(zch, codeId, jglx, "");
                    if (!"".equals(retValue)) {
                        resultMsg = "zchRepeat";
                        sourceTable = retValue.split(":")[1];
                        return true;
                    }
                }
                //注销库查重
                if (!codeName.equals(dcodeName) && !zch.equals(dzch)) {
                    if (fzdmBus.isJgmcAndZchRepeat(codeName, zch, codeId)) {
                        resultMsg = "fzcRepeat";
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
        }
        return false;
    }


    /**
     * 申请表修改，删除,换证调用
     *
     * @return
     */
    public String search() {
        //已经登记的机构代码信息表单 操作t_jgdm表
        formType = "4";
        //申请表单修改
        if ("update".equals(source)) {
            if ("t_sptemp".equals(sourceTable)) {
                currentPath = "/product/jsp/certificate/updateJgdmView.jsp";
                TSpdmtemp spdm = new TSpdmtempBus().getSpdm(tyshxydm, "'16'");
                if (spdm != null) {
                    tjgdm = new TJgdm();
                    BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdm.class, false);
                    copier.copy(spdm, tjgdm, null);
                }
                List<TSp> sps = tSpBus.getTspList(tyshxydm, "16");
                if (sps != null && !sps.isEmpty()) {
                    shyj = sps.get(0).getShreason();
                    shresult = sps.get(0).getShflag().trim();
                }
                audit = true;
                needAudit = false;
            } else {
                currentPath = "/product/jsp/certificate/updateEnterInfoSave.jsp";
                tjgdm = jgdmBus.findById(tyshxydm);
                tfddbr= saveBus.fddbrList(tyshxydm);
                frjl=saveBus.getFrjl(tfddbr.getLsh());
                /*if ("1".equals(tjgdm.getDybz())) {
                    currentPath = "/product/jsp/certificate/certSearch.jsp";
                    resultMsg = "机构代码（" + jgdm + "）证书已经打印不能再做申请表修改！";
                    return SUCCESS;
                }*/
            }
        }
        //申请表单删除
        if ("delete".equals(source)) {
            type = "1";//删除操作
            currentPath = "/product/jsp/certificate/viewPage.jsp";
            if (InitSysParams.system.getSqbscsh() != null && InitSysParams.system.getSqbscsh()) {
                delMessage = tSpBus.getDelMessage(jgdm);
            } else
                delMessage = "1";
            tjgdm = jgdmBus.findJgdmByCondition(source, jgdm, bzjgdm);
            tjgdm = jgdmBus.findById(tyshxydm);
            /*if (!"0".equals(tjgdm.getDybz()) && "1".equals(tjgdm.getDjblx())) {
                currentPath = "/product/jsp/certificate/certSearch.jsp";
                resultMsg = "机构代码（" + jgdm + "）证书已经打印不能再做申请表删除！";
                return SUCCESS;
            }*/
        }
        //换证处理
        if ("certChange".equals(source)) {
            //判断是否处罚，如果处罚跳转到处罚页面
       /*     boolean cfFlag = jgdmBus.isChuFa();
            if (cfFlag) {
                User user = (User) session.get("sysUser");
                if (checkCfjl == null || !"no".equals(checkCfjl)) {
                    cfjlbList = jgdmBus.getCfzlList(jgdm);
                    if (cfjlbList != null && !cfjlbList.isEmpty()) {
                        if (!saveBus.isBeiAn(jgdm, user)) {

                            source = "hz";
                            currentPath = "/product/jsp/common/cflb.jsp";
                            return this.SUCCESS;
                        }
                    }
                }
            }*/
            formType = "3";
            
            listFzr= saveBus.fzrList(tyshxydm);
            currentPath = "/product/jsp/certificate/updateEnterInfo.jsp";
        	 EntityManager em = EntityManagerHelper.getEntityManager();
        	 
         	String sql="from TNNjjlx model where model.jglx='"+jglx+"'";
         	jjlx=em.createQuery(sql).getResultList();
         	String sql1="from ScZw model where model.jglx='"+jglx+"'";
        	zwList=em.createQuery(sql1).getResultList();
           // TSp tsp = tSpBus.checkRepeatAudia(jgdm);
            //如果需要重名审核或者系统设置换证审核 查看审核结果
           /* if (tsp != null) {
                String returnValue = tSpBus.checkforAudia(jgdm, "02");
                int i = returnValue.indexOf(":");
                String flag = returnValue.substring(0, i);
                //返回值状态 flag = 1 发送请求，等待审核；
                if ("1".equals(flag)) {
                    audit = false;
                    needAudit = true;
                    repeatAudit = true;
                    resultMsg = returnValue.substring(i + 1);
                    currentPath = "/product/jsp/certificate/certPromptInfo.jsp";
                    return this.SUCCESS;
                }
                shyj = tsp.getShreason();
                shresult = tsp.getShflag().trim();
                //返回值状态 flag = 2 已审核通过；
                if ("2".equals(flag)) {
                    needAudit = false;
                    audit = true;
                    TSpdmtemp spdm = new TSpdmtempBus().getSpdm(jgdm, tsp.getYwlx());
                    if (spdm != null) {
                        tjgdm = new TJgdm();
                        BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdm.class, false);

                        copier.copy(spdm, tjgdm, null);
                        currentPath = "/product/jsp/certificate/auditViewCert.jsp";
                        return this.SUCCESS;
                    }
                }
                //返回值状态 flag = 3 已审核不通过；
                if ("3".equals(flag)) {
                    //如果业务类型为换证重名,并且没有开启换证审核业务，则调用原数据,页面不需要在重新提交审核请求
                    if (1 == tsp.getSubmitType() && !(InitSysParams.system.getHzsh() != null && InitSysParams.system.getHzsh())) {
                        needAudit = false;
                        audit = false;
                        repeatAudit = true;
                        tjgdm = jgdmBus.findById(jgdm);
                    } else {
                        TSpdmtemp spdm = new TSpdmtempBus().getSpdmNoPass(jgdm, tsp.getYwlx());
                        if (spdm != null) {
                            tjgdm = new TJgdm();
                            BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdm.class, false);
                            copier.copy(spdm, tjgdm, null);
                        }
                        needAudit = true;
                        audit = true;
                        repeatAudit = false;
                    }
                }
                //返回值状态 flag = 4 需要发送请求；
                if ("4".equals(flag)) {
                    needAudit = true;
                    audit = false;
                    repeatAudit = false;
                    tjgdm = jgdmBus.findById(jgdm);
                    if (!"1".equals(tjgdm.getDybz())) {
                        currentPath = "/product/jsp/certificate/certSearch.jsp";
                        resultMsg = "机构代码（" + jgdm + "）证书还未打印证书，不能做换证处理！";
                        return SUCCESS;
                    }
                }
                //如果已经审核 获取审核结果及审核依据
                if (audit || repeatAudit) {
                    List<TSp> sps = tSpBus.getTspList(jgdm, tsp.getYwlx());
                    if (sps != null && !sps.isEmpty()) {
                        shyj = sps.get(0).getShreason();
                        shresult = sps.get(0).getShflag().trim();
                    }
                }
            }*/ //else {
          
                    tjgdm = jgdmBus.findById(tyshxydm);
                   /* if (!"1".equals(tjgdm.getDybz())) {
                        currentPath = "/product/jsp/certificate/certSearch.jsp";
                        resultMsg = "机构代码（" + jgdm + "）证书还未打印证书，不能做换证处理！";
                        return SUCCESS;
                    }*/
            
               /* if ((InitSysParams.system.getHzsh() != null && InitSysParams.system.getHzsh())) {
                    repeatAudit = false;
                    needAudit = true;
                    audit = false;
                } else {
                    repeatAudit = false;
                    needAudit = false;
                    audit = false;
                }*/
          //  }

        }

        if (tjgdm == null) {
            currentPath = "/product/jsp/certificate/certPromptInfo.jsp";
            resultMsg = "查询的记录不存在!";
            return this.SUCCESS;
        }
        //如果是申请表修改，并且需要重名审核并通过，需要从审核表中调用数据


        //工商数据导入----------------------------
        //if (!clsStringTool.isEmpty(dzch) && ("check".equals(type) || "update_no".equals(type))) {
        if (!clsStringTool.isEmpty(dzch) && "certChange".equals(source)) {
            if (tjgdm.getJglx().contains("b")) {
                List<Gtgsh> gtList = EntityManagerHelper.getEntityManager().createQuery("select model from Gtgsh model where model.czch = '" + dzch + "'").getResultList();
                if (gtList != null && gtList.size() > 0) {
                    Gtgsh gt = gtList.get(0);
                    tjgdm.setJgmc(gt.getVqymc());
                    tjgdm.setJgdz(gt.getVzs());
                    tjgdm.setJyfw(gt.getVchrJyfw());
                    tjgdm.setZcrq(gt.getDclrq());
                   // tjgdm.setGsfzrq(gt.getDjyqxz());
                    tjgdm.setZczj(gt.getNumZczb());
//                    tjgdm.setFddbr(gt.getVchrXm());
//                    tjgdm.setZjhm(gt.getChrZjhm());
                }
            } else {
                //TODO import..................
                List<Qiye> qyList = EntityManagerHelper.getEntityManager().createQuery("select model from Qiye model where model.czch = '" + dzch + "'").getResultList();
                if (qyList != null && qyList.size() > 0) {
                    Qiye qiye = qyList.get(0);
                    tjgdm.setJgmc(qiye.getVqymc());
                    tjgdm.setJgdz(qiye.getVzs());
                    tjgdm.setJyfw(qiye.getVchrJyfw());
                    tjgdm.setZcrq(qiye.getDclrq());
                   // tjgdm.setGsfzrq(qiye.getDjyqxz());
                    tjgdm.setZczj(qiye.getNumZczb());
//                    tjgdm.setFddbr(qiye.getVchrXm());
//                    tjgdm.setZjhm(qiye.getChrZjhm());
                }
            }
        }
        return this.SUCCESS;
    }

    /**
     * 申请表删除列表查询
     *
     * @return
     */
    public String delApplySaveList() {
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/certificate/delApplyList.jsp";
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        needAudit = InitSysParams.system.getSqbscsh() != null && InitSysParams.system.getSqbscsh();
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        if (!clsStringTool.isEmpty(ywlsh)) {
            params.put("ywlsh", ywlsh);
        }
        //判断是否开启业务流程
        if (isYwlc) {
            currentPath = "/product/jsp/certificate/delApplyYwlcList.jsp";
            if (needAudit) {
                ywlcDelList = ywlcBus.listDelAuditYwlc(user, "'校对赋码','申请表修改','校对'", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            } else {
                ywlcDelList = ywlcBus.listDelYwlc(user, "'校对赋码','申请表修改','校对'", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            }
        } else {
            //判断是否需要审核，如果需要审核需要与审核表关联查询审核状态；不需要审核直接查询单表
            if (needAudit) {
                vList = saveBus.delApplyListTjgdmSaveAudit(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            } else {
                vList = saveBus.delApplyListTjgdmSave(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            }
        }
        return this.SUCCESS;
    }

    /**
     * 其他部门赋码删除，预赋码删除列表查询
     *
     * @return
     */
    public String delSaveList() {
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/certificate/delList.jsp";
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        //其他部门赋码
        if ("1".equals(delType)) {
            params.put("djblx", "1");
            needAudit = InitSysParams.system.getQtbmfmsh() != null && InitSysParams.system.getQtbmfmsh();
            ywlx = "08";
        }
        //预赋码
        if ("2".equals(delType)) {
            params.put("djblx", "2");
            needAudit = InitSysParams.system.getYfmscsh() != null && InitSysParams.system.getYfmscsh();
            ywlx = "09";
        }
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        //判断是否需要审核，如果需要审核需要与审核表关联查询审核状态；不需要审核直接查询单表
        if (needAudit) {
            vList = saveBus.delListTjgdmSaveAudit(user, params, ywlx, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        } else {
            vList = saveBus.delListTjgdmSave(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        }

        return this.SUCCESS;
    }

    /**
     * 换证提交申请
     *
     * @return
     */
    public String auditSubmit() {

        try {
            currentPath = "/product/jsp/certificate/auditPromptInfo.jsp";
            User user = (User) session.get("sysUser");
            HttpServletRequest request = ServletActionContext.getRequest();
            tjgdm = jgdmBus.findById(jgdm);
            tSpBus.delSptempTjgdmData(tjgdm.getJgdm(), "02");
            String text = "换证";
            //不通过审核的提交审核请求 直接从页面上读取数据，通过审核的需要从t_sp表里面读取数据
            if (audit && !needAudit) {
                TSpdmtemp spdm = null;
                //重名审核，换证审核并存，以重名审核为主
                if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
                    text = "重名";
                }
                spdm = new TSpdmtempBus().getSpdm(jgdm, "02");
                BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdm.class, false);
                copier.copy(spdm, tjgdm, null);
            } else {
                getJGdmDate(request, tjgdm);
                this.bindingForm2Bean(tjgdm, request.getParameterMap());
            }
            int result = 0;
            result = new TSpBus().sendCertAudit(tjgdm, user, submitType);
            if (result == 1) {
                resultMsg = "机构代码(" + jgdm + ")的" + text + "请求已经发送给省中心。一旦省中心审核后，就可以进行换证操作！";
            }
            if (result == 0) {
                resultMsg = "机构代码(" + jgdm + ")" + text + "请求发送失败！";
            }

            //网上业务标识
            if (!clsStringTool.isEmpty(djblx)) {
                wsbzBus.saveWsyw(clsStringTool.convertNull(tjgdm.getJgdm()), tjgdm.getJgmc(), "3", "3", djh);
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
            return ERROR;
        }

        return this.SUCCESS;
    }

    /**
     * 申请表删除发送审核
     *
     * @return
     */
    public String send() {
        currentPath = "/product/jsp/certificate/delPromptInfo.jsp";
        User user = (User) session.get("sysUser");
        HttpServletRequest request = ServletActionContext.getRequest();
        String reason = request.getParameter("reason");
        String yw = request.getParameter("formType");
        //删除审批表里面存在此条机构代码审核不通过的记录
        tSpBus.delAuditNOPass(jgdm);
        int result = new TSpBus().sendDelRequest(jgdm, reason, user, yw);
        if (result == 2) {
            resultMsg = "机构代码(" + jgdm + ")已经向省中心发送了申请,请不要重新发送申请！";
        }
        if (result == 1) {
            resultMsg = "删除机构代码(" + jgdm + ")的请求已经发送给省中心。一旦省中心审核后，就可以删除此代码！";
        }
        if (result == 0) {
            resultMsg = "机构代码(" + jgdm + ")删除申请发送失败！";
        }
        return this.SUCCESS;
    }

    public String deleteApplyForm() {
        currentPath = "/product/jsp/certificate/promptInfo.jsp";
        User user = (User) session.get("sysUser");
        String result = new TSpBus().delApplyForm(jgdm, user);

        if ("1".equals(result)) {
            resultMsg = "机构代码(" + jgdm + ")删除成功，并且回收成功!可再利用!";
            
            tSpBus.delSptempTjgdmData(jgdm, "00");
        } else if ("0".equals(result)) {
            resultMsg = "机构代码(" + jgdm + ")申请表删除失败！";
        } else if ("2".equals(result)) {
            resultMsg = "要恢复的机构代码不存在!";
        } else if (result.contains("3")) {
            resultMsg = "国家中心代码删除出错：" + result.split(":")[1] + "，请重试!";
        }
        return this.SUCCESS;
    }

    public String list() {
        //是否开启业务流程
        String ywlclx = "";
        String type = "'受理'";
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        if (!isYwlc) {
            params.put("djblx", formType);
        }
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        if (!clsStringTool.isEmpty(tyshxydm)) {
        	if(tyshxydm.length()==9){
        		
        		params.put("jgdm", tyshxydm);
        	}else{
        		params.put("tyshxydm", tyshxydm);
        		
        	}
        }
        if (!clsStringTool.isEmpty(ywlsh)) {
            params.put("ywlsh", ywlsh);
        }
  /*      if(formType.equals("0")){
	        if (!clsStringTool.isEmpty(bak3)) {
	            params.put("bak3", bak3); 
	        }else{
	        	if(user.getUserCareer()!=null&&user.getUserCareer().equals("admin")){
	        		 params.put("bak3", "1");
	        		 bak3="1";
	        	}else{
	        	 params.put("bak3", "0");
	        	}
	        }
        }*/
        if ("0".equals(formType)) {
            ywlclx = "'1'";
        }
        if ("1".equals(formType)) {
            ywlclx = "'4'";
        }
        if ("2".equals(formType)) {
            ywlclx = "'3'";
        }
        if (!isYwlc) {
            currentPath = "/product/jsp/certificate/certList.jsp";
            //预赋码
            if ("2".equals(formType)) {
                currentPath = "/product/jsp/certificate/entCertList.jsp";
            }
            list = saveBus.listTjgdmSave(user, formType, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod,jglx);
        } else {
            currentPath = "/product/jsp/certificate/newYwlc.jsp";
            //预赋码
            if ("2".equals(formType)) {
                type = "'受理','更新'";
                currentPath = "/product/jsp/certificate/newPreYwlc.jsp";
            }
            ywlcList = ywlcBus.listNewYwlc(user, ywlclx, type, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        }
        return this.SUCCESS;
    }
   

    public String yfmList() {
        formType = "2";
        //是否开启业务流程
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        String ywlclx = "'2','5'";
        String type = "'受理'";
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        if (!isYwlc) {
            //预赋码
            params.put("djblx", "2");
        }
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
        if (!clsStringTool.isEmpty(jgdm)) {
            params.put("jgdm", jgdm);
        }
        if (!clsStringTool.isEmpty(ywlsh)) {
            params.put("ywlsh", ywlsh);
        }
        currentPath = "/product/jsp/certificate/entPartCertList.jsp";
        list = saveBus.listYfm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        /*
        if (!isYwlc) {
            currentPath = "/product/jsp/certificate/entPartCertList.jsp";
            list = saveBus.listYfm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        } else {
            currentPath = "/product/jsp/certificate/newPartPreYwlc.jsp";
            ywlcList = ywlcBus.listNewYwlc(user, ywlclx, type, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        }
        */
        return this.SUCCESS;
    }
    public String searchDm(){
    	try{
    		//currentPath = "/product/jsp/certificate/addinfomationEnter.jsp";
    		currentPath = "/product/jsp/certificate/jgdmdmList.jsp";
    		if (page == null) {
                page = new Page();
                page.setOrderByType("desc");
            }
    		String sql="";
    		  if(!"".equals(jgdmdm.getJgmc())){
            	  sql+=" and model.jgmc like '%"+jgdmdm.getJgmc()+"%'";
              }
    		  jgdmdmList=EntityManagerHelper.getEntityManager().createQuery("from TJgdmdm model where 1=1"+sql+"order by bzrq desc").getResultList();
    		    page.setTotalRecord(((Long) EntityManagerHelper.getEntityManager().createQuery(" select count(*)  from TJgdmdm  model where 1=1"+sql )
    		            .getResultList().get(0)).intValue());
    		    if(jgdmdmList.size()>0){
    		    	currentPath = "/product/jsp/certificate/jgdmdmList.jsp";
    		    }else{
    		    	resultMsg="没有查出相关信息，是否继续？";
    		    	//formType="0";
    		    }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return this.SUCCESS;
    }
    public String operList() {
        //是否开启业务流程
        //isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/certificate/jgdmUpdateList.jsp";
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
       /* if (!clsStringTool.isEmpty(tyshxydm)) {
            params.put("tyshxydm", tyshxydm);
        }*/
        if (!clsStringTool.isEmpty(ywlsh)) {
            params.put("ywlsh", ywlsh);
        }
        if (isYwlc) {
            currentPath = "/product/jsp/certificate/updateApplyFormYwlc.jsp";
            ywlcList = ywlcBus.listYwlc(user, "'校对赋码','校对','申请表修改'", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        } else {
            tjgdmList = jgdmBus.listTjgdm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod,jglx,tyshxydm);
        }
        return this.SUCCESS;
    }

    public String certOperList() {
        //是否开启业务流程
        //isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        /*if (!isYwlc) {
            params.put("dybz", "1");
        }*/
        if (!clsStringTool.isEmpty(jgmc)) {
            params.put("jgmc", jgmc);
        }
      /*  if (!clsStringTool.isEmpty(tyshxydm)) {
            params.put("tyshxydm", tyshxydm);
        }
        if (!clsStringTool.isEmpty(tyshxydm)) {
            params.put("jgdm", tyshxydm);
        }*/
        if (!clsStringTool.isEmpty(ywlsh)) {
            params.put("ywlsh", ywlsh);
        }
   
            currentPath = "/product/jsp/certificate/jgdmCertChangeList.jsp";
            pages.setCurrentPage(0);
            if (!clsStringTool.isEmpty(showData)) {
                vList = jgdmBus.listCertTjgdm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod,jglx,tyshxydm);
            }
      
        return this.SUCCESS;
    }


    public String dailyCertList() {
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/certificate/dailyCertList.jsp";
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        params.put("jgdm", jgdm);
        if (!user.getUserName().contains("admin")) {
            params.put("bzjgdm", user.getBzjgdm());
        }
        zsdsList = new TZsdsBus().listTZsds(params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        return this.SUCCESS;
    }


    public String updatePage() {
        currentPath = "/product/jsp/certificate/updateEnterInfo.jsp";
        //如果是申请表修改，并且需要重名审核并通过，需要从审核表中调用数据
        if ("t_sptemp".equals(sourceTable)) {
            currentPath = "/product/jsp/certificate/updateEnterInfoView.jsp";
            String tempValue = "";
            if (jgdm == null || "".equals(jgdm.trim()) || "0".equals(formType)) {
                tempValue = id;
            } else {
                tempValue = jgdm;
            }
            TSpdmtemp spdm = new TSpdmtempBus().getSpdm(tempValue, "'10','11','15'");
            if (spdm != null) {
                if (jgdm == null || "".equals(jgdm.trim()) || "0".equals(formType)) {
                    jgdmSave = saveBus.findById(Integer.valueOf(tempValue));
                } else
                    jgdmSave = saveBus.findByJgdm(tempValue);
                BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdmSave.class, false);
                copier.copy(spdm, jgdmSave, null);
            }
            String ywType = "";
            if ("0".equals(formType)) {
                ywType = "10";
            }
            if ("1".equals(formType)) {
                ywType = "11";
            }
            if ("2".equals(formType)) {
                ywType = "15";
            }
            List<TSp> sps = tSpBus.getTspList(jgdm, ywType);
            if (sps != null && !sps.isEmpty()) {
                shyj = sps.get(0).getShreason();
                shresult = sps.get(0).getShflag().trim();
            }
            audit = true;
            needAudit = false;
        } else {
            jgdmSave = saveBus.findByJgdm(id);
            if (jgdmSave == null) {
                jgdmSave = saveBus.findById(Integer.valueOf(id));
            }
        }
        return this.SUCCESS;
    }
    public String updatePageSave() {
    	System.out.println(jglx);
        currentPath = "/product/jsp/certificate/updateEnterInfoSave.jsp";
        //如果是申请表修改，并且需要重名审核并通过，需要从审核表中调用数据
        if ("t_sptemp".equals(sourceTable)) {
            currentPath = "/product/jsp/certificate/updateEnterInfoView.jsp";
            String tempValue = "";
            if (tyshxydm == null || "".equals(tyshxydm.trim()) || "0".equals(formType)) {
                tempValue = id;
            } else {
                tempValue = tyshxydm;
            }
            TSpdmtemp spdm = new TSpdmtempBus().getSpdm(tempValue, "'07','11','15','13'");
            if (spdm != null) {
                if (tyshxydm == null || "".equals(tyshxydm.trim()) || "0".equals(formType)) {
                    jgdmSave = saveBus.findById(Integer.valueOf(tempValue));
                } else
                    jgdmSave = saveBus.findByJgdm(tempValue);
                BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdmSave.class, false);
                copier.copy(spdm, jgdmSave, null);
            }
            String ywType = "";
            if ("0".equals(formType)) {
                ywType = "10";
            }
            if ("1".equals(formType)) {
                ywType = "11";
            }
            if ("2".equals(formType)) {
                ywType = "15";
            }
            List<TSp> sps = tSpBus.getTspList(tyshxydm, ywType);
            if (sps != null && !sps.isEmpty()) {
                shyj = sps.get(0).getShreason();
                shresult = sps.get(0).getShflag().trim();
            }
            audit = true;
            needAudit = false;
        } else {
            jgdmSave = saveBus.findByJgdm(id);
            if (jgdmSave == null) {
                jgdmSave = saveBus.findById(Integer.valueOf(id));
                tfddbr= saveBus.fddbrList(id);
                frjl=saveBus.getFrjl(tfddbr.getLsh());
                //listFzr=saveBus.fzrList(id);
            }
        }
        return this.SUCCESS;
    }

    public String updateRequisitionPage() {
        currentPath = "/product/jsp/certificate/updateRequisition.jsp";
        if ("t_sptemp".equals(sourceTable)) {
            currentPath = "/product/jsp/certificate/viewRequisition.jsp";
            String tempValue = "";
            if (jgdm == null || "".equals(jgdm.trim())) {
                tempValue = id;
            } else {
                tempValue = jgdm;
            }
            TSpdmtemp spdm = new TSpdmtempBus().getSpdm(tempValue, "'10','11','15'");
            if (spdm != null) {
                if (jgdm == null || "".equals(jgdm.trim())) {
                    jgdmSave = saveBus.findById(Integer.valueOf(tempValue));
                    BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdmSave.class, false);
                    copier.copy(spdm, jgdmSave, null);
                    jgdmSave.setJgdm("");
                } else {
                    jgdmSave = saveBus.findByJgdm(tempValue);
                    BeanCopier copier = BeanCopier.create(TSpdmtemp.class, TJgdmSave.class, false);
                    copier.copy(spdm, jgdmSave, null);
                }

            }
            audit = true;
            needAudit = false;
        } else {
            isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
            if (isYwlc) {
                jgdmSave = saveBus.findByJgdm(id);
            } else
                jgdmSave = saveBus.findById(Integer.valueOf(id));
        }
        return this.SUCCESS;
    }

    public String printCertNotice() {
        currentPath = "/product/jsp/certificate/printCertNotice.jsp";
        jgdmSave = saveBus.findById(Integer.valueOf(id));
        return this.SUCCESS;
    }


    public String viewPage() {
    	System.out.println(jglx);
        currentPath = "/product/jsp/certificate/viewPage.jsp";
        if ("4".equals(formType)) {
            tjgdm = jgdmBus.findById(jgdm);
        } else {
            jgdmSave = saveBus.findByJgdm(id);
            if (jgdmSave == null) {
                jgdmSave = saveBus.findById(Integer.valueOf(id));
            }
            System.out.println("jgdmSvae=----------------------"+jgdmSave);
            fddbr= saveBus.fddbrList(id);
        }
        return this.SUCCESS;
    }

    public String viewFddbrPage() {
        currentPath = "/product/jsp/certificate/viewFddbrPage.jsp";
        if ("t_jgdm_save".equals(sourceTable)) {
            jgdmSave = saveBus.findById(Integer.parseInt(id));
        }
        if ("t_jgdm".equals(sourceTable)) {
            tjgdm = jgdmBus.findById(jgdm);
            jgdmSave = new TJgdmSave();
            BeanCopier beanCopier = BeanCopier.create(TJgdm.class, TJgdmSave.class, false);
            beanCopier.copy(tjgdm, jgdmSave, null);
        }
        //bs库
        if ("t_jgdm_bs".equals(sourceTable)) {
        	TJgdmBs tjgdm = jgdmBus.findByIdBs(jgdm);
        	jgdmSave = new TJgdmSave();
        	BeanUtilsEx.copyProperties(jgdmSave,tjgdm);
        	
        	//BeanCopier beanCopier = BeanCopier.create(TJgdmBs.class, TJgdmSave.class, false);
        	//beanCopier.copy(tjgdm, jgdmSave, null);
        }
        if ("t_qzjgdm".equals(sourceTable)) {
            qzjgdm = qzjgdmBus.getQzjgdmByJgdm(jgdm);
            jgdmSave = new TJgdmSave();
            BeanCopier beanCopier = BeanCopier.create(TQzjgdm.class, TJgdmSave.class, false);
            beanCopier.copy(qzjgdm, jgdmSave, null);
        }
        if ("t_fzdm".equals(sourceTable)) {
            fzdm = fzdmBus.findById(jgdm);
            jgdmSave = new TJgdmSave();
            BeanCopier beanCopier = BeanCopier.create(TFzdm.class, TJgdmSave.class, false);
            beanCopier.copy(fzdm, jgdmSave, null);
        }
        //bs库
        if ("t_fzdm_bs".equals(sourceTable)) {
        	TFzdmBs fzdm = fzdmBus.findByIdBs(jgdm);
        	jgdmSave = new TJgdmSave();
        	BeanUtilsEx.copyProperties(jgdmSave,fzdm);
        	//BeanCopier beanCopier = BeanCopier.create(TFzdmBs.class, TJgdmSave.class, false);
        	//beanCopier.copy(fzdm, jgdmSave, null);
        }
        
        return this.SUCCESS;
    }

    public String printCert() {
        currentPath = "/product/jsp/certificate/printPage.jsp";
        tjgdm = jgdmBus.findById(jgdm);
        return this.SUCCESS;
    }

    public String viewRequisitionPage() {
        currentPath = "/product/jsp/certificate/viewRequisition.jsp";
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        if (isYwlc) {
            jgdmSave = saveBus.findByJgdm(id);
            if (jgdmSave == null) {
                jgdmSave = saveBus.findById(Integer.valueOf(id));
            }
        } else
            jgdmSave = saveBus.findById(Integer.valueOf(id));
        return this.SUCCESS;
    }

    /**
     * 查询法定代表人列表
     *
     * @return
     */
    public String frdbList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String fddbr = request.getParameter("fddbr");
        try {
            fddbr = java.net.URLDecoder.decode(fddbr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(IssueCertificateAction.class, e);
        }
        currentPath = "/product/jsp/certificate/frdbList.jsp";
        commonList = saveBus.getFrdbList(fddbr);
        path = "fddbr";
        return this.SUCCESS;
    }

    /**
     * 查询证件号码列表
     *
     * @return
     */
    public String zjhmList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String zjlx = request.getParameter("zjlx");
        String zjhm = request.getParameter("zjhm");
        try {
            zjhm = java.net.URLDecoder.decode(zjhm, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(IssueCertificateAction.class, e);
        }
        currentPath = "/product/jsp/certificate/frdbList.jsp";
        commonList = saveBus.getZjhmList(zjlx, zjhm);
        path = "zjhm";
        return this.SUCCESS;
    }

    /**
     * 查询证件号码列表
     *
     * @return
     */
    public String mcList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String value = request.getParameter("value");
        String type = request.getParameter("type");
        try {
            value = java.net.URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(IssueCertificateAction.class, e);
        }
        currentPath = "/product/jsp/certificate/mcList.jsp";
        commonList = saveBus.getMcList(type, value);
        path = "hzcq";
        return this.SUCCESS;
    }

    /**
     * 查询证件号码列表
     *
     * @return
     */
    public String hzcqList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String value = request.getParameter("value");
        try {
            value = java.net.URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(IssueCertificateAction.class, e);
        }
        currentPath = "/product/jsp/certificate/mcList.jsp";
        commonList = saveBus.getHzcqList(value);
        path = type;
        return this.SUCCESS;
    }
    
    /**
     * 查询机构名称列表
     * @return
     */
    public String jgmcList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String jgmc = request.getParameter("jgmc");
        try {
        	jgmc = java.net.URLDecoder.decode(jgmc, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(IssueCertificateAction.class, e);
        }
        currentPath = "/product/jsp/certificate/cfList.jsp";
        commonList =saveBus.getMcList("jgmc", jgmc);
//        type = "jgmc";
        type="2";
        return this.SUCCESS;
    }
    /**
     * 查重列表
     * @return
     */
    public String cfCxList() {
    	
    	currentPath = "/product/jsp/certificate/cfList.jsp";
    	String tjmc="";
    	if(type.equals("1")){
    		tjmc="zch";
    	}else if(type.equals("2")){
    		tjmc="jgmc";
    	}else if(type.equals("3")){
    		tjmc="fddbr";
    	}
    	commonList =saveBus.getMcList(tjmc, source);
    	return this.SUCCESS;
    }
    
    /**
     * 查询注册号列表
     * @return
     */
    public String zchList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String zch = request.getParameter("zch");
        currentPath = "/product/jsp/certificate/cfList.jsp";
        commonList =saveBus.getMcList("zch", zch);
         type="zch";
        return this.SUCCESS;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TJgdmSave getJgdmSave() {
        return jgdmSave;
    }

    public void setJgdmSave(TJgdmSave jgdmSave) {
        this.jgdmSave = jgdmSave;
    }

    public TJgdm getTjgdm() {
        return tjgdm;
    }

    public void setTjgdm(TJgdm tjgdm) {
        this.tjgdm = tjgdm;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public List<TjgdmVO> getList() {
        return list;
    }

    public void setList(List<TjgdmVO> list) {
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


    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDelMessage() {
        return delMessage;
    }

    public void setDelMessage(String delMessage) {
        this.delMessage = delMessage;
    }

    public List<TZs> getZsList() {
        return zsList;
    }

    public void setZsList(List<TZs> zsList) {
        this.zsList = zsList;
    }

    public List<TYwlc> getYwlcList() {
        return ywlcList;
    }

    public void setYwlcList(List<TYwlc> ywlcList) {
        this.ywlcList = ywlcList;
    }

    public List<TZsds> getZsdsList() {
        return zsdsList;
    }

    public void setZsdsList(List<TZsds> zsdsList) {
        this.zsdsList = zsdsList;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public Boolean getNeedAudit() {
        return needAudit;
    }

    public void setNeedAudit(Boolean needAudit) {
        this.needAudit = needAudit;
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

    public String getDzch() {
        return dzch;
    }

    public void setDzch(String dzch) {
        this.dzch = dzch;
    }

    public String getDcodeName() {
        return dcodeName;
    }

    public void setDcodeName(String dcodeName) {
        this.dcodeName = dcodeName;
    }

    public String getDelType() {
        return delType;
    }

    public void setDelType(String delType) {
        this.delType = delType;
    }

    public List<TjgdmVO> getVList() {
        return vList;
    }

    public void setVList(List<TjgdmVO> vList) {
        this.vList = vList;
    }

    public List<TjgdmVO> getTjgdmList() {
        return tjgdmList;
    }

    public void setTjgdmList(List<TjgdmVO> tjgdmList) {
        this.tjgdmList = tjgdmList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public boolean isYwlc() {
        return isYwlc;
    }

    public void setYwlc(boolean ywlc) {
        isYwlc = ywlc;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public List<TywlcVO> getYwlcDelList() {
        return ywlcDelList;
    }

    public void setYwlcDelList(List<TywlcVO> ywlcDelList) {
        this.ywlcDelList = ywlcDelList;
    }

    public String getCheckCfjl() {
        return checkCfjl;
    }

    public void setCheckCfjl(String checkCfjl) {
        this.checkCfjl = checkCfjl;
    }

    public List<TCfjlb> getCfjlbList() {
        return cfjlbList;
    }

    public void setCfjlbList(List<TCfjlb> cfjlbList) {
        this.cfjlbList = cfjlbList;
    }

    public List<TjgdmCommon> getCommonList() {
        return commonList;
    }

    public void setCommonList(List<TjgdmCommon> commonList) {
        this.commonList = commonList;
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public Boolean getRepeatAudit() {
        return repeatAudit;
    }

    public void setRepeatAudit(Boolean repeatAudit) {
        this.repeatAudit = repeatAudit;
    }

    /**
     * 绑定form里面的值到对象，可节省装载属性的时间，但是注意，此方法只装载form中各个字段name[0]的value，可满足一般性需求，如果name长度大于1，则需自己写方法
     *
     * @param obj
     * @param map
     */
    protected void bindingForm2Bean(Object obj, Map map) {
        Map processedMap = new HashMap();
        for (Iterator iter = map.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String[] val = (String[]) entry.getValue();
            processedMap.put(key, val[0]);
        }
        BeanUtilsEx.copyProperties(obj, processedMap);
    }

    private void getPwDate(HttpServletRequest request, TJgdmSave jgdmSave) {
        String bzrq = request.getParameter("tbzrq");
        if (!clsStringTool.isEmpty(bzrq)) {
            jgdmSave.setBzrq(new Timestamp(DateUtil.strToDate(bzrq).getTime()));
           /* jgdmSave.setNjqx(DateUtil.strToDate(DateUtil.addMonth(DateUtil.dateToStr(new Date()), 12)));
            jgdmSave.setZfrq(DateUtil.strToDate(DateUtil.addMonth(DateUtil.dateToStr(new Date()), 48)));*/
        }
        String pwrq = request.getParameter("tpwrq");
        //jgdmSave.setPwrq(new Timestamp(DateUtil.strToDate(pwrq).getTime()));
    }

    private void getDate(HttpServletRequest request, TJgdmSave jgdmSave) {
        String tzcrq = request.getParameter("tzcrq");
        if("".equals(tzcrq)){
        	jgdmSave.setZcrq(null);
        }else{
        	
        	
        	jgdmSave.setZcrq(new Timestamp(DateUtil.strToDate(tzcrq).getTime()));
        }
        
        String bzrq = request.getParameter("tbzrq");
        if("".equals(bzrq)){
        	jgdmSave.setBzrq(null);
        }else{
        	
        	jgdmSave.setBzrq(new Timestamp(DateUtil.strToDate(bzrq).getTime()));
        }
        String tnjqx = request.getParameter("tnjqx");
        //jgdmSave.setNjqx(new Timestamp(DateUtil.strToDate(tnjqx).getTime()));
        String tzfrq = request.getParameter("tzfrq");
        if("".equals(tzfrq)){
        	jgdmSave.setYxqxe(null);
        }else{
        	
        	jgdmSave.setYxqxe(new Timestamp((DateUtil.strToDate(tzfrq)).getTime()));
        }
   
        
        String yxqxs = request.getParameter("tyxqxs");
        if(!clsStringTool.isEmpty(yxqxs)){
        	jgdmSave.setYxqxs(new Timestamp(DateUtil.strToDate(yxqxs).getTime()));
        }else{
        	jgdmSave.setYxqxs(null);
        }
        String jlrq = request.getParameter("tjlrq");
        if(!clsStringTool.isEmpty(jlrq)){
        	jgdmSave.setJlrq(new Timestamp(DateUtil.strToDate(jlrq).getTime()));
        }else{
        	jgdmSave.setJlrq(null);
        }
        String txjrq = request.getParameter("txjrq");
        if(!clsStringTool.isEmpty(txjrq)){
        	jgdmSave.setXjrq(new Timestamp(DateUtil.strToDate(txjrq).getTime()));
        }else{
        	jgdmSave.setXjrq(null);
        }
    
       /* if (!clsStringTool.isEmpty(tgsfzrq)) {
            jgdmSave.setGsfzrq(new Timestamp(DateUtil.strToDate(tgsfzrq).getTime()));
        }else{
        	jgdmSave.setGsfzrq(null);
        } */
    }

    private void getJGdmDate(HttpServletRequest request, TJgdm tJgdm) {
        String tzcrq = request.getParameter("tzcrq");
        if (!clsStringTool.isEmpty(tzcrq)) {
        	
        	tJgdm.setZcrq(new Timestamp(DateUtil.strToDate(tzcrq).getTime()));
        }else{
        	tJgdm.setZcrq(null);
        }
        	
        String bzrq = request.getParameter("tbzrq");
        if (!clsStringTool.isEmpty(bzrq)) {
        	
        	tJgdm.setBzrq(new Timestamp(DateUtil.strToDate(bzrq).getTime()));
        }else{
        	tJgdm.setBzrq(null);
        }
        String tnjqx = request.getParameter("tnjqx");

        	
       // tJgdm.setNjqx(new Timestamp(DateUtil.strToDate(tnjqx).getTime()));
        String tzfrq = request.getParameter("tzfrq");
        if("".equals(tzfrq)){
        	tJgdm.setYxqxe(null);
        }else{
        	
        	tJgdm.setYxqxe(new Timestamp((DateUtil.strToDate(tzfrq)).getTime()));
        }
        	
        String tgsfzrq = request.getParameter("tgsfzrq");
        String yxqxs = request.getParameter("tyxqxs");
        if(!clsStringTool.isEmpty(yxqxs)){
        	tJgdm.setYxqxs(new Timestamp(DateUtil.strToDate(yxqxs).getTime()));
        }else{
        	tJgdm.setYxqxs(null);
        }
        String jlrq = request.getParameter("tjlrq");
        if(!clsStringTool.isEmpty(jlrq)){
        	tJgdm.setJlrq(new Timestamp(DateUtil.strToDate(jlrq).getTime()));
        }else{
        	tJgdm.setJlrq(null);
        }
        String txjrq = request.getParameter("txjrq");
        if(!clsStringTool.isEmpty(jlrq)){
        	tJgdm.setXjrq(new Timestamp(DateUtil.strToDate(txjrq).getTime()));
        }else{
        	tJgdm.setXjrq(null);
        }
        /*if (!clsStringTool.isEmpty(tgsfzrq)) {
            tJgdm.setGsfzrq(new Timestamp(DateUtil.strToDate(tgsfzrq).getTime()));
        }*/
    }

    public String getDjblx() {
        return djblx;
    }

    public void setDjblx(String djblx) {
        this.djblx = djblx;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public Wgs getWgs() {
        return wgs;
    }

    public void setWgs(Wgs wgs) {
        this.wgs = wgs;
    }

    public String getSslcode() {
        return sslcode;
    }

    public void setSslcode(String sslcode) {
        this.sslcode = sslcode;
    }

	public String getWsBzjgdm() {
		return wsBzjgdm;
	}

	public void setWsBzjgdm(String wsBzjgdm) {
		this.wsBzjgdm = wsBzjgdm;
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public String getTyshxydm() {
		return tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	public List<TNNjjlx> getJjlx() {
		return jjlx;
	}

	public void setJjlx(List<TNNjjlx> jjlx) {
		this.jjlx = jjlx;
	}

	public TFzr getFzr() {
		return fzr;
	}

	public void setFzr(TFzr fzr) {
		this.fzr = fzr;
	}
	

	public String getIsdang() {
		return isdang;
	}

	public void setIsdang(String isdang) {
		this.isdang = isdang;
	}


	public TFddbr getFddbr() {
		return fddbr;
	}

	public void setFddbr(TFddbr fddbr) {
		this.fddbr = fddbr;
	}

	public List<ScZw> getZwList() {
		return zwList;
	}

	public void setZwList(List<ScZw> zwList) {
		this.zwList = zwList;
	}



	public TFddbr getTfddbr() {
		return tfddbr;
	}

	public void setTfddbr(TFddbr tfddbr) {
		this.tfddbr = tfddbr;
	}

	public TFrjl getFrjl() {
		return frjl;
	}

	public void setFrjl(TFrjl frjl) {
		this.frjl = frjl;
	}
	
	public List<TJgdmdm> getJgdmdmList() {
		return jgdmdmList;
	}

	public void setJgdmdmList(List<TJgdmdm> jgdmdmList) {
		this.jgdmdmList = jgdmdmList;
	}

	public TJgdmdm getJgdmdm() {
		return jgdmdm;
	}

	public void setJgdmdm(TJgdmdm jgdmdm) {
		this.jgdmdm = jgdmdm;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
}
