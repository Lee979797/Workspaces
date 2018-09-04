package com.ninemax.jpa.system.action;

import cn.com.jit.assp.dsign.DSign;
import cn.com.jit.assp.dsign.DSignGlobalMethod;

import com.ninemax.jdbc.business.system.clsUserBus;
import com.ninemax.jdbc.business.system.clsUserRightKeyBus;
import com.ninemax.jpa.code.bus.CodePartBus;
import com.ninemax.jpa.code.dao.TSmTaskDAO;
import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.code.model.TSystem;
import com.ninemax.jpa.global.BaseAction;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.bo.SysManage_logBo;
import com.ninemax.jpa.system.bo.UserBo;
import com.ninemax.jpa.system.bo.UserGroupBo;
import com.ninemax.jpa.system.bo.UserLogin_logBo;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.system.model.UserGroup;
import com.ninemax.jpa.system.model.UserLogin_log;
import com.ninemax.jpa.util.*;
import org.apache.log4j.Logger;
import pubtool.KeyVerify;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yzhhui part login to 1,2,3
 */
public class UserAction extends BaseAction {

    private static Logger log = Logger.getLogger(UserAction.class);
    private UserBo userBo = new UserBo();
    private SysManage_logBo sysManage_logBo = new SysManage_logBo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
        String method = request.getParameter("method");
        if (method == null) {
            return;
        } else if (method.equals("add")) {
            add(request, response);
        } else if (method.equals("yzsz")) {
            yzsz(request, response);
        } else if (method.equals("modify")) {
            modify(request, response);
        } else if (method.equals("delete")) {
            delete(request, response);
        } else if (method.equals("list")) {
            list(request, response);
        } else if (method.equals("manageRole")) {
            manageRole(request, response);
        } else if (method.equals("initPassword")) {
            initPassword(request, response);
        } else if (method.equals("modPassword")) {
            modPassword(request, response);
        } else if (method.equals("login")) {
            login(request, response);
        } else if (method.equals("exit")) {
            exit(request, response);
        }
    }

    String message = "";

    private void add(HttpServletRequest request,
                     HttpServletResponse response) throws IOException {
        User user = new User();
        java.text.SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sd.format(new Date());

        HttpSession session = request.getSession();
        User ses_sysUserTO = (User) session.getAttribute("sysUser");
        Date newDate = new Date();

        //  String firstXzqh = request.getParameter("firstXzqh");
        String twoXzqh = request.getParameter("twoXzqh");
        //String threeXzqh = request.getParameter("threeXzqh");
        String db = "1";//默认始终是勾选;为勾选应该是0
        String bzjgdm = "";
        String zrxzqu = "";
        String userProvince = "";
        //  clsBzjgdmBus bzjgdmBus = new clsBzjgdmBus();
        if (!clsStringTool.isEmpty(twoXzqh)) {
            userProvince = bzjgdm;
            //zrxzqu = twoXzqh;
           // bzjgdm = twoXzqh;
        }
        this.bindingForm2Bean(user, request.getParameterMap());
        user.setLastlogin(date);
        user.setRegdate(date);
        user.setUserPassword(com.ninemax.jpa.util.clsThreeDes.encryptMode3DES(request
                .getParameter("user_password1")));

        user.setDb(db);
       // user.setZrxzqu(zrxzqu);
        user.setUserProvince(userProvince);
        user.setBzjgdm(request.getParameter("bzjgdm"));

        int intResult;
        try {
            intResult = userBo.AddRegUser(user);
            if (intResult == -1) {

                message = "existRegUser";
                this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
                return;
            } else if (intResult == 1) {

                //操作成功，写日志
                SysManage_log sysManage_log = new SysManage_log();
                sysManage_log.setOperkindId("");
                sysManage_log.setMemo("添加用户");
                sysManage_log.setOpervalue(user.getUserName());
                sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
                sysManage_log.setUsername(ses_sysUserTO.getUserName());
                sysManage_log.setOperdate(newDate);
                sysManage_logBo.save(sysManage_log);
                message = "AddRegUserSuc";
                this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
            } else {
                message = "serverbusy";
                this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
            }
        } catch (SQLException e) {
            log.error(UserAction.class, e);
        }

    }

    private void yzsz(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String user_id = request.getParameter("userId");
        Integer yqsj = Integer.valueOf(request.getParameter("yqsj").trim());
        User user = userBo.findById(Integer.valueOf(user_id));
        user.setYqsj(yqsj);
        if (userBo.update(user)) {
            message = "success";
        } else {
            message = "error";
        }

        this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
    }

    private void modify(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        User user = new User();

        this.bindingForm2Bean(user, request.getParameterMap());
        String user_id = request.getParameter("userId");

        HttpSession session = request.getSession();
        User ses_sysUserTO = (User) session.getAttribute("sysUser");
        Date newDate = new Date();
        java.text.SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sd.format(new Date());
        String twoXzqh = request.getParameter("twoXzqh");
        String db = "1";//默认始终是勾选;为勾选应该是0
        String bzjgdm = "";
        String zrxzqu = "";
        String userProvince = "";
        if (!clsStringTool.isEmpty(twoXzqh)) {
            userProvince = bzjgdm;
           // zrxzqu = twoXzqh;
           // bzjgdm = twoXzqh;
        }


        User userPss = userBo.findById(Integer.valueOf(user_id));
        user.setOffsetx(userPss.getOffsetx());
        user.setOffsety(userPss.getOffsety());
 
 //lvwei 2017-07-21  修改用户发证机关  注销下面的库中取值放入user功能      
 //       user.setPrintName(userPss.getPrintName());
        user.setUserPassword(userPss.getUserPassword());
        user.setLastlogin(clsStringTool.isEmpty(userPss.getLastlogin()) ? date : userPss.getLastlogin());
        user.setRegdate(clsStringTool.isEmpty(userPss.getRegdate()) ? date : userPss.getRegdate());

        user.setDb(db);
      //  user.setZrxzqu(zrxzqu);
        user.setUserProvince(userProvince);
       // user.setBzjgdm(bzjgdm);

        if (userBo.ModifyRegUser(user) > 0) {

            //操作成功，写日志
            SysManage_log sysManage_log = new SysManage_log();
            sysManage_log.setOperkindId("");
            sysManage_log.setMemo("修改用户");
            sysManage_log.setOpervalue(user.getUserName());
            sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
            sysManage_log.setUsername(ses_sysUserTO.getUserName());
            sysManage_log.setOperdate(newDate);

            sysManage_logBo.save(sysManage_log);

            message = "modRegUserSuc";
            this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
        } else {
            message = "serverbusy";
            this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
        }
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        String user_id = request.getParameter("user_id");
        clsUserBus userBus = new clsUserBus();

        HttpSession session = request.getSession();
        User ses_sysUserTO = (User) session.getAttribute("sysUser");
        Date newDate = new Date();

        userBus.DeleteUser(user_id);
        User user = userBus.FindUserById(user_id);
        //操作成功，写日志
        SysManage_log sysManage_log = new SysManage_log();
        sysManage_log.setOperkindId("");
        sysManage_log.setMemo("删除用户");
        sysManage_log.setOpervalue(user.getUserName());
        sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
        sysManage_log.setUsername(ses_sysUserTO.getUserName());
        sysManage_log.setOperdate(newDate);

        sysManage_logBo.save(sysManage_log);

        message = "success";
        //	this.sendRedirect(response, "/product/jsp/user/userList.jsp?msg="+message);

        response.getWriter().write(message);
        return;

    }

    private void list(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/product/jsp/user/userList.jsp").forward(request, response);

    }

    private void manageRole(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        UserGroup userGroup = new UserGroup();
        this.bindingForm2Bean(userGroup, request.getParameterMap());
        String group_id = request.getParameter("group_id");
        HttpSession session = request.getSession();
        User ses_sysUserTO = (User) session.getAttribute("sysUser");
        Date newDate = new Date();
        UserGroupBo userGroupBo = new UserGroupBo();
        String group_name = userGroupBo.findById(Integer.parseInt(group_id)).getUsergroupName();
        //操作成功，写日志
        SysManage_log sysManage_log = new SysManage_log();
        sysManage_log.setOperkindId("");
        sysManage_log.setMemo("分配角色");
        sysManage_log.setOpervalue("角色=" + group_name);
        sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
        sysManage_log.setUsername(ses_sysUserTO.getUserName());
        sysManage_log.setOperdate(newDate);
        sysManage_logBo.save(sysManage_log);
        message = "manageGroupRole";
        this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
    }


    private void initPassword(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        User user = new User();

        this.bindingForm2Bean(user, request.getParameterMap());

        String userId = request.getParameter("user_id");
        String newPassword = com.ninemax.jpa.util.clsThreeDes.encryptMode3DES(request
                .getParameter("user_password1"));

        HttpSession session = request.getSession();
        User ses_sysUserTO = (User) session.getAttribute("sysUser");
        Date newDate = new Date();

        User _user = userBo.GetRegUser(userId);
        clsUserBus userBus = new clsUserBus();
        userBus.ChanagePassword(userId, newPassword);

        //操作成功，写日志
        SysManage_log sysManage_log = new SysManage_log();
        sysManage_log.setOperkindId("");
        sysManage_log.setMemo("初始化密码");
        sysManage_log.setOpervalue(_user.getUserName());
        sysManage_log.setUserid(String.valueOf(ses_sysUserTO.getUserId()));
        sysManage_log.setUsername(ses_sysUserTO.getUserName());
        sysManage_log.setOperdate(newDate);

        sysManage_logBo.save(sysManage_log);

        message = "iniRegUserPassSuc";
        this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=" + message));
    }

    private void modPassword(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User userTO = (User) session.getAttribute("sysUser");
        String currentPage = request.getParameter("currentPage");

        String user_id = String.valueOf(userTO.getUserId());
        String user_name = userTO.getUserName();
        String oldPassword = clsThreeDes.encryptMode3DES(request.getParameter("user_oldpassword"));
        String newPassword1 = clsThreeDes.encryptMode3DES(request.getParameter("user_newpassword1"));
        int result;
        try {
            result = userBo.Login(user_name, oldPassword);
            if (result == 1) {
                clsUserBus userBus = new clsUserBus();
                userBus.ChanagePassword(user_id, newPassword1);
                response.sendRedirect(currentPage + "?message=modPasswordSuc");
            } else {
                response.sendRedirect(currentPage + "?message=oldPasswordError");
            }
        } catch (SQLException e) {
            log.error(UserAction.class, e);
        }
    }

    private synchronized void login(HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        response.addHeader("P3P", "CP=CAO PSA OUR");
        String loginType = request.getParameter("loginType");
        String sysDate = DateProcess.getSysTime();
        String sysTime = sysDate.substring(11, 16);
        HttpSession session = request.getSession();
        session.setAttribute("center", UserPropertiesData.getValueByPropertyName("center"));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String un = request.getParameter("username");
        String chooseName = request.getParameter("currentName");
        if (un == null || !un.trim().toLowerCase().contains("admin")) {
         
        	if(chooseName==null||!chooseName.trim().toLowerCase().contains("admin")){
        		try {
        			Date d1 = sdf.parse(sysTime);
        			Date d2 = sdf.parse(UserPropertiesData.getValueByPropertyName("startDate"));
        			Date d3 = sdf.parse(UserPropertiesData.getValueByPropertyName("endDate"));
        			if (d1.after(d3) || d1.before(d2)) {
        				response.sendRedirect(request.getContextPath() + "/product/CALogin2.jsp?error=justwrongtime");
        				log.info("非登录时间登录系统！");
        				return;
        			}
        		} catch (Exception e) {
        			log.error(UserAction.class, e);
        		}
        	}
        }
        if ("3".equals(loginType)) {
            login_3(request, response, session);
        } else if ("2".equals(loginType)) {
            login_2(request, response, session);
        } else if ("1".equals(loginType)) {
            login_1(request, response, session);
        }
    }

    private void login_log(HttpServletRequest request, HttpServletResponse response, User currentUser) {
        UserLogin_logBo userLogin_logBo = new UserLogin_logBo();
        UserLogin_log userLogin_log = new UserLogin_log();
        userLogin_log.setUserid(String.valueOf(currentUser.getUserId()));
        userLogin_log.setUsername(currentUser.getUserName());
        userLogin_log.setUserIp(SystemTool.getClientIp(request));
        userLogin_log.setLogindate(DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        userLogin_logBo.save(userLogin_log);
        try {
            boolean UpdateAccess = new clsUserBus().UpdateLastLogin(String.valueOf(currentUser.getUserId()));
            if (!UpdateAccess) {
                log.info("更新用户登录时间错误！");
            }
        } catch (Exception e) {
            log.info("更新登录时间失败" + e);
            log.error(UserAction.class, e);
        }
    }

    private void login_1(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        String strUsername = request.getParameter("username");
        String strPassword = request.getParameter("password");
        String currentPage = request.getParameter("currentPage");
        String goPage = request.getParameter("goPage");
            /*String strWebSite_name = "";
               if(session.getAttribute("isWebSite").equals("1")){
                   strWebSite_name = request.getParameter("website_name");
               }*/
        String validateCode_session = (String) session.getAttribute("validate_code");
        String validateCode_client = request.getParameter("ValidateCode");
        if (clsStringTool.isEmpty(strUsername)) {
            //用户名为空
            response.sendRedirect(currentPage + "?error=username");
        } else if (clsStringTool.isEmpty(strPassword)) {//密码为空
            response.sendRedirect(currentPage + "?error=password");
        }else{
        	 try {
                 int result = userBo.Login(strUsername, com.ninemax.jpa.util.clsThreeDes.encryptMode3DES(strPassword));

                 if (result == 1) {
                     //登陆成功
                     //验证只能系统用户登录
                     User currentUser = new clsUserBus().FindUserByName(strUsername);
                     //codeFragmentManager(currentUser, session);
                     if (session.getAttribute("sysUser") != null) {
                         session.removeAttribute("sysUser");
                     }
                     session.setAttribute("sysUser", currentUser);
                     login_log(request, response, currentUser);
                     checkSmrw(request, response, currentUser, goPage);
                 } else if (result == -5) {
                     response.sendRedirect(currentPage + "?error=errorXzqh");
                 } else {
                     response.sendRedirect(currentPage + "?error=errorPassword");
                 }
             } catch (SQLException ex) {
                 log.info("数据库连接异常，请联系管理员！" + ex);
                 response.sendRedirect(currentPage + "?error=sqlerror");

             }
        } //else if (!clsStringTool.isEmpty(validateCode_session)&& validateCode_session.equalsIgnoreCase(validateCode_client)) {//验证码一致!clsStringTool.isEmpty(validateCode_session)             && validateCode_session.equalsIgnoreCase(validateCode_client)

           
        //} else {
            //response.sendRedirect(currentPage + "?error=errorValidateCode");
        //}

    }

    private void login_2(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String jgdm = request.getParameter("jgdm");
        String currentPage = request.getParameter("currentPage");
        String passwords = request.getParameter("passwords");
        String goPage = request.getParameter("goPage");
        User currentUser = userBo.checkIC(jgdm);
        if (currentUser != null && !clsStringTool.isEmpty(jgdm)) {
            if (passwords.equals(jgdm)) {
                //码段管理
                codeFragmentManager(currentUser, session);
                session.setAttribute("sysUser", currentUser);
                login_log(request, response, currentUser);
                checkSmrw(request, response, currentUser, goPage);
            } else {
                response.sendRedirect(currentPage + "?error=errorPWD");
            }
        } else {
            response.sendRedirect(currentPage + "?error=icerror");
        }
    }

    private void login_3(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String goPage = request.getParameter("goPage");
        String error = "";
        String currentUserName = "";
        String chooseName = request.getParameter("currentName");
        HashMap hmSession1 = (HashMap) session.getAttribute("hmSession");//初始化session

        try {
            HashMap hmSession = KeyVerify.crlverify(request, hmSession1);
            String[] strCertInfo = (String[]) hmSession.get("CERT_INFO");
            if (strCertInfo[0] != null && !strCertInfo[0].equals("")) {
                String[] attributes = strCertInfo[0].split(",");
                for (String ss : attributes) {
                    if ((ss = clsStringTool.convertNull(ss)).startsWith("CN")) {
                        String[] s = ss.split("=");
                        currentUserName = s[1];
                    }
                }
            }
        } catch (Exception e) {
            log.info("CA ERROR: " + e);
            log.error(UserAction.class, e);
            error = "caunuse";
        }
        User currentUser = userBo.checkCA((clsStringTool.isEmpty(currentUserName) ? "unknow" : currentUserName), chooseName);
        //User currentUser = userBo.checkCA(currentUserName);
        if (clsStringTool.isEmpty(error) && currentUser != null) {
            //codeFragmentManager(currentUser, session);
            session.setAttribute("sysUser", currentUser);
            login_log(request, response, currentUser);
            checkSmrw(request, response, currentUser, goPage);
        } else {
            response.sendRedirect(request.getContextPath() + "/product/CALogin2.jsp?error=" + error);
        }
    }
/*    public static HashMap crlverify(HttpServletRequest request,
			HashMap hmSession) throws Exception {
		String strEncStatus = "";
		long num = 0L;
		String strCertInfo[] = null;
		String strEncData = request.getParameter("ENC_DATA");
		if (strEncData != null && !strEncData.trim().equals("")) {
			DSign dSign = new DSign();
			strEncData = DSignGlobalMethod.getISO8859ToGBK(strEncData);
			//num = dSign.verifyAttachedSign(strEncData.getBytes());
			if (num != (long) 0) {
				strEncStatus = dSign.getErrorMessage();
				long itype = dSign.getErrorCode();
				String strErrCode = Long.toString(itype);
				if (itype == (long) -10001005)
					strEncStatus = "--您使用的数字证书的颁发者不正确--";
				else if (itype == (long) -10001006)
					strEncStatus = "--您的数字证书已经超过有效期！--";
				else if (itype == (long) -10001007)
					strEncStatus = "--您的数字证书已经被注销(CRL验证结果)！--";
				else
					strEncStatus = String.valueOf(String
							.valueOf((new StringBuffer(
									"----您的数字证书无法通过验证！--错误码：")).append(
									strErrCode).append(" 错误信息：").append(
									strEncStatus)));
				throw new Exception(strEncStatus);
			}
			strEncStatus = "成功";
			do {
				byte bData[] = dSign.getData();
				if (bData == null)
					break;
				hmSession.put("ORG_DATA", new String(bData));
			} while (true);
			strCertInfo = new String[10];
			strCertInfo[0] = dSign.getCertInfo("VS", 0, null);
			strCertInfo[1] = dSign.getCertInfo("VS", 1, null);
			strCertInfo[2] = dSign.getCertInfo("VS", 2, null);
			strCertInfo[3] = dSign.getCertInfo("VS", 3, null);
			strCertInfo[4] = dSign.getCertInfo("VS", 4, null);
			strCertInfo[5] = dSign.getCertInfo("VS", 5, null);
			strCertInfo[6] = dSign.getCertInfo("VS", 6, null);
			if(!"".equals(strCertInfo[7])&&strCertInfo[7]!=null){
				strCertInfo[7] = dSign.getCertInfo("VS", 7, "1.2.86.11.7.3.20")
				.trim();
				
			}else{
				strCertInfo[7]="";
			}
			strCertInfo[8] = dSign.getCertInfo("VS", 8, null);
			int iStart = 0;
			int iEnd = 0;
			String strHm = "";
			if (strCertInfo[7].trim().equals("001")) {
				iStart = strCertInfo[0].indexOf('@');
				iEnd = strCertInfo[0].lastIndexOf('@');
				strHm = strCertInfo[0].substring(iStart + 1, iEnd);
			}
			if (strCertInfo[7].trim().equals("101")) {
				iStart = strCertInfo[0].lastIndexOf('=');
				iEnd = strCertInfo[0].length();
				strHm = strCertInfo[0].substring(iStart + 1, iEnd);
			}
			strCertInfo[9] = strHm;
			hmSession.put("CERT_INFO", strCertInfo);
			hmSession.put("ENC_DATA", strEncData);
			hmSession.put("ENC_STATUS", strEncStatus);
			hmSession.put("ENC_RESULT", Long.toString(num));
		}
		return hmSession;
	}*/

    private void checkSmrw(HttpServletRequest request, HttpServletResponse response, User currentUser, String goPage) throws IOException {

        response.sendRedirect("http://" + request.getServerName() + ":" + TomcatUtils.port() + goPage);
    }

    private void codeFragmentManager(User user, HttpSession session) {
        String prompt = "";
        //判断是否有预警权限
        boolean canYz = new clsUserRightKeyBus().HasRight(String.valueOf(user.getUserId()), "0301");
        if (canYz) {
            //获取码段预警数
            TSystem system = InitSysParams.system;
            int mdyjs = system.getMdyjs();
            //码段剩余个数提醒
            Map<String, String> mp = new CodePartBus().sycodeCount();
            //非个体码段
            String nonPer = mp.get("0");
            //个体码段
            String per = mp.get("3");
            if (Integer.parseInt(nonPer) <= mdyjs) {
                prompt += "非个体码段数已经达到预警值！";
            }
            if (Integer.parseInt(per) <= mdyjs) {
                prompt += "个体码段数已经达到预警值！";
            }
            if (Integer.parseInt(nonPer) <= mdyjs || Integer.parseInt(per) <= mdyjs) {
                prompt += "请申请码段！";
            }
        }
        session.setAttribute("prompt", prompt);
    }

    private void exit(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("sysUser") != null) {
            session.removeAttribute("sysUser");
        }
        if (session.getAttribute("webSite_id") != null) {
            session.removeAttribute("webSite_id");
        }
        session.invalidate();
    }

    private String formatUrl(String url, String params) {
        if (!url.contains("?")) {
            url += "?";
        } else {
            url += "&";
        }
        return url + params;
    }


}
