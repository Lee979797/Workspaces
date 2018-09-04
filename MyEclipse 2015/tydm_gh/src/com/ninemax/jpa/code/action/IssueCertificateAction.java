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
 * Time: ����10:08
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
    //type ����ҳ����ת�ж��ǲ鿴 �޸Ļ���У��
    private String type;
    //�ǼǱ�0���������Ÿ���1��Ԥ����2, ��֤3 ������޸� 4
    private String formType;
    private String jgdm;
    private String jgmc;
    private String bzjgdm;
    //������޸Ļ�ɾ����ʾ�Լ�֤���ʧģ��
    private String source;
    //��ʾ���ذ�ť���غδ�
    private String path;
    private String checkCfjl;

    //�����ɾ����Ϣ��ʾ
    private String delMessage;
    //��Ҫ��˱��
    private Boolean needAudit;
    //�Ƿ��Ѿ����
    private Boolean audit;
    //�����Ƿ����
    private Boolean repeatAudit;
    //�������
    protected String ywlx;
    //�������
    protected String shyj;
    //��˽��
    protected String shresult;
    //ע���
    private String dzch;
    //��������
    private String dcodeName;
    //��ʾ�������Ÿ���ɾ����Ԥ����ɾ�� 1�������� 2 Ԥ���� 4 �����ɾ��
    private String delType;
    //�Ƿ���ҵ������
    private boolean isYwlc;
    private boolean codeNameRepeat;
    private String sourceTable;
    //��������Ƿ���ʾ����Ĭ�ϲ���ʾ
    private String showData;
    //�����ж�
    private String nameType;
    //Ȩ������
    private String submitType;
    //��ʶ��������������
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
        //������������Ÿ��������Ҫ����֤���������Ƿ����
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
        /*//�ж��ظ�
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
            //��������ҵ������
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
        //�����Ҫ������ˣ���������ύ
        /*if (("1".equals(formType)||"8".equals(formType))||(!clsStringTool.isEmpty(submitType) && !"0".equals(submitType))) {
            //ֻ����ӳɹ����ܷ�������
            if (addResult == 1) {
                //�ж�formType 0 ����ͨ�����Ǽǣ�1 �������Ÿ���Ǽǣ�
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
                    promptName = "ע��ţ����������Ƿ�����ظ�";
                }
                if ("1".equals(submitType)) {
                    promptName = "���������Ƿ�����ظ�";
                }
                if ("2".equals(submitType)) {
                    promptName = "ע����Ƿ�����ظ�";
                }
                if ("4".equals(submitType)) {
                    promptName = "���������Ƿ���԰����������硯";
                }
                if ("5".equals(submitType)) {
                    promptName = "�����Ƿ��������";
                }
                if (result == 1) {
                    nameType = "revisionForbidden";
                    resultMsg = promptName + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ���У�Բ�����";
                }
                if (result == 0) {
                    resultMsg = promptName + "������ʧ�ܣ�";
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
    		//���������߼�
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
            ywlsh = ywlcBus.updateYwlc(id, jgdmSave.getJgmc(), "1", "����", "0", jgdmSave.getBzjgdm(),user.getUserName());
        }
        if ("1".equals(formType)) {
            ywlsh = ywlcBus.updateYwlc(id, jgdmSave.getJgmc(), "4", "����", "0", jgdmSave.getBzjgdm(),user.getUserName());
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

                resultMsg = "�������ƣ�" + jgmc + " �����Ǽ������ɹ�!";
              /*  if(!"".equals(jgdmSave.getBak4())&&jgdmSave.getBak4()!=null&&!"A".equals(jgdmSave.getBak4())){
                	TyGsBus bus=new TyGsBus();
                	bus.updateStatus(jgdmSave.getBak4());
                }*/
                if (isYwlc) {
                    resultMsg += "ҵ����ˮ��:" + ywlsh;
                }
            }
            if ("1".equals(formType)) {
                resultMsg = "�������룺" + jgdm + " �������Ÿ��������ɹ�!";
                if (isYwlc) {
                    resultMsg += "ҵ����ˮ��:" + ywlsh;
                }
            }
        } else {
        	currentPath = "/product/jsp/certificate/addError.jsp";
        	resultMsg = "�������ƣ�" + jgmc + " �����Ǽ�ʧ��!��ȷ������״��֮������¼��.";
        }
        return result;
    }

    public String addRequisition() {
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        HttpServletRequest request = setValue("add");
        getPwDate(request, jgdmSave);
        User user = (User) session.get("sysUser");
        String xzqh = user.getBzjgdm();
        //�������Ʋ���
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
        //�����Ҫ������ˣ���������ύ
        if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            //�ж�formType 0 ����ͨ�����Ǽǣ�1 �������Ÿ���Ǽǣ�2 Ԥ����Ǽ�
            ywlx = "15";
            int result = new TSpBus().sendSaveAudit(jgdmSave, user, submitType, ywlx);
            String promptName = "";
            if ("3".equals(submitType)) {
                promptName = "ע��ţ����������Ƿ�����ظ�";
            }
            if ("1".equals(submitType)) {
                promptName = "���������Ƿ�����ظ�";
            }
            if ("2".equals(submitType)) {
                promptName = "ע����Ƿ�����ظ�";
            }
            if (result == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ���У�Բ�����";
            }
            if (result == 0) {
                resultMsg = promptName + "������ʧ�ܣ�";
            }
            source = "/bsweb/certificate_yfmList.action";
            currentPath = "/product/jsp/certificate/certSuccess.jsp";
        } else {
            int addResult = saveBus.AddTjgdmSavePart(jgdmSave, sslcode);
            id = String.valueOf(jgdmSave.getId());
            //String ywlsh = ywlcBus.updateYwlc(jgdmSave.getJgdm(), jgdmSave.getJgmc(), "3", "����", "0", jgdmSave.getBzjgdm());
            if (addResult == 1) {
                id = String.valueOf(jgdmSave.getId());
                jgdm = jgdmSave.getJgdm();
                source = "/bsweb/certificate_yfmList.action";
                currentPath = "/product/jsp/certificate/certSuccess.jsp";
                resultMsg = "������" + jgmc + "����ӳɹ���Ԥ���루" + jgdm + "��";
                if (isYwlc) {
                    resultMsg += "ҵ����ˮ��:" + ywlsh;
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
        //��ͨ����˵��޸�ֱ�Ӵ�ҳ���϶�ȡ���ݣ�ͨ����˵��޸���Ҫ��t_sp�������ȡ����
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

        //����������Ʒ����仯��Ҫ�������Ʋ���
        String codeName = jgdmSave.getJgmc();
        /*String retVal = saveBus.isExistCodeName(codeName, jgdm);
        if (!"".equals(retVal)) {
            resultMsg = "codeRepeat";
            sourceTable = retVal.split(":")[1];
            return "repeat";
        }*/
        //�޸�ǰȥɾ����˱�����˵ǼǱ��Ӧ������
        tSpBus.delSptempData(jgdmSave, "15");
        currentPath = "/product/jsp/certificate/updatePrompt.jsp";
        source = "yfmList";
        //�����Ҫ������ˣ���������ύ
        if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            ywlx = "15";
            jgmc = jgdmSave.getJgmc();
            int urRsult = new TSpBus().sendSaveAudit(jgdmSave, user, submitType, ywlx);
            String promptName = "";
            if ("3".equals(submitType)) {
                promptName = "ע��ţ����������Ƿ�����ظ�";
            }
            if ("1".equals(submitType)) {
                promptName = "���������Ƿ�����ظ�";
            }
            if ("2".equals(submitType)) {
                promptName = "ע����Ƿ�����ظ�";
            }
            if (urRsult == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ���У�Բ�����";
            }
            if (urRsult == 0) {
                resultMsg = promptName + "������ʧ�ܣ�";
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
                resultMsg = "�������ƣ�" + jgmc + "����֪ͨ���޸ĳɹ�!";
                 /*ywlcBus.updateYwlcById(String.valueOf(jgdmSave.getId()),jgdm,jgdmSave.getJgmc(),"5","Ԥ�����޸�","1",jgdmSave.getBzjgdm());*/
                
            } else {
                resultMsg = "failure";
            }
        }
        return this.SUCCESS;
    }

    public String update() {
        User user = (User) session.get("sysUser");

        //�޸�ǰȥɾ����˱�����˵ǼǱ��Ӧ������
        //formTYpe 0 ��ͨ�����1 �������Ÿ���
        if ("0".equals(formType)) {
            ywlx = "07,13";
        }
        if ("1".equals(formType)) {
            ywlx = "11";
        }
        if ("2".equals(formType)) {
            ywlx = "15";
        }
        //��ͨ����˵��޸�ֱ�Ӵ�ҳ���϶�ȡ���ݣ�ͨ����˵��޸���Ҫ��t_sp�������ȡ����
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
        //ɾ����˱���ڵ�����
        tSpBus.delSptempData(jgdmSave, ywlx);
        //�ж��ظ�
        /*if (isRepeat(request, (jgdm == null || "".equals(jgdm)) ? id : jgdm,"update")) return "repeat";*/
        jgdmSave.setLry(user.getUserName());
        jgmc = jgdmSave.getJgmc();
        currentPath = "/product/jsp/certificate/updatePrompt.jsp";
        source = "list";
        //�����Ҫ������ˣ���������ύ
        if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            //�����Ԥ������£��ȱ����û���д����Ϣ,�ڷ�������
            if ("2".equals(formType)) {
                saveBus.updateTjgdmSave(jgdmSave);
            }
            int result = tSpBus.sendSaveAudit(jgdmSave, user, submitType, ywlx,jglx);
            String promptName = "";

            if ("3".equals(submitType)) {
                promptName = "ע��ţ����������Ƿ�����ظ�";
            }
            if ("1".equals(submitType)) {
                promptName = "���������Ƿ�����ظ�";
            }
            if ("2".equals(submitType)) {
                promptName = "ע����Ƿ�����ظ�";
            }
            if (result == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ���У�Բ�����";
            }
            if (result == 0) {
                resultMsg = promptName + "������ʧ�ܣ�";
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
            resultMsg = "�������ƣ�" + jgmc + "�޸ĳɹ�!";
           
           
        } else {
            resultMsg = "ϵͳ��æ!���Ժ�����!";
        }
        return result;
    }

    /**
     * ������޸�
     * ����������ύ�����޸�t_jgdm��ֻ�ܲ��뵽t_sptemp����
     *
     * @return
     */
    public String updateJgdm() {
        User user = (User) session.get("sysUser");
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            boolean flag = false;
            //��ͨ����˵��޸�ֱ�Ӵ�ҳ���϶�ȡ���ݣ�ͨ����˵��޸���Ҫ��t_sp�������ȡ����
            if (audit && !needAudit) {
                tjgdm = jgdmBus.findById(tyshxydm);
                TSpdmtemp spdm = null;
                spdm = new TSpdmtempBus().getSpdm(tyshxydm, "16");
                //�ж��û��Ƿ���ķ�����ʶ������ ,���ķ���true
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
            //lvwei 20180103 �ϱ��ֶ�
            tjgdm.setDflag(0);
            tjgdm.setYwlx("��Ϣ�޸�");
            //�޸�ǰȥɾ����˱�����˵ǼǱ��Ӧ������
            tSpBus.delSptempTjgdmData(tjgdm.getTyshxydm(), "16");
            //�����Ҫ������ˣ���������ύ
            if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
                int result = tSpBus.sendAudit(tjgdm, user, submitType);
                String promptName = "";
                if ("3".equals(submitType)) {
                    promptName = "ע��ţ����������Ƿ�����ظ�";
                }
                if ("1".equals(submitType)) {
                    promptName = "���������Ƿ�����ظ�";
                }
                if ("2".equals(submitType)) {
                    promptName = "ע����Ƿ�����ظ�";
                }
                if (result == 1) {
                    nameType = "revisionForbidden";
                    resultMsg = promptName + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ�������������";
                }
                if (result == 0) {
                    resultMsg = promptName + "������ʧ�ܣ�";
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
                    resultMsg = "�����ͳһ���룺��" + tjgdm.getTyshxydm() + "���޸ĳɹ�";
                    source = "/bsweb/certificate_operList.action?pageno=" + pageno + "&rowNumsView=" + rowNumsView+"&jglx="+jglx;
                    currentPath = "/product/jsp/certificate/certSuccess.jsp";
                    //TYwlc ywlc = ywlcBus.findByJgdm(jgdm);
                    //ywlcBus.updateYwlc(jgdm,tjgdm.getJgmc(),String.valueOf(ywlc.getYwlclx()),"������޸�","1",tjgdm.getBzjgdm());
                    //����û��޸��˻������ƣ�ͬ������
                    /*if(codeNameRepeat&&!clsStringTool.isEmpty(ywlsh)){
                        ywlcBus.updateYwlcLog(ywlsh,tjgdm.getJgmc());
                    }*/
                } else {
                    resultMsg = "ϵͳ��æ!���Ժ�����!";
                }
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
        }
        return this.SUCCESS;
    }

    /**
     * ǿ���޸�
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
                resultMsg = "ǿ���޸�ͳһ���루" + tjgdm.getTyshxydm() + "���ɹ�";
                if ("1".equals(type)) {
                    currentPath = "/product/jsp/certificate/forceUpdateNoZsSuccess.jsp";
                } else {
                    currentPath = "/product/jsp/certificate/forceUpdateSuccess.jsp";
                }

            } else {
                resultMsg = "ϵͳ��æ!���Ժ�����!";
            }
        } catch (Exception e) {
            log.error(IssueCertificateAction.class, e);
        }
        return this.SUCCESS;
    }


    /**
     * ǿ���޸�ҳ��
     *
     * @return
     */
    public String forceUpdatePage() {
        tjgdm = jgdmBus.findById(jgdm);
       
        //listFzr= saveBus.fzrList(jgdm);
        if (tjgdm == null) {
            currentPath = "/product/jsp/certificate/forceUpdate.jsp";
            resultMsg = "ͳһ������루" + jgdm + "������������ʽ���У�������ǿ���޸ģ�";
            return this.SUCCESS;
        }
        tfddbr= saveBus.fddbrList(tjgdm.getTyshxydm());
        frjl=saveBus.getFrjl(tfddbr.getLsh());
        User user = (User) session.get("sysUser");
//        if (!(user.getUserName().contains("admin") || tjgdm.getBzjgdm().equals(user.getBzjgdm()))) {
        if (false) {
            currentPath = "/product/jsp/certificate/forceUpdate.jsp";
            resultMsg = "�������루" + jgdm + "�������ڱ���֤�������������޸ĵ�ǰ�������룡";
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
     * ǿ���޸�ҳ��
     *
     * @return
     */
    public String forceUpdatePageNoZs() {
        tjgdm = jgdmBus.findById(jgdm);
        if (tjgdm == null) {
            currentPath = "/product/jsp/certificate/forceUpdateNoZs.jsp";
            resultMsg = "�������루" + jgdm + "������������ʽ���У�������ǿ���޸ģ�";
            return this.SUCCESS;
        }
        User user = (User) session.get("sysUser");
        if (!(user.getUserName().contains("admin") || tjgdm.getBzjgdm().equals(user.getBzjgdm()))) {
            currentPath = "/product/jsp/certificate/forceUpdateNoZs.jsp";
            resultMsg = "�������루" + jgdm + "�������ڱ���֤�������������޸ĵ�ǰ�������룡";
            return this.SUCCESS;
        }
       /* if (!"1".equals(tjgdm.getDybz())) {
            currentPath = "/product/jsp/certificate/forceUpdateNoZs.jsp";
            resultMsg = "�������루" + jgdm + "����δ��ӡ֤�飬��ʹ��������޸Ĺ����޸ģ�";
            return this.SUCCESS;
        }*/
        currentPath = "/product/jsp/certificate/forceUpdateJgdmNoZs.jsp";
        return this.SUCCESS;
    }

    /**
     * ��֤����
     *
     * @return
     */
   public String certChange() {
        currentPath = "/product/jsp/certificate/certChangeInfo.jsp";
        User user = (User) session.get("sysUser");
        HttpServletRequest request = ServletActionContext.getRequest();
        int result = 0;
        tjgdm = jgdmBus.findById(tyshxydm);
      //������Ա��Ϣ
        saveBus.AddTjgdmFzr(fzr, tyshxydm);
        
       /* String strFkbzOld = tjgdm.getFkbz();
        Integer strFkslOld = tjgdm.getFksl();*/
        //�����Ҫ������ˣ���������ύ
     /*   if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
            currentPath = "/product/jsp/certificate/certSend.jsp";
            ywlx = "02";
            getJGdmDate(request, tjgdm);
            this.bindingForm2Bean(tjgdm, request.getParameterMap());
            int urRsult = new TSpBus().sendCertAudit(tjgdm, user, submitType);
            String promptName = "";
            if ("3".equals(submitType)) {
                promptName = "ע��ţ����������Ƿ�����ظ�";
            }
            if ("1".equals(submitType)) {
                promptName = "���������Ƿ�����ظ�";
            }
            if ("2".equals(submitType)) {
                promptName = "ע����Ƿ�����ظ�";
            }
            if (urRsult == 1) {
                nameType = "revisionForbidden";
                resultMsg = promptName + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ��л�֤������";
            }
            if (urRsult == 0) {
                resultMsg = promptName + "������ʧ�ܣ�";
            }
        } *///else {
            //��ͨ����˵Ļ�ֱ֤�Ӵ�ҳ���϶�ȡ���ݣ�ͨ����˵Ļ�֤��Ҫ��t_sp�������ȡ����
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
                log.error("������ҵ���ճ���");
                resultMsg = "����ľ�����ҵ������������У��������";
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
                resultMsg = "����(ͳһ������룺" + tyshxydm + ")��֤�ɹ�!���֤!";
             
               // ywlcBus.updateYwlc2(jgdm, tjgdm.getJgmc(), "��֤", "1",user.getUserName());
                //��֤�ɹ���ɾ����˱�����˵ǼǱ��Ӧ������
                //tSpBus.delSptempTjgdmData(tjgdm.getJgdm(), "02");
            } else {
                resultMsg = "��֤ʧ�ܣ�������!";
//                ?eturn this.ERROR;
            }
        //}

        //������״̬
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
                    resultMsg = "��������(" + jgdm + ")֤��(" + strAlldjh + ")ԤԼ��ʧ���,ȷ�Ϲ�ʧ��ſ��Դ�ӡ��ʧ֤�飡";
                } else {
                    resultMsg = "д֤��ԤԼ��ʧ��Ϣʱ����!";
                }
            }
            if ("qxgs".equals(source)) {
                result = new TZsBus().cancelCertLost(djhs, jgdm, user);
                if (result == 1) {
                    resultMsg = "��������(" + jgdm + ")֤��(" + strAlldjh + ")ȡ��ԤԼ��ʧ���,ȡ��ԤԼ��ʧ��֤����Լ���ʹ�ã�";
                } else {
                    resultMsg = "дȡ��֤��ԤԼ��ʧ��Ϣʱ����!";
                }
            }
            if ("qrgs".equals(source)) {
                String gsyj = request.getParameter("gsyj");
                String gsreason = request.getParameter("gsreason");
                String zfrq = request.getParameter("zfrq");
                result = new TZsBus().confirmCertLost(djhs, jgdm, user, gsyj, gsreason, zfrq);
                if (result == 1) {
                    resultMsg = "��������(" + jgdm + ")֤��(" + strAlldjh + ")��ʧ���,ԭ֤�齫�޷�ʹ��!";
                } else {
                    resultMsg = "д֤��ȷ�Ϲ�ʧ��Ϣʱ����!";
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
                //�����˱�
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
            resultMsg = jgmc + "ɾ���ɹ�!";
            //�����˱�����û���������˲�ͨ������
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
            //�����Ǽ�ɾ��
            if ("0".equals(formType)) {
                ywlcBus.delYwlcData(id);
            }
            //�������Ÿ���ɾ��
            if ("1".equals(formType)) {
                ywlcBus.updateYwlcById(id, save.getJgdm(), save.getJgmc(), "4", "���Ÿ���ɾ��", "2", save.getBzjgdm());
            }
            //Ԥ����ɾ��
            if ("2".equals(formType)) {
                ywlcBus.updateYwlcById(id, save.getJgdm(), save.getJgmc(), "3", "Ԥ����ɾ��", "2", save.getBzjgdm());
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
         * 0ʧ�ܣ�1�ɹ�
         *//*
        String str = (String)serviceClient.invokeBlocking(opAddEntry,new Object[]{tjgdm.getBak3(),tjgdm.getZch(),tjgdm.getJgdm()},  
        		new Class[]{String.class,String.class,String.class})[0];

        if(str.equals("0")){
        	System.out.println(jgdm+"++++++++++++++++++�ֶ��ش���������ʧ��!");
        	resultMsg=jgdm+"+�ֶ��ش���������ʧ��!";
        }
        if(str.equals("1")){
        	System.out.println(jgdm+"++++++++++++++++++�ֶ��ش���������ɹ�!");
        	resultMsg=jgdm+"+�ֶ��ش���������ʧ��!";
        }
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println(jgdm+"++++++++++++++++++�ֶ��ش��������뱨��:"+e);
        	resultMsg=jgdm+"+�ֶ��ش���������ʧ��!";
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
                //���ع��̽ӿ� 
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
                 * 0ʧ�ܣ�1�ɹ�
                 *//*
                String str = (String)serviceClient.invokeBlocking(opAddEntry,new Object[]{dm.getJgmc(),dm.getZch(),dm.getJgdm()},  
                		new Class[]{String.class,String.class,String.class})[0];

                if(str.equals("0"))System.out.println(jgdm+"++++++++++++++++++�ش���������ʧ��!");
                if(str.equals("1"))System.out.println(jgdm+"++++++++++++++++++�ش���������ɹ�!");
                }catch (Exception e) {
					// TODO: handle exception
                	System.out.println(jgdm+"++++++++++++++++++�ش��������뱨��:"+e);
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
                	lshmsg=",ҵ����ˮ���ѹ���Ϊ:"+jgdmSave.getBak3();
                }*/
                resultMsg = jgdmSave.getJgmc() + "У�Ը���ɹ�!ͳһ������" + jgdm+lshmsg;
               
                //            }
                jgmc=jgdmSave.getJgmc();
                
                saveBus.upFzr(id, jgdm);
                /*
                if ("0".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "1", "У�Ը���", "1", jgdmSave.getBzjgdm());
                }
                if ("1".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "4", "У��", "1", jgdmSave.getBzjgdm());
                }
                if ("2".equals(formType)) {
                    ywlcBus.updateYwlcByYwlsh(ywlsh, jgdm, jgmc, "3", "У��", "1", jgdmSave.getBzjgdm());
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
    
    
    
    
    
    
   /*����δ�޸�  createByZsl 2016-12-7
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
                //���ع��̽ӿ� 
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
                 * 0ʧ�ܣ�1�ɹ�
                 *//*
                String str = (String)serviceClient.invokeBlocking(opAddEntry,new Object[]{dm.getJgmc(),dm.getZch(),dm.getJgdm()},  
                		new Class[]{String.class,String.class,String.class})[0];

                if(str.equals("0"))System.out.println(jgdm+"++++++++++++++++++�ش���������ʧ��!");
                if(str.equals("1"))System.out.println(jgdm+"++++++++++++++++++�ش���������ɹ�!");
                }catch (Exception e) {
					// TODO: handle exception
                	System.out.println(jgdm+"++++++++++++++++++�ش��������뱨��:"+e);
				}
                }
  //////////////////////////////////////////////////////////////
                
                
                String djh = wsbzBus.findWsywDjh(jgdmSave.getJgmc(), "0");
                if (djh != null)
                    wsbzBus.updateXb(djh, "3", "0", dm);
                wsbzBus.delWsywByjgmc(jgdmSave.getJgmc(), "0");
                String lshmsg="";
                if(jgdmSave.getBak3()!=null&&jgdmSave.getBak3().length()>15){
                	lshmsg=",ҵ����ˮ���ѹ���Ϊ:"+jgdmSave.getBak3();
                }
                resultMsg = jgdmSave.getJgmc() + "У�Ը���ɹ�!ͳһ������" + jgdm+lshmsg;
               
                //            }
                jgmc=jgdmSave.getJgmc();
                
                saveBus.upFzr(id, jgdm);
                
                if ("0".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "1", "У�Ը���", "1", jgdmSave.getBzjgdm());
                }
                if ("1".equals(formType)) {
                    ywlcBus.updateYwlcById(id, jgdm, jgmc, "4", "У��", "1", jgdmSave.getBzjgdm());
                }
                if ("2".equals(formType)) {
                    ywlcBus.updateYwlcByYwlsh(ywlsh, jgdm, jgmc, "3", "У��", "1", jgdmSave.getBzjgdm());
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
    			resultMsg = jgdmSave.getJgmc() + "У�Ը���ɹ�!����������(" + jgdm+")";
    			
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
        //�ж��û��Ƿ���ķ�����ʶ������ ,���ķ���true
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
        //����ǼǱ�0��Ԥ����2���������Ÿ���1
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
            //��������
            String codeName = jgdmSave.getJgmc();
            String zch = jgdmSave.getZch();
            String jglx = request.getParameter("jglx");
            //���typeΪadd����������Ҫ�ж��ظ�;�����Ǹ�����Ҫ�����û��Ƿ��޸Ļ��������ע����ж��Ƿ���Ҫ�ж��ظ�
            if ("add".equals(type)) {
                //�������Ʋ���
                String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                if (!"".equals(retVal)) {
                    resultMsg = "codeRepeat";
                    sourceTable = retVal.split(":")[1];
                    return true;
                }
                //ע��Ų���
                String retValue = saveBus.isExistZch(zch, codeId, jglx, formType);
                if (!"".equals(retValue)) {
                    resultMsg = "zchRepeat";
                    sourceTable = retValue.split(":")[1];
                    return true;
                }
                //ע�������
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
                //�������Ʋ���
                //����û�����Ļ���������ҳ������Ļ���������ͬ ����Ҫ�ж��ظ�
                if (!codeName.equals(dcodeName)) {
                    codeNameRepeat = true;
                    String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                    if (!"".equals(retVal)) {
                        resultMsg = "codeRepeat";
                        sourceTable = retVal.split(":")[1];
                        return true;
                    }
                }
                //ע��Ų���
                //����û������ע�����ҳ�������ע�����ͬ ����Ҫ�ж��ظ�
                if (!zch.equals(dzch)) {
                    String retValue = saveBus.isExistZch(zch, codeId, jglx, formType);
                    if (!"".equals(retValue)) {
                        resultMsg = "zchRepeat";
                        sourceTable = retValue.split(":")[1];
                        return true;
                    }
                }
                //ע�������
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
            //��������
            String codeName = tjgdm.getJgmc();
            String zch = tjgdm.getZch();
            String jglx = request.getParameter("jglx");
            //���typeΪadd����������Ҫ�ж��ظ�;�����Ǹ�����Ҫ�����û��Ƿ��޸Ļ��������ע����ж��Ƿ���Ҫ�ж��ظ�
            if ("add".equals(type)) {
                //�������Ʋ���
                String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                if (!"".equals(retVal)) {
                    sourceTable = retVal.split(":")[1];
                    resultMsg = "codeRepeat";
                    return true;
                }
                //ע��Ų���
                String retValue = saveBus.isExistZch(zch, codeId, jglx, "");
                if (!"".equals(retValue)) {
                    resultMsg = "zchRepeat";
                    sourceTable = retValue.split(":")[1];
                    return true;
                }
                //ע�������
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
                //�������Ʋ���
                //����û�����Ļ���������ҳ������Ļ���������ͬ ����Ҫ�ж��ظ�
                if (!codeName.equals(dcodeName)) {
                    codeNameRepeat = true;
                    String retVal = saveBus.isExistCodeName(codeName, codeId, "");
                    if (!"".equals(retVal)) {
                        sourceTable = retVal.split(":")[1];
                        resultMsg = "codeRepeat";
                        return true;
                    }
                }
                //ע��Ų���
                //����û������ע�����ҳ�������ע�����ͬ ����Ҫ�ж��ظ�
                if (!zch.equals(dzch)) {
                    String retValue = saveBus.isExistZch(zch, codeId, jglx, "");
                    if (!"".equals(retValue)) {
                        resultMsg = "zchRepeat";
                        sourceTable = retValue.split(":")[1];
                        return true;
                    }
                }
                //ע�������
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
     * ������޸ģ�ɾ��,��֤����
     *
     * @return
     */
    public String search() {
        //�Ѿ��ǼǵĻ���������Ϣ�� ����t_jgdm��
        formType = "4";
        //������޸�
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
                    resultMsg = "�������루" + jgdm + "��֤���Ѿ���ӡ��������������޸ģ�";
                    return SUCCESS;
                }*/
            }
        }
        //�����ɾ��
        if ("delete".equals(source)) {
            type = "1";//ɾ������
            currentPath = "/product/jsp/certificate/viewPage.jsp";
            if (InitSysParams.system.getSqbscsh() != null && InitSysParams.system.getSqbscsh()) {
                delMessage = tSpBus.getDelMessage(jgdm);
            } else
                delMessage = "1";
            tjgdm = jgdmBus.findJgdmByCondition(source, jgdm, bzjgdm);
            tjgdm = jgdmBus.findById(tyshxydm);
            /*if (!"0".equals(tjgdm.getDybz()) && "1".equals(tjgdm.getDjblx())) {
                currentPath = "/product/jsp/certificate/certSearch.jsp";
                resultMsg = "�������루" + jgdm + "��֤���Ѿ���ӡ�������������ɾ����";
                return SUCCESS;
            }*/
        }
        //��֤����
        if ("certChange".equals(source)) {
            //�ж��Ƿ񴦷������������ת������ҳ��
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
            //�����Ҫ������˻���ϵͳ���û�֤��� �鿴��˽��
           /* if (tsp != null) {
                String returnValue = tSpBus.checkforAudia(jgdm, "02");
                int i = returnValue.indexOf(":");
                String flag = returnValue.substring(0, i);
                //����ֵ״̬ flag = 1 �������󣬵ȴ���ˣ�
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
                //����ֵ״̬ flag = 2 �����ͨ����
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
                //����ֵ״̬ flag = 3 ����˲�ͨ����
                if ("3".equals(flag)) {
                    //���ҵ������Ϊ��֤����,����û�п�����֤���ҵ�������ԭ����,ҳ�治��Ҫ�������ύ�������
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
                //����ֵ״̬ flag = 4 ��Ҫ��������
                if ("4".equals(flag)) {
                    needAudit = true;
                    audit = false;
                    repeatAudit = false;
                    tjgdm = jgdmBus.findById(jgdm);
                    if (!"1".equals(tjgdm.getDybz())) {
                        currentPath = "/product/jsp/certificate/certSearch.jsp";
                        resultMsg = "�������루" + jgdm + "��֤�黹δ��ӡ֤�飬��������֤����";
                        return SUCCESS;
                    }
                }
                //����Ѿ���� ��ȡ��˽�����������
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
                        resultMsg = "�������루" + jgdm + "��֤�黹δ��ӡ֤�飬��������֤����";
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
            resultMsg = "��ѯ�ļ�¼������!";
            return this.SUCCESS;
        }
        //�����������޸ģ�������Ҫ������˲�ͨ������Ҫ����˱��е�������


        //�������ݵ���----------------------------
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
     * �����ɾ���б��ѯ
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
        //�ж��Ƿ���ҵ������
        if (isYwlc) {
            currentPath = "/product/jsp/certificate/delApplyYwlcList.jsp";
            if (needAudit) {
                ywlcDelList = ywlcBus.listDelAuditYwlc(user, "'У�Ը���','������޸�','У��'", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            } else {
                ywlcDelList = ywlcBus.listDelYwlc(user, "'У�Ը���','������޸�','У��'", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            }
        } else {
            //�ж��Ƿ���Ҫ��ˣ������Ҫ�����Ҫ����˱������ѯ���״̬������Ҫ���ֱ�Ӳ�ѯ����
            if (needAudit) {
                vList = saveBus.delApplyListTjgdmSaveAudit(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            } else {
                vList = saveBus.delApplyListTjgdmSave(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
            }
        }
        return this.SUCCESS;
    }

    /**
     * �������Ÿ���ɾ����Ԥ����ɾ���б��ѯ
     *
     * @return
     */
    public String delSaveList() {
        User user = (User) session.get("sysUser");
        currentPath = "/product/jsp/certificate/delList.jsp";
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        //�������Ÿ���
        if ("1".equals(delType)) {
            params.put("djblx", "1");
            needAudit = InitSysParams.system.getQtbmfmsh() != null && InitSysParams.system.getQtbmfmsh();
            ywlx = "08";
        }
        //Ԥ����
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
        //�ж��Ƿ���Ҫ��ˣ������Ҫ�����Ҫ����˱������ѯ���״̬������Ҫ���ֱ�Ӳ�ѯ����
        if (needAudit) {
            vList = saveBus.delListTjgdmSaveAudit(user, params, ywlx, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        } else {
            vList = saveBus.delListTjgdmSave(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        }

        return this.SUCCESS;
    }

    /**
     * ��֤�ύ����
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
            String text = "��֤";
            //��ͨ����˵��ύ������� ֱ�Ӵ�ҳ���϶�ȡ���ݣ�ͨ����˵���Ҫ��t_sp�������ȡ����
            if (audit && !needAudit) {
                TSpdmtemp spdm = null;
                //������ˣ���֤��˲��棬���������Ϊ��
                if (!clsStringTool.isEmpty(submitType) && !"0".equals(submitType)) {
                    text = "����";
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
                resultMsg = "��������(" + jgdm + ")��" + text + "�����Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Խ��л�֤������";
            }
            if (result == 0) {
                resultMsg = "��������(" + jgdm + ")" + text + "������ʧ�ܣ�";
            }

            //����ҵ���ʶ
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
     * �����ɾ���������
     *
     * @return
     */
    public String send() {
        currentPath = "/product/jsp/certificate/delPromptInfo.jsp";
        User user = (User) session.get("sysUser");
        HttpServletRequest request = ServletActionContext.getRequest();
        String reason = request.getParameter("reason");
        String yw = request.getParameter("formType");
        //ɾ��������������ڴ�������������˲�ͨ���ļ�¼
        tSpBus.delAuditNOPass(jgdm);
        int result = new TSpBus().sendDelRequest(jgdm, reason, user, yw);
        if (result == 2) {
            resultMsg = "��������(" + jgdm + ")�Ѿ���ʡ���ķ���������,�벻Ҫ���·������룡";
        }
        if (result == 1) {
            resultMsg = "ɾ����������(" + jgdm + ")�������Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ���ɾ���˴��룡";
        }
        if (result == 0) {
            resultMsg = "��������(" + jgdm + ")ɾ�����뷢��ʧ�ܣ�";
        }
        return this.SUCCESS;
    }

    public String deleteApplyForm() {
        currentPath = "/product/jsp/certificate/promptInfo.jsp";
        User user = (User) session.get("sysUser");
        String result = new TSpBus().delApplyForm(jgdm, user);

        if ("1".equals(result)) {
            resultMsg = "��������(" + jgdm + ")ɾ���ɹ������һ��ճɹ�!��������!";
            
            tSpBus.delSptempTjgdmData(jgdm, "00");
        } else if ("0".equals(result)) {
            resultMsg = "��������(" + jgdm + ")�����ɾ��ʧ�ܣ�";
        } else if ("2".equals(result)) {
            resultMsg = "Ҫ�ָ��Ļ������벻����!";
        } else if (result.contains("3")) {
            resultMsg = "�������Ĵ���ɾ������" + result.split(":")[1] + "��������!";
        }
        return this.SUCCESS;
    }

    public String list() {
        //�Ƿ���ҵ������
        String ywlclx = "";
        String type = "'����'";
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
            //Ԥ����
            if ("2".equals(formType)) {
                currentPath = "/product/jsp/certificate/entCertList.jsp";
            }
            list = saveBus.listTjgdmSave(user, formType, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod,jglx);
        } else {
            currentPath = "/product/jsp/certificate/newYwlc.jsp";
            //Ԥ����
            if ("2".equals(formType)) {
                type = "'����','����'";
                currentPath = "/product/jsp/certificate/newPreYwlc.jsp";
            }
            ywlcList = ywlcBus.listNewYwlc(user, ywlclx, type, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        }
        return this.SUCCESS;
    }
   

    public String yfmList() {
        formType = "2";
        //�Ƿ���ҵ������
        isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
        String ywlclx = "'2','5'";
        String type = "'����'";
        User user = (User) session.get("sysUser");
        if (pages == null)
            pages = new clsPageComponent();
        Map<String, String> params = new HashedMap();
        if (!isYwlc) {
            //Ԥ����
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
    		    	resultMsg="û�в�������Ϣ���Ƿ������";
    		    	//formType="0";
    		    }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return this.SUCCESS;
    }
    public String operList() {
        //�Ƿ���ҵ������
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
            ywlcList = ywlcBus.listYwlc(user, "'У�Ը���','У��','������޸�'", params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod);
        } else {
            tjgdmList = jgdmBus.listTjgdm(user, params, pageno, rowNumsView, pages, orderbyColum, orderbyMethod,jglx,tyshxydm);
        }
        return this.SUCCESS;
    }

    public String certOperList() {
        //�Ƿ���ҵ������
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
        //�����������޸ģ�������Ҫ������˲�ͨ������Ҫ����˱��е�������
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
        //�����������޸ģ�������Ҫ������˲�ͨ������Ҫ����˱��е�������
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
        //bs��
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
        //bs��
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
     * ��ѯ�����������б�
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
     * ��ѯ֤�������б�
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
     * ��ѯ֤�������б�
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
     * ��ѯ֤�������б�
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
     * ��ѯ���������б�
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
     * �����б�
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
     * ��ѯע����б�
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
     * ��form�����ֵ�����󣬿ɽ�ʡװ�����Ե�ʱ�䣬����ע�⣬�˷���ֻװ��form�и����ֶ�name[0]��value��������һ�����������name���ȴ���1�������Լ�д����
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
