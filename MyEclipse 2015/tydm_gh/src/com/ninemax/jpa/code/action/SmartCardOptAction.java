/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.TjgdmCardVO;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author yanzh
 */
public class SmartCardOptAction extends ActionSupport implements SessionAware {
    private static final String path = "/product/jsp/SmartCard/";
    private String currentPath;
    private String source;
    private TSystem system;
    private String title;
    private String message;
    private TJgdm jgdm;
    private TJgdm icCard;
    private TjgdmCardVO cardVO;
    private List<Kxx> kxxes;
    private HashMap<String, TjgdmCardVO> cardHashMap;
    //��ӡ����
    private TkPrintset printset;
    protected Map<String, Object> session;
    //IC ��
    private TkKxxk kxxk;
    //����ʧԭ��
    private String gsyy;
    //��������
    private Integer bksl;
    //�䷢��λ
    private String bfdw;
    //�䷢����
    private String bfrq;
    //�ƿ��ϱ���ʼʱ��
    private Date startDate;
    //�ƿ��ϱ�����ʱ��ʱ��
    private Date endDate;
    private List<TkKxxk> kxxks;
    private Map<String, String> dmmcs;
    private Page page;
    private String lshs;

    public SmartCardOptAction() {
    }

    /**
     * ������������ ת��д��ҳ��
     *
     * @return
     */
    public String search() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();
                if (jgdm2 == null) {
                    setMessage("�������루" + jgdm.getJgdm() + "��������");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
                jgdm = jgdm2;
                if (!"supplement".equals(source)) {
                    String sql = "select model from TkKxxk model where jgdm='" + jgdm.getJgdm() + "' and kxlh is null";
                    if (source.matches("^(loss|validate|check|update).*")) {
                        sql = sql.replace("kxlh is null", "kxlh is not null");
                    }
                    kxxks = em.createQuery(sql).getResultList();
                    if (kxxks == null || kxxks.isEmpty()) {
                        setMessage("�������루" + jgdm.getJgdm() + "��û�����뿨��¼�����ܰ����ҵ��");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    Map<String, TZrxzqh> hashMap = InitSysParams.zrxzqhMap2;

                    bfdw = hashMap.get(jgdm.getXzqh()) == null ? "" : hashMap.get(jgdm.getXzqh()).getJgmc();
                    String today = DateUtil.dateToStr(new Date());
                    bfrq = today.substring(0, 4) + today.substring(5, 7) + today.substring(8, 10);
                }
                currentPath = path + source + "ICCard.jsp";
            }
        }.template();
    }

    /**
     * ���ܿ����ҳ��
     *
     * @return
     */
    public String check() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                HttpServletRequest request = ServletActionContext.getRequest();
                User user = (User) session.get("sysUser");
                em.clear();
                String today = DateUtil.dateToStr(new Date());

                String strSeriaNo = request.getParameter("kxlh");
                String strLsh = request.getParameter("lsh");
                String strJgmc = jgdm.getJgmc();
                String strBfjgmc = today.substring(0, 4) + today.substring(5, 7) + today.substring(8, 10);
                String strJglx = jgdm.getJglx();
                String strJglxmc = InitSysParams.jglxMap.get(strJglx);
                String strFddbr = jgdm.getFddbr();
                String strXzqh = jgdm.getXzqh();
                String strJgdz = jgdm.getJgdz();
                String strYzbm = jgdm.getYzbm();
                String strDhhm = jgdm.getDhhm();
                String strZczj = String.valueOf(jgdm.getZczj());
                String strHbzl = jgdm.getHbzl();
                String strHbzlmc = InitSysParams.hbMap.get(strHbzl);
                String strJjlx = jgdm.getJjlx();
                String strJjlxmc = InitSysParams.jjlxMap.get(strJjlx);
                String strWftzgb = jgdm.getWftzgb();
                String strWftzgbmc = InitSysParams.gjMap.get(strWftzgb);
                String strNjrq = DateUtil.dateToStr(jgdm.getNjqx());
                String strNjqx = DateUtil.dateToStr(jgdm.getNjqx());
                String strZch = jgdm.getZch();
                String strSql = "update tk_xgk set flag='0' where jgdm='" + jgdm.getJgdm() + "' and kxlh=" + strSeriaNo;
                em.createNativeQuery(strSql).executeUpdate();
                strSql = "insert into tk_xgk(kxlh,operater,jgdm,jgmc,bfjgmc,fksj,jglx,jglxmc,fddbr,xzqh,jgdz,yzbm,dhhm,zczj,hbzl,hbzlmc,jjlx,jjlxmc,wftzgb,wftzgbmc," +
                        "njrq,njqx,zch,xgsj,flag) values (" + strSeriaNo + ",'" + user.getBzjgdm() + "','" + jgdm.getJgdm() + "','" + strJgmc + "','" + strBfjgmc + "'," +
                        "'" + today + "','" + strJglx + "','" + strJglxmc + "','" + strFddbr + "','" + strXzqh + "','" + strJgdz + "','" + strYzbm + "','" + strDhhm +
                        "'," + strZczj + ",'" + strHbzl + "','" + strHbzlmc + "','" + strJjlx + "','" + strJjlxmc + "','" + strWftzgb + "','" + strWftzgbmc + "','" +
                        strNjrq + "','" + strNjqx + "','" + strZch + "','" + today + "','1')";
                em.createNativeQuery(strSql).executeUpdate();
                strSql = "INSERT INTO t_czjl(name,type,date,jgdm,xzqh,klsh)";
                strSql = strSql + "VALUES ('" + user.getBzjgdm() + "','K6','" + today + "','" + jgdm.getJgdm() + "','" + user.getBzjgdm() + "'," + strLsh + ")";
                em.createNativeQuery(strSql).executeUpdate();
                message = "��������(" + jgdm.getJgdm() + ")��ˮ��Ϊ(" + strLsh + ")�����ܿ������ϣ�";
                currentPath = path + "checkPrompt.jsp";
            }
        }.template();
    }

    public String searchForDataReport() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if ((startDate == null) || (endDate == null)) {
                    endDate = DateUtil.strToDate(DateUtil.dateToStr(new Date()));
                    startDate = DateUtil.dayBefore(endDate, 10);
                }
                Date end = DateUtil.dayAfter(endDate, 1);
                String sql = "select model from TkKxxk model  where model.xzqh='" + user.getBzjgdm() + "' and model.sqsj>:startDate and model.sqsj<:endDate and model.haveDown='0' order by model.jgdm";
                Query query = em.createQuery(sql).setParameter("startDate", startDate).setParameter("endDate", end);
                kxxks = query.getResultList();
                if (kxxks == null || kxxks.isEmpty()) {
                    kxxks = null;
                    message = "û�з������������ܿ�������Ϣ,������!";
                } else {
                    sql = "select dm from  TJgdm dm   where dm.jgdm in(select model.jgdm from TkKxxk model where model.xzqh='" + user.getBzjgdm() + "' and model.sqsj>:startDate and model.sqsj<:endDate and model.haveDown='0' )";
                    query = em.createQuery(sql).setParameter("startDate", startDate).setParameter("endDate", end);
                    List<TJgdm> dms = query.getResultList();
                    dmmcs = new HashMap<String, String>();
                    for (int i = 0; i < dms.size(); i++) {
                        TJgdm tJgdm = dms.get(i);
                        dmmcs.put(tJgdm.getJgdm(), tJgdm.getJgmc());
                    }
                }
                currentPath = path + "cardDataReport.jsp";
            }
        }.template();
    }

    public String searchForDataReportView() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
            }
        }.template();
    }

    /**
     * ��ȡ��ӡ������ ������ӡ������ҳ��
     *
     * @return
     */
    public String printerSetting() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql = "select model from TkPrintset model where model.userid='" + user.getUserId() + "'";
                List<TkPrintset> printsets = em.createQuery(sql).getResultList();
                if (printsets == null || printsets.isEmpty()) {
                    printset = new TkPrintset();
                } else {
                    printset = printsets.get(0);
                }
                currentPath = path + "printerSetting.jsp";
            }
        }.template();

    }

    /**
     * �����ӡ������
     *
     * @return
     */
    public String savePrinterSetting() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql = "select model from TkPrintset model where model.userid='" + user.getUserId() + "'";
                List<TkPrintset> printsets = em.createQuery(sql).getResultList();
                if (printsets == null || printsets.isEmpty()) {
                    em.persist(printset);
                } else {
                    em.merge(printset);
                }
                setTitle("���ܿ� &gt;&gt; ���ܿ����� &gt;&gt; �ƿ������óɹ�");
                message = "��ӡ���������óɹ���";
                currentPath = path + "success.jsp";
                source = "/bsweb/icCardOpt_printerSetting.html";
            }
        }.template();

    }

    /**
     * �ƿ�
     *
     * @return
     */
    public String punchICCard() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TkKxxk kxxk1 = em.find(TkKxxk.class, kxxk.getLsh());
                kxxk1.setWritecarddate(new Date());
                if (kxxk.getKxlh() == null) {
                    SerialPK pk = new SerialPK();
                    pk.setXzqhCode(user.getBzjgdm());
                    pk.setTableType("4");
                    Serial serial = em.find(Serial.class, pk);
                    if (serial == null) {
                        serial = new Serial();
                        serial.setTableType("4");
                        serial.setXzqhCode(user.getBzjgdm());
                        serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                        serial.setFlowIdLen("6");
                        serial.setFlowId(100000);
                    } else {
                        kxxk.setKxlh(Long.valueOf(serial.getFlowId()));
                    }
                }


                kxxk1.setKxlh(kxxk.getKxlh());
                em.merge(kxxk1);
                TkFkk fkk = new TkFkk();
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                BeanUtilsEx.copyProperties(fkk, jgdm);
                fkk.setKxlh(kxxk.getKxlh());
                fkk.setLsh(kxxk.getLsh());
                fkk.setLastdate(new Date());
                fkk.setOperatenum(user.getUserName());
                em.merge(fkk);
                TCzjl czjl = new TCzjl();
                czjl.setName(user.getUserName());
                czjl.setType("KP");
                czjl.setDate(new Date());
                czjl.setJgdm(jgdm.getJgdm());
                czjl.setXzqh(user.getBzjgdm());
                czjl.setKlsh(kxxk.getLsh().longValue());
                em.persist(czjl);
                setTitle("���ܿ� &gt;&gt; ���ܿ����� &gt;&gt; �ƿ�");
                message = "��������(" + jgdm.getJgdm() + ")��ˮ��Ϊ(" + kxxk.getLsh() + ")�����ܿ��ƿ���ϣ�";
                currentPath = path + "success.jsp";
            }
        }.template();

    }

    /**
     * Ϊʡ����У���ȡ��ӡ������
     *
     * @return
     */
    public String searchProvincialKeys() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                message = "�ƿ��������Ѿ��ɹ����棡";
                String sql = "select model from TkPrintset model where model.userid='" + user.getUserId() + "'";
                List<TkPrintset> printsets = em.createQuery(sql).getResultList();
                if (printsets == null || printsets.isEmpty()) {
                    printset = new TkPrintset();
                    printset.setPrintPort("LPT0:");
                    printset.setCommunicationPort(Short.parseShort("1"));
                    printset.setBaudRate(0);
                    printset.setPrinterType(Short.parseShort("0"));
                } else {
                    printset = printsets.get(0);
                }
                currentPath = path + "checkProvincialKey.jsp";
            }
        }.template();

    }

    /**
     * ����ʡУ����
     *
     * @return
     */
    public String checkProvincialKeys() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                session.put("PrintPort", printset.getPrintPort());
                session.put("CommPort", printset.getCommunicationPort());
                session.put("BaudRate", printset.getBaudRate());
                session.put("PrinterType", printset.getPrinterType());
                currentPath = path + "checkSuccess.jsp";
            }
        }.template();
    }

    /**
     * ������ܿ���Ϣ
     *
     * @return
     */
    public String icCheck() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                currentPath = path + "icCardTesting.jsp";
                cardHashMap = new HashMap<String, TjgdmCardVO>();
                //������ܿ���Ϣ
                HttpServletRequest request = ServletActionContext.getRequest();
                //��ȡstruts2��ȡ����������
                String bfdwmc = request.getParameter("bfdwmc");
                String bfrq = request.getParameter("bfrq");
                String zczj = request.getParameter("zczj");
                String njqx = request.getParameter("njqx");
                String njrq = request.getParameter("njrq");
                String zch = request.getParameter("zch");
                //���ڸ�ʽ���Ϸ�
                if (njqx != null && njqx.length() != 8) {
                    njqx = null;
                }
                if (bfrq != null && bfrq.length() != 8) {
                    bfrq = null;
                }
                if (njrq != null && njrq.length() != 8) {
                    njrq = null;
                }
                cardVO.setBfdwmc(bfdwmc);
                cardVO.setBfrq(bfrq);
                cardVO.setNjqx(njqx);
                cardVO.setNjrq(njrq);
                if (zczj != null && zczj.matches("\\d+(\\.\\d+)?"))
                    cardVO.setZczj(Double.valueOf(zczj));
                cardVO.setZch(zch);
                cardHashMap.put("card", cardVO);
                //��ȡ���ݿ�˻�����Ϣ
                jgdm = em.find(TJgdm.class, cardVO.getJgdm());
                if (jgdm != null) {
                    cardVO = new TjgdmCardVO();
                    cardVO.setJgdm(jgdm.getJgdm());
                    cardVO.setJgmc(jgdm.getJgmc());
                    cardVO.setBfrq(null);
                    cardVO.setBfdwmc(jgdm.getBzjgdm());
                    cardVO.setDhhm(jgdm.getDhhm());
                    cardVO.setFddbr(jgdm.getFddbr());
                    cardVO.setHbzl(jgdm.getHbzl());
                    cardVO.setJgdz(jgdm.getJgdz());
                    cardVO.setJglx(jgdm.getJglx());
                    cardVO.setJjlx(jgdm.getJjlx());
                    cardVO.setNjqx(jgdm.getNjqx() == null ? "" : DateUtil.dateToStr(jgdm.getNjqx()));
                    cardVO.setNjrq(jgdm.getNjrq() == null ? "" : DateUtil.dateToStr(jgdm.getNjrq()));
                    cardVO.setWftzgb(jgdm.getWftzgb());
                    cardVO.setXzqh(jgdm.getXzqh());
                    cardVO.setYzbm(jgdm.getYzbm());
                    cardVO.setZch(jgdm.getZch());
                    cardVO.setZczj(jgdm.getZczj());
                    //������ݿ���Ϣ
                    cardHashMap.put("db", cardVO);
                } else {
                    message = "��������" + cardVO.getJgdm() + "������!����������!";
                    currentPath = path + "prompt.jsp";
                }
            }
        }.template();
    }

    /**
     * �����
     *
     * @return
     */
    public String checkICCard() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql = "update TkXgk set flag='0' where jgdm='" + jgdm.getJgdm() + "' and kxlh=" + kxxk.getKxlh();
                em.createQuery(sql).executeUpdate();
                TkXgk xgk = new TkXgk();
                BeanUtilsEx.copyProperties(xgk, jgdm);
                xgk.setKxlh(kxxk.getKxlh());
                xgk.setOperater(user.getUserName());
                xgk.setFksj(new Date());
                xgk.setXgsj(new Date());
                xgk.setFlag("1");
                em.persist(xgk);
                TCzjl czjl = new TCzjl();
                czjl.setName(user.getUserName());
                czjl.setType("K6");
                czjl.setDate(new Date());
                czjl.setJgdm(jgdm.getJgdm());
                czjl.setXzqh(user.getBzjgdm());
                czjl.setKlsh(kxxk.getLsh().longValue());
                em.persist(czjl);
                message = "��������(" + jgdm.getJgdm() + ")��ˮ��Ϊ(" + kxxk.getLsh() + ")�����ܿ������ϣ�";
                source = "check";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * ������
     *
     * @return
     */
    public String updateICCard() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql = "update TkXgk set flag='0' where jgdm='" + jgdm.getJgdm() + "' and kxlh=" + kxxk.getKxlh();
                em.createQuery(sql).executeUpdate();
                TkXgk xgk = new TkXgk();
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                BeanUtilsEx.copyProperties(xgk, jgdm);
                xgk.setKxlh(kxxk.getKxlh());
                xgk.setFksj(new Date());
                xgk.setXgsj(new Date());
                xgk.setFlag("1");
                em.persist(xgk);
                TCzjl czjl = new TCzjl();
                czjl.setName(user.getUserName());
                czjl.setType("K2");
                czjl.setDate(new Date());
                czjl.setJgdm(jgdm.getJgdm());
                czjl.setXzqh(user.getBzjgdm());
                czjl.setKlsh(kxxk.getLsh().longValue());
                em.persist(czjl);
                source = "update";
                currentPath = path + "success.jsp";
                message = "��������(" + jgdm.getJgdm() + ")���к�Ϊ(" + kxxk.getKxlh() + ")�����ܿ������ϣ�";

            }
        }.template();

    }

    /**
     * ��ע��
     *
     * @return
     */
    public String validateICCard() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());

                if (jgdm == null) {
                    throw new Exception(String.valueOf(String.valueOf(new StringBuffer("��������(").append(jgdm.getJgdm()).append(")������!"))));
                }

                if ((jgdm.getFksl() == null)) {
                    jgdm.setFksl(0);
                }


                if (!jgdm.getBzjgdm().equals(user.getBzjgdm())) {
                    throw new Exception(String.valueOf(String.valueOf(new StringBuffer("����Ȩ�Ի�������(").append(jgdm.getJgdm()).append(")���в���,������������������(").append(jgdm.getBzjgdm()).append(")."))));
                }

                String sql = "select model from TkKxxk model where model.kxlh=" + kxxk.getKxlh() + " and model.jgdm='" + jgdm.getJgdm() + "'";
                List<TkKxxk> kxxks = em.createQuery(sql).getResultList();
                if (kxxks == null || kxxks.isEmpty()) {
                    throw new Exception(String.valueOf(String.valueOf(new StringBuffer("�����к�(").append(kxxk.getKxlh()).append(")������!"))));
                }

                kxxk = kxxks.get(0);
                TkFzk fzk = new TkFzk();
                fzk.setKxlh(kxxk.getKxlh());
                fzk.setJgdm(jgdm.getJgdm());
                fzk.setFzsj(new Date());
                fzk.setOperater(user.getUserName());
                fzk.setXzqh(user.getBzjgdm());
                em.persist(fzk);
                sql = "delete from TkKxxk where kxlh=" + kxxk.getKxlh() + " and jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                TCzjl czjl = new TCzjl();
                czjl.setName(user.getUserName());
                czjl.setType("B");
                czjl.setDate(new Date());
                czjl.setJgdm(jgdm.getJgdm());
                czjl.setXzqh(user.getBzjgdm());
                czjl.setKlsh(kxxk.getLsh().longValue());
                em.persist(czjl);
                sql = "update TJgdm  set fkbz=:fkbz,fksl=" + jgdm.getFksl() + " where jgdm='" + jgdm.getJgdm() + "'";
                Query query = em.createQuery(sql);
                int iBksl = jgdm.getFksl() - 1;
                if (iBksl <= 0)
                    query.setParameter("fkbz", "0");
                else {
                    query.setParameter("fkbz", "1");
                }
                query.executeUpdate();
                source = "validate";
                message = "��������(" + jgdm.getJgdm() + ")���ܿ�ע���ɹ���";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * ����ʧ
     *
     * @return
     */
    public String lossICCard() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());

                if (jgdm == null) {
                    throw new Exception(String.valueOf(String.valueOf(new StringBuffer("��������(").append(jgdm.getJgdm()).append(")������!"))));
                }

                if ((jgdm.getFksl() == null)) {
                    jgdm.setFksl(0);
                }


                if (!jgdm.getBzjgdm().equals(user.getBzjgdm())) {
                    throw new Exception(String.valueOf(String.valueOf(new StringBuffer("����Ȩ�Ի�������(").append(jgdm.getJgdm()).append(")���в���,������������������(").append(jgdm.getBzjgdm()).append(")."))));
                }

                String sql = "select model from TkKxxk model where model.kxlh=" + kxxk.getKxlh() + " and model.jgdm='" + jgdm.getJgdm() + "'";
                List<TkKxxk> kxxks = em.createQuery(sql).getResultList();
                if (kxxks == null || kxxks.isEmpty()) {
                    throw new Exception(String.valueOf(String.valueOf(new StringBuffer("�����к�(").append(kxxk.getKxlh()).append(")������!"))));
                }
                kxxk = kxxks.get(0);
                sql = "delete from TkKxxk where kxlh=" + kxxk.getKxlh() + " and jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                TkGsk gsk = new TkGsk();
                gsk.setKxlh(kxxk.getKxlh());
                gsk.setJgdm(jgdm.getJgdm());
                gsk.setGsyy(gsyy);
                gsk.setGssj(new Date());
                gsk.setXzqh(user.getBzjgdm());
                em.persist(gsk);
                TBlack black = new TBlack();
                BeanUtilsEx.copyProperties(black, jgdm);
                black.setCzr(user.getUserName());
                black.setCzrq(new Date());
                em.persist(black);
                TCzjl czjl = new TCzjl();
                czjl.setName(user.getUserName());
                czjl.setType("A");
                czjl.setDate(new Date());
                czjl.setJgdm(jgdm.getJgdm());
                czjl.setXzqh(user.getBzjgdm());
                czjl.setKlsh(kxxk.getLsh().longValue());
                em.persist(czjl);
                sql = "update TJgdm  set fkbz=:fkbz,fksl=" + jgdm.getFksl() + " where jgdm='" + jgdm.getJgdm() + "'";
                Query query = em.createQuery(sql);
                int iBksl = jgdm.getFksl() - 1;
                if (iBksl <= 0)
                    query.setParameter("fkbz", "0");
                else {
                    query.setParameter("fkbz", "1");
                }
                query.executeUpdate();
                source = "loss";
                message = "��������(" + jgdm.getJgdm() + ")��ʧ�ɹ���";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * ����
     *
     * @return
     */
    public String supplementICCard() {
        return new ActionUtils(session) {


            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
//                String[] lshs = getLshNum("100000", "4", bksl);
                for (int i = 0; i < bksl; i++) {
                    TkKxxk kxxk = new TkKxxk();
                    BeanUtilsEx.copyProperties(kxxk, jgdm);
//                    kxxk.setLsh(Integer.valueOf(lshs[i]));
                    kxxk.setXzqh(user.getBzjgdm());
                    kxxk.setFkbz("1");
                    kxxk.setBkbz("0");
                    kxxk.setGsbz("0");
                    kxxk.setXgbz("0");
                    kxxk.setSbbz("0");
                    kxxk.setSqsj(new Date());
                    kxxk.setCzsj(new Date());
                    kxxk.setCzy(user.getUserName());
                    kxxk.setHaveDown("0");
                    kxxk.setFlag("0");
                    em.persist(kxxk);
                    em.flush();
                    TCzjl czjl = new TCzjl();
                    czjl.setName(user.getUserName());
                    czjl.setType("S");
                    czjl.setDate(new Date());
                    czjl.setJgdm(jgdm.getJgdm());
                    czjl.setXzqh(user.getBzjgdm());
                    czjl.setKlsh(kxxk.getLsh().longValue());
                    em.persist(czjl);
                }
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                jgdm.setFkbz("1");
                jgdm.setFksl(jgdm.getFksl() + bksl);
                em.merge(jgdm);
                source = "supplement";
                message = "��������(" + jgdm.getJgdm() + ")�����ɹ�������ֱ���ƿ�!";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * �˿�
     *
     * @return
     */
    public String backICCard() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql = "select model from TkKxxk model where kxlh is null and jgdm='" + jgdm.getJgdm() + "'";
                List<TkKxxk> kxxks = em.createQuery(sql).getResultList();
                if (kxxks == null || kxxks.isEmpty()) {
                    throw new Exception("���루" + jgdm.getJgdm() + "��û���������������Ҫ�˿���");
                } else {
                    for (TkKxxk kxxk1 : kxxks) {
                        if (kxxk1.getKxlh() == null) {
                            TCzjl czjl = new TCzjl();
                            czjl.setName(user.getUserName());
                            czjl.setType("KQ");
                            czjl.setDate(new Date());
                            czjl.setJgdm(jgdm.getJgdm());
                            czjl.setXzqh(user.getBzjgdm());
                            czjl.setKlsh(kxxk1.getLsh().longValue());
                            em.persist(czjl);
                        }
                    }
                    sql = "DELETE TkKxxk WHERE jgdm='" + jgdm.getJgdm() + "' and kxlh is null";
                    em.createQuery(sql).executeUpdate();
                    sql = "DELETE Codebuf buf WHERE buf.jgdm='" + jgdm.getJgdm() + "'";
                    em.createQuery(sql).executeUpdate();
                    sql = "update TJgdm set fkbz='0',fksl=0 where jgdm ='" + jgdm.getJgdm() + "'";
                    em.createQuery(sql).executeUpdate();
                    message = "Ϊ��������(" + jgdm.getJgdm() + ")�˷�������Ҫ�������ܿ���";
                    source = "back";
                    currentPath = path + "success.jsp";

                }
            }
        }.template();
    }

    public String writesurface() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                message = "Ϊ��������(" + jgdm.getJgdm() + ")��ӡ��������Ϣ�ɹ���";
                source = "writesurface";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String list_extractData() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                }
                String sql = "from  TkKxxk kxxk , TJgdm model  where model.jgdm=kxxk.jgdm and kxxk.kxlh is null and   kxxk.haveDown ='0' and kxxk.sbbz = '1'  ";
                if (startDate != null) {
                    sql += " and kxxk.sqsj >='" + DateUtil.dateToStr(startDate) + "'";
                }
                if (endDate != null) {
                    sql += " and kxxk.sqsj <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
                }
                kxxes = em.createQuery("select new com.ninemax.jpa.code.model.Kxx(model,kxxk) " + sql)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize()).getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model)  " + sql)
                        .getResultList().get(0)).intValue());
                currentPath = path + "list_extractData.jsp";
            }
        }.template();
    }

    public String extractData() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                String[] lsh = lshs.split(",");
                if (lsh == null || lsh.length <= 0) {
                    setMessage("����ѡ���¼���ڴ������棡");
                    currentPath = path + "list_extractData.jsp";
                    return;
                } else {
                }
                message = "�ɹ���ȡ" + lsh.length + "���ƿ����ݵ����棡";
                source = "list_extractData";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public TSystem getSystem() {
        return system;
    }

    public void setSystem(TSystem system) {
        this.system = system;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TkPrintset getPrintset() {
        return printset;
    }

    public void setPrintset(TkPrintset printset) {
        this.printset = printset;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public TkKxxk getKxxk() {
        return kxxk;
    }

    public void setKxxk(TkKxxk kxxk) {
        this.kxxk = kxxk;
    }

    public TJgdm getIcCard() {
        return icCard;
    }

    public void setIcCard(TJgdm icCard) {
        this.icCard = icCard;
    }

    public String getGsyy() {
        return gsyy;
    }

    public void setGsyy(String gsyy) {
        this.gsyy = gsyy;
    }

    public Integer getBksl() {
        return bksl;
    }

    public void setBksl(Integer bksl) {
        this.bksl = bksl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<TkKxxk> getKxxks() {
        return kxxks;
    }

    public void setKxxks(List<TkKxxk> kxxks) {
        this.kxxks = kxxks;
    }

    public Map<String, String> getDmmcs() {
        return dmmcs;
    }

    public void setDmmcs(Map<String, String> dmmcs) {
        this.dmmcs = dmmcs;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TjgdmCardVO getCardVO() {
        return cardVO;
    }

    public void setCardVO(TjgdmCardVO cardVO) {
        this.cardVO = cardVO;
    }

    public HashMap<String, TjgdmCardVO> getCardHashMap() {
        return cardHashMap;
    }

    public void setCardHashMap(HashMap<String, TjgdmCardVO> cardHashMap) {
        this.cardHashMap = cardHashMap;
    }

    public String getBfdw() {
        return bfdw;
    }

    public void setBfdw(String bfdw) {
        this.bfdw = bfdw;
    }

    public String getBfrq() {
        return bfrq;
    }

    public void setBfrq(String bfrq) {
        this.bfrq = bfrq;
    }

    public List<Kxx> getKxxes() {
        return kxxes;
    }

    public void setKxxes(List<Kxx> kxxes) {
        this.kxxes = kxxes;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getJgdmIds() {
        return lshs;
    }

    public void setJgdmIds(String jgdmIds) {
        this.lshs = jgdmIds;
    }
}