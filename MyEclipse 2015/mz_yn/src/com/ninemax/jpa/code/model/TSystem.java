package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: yzhhui
 * Date: 13-4-16
 * Time: ÏÂÎç12:28
 */
@javax.persistence.Table(name = "t_system")
@Entity
public class TSystem {
    private String xzqhdm;

    @javax.persistence.Column(name = "xzqhdm")
    @Id
    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    private String xzqhmc;

    @javax.persistence.Column(name = "xzqhmc")
    @Basic
    public String getXzqhmc() {
        return xzqhmc;
    }

    public void setXzqhmc(String xzqhmc) {
        this.xzqhmc = xzqhmc;
    }

    private String dm;

    @javax.persistence.Column(name = "dm")
    @Basic
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    private String mc;

    @javax.persistence.Column(name = "mc")
    @Basic
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    private String md;

    @javax.persistence.Column(name = "md")
    @Basic
    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    private String icqx;

    @javax.persistence.Column(name = "icqx")
    @Basic
    public String getIcqx() {
        return icqx;
    }

    public void setIcqx(String icqx) {
        this.icqx = icqx;
    }

    private String fmfs;

    @javax.persistence.Column(name = "fmfs")
    @Basic
    public String getFmfs() {
        return fmfs;
    }

    public void setFmfs(String fmfs) {
        this.fmfs = fmfs;
    }

    private Integer interval;

    @javax.persistence.Column(name = "interval")
    @Basic
    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    private String ip;

    @javax.persistence.Column(name = "ip")
    @Basic
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private Integer xbcqsz;

    @javax.persistence.Column(name = "xbcqsz")
    @Basic
    public Integer getXbcqsz() {
        return xbcqsz;
    }

    public void setXbcqsz(Integer xbcqsz) {
        this.xbcqsz = xbcqsz;
    }

    private Integer hzcqsz;

    @javax.persistence.Column(name = "hzcqsz")
    @Basic
    public Integer getHzcqsz() {
        return hzcqsz;
    }

    public void setHzcqsz(Integer hzcqsz) {
        this.hzcqsz = hzcqsz;
    }

    private Integer njcqsz;

    @javax.persistence.Column(name = "njcqsz")
    @Basic
    public Integer getNjcqsz() {
        return njcqsz;
    }

    public void setNjcqsz(Integer njcqsz) {
        this.njcqsz = njcqsz;
    }

    private Integer bgcqsz;

    @javax.persistence.Column(name = "bgcqsz")
    @Basic
    public Integer getBgcqsz() {
        return bgcqsz;
    }

    public void setBgcqsz(Integer bgcqsz) {
        this.bgcqsz = bgcqsz;
    }

    private Integer fzcqsz;

    @javax.persistence.Column(name = "fzcqsz")
    @Basic
    public Integer getFzcqsz() {
        return fzcqsz;
    }

    public void setFzcqsz(Integer fzcqsz) {
        this.fzcqsz = fzcqsz;
    }

    private Boolean xbsfcf;

    @javax.persistence.Column(name = "xbsfcf")
    @Basic
    public Boolean getXbsfcf() {
        return xbsfcf;
    }

    public void setXbsfcf(Boolean xbsfcf) {
        this.xbsfcf = xbsfcf;
    }

    private Boolean hzsfcf;

    @javax.persistence.Column(name = "hzsfcf")
    @Basic
    public Boolean getHzsfcf() {
        return hzsfcf;
    }

    public void setHzsfcf(Boolean hzsfcf) {
        this.hzsfcf = hzsfcf;
    }

    private Boolean njsfcf;

    @javax.persistence.Column(name = "njsfcf")
    @Basic
    public Boolean getNjsfcf() {
        return njsfcf;
    }

    public void setNjsfcf(Boolean njsfcf) {
        this.njsfcf = njsfcf;
    }

    private Boolean bgsfcf;

    @javax.persistence.Column(name = "bgsfcf")
    @Basic
    public Boolean getBgsfcf() {
        return bgsfcf;
    }

    public void setBgsfcf(Boolean bgsfcf) {
        this.bgsfcf = bgsfcf;
    }

