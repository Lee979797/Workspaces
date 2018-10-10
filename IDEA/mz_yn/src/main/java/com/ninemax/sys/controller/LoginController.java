package com.ninemax.sys.controller;

import com.ninemax.sys.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/")
@Controller
public class LoginController {
    @Resource
    private SysUserService loginService;

    @RequestMapping("doLogin")
    public String doLogin() {
        return "login";
    }
}
