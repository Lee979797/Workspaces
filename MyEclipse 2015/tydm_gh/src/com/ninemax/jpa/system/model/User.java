package com.ninemax.jpa.system.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * User: yzhhui
 * Date: 13-4-10
 * Time: ÉÏÎç10:54
 */
@javax.persistence.Table(name = "SM_USERMANAGE")
@Entity
public class User implements Serializable{
    private Integer userId;

    @javax.persistence.Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
     public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private String userName;

    @javax.persistence.Column(name = "USER_NAME")
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userChinesename;

    @javax.persistence.Column(name = "USER_CHINESENAME")
    @Basic
    public String getUserChinesename() {
        return userChinesename;
    }

    public void setUserChinesename(String userChinesename) {
        this.userChinesename = userChinesename;
    }

    private String userPassword;

    @javax.persistence.Column(name = "USER_PASSWORD")
    @Basic
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String roleId;

    @javax.persistence.Column(name = "ROLE_ID")
    @Basic
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    private String usergroupId;

    @javax.persistence.Column(name = "USERGROUP_ID")
    @Basic
    public String getUsergroupId() {
        return usergroupId;
    }

    public void setUsergroupId(String usergroupId) {
        this.usergroupId = usergroupId;
    }

    private String operid;

    @javax.persistence.Column(name = "OPERID")
    @Basic
    public String getOperid() {
        return operid;
    }

    public void setOperid(String operid) {
        this.operid = operid;
    }

    private String lastlogin;

    @javax.persistence.Column(name = "LASTLOGIN")
    @Basic
    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    private String regdate;

    @javax.persistence.Column(name = "REGDATE")
    @Basic
    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    private String userBranch;

    @javax.persistence.Column(name = "USER_BRANCH")
    @Basic
    public String getUserBranch() {
        return userBranch;
    }

    public void setUserBranch(String userBranch) {
        this.userBranch = userBranch;
    }

    private String userIp;

    @javax.persistence.Column(name = "USER_IP")
    @Basic
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    private String ipvalid;

    @javax.persistence.Column(name = "IPVALID")
    @Basic
    public String getIpvalid() {
        return ipvalid;
    }

    public void setIpvalid(String ipvalid) {
        this.ipvalid = ipvalid;
    }

    private String userStatus;

    @javax.persistence.Column(name = "USER_STATUS")
    @Basic
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    private String userKind;

    @javax.persistence.Column(name = "USER_KIND")
    @Basic
    public String getUserKind() {
        return userKind;
    }

    public void setUserKind(String userKind) {
        this.userKind = userKind;
    }

    private String memo;

    @javax.persistence.Column(name = "MEMO")
    @Basic
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    private String userAddress;

    @javax.persistence.Column(name = "USER_ADDRESS")
    @Basic
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    private String userPhone;

    @javax.persistence.Column(name = "USER_PHONE")
    @Basic
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    private String userBirthday;

    @javax.persistence.Column(name = "USER_BIRTHDAY")
    @Basic
    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    private String userSex;

    @javax.persistence.Column(name = "USER_SEX")
    @Basic
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    private String userPostid;

    @javax.persistence.Column(name = "USER_POSTID")
    @Basic
    public String getUserPostid() {
        return userPostid;
    }

    public void setUserPostid(String userPostid) {
        this.userPostid = userPostid;
    }

    private String userMobile;

    @javax.persistence.Column(name = "USER_MOBILE")
    @Basic
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    private String userFax;

    @javax.persistence.Column(name = "USER_FAX")
    @Basic
    public String getUserFax() {
        return userFax;
    }

    public void setUserFax(String userFax) {
        this.userFax = userFax;
    }

    private String userEmail;

    @javax.persistence.Column(name = "USER_EMAIL")
    @Basic
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String userCardid;

    @javax.persistence.Column(name = "USER_CARDID")
    @Basic
    public String getUserCardid() {
        return userCardid;
    }

    public void setUserCardid(String userCardid) {
        this.userCardid = userCardid;
    }

    private String userTech;

    @javax.persistence.Column(name = "USER_TECH")
    @Basic
    public String getUserTech() {
        return userTech;
    }