    private Boolean fzsfcf;

    @javax.persistence.Column(name = "fzsfcf")
    @Basic
    public Boolean getFzsfcf() {
        return fzsfcf;
    }

    public void setFzsfcf(Boolean fzsfcf) {
        this.fzsfcf = fzsfcf;
    }

    private Integer gtcfsz;

    @javax.persistence.Column(name = "gtcfsz")
    @Basic
    public Integer getGtcfsz() {
        return gtcfsz;
    }

    public void setGtcfsz(Integer gtcfsz) {
        this.gtcfsz = gtcfsz;
    }

    private Boolean gtsfcf;

    @javax.persistence.Column(name = "gtsfcf")
    @Basic
    public Boolean getGtsfcf() {
        return gtsfcf;
    }

    public void setGtsfcf(Boolean gtsfcf) {
        this.gtsfcf = gtsfcf;
    }

    private Integer cfjesx;

    @javax.persistence.Column(name = "cfjesx")
    @Basic
    public Integer getCfjesx() {
        return cfjesx;
    }

    public void setCfjesx(Integer cfjesx) {
        this.cfjesx = cfjesx;
    }

    private Boolean kcdybz;

    @javax.persistence.Column(name = "kcdybz")
    @Basic
    public Boolean getKcdybz() {
        return kcdybz;
    }

    public void setKcdybz(Boolean kcdybz) {
        this.kcdybz = kcdybz;
    }

    private Boolean isfzdm;

    @javax.persistence.Column(name = "isfzdm")
    @Basic
    public Boolean getIsfzdm() {
        return isfzdm;
    }

    public void setIsfzdm(Boolean isfzdm) {
        this.isfzdm = isfzdm;
    }

    private Boolean frbgprintzs;

    @javax.persistence.Column(name = "frbgprintzs")
    @Basic
    public Boolean getFrbgprintzs() {
        return frbgprintzs;
    }

    public void setFrbgprintzs(Boolean frbgprintzs) {
        this.frbgprintzs = frbgprintzs;
    }

    private Boolean fzsh;

    @javax.persistence.Column(name = "fzsh")
    @Basic
    public Boolean getFzsh() {
        return fzsh;
    }

    public void setFzsh(Boolean fzsh) {
        this.fzsh = fzsh;
    }

    private Boolean fzhfsh;

    @javax.persistence.Column(name = "fzhfsh")
    @Basic
    public Boolean getFzhfsh() {
        return fzhfsh;
    }

    public void setFzhfsh(Boolean fzhfsh) {
        this.fzhfsh = fzhfsh;
    }

    private String szxglbf;

    @javax.persistence.Column(name = "szxglbf")
    @Basic
    public String getSzxglbf() {
        return szxglbf;
    }

    public void setSzxglbf(String szxglbf) {
        this.szxglbf = szxglbf;
    }

    private String szxzxdh;

    @javax.persistence.Column(name = "szxzxdh")
    @Basic
    public String getSzxzxdh() {
        return szxzxdh;
    }

    public void setSzxzxdh(String szxzxdh) {
        this.szxzxdh = szxzxdh;
    }

    private Boolean zygljb;

    @javax.persistence.Column(name = "zygljb")
    @Basic
    public Boolean getZygljb() {
        return zygljb;
    }

    public void setZygljb(Boolean zygljb) {
        this.zygljb = zygljb;
    }

    private Boolean zsbhsfbl;

    @javax.persistence.Column(name = "zsbhsfbl")
    @Basic
    public Boolean getZsbhsfbl() {
        return zsbhsfbl;
    }

    public void setZsbhsfbl(Boolean zsbhsfbl) {
        this.zsbhsfbl = zsbhsfbl;
    }

    private Boolean qzsh;

    @javax.persistence.Column(name = "qzsh")
    @Basic
    public Boolean getQzsh() {
        return qzsh;
    }

    public void setQzsh(Boolean qzsh) {
        this.qzsh = qzsh;
    }

    private Boolean deletesh;

    @javax.persistence.Column(name = "deletesh")
    @Basic
    public Boolean getDeletesh() {
        return deletesh;
    }

