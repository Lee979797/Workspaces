package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Liuzy
 */
@Entity
@Table(name = "t_zsbhb")
public class TZsbhb implements java.io.Serializable {

    private static final long serialVersionUID = 3458217551635381106L;
    private TZsbhbId id;
    private String ssds;
    private String ssbzjg;
    private String flag;
    private Date fpsj;
    private Date dysj;
    private String czy;
    private String djh;

    @EmbeddedId
    @AttributeOverrides( {
            @AttributeOverride(name = "zsbh", column = @Column(name = "zsbh", nullable = false, length = 11)),
            @AttributeOverride(name = "zslx", column = @Column(name = "zslx", nullable = false, length = 1)) })
    public TZsbhbId getId() {
        return this.id;
    }

    public void setId(TZsbhbId id) {
        this.id = id;
    }

    @Column(name = "ssds", length = 6)
    public String getSsds() {
        return this.ssds;
    }

    public void setSsds(String ssds) {
        this.ssds = ssds;
    }

    @Column(name = "ssbzjg", length = 6)
    public String getSsbzjg() {
        return this.ssbzjg;
    }

    public void setSsbzjg(String ssbzjg) {
        this.ssbzjg = ssbzjg;
    }

    @Column(name = "flag", nullable = false, length = 1)
    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Column(name = "fpsj", length = 23,columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFpsj() {
        return this.fpsj;
    }

    public void setFpsj(Date fpsj) {
        this.fpsj = fpsj;
    }

    @Column(name = "dysj",length = 23,columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDysj() {
        return this.dysj;
    }

    public void setDysj(Date dysj) {
        this.dysj = dysj;
    }

    @Column(name = "czy", length = 50)
    public String getCzy() {
        return this.czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    @Column(name = "djh", length = 25)
    public String getDjh() {
        return this.djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }
    
    
    

	/**
     * Returns a string representation of the object. In general, the
     * <code>toString</code> method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p/>
     * The <code>toString</code> method for class <code>Object</code>
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `<code>@</code>', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "{id:"+this.id+"',}";    //To change body of overridden methods use File | Settings | File Templates.
    }
}