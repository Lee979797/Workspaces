package com.ninemax.sys.controller;

import com.ninemax.common.util.ShiroUtils;
import com.ninemax.sys.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/")
@Controller
public class IndexController {
    @Resource
    private SysUserService loginService;

    @RequestMapping("indexUI")
    public String indexUI() {
        String role = loginService.findRoleByUsername(ShiroUtils.getPrincipal());
        if ("校级账户".equals(role))
            return "headmaster_starter";
        if ("院级账户".equals(role))
            return "dean_starter";
        if ("财务账户".equals(role))
            return "accountant_starter";
        if ("一般账户".equals(role))
            return "teacher_starter";
        return "login";
    }

    @RequestMapping("pageUI")
    public String pageUI() {
        return "com/ninemax/common/page";
    }
}
