package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;

@Entity
@Table(name="sc_newcpfl")

public class NewCpfl  implements java.io.Serializable {
	
	private static final long serialVersionUID = -8455295574346678485L;
	private Integer id;
     private String bigType;
     private String midType;
     private String smlType;
     private String zryy;
     private String memo;
     private String jgdm;
     private String productname;
     private String codecn;



    public NewCpfl() {
    }

    @Id
    
    @Column(name="cid", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="bigType", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getBigType() {
        return this.bigType;
    }
    
    public void setBigType(String bigType) {
        this.bigType = bigType;
    }
    
    @Column(name="midType", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getMidType() {
        return this.midType;
    }
    
    public void setMidType(String midType) {
        this.midType = midType;
    }
    
    @Column(name="smlType", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getSmlType() {
        return this.smlType;
    }
    
    public void setSmlType(String smlType) {
        this.smlType = smlType;
    }
    
    @Column(name="zryy", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getZryy() {
        return this.zryy;
    }
    
    public void setZryy(String zryy) {
        this.zryy = zryy;
    }
    
    @Column(name="memo", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    @Column(name="jgdm", unique=false, nullable=true, insertable=true, updatable=true, length=11)

    public String getJgdm() {
        return this.jgdm;
    }
    
    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }
    
    @Column(name="productname", unique=false, nullable=true, insertable=true, updatable=true, length=500)

    public String getProductname() {
        return this.productname;
    }
    
    public void setProductname(String productname) {
        this.productname = productname;
    }

	public String getCodecn() {
		return codecn;
	}

	public void setCodecn(String codecn) {
		this.codecn = codecn;
	}
   

}