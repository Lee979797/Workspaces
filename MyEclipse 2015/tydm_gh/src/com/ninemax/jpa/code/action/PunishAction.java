package com.ninemax.jpa.code.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.ninemax.jpa.code.bus.PunishBus;
import com.ninemax.jpa.code.bus.SerialBus;
import com.ninemax.jpa.code.bus.TCflxBus;
import com.ninemax.jpa.code.bus.WsbzXbBus;
import com.ninemax.jpa.code.model.Hzcq;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.TBajlb;
import com.ninemax.jpa.code.model.TCfjlb;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TSystem;
import com.ninemax.jpa.code.model.TZgtzd;
import com.ninemax.jpa.code.model.TZgtzdMx;
import com.ninemax.jpa.code.model.TZgtzdPK;
import com.ninemax.jpa.code.model.vo.Wba;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.CheckCode;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsStringTool;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Liuzy
 */
public class PunishAction extends ActionSupport implements SessionAware {
    private static Logger log = Logger.getLogger(PunishAction.class);
    private static final String path = "/product/jsp/punish/";
    private Map<String, Object> session;
    private PunishBus punBus;
    private String resultMsg = "";
    private String currentPath;
    private String message;
    private String title;
    private String source;
    private List<TCfjlb> punishs;
    private Map<String, String> cflxs;
    private TCfjlb cfjl;
    private Hzcq hzcq;
    private List<Hzcq> hzcqs;
    private TJgdm jgdm;
    private List<TJgdm> jgdms;
    private String jgdmIds;
    private SerialBus serialBus;
    private Page page;
    private Date startDate;
    private Date endDate;
    private TBajlb bajl;
    private List<TBajlb> bajls;
    private TZgtzd zgtzd;
    private List<TZgtzd> zgtzds;
    private List<TZgtzdMx> mxList;
    private TSystem system = InitSysParams.system;
    private File file;
    private String fileFileName;
    private WsbzXbBus wsbzBus;
    private String id;
    private String flag;
    private String barq;
    private String bayy;

    public PunishAction() {
        if (punBus == null)
            punBus = new PunishBus();
        if (cflxs == null)
            cflxs = new TCflxBus().getMap();
        if (serialBus == null)
            serialBus = new SerialBus();
        if (wsbzBus == null)
            wsbzBus = new WsbzXbBus();
    }

    /**
     * δ������¼�б�
     *
     * @return
     */
    public String listForAdd() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("njqx");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                if (jgdm == null)
                    jgdm = new TJgdm();
                String sql = "from TJgdm model  where   model.jgdm not in (select cfjlb.jgdm from  TCfjlb cfjlb) and " + sql();
                if (jgdm.getJgdm() != null) {
                    sql += " and model.jgdm like '%" + jgdm.getJgdm() + "%' ";
                }

                jgdms = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                int count = ((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue();
                page.setTotalRecord(count);
                em.clear();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ���Υ�����");
                currentPath = path + "listForAdd.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * ��������
     *
     * @return
     */
    public String list_punish() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lrrq");
                    page.setOrderByType("desc");
                }
                if (cfjl == null) {
                    cfjl = new TCfjlb();
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TCfjlb model where " + sql() + " and model.cfbz=false ";
                if (cfjl.getJgdm() != null && !"".equals(cfjl.getJgdm())) {
                    sql += " and model.jgdm like '%" + cfjl.getJgdm() + "%'  ";
                } else {
                    if (startDate != null) {
                        sql += " and model.lrrq >= '" + DateUtil.dateToStr(startDate) + "'  ";
                    }
                    if (endDate != null) {
                        sql += " and model.lrrq < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                    }
                }
                if (cfjl == null)
                    cfjl = new TCfjlb();
                punishs = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                int count = ((Long) em.createQuery("select count (model) " + sql)
                        .getResultList().get(0)).intValue();
                page.setTotalRecord(count);
                em.clear();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; Υ�洦��");
                currentPath = path + "list_punish.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * ��������
     *
     * @return
     */
    public String list_hzcq() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("zjhm");
                    page.setOrderByType("desc");
                }
                if (hzcq == null) {
                    hzcq = new Hzcq();
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from Hzcq model where 1=1  ";
                if (hzcq.getJgdm() != null && !"".equals(hzcq.getJgdm())) {
                    sql += " and model.jgdm like '%" + hzcq.getJgdm() + "%'  ";
                }
                if (hzcq.getFddbr() != null && !"".equals(hzcq.getFddbr())) {
                    sql += " and model.fddbr like '%" + hzcq.getFddbr() + "%'  ";
                }
                if (hzcq.getZjhm() != null && !"".equals(hzcq.getZjhm())) {
                    sql += " and model.zjhm like '%" + hzcq.getZjhm() + "%'  ";
                }

                hzcqs = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                int count = ((Long) em.createQuery("select count (model) " + sql)
                        .getResultList().get(0)).intValue();
                page.setTotalRecord(count);
                em.clear();
                setTitle("���� &gt;&gt;��֤���ڹ��� &gt;&gt; ��֤���ڹ���");
                currentPath = path + "list_hzcq.jsp";
            }
        }.nSyTemplate();
    }

