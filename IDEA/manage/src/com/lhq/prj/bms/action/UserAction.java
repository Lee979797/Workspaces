package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.core.SpringMail;
import com.lhq.prj.bms.dao.IDutyDao;
import com.lhq.prj.bms.dao.IFuncDao;
import com.lhq.prj.bms.dao.IQxDao;
import com.lhq.prj.bms.po.Duty;
import com.lhq.prj.bms.po.Qx;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.service.IUserService;
import com.opensymphony.xwork2.ActionContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * UserAction.java Create on 2013-4-19 17:38:39
 * <p>
 * 系统用户
 * <p>
 * Copyright (c) 2012 by YQ.
 *
 * @author yangqi
 * @version 1.0
 */
@SuppressWarnings("serial")
public class UserAction extends BaseAction {

    public static final String SUCCESS_MANAGER = "success_manager";

    private IUserService userService;

    private IQxDao qxDao;

    private IDutyDao dutyDao;

    private IFuncDao funcDao;

    private User user;

    private boolean success;

    private Page page;

    private Integer userId;

    private String userName;

    private String password;

    private String userPwdOld;

    private boolean manager;

    private String mobilePhone;

    private String sex;

    private Integer useUpPageSize;

    private Integer useDownPageSize;

    private Integer useFullPageSize;

    private Object novString;

    private String tip;

    private Map appSysConfig;

    private String qxCode;

    private String ywqx;

    public String logout() {
        getSession().removeAttribute("user");
        success = true;
        return SUCCESS;
    }

