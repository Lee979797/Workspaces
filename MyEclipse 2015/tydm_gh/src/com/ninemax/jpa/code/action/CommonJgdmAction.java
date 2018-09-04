/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.SerialBus;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.FtpUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yanzh
 */
public class CommonJgdmAction extends ActionSupport implements SessionAware {
    public static final String NO_DATA = "noData";
    protected static final String path = "/product/jsp/changeBZAddress/";
    protected Map<String, Object> session;
    protected List<TYwlc> ywlcs;
    protected TYwlc ywlc;
    protected Boolean isYwlc;
    protected Integer ywType = 0;
    protected Integer ywlclx;
    protected String type;
    protected Integer submitType = 0;
    protected Integer yfmType = 0;
    public Integer getYfmType() {
		return yfmType;
	} 

	public void setYfmType(Integer yfmType) {
		this.yfmType = yfmType;
	} 

	SerialBus serialBus;
    //处罚记录
    protected List<TCfjlb> cfjlbList = null;
    //需要审核标记
    protected Boolean needAudit;
    //是否已经审核
    protected Boolean audit;
    protected List<TJgdm> jgdms;
    protected Page page;
    protected TJgdm jgdm;
    protected List<TZs> tzss;
    protected TCzjl tcjl;
    protected List<TCzjl> tCzjls;
    
    public TCzjl getTcjl() {
		return tcjl;
	}

	public void setTcjl(TCzjl tcjl) {
		this.tcjl = tcjl;
	}

	public List<TZs> getTzss() {
		return tzss;
	}

	public void setTzss(List<TZs> tzss) {
		this.tzss = tzss;
	}

	public TZs getTzs() {
		return tzs;
	}

	public void setTzs(TZs tzs) {
		this.tzs = tzs;
	}

	protected TZs tzs;
	
	

	//消息头
    protected String message;
    //抬头
    protected String title;

    protected Map<String, String> jglxMap;

    protected Integer fksl;
    /**
     * 路径跳转信息
     */
    protected String source;
    /**
     * 查询的机构代码
     */
    protected String mc;
    /**
     * 当前路径
     */
    protected String currentPath = path + "";
    /**
     * 是否需要检查处罚记录
     */
    protected String checkCfjl = "";
    /*
     注销，删除，恢复原因
    */
    protected String fzyj;
    protected String fzreason;
    protected String shyj;
    protected String shresult;
    /**
     * 审核类型
     */
    protected String ywlx;

    /**
     * 办证机构代码
     */
    protected String xzqhdm;
    /**
     * 提交审核结果标着
     */
    protected String dy;
    /**
     * 迁入表的Id
     */
    protected Integer qzjgId;

    /**
     * 迁入表的省中心代码
     */
    protected String sccenter;
    protected String qcdjgdm;

    public CommonJgdmAction() {
        serialBus = new SerialBus();
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }


    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCheckCfjl() {
        return checkCfjl;
    }

    public void setCheckCfjl(String checkCfjl) {
        this.checkCfjl = checkCfjl;
    }

    public List<TCfjlb> getCfjlbList() {
        return cfjlbList;
    }

    public void setCfjlbList(List<TCfjlb> cfjlbList) {
        this.cfjlbList = cfjlbList;
    }

    public Boolean getNeedAudit() {
        return needAudit;
    }

