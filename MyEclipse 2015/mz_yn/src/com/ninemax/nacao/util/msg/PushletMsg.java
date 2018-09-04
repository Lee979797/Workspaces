package com.ninemax.nacao.util.msg;

import nl.justobjects.pushlet.client.PushletClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhanghongbin
 * Date: 2010-3-31
 * Time: 14:58:29
 * To change this template use File | Settings | File Templates.
 */
public final class PushletMsg implements IMsg {

    private String url = null;
    private String subscriber = null;
    private Map args = null;

    public PushletMsg(String url, String subscriber, Map args) {
        this.url = url;
        this.subscriber = subscriber;
        this.args = args;
    }

    public boolean send() {
        try {
            PushletClient p = new PushletClient(url + "/pushlet.srv");
            p.join();
            p.publish(subscriber, args);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Map m =  new HashMap();
        m.put("notice","1");
        m.put("content", "sdfsa");
             PushletMsg p = new PushletMsg("http://172.16.3.6:8080","00000001",m);
        p.send();

    }
}