    public String login() {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        User _user = userService.login(user);

        if (_user != null) {
            appSysConfig = ActionContext.getContext().getApplication();
            String strSysXcWorkMode = appSysConfig.get("sysXcWorkMode").toString();
            if (strSysXcWorkMode.equals("1")) {
                //现场办证审核，用session保存
                Qx qx = new Qx();
                qx.setBzjgCode(_user.getBzjgCode());
                List ywxcList = qxDao.findByBzjgCode(qx);
                getSession().setAttribute("ywxcList", ywxcList);
            }

            //用户功能权限start
            String strDutyCondition = _user.getDutyName();
            if (strDutyCondition != "" && !"".equals(strDutyCondition)) {
                List dutyConditions = new ArrayList();
                MyUtils.addToCollection(dutyConditions, MyUtils.split(strDutyCondition, ","));
                page = new Page();
                page.setDutyConditions(dutyConditions);
                String strFuncCodeList = "";
                String strPfuncCodeList = "";
                String strPfuncCodeList2 = "";
                //start,p_zzUserPwdSet, p_user,p_zzDuty,p_zzWorkOrder, p_zzArchives,p_zzWorkShenhe, p_zzWorkQuery,p_zzArchivesTo,p_zzArchivesDo, p_zzLicensePrint,p_zzLicensePrintFuben,p_zzLicensePrintTeshu,p_zzRegisterManage,p_zzLicenseLog,p_zzLicenseArchive,p_dfileQueryAll,p_dfileManage,p_dfileQuery,p_dfileArchiveManage,p_dfileQueryArchive,p_zzDictIndex,p_zzDictDetail,p_zzXzqhManage,p_zzBzjgallManage,p_zzPzjgManage,p_zzSysConfigManage,p_zzCenter,p_zzBzjg,p_zzJglxManage,p_zzJjlxManage,p_zzHylxManage,p_zzYwnetSet,p_zzYwxcSet,p_zzArchiveScan,p_zzXinban,p_zzNianjian,p_zzBiangen,p_zzHuanzheng,p_zzBuzheng,p_zzQianru,p_zzYufuma,p_zzQianchu,p_zzFeizhi,p_zzPiliangfeizhi,p_zzGoDfile,p_zzFeizhiHuifu,p_zzFeizhiHuifuManage,p_zzJggzSq,p_zzJggzManage,p_zzOrgPrtSqd,p_zzOrgPrtQzd,p_zzOrgPrtZxd,p_zzOrgPrtYfm,p_zzCardNJ,p_zzCardPrintSet,p_zzCardRead,p_zzCardWrite,p_zzDCardPrint,p_zzCardPrintLog,p_zzCardPrint,p_zzQXSet,p_zzZsscManage,p_zzTsfmManage,p_zzDataModify
                List dutyList = dutyDao.findByDutyName(page);
                for (int k = 0; k < dutyList.size(); k++) {
                    Duty duty = (Duty) dutyList.get(k);
                    String strFuncCode = duty.getFuncCode();
                    String funcCodeList[] = strFuncCode.split(",");
                    for (int i = 0; i < funcCodeList.length; i++) {
                        String nodeFuncCode = "|" + funcCodeList[i] + "|";
                        String nodePfuncCode = "";
                        String nodeFuncCode2 = "";
                        if (nodeFuncCode.equals("|zzCard|") || nodeFuncCode.equals("|zzYwset|") || nodeFuncCode.equals("|zzDict|") || nodeFuncCode.equals("|zzCenterManage|")) {
                            if (nodeFuncCode.equals("|zzCard|")) {
                                nodePfuncCode = "|p_zzCardAudit||p_zzCardRead||p_zzCardWrite||p_zzDCardPrint||p_zzCardPrint||p_zzCardPrintLog||p_zzCardPrintSet|";
                                nodeFuncCode2 = "|zzCardAudit||zzCardRead||zzCardWrite||zzDCardPrint||zzCardPrint||zzCardPrintLog||zzCardPrintSet|";
                                //nodePfuncCode="|p_zzCardAudit||p_zzCardRead||p_zzCardWrite||p_zzCardPrint||p_zzCardPrintLog||p_zzCardPrintSet|";
                                //nodeFuncCode2="|zzCardAudit||zzCardRead||zzCardWrite||zzCardPrint||zzCardPrintLog||zzCardPrintSet|";
                            }
                            if (nodeFuncCode.equals("|zzYwset|")) {
                                nodePfuncCode = "|p_zzYwnetSet||p_zzQXSet|";
                                nodeFuncCode2 = "|zzYwnetSet||zzQXSet|";
                            }
                            if (nodeFuncCode.equals("|zzDict|")) {
                                nodePfuncCode = "|p_zzDictIndex||p_zzDictDetail|";
                                nodeFuncCode2 = "|zzDictIndex||zzDictDetail|";
                            }
                            if (nodeFuncCode.equals("|zzCenterManage|")) {
                                nodePfuncCode = "|p_zzCenter||p_zzBzjg||p_zzBzjgallManage|";
                                nodeFuncCode2 = "|zzCenter||zzBzjg||zzBzjgallManage|";
                            }
                        } else {
                            nodePfuncCode = "|p_" + funcCodeList[i] + "|";//加上"P_"
                            nodeFuncCode2 = "|" + funcCodeList[i] + "|";
                        }

                        if (!MyUtils.isContainsAny(strFuncCodeList, nodeFuncCode)) {
                            strFuncCodeList = strFuncCodeList + nodeFuncCode;
                            strPfuncCodeList = strPfuncCodeList + nodePfuncCode; //有"P_"
                            strPfuncCodeList2 = strPfuncCodeList2 + nodeFuncCode2; //有"P_"
                        }
                    }
                }
                strFuncCodeList = strFuncCodeList.replace("||", "|");
                strPfuncCodeList = strPfuncCodeList.replace("||", ",");//有"P_"
                strPfuncCodeList = strPfuncCodeList.replace("|", ",");//有"P_"
                strPfuncCodeList = "start" + strPfuncCodeList + "p_zzUserPwdSet,p_zzUserConfigSet";
                getSession().setAttribute("strPfunc", strPfuncCodeList);//main.js中调用

                strPfuncCodeList2 = strPfuncCodeList2.replace("||", ",");//有"P_"
                strPfuncCodeList2 = strPfuncCodeList2.replace("|", ",");//有"P_"
                strPfuncCodeList2 = strPfuncCodeList2 + "zzUserPwdSet,zzUserConfigSet";
                getSession().setAttribute("strPfunc2", strPfuncCodeList2);//manage_index.jsp中调用


                if (strFuncCodeList != "" && !"".equals(strFuncCodeList)) {
                    List funcConditions = new ArrayList();
                    MyUtils.addToCollection(funcConditions, MyUtils.split(strFuncCodeList, "|"));
                    page = new Page();
                    page.setFuncConditions(funcConditions);
                    List funcList = new ArrayList();
                    funcList = funcDao.findByFuncCode(page);
                    getSession().setAttribute("funcList", funcList);
                }
            }
            //用户功能权限end

            if (!"admin".equals(userName)) {
                //当前时间
                Calendar now = Calendar.getInstance();
                String strCurrentTime = new SimpleDateFormat("HHmm").format(now.getTime());
                Integer intCurrentTime = Integer.parseInt(strCurrentTime);
                //系统开始时间
                String strSysWorkStartime1 = appSysConfig.get("sysWorkStartime").toString();
                String strSysWorkStartimeHour = strSysWorkStartime1.substring(0, 2);
                String strSysWorkStartimeMinute = strSysWorkStartime1.substring(3, 5);
                String strSysWorkStartime2 = strSysWorkStartimeHour + strSysWorkStartimeMinute;

                //系统结束时间
                String strSysWorkEndtime1 = appSysConfig.get("sysWorkEndtime").toString();
                String strSysWorkEndtimeHour = strSysWorkEndtime1.substring(0, 2);
                String strSysWorkEndtimeMinute = strSysWorkEndtime1.substring(3, 5);
                String strSysWorkEndtime2 = strSysWorkEndtimeHour + strSysWorkEndtimeMinute;

                if (intCurrentTime > Integer.parseInt(strSysWorkStartime2) && intCurrentTime < Integer.parseInt(strSysWorkEndtime2)) {
                    if (_user.isManager() == true) {
                        this.setTip("manager");// ����Ա
                    } else {
                        this.setTip("simple");// ��ͨ�û�
                    }

                    getSession().setAttribute("user", _user);
                    return SUCCESS;
                } else {
                    this.setTip("系统已经关闭，用户不能登录!(系统开放时间" + strSysWorkStartime1 + "至" + strSysWorkEndtime1 + ")");
                    return INPUT;
                }

            } else {
                if (_user.isManager() == true) {
                    this.setTip("manager");// ����Ա
                } else {
                    this.setTip("simple");// ��ͨ�û�
                }

                getSession().setAttribute("user", _user);
                return SUCCESS;
            }
        } else {
            this.setTip("用户名或密码错误!");
            return INPUT;
        }
    }

