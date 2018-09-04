package com.ninemax.jpa.code.model;

public class Field {
    private String dm;
    private String name;
    private boolean select = false;

    public Field() {
    }

    public Field(String dm, String name, boolean select) {
        this.dm = dm;
        this.name = name;
        this.select = select;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}