    public String remove_hzcq() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (hzcq == null || hzcq.getJgdm() == null) {
                    throw new Exception("���ݴ������");
                }
                hzcq = em.find(Hzcq.class, hzcq.getJgdm());
                message = "���ˣ�" + hzcq.getFddbr() + "���Ļ��������룺" + hzcq.getJgdm() + "�������ϳ��������Ѿ��������������ذ�֤��λ�������촦�������ҵ�񣬷���ϵͳ�����¼�¼��";
                em.remove(hzcq);
                em.flush();
                setTitle("���� &gt;&gt;��֤���ڹ��� &gt;&gt; ��֤���ڹ���");
                currentPath = path + "delsuc.jsp";
            }
        }.template();
    }

    /**
     * �Ѿ�������¼�б�
     *
     * @return
     */
    public String list_punish_back() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("cfrq");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                if (cfjl == null)
                    cfjl = new TCfjlb();
                String sql = " from TCfjlb model where " + sql() + " and model.fkje<> 0 and model.cfbz=true ";
                if (cfjl.getJgdm() != null && !"".equals(cfjl.getJgdm())) {
                    sql += " and model.jgdm like '%" + cfjl.getJgdm() + "%'  ";
                } else {
                    if (startDate != null) {
                        sql += " and model.cfrq >= '" + DateUtil.dateToStr(startDate) + "'  ";
                    }
                    if (endDate != null) {
                        sql += " and model.cfrq < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                    }
                }
                punishs = em.createQuery("select model" + sql + orderBy)

                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                int count = ((Long) em.createQuery("select count(model)" + sql)

                        .getResultList().get(0)).intValue();
                page.setTotalRecord(count);

                em.clear();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; Υ�洦���˿�");
                currentPath = path + "list_punish_back.jsp";
            }
        }.nSyTemplate();
    }
    
    
    public String rectification_list_je(){
    	return new ActionUtils(session) {
    		@Override
            protected void excute() throws Exception {
    			if (page == null) {
                    page = new Page();
                    //page.setOrderByField("lrrq");
                    page.setOrderByType("desc");
                }
                if (cfjl == null) {
                    cfjl = new TCfjlb();
                }
                String sql = " from t_cfjlb model where 1=1 ";
                if (cfjl.getJgdm() != null && !"".equals(cfjl.getJgdm())) {
                    sql += " and  model.jgdm like '%" + cfjl.getJgdm()+ "%'";
                }
                if (cfjl.getBzjgdm() != null && !"".equals(cfjl.getBzjgdm())) {
                    sql += " and  model.bzjgdm=" + cfjl.getBzjgdm();
                }
                if (cfjl.getJglx() != null && !"".equals(cfjl.getJglx())) {
                    sql += " and  model.jglx=" + cfjl.getJglx();
                }
                if (startDate != null) {
                    sql += " and  model.lrrq >='" + DateUtil.dateToStr(startDate) + "'";
                }
                if (endDate != null) {
                    sql += " and  model.lrrq <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                List<TCfjlb[]> punish = em.createNativeQuery("select SUM(model.fkje) as fkje,model.bzjgdm as bzjgdm" + sql +"group by model.bzjgdm")
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Integer) em.createNativeQuery("select count(a.bzjgdm) from(select count(model.bzjgdm) as bzjgdm" + sql +"group by model.bzjgdm"+")"+"as a")
		                .getResultList().get(0)).intValue());
                punishs=new ArrayList<TCfjlb>();
                for(Object[] a:punish){
                	TCfjlb cf=new TCfjlb();
                	cf.setFkje(Integer.parseInt(a[0].toString()));
                	cf.setBzjgdm(a[1].toString());
                	punishs.add(cf);
                }
                setTitle("���� &gt;&gt; ������ѯͳ�� &gt;&gt;�������ͳ��");
                currentPath = path + "rectification_list_je.jsp";
    		}
    	}.nSyTemplate();
    }

    /**
     * ��ʾһ��������¼
     *
     * @return
     */
    public String show_punish() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                cfjl = em.find(TCfjlb.class, cfjl.getId());
                em.clear();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; Υ�洦��");
                currentPath = path + "punish.jsp";
            }
        }.nSyTemplate();
    }

    public String show() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                cfjl = em.find(TCfjlb.class, cfjl.getId());
                em.clear();
                setTitle("���� &gt;&gt; ������ѯͳ�� &gt;&gt;Υ�洦����ѯ");
                currentPath = path + "show_punish.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * ��ʾһ��������¼
     *
     * @return
     */
    public String show_jgdm() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ���Υ�����");
                currentPath = path + "add.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * ��ʾһ��������¼
     *
     * @return
     */
    public String add() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                cfjl.setCfbz(false);
                cfjl.setLrr(user.getUserName());
                cfjl.setLrrq(new Date());
              /*  Map<Object, Object> objectMap = BeanUtilsEx.describe(cfjl);
                for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
                    System.out.println("entry.getKey()+\":\"+entry.getValue() = " + entry.getKey() + ":" + entry.getValue());
                }*/
                em.persist(cfjl);
                em.flush();
                setSource("listForAdd");
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ���Υ�����");
                setMessage("�Ի������루" + cfjl.getJgdm() + "�����Υ���¼�ɹ�!");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * * @return
     */
    public String addAll() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                int[] errors = new int[11];
                int all = 0;
                int suc = 0;
                for (int i = 0; i < errors.length; i++) {
                    errors[i] = 0;
                }
                try {
                    FileInputStream is = new FileInputStream(file);
                    Workbook wbs;
                    if (fileFileName.toLowerCase().endsWith("xlsx")) {
                        wbs = new XSSFWorkbook(is);
                    } else {
                        wbs = new HSSFWorkbook(is);
                    }

                    Sheet childSheet = wbs.getSheetAt(0);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date;
                    for (int j = 0; j <= childSheet.getLastRowNum(); j++) {
                        all++;
                        Row s = childSheet.getRow(j);
                        cfjl = new TCfjlb();
                        Cell cell = s.getCell(0);
                        cfjl.setJgdm(getCellValue(cell));
                        if (!CheckCode.isCheckCode(cfjl.getJgdm())) {
                            errors[0]++;
                            continue;
                        }
                        TJgdm jgdm = em.find(TJgdm.class, cfjl.getJgdm());
                        if (jgdm == null) {
                            errors[0]++;
                            continue;
                        }
                        List list = em.createQuery("select model from  TJgdm model where " + sql() + " and model.jgdm=:jgdm").setParameter("jgdm", cfjl.getJgdm()).getResultList();
                        if (list == null || list.isEmpty()) {
                            errors[4]++;
                            continue;
                        }
                        List<TCfjlb> cfjlblist = em.createQuery("SELECT model  from  TCfjlb model where model.jgdm =:jgdm and model.cfbz=false").setParameter("jgdm", cfjl.getJgdm()).getResultList();
                        if (cfjlblist != null && !cfjlblist.isEmpty()) {
                            errors[10]++;
                            continue;
                        }


                        cfjl.setCfbz(false);
                        cfjl.setLrr(user.getUserName());
                        cfjl.setLrrq(new Date());
                        cell = s.getCell(1);
                        cfjl.setJgmc(getCellValue(cell));

                        cell = s.getCell(2);
                        cfjl.setJglx(getCellValue(cell));

                        cell = s.getCell(3);
                        cfjl.setFddbr(getCellValue(cell));

                        cell = s.getCell(4);
                        cfjl.setBzjgdm(getCellValue(cell));


                        try {
                            cell = s.getCell(5);
                            date = dateFormat.parse(getCellValue(cell));
                            cfjl.setZcrq(date);
                        } catch (ParseException e) {
                            errors[5]++;
                            continue;
                        }
                        try {
                            cell = s.getCell(6);
                            date = dateFormat.parse(getCellValue(cell));
                            cfjl.setZfrq(date);
                        } catch (ParseException e) {
                            errors[6]++;
                            continue;
                        }
                        try {
                            cell = s.getCell(8);
                            date = dateFormat.parse(getCellValue(cell));
                            cfjl.setNjqx(date);
                        } catch (ParseException e) {
                            errors[8]++;
                            continue;
                        }
                        cell = s.getCell(7);
                        cfjl.setJgdz(getCellValue(cell));
                        cell = s.getCell(9);
                        cfjl.setCflx(getCellValue(cell));
                        if (!jgdm.getJgmc().equals(cfjl.getJgmc())) {
                            errors[1]++;
                            continue;
                        }
                        if (!jgdm.getJglx().equals(cfjl.getJglx())) {
                            errors[2]++;
                            continue;
                        }
                        if (!jgdm.getFddbr().equals(cfjl.getFddbr())) {
                            errors[4]++;
                            continue;
                        }
                        if (!jgdm.getBzjgdm().equals(cfjl.getBzjgdm())) {
                            errors[4]++;
                            continue;
                        }
                        if (!jgdm.getBzjgdm().equals(cfjl.getBzjgdm())) {
                            errors[4]++;
                            continue;
                        }
                        if (!jgdm.getZcrq().equals(cfjl.getZcrq())) {
                            errors[5]++;
                            continue;
                        }
                        if (!jgdm.getZfrq().equals(cfjl.getZfrq())) {
                            errors[6]++;
                            continue;
                        }
                        if (!jgdm.getJgdz().equals(cfjl.getJgdz())) {
                            errors[7]++;
                            continue;
                        }
                        if (!jgdm.getNjqx().equals(cfjl.getNjqx())) {
                            errors[8]++;
                            continue;
                        }

                        if (cfjl.getCflx().length() > 2) {
                            errors[9]++;
                            continue;
                        }
                        em.persist(cfjl);
                        suc++;
                    }
                } catch (Exception e) {
                    log.error(PunishAction.class, e);
                    throw e;
                }


                em.flush();
                setSource("listForAdd");
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ���Υ�����");
                setMessage("�������������ɣ���" + all + "��,���е���ɹ�" + suc + "���� ");
                for (int i = 0; i < errors.length; i++) {
                    if (errors[i] > 0) {
                        switch (i) {
                            case 0:
                                message += "�����������" + errors[0] + "���� ";
                                break;
                            case 1:
                                message += "�������ƴ���" + errors[1] + "���� ";
                                break;
                            case 2:
                                message += "�������ʹ���" + errors[2] + "���� ";
                                break;
                            case 4:
                                message += "��֤���������ڱ���֤�������д��" + errors[4] + "���� ";
                                break;
                            case 3:
                                message += "���˻����˴���" + errors[3] + "���� ";
                                break;
                            case 5:
                                message += "ע�����ڴ���" + errors[5] + "���� ";
                                break;
                            case 6:
                                message += "�������ڴ���" + errors[6] + "���� ";
                                break;
                            case 7:
                                message += "������ַ����" + errors[7] + "���� ";
                                break;
                            case 8:
                                message += ",������޴���" + errors[8] + "���� ";
                                break;
                            case 9:
                                message += "�������ʹ���" + errors[9] + "���� ";
                                break;
                            case 10:
                                message += "ϵͳ���Ѿ�����" + errors[10] + "��, ";

                        }
                    }
                }
                message = message.substring(0, message.length() - 2) + "��";
                currentPath = path + "excelSucIn.jsp";
            }

            private String getCellValue(Cell cell) {
                String value = null;
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BLANK:
                        value = null;
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = cell.getBooleanCellValue() ? "true" : "false";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        NumberFormat format = new DecimalFormat("##");

                        value = format.format(cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        value = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_ERROR:
                    case Cell.CELL_TYPE_FORMULA:
                    default:
                        value = "error";
                        break;
                }
                return value;

            }
        }.template();

    }



    /**
     * ��ʾһ��������¼
     *
     * @return
     */
    public String show_punish_back() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                cfjl = em.find(TCfjlb.class, cfjl.getId());
                jgdm = em.find(TJgdm.class, cfjl.getJgdm());
                if (jgdm != null) {
                    cfjl.setJglx(jgdm.getJglx());
                    cfjl.setJgdz(jgdm.getJgdz());
                    cfjl.setJgmc(jgdm.getJgmc());
                    cfjl.setZfrq(jgdm.getZfrq());
                    cfjl.setBzjgdm(jgdm.getBzjgdm());
                    cfjl.setFddbr(jgdm.getFddbr());
                    cfjl.setZjlx(jgdm.getZjlx());
                    cfjl.setZjhm(jgdm.getZjhm());
                }
                em.clear();
                setTitle("���� &gt;&gt;�����˿���� &gt;&gt; �����˿�");
                currentPath = path + "show_punish_back.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * �˿�
     *
     * @return
     */
    public String punish_back_ok() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                cfjl = em.find(TCfjlb.class, cfjl.getId());
                cfjl.setCfbz(true);
                cfjl.setFkje(0);
                cfjl.setCfr(user.getUserName());
                cfjl.setCfrq(new Date());
                em.merge(cfjl);
                em.flush();
                setMessage("�������루" + cfjl.getJgdm() + "���˿���ɣ�");
                setTitle("���� &gt;&gt;�����˿���� &gt;&gt; ��Ϣ����");
                currentPath = path + "search.jsp";
            }
        }.template();
    }

    public String punish_back() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                cfjl = em.find(TCfjlb.class, cfjl.getId());
                cfjl.setCfbz(true);
                cfjl.setFkje(0);
                cfjl.setCfr(user.getUserName());
                cfjl.setCfrq(new Date());
                em.merge(cfjl);
                em.flush();
                setMessage("�������루" + cfjl.getJgdm() + "���˿���ɣ�");
                setTitle("���� &gt;&gt;�����˿���� &gt;&gt; ��Ϣ����");
                setSource("list_punish_back");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * ����
     *
     * @return
     */
    public String punish() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");

                int cfzgbz = 10000000;
                int cfzdbz = 0;
                cfzgbz = system.getCfjesx();
                if (system.getGtsfcf()) {
                    cfzdbz = system.getGtcfsz();
                }
                if ("B".equals(cfjl.getJglx())) {
                    cfzdbz = cfzdbz > user.getCfbz() ? user.getCfbz() : cfzgbz;
                }
                if (cfzgbz < cfjl.getFkje()) {
                    setMessage("���Ĵ�����������ߴ����޶");
                    cfjl = em.find(TCfjlb.class, cfjl.getId());
                    em.clear();
                    setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; Υ�洦��");
                    currentPath = path + "show_punish.jsp";
                    return;
                }

                if (cfzdbz > cfjl.getFkje()) {
                    setMessage("���Ĵ�����������ʹ����޶");
                    cfjl = em.find(TCfjlb.class, cfjl.getId());
                    em.clear();
                    setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; Υ�洦��");
                    currentPath = path + "show_punish.jsp";
                    return;
                }
                TCfjlb cfjl1 = em.find(TCfjlb.class, cfjl.getId());
                cfjl1.setFkje(cfjl.getFkje());
                cfjl1.setCfbz(true);
                cfjl1.setCfrq(new Date());
                cfjl1.setCfr(user.getUserName());
                cfjl1.setMemo(cfjl.getMemo());
                em.merge(cfjl1);
                em.createNativeQuery("update t_bajlb set cfbz=1 where jgdm='" + cfjl1.getJgdm() + "' and cfbz=0").executeUpdate();
                setMessage("�������루" + cfjl1.getJgdm() + "��������ɣ�");
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; Υ�洦��");
                setSource("list_punish");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String rectificationNotice() {
        return new ActionUtils(session) {

            @Override
            protected void excute() throws Exception {
                if (jgdm == null) {
                    jgdm = new TJgdm();
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";


                String sql = " from TJgdm model where  " + sql();
                if (jgdm.getJgmc() != null && !"".equals(jgdm.getJgmc()))
                    sql = sql + " and model.jgmc like '%" + jgdm.getJgmc() + "%' ";
                if (jgdm.getBzjgdm() != null && !"*".equals(jgdm.getBzjgdm()) && !"".equals(jgdm.getBzjgdm()))
                    sql = sql + " and model.bzjgdm ='" + jgdm.getBzjgdm() + "' ";

                if (jgdm.getJgdm() != null && !"".equals(jgdm.getJgdm()))
                    sql = sql + " and model.jgdm like '%" + jgdm.getJgdm() + "%' ";
                if (jgdm.getFddbr() != null && !"".equals(jgdm.getFddbr()))
                    sql = sql + " and model.fddbr like '%" + jgdm.getFddbr() + "%' ";
                if (jgdm.getZjhm() != null && !"".equals(jgdm.getZjhm()))
                    sql = sql + " and model.zjhm like '%" + jgdm.getZjhm() + "%' ";
                jgdms = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize()).getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ��������֪ͨ");
                currentPath = path + "rectificationNotice.jsp";
            }
        }.template();
    }

    /**
     * ��쳬���б�
     *
     * @return
     */
    public String checkOverDueNotice_list() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("njqx");
                    page.setOrderByType("desc");
                }
                String sql = "from TJgdm model where " + sql();

                if (startDate != null) {
                    sql += " and model.njqx >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.njqx < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                jgdms = em.createQuery("select model  " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                if (jgdms == null || jgdms.isEmpty()) {
                    setMessage("��ǰʱ�������ڣ���������쳬�ڵĻ�����");
                } else {
                    page.setTotalRecord(((Long) em.createQuery("select count(model)" + sql)
                            .getResultList().get(0)).intValue());
                }

                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt;��쳬��֪ͨ");
                currentPath = path + "checkOverDueNotice_list.jsp";
            }
        }.nSyTemplate();
    }

    public String checkOverDueNotice() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                if (jgdm == null) {
                    throw new Exception("��ǰʱ�������ڣ���������쳬�ڵĻ�����");
                }

                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt;��ӡ��쳬��֪ͨ");
                currentPath = path + "checkOverDueNotice.jsp";
            }
        }.nSyTemplate();
    }

    public String noticeBooks() {
        return new ActionUtils() {

            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String[] checkedJgdms = jgdmIds.split(",");
                if (checkedJgdms == null || checkedJgdms.length <= 0) {
                    setMessage("û��ѡ���¼���޷�����֪ͨ����");
                    setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ��������֪ͨ��");
                    currentPath = path + "rectificationNotice.jsp";
                } else {
                    String lsh = (String) em.createNativeQuery("select max(substring(lshjc,5,6)) from t_zgtzd").getSingleResult();
                    Integer intLsh = 0;
                    if (clsStringTool.isEmpty(lsh)) {
                        intLsh = 1;
                    } else
                        intLsh = Integer.valueOf(lsh) + 1;

                    lsh = "";
                    for (int i = 0; i < 6 - intLsh.toString().length(); i++) {
                        lsh += "0";
                    }
                    lsh += intLsh;
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    jgdm = em.find(TJgdm.class, checkedJgdms[0]);
                    zgtzd = new TZgtzd();
                    String zglsh = "��š�" + year + "����" + lsh + "��";
                    zgtzd.setZglsh(zglsh);
                    zgtzd.setLshjc(year + "" + lsh);
                    zgtzd.setBzjgdm(user.getBzjgdm());
                    zgtzd.setJgdm(jgdm.getJgdm());
                    zgtzd.setJgmc(jgdm.getJgmc());
                    zgtzd.setFddbr(jgdm.getFddbr());
                    zgtzd.setZjhm(jgdm.getZjhm());
                    zgtzd.setZch(jgdm.getZch());
                    zgtzd.setScrq(new Date());
                    em.persist(zgtzd);


                    em.flush();
                    mxList = new ArrayList<TZgtzdMx>();
                    for (String checkedJgdm : checkedJgdms) {
                        TJgdm jgdm = em.find(TJgdm.class, checkedJgdm);
                        TZgtzdMx mx = new TZgtzdMx();
                        mx.setZglsh(zglsh);
                        mx.setBzjgdm(user.getBzjgdm());
                        mx.setJgdm(jgdm.getJgdm());
                        mx.setJgmc(jgdm.getJgmc());
                        mx.setFddbr(jgdm.getFddbr());
                        mx.setZjhm(jgdm.getZjhm());
                        mx.setZch(jgdm.getZch());
                        mx.setBzrq(jgdm.getBzrq());
                        mx.setZfrq(jgdm.getZfrq());
                        mx.setNjqx(jgdm.getNjqx());
                        mx.setZxdh(jgdm.getDhhm());
                        mx.setType("*");
                        mx.setNote("����");
//                        Map<Object, Object> map = BeanUtilsEx.describe(mx);
//                        for (Map.Entry<Object, Object> entry : map.entrySet())
//                            System.out.println("entry.getKey()+\":\"+entry.getKey() = " + entry.getKey() + ":" + entry.getKey());
                        mxList.add(mx);
                        em.persist(mx);
                    }
                    em.flush();
                    TZgtzdPK pk = new TZgtzdPK();
                    zgtzds = em.createQuery("from TZgtzd where zglsh='" + zgtzd.getZglsh() + "'").getResultList();
                    if (zgtzds != null && !zgtzds.isEmpty())
                        zgtzd = zgtzds.get(0);
                    mxList = em.createQuery("from TZgtzdMx  where zglsh='" + zgtzd.getZglsh() + "'").getResultList();
                }
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ��������֪ͨ��");
                currentPath = path + "notice.jsp";
            }
        }.template();
    }

    public String showNotice() {
        return new ActionUtils() {

            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                zgtzds = em.createQuery("from TZgtzd where lshjc='" + zgtzd.getJgdm() + "'").getResultList();
                if (zgtzds != null && !zgtzds.isEmpty()) {
                    zgtzd = zgtzds.get(0);
                    mxList = em.createQuery("from TZgtzdMx  where zglsh='" + zgtzd.getZglsh() + "'").getResultList();
                    for (TZgtzdMx mx : mxList) {
                    }
                } else {
                    throw new Exception("��Ϣ��¼������");
                }

                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; ��������֪ͨ����ӡ");
                currentPath = path + "notice2.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * ��ʾһ��������¼
     *
     * @return
     */
    public String updateOverDue() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                eupdateOverDue();
            }
        }.nSyTemplate();
    }

    public void eupdateOverDue() {
        setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; �������¼��");
        setSource("show_updateOverDue");
        currentPath = path + "search.jsp";
    }

    /**
     * ��ʾһ��������¼
     *
     * @return
     */
    public String show_updateOverDue() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, cfjl.getJgdm());
                if (jgdm == null) {
                    setMessage("��ѯ�Ļ�����Ϣ�����ڣ�");
                    eupdateOverDue();
                    return;
                }
                em.clear();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; �������¼��");
                currentPath = path + "updateOverDueIn.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * �������¼��
     *
     * @return
     */
    public String updateOverDueIn() {
        return new ActionUtils() {

            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, cfjl.getJgdm());
                cfjl.setLrrq(new Date());
                cfjl.setJglx(cfjl.getJglx().split(":")[0]);
                cfjl.setLrr(user.getUserName());
                cfjl.setCflx("04");
                cfjl.setCfbz(false);
                cfjl.setNjqx(jgdm.getNjqx());
                cfjl.setZcrq(jgdm.getZcrq());
                em.merge(cfjl);
                em.flush();
                setTitle("���� &gt;&gt; Υ�洦������ &gt;&gt; �������¼�����");
                setMessage("�������루" + cfjl.getJgdm() + "���������¼��ɹ���");
                setSource("updateOverDue");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String keepOnInfo() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                ekeepOnInfo();
            }
        }.nSyTemplate();
    }

    private void ekeepOnInfo() {
        setTitle("���� &gt;&gt;������Ϣ���� &gt;&gt; ������Ϣ¼��");
        setSource("show_keepOnInfo");
        currentPath = path + "search.jsp";
    }

    public String show_keepOnInfo() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                jgdm = em.find(TJgdm.class, cfjl.getJgdm());
                bajls = em.createQuery("select model from TBajlb model where model.cfbz='0' and model.jgdm='" + cfjl.getJgdm() + "'Order By model.yxrq" ).getResultList();
                String sql;
                Query query;
                //����ҵ��
               
                if (!clsStringTool.isEmpty(flag)) {
                    Wba ba = wsbzBus.findWba(id);
                    if (ba != null) {
                        barq = ba.getBarq();
                        bayy = ba.getBayy();
                    }
                }
                if (jgdm == null) {
                    setMessage("��ѯ�Ļ�����Ϣ�����ڣ�");
                    ekeepOnInfo();
                    return;
                }
                if ((bajls != null) && !bajls.isEmpty()) {
	                TBajlb bajl = new TBajlb();
	                for(TBajlb tba : bajls){
	                	//tba.setYxrq(tba.getYxrq());
	                	bajl.setYxrq(tba.getYxrq());
	                }
//	                if(bajl.getYxrq().after(new Date())){
//	                	if ((bajls != null) && !bajls.isEmpty()) {
//	                        setMessage("�ѶԸû�����" + cfjl.getJgdm() + "�����˱�����¼������Ҫ�ٴα�����");
//	                        ekeepOnInfo();
//	                        return;
//	                    }
//	                }
                }
                //sql = "UPDATE TZs model SET model.cfbz='0' where model.cfbz='0' and model.jgdm=:jgdm'";
                //query = em.createQuery(sql);
                setTitle("���� &gt;&gt;������Ϣ���� &gt;&gt; ������Ϣ¼��");
                setSource("keepOnInfoIn");
                currentPath = path + "keepOnInfoIn.jsp";
            }
        }.nSyTemplate();


    }

    public String keepOnInfoIn() {

        String result = new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                bajl.setBarq(new Date());
                bajl.setCfbz(false);
                bajl.setLrr(user.getUserName());
                bajl.setLrsj(new Date());
                em.persist(bajl);
                em.flush();
                setTitle("���� &gt;&gt; ������Ϣ���� &gt;&gt; ������Ϣ¼�����");
                setMessage("�������루" + bajl.getJgdm() + "��������Ϣ¼��ɹ���");
                setSource("keepOnInfo");
                currentPath = path + "success.jsp";
            }
        }.template();

        if (result.equalsIgnoreCase("SUCCESS")) {
            wsbzBus.updateWba(bajl.getJgdm());
        }
        return result;
    }

    /**
     * ������Ϣ�б�
     *
     * @return
     */
    public String keepOnInfo_list() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("yxrq");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "from TBajlb model where  " + sql();
                if (bajl == null) {
                    bajl = new TBajlb();
                }
                if (startDate != null)
                    sql += " and model.barq >='" + DateUtil.dateToStr(startDate) + "'";
                if (bajl.getBarq() != null) {
                    sql += " and model.barq <'" + DateUtil.dateToStr(DateUtil.dayAfter(bajl.getBarq(), 1)) + "'";
                }

                if (endDate != null) {
                    Date end = DateUtil.dayAfter(endDate, 1);
                    sql += " and model.yxrq <'" + DateUtil.dateToStr(end) + "'";
                }

                if (bajl.getYxrq() != null)
                    sql += " and model.yxrq >='" + DateUtil.dateToStr(bajl.getYxrq()) + "'";

                if (bajl.getYxrq() != null)
                    sql += " and model.yxrq >='" + DateUtil.dateToStr(bajl.getYxrq()) + "'";
                if (bajl.getJgdm() != null && !"".equals(bajl.getJgdm()))
                    sql += " and model.jgdm like '%" + bajl.getJgdm() + "%'";

                bajls = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("���� &gt;&gt; ������Ϣ���� &gt;&gt;������Ϣ��ѯ");
                currentPath = path + "keepOnInfo_list.jsp";
            }
        }.template();
    }

    /**
     * Υ���ѯͳ��
     *
     * @return
     */
    public String violationPunish_list() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lrrq");
                    page.setOrderByType("desc");
                }
                if (cfjl == null) {
                    cfjl = new TCfjlb();
                }
                String sql = " from TCfjlb model where " + sql();
                if (cfjl.getJgdm() != null || !"".equals(cfjl.getJgdm())) {
                    sql += " and  model.jgdm like '%" + cfjl.getJgdm() + "%'";
                }
                HttpServletRequest request = ServletActionContext.getRequest();
                String ccfbz = request.getParameter("cfbz");
                if (clsStringTool.isEmpty(ccfbz)) {
                    cfjl.setCfbz(null);
                } else {
                    cfjl.setCfbz(Boolean.valueOf(ccfbz));
                }
                if (cfjl.getCfbz() != null && !"".equals(cfjl.getCfbz())) {
                    sql += " and  model.cfbz=" + cfjl.getCfbz();
                }
                if (startDate != null) {
                    sql += " and  model.lrrq >='" + DateUtil.dateToStr(startDate) + "'";
                }
                if (endDate != null) {
                    sql += " and  model.lrrq <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";


                punishs = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
                setTitle("���� &gt;&gt; ������ѯͳ�� &gt;&gt;Υ�洦����ѯ");
                currentPath = path + "violationPunish_list.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * Υ���ѯͳ��
     *
     * @return
     */
    public String rectification_list() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("scrq");
                    page.setOrderByType("desc");
                }
                if (zgtzd == null) {
                    zgtzd = new TZgtzd();
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "from TZgtzd  model where " + sql() + " and  model.lshjc like '%" + (zgtzd.getZglsh() == null ? "" : zgtzd.getZglsh()) + (zgtzd.getLshjc() == null ? "" : zgtzd.getLshjc()) + "%' ";
                if (startDate != null) {
                    sql += " and model.scrq >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.scrq < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                zgtzds = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model.zglsh) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("���� &gt;&gt; ������ѯͳ�� &gt;&gt;����֪ͨ����ѯ");
                currentPath = path + "rectification_list.jsp";
            }
        }.nSyTemplate();
    }

    public List<TCfjlb> getPunishs() {
        return punishs;
    }

    public void setPunishs(List<TCfjlb> punishs) {
        this.punishs = punishs;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public TCfjlb getCfjl() {
        return cfjl;
    }

    public void setCfjl(TCfjlb cfjl) {
        this.cfjl = cfjl;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, String> getCflxs() {
        return cflxs;
    }

    public void setCflxs(Map<String, String> cflxs) {
        this.cflxs = cflxs;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public List<TJgdm> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TJgdm> jgdms) {
        this.jgdms = jgdms;
    }

    public String getJgdmIds() {
        return jgdmIds;
    }

    public void setJgdmIds(String jgdmIds) {
        this.jgdmIds = jgdmIds;
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

    public TBajlb getBajl() {
        return bajl;
    }

    public void setBajl(TBajlb bajl) {
        this.bajl = bajl;
    }

    public List<TBajlb> getBajls() {
        return bajls;
    }

    public void setBajls(List<TBajlb> bajls) {
        this.bajls = bajls;
    }

    public TZgtzd getZgtzd() {
        return zgtzd;
    }

    public void setZgtzd(TZgtzd zgtzd) {
        this.zgtzd = zgtzd;
    }

    public List<TZgtzdMx> getMxList() {
        return mxList;
    }

    public void setMxList(List<TZgtzdMx> mxList) {
        this.mxList = mxList;
    }


    public List<TZgtzd> getZgtzds() {
        return zgtzds;
    }

    public void setZgtzds(List<TZgtzd> zgtzds) {
        this.zgtzds = zgtzds;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBayy() {
        return bayy;
    }

    public void setBayy(String bayy) {
        this.bayy = bayy;
    }

    public String getBarq() {
        return barq;
    }

    public void setBarq(String barq) {
        this.barq = barq;
    }

    public Hzcq getHzcq() {
        return hzcq;
    }

    public void setHzcq(Hzcq hzcq) {
        this.hzcq = hzcq;
    }

    public List<Hzcq> getHzcqs() {
        return hzcqs;
    }

    public void setHzcqs(List<Hzcq> hzcqs) {
        this.hzcqs = hzcqs;
    }
}