    public void setNeedAudit(Boolean needAudit) {
        this.needAudit = needAudit;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Integer getYwlclx() {
        return ywlclx;
    }

    public void setYwlclx(Integer ywlclx) {
        this.ywlclx = ywlclx;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected boolean addCzjl(EntityManager em, TJgdm jgdm, String memo, String type, Long lsh) {
        TCzjl czjl = new TCzjl();
        User user = (User) session.get("sysUser");
        czjl.setTyshxydm(jgdm.getTyshxydm());
        czjl.setMemo(memo);
        czjl.setName(user.getUserName());
        czjl.setType(type);
        czjl.setDate(new Date());
        czjl.setXzqh(user.getBzjgdm());
        if (lsh != null)
            czjl.setKlsh(lsh);
        try {
            em.persist(czjl);
        } catch (EnumConstantNotPresentException e) {
            return false;
        }
        return true;
    }


    public String getFzyj() {
        return fzyj;
    }

    public void setFzyj(String fzyj) {
        this.fzyj = fzyj;
    }

    public String getFzreason() {
        return fzreason;
    }

    public void setFzreason(String fzreason) {
        this.fzreason = fzreason;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public Integer getQzjgId() {
        return qzjgId;
    }

    public void setQzjgId(Integer qzjgId) {
        this.qzjgId = qzjgId;
    }

    public Map<String, String> getJglxMap() {
        jglxMap = InitSysParams.jglxMap;
        return jglxMap;
    }

    public void setJglxMap(Map<String, String> jglxMap) {
        this.jglxMap = jglxMap;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSccenter() {
        return sccenter;
    }

    public void setSccenter(String sccenter) {
        this.sccenter = sccenter;
    }

    public String getQcdjgdm() {
        return qcdjgdm;
    }

    public void setQcdjgdm(String qcdjgdm) {
        this.qcdjgdm = qcdjgdm;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public String getShyj() {
        return shyj;
    }

    public void setShyj(String shyj) {
        this.shyj = shyj;
    }

    public String getShresult() {
        return shresult;
    }

    public void setShresult(String shresult) {
        this.shresult = shresult;
    }

    public Integer getFksl() {
        return fksl;
    }

    public void setFksl(Integer fksl) {
        this.fksl = fksl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsYwlc() {
        return isYwlc;
    }

    public void setIsYwlc(Boolean ywlc) {
        this.isYwlc = ywlc;
    }

    public List<TYwlc> getYwlcs() {
        return ywlcs;
    }

    public void setYwlcs(List<TYwlc> ywlcs) {
        this.ywlcs = ywlcs;
    }

    public TYwlc getYwlc() {
        return ywlc;
    }

    public void setYwlc(TYwlc ywlc) {
        this.ywlc = ywlc;
    }

    public List<TJgdm> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TJgdm> jgdms) {
        this.jgdms = jgdms;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getSubmitType() {
        return submitType;
    }

    public void setSubmitType(Integer submitType) {
        this.submitType = submitType;
    }

    protected void clearSp(EntityManager em, TJgdm jgdm, String ywlx) {
        String query = "select sp  from TSp sp where sp.tyshxydm='" + jgdm.getTyshxydm() + "' and sp.flag='1' and sp.ywlx in (" + ywlx + ") order by sp.lsh desc";
        List<TSp> tSps = em.createQuery(query).setFirstResult(0).setMaxResults(1).getResultList();
        if (tSps != null && !tSps.isEmpty()) {
            TSp sp = tSps.get(0);
            em.createQuery("update TSp set flag='2' where lsh=:lsh").setParameter("lsh", sp.getLsh()).executeUpdate();
            em.createQuery("delete from TSpdmtemp where lsh=" + sp.getGllsh() + "").executeUpdate();
        }
    }

    /**
     * 根据机构代码 和审核类型获取 审核处理的数据
     *
     * @param em
     * @param jgdm
     * @param type
     * @return
     */
    protected TSpdmtemp getSpdm(EntityManager em, String jgdm, String type) {
        String nameQuery = "select model from TSp model where model.tyshxydm='" + jgdm + "' and model.ywlx in (" + type + ") and model.flag='1' ";

        List<TSp> sps = em.createQuery(nameQuery).getResultList();
        if (sps == null || sps.isEmpty() || sps.size() > 1) {
            return null;
        }
        TSp sp = sps.get(0);
        if ("1".equals(sp.getShflag().trim())) {
            audit = true;

        } else {
            audit = false;
        }
        shyj = sp.getShreason();
        shresult = sp.getShflag().trim();
        TSpdmtemp spdm = em.find(TSpdmtemp.class, sps.get(0).getGllsh());
        fzreason = spdm.getCzreasion();
        fzyj = spdm.getCzyj();
        return spdm;
    }

    /**
     * 根据查询机构代码获取预赋码迁至数据
     */
    protected TQzjgdm getYfm(EntityManager em, String jgdm) {
        String nameQuery = "select model from TQzjgdm model where model.jgdm='" + jgdm + "' and model.qzbz='2' ";

        List<TQzjgdm> sps = em.createQuery(nameQuery).getResultList();
        if (sps == null || sps.isEmpty() || sps.size() > 1) {
            return null;
        }
        TQzjgdm sp = sps.get(0);
        //shyj = sp.getShreason();
        //shresult = sp.getShflag().trim();
        //TQzjgdm spdm = em.find(TQzjgdm.class, sps.get(0).getQzbz());
        //fzreason = spdm.getCzreason();
        //fzyj = spdm.getCzyj();
        return sp;
    }
    
    
    
    /**
     * 执行处罚检查
     *
     * @param em
     * @return
     */
    protected boolean chufa(EntityManager em) {
        if (checkCfjl == null || "yes".equals(checkCfjl)) {
            cfjlbList = em.createQuery("select model from TCfjlb model where model.jgdm='" + jgdm.getJgdm() + "' and model.cfbz=false").getResultList();
            if (cfjlbList != null && !cfjlbList.isEmpty()) {
                User user = (User) session.get("sysUser");
                if (!new TJgdmSaveBus().isBeiAn(jgdm.getJgdm(), user)) {
                    currentPath = "/product/jsp/common/cflb.jsp";
                    return true;
                }
            }
        }
        return false;
    }

    protected void addTSmrw(EntityManager em, SmTaskType type) {


        if (isrw(type)) {
            addrw(em, type);
        }
    }

    private boolean isrw(SmTaskType type) {
        TSystem system = InitSysParams.system;
        if (system.getIsSmTask())
            switch (type) {
                case 省内迁入:
                    return system.getSnqrSmTask();
                case 新增:
                    return system.getAddJgdmSmTask();
                case 其他赋码:
                    return system.getQtfmSmTask();
                case 预赋码更新:
                    return system.getAddJgdmSmTask();
                case 变更:
                    return system.getBgSmTask();
                case 换证:
                    return system.getHzSmTask();
                case 年检:
                    return system.getNjSmTask();
                case 省间迁入:
                    return system.getSjjrSmTask();
                case 省间迁出:
                    return system.getSjqcSmTask();
                case 预赋码:
                    return system.getYfmSmTask();
                case 省内迁出:
                    return system.getSnqcSmTask();
                case 注销恢复:
                    return system.getFzhfSmTask();
                case 注销:
                    return system.getFzSmTask();
            }

        return false;
    }

    private void addrw(EntityManager em, SmTaskType type) {
    	 User user = (User) session.get("sysUser");
        List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                .setParameter(1, type.getValue().toString())
                .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
                .setParameter(3, jgdm.getJgdm()).getResultList();
        if (rws.isEmpty() || rws.size() <= 0) {
            TSmrw task = new TSmrw();
            BeanUtilsEx.copyProperties(task, jgdm);
            task.setId(null);
            task.setCreateTime(new Date());
            task.setStatus(false);
            task.setType(type.getValue().toString());
            task.setCzr(user.getUserName());
            em.persist(task);
        }
      /*  if (InitSysParams.system.getQzsm() == null || !InitSysParams.system.getQzsm()) {

        } else {
            List<TQzsm> rws = em.createQuery("select model from TQzsm model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ").setParameter(1, type.getValue().toString())
                    .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
                    .setParameter(3, jgdm.getJgdm()).getResultList();
            if (!rws.isEmpty() && rws.size() > 0) {
                TQzsm qzsm = rws.get(0);
                makeDfile(em, qzsm);
            }
        }*/
    }

    private void makeDfile(EntityManager em, TQzsm task) {
        EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();
        String[] names = task.getImagePath().split("\\.")[0].split("\\\\");
        String fileName = names[names.length - 1];
        List<TArchivePage> pages = em.createQuery("select model from TArchivePage model where  model.archid=?1 order by  model.pageno ").setParameter(1, fileName).getResultList();
        String wdidbs = "";
        em.clear();
        for (TArchivePage page : pages) {
            wdidbs += (page.getPagetype() + "%");
            em.remove(page);
        }
        User user = (User) session.get("sysUser");
        DFile0 dfile = new DFile0();
        List<Integer> integers = thamsManager.createQuery("select MAX (model.did) from  DFile0 model").getResultList();
        int did;
        if (integers == null || integers.isEmpty() || integers.size() <= 0 || integers.get(0) == null) {
            did = 2;
        } else {
            did = (integers.get(0) % 2 == 1 ? (integers.get(0) + 2) : (integers.get(0) + 1));
        }
        BeanUtilsEx.copyProperties(dfile, task, 1, thamsManager, "d_file0");
        dfile.setDid(did);
        dfile.setCreator("bs_" + user.getBzjgdm().trim());
        dfile.setCreatetime(DateUtil.strToDate(DateUtil.dateToStr(task.getCreateTime())));
        dfile.setFddbr(task.getFddbr() + task.getZjhm());
        dfile.setNewdate(task.getCreateTime());
        dfile.setModifydate(DateUtil.strToDate(DateUtil.dateToStr(task.getCompleTime())));
        dfile.setArctype(SmTaskType.getDfileType(Integer.valueOf(task.getType())));
        dfile.setDocmemo(user.getBzjgdm() + "-" + DateUtil.dateToStr(new Date(), "yyyyMMdd") + dfile.getJgdm() + dfile.getJglx());
        dfile.setIsMini(wdidbs != null && wdidbs.contains("小微企业证明材料") ? 1 : 0);
        dfile.setAttr(1);
        dfile.setStatus(0);
        dfile.setPageflag(0);
        dfile.setPagesame(0);
        dfile.setScamodal(-1);
        dfile.setErrorflag(-1);
        dfile.setPid(-1);
        dfile.setQzh("-1");
        dfile.setDocid(fileName);
             /*   Map<Object,Object> a= BeanUtilsEx.describe(dfile);
                for (Map.Entry<Object,Object> s:a.entrySet()){
                    System.out.println("s.getKey()" + s.getKey() + ":" + s.getValue());
                }*/
        thamsManager.persist(dfile);
        integers = thamsManager.createQuery("select MAX (model.did) from  EFile0 model").getResultList();
        if (integers == null || integers.isEmpty() || integers.size() <= 0 || integers.get(0) == null) {
            did = 2;
        } else {
            did = (integers.get(0) % 2 == 1 ? (integers.get(0) + 2) : (integers.get(0) + 1));
        }
        EFile0 efile = new EFile0();
        efile.setDid(did);
        efile.setPid(dfile.getDid());
        efile.setEfilename(fileName + ".tif");
        efile.setTitle(task.getJgdm() + task.getJgmc());
        efile.setExt("tif");
        efile.setPzm(new FtpUtil().getSFwqpz().getPzname());
        efile.setPathname(task.getImagePath().substring(0, task.getImagePath().lastIndexOf("\\")));
        efile.setStatus(0);
        efile.setAttr(1);
        efile.setAttrex(0);
        efile.setCreator(user.getUserName());
        efile.setCreatetime(new Date());
        thamsManager.persist(efile);
        String[] imagePages = wdidbs.split("%");
        for (int i = 0; i < imagePages.length; i++) {
            did += 2;
            PFile0 pFile0 = new PFile0();
            pFile0.setDid(did);
            pFile0.setPid(dfile.getDid());
            pFile0.setPageno(i + 1);
            pFile0.setPagetype(imagePages[i]);
            thamsManager.persist(pFile0);
            thamsManager.flush();
        }
        TSmrwwc smrwwc = new TSmrwwc();
        BeanUtilsEx.copyProperties(smrwwc, task);
        smrwwc.setId(null);
        em.persist(smrwwc);
        em.remove(em.getReference(TQzsm.class,task.getId()));
        thamsManager.flush();
    }

    /**
     * 清楚对应的 不需要的审核信息
     *
     * @param em
     * @param jgdm
     * @param ywlx
     */
    protected void deleteSp(EntityManager em, String jgdm, String ywlx) {
        em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1')))")
                .setParameter("jgdm", jgdm).setParameter("ywlx", ywlx).executeUpdate();
        em.createQuery("update  TSp model set model.flag='2' where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1'))")
                .setParameter("jgdm", jgdm).setParameter("ywlx", ywlx).executeUpdate();
    }

    protected void deleteSp(EntityManager em, String jgdm) {
        em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.tyshxydm=:jgdm and model.flag='1' and model.shflag <> '1')")
                .setParameter("jgdm", jgdm).executeUpdate();
        em.createQuery("update  TSp model set model.flag='2' where model.tyshxydm=:jgdm and model.flag='1' and model.shflag <> '1'")
                .setParameter("jgdm", jgdm).executeUpdate();
    }

	public List<TCzjl> getTCzjls() {
		return tCzjls;
	}

	public void setTCzjls(List<TCzjl> tCzjls) {
		this.tCzjls = tCzjls;
	}
    
    
    /**
     * 对应清楚不需要的恢复
     * 
     */
}