    public void setDeletesh(Boolean deletesh) {
        this.deletesh = deletesh;
    }

    private Boolean bgsh;

    @javax.persistence.Column(name = "bgsh")
    @Basic
    public Boolean getBgsh() {
        return bgsh;
    }

    public void setBgsh(Boolean bgsh) {
        this.bgsh = bgsh;
    }

    private Boolean hzsh;

    @javax.persistence.Column(name = "hzsh")
    @Basic
    public Boolean getHzsh() {
        return hzsh;
    }

    public void setHzsh(Boolean hzsh) {
        this.hzsh = hzsh;
    }

    private Boolean sqbscsh;

    @javax.persistence.Column(name = "sqbscsh")
    @Basic
    public Boolean getSqbscsh() {
        return sqbscsh;
    }

    public void setSqbscsh(Boolean sqbscsh) {
        this.sqbscsh = sqbscsh;
    }

    private Boolean cmzcsh;

    @javax.persistence.Column(name = "cmzcsh")
    @Basic
    public Boolean getCmzcsh() {
        return cmzcsh;
    }

    public void setCmzcsh(Boolean cmzcsh) {
        this.cmzcsh = cmzcsh;
    }

    private Boolean oneKind;

    @javax.persistence.Column(name = "oneKind")
    @Basic
    public Boolean getOneKind() {
        return oneKind;
    }

    public void setOneKind(Boolean oneKind) {
        this.oneKind = oneKind;
    }

    private Integer busTimes;

    @javax.persistence.Column(name = "busTimes")
    @Basic
    public Integer getBusTimes() {
        return busTimes;
    }

    public void setBusTimes(Integer busTimes) {
        this.busTimes = busTimes;
    }

    private Boolean xbfz;

    @javax.persistence.Column(name = "xbfz")
    @Basic
    public Boolean getXbfz() {
        return xbfz;
    }

    public void setXbfz(Boolean xbfz) {
        this.xbfz = xbfz;
    }

    private Boolean njfz;

    @javax.persistence.Column(name = "njfz")
    @Basic
    public Boolean getNjfz() {
        return njfz;
    }

    public void setNjfz(Boolean njfz) {
        this.njfz = njfz;
    }

    private Boolean hzfz;

    @javax.persistence.Column(name = "hzfz")
    @Basic
    public Boolean getHzfz() {
        return hzfz;
    }

    public void setHzfz(Boolean hzfz) {
        this.hzfz = hzfz;
    }

    private Boolean addJgdmSmTask;

    @javax.persistence.Column(name = "addJgdmSmTask")
    @Basic
    public Boolean getAddJgdmSmTask() {
        return addJgdmSmTask;
    }

    public void setAddJgdmSmTask(Boolean addJgdmSmTask) {
        this.addJgdmSmTask = addJgdmSmTask;
    }

    private Boolean qtfmSmTask;

    @javax.persistence.Column(name = "qtfmSmTask")
    @Basic
    public Boolean getQtfmSmTask() {
        return qtfmSmTask;
    }

    public void setQtfmSmTask(Boolean qtfmSmTask) {
        this.qtfmSmTask = qtfmSmTask;
    }

    private Boolean yfmSmTask;

    @javax.persistence.Column(name = "yfmSmTask")
    @Basic
    public Boolean getYfmSmTask() {
        return yfmSmTask;
    }

    public void setYfmSmTask(Boolean yfmSmTask) {
        this.yfmSmTask = yfmSmTask;
    }

    private Boolean bgSmTask;

    @javax.persistence.Column(name = "bgSmTask")
    @Basic
    public Boolean getBgSmTask() {
        return bgSmTask;
    }

    public void setBgSmTask(Boolean bgSmTask) {
        this.bgSmTask = bgSmTask;
    }

    private Boolean hzSmTask;

    @javax.persistence.Column(name = "hzSmTask")
    @Basic
    public Boolean getHzSmTask() {
        return hzSmTask;
    }

    public void setHzSmTask(Boolean hzSmTask) {
        this.hzSmTask = hzSmTask;
    }

    private Boolean njSmTask;

