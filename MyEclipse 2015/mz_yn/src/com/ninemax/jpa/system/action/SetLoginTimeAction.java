package com.ninemax.jpa.system.action;

import com.ninemax.jpa.global.BaseAction;
import com.ninemax.jpa.util.UserPropertiesData;
import com.ninemax.jpa.util.clsStringTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetLoginTimeAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
        String startDate1 = clsStringTool.convertNull(request.getParameter("startDate1"));
        String startDate2 = clsStringTool.convertNull(request.getParameter("startDate2"));
        String endDate1 = clsStringTool.convertNull(request.getParameter("endDate1"));
        String endDate2 = clsStringTool.convertNull(request.getParameter("endDate2"));
//        String centerName = request.getParameter("firstXzqh");
//        boolean flag = new UserPropertiesData().changeValueByPropertyName("productCenter",centerName);
        //System.out.println("startDate1 = " + startDate1 + ":" + startDate2 + "-" + endDate1 + ":" + endDate2);
        if (Integer.valueOf(startDate1) > Integer.valueOf(endDate1) || (Integer.valueOf(startDate1) == Integer.valueOf(endDate1) && Integer.valueOf(startDate2) >= Integer.valueOf(endDate2))) {
            this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=no"));
            return;
        }
        boolean startDateFlag = UserPropertiesData.changeValueByPropertyName("startDate", startDate1 + ":" + startDate2);
        boolean endDateFlag = UserPropertiesData.changeValueByPropertyName("endDate", endDate1 + ":" + endDate2);
//		if(startDateFlag && endDateFlag && flag){
        if (startDateFlag && endDateFlag) {
            this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=ok"));
        } else {
            this.sendRedirect(response, formatUrl(request.getParameter("currentPage"), "msg=no"));
        }
    }

    private String formatUrl(String url, String params) {
        if (url.indexOf("?") == -1) {
            url += "?";
        } else {
            url += "&";
        }
        return url + params;
    }
}
