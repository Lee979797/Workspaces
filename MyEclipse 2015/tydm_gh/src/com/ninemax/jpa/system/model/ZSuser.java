package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;


/**
 * ZSuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SM_ZSuser")

public class ZSuser  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String userName;
     private String userChinesename;
     private String userPassword;
     private String roleId;
     private String usergroupId;
     private String operid;
     private String lastlogin;
     private String regdate;
     private String userBranch;
     private String userIp;
     private String ipvalid;
     private String userStatus;
     private String userKind;
     private String memo;
     private String userAddress;
     private String userPhone;
     private String userBirthday;
     private String userSex;
     private String userPostid;
     private String userMobile;
     private String userFax;
     private String userEmail;
     private String userCardid;//IC
     private String userTech;
     private String userProvince;
     private String userWork;
     private String userPostkind;
     private String userLostpwshow;
     private String userShowproblem;
     private String userArticledb;
     private String issysuser;
     private String item1;
     private String item2;
     private String userEducation;
     private String userHasblog;
     private String png;
     private String userClass;
     private String userLevel;
     private String userInbrach;
     private String userCareer;//CA
     private String userPolitics;
     private String userCompanyAddress;
     private String userIcq;
     private String userNature;
     private String certId;
     private String userAvatar;
     private Long userScore;
     private String bzjgdm;
     private String zrxzqu;
     private String db;
     private String jgdm;


    // Constructors

    /** default constructor */
    public ZSuser() {
    }

	/** minimal constructor */
    public ZSuser(Integer userId, String userName, String userPassword, String usergroupId, String lastlogin, String regdate, String userStatus, String userKind, String jgdm) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.usergroupId = usergroupId;
        this.lastlogin = lastlogin;
        this.regdate = regdate;
        this.userStatus = userStatus;
        this.userKind = userKind;
        this.jgdm = jgdm;
    }
    
    /** full constructor */
    public ZSuser(Integer userId, String userName, String userChinesename, String userPassword, String roleId, String usergroupId, String operid, String lastlogin, String regdate, String userBranch, String userIp, String ipvalid, String userStatus, String userKind, String memo, String userAddress, String userPhone, String userBirthday, String userSex, String userPostid, String userMobile, String userFax, String userEmail, String userCardid, String userTech, String userProvince, String userWork, String userPostkind, String userLostpwshow, String userShowproblem, String userArticledb, String issysuser, String item1, String item2, String userEducation, String userHasblog, String png, String userClass, String userLevel, String userInbrach, String userCareer, String userPolitics, String userCompanyAddress, String userIcq, String userNature, String certId, String userAvatar, Long userScore, String bzjgdm, String zrxzqu, String db, String jgdm) {
        this.userId = userId;
        this.userName = userName;
        this.userChinesename = userChinesename;
        this.userPassword = userPassword;
        this.roleId = roleId;
        this.usergroupId = usergroupId;
        this.operid = operid;
        this.lastlogin = lastlogin;
        this.regdate = regdate;
        this.userBranch = userBranch;
        this.userIp = userIp;
        this.ipvalid = ipvalid;
        this.userStatus = userStatus;
        this.userKind = userKind;
        this.memo = memo;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userBirthday = userBirthday;
        this.userSex = userSex;
        this.userPostid = userPostid;
        this.userMobile = userMobile;
        this.userFax = userFax;
        this.userEmail = userEmail;
        this.userCardid = userCardid;
        this.userTech = userTech;
        this.userProvince = userProvince;
        this.userWork = userWork;
        this.userPostkind = userPostkind;
        this.userLostpwshow = userLostpwshow;
        this.userShowproblem = userShowproblem;
        this.userArticledb = userArticledb;
        this.issysuser = issysuser;
        this.item1 = item1;
        this.item2 = item2;
        this.userEducation = userEducation;
        this.userHasblog = userHasblog;
        this.png = png;
        this.userClass = userClass;
        this.userLevel = userLevel;
        this.userInbrach = userInbrach;
        this.userCareer = userCareer;
        this.userPolitics = userPolitics;
        this.userCompanyAddress = userCompanyAddress;
        this.userIcq = userIcq;
        this.userNature = userNature;
        this.certId = certId;
        this.userAvatar = userAvatar;
        this.userScore = userScore;
        this.bzjgdm = bzjgdm;
        this.zrxzqu = zrxzqu;
        this.db = db;
        this.jgdm = jgdm;
    }

   
    // Property accessors
    @Id
    
    @Column(name="USER_ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @Column(name="USER_NAME", unique=false, nullable=false, insertable=true, updatable=true, length=18)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="USER_CHINESENAME", unique=false, nullable=true, insertable=true, updatable=true, length=30)

    public String getUserChinesename() {
        return this.userChinesename;
    }
    
    public void setUserChinesename(String userChinesename) {
        this.userChinesename = userChinesename;
    }
    
    @Column(name="USER_PASSWORD", unique=false, nullable=false, insertable=true, updatable=true, length=70)

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name="ROLE_ID", unique=false, nullable=true, insertable=true, updatable=true, length=4)

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    @Column(name="USERGROUP_ID", unique=false, nullable=true, insertable=true, updatable=true, length=300)

    public String getUsergroupId() {
        return this.usergroupId;
    }
    
    public void setUsergroupId(String usergroupId) {
        this.usergroupId = usergroupId;
    }
    
    @Column(name="OPERID", unique=false, nullable=true, insertable=true, updatable=true, length=12)

    public String getOperid() {
        return this.operid;
    }
    
    public void setOperid(String operid) {
        this.operid = operid;
    }
    
    @Column(name="LASTLOGIN", unique=false, nullable=false, insertable=true, updatable=true, length=21)

    public String getLastlogin() {
        return this.lastlogin;
    }
    
    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }
    
    @Column(name="REGDATE", unique=false, nullable=false, insertable=true, updatable=true, length=21)

    public String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
    
    @Column(name="USER_BRANCH", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getUserBranch() {
        return this.userBranch;
    }
    
    public void setUserBranch(String userBranch) {
        this.userBranch = userBranch;
    }
    
    @Column(name="USER_IP", unique=false, nullable=true, insertable=true, updatable=true, length=15)

    public String getUserIp() {
        return this.userIp;
    }
    
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
    
    @Column(name="IPVALID", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getIpvalid() {
        return this.ipvalid;
    }
    
    public void setIpvalid(String ipvalid) {
        this.ipvalid = ipvalid;
    }
    
    @Column(name="USER_STATUS", unique=false, nullable=false, insertable=true, updatable=true, length=1)

    public String getUserStatus() {
        return this.userStatus;
    }
    
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    
    @Column(name="USER_KIND", unique=false, nullable=false, insertable=true, updatable=true, length=1)

    public String getUserKind() {
        return this.userKind;
    }
    
    public void setUserKind(String userKind) {
        this.userKind = userKind;
    }
    
    @Column(name="MEMO", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    @Column(name="USER_ADDRESS", unique=false, nullable=true, insertable=true, updatable=true, length=30)

    public String getUserAddress() {
        return this.userAddress;
    }
    
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    
    @Column(name="USER_PHONE", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    @Column(name="USER_BIRTHDAY", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getUserBirthday() {
        return this.userBirthday;
    }
    
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }
    
    @Column(name="USER_SEX", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getUserSex() {
        return this.userSex;
    }
    
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
    
    @Column(name="USER_POSTID", unique=false, nullable=true, insertable=true, updatable=true, length=6)

    public String getUserPostid() {
        return this.userPostid;
    }
    
    public void setUserPostid(String userPostid) {
        this.userPostid = userPostid;
    }
    
    @Column(name="USER_MOBILE", unique=false, nullable=true, insertable=true, updatable=true, length=11)

    public String getUserMobile() {
        return this.userMobile;
    }
    
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    
    @Column(name="USER_FAX", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserFax() {
        return this.userFax;
    }
    
    public void setUserFax(String userFax) {
        this.userFax = userFax;
    }
    
    @Column(name="USER_EMAIL", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    @Column(name="USER_CARDID", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserCardid() {
        return this.userCardid;
    }
    
    public void setUserCardid(String userCardid) {
        this.userCardid = userCardid;
    }
    
    @Column(name="USER_TECH", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getUserTech() {
        return this.userTech;
    }
    
    public void setUserTech(String userTech) {
        this.userTech = userTech;
    }
    
    @Column(name="USER_PROVINCE", unique=false, nullable=true, insertable=true, updatable=true, length=6)

    public String getUserProvince() {
        return this.userProvince;
    }
    
    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }
    
    @Column(name="USER_WORK", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getUserWork() {
        return this.userWork;
    }
    
    public void setUserWork(String userWork) {
        this.userWork = userWork;
    }
    
    @Column(name="USER_POSTKIND", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getUserPostkind() {
        return this.userPostkind;
    }
    
    public void setUserPostkind(String userPostkind) {
        this.userPostkind = userPostkind;
    }
    
    @Column(name="USER_LOSTPWSHOW", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserLostpwshow() {
        return this.userLostpwshow;
    }
    
    public void setUserLostpwshow(String userLostpwshow) {
        this.userLostpwshow = userLostpwshow;
    }
    
    @Column(name="USER_SHOWPROBLEM", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserShowproblem() {
        return this.userShowproblem;
    }
    
    public void setUserShowproblem(String userShowproblem) {
        this.userShowproblem = userShowproblem;
    }
    
    @Column(name="USER_ARTICLEDB", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getUserArticledb() {
        return this.userArticledb;
    }
    
    public void setUserArticledb(String userArticledb) {
        this.userArticledb = userArticledb;
    }
    
    @Column(name="ISSYSUSER", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getIssysuser() {
        return this.issysuser;
    }
    
    public void setIssysuser(String issysuser) {
        this.issysuser = issysuser;
    }
    
    @Column(name="ITEM1", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getItem1() {
        return this.item1;
    }
    
    public void setItem1(String item1) {
        this.item1 = item1;
    }
    
    @Column(name="ITEM2", unique=false, nullable=true, insertable=true, updatable=true, length=100)

    public String getItem2() {
        return this.item2;
    }
    
    public void setItem2(String item2) {
        this.item2 = item2;
    }
    
    @Column(name="USER_EDUCATION", unique=false, nullable=true, insertable=true, updatable=true, length=20)

    public String getUserEducation() {
        return this.userEducation;
    }
    
    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }
    
    @Column(name="USER_HASBLOG", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getUserHasblog() {
        return this.userHasblog;
    }
    
    public void setUserHasblog(String userHasblog) {
        this.userHasblog = userHasblog;
    }
    
    @Column(name="PNG", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getPng() {
        return this.png;
    }
    
    public void setPng(String png) {
        this.png = png;
    }
    
    @Column(name="USER_CLASS", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getUserClass() {
        return this.userClass;
    }
    
    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }
    
    @Column(name="USER_LEVEL", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getUserLevel() {
        return this.userLevel;
    }
    
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
    
    @Column(name="USER_INBRACH", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getUserInbrach() {
        return this.userInbrach;
    }
    
    public void setUserInbrach(String userInbrach) {
        this.userInbrach = userInbrach;
    }
    
    @Column(name="USER_CAREER", unique=false, nullable=true, insertable=true, updatable=true, length=50)

    public String getUserCareer() {
        return this.userCareer;
    }
    
    public void setUserCareer(String userCareer) {
        this.userCareer = userCareer;
    }
    
    @Column(name="USER_POLITICS", unique=false, nullable=true, insertable=true, updatable=true, length=2)

    public String getUserPolitics() {
        return this.userPolitics;
    }
    
    public void setUserPolitics(String userPolitics) {
        this.userPolitics = userPolitics;
    }
    
    @Column(name="USER_COMPANY_ADDRESS", unique=false, nullable=true, insertable=true, updatable=true, length=200)

    public String getUserCompanyAddress() {
        return this.userCompanyAddress;
    }
    
    public void setUserCompanyAddress(String userCompanyAddress) {
        this.userCompanyAddress = userCompanyAddress;
    }
    
    @Column(name="USER_ICQ", unique=false, nullable=true, insertable=true, updatable=true, length=40)

    public String getUserIcq() {
        return this.userIcq;
    }
    
    public void setUserIcq(String userIcq) {
        this.userIcq = userIcq;
    }
    
    @Column(name="USER_NATURE", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getUserNature() {
        return this.userNature;
    }
    
    public void setUserNature(String userNature) {
        this.userNature = userNature;
    }
    
    @Column(name="CERT_ID", unique=false, nullable=true, insertable=true, updatable=true, length=80)

    public String getCertId() {
        return this.certId;
    }
    
    public void setCertId(String certId) {
        this.certId = certId;
    }
    
    @Column(name="USER_AVATAR", unique=false, nullable=true, insertable=true, updatable=true, length=1000)

    public String getUserAvatar() {
        return this.userAvatar;
    }
    
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
    
    @Column(name="USER_SCORE", unique=false, nullable=true, insertable=true, updatable=true, precision=18, scale=0)

    public Long getUserScore() {
        return this.userScore;
    }
    
    public void setUserScore(Long userScore) {
        this.userScore = userScore;
    }
    
    @Column(name="bzjgdm", unique=false, nullable=true, insertable=true, updatable=true, length=10)

    public String getBzjgdm() {
        return this.bzjgdm;
    }
    
    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }
    
    @Column(name="zrxzqu", unique=false, nullable=true, insertable=true, updatable=true, length=200)

    public String getZrxzqu() {
        return this.zrxzqu;
    }
    
    public void setZrxzqu(String zrxzqu) {
        this.zrxzqu = zrxzqu;
    }
    
    @Column(name="db", unique=false, nullable=true, insertable=true, updatable=true, length=1)

    public String getDb() {
        return this.db;
    }
    
    public void setDb(String db) {
        this.db = db;
    }
    
    @Column(name="jgdm", unique=false, nullable=false, insertable=true, updatable=true, length=11)

    public String getJgdm() {
        return this.jgdm;
    }
    
    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }
   








}