    @javax.persistence.Column(name = "njSmTask")
    @Basic
    public Boolean getNjSmTask() {
        return njSmTask;
    }

    public void setNjSmTask(Boolean njSmTask) {
        this.njSmTask = njSmTask;
    }

    private Boolean sjjrSmTask;

    @javax.persistence.Column(name = "sjjrSmTask")
    @Basic
    public Boolean getSjjrSmTask() {
        return sjjrSmTask;
    }

    public void setSjjrSmTask(Boolean sjjrSmTask) {
        this.sjjrSmTask = sjjrSmTask;
    }

    private Boolean qtbmfmsh;

    @javax.persistence.Column(name = "qtbmfmsh")
    @Basic
    public Boolean getQtbmfmsh() {
        return qtbmfmsh;
    }

    public void setQtbmfmsh(Boolean qtbmfmsh) {
        this.qtbmfmsh = qtbmfmsh;
    }

    private Boolean yfmscsh;

    @javax.persistence.Column(name = "yfmscsh")
    @Basic
    public Boolean getYfmscsh() {
        return yfmscsh;
    }

    public void setYfmscsh(Boolean yfmscsh) {
        this.yfmscsh = yfmscsh;
    }

    private Integer printAfterDay;

    @javax.persistence.Column(name = "printAfterDay")
    @Basic
    public Integer getPrintAfterDay() {
        return printAfterDay;
    }

    public void setPrintAfterDay(Integer printAfterDay) {
        this.printAfterDay = printAfterDay;
    }

    private Boolean isPunish;

    @javax.persistence.Column(name = "isPunish")
    @Basic
    public Boolean getIsPunish() {
        return isPunish;
    }

    public void setIsPunish(Boolean punish) {
        isPunish = punish;
    }

    private Integer njqx;

    @javax.persistence.Column(name = "njqx")
    @Basic
    public Integer getNjqx() {
        return njqx;
    }

    public void setNjqx(Integer njqx) {
        this.njqx = njqx;
    }

    private Integer fmqx;

    @javax.persistence.Column(name = "fmqx")
    @Basic
    public Integer getFmqx() {
        return fmqx;
    }

    public void setFmqx(Integer fmqx) {
        this.fmqx = fmqx;
    }

    private Integer hzqx;

    @javax.persistence.Column(name = "hzqx")
    @Basic
    public Integer getHzqx() {
        return hzqx;
    }

    public void setHzqx(Integer hzqx) {
        this.hzqx = hzqx;
    }

    private Boolean xsgg;

    @javax.persistence.Column(name = "xsgg")
    @Basic
    public Boolean getXsgg() {
        return xsgg;
    }

    public void setXsgg(Boolean xsgg) {
        this.xsgg = xsgg;
    }

    private String imagePath;

    @javax.persistence.Column(name = "ImagePath")
    @Basic
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private Boolean isYwlc;

    @javax.persistence.Column(name = "isYwlc")
    @Basic
    public Boolean getIsYwlc() {
        return isYwlc;
    }

    public void setIsYwlc(Boolean ywlc) {
        isYwlc = ywlc;
    }

    private Boolean isSmTask;

    @javax.persistence.Column(name = "isSmTask")
    @Basic
    public Boolean getIsSmTask() {
        return isSmTask;
    }

    public void setIsSmTask(Boolean smTask) {
        isSmTask = smTask;
    }

    private Integer mdyjs;

    @javax.persistence.Column(name = "mdyjs")
    @Basic
    public Integer getMdyjs() {
        return mdyjs;
    }

    public void setMdyjs(Integer mdyjs) {
        this.mdyjs = mdyjs;
    }

    private Integer smqx;

    @javax.persistence.Column(name = "smqx")
    @Basic
    public Integer getSmqx() {
        return smqx;
    }

    public void setSmqx(Integer smqx) {
        this.smqx = smqx;
    }

    private Integer daqx;

    @javax.persistence.Column(name = "daqx")
    @Basic
    public Integer getDaqx() {
        return daqx;
    }

    public void setDaqx(Integer daqx) {
        this.daqx = daqx;
    }

    private Integer sjqx;

