package com.ninemax.jpa.system.action;

import com.ninemax.jpa.code.dao.TSmTaskDAO;
import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.TomcatUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class OnlineFilter extends HttpServlet implements javax.servlet.Filter {
    private static final long serialVersionUID = 1L;
    private int time = 0;

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        if (time == 0 && req.getScheme().equals("https")) {
            time = 1;
            responseTo(req, resp, "/");
            return;
        }
        time = 1;
        String uris[] = req.getRequestURI().split("/");
        String uri = uris[uris.length - 1];
        if ("real.jsp".equals(uri)
                || "login.jsp".equals(uri)
                || "real.jsp".equals(uri)
                || "userSel.jsp".equals(uri)
                || "checkpwd.jsp".equals(uri)
                || uri.endsWith("js")
                || uri.endsWith("css")
                || (uris.length >= 2 && uris[uris.length - 2].matches("css|image(s?)|js"))) {
            chain.doFilter(request, response);
            return;
        }
        User user = (User) session.getAttribute("sysUser");
        if (user == null) {
            session.removeAttribute("sysUser");
            responseTo(req, resp, "/product/real.jsp?message=sessionOutTime");
        } else if ((user.getUserName().contains("admin") && uris.length >= 2 && uris[uris.length - 2].equals("rightkey"))
                || "bottom.html".equals(uri)
                || "top_task.jsp".equals(uri)
                || "index.jsp".equals(uri)
                || checkSmrw(req, resp, user)) {
            chain.doFilter(request, response);
        } else if (!user.getUserName().contains("admin") && uris.length >= 2 && uris[uris.length - 2].equals("rightkey")) {
            responseTo(req, resp, "/product/index.html");

        }
    }

    private boolean checkSmrw(HttpServletRequest request, HttpServletResponse response, User currentUser) throws IOException {

        return true;

    }

    private void responseTo(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        response.getWriter().write("<script type='text/javascript'> " +
                "var object = window.parent;" +
                "while ((!undefined === object.parent) && object.parent != null) {" +
                "    object=object.parent;" +
                "}" +
                "object.location.href='" + "http://" + request.getServerName() + ":" + TomcatUtils.port() + url + "';" +
                "</script>");
    }

    public void init(FilterConfig filterConfig) {

    }

    public void destroy() {

    }
}
