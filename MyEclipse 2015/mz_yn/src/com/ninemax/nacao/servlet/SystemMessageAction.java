package com.ninemax.nacao.servlet;


import com.ninemax.jpa.system.bo.SysManage_logBo;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.Map2Bean;
import com.ninemax.nacao.business.message.AttachmentBus;
import com.ninemax.nacao.business.message.SystemMessageBus;
import com.ninemax.nacao.to.message.SystemMessageTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class SystemMessageAction extends HttpServlet {
    private SysManage_logBo sysManage_logBo = new SysManage_logBo();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //���ñ�������
        request.setCharacterEncoding("GBK");
        HttpSession session = request.getSession();
        String operFlag = request.getParameter("operFlag");
        User sysuser = (User) session.getAttribute("sysUser");
        String returnMess;
        SystemMessageTO sysMessage = (SystemMessageTO) Map2Bean.convert(request.getParameterMap(), SystemMessageTO.class);
        SystemMessageBus sysMessBus = new SystemMessageBus();
        AttachmentBus attacthmentBus = new AttachmentBus();
        if ("new".equals(operFlag)) {
            String uuid = request.getSession().getAttribute("uuid").toString();
            String file[] = request.getParameterValues("file");
            String fileName[] = request.getParameterValues("fileName");

            sysMessage.setTop_status("0");
            sysMessage.setSend_status("1");
            int id = sysMessBus.addSysMessage(sysMessage); //������Ϣ����
            // ���渽������
            if ((id != 0) && (file != null)) {
                attacthmentBus.submitAttachmen(file, fileName, uuid, String.valueOf(id));
            }
            //�����ɹ���д��־
            SysManage_log sysManage_log = new SysManage_log();
            sysManage_log.setOperkindId("");
            sysManage_log.setMemo("��������");
            sysManage_log.setOpervalue("��������");
            sysManage_log.setUserid(String.valueOf(sysuser.getUserId()));
            sysManage_log.setUsername(sysuser.getUserName());
            //System.out.println("time======="+DateUtil.getCurrentSystemDateTime());
            sysManage_log.setOperdate(DateUtil.getCurrentSystemDateTime());

            sysManage_logBo.save(sysManage_log);
            if (id == 0) {
                returnMess = "failure";
            } else {
                returnMess = "success";
            }
            request.getSession().removeAttribute("uuid"); // ע����ʵ�������ʱ������ʾ
            response.sendRedirect(request.getContextPath() + "/product/jsp/frame/news_add.jsp?msg=" + returnMess + "&oper=add");
        }
        if ("newmod".equals(operFlag)) {
            String uuid = request.getSession().getAttribute("uuid").toString();
            String file[] = request.getParameterValues("file");
            String fileName[] = request.getParameterValues("fileName");

            sysMessage.setTop_status("0");
            sysMessage.setSend_status("1");
            String i = sysMessBus.modSysMessage(sysMessage);
            if ((i != "") && (file != null)) {
                attacthmentBus.submitModAddAttachmen(file, fileName, uuid, sysMessage.getSys_id());
            }
            //�����ɹ���д��־
            SysManage_log sysManage_log = new SysManage_log();
            sysManage_log.setOperkindId("");
            sysManage_log.setMemo("�޸Ĺ���");
            sysManage_log.setOpervalue("�޸Ĺ���");
            sysManage_log.setUserid(String.valueOf(sysuser.getUserId()));
            sysManage_log.setUsername(sysuser.getUserName());
            sysManage_log.setOperdate(DateUtil.getCurrentSystemDateTime());
            sysManage_logBo.save(sysManage_log);
            if (i != "") {
                returnMess = "success";
            } else {
                returnMess = "failure";
            }
            request.getSession().removeAttribute("uuid"); // ע����ʵ�������ʱ������ʾ
            response.sendRedirect(request.getContextPath() + "/product/jsp/frame/news_add.jsp?msg=" + returnMess + "&oper=mod");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
