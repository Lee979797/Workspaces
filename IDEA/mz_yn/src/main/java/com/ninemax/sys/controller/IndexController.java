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

    @RequestMapping("pageUI")
    public String pageUI() {
        return "com/ninemax/common/page";
    }
}
