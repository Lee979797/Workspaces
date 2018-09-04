/**
 *
 */
package com.ninemax.jpa.util;

import com.ninemax.jpa.system.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Liuzy
 */
public class OnlineUserInterceptor implements Interceptor {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    /* (non-Javadoc)
      * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
      */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
//        ActionContext actionContext = invocation.getInvocationContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = invocation.getInvocationContext().getSession();
        HttpServletResponse response = ServletActionContext.getResponse();
        User user = (User) session.get("sysUser");
        if (user == null)
            user = (User) request.getSession().getAttribute("sysUser");
        String result;
        if (user != null)
            result = invocation.invoke();
        else
            result = Action.LOGIN;
        String sessionId = request.getSession().getId();
        response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionId + "; HttpOnly;secure");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        return result;
    }
}
