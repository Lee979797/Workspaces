package com.ninemax.jpa.util;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.global.InitSysParams;
import org.apache.log4j.Logger;
import org.codehaus.xfire.client.Client;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


public class ServiceClient {
    private static Client client;
    private static Logger log = Logger.getLogger(ServiceClient.class);

    static {
        try {
            client = new Client(new URL("http://221.212.89.165:8899/wsdl/services/ReadCompanyService?wsdl"));
        } catch (Exception e) {
            log.error(ServiceClient.class, e);
        }
    }

    /**
     * 查询test方法
     *
     * @return
     */
    public static void query() {
        List<TJgdm> jgdms = new ArrayList<TJgdm>();
        try {
          Object[] results = client.invoke("sayHello", new Object[]{"sdsadasd"});
            for (Object r : results) {
                System.out.println("r = " + r);
                //    System.out.println("r = " + XmlUtils.parseXMLR(URLDecoder.decode((String) r, "utf-8")));
            }
        } catch (MalformedURLException e) {
            log.error(ServiceClient.class, e);
        } catch (Exception e) {
            log.error(ServiceClient.class, e);
        }
    }

    public static boolean update(String numberStr, TJgdm jgdm) {
        try {
            System.out.println("dm.getBak4() = " + numberStr);
            System.out.println("dm.getBak4() = " + jgdm.getJgdm());
            Object[] objects = new Object[9];
            objects[0] = UserPropertiesData.getValueByPropertyName("WS_DPMID");
            objects[1] = numberStr;
            objects[2] = jgdm.getJgmc();
            objects[3] = jgdm.getJgdm();
            objects[4] = InitSysParams.zrxzqhMap.get(jgdm.getBzjgdm());
            objects[5] = DateUtil.dateToStr(jgdm.getBzrq());
            objects[6] = jgdm.getZslsh();
            objects[7] = DateUtil.dateToStr(jgdm.getBzrq());
            objects[8] = DateUtil.dateToStr(jgdm.getZfrq());
            Object[] results = client.invoke(UserPropertiesData.getValueByPropertyName("WS_UPDATA"), objects);
            for (Object r : results) {
                if ("1".equals(XmlUtils.parseXMLR(URLDecoder.decode((String) r, "utf-8")))) {
                    return true;
                }
            }
        } catch (MalformedURLException e) {
            log.error(ServiceClient.class, e);
        } catch (Exception e) {
            log.error(ServiceClient.class, e);
        }
        return false;
    }

    public static void main(String[] args) {
        //插入操作
        //System.out.println(new AccountFlowServiceClient().create());
        //修改操作
        //System.out.println(new AccountFlowServiceClient().update());
        //查询操作
        ServiceClient.query();
    }

}
