package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-25
 * Time: 下午2:57
 */
public class BusHandleAction extends ActionSupport implements SessionAware {
    protected static Logger log = Logger.getLogger(BusHandleAction.class);
    private Map<String, Object> session;
    private String ywlsh;
    private String jgdm;
    private String ywlx;
    private String isend;
    private String message;
    private String currentPath;

    private TywlcBus ywlcBus;
    private TywlcLogBus ywlcLogBus;
    private TywlcLxBus lxBus;
    private Page page;
    private List<TYwlc> ywlcList;
    private String xzqh;
    
    private String url;
    private String startDate;
    private String endDate;
    private String userName;

    public BusHandleAction() {
        ywlcBus = new TywlcBus();
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String ywcz(){
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	TYwlc tYwlc = em.find(TYwlc.class, ywlsh.trim());
    	TJgdm jgdm2 = em.find(TJgdm.class, tYwlc.getJgdm().trim());
    	User user = (User) session.get("sysUser");
    	currentPath="/product/jsp/qd_jsp/success.jsp";
    	if(tYwlc!=null&&jgdm2!=null){
    		if(ywlx.equals("1")){//打证
    			if(jgdm2.getDybz().equals("1")){
    				message="该办证机构证书已打印!";
    			}else{
    				url="/bsweb/certificatePrint_zb_info.action?jgdm.jgdm="+jgdm2.getJgdm();
    			}
    		}else if(ywlx.equals("2")){//变更
    			if(jgdm2.getDybz().equals("1")){
    				url="/bsweb/business_search.action?mc="+jgdm2.getJgdm()+"&type=update_no&source=update_no&bzjgdm="+user.getBzjgdm()+"&needAudit=false&audit=false&checkCfjl=yes&ywlx=17&dzch=";
    			}else{
    				message="该办证机构还未打印证书,请打印证书后再进行变更!";
    			}
    		}else if(ywlx.equals("3")){//换证
    			if(jgdm2.getDybz().equals("1")){
    				url="/bsweb/certificate_search.action?jgdm="+jgdm2.getJgdm()+"&source=certChange&dzch=undefined&bzjgdm="+user.getBzjgdm()+"&pageno=0&rowNumsView=20";
    			}else{
    				message="该办证机构还未打印证书,请打印证书后再进行换证!";
    			}
    		}else if(ywlx.equals("4")){//申请表修改
    			if(jgdm2.getDybz().equals("1")){
    				message="该办证机构证书已打印,修改请到变更换证!";
    			}else{
    				url="/bsweb/certificate_search.action?jgdm="+jgdm2.getJgdm()+"&source=update&bzjgdm="+user.getBzjgdm()+"&pageno=1&rowNumsView=20&sourceTable=t_jgdm";
    			}
    		}
    	}else{
    		message="未找到对应记录,请检查是否正确!";
    	}
    	EntityManagerHelper.closeEntityManager();
    	return SUCCESS;
    }
    public String sel() {
    	/*
        ywlcLogBus = new TywlcLogBus();
        List<TYwlcLog> list = ywlcLogBus.findList(ywlsh, jgdm);
        if (list != null && list.size() > 0) {
            String ywName = "";
            TYwlcLog ywlcLog = list.get(0);
            if (ywlcLog != null) {
                ywlcLog.getYwlclx();
                lxBus = new TywlcLxBus();
                List<TYwlcLx> lxList = lxBus.getTywlcLx(ywlcLog.getYwlclx());
                if (lxList != null && lxList.size() > 0) {
                    TYwlcLx lx = lxList.get(0);
                    ywName = lx.getCzlxmc();
                }
                if ("2".equals(ywlcLog.getIsend())) {
                    message = "业务流程" + ywName + "已经做完!";
                } else {
                    message = "业务流程" + ywName + "正在进行" + ywlcLog.getType() + "操作";
                }
            }
        } else {
            message = "需要查询的业务不存在!业务流水号或机构代码错误!";
        }
        return this.SUCCESS;
        */
        return new ActionUtils() {
    		@Override
    		protected void excute() throws Exception {
    			HttpSession session = ServletActionContext.getRequest().getSession();
    			if (page == null) {
    				page = new Page();
    			}
    			if(url==null||url.equals("")){
    			User user = (User) session.getAttribute("sysUser");
    			String sql="from TYwlc where "+sql(user);
    			if(ywlsh!=null&&ywlsh.length()>0){
    				sql+=" and ywlsh like '%"+ywlsh+"%'";
    			}
    			if(jgdm!=null&&jgdm.length()>0){
    				sql+=" and jgdm = '"+jgdm+"'";
    			}
    			if(ywlx!=null&&ywlx.length()>0){
    				sql+=" and ywlclx = '"+ywlx+"'";
    			}
    			if(isend!=null&&isend.length()>0&&!isend.equals("3")){
    				if(isend.equals("1")){
    					sql+=" and isend in ('0','1')";
    				}else{
    				sql+=" and isend = '"+isend+"'";
    				}
    			}
    			if(isend!=null&&isend.length()>0&&isend.equals("3")){
    				sql+=" and jgdm='' and jgmc=''";
    			}
    			if(startDate!=null&&startDate.length()>0){
    				sql+=" and clsj>='"+startDate+"'";
    			}
    			if(endDate!=null&&endDate.length()>0){
    				sql+=" and clsj<='"+endDate+" 23:00:00'";
    			}
    			if(userName!=null&&userName.length()>0){
    				sql+=" and userName like '%"+userName+"%'";
    			}
    			String order=" order by ywlsh asc";
    			ywlcList = em.createQuery(sql +order) .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize()).getResultList();
    			page.setTotalRecord(((Long) em.createQuery("select count(ywlsh) "+sql)
    					.getResultList().get(0)).intValue());
    			}
    			currentPath ="/product/jsp/qd_jsp/ywcxList.jsp";
    		}
    	}.template();
    }

