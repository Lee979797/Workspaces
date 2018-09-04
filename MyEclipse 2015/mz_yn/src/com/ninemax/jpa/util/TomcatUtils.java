package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import javax.management.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ninemax-199
 * Date: 13-12-3
 * Time: 下午2:12
 */
public class TomcatUtils {
    private static Logger log = Logger.getLogger(TomcatUtils.class);
    private static String port = null;

    public static String port() {
        if (port == null) {
            port = getHttpPort("org.apache.coyote.http11.Http11NioProtocol", "http");
        }
        
        //port="7002";
        return port;
    }
    /**
     * 根据协议和scheme获取服务端口号
     *
     * @param protocol String
     * @param scheme   String
     * @return 端口号
     */
    private static String getHttpPort(String protocol, String scheme) {
        MBeanServer server = null;
        if (MBeanServerFactory.findMBeanServer(null).size() > 0) {
            server = MBeanServerFactory.findMBeanServer(null).get(0);
        }
        try {
            Set<ObjectName> names = server.queryNames(new ObjectName("Catalina:type=Connector,*"), null);
            Iterator it = names.iterator();
            ObjectName name;

            while (it.hasNext()) {
                name = (ObjectName) it.next();
                String pvalue = (String) server.getAttribute(name, "protocol");
                String svalue = (String) server.getAttribute(name, "scheme");
                if (protocol.equals(pvalue) && scheme.equals(svalue)) {

                    return (server.getAttribute(name, "port")).toString();

                }
            }
        } catch (MBeanException e) {
            log.error(TomcatUtils.class, e);
        } catch (AttributeNotFoundException e) {
            log.error(TomcatUtils.class, e);
        } catch (InstanceNotFoundException e) {
            log.error(TomcatUtils.class, e);
        } catch (ReflectionException e) {
            log.error(TomcatUtils.class, e);
        } catch (MalformedObjectNameException e) {
            log.error(TomcatUtils.class, e);
        }
        return "8080";
    }

}
