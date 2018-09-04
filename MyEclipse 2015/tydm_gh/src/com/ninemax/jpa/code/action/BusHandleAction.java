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
 * Time: ����2:57
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
    		if(ywlx.equals("1")){//��֤
    			if(jgdm2.getDybz().equals("1")){
    				message="�ð�֤����֤���Ѵ�ӡ!";
    			}else{
    				url="/bsweb/certificatePrint_zb_info.action?jgdm.jgdm="+jgdm2.getJgdm();
    			}
    		}else if(ywlx.equals("2")){//���
    			if(jgdm2.getDybz().equals("1")){
    				url="/bsweb/business_search.action?mc="+jgdm2.getJgdm()+"&type=update_no&source=update_no&bzjgdm="+user.getBzjgdm()+"&needAudit=false&audit=false&checkCfjl=yes&ywlx=17&dzch=";
    			}else{
    				message="�ð�֤������δ��ӡ֤��,���ӡ֤����ٽ��б��!";
    			}
    		}else if(ywlx.equals("3")){//��֤
    			if(jgdm2.getDybz().equals("1")){
    				url="/bsweb/certificate_search.action?jgdm="+jgdm2.getJgdm()+"&source=certChange&dzch=undefined&bzjgdm="+user.getBzjgdm()+"&pageno=0&rowNumsView=20";
    			}else{
    				message="�ð�֤������δ��ӡ֤��,���ӡ֤����ٽ��л�֤!";
    			}
    		}else if(ywlx.equals("4")){//������޸�
    			if(jgdm2.getDybz().equals("1")){
    				message="�ð�֤����֤���Ѵ�ӡ,�޸��뵽�����֤!";
    			}else{
    				url="/bsweb/certificate_search.action?jgdm="+jgdm2.getJgdm()+"&source=update&bzjgdm="+user.getBzjgdm()+"&pageno=1&rowNumsView=20&sourceTable=t_jgdm";
    			}
    		}
    	}else{
    		message="δ�ҵ���Ӧ��¼,�����Ƿ���ȷ!";
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
                    message = "ҵ������" + ywName + "�Ѿ�����!";
                } else {
                    message = "ҵ������" + ywName + "���ڽ���" + ywlcLog.getType() + "����";
                }
            }
        } else {
            message = "��Ҫ��ѯ��ҵ�񲻴���!ҵ����ˮ�Ż�����������!";
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
            //ֻ�и������ҵ��isend��0��ҵ��ſ��Խ����������Ҳ����°�ҵ��ҵ������������1��2,4��ҵ������
            if ("0".equals(tYwlc.getIsend()) && (!"1".equals(tYwlc.getYwlclx()) || !"2".equals(tYwlc.getYwlclx()) || !"4".equals(tYwlc.getYwlclx()))) {
                boolean flag = ywlcBus.delYwlcDataByYwlsh(ywlsh);
                if (flag) {
                    message = "ҵ�����ɹ�!";
                } else
                    message = "ҵ���������з����쳣!";
            } else
                message = "��Ҫ������ҵ���ܽ�������";
        } else {
            message = "��Ҫ������ҵ�񲻴���!ҵ����ˮ�Ŵ���!";
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
        //�����Ԥ�����޸Ļ�Ԥ�����֤ȥt_jgdm_save���ж�;����Ǵ���ָ�������ȥע���������жϻ��������Ƿ����;����ҵ������ȥt_jgdm�����ж�
        if ("3".equals(ywlx) || "5".equals(ywlx) || "17".equals(ywlx)) {
            save = new TJgdmSaveBus().findByJgdm(jgdm);
            if (save == null) {
                message = "ҵ���ܽ�������!�������벻����!";
                return this.SUCCESS;
            } else {
                if (!bzjgdm.equals(save.getBzjgdm())) {
                    message = "ҵ���ܽ�������!�������벻���ڰ�֤����,�뵽��ص�λ��" + InitSysParams.zrxzqhMap.get(save.getBzjgdm()) + "������!";
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
                message = "ҵ���ܽ�������!�������벻����!";
                return this.SUCCESS;
            } else {
                if (!bzjgdm.equals(fzdm.getBzjgdm())) {
                    message = "ҵ���ܽ�������!�������벻���ڰ�֤����,�뵽��ص�λ��" + InitSysParams.zrxzqhMap.get(fzdm.getBzjgdm()) + "������!";
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
                message = "ҵ���ܽ�������!�������벻����!";
                return this.SUCCESS;
            } else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
                message = "�������루" + jgdm + "�������ڵ�ǰ��֤�������뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getXzqh()) + "��������ҵ��!";
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
                message = "ҵ���ܽ�������!�������벻����!";
                return this.SUCCESS;
            } else if (qzjgdm.getQrdbzjgdm() == null || !qzjgdm.getQrdbzjgdm().equals(bzjgdm)) {
                message = "�������루" + jgdm + "�������ڵ�ǰ��֤�������뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getQrdbzjgdm()) + "��������ҵ��!";
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
                message = "ҵ���ܽ�������!�������벻����!";
                return this.SUCCESS;
            } else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
                message = "�������루" + jgdm + "�������ڵ�ǰ��֤�������뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getBzjgdm()) + "��������ҵ��!";
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
                message = "ҵ���ܽ�������!�������벻����!";
                return this.SUCCESS;
            } else if (!bzjgdm.equals(tJgdm.getBzjgdm())) {
                message = "ҵ���ܽ�������!�������벻���������֤����!";
                return this.SUCCESS;
            } else {
                jgmc = tJgdm.getJgmc();
                if (!verifyBus(bzjgdm)) {
                    return this.SUCCESS;
                }
            }
        }
        

        //����ɹ����뵽ҵ�����̼�ҵ��������־��
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
            message = "����ȡ��ҵ���!���ݿ��쳣!";
            return this.SUCCESS;
        }
        *
        */
        if(sid.equals("")){
        	  message = "����ȡ��ҵ���!���ݿ��쳣!";
              return this.SUCCESS;
        }
        //String sid = DateUtil.getCurrentDateTime().substring(0, 4) + maxId;
        boolean flag = ywlcBus.handleBus(sid, id, bzjgdm, ywlx, jgmc, jgdm,user.getUserName());
        if (!flag) {
            message = "ҵ������������!";
            return this.SUCCESS;
        } else

        {
            message = "ҵ������ɹ�!ҵ����ˮ��Ϊ" + sid;
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
    	//�����Ԥ�����޸Ļ�Ԥ�����֤ȥt_jgdm_save���ж�;����Ǵ���ָ�������ȥע���������жϻ��������Ƿ����;����ҵ������ȥt_jgdm�����ж�
    	if ("3".equals(ywlx) || "5".equals(ywlx) || "17".equals(ywlx)) {
    		save = new TJgdmSaveBus().findByJgdm(jgdm);
    		if (save == null) {
    			message = "ҵ���ܽ�������!�������벻����!";
    			return this.SUCCESS;
    		} else {
    			if (!bzjgdm.equals(save.getBzjgdm())) {
    				message = "ҵ���ܽ�������!�������벻���ڰ�֤����,�뵽��ص�λ��" + InitSysParams.zrxzqhMap.get(save.getBzjgdm()) + "������!";
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
    			message = "ҵ���ܽ�������!�������벻����!";
    			return this.SUCCESS;
    		} else {
    			if (!bzjgdm.equals(fzdm.getBzjgdm())) {
    				message = "ҵ���ܽ�������!�������벻���ڰ�֤����,�뵽��ص�λ��" + InitSysParams.zrxzqhMap.get(fzdm.getBzjgdm()) + "������!";
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
    			message = "ҵ���ܽ�������!�������벻����!";
    			return this.SUCCESS;
    		} else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
    			message = "�������루" + jgdm + "�������ڵ�ǰ��֤�������뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getXzqh()) + "��������ҵ��!";
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
    			message = "ҵ���ܽ�������!�������벻����!";
    			return this.SUCCESS;
    		} else if (qzjgdm.getQrdbzjgdm() == null || !qzjgdm.getQrdbzjgdm().equals(bzjgdm)) {
    			message = "�������루" + jgdm + "�������ڵ�ǰ��֤�������뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getQrdbzjgdm()) + "��������ҵ��!";
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
    			message = "ҵ���ܽ�������!�������벻����!";
    			return this.SUCCESS;
    		} else if (qzjgdm.getBzjgdm() == null || !qzjgdm.getBzjgdm().equals(bzjgdm)) {
    			message = "�������루" + jgdm + "�������ڵ�ǰ��֤�������뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getBzjgdm()) + "��������ҵ��!";
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
    			message = "ҵ���ܽ�������!�������벻����!";
    			return this.SUCCESS;
    		} else if (!bzjgdm.equals(tJgdm.getBzjgdm())) {
    			message = "ҵ���ܽ�������!�������벻���������֤����!";
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
    	
    	
    	//����ɹ����뵽ҵ�����̼�ҵ��������־��
    	EntityManager em2 = EntityManagerHelper.getEntityManager();
    	EntityTransaction tx = em2.getTransaction();
    	try {
    		tx.begin();
    		tYwlc.setJgdm(jgdm);
    		tYwlc.setJgmc(jgmc);
    		tYwlc.setIsend(isdy);
    		em2.merge(tYwlc);
    		tx.commit();
    		message="��ˮ��:"+ywlsh+"�ѹ�����������:"+jgdm;
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
                message = "ҵ���ܽ�������!����δ������ɵ�ҵ��!";
            }
            if (!bzjgdm.equals(ywlc.getBzjgdm())) {
                flag = false;
                message = "ҵ���ܽ�������!�������벻���ڰ�֤����,�뵽��ص�λ��" + InitSysParams.zrxzqhMap.get(ywlc.getBzjgdm()) + "������!";
            }
            //���֮ǰҵ����Ԥ�����½�������ֻ�ܰ���Ԥ�����޸Ļ�Ԥ�����֤ҵ��
            if ("2".equals(ywlc.getYwlclx())) {
                if ("3".equals(ywlx) || "5".equals(ywlx)) {
                    flag = true;
                } else {
                    flag = false;
                    message = "�˻�������ֻ������Ԥ�����֤ҵ���Ԥ�����޸�ҵ��!";
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
