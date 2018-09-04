/**
 *
 */
package com.ninemax.jpa.code.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * @author Liuzy
 */
public class  UserManageAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;


    public UserManageAction() {

    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
