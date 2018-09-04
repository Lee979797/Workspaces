package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: zhanghongbin
 * Date: 2010-3-29
 * Time: 13:23:07
 * To change this template use File | Settings | File Templates.
 */
public class AudiUser  implements Serializable{

    private String id = null;
    private String name = null;
    private String areaCode = null;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


}