    /**
     * ���ϵͳ�û�
     *
     * @return
     */
    public String saveUser() {
        String bzjgName = user.getBzjgName();
        String cnName = user.getEmplName();
        String userName = user.getUserName();
        String userPassword = user.getPassword();
        String userEmail = user.getEmail();
        userId = (Integer) userService.saveUser(user);

        appSysConfig = ActionContext.getContext().getApplication();
        String sysAutoMailMode = appSysConfig.get("sysAutoMailMode").toString();
        String sysAutoMailUrl = appSysConfig.get("sysAutoMailUrl").toString();
        String sysTitle = appSysConfig.get("sysAppName").toString() + "--系统用户注册成功！";

        if (userId != null) {
            if ("1".equals(sysAutoMailMode)) {
                try {
                    SpringMail SpringMail = new SpringMail();
                    SpringMail.sendMail(userEmail, sysAutoMailUrl, sysTitle, bzjgName, cnName, userName, userPassword);
                } catch (Exception e) {
                    String error = "邮件发送失败!请检查您的网络是否正常!";
                    System.out.print(error);
                }
            }
            success = true;
        }
        return SUCCESS;
    }


    /**
     * �û�ע��
     *
     * @return
     */
    public String regUser() {
        userId = (Integer) userService.regUser(user);
        if (userId != null) {
            success = true;
            return SUCCESS;
        } else {
            return INPUT;
        }
    }


    /**
     * �����û���Ϣ
     *
     * @return
     */
    public String findAllUser() {
        String strCondition = getRequest().getParameter("conditions");
        List conditions = new ArrayList();
        MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
        page = new Page();
        page.setConditions(conditions);
        int start = Integer.valueOf(getRequest().getParameter("start"));
        int limit = Integer.valueOf(getRequest().getParameter("limit"));
        page.setStart(++start);
        page.setLimit(limit = limit == 0 ? 20 : limit);
        page = userService.findByPage(page);
        return SUCCESS;
    }

    public String findUserByExample() {
        String strUsername = getRequest().getParameter("username");
        page = new Page();
        User user = new User();
        user.setUserName(strUsername);
        page.setRoot(userService.findByExample(user));
        return SUCCESS;
    }

    public String updateUserPwd() {
        userPwdOld = getRequest().getParameter("userPwdOld");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        success = userService.updatePwd(userPwdOld, user);

        return SUCCESS;
    }

