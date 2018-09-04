package com.ninemax.jpa.collection.model;

import javax.persistence.*;


@Entity
@Table(name = "sc_checkcontrol")

public class CheckControl implements java.io.Serializable {

    private static final long serialVersionUID = -5713051632451203524L;
    private Integer id;
    private String bzjgdm;
    private String bz;


    public CheckControl() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "bzjgdm", length = 6)

    public String getBzjgdm() {
        return this.bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    @Column(name = "bz", length = 50)

    public String getBz() {
        return this.bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

}