    public void setUserTech(String userTech) {
        this.userTech = userTech;
    }

    private String userProvince;

    @javax.persistence.Column(name = "USER_PROVINCE")
    @Basic
    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    private String userWork;

    @javax.persistence.Column(name = "USER_WORK")
    @Basic
    public String getUserWork() {
        return userWork;
    }

    public void setUserWork(String userWork) {
        this.userWork = userWork;
    }

    private String userPostkind;

    @javax.persistence.Column(name = "USER_POSTKIND")
    @Basic
    public String getUserPostkind() {
        return userPostkind;
    }

    public void setUserPostkind(String userPostkind) {
        this.userPostkind = userPostkind;
    }

    private String userLostpwshow;

    @javax.persistence.Column(name = "USER_LOSTPWSHOW")
    @Basic
    public String getUserLostpwshow() {
        return userLostpwshow;
    }

    public void setUserLostpwshow(String userLostpwshow) {
        this.userLostpwshow = userLostpwshow;
    }

    private String userShowproblem;

    @javax.persistence.Column(name = "USER_SHOWPROBLEM")
    @Basic
    public String getUserShowproblem() {
        return userShowproblem;
    }

    public void setUserShowproblem(String userShowproblem) {
        this.userShowproblem = userShowproblem;
    }

    private String userArticledb;

    @javax.persistence.Column(name = "USER_ARTICLEDB")
    @Basic
    public String getUserArticledb() {
        return userArticledb;
    }

    public void setUserArticledb(String userArticledb) {
        this.userArticledb = userArticledb;
    }

    private String issysuser;

    @javax.persistence.Column(name = "ISSYSUSER")
    @Basic
    public String getIssysuser() {
        return issysuser;
    }

    public void setIssysuser(String issysuser) {
        this.issysuser = issysuser;
    }

    private String item1;

    @javax.persistence.Column(name = "ITEM1")
    @Basic
    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    private String item2;

    @javax.persistence.Column(name = "ITEM2")
    @Basic
    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    private String userEducation;