    @javax.persistence.Column(name = "sjqx")
    @Basic
    public Integer getSjqx() {
        return sjqx;
    }

    public void setSjqx(Integer sjqx) {
        this.sjqx = sjqx;
    }

    private Boolean snqrSmTask;

    @javax.persistence.Column(name = "snqrSmTask")
    @Basic
    public Boolean getSnqrSmTask() {
        return snqrSmTask;
    }

    public void setSnqrSmTask(Boolean snqrSmTask) {
        this.snqrSmTask = snqrSmTask;
    }

    private Boolean snqcSmTask;

    @javax.persistence.Column(name = "snqcSmTask")
    @Basic
    public Boolean getSnqcSmTask() {
        return snqcSmTask;
    }

    public void setSnqcSmTask(Boolean snqcSmTask) {
        this.snqcSmTask = snqcSmTask;
    }

    private Boolean sjqcSmTask;

    @javax.persistence.Column(name = "sjqcSmTask")
    @Basic
    public Boolean getSjqcSmTask() {
        return sjqcSmTask;
    }

    public void setSjqcSmTask(Boolean sjqcSmTask) {
        this.sjqcSmTask = sjqcSmTask;
    }

    private Boolean fzhfSmTask;

    @javax.persistence.Column(name = "fzhfSmTask")
    @Basic
    public Boolean getFzhfSmTask() {
        return fzhfSmTask;
    }

    public void setFzhfSmTask(Boolean fzhfSmTask) {
        this.fzhfSmTask = fzhfSmTask;
    }

    private Boolean fzSmTask;

    @javax.persistence.Column(name = "fzSmTask")
    @Basic
    public Boolean getFzSmTask() {
        return fzSmTask;
    }

    public void setFzSmTask(Boolean fzSmTask) {
        this.fzSmTask = fzSmTask;
    }

    private Boolean qzsm;

    @javax.persistence.Column(name = "qzsm")
    @Basic
    public Boolean getQzsm() {
        return qzsm;
    }

    public void setQzsm(Boolean qzsm) {
        this.qzsm = qzsm;
    }

    private Boolean isGs;

    @javax.persistence.Column(name = "isgs")
    @Basic
    public Boolean getIsGs() {
        return isGs;
    }

    public void setIsGs(Boolean gs) {
        isGs = gs;
    }

    private Boolean forceEntryNo;

    @javax.persistence.Column(name = "forceEntryNo")
    @Basic
    public Boolean getForceEntryNo() {
        return forceEntryNo;
    }

    public void setForceEntryNo(Boolean forceEntryNo) {
        this.forceEntryNo = forceEntryNo;
    }

    private Boolean jzfm;

    @javax.persistence.Column(name = "jzfm")
    @Basic
    public Boolean getJzfm() {
        return jzfm;
    }