    /**
     * ɾ���û�
     *
     * @return
     */
    public String deleteUser() {
        String strUserId = getRequest().getParameter("userId");
        if (strUserId != null && !"".equals(strUserId) && !"1".equals(strUserId)) {
            success = userService.deleteUser(Integer.valueOf(strUserId));
        }
        return SUCCESS;
    }

    /**
     * �޸��û���Ϣ
     *
     * @return
     * @throws Exception
     */
    public String updateUser() throws Exception {

        String strCenterId = getRequest().getParameter("centerId");
        String strCenterCode = getRequest().getParameter("centerCode");
        String strBzjgId = getRequest().getParameter("bzjgId");
        String strBzjgCode = getRequest().getParameter("bzjgCode");
        String strDutyId = getRequest().getParameter("dutyId");
        String strUserId = getRequest().getParameter("userId");
        String strManager = getRequest().getParameter("managerId");
        String strQxCode = getRequest().getParameter("qxCode");
        String strYwqx = getRequest().getParameter("ywqx");
        String fieldName = getRequest().getParameter("fieldName");
        String fieldValue = getRequest().getParameter("fieldValue");

        if (strUserId != null && !"".equals(strUserId)) {
            User user = new User();
            if ("false".equals(strManager)) {
                user.setManager(false);
            } else {
                user.setManager(true);
            }
            if ("centerName".equals(fieldName) && !"".equals(strCenterId) && !"".equals(strCenterCode)) {
                user.setCenterId(Integer.valueOf(strCenterId));
                user.setCenterCode(strCenterCode);
            }
            if ("bzjgName".equals(fieldName) && !"".equals(strBzjgId) && !"".equals(strBzjgCode)) {
                user.setBzjgId(Integer.valueOf(strBzjgId));
                user.setBzjgCode(strBzjgCode);
            }
            if ("dutyName".equals(fieldName) && !"".equals(strDutyId)) {
                user.setDutyId(strDutyId);
            }
            if ("qxCode".equals(fieldName) && !"".equals(strQxCode)) {
                user.setQxCode(strQxCode);
            }
            if ("ywqx".equals(fieldName) && !"".equals(strYwqx)) {
                user.setQxCode(strYwqx);
            }
            user.setUserId(Integer.valueOf(userId));
            MyUtils.invokeSetMethod(fieldName, user, new Object[]{fieldValue});
            success = userService.updateUser(user);
        }
        return SUCCESS;
    }

    /**
     * �޸��û���Ϣ
     *
     * @return
     * @throws Exception
     */
    public String midifyUser() throws Exception {

        String strUserName = getRequest().getParameter("userName");
        if (strUserName != null && !"".equals(strUserName)) {
            User user = new User();
            user.setUserName(strUserName);
            user.setSex(sex);
            user.setMobilePhone(mobilePhone);
            user.setUseUpPageSize(useUpPageSize);
            user.setUseDownPageSize(useDownPageSize);
            user.setUseFullPageSize(useFullPageSize);
            ;
            success = userService.midifyUser(user);
        }
        return SUCCESS;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void setQxDao(IQxDao qxDao) {
        this.qxDao = qxDao;
    }

    public void setDutyDao(IDutyDao dutyDao) {
        this.dutyDao = dutyDao;
    }

    public void setFuncDao(IFuncDao funcDao) {
        this.funcDao = funcDao;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setUseUpPageSize(Integer useUpPageSize) {
        this.useUpPageSize = useUpPageSize;
    }

    public Integer getUseUpPageSize() {
        return useUpPageSize;
    }

    public void setUseDownPageSize(Integer useDownPageSize) {
        this.useDownPageSize = useDownPageSize;
    }

    public Integer getUseDownPageSize() {
        return useDownPageSize;
    }

    public void setUseFullPageSize(Integer useFullPageSize) {
        this.useFullPageSize = useFullPageSize;
    }

    public Integer getUseFullPageSize() {
        return useFullPageSize;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setNovString(Object novString) {
        this.novString = novString;
    }

    public Object getNovString() {
        return novString;
    }

    public String getQxCode() {
        return qxCode;
    }

    public void setQxCode(String qxCode) {
        this.qxCode = qxCode;
    }

    public String getYwqx() {
        return ywqx;
    }

    public void setYwqx(String ywqx) {
        this.ywqx = ywqx;
    }

}
