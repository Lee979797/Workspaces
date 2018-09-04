package com.ninemax.jpa.code.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by ninemax-199 on 2014/4/2.
 */
@WebService(endpointInterface = "com.ninemax.jpa.code.service.WebServiceTest")
public class WebServiceTestImp implements WebServiceTest {

    @Override
    public String getName(String name) {
        return "hello==>" + name;
    }

    public static void main(String[] args) {
        Endpoint.publish(
                "http:/127.0.0.1:9000/ws/hello", new WebServiceTestImp());
    }
}
