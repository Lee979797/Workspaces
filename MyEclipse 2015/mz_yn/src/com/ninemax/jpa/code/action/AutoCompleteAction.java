package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.AjaxBus;
import com.ninemax.jpa.global.BaseAction;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-25
 * Time: ÏÂÎç2:26
 */
public class AutoCompleteAction extends BaseAction {

    private static Logger log = Logger.getLogger(AutoCompleteAction.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            AjaxBus ajaxBo = new AjaxBus();
            request.setCharacterEncoding("GBK");
            response.setContentType("text/html; charset=GBK");
            PrintWriter out;
            String method = request.getParameter("method");
            String filter = request.getParameter("filter");
            String userInput = request.getParameter("term");
            String bzjgdm = request.getParameter("bzjgdm");
            String strs = ajaxBo.getAjaxInfo(method, userInput, bzjgdm, "true".equals(filter));
            out = response.getWriter();
            out.print(strs);
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error(AutoCompleteAction.class, e);
        }
    }

}
