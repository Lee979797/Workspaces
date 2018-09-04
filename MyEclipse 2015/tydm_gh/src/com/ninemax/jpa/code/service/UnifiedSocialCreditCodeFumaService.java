package com.ninemax.jpa.code.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by ninemax-199 on 2014/4/2.
 */
@WebService()
public class UnifiedSocialCreditCodeFumaService {
    @WebMethod
    public String CodeFuma(String username,String password,String orgName,String regNum,String codeType,String flag) {
        String result = "Hello, world, from " + username;
        System.out.println(result);
        return result;
    }
    @WebMethod
    public String confirm(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }
}
