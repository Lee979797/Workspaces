package com.ninemax.sys.controller;

import com.ninemax.common.vo.JsonResult;
import com.ninemax.sys.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SysLoginController {
    @Resource
    private SysUserService loginService;

    @RequestMapping("/loginUI")
    public String login() {
        return "login";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    /**
     * 登录操作
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public JsonResult doLogin(String username, String password) {
        System.out.println(username + "/" + password);
        loginService.login(username, password);
        return new JsonResult("doLogin ok!");
    }

}
