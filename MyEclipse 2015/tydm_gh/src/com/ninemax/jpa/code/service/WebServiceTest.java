package com.ninemax.jpa.code.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by ninemax-199 on 2014/4/2.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiceTest {
    @WebMethod
    public String getName(String name);
}