    public String revocation() {
        ywlcBus = new TywlcBus();
        ywlcLogBus = new TywlcLogBus();
        TYwlc tYwlc = ywlcBus.findByYwlsh(ywlsh);
        if (tYwlc != null) {
            //只有刚受理的业务即isend是0的业务才可以进行受理，并且不是新办业务即业务流程类型是1，2,4的业务流程
            if ("0".equals(tYwlc.getIsend()) && (!"1".equals(tYwlc.getYwlclx()) || !"2".equals(tYwlc.getYwlclx()) || !"4".equals(tYwlc.getYwlclx()))) {
                boolean flag = ywlcBus.delYwlcDataByYwlsh(ywlsh);
                if (flag) {
                    message = "业务撤销成功!";
                } else
                    message = "业务撤销过程中发生异常!";
            } else
                message = "您要撤销的业务不能进行受理！";
        } else {
            message = "需要撤销的业务不存在!业务流水号错误!";
        }
        return this.SUCCESS;
    }

    public String handle() {
        User user = (User) session.get("sysUser");
        String bzjgdm = user.getBzjgdm();

        TYwlc ywlc;
        String jgmc = "";
        TJgdmSave save = null;
        log.info("handle:" + ywlx + ":" + jgdm);
        //如果是预赋码修改或预防码颁证去t_jgdm_save中判断;如果是代码恢复，首先去注销库里面判断机构代码是否存在;其它业务类型去t_jgdm表中判断
        if ("3".equals(ywlx) || "5".equals(ywlx) || "17".equals(ywlx)) {
            save = new TJgdmSaveBus().findByJgdm(jgdm);
            if (save == null) {
                message = "业务不能进行受理!机构代码不存在!";
                return this.SUCCESS;
            } else {
                if (!bzjgdm.equals(save.getBzjgdm())) {
                    message = "业务不能进行受理!机构代码不属于办证机构,请到相关单位（" + InitSysParams.zrxzqhMap.get(save.getBzjgdm()) + "）办理!";
                    return this.SUCCESS;
                } else {
                    jgmc = save.getJgmc();
                    if (!verifyBus(bzjgdm)) {
                        return this.SUCCESS;
                    }
                }
            }
        }else if ("1".equals(ywlx)) {
        	jgdm="";
        	jgmc="";
        }else if("16".equals(ywlx)){ 
        	jgmc="";
        }else if ("8".equals(ywlx)) {
            TFzdm fzdm = new TFzdmBus().findById(jgdm);
            if (fzdm == null) {
                message = "业务不能进行受理!机构代码不存在!";
                return this.SUCCESS;
            } else {
                if (!bzjgdm.equals(fzdm.getBzjgdm())) {
                    message = "业务不能进行受理!机构代码不属于办证机构,请到相关单位（" + InitSysParams.zrxzqhMap.get(fzdm.getBzjgdm()) + "）办理!";
                    return this.SUCCESS;
                } else {
                    jgmc = fzdm.getJgmc();
                    if (!verifyBus(bzjgdm)) {
                        return this.SUCCESS;
                    }
                }
            }

        } else if ("18".equals(ywlx)) {
            TQzjgdm qzjgdm = new TQzjgdmBus().getQzjgdm(jgdm);
            if (qzjgdm == null) {
                message = "业务不能进行受理!机构代码不存在!";
                return this.SUCCESS;
            } else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
                message = "机构代码（" + jgdm + "）不属于当前办证机构，请到（" + InitSysParams.zrxzqhMap.get(qzjgdm.getXzqh()) + "）处办理业务!";
                return this.SUCCESS;
            } else {
                jgmc = qzjgdm.getJgmc();
                if (!verifyBus(bzjgdm)) {
                    return this.SUCCESS;
                }
            }

        } else if ("19".equals(ywlx)) {
            log.info("TQzjgdm:"+jgdm);
            TQzjgdm qzjgdm = new TQzjgdmBus().getQzjgdmByJgdm(jgdm);
            if (qzjgdm == null) {
                message = "业务不能进行受理!机构代码不存在!";
                return this.SUCCESS;
            } else if (qzjgdm.getQrdbzjgdm() == null || !qzjgdm.getQrdbzjgdm().equals(bzjgdm)) {
                message = "机构代码（" + jgdm + "）不属于当前办证机构，请到（" + InitSysParams.zrxzqhMap.get(qzjgdm.getQrdbzjgdm()) + "）处办理业务!";
                return this.SUCCESS;
            } else {
                jgmc = qzjgdm.getJgmc();
                if (!verifyBus(bzjgdm)) {
                    return this.SUCCESS;
                }
            }

        }  else if ("20".equals(ywlx) || "21".equals(ywlx)) {
            log.info("TQzjgdm:"+jgdm);
            TQzjgdm qzjgdm = new TQzjgdmBus().getQzjgdmByJgdm(jgdm);
            if (qzjgdm == null) {
                message = "业务不能进行受理!机构代码不存在!";
                return this.SUCCESS;
            } else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
                message = "机构代码（" + jgdm + "）不属于当前办证机构，请到（" + InitSysParams.zrxzqhMap.get(qzjgdm.getBzjgdm()) + "）处办理业务!";
                return this.SUCCESS;
            } else {
                jgmc = qzjgdm.getJgmc();
                if (!verifyBus(bzjgdm)) {
                    return this.SUCCESS;
                }
            }

        } else {
            TJgdm tJgdm = new TjgdmBus().findById(jgdm);
            if (tJgdm == null) {
                message = "业务不能进行受理!机构代码不存在!";
                return this.SUCCESS;
            } else if (!bzjgdm.equals(tJgdm.getBzjgdm())) {
                message = "业务不能进行受理!机构代码不属于这个办证机构!";
                return this.SUCCESS;
            } else {
                jgmc = tJgdm.getJgmc();
                if (!verifyBus(bzjgdm)) {
                    return this.SUCCESS;
                }
            }
        }
        

        //受理成功插入到业务流程及业务流程日志表
        if(xzqh==null||xzqh.length()!=6){
        	xzqh=bzjgdm;
        }
        String sid=ywlcBus.getMaxLsh(xzqh);
        String id="";
        
        /*
        String[] array = ywlcBus.getMaxId();
        String maxId = "";
        String id = "";
        if (array != null && array.length == 2)

        {
            maxId = array[0];
            id = array[1];
        } else

        {
            message = "不能取得业务号!数据库异常!";
            return this.SUCCESS;
        }
        *
        */
        if(sid.equals("")){
        	  message = "不能取得业务号!数据库异常!";
              return this.SUCCESS;
        }
        //String sid = DateUtil.getCurrentDateTime().substring(0, 4) + maxId;
        boolean flag = ywlcBus.handleBus(sid, id, bzjgdm, ywlx, jgmc, jgdm,user.getUserName());
        if (!flag) {
            message = "业务受理发生错误!";
            return this.SUCCESS;
        } else

        {
            message = "业务受理成功!业务流水号为" + sid;
            currentPath = "/product/jsp/busHandle/handleResult.jsp";
            return this.SUCCESS;
        }

    }
    public String glLsh() {
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	currentPath="/product/jsp/qd_jsp/glLsh.jsp";
    	TYwlc tYwlc = em.find(TYwlc.class, ywlsh);
    	EntityManagerHelper.closeEntityManager();
    	ywlx=tYwlc.getYwlclx()+"";
    	User user = (User) session.get("sysUser");
    	String bzjgdm = user.getBzjgdm();
    	String isdy="1";
    	
    	String jgmc = "";
    	TJgdmSave save = null;
    	log.info("handle:" + ywlx + ":" + jgdm);
    	//如果是预赋码修改或预防码颁证去t_jgdm_save中判断;如果是代码恢复，首先去注销库里面判断机构代码是否存在;其它业务类型去t_jgdm表中判断
    	if ("3".equals(ywlx) || "5".equals(ywlx) || "17".equals(ywlx)) {
    		save = new TJgdmSaveBus().findByJgdm(jgdm);
    		if (save == null) {
    			message = "业务不能进行受理!机构代码不存在!";
    			return this.SUCCESS;
    		} else {
    			if (!bzjgdm.equals(save.getBzjgdm())) {
    				message = "业务不能进行受理!机构代码不属于办证机构,请到相关单位（" + InitSysParams.zrxzqhMap.get(save.getBzjgdm()) + "）办理!";
    				return this.SUCCESS;
    			} else {
    				jgmc = save.getJgmc();
    				if (!verifyBus(bzjgdm)) {
    					return this.SUCCESS;
    				}
    			}
    		}
    	}else if ("8".equals(ywlx)) {
    		TFzdm fzdm = new TFzdmBus().findById(jgdm);
    		if (fzdm == null) {
    			message = "业务不能进行受理!机构代码不存在!";
    			return this.SUCCESS;
    		} else {
    			if (!bzjgdm.equals(fzdm.getBzjgdm())) {
    				message = "业务不能进行受理!机构代码不属于办证机构,请到相关单位（" + InitSysParams.zrxzqhMap.get(fzdm.getBzjgdm()) + "）办理!";
    				return this.SUCCESS;
    			} else {
    				jgmc = fzdm.getJgmc();
    				if (!verifyBus(bzjgdm)) {
    					return this.SUCCESS;
    				}
    			}
    		}
    		 
    	} else if ("18".equals(ywlx)) {
    		TQzjgdm qzjgdm = new TQzjgdmBus().getQzjgdm(jgdm);
    		if (qzjgdm == null) {
    			message = "业务不能进行受理!机构代码不存在!";
    			return this.SUCCESS;
    		} else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
    			message = "机构代码（" + jgdm + "）不属于当前办证机构，请到（" + InitSysParams.zrxzqhMap.get(qzjgdm.getXzqh()) + "）处办理业务!";
    			return this.SUCCESS;
    		} else {
    			jgmc = qzjgdm.getJgmc();
    			if (!verifyBus(bzjgdm)) {
    				return this.SUCCESS;
    			}
    		}
    		
    	} else if ("19".equals(ywlx)) {
    		log.info("TQzjgdm:"+jgdm);
    		TQzjgdm qzjgdm = new TQzjgdmBus().getQzjgdmByJgdm(jgdm);
    		if (qzjgdm == null) {
    			message = "业务不能进行受理!机构代码不存在!";
    			return this.SUCCESS;
    		} else if (qzjgdm.getQrdbzjgdm() == null || !qzjgdm.getQrdbzjgdm().equals(bzjgdm)) {
    			message = "机构代码（" + jgdm + "）不属于当前办证机构，请到（" + InitSysParams.zrxzqhMap.get(qzjgdm.getQrdbzjgdm()) + "）处办理业务!";
    			return this.SUCCESS;
    		} else {
    			jgmc = qzjgdm.getJgmc();
    			if (!verifyBus(bzjgdm)) {
    				return this.SUCCESS;
    			}
    		}
    		
    	}  else if ("20".equals(ywlx) || "21".equals(ywlx)) {
    		log.info("TQzjgdm:"+jgdm);
    		TQzjgdm qzjgdm = new TQzjgdmBus().getQzjgdmByJgdm(jgdm);
    		if (qzjgdm == null) {
    			message = "业务不能进行受理!机构代码不存在!";
    			return this.SUCCESS;
    		} else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
    			message = "机构代码（" + jgdm + "）不属于当前办证机构，请到（" + InitSysParams.zrxzqhMap.get(qzjgdm.getBzjgdm()) + "）处办理业务!";
    			return this.SUCCESS;
    		} else {
    			jgmc = qzjgdm.getJgmc();
    			if (!verifyBus(bzjgdm)) {
    				return this.SUCCESS;
    			}
    		}
    		
    	} else {
    		TJgdm tJgdm = new TjgdmBus().findById(jgdm);
    		
    		if (tJgdm == null) {
    			message = "业务不能进行受理!机构代码不存在!";
    			return this.SUCCESS;
    		} else if (!bzjgdm.equals(tJgdm.getBzjgdm())) {
    			message = "业务不能进行受理!机构代码不属于这个办证机构!";
    			return this.SUCCESS;
    		} else {
    			if(tJgdm.getDybz().equals("1")){
    				isdy="2";
    			}
    			jgmc = tJgdm.getJgmc();
    			if (!verifyBus(bzjgdm)) {
    				return this.SUCCESS;
    			}
    		}
    	}
    	
    	
    	//受理成功插入到业务流程及业务流程日志表
    	EntityManager em2 = EntityManagerHelper.getEntityManager();
    	EntityTransaction tx = em2.getTransaction();
    	try {
    		tx.begin();
    		tYwlc.setJgdm(jgdm);
    		tYwlc.setJgmc(jgmc);
    		tYwlc.setIsend(isdy);
    		em2.merge(tYwlc);
    		tx.commit();
    		message="流水号:"+ywlsh+"已关联机构代码:"+jgdm;
    		currentPath="/bsweb/busHandle_sel.action";
		} catch (Exception e) {
            log.error("TJgdmBus forceUpdate exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    	
    	return SUCCESS;
    	
    }

    private boolean verifyBus(String bzjgdm) {
        boolean flag = true;
        TYwlc ywlc;
        ywlc = ywlcBus.findByJgdm(jgdm);
        if (ywlc != null) {
            if (!"2".equals(ywlc.getIsend())) {
                flag = false;
                message = "业务不能进行受理!还有未处理完成的业务!";
            }
            if (!bzjgdm.equals(ywlc.getBzjgdm())) {
                flag = false;
                message = "业务不能进行受理!机构代码不属于办证机构,请到相关单位（" + InitSysParams.zrxzqhMap.get(ywlc.getBzjgdm()) + "）办理!";
            }
            //如果之前业务是预赋码新建，现在只能办理预赋码修改或预赋码颁证业务
            if ("2".equals(ywlc.getYwlclx())) {
                if ("3".equals(ywlx) || "5".equals(ywlx)) {
                    flag = true;
                } else {
                    flag = false;
                    message = "此机构代码只能受理预赋码颁证业务或预赋码修改业务!";
                }
            }
        }
        return flag;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

	public List<TYwlc> getYwlcList() {
		return ywlcList;
	}

	public void setYwlcList(List<TYwlc> ywlcList) {
		this.ywlcList = ywlcList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getIsend() {
		return isend;
	}

	public void setIsend(String isend) {
		this.isend = isend;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	 
	
    
}