    public void setJzfm(Boolean jzfm) {
        this.jzfm = jzfm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSystem tSystem = (TSystem) o;

        if (addJgdmSmTask != null ? !addJgdmSmTask.equals(tSystem.addJgdmSmTask) : tSystem.addJgdmSmTask != null)
            return false;
        if (bgSmTask != null ? !bgSmTask.equals(tSystem.bgSmTask) : tSystem.bgSmTask != null) return false;
        if (bgcqsz != null ? !bgcqsz.equals(tSystem.bgcqsz) : tSystem.bgcqsz != null) return false;
        if (bgsfcf != null ? !bgsfcf.equals(tSystem.bgsfcf) : tSystem.bgsfcf != null) return false;
        if (bgsh != null ? !bgsh.equals(tSystem.bgsh) : tSystem.bgsh != null) return false;
        if (busTimes != null ? !busTimes.equals(tSystem.busTimes) : tSystem.busTimes != null) return false;
        if (cfjesx != null ? !cfjesx.equals(tSystem.cfjesx) : tSystem.cfjesx != null) return false;
        if (cmzcsh != null ? !cmzcsh.equals(tSystem.cmzcsh) : tSystem.cmzcsh != null) return false;
        if (deletesh != null ? !deletesh.equals(tSystem.deletesh) : tSystem.deletesh != null) return false;
        if (dm != null ? !dm.equals(tSystem.dm) : tSystem.dm != null) return false;
        if (fmfs != null ? !fmfs.equals(tSystem.fmfs) : tSystem.fmfs != null) return false;
        if (frbgprintzs != null ? !frbgprintzs.equals(tSystem.frbgprintzs) : tSystem.frbgprintzs != null) return false;
        if (fzSmTask != null ? !fzSmTask.equals(tSystem.fzSmTask) : tSystem.fzSmTask != null) return false;
        if (fzcqsz != null ? !fzcqsz.equals(tSystem.fzcqsz) : tSystem.fzcqsz != null) return false;
        if (fzhfSmTask != null ? !fzhfSmTask.equals(tSystem.fzhfSmTask) : tSystem.fzhfSmTask != null) return false;
        if (fzhfsh != null ? !fzhfsh.equals(tSystem.fzhfsh) : tSystem.fzhfsh != null) return false;
        if (fzsfcf != null ? !fzsfcf.equals(tSystem.fzsfcf) : tSystem.fzsfcf != null) return false;
        if (fzsh != null ? !fzsh.equals(tSystem.fzsh) : tSystem.fzsh != null) return false;
        if (gtcfsz != null ? !gtcfsz.equals(tSystem.gtcfsz) : tSystem.gtcfsz != null) return false;
        if (gtsfcf != null ? !gtsfcf.equals(tSystem.gtsfcf) : tSystem.gtsfcf != null) return false;
        if (hzSmTask != null ? !hzSmTask.equals(tSystem.hzSmTask) : tSystem.hzSmTask != null) return false;
        if (hzcqsz != null ? !hzcqsz.equals(tSystem.hzcqsz) : tSystem.hzcqsz != null) return false;
        if (hzqx != null ? !hzqx.equals(tSystem.hzqx) : tSystem.hzqx != null) return false;
        if (hzsfcf != null ? !hzsfcf.equals(tSystem.hzsfcf) : tSystem.hzsfcf != null) return false;
        if (hzsh != null ? !hzsh.equals(tSystem.hzsh) : tSystem.hzsh != null) return false;
        if (icqx != null ? !icqx.equals(tSystem.icqx) : tSystem.icqx != null) return false;
        if (imagePath != null ? !imagePath.equals(tSystem.imagePath) : tSystem.imagePath != null) return false;
        if (interval != null ? !interval.equals(tSystem.interval) : tSystem.interval != null) return false;
        if (ip != null ? !ip.equals(tSystem.ip) : tSystem.ip != null) return false;
        if (isPunish != null ? !isPunish.equals(tSystem.isPunish) : tSystem.isPunish != null) return false;
        if (isSmTask != null ? !isSmTask.equals(tSystem.isSmTask) : tSystem.isSmTask != null) return false;
        if (isYwlc != null ? !isYwlc.equals(tSystem.isYwlc) : tSystem.isYwlc != null) return false;
        if (isfzdm != null ? !isfzdm.equals(tSystem.isfzdm) : tSystem.isfzdm != null) return false;
        if (kcdybz != null ? !kcdybz.equals(tSystem.kcdybz) : tSystem.kcdybz != null) return false;
        if (mc != null ? !mc.equals(tSystem.mc) : tSystem.mc != null) return false;
        if (md != null ? !md.equals(tSystem.md) : tSystem.md != null) return false;
        if (mdyjs != null ? !mdyjs.equals(tSystem.mdyjs) : tSystem.mdyjs != null) return false;
        if (njSmTask != null ? !njSmTask.equals(tSystem.njSmTask) : tSystem.njSmTask != null) return false;
        if (njcqsz != null ? !njcqsz.equals(tSystem.njcqsz) : tSystem.njcqsz != null) return false;
        if (njqx != null ? !njqx.equals(tSystem.njqx) : tSystem.njqx != null) return false;
        if (njsfcf != null ? !njsfcf.equals(tSystem.njsfcf) : tSystem.njsfcf != null) return false;
        if (oneKind != null ? !oneKind.equals(tSystem.oneKind) : tSystem.oneKind != null) return false;
        if (printAfterDay != null ? !printAfterDay.equals(tSystem.printAfterDay) : tSystem.printAfterDay != null)
            return false;
        if (qtbmfmsh != null ? !qtbmfmsh.equals(tSystem.qtbmfmsh) : tSystem.qtbmfmsh != null) return false;
        if (qtfmSmTask != null ? !qtfmSmTask.equals(tSystem.qtfmSmTask) : tSystem.qtfmSmTask != null) return false;
        if (qzsh != null ? !qzsh.equals(tSystem.qzsh) : tSystem.qzsh != null) return false;
        if (sjjrSmTask != null ? !sjjrSmTask.equals(tSystem.sjjrSmTask) : tSystem.sjjrSmTask != null) return false;
        if (sjqcSmTask != null ? !sjqcSmTask.equals(tSystem.sjqcSmTask) : tSystem.sjqcSmTask != null) return false;
        if (smqx != null ? !smqx.equals(tSystem.smqx) : tSystem.smqx != null) return false;
        if (snqcSmTask != null ? !snqcSmTask.equals(tSystem.snqcSmTask) : tSystem.snqcSmTask != null) return false;
        if (snqrSmTask != null ? !snqrSmTask.equals(tSystem.snqrSmTask) : tSystem.snqrSmTask != null) return false;
        if (sqbscsh != null ? !sqbscsh.equals(tSystem.sqbscsh) : tSystem.sqbscsh != null) return false;
        if (szxglbf != null ? !szxglbf.equals(tSystem.szxglbf) : tSystem.szxglbf != null) return false;
        if (szxzxdh != null ? !szxzxdh.equals(tSystem.szxzxdh) : tSystem.szxzxdh != null) return false;
        if (xbcqsz != null ? !xbcqsz.equals(tSystem.xbcqsz) : tSystem.xbcqsz != null) return false;
        if (xbsfcf != null ? !xbsfcf.equals(tSystem.xbsfcf) : tSystem.xbsfcf != null) return false;
        if (xsgg != null ? !xsgg.equals(tSystem.xsgg) : tSystem.xsgg != null) return false;
        if (xzqhdm != null ? !xzqhdm.equals(tSystem.xzqhdm) : tSystem.xzqhdm != null) return false;
        if (xzqhmc != null ? !xzqhmc.equals(tSystem.xzqhmc) : tSystem.xzqhmc != null) return false;
        if (yfmSmTask != null ? !yfmSmTask.equals(tSystem.yfmSmTask) : tSystem.yfmSmTask != null) return false;
        if (yfmscsh != null ? !yfmscsh.equals(tSystem.yfmscsh) : tSystem.yfmscsh != null) return false;
        if (zsbhsfbl != null ? !zsbhsfbl.equals(tSystem.zsbhsfbl) : tSystem.zsbhsfbl != null) return false;
        if (zygljb != null ? !zygljb.equals(tSystem.zygljb) : tSystem.zygljb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqhdm != null ? xzqhdm.hashCode() : 0;
        result = 31 * result + (xzqhmc != null ? xzqhmc.hashCode() : 0);
        result = 31 * result + (dm != null ? dm.hashCode() : 0);
        result = 31 * result + (mc != null ? mc.hashCode() : 0);
        result = 31 * result + (md != null ? md.hashCode() : 0);
        result = 31 * result + (icqx != null ? icqx.hashCode() : 0);
        result = 31 * result + (fmfs != null ? fmfs.hashCode() : 0);
        result = 31 * result + (interval != null ? interval.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (xbcqsz != null ? xbcqsz.hashCode() : 0);
        result = 31 * result + (hzcqsz != null ? hzcqsz.hashCode() : 0);
        result = 31 * result + (njcqsz != null ? njcqsz.hashCode() : 0);
        result = 31 * result + (bgcqsz != null ? bgcqsz.hashCode() : 0);
        result = 31 * result + (fzcqsz != null ? fzcqsz.hashCode() : 0);
        result = 31 * result + (xbsfcf != null ? xbsfcf.hashCode() : 0);
        result = 31 * result + (hzsfcf != null ? hzsfcf.hashCode() : 0);
        result = 31 * result + (njsfcf != null ? njsfcf.hashCode() : 0);
        result = 31 * result + (bgsfcf != null ? bgsfcf.hashCode() : 0);
        result = 31 * result + (fzsfcf != null ? fzsfcf.hashCode() : 0);
        result = 31 * result + (gtcfsz != null ? gtcfsz.hashCode() : 0);
        result = 31 * result + (gtsfcf != null ? gtsfcf.hashCode() : 0);
        result = 31 * result + (cfjesx != null ? cfjesx.hashCode() : 0);
        result = 31 * result + (kcdybz != null ? kcdybz.hashCode() : 0);
        result = 31 * result + (isfzdm != null ? isfzdm.hashCode() : 0);
        result = 31 * result + (frbgprintzs != null ? frbgprintzs.hashCode() : 0);
        result = 31 * result + (fzsh != null ? fzsh.hashCode() : 0);
        result = 31 * result + (fzhfsh != null ? fzhfsh.hashCode() : 0);
        result = 31 * result + (szxglbf != null ? szxglbf.hashCode() : 0);
        result = 31 * result + (szxzxdh != null ? szxzxdh.hashCode() : 0);
        result = 31 * result + (zygljb != null ? zygljb.hashCode() : 0);
        result = 31 * result + (zsbhsfbl != null ? zsbhsfbl.hashCode() : 0);
        result = 31 * result + (qzsh != null ? qzsh.hashCode() : 0);
        result = 31 * result + (deletesh != null ? deletesh.hashCode() : 0);
        result = 31 * result + (bgsh != null ? bgsh.hashCode() : 0);
        result = 31 * result + (hzsh != null ? hzsh.hashCode() : 0);
        result = 31 * result + (sqbscsh != null ? sqbscsh.hashCode() : 0);
        result = 31 * result + (cmzcsh != null ? cmzcsh.hashCode() : 0);
        result = 31 * result + (oneKind != null ? oneKind.hashCode() : 0);
        result = 31 * result + (busTimes != null ? busTimes.hashCode() : 0);
        result = 31 * result + (addJgdmSmTask != null ? addJgdmSmTask.hashCode() : 0);
        result = 31 * result + (qtfmSmTask != null ? qtfmSmTask.hashCode() : 0);
        result = 31 * result + (yfmSmTask != null ? yfmSmTask.hashCode() : 0);
        result = 31 * result + (bgSmTask != null ? bgSmTask.hashCode() : 0);
        result = 31 * result + (hzSmTask != null ? hzSmTask.hashCode() : 0);
        result = 31 * result + (njSmTask != null ? njSmTask.hashCode() : 0);
        result = 31 * result + (sjjrSmTask != null ? sjjrSmTask.hashCode() : 0);
        result = 31 * result + (qtbmfmsh != null ? qtbmfmsh.hashCode() : 0);
        result = 31 * result + (yfmscsh != null ? yfmscsh.hashCode() : 0);
        result = 31 * result + (printAfterDay != null ? printAfterDay.hashCode() : 0);
        result = 31 * result + (isPunish != null ? isPunish.hashCode() : 0);
        result = 31 * result + (njqx != null ? njqx.hashCode() : 0);
        result = 31 * result + (hzqx != null ? hzqx.hashCode() : 0);
        result = 31 * result + (xsgg != null ? xsgg.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (isYwlc != null ? isYwlc.hashCode() : 0);
        result = 31 * result + (isSmTask != null ? isSmTask.hashCode() : 0);
        result = 31 * result + (mdyjs != null ? mdyjs.hashCode() : 0);
        result = 31 * result + (smqx != null ? smqx.hashCode() : 0);
        result = 31 * result + (snqrSmTask != null ? snqrSmTask.hashCode() : 0);
        result = 31 * result + (snqcSmTask != null ? snqcSmTask.hashCode() : 0);
        result = 31 * result + (sjqcSmTask != null ? sjqcSmTask.hashCode() : 0);
        result = 31 * result + (fzhfSmTask != null ? fzhfSmTask.hashCode() : 0);
        result = 31 * result + (fzSmTask != null ? fzSmTask.hashCode() : 0);
        return result;
    }
}