    @javax.persistence.Column(name = "USER_EDUCATION")
    @Basic
    public String getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }

    private String userHasblog;

    @javax.persistence.Column(name = "USER_HASBLOG")
    @Basic
    public String getUserHasblog() {
        return userHasblog;
    }

    public void setUserHasblog(String userHasblog) {
        this.userHasblog = userHasblog;
    }

    private String png;

    @javax.persistence.Column(name = "PNG")
    @Basic
    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    private String userClass;

    @javax.persistence.Column(name = "USER_CLASS")
    @Basic
    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    private String userLevel;

    @javax.persistence.Column(name = "USER_LEVEL")
    @Basic
    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    private String userInbrach;

    @javax.persistence.Column(name = "USER_INBRACH")
    @Basic
    public String getUserInbrach() {
        return userInbrach;
    }

    public void setUserInbrach(String userInbrach) {
        this.userInbrach = userInbrach;
    }

    private String userCareer;

    @javax.persistence.Column(name = "USER_CAREER")
    @Basic
    public String getUserCareer() {
        return userCareer;
    }

    public void setUserCareer(String userCareer) {
        this.userCareer = userCareer;
    }

    private String userPolitics;

    @javax.persistence.Column(name = "USER_POLITICS")
    @Basic
    public String getUserPolitics() {
        return userPolitics;
    }

    public void setUserPolitics(String userPolitics) {
        this.userPolitics = userPolitics;
    }

    private String userCompanyAddress;

    @javax.persistence.Column(name = "USER_COMPANY_ADDRESS")
    @Basic
    public String getUserCompanyAddress() {
        return userCompanyAddress;
    }

    public void setUserCompanyAddress(String userCompanyAddress) {
        this.userCompanyAddress = userCompanyAddress;
    }

    private String userIcq;

    @javax.persistence.Column(name = "USER_ICQ")
    @Basic
    public String getUserIcq() {
        return userIcq;
    }

    public void setUserIcq(String userIcq) {
        this.userIcq = userIcq;
    }

    private String userNature;

    @javax.persistence.Column(name = "USER_NATURE")
    @Basic
    public String getUserNature() {
        return userNature;
    }

    public void setUserNature(String userNature) {
        this.userNature = userNature;
    }

    private String certId;

    @javax.persistence.Column(name = "CERT_ID")
    @Basic
    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    private String userAvatar;

    @javax.persistence.Column(name = "USER_AVATAR")
    @Basic
    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    private Integer userScore;

    @javax.persistence.Column(name = "USER_SCORE")
    @Basic
    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "bzjgdm")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }
    private Integer yqsj;

    @javax.persistence.Column(name = "yqsj")
    @Basic
    public Integer getYqsj() {
        return yqsj;
    }

    public void setYqsj(Integer yqsj) {
        this.yqsj = yqsj;
    }

    private String zrxzqu;

    @javax.persistence.Column(name = "zrxzqu")
    @Basic
    public String getZrxzqu() {
        return zrxzqu;
    }

    public void setZrxzqu(String zrxzqu) {
        this.zrxzqu = zrxzqu;
    }

    private String db;

    @javax.persistence.Column(name = "db")
    @Basic
    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    private String cncode;

    @javax.persistence.Column(name = "cncode")
    @Basic
    public String getCncode() {
        return cncode;
    }

    public void setCncode(String cncode) {
        this.cncode = cncode;
    }

    private String iccade;

    @javax.persistence.Column(name = "iccade")
    @Basic
    public String getIccade() {
        return iccade;
    }

    public void setIccade(String iccade) {
        this.iccade = iccade;
    }

    private String zsbhpre;

    @javax.persistence.Column(name = "zsbhpre")
    @Basic
    public String getZsbhpre() {
        return zsbhpre;
    }

    public void setZsbhpre(String zsbhpre) {
        this.zsbhpre = zsbhpre;
    }

    private String zsbhpreFb;

    @javax.persistence.Column(name = "zsbhpre_fb")
    @Basic
    public String getZsbhpreFb() {
        return zsbhpreFb;
    }

    public void setZsbhpreFb(String zsbhpreFb) {
        this.zsbhpreFb = zsbhpreFb;
    }

    private Integer cfbz;

    @javax.persistence.Column(name = "cfbz")
    @Basic
    public Integer getCfbz() {
        return cfbz;
    }

    public void setCfbz(Integer cfbz) {
        this.cfbz = cfbz;
    }

    private Boolean needScan;

    @javax.persistence.Column(name = "needScan")
    @Basic
  public  Boolean getNeedScan() {
        return needScan;
    }

    public void setNeedScan(Boolean needScan) {
        this.needScan = needScan;
    }

    private String printName;

    @javax.persistence.Column(name = "printName")
    @Basic
    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    private Integer offsetx;

    @javax.persistence.Column(name = "offsetx")
    @Basic
    public Integer getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(Integer offsetx) {
        this.offsetx = offsetx;
    }

    private Integer offsety;

    @javax.persistence.Column(name = "offsety")
    @Basic
    public Integer getOffsety() {
        return offsety;
    }

    public void setOffsety(Integer offsety) {
        this.offsety = offsety;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (bzjgdm != null ? !bzjgdm.equals(user.bzjgdm) : user.bzjgdm != null) return false;
        if (certId != null ? !certId.equals(user.certId) : user.certId != null) return false;
        if (cfbz != null ? !cfbz.equals(user.cfbz) : user.cfbz != null) return false;
        if (cncode != null ? !cncode.equals(user.cncode) : user.cncode != null) return false;
        if (db != null ? !db.equals(user.db) : user.db != null) return false;
        if (iccade != null ? !iccade.equals(user.iccade) : user.iccade != null) return false;
        if (ipvalid != null ? !ipvalid.equals(user.ipvalid) : user.ipvalid != null) return false;
        if (issysuser != null ? !issysuser.equals(user.issysuser) : user.issysuser != null) return false;
        if (item1 != null ? !item1.equals(user.item1) : user.item1 != null) return false;
        if (item2 != null ? !item2.equals(user.item2) : user.item2 != null) return false;
        if (lastlogin != null ? !lastlogin.equals(user.lastlogin) : user.lastlogin != null) return false;
        if (memo != null ? !memo.equals(user.memo) : user.memo != null) return false;
        if (needScan != null ? !needScan.equals(user.needScan) : user.needScan != null) return false;
        if (offsetx != null ? !offsetx.equals(user.offsetx) : user.offsetx != null) return false;
        if (offsety != null ? !offsety.equals(user.offsety) : user.offsety != null) return false;
        if (operid != null ? !operid.equals(user.operid) : user.operid != null) return false;
        if (png != null ? !png.equals(user.png) : user.png != null) return false;
        if (printName != null ? !printName.equals(user.printName) : user.printName != null) return false;
        if (regdate != null ? !regdate.equals(user.regdate) : user.regdate != null) return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;
        if (userAddress != null ? !userAddress.equals(user.userAddress) : user.userAddress != null) return false;
        if (userArticledb != null ? !userArticledb.equals(user.userArticledb) : user.userArticledb != null)
            return false;
        if (userAvatar != null ? !userAvatar.equals(user.userAvatar) : user.userAvatar != null) return false;
        if (userBirthday != null ? !userBirthday.equals(user.userBirthday) : user.userBirthday != null) return false;
        if (userBranch != null ? !userBranch.equals(user.userBranch) : user.userBranch != null) return false;
        if (userCardid != null ? !userCardid.equals(user.userCardid) : user.userCardid != null) return false;
        if (userCareer != null ? !userCareer.equals(user.userCareer) : user.userCareer != null) return false;
        if (userChinesename != null ? !userChinesename.equals(user.userChinesename) : user.userChinesename != null)
            return false;
        if (userClass != null ? !userClass.equals(user.userClass) : user.userClass != null) return false;
        if (userCompanyAddress != null ? !userCompanyAddress.equals(user.userCompanyAddress) : user.userCompanyAddress != null)
            return false;
        if (userEducation != null ? !userEducation.equals(user.userEducation) : user.userEducation != null)
            return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (userFax != null ? !userFax.equals(user.userFax) : user.userFax != null) return false;
        if (userHasblog != null ? !userHasblog.equals(user.userHasblog) : user.userHasblog != null) return false;
        if (userIcq != null ? !userIcq.equals(user.userIcq) : user.userIcq != null) return false;
        if (userInbrach != null ? !userInbrach.equals(user.userInbrach) : user.userInbrach != null) return false;
        if (userIp != null ? !userIp.equals(user.userIp) : user.userIp != null) return false;
        if (userKind != null ? !userKind.equals(user.userKind) : user.userKind != null) return false;
        if (userLevel != null ? !userLevel.equals(user.userLevel) : user.userLevel != null) return false;
        if (userLostpwshow != null ? !userLostpwshow.equals(user.userLostpwshow) : user.userLostpwshow != null)
            return false;
        if (userMobile != null ? !userMobile.equals(user.userMobile) : user.userMobile != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userNature != null ? !userNature.equals(user.userNature) : user.userNature != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userPhone != null ? !userPhone.equals(user.userPhone) : user.userPhone != null) return false;
        if (userPolitics != null ? !userPolitics.equals(user.userPolitics) : user.userPolitics != null) return false;
        if (userPostid != null ? !userPostid.equals(user.userPostid) : user.userPostid != null) return false;
        if (userPostkind != null ? !userPostkind.equals(user.userPostkind) : user.userPostkind != null) return false;
        if (userProvince != null ? !userProvince.equals(user.userProvince) : user.userProvince != null) return false;
        if (userScore != null ? !userScore.equals(user.userScore) : user.userScore != null) return false;
        if (userSex != null ? !userSex.equals(user.userSex) : user.userSex != null) return false;
        if (userShowproblem != null ? !userShowproblem.equals(user.userShowproblem) : user.userShowproblem != null)
            return false;
        if (userStatus != null ? !userStatus.equals(user.userStatus) : user.userStatus != null) return false;
        if (userTech != null ? !userTech.equals(user.userTech) : user.userTech != null) return false;
        if (userWork != null ? !userWork.equals(user.userWork) : user.userWork != null) return false;
        if (usergroupId != null ? !usergroupId.equals(user.usergroupId) : user.usergroupId != null) return false;
        if (zrxzqu != null ? !zrxzqu.equals(user.zrxzqu) : user.zrxzqu != null) return false;
        if (zsbhpre != null ? !zsbhpre.equals(user.zsbhpre) : user.zsbhpre != null) return false;
        if (zsbhpreFb != null ? !zsbhpreFb.equals(user.zsbhpreFb) : user.zsbhpreFb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userChinesename != null ? userChinesename.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (usergroupId != null ? usergroupId.hashCode() : 0);
        result = 31 * result + (operid != null ? operid.hashCode() : 0);
        result = 31 * result + (lastlogin != null ? lastlogin.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        result = 31 * result + (userBranch != null ? userBranch.hashCode() : 0);
        result = 31 * result + (userIp != null ? userIp.hashCode() : 0);
        result = 31 * result + (ipvalid != null ? ipvalid.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (userKind != null ? userKind.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userBirthday != null ? userBirthday.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userPostid != null ? userPostid.hashCode() : 0);
        result = 31 * result + (userMobile != null ? userMobile.hashCode() : 0);
        result = 31 * result + (userFax != null ? userFax.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userCardid != null ? userCardid.hashCode() : 0);
        result = 31 * result + (userTech != null ? userTech.hashCode() : 0);
        result = 31 * result + (userProvince != null ? userProvince.hashCode() : 0);
        result = 31 * result + (userWork != null ? userWork.hashCode() : 0);
        result = 31 * result + (userPostkind != null ? userPostkind.hashCode() : 0);
        result = 31 * result + (userLostpwshow != null ? userLostpwshow.hashCode() : 0);
        result = 31 * result + (userShowproblem != null ? userShowproblem.hashCode() : 0);
        result = 31 * result + (userArticledb != null ? userArticledb.hashCode() : 0);
        result = 31 * result + (issysuser != null ? issysuser.hashCode() : 0);
        result = 31 * result + (item1 != null ? item1.hashCode() : 0);
        result = 31 * result + (item2 != null ? item2.hashCode() : 0);
        result = 31 * result + (userEducation != null ? userEducation.hashCode() : 0);
        result = 31 * result + (userHasblog != null ? userHasblog.hashCode() : 0);
        result = 31 * result + (png != null ? png.hashCode() : 0);
        result = 31 * result + (userClass != null ? userClass.hashCode() : 0);
        result = 31 * result + (userLevel != null ? userLevel.hashCode() : 0);
        result = 31 * result + (userInbrach != null ? userInbrach.hashCode() : 0);
        result = 31 * result + (userCareer != null ? userCareer.hashCode() : 0);
        result = 31 * result + (userPolitics != null ? userPolitics.hashCode() : 0);
        result = 31 * result + (userCompanyAddress != null ? userCompanyAddress.hashCode() : 0);
        result = 31 * result + (userIcq != null ? userIcq.hashCode() : 0);
        result = 31 * result + (userNature != null ? userNature.hashCode() : 0);
        result = 31 * result + (certId != null ? certId.hashCode() : 0);
        result = 31 * result + (userAvatar != null ? userAvatar.hashCode() : 0);
        result = 31 * result + (userScore != null ? userScore.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (zrxzqu != null ? zrxzqu.hashCode() : 0);
        result = 31 * result + (db != null ? db.hashCode() : 0);
        result = 31 * result + (cncode != null ? cncode.hashCode() : 0);
        result = 31 * result + (iccade != null ? iccade.hashCode() : 0);
        result = 31 * result + (zsbhpre != null ? zsbhpre.hashCode() : 0);
        result = 31 * result + (zsbhpreFb != null ? zsbhpreFb.hashCode() : 0);
        result = 31 * result + (cfbz != null ? cfbz.hashCode() : 0);
        result = 31 * result + (needScan != null ? needScan.hashCode() : 0);
        result = 31 * result + (printName != null ? printName.hashCode() : 0);
        result = 31 * result + (offsetx != null ? offsetx.hashCode() : 0);
        result = 31 * result + (offsety != null ? offsety.hashCode() : 0);
        return result;
    }
}
