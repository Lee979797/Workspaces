/**
 *
 */
package com.ninemax.jpa.code.action;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import sun.misc.BASE64Encoder;

import com.ninemax.jpa.code.model.DFile0;
import com.ninemax.jpa.code.model.EFile0;
import com.ninemax.jpa.code.model.Model;
import com.ninemax.jpa.code.model.PFile0;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.SmTaskType;
import com.ninemax.jpa.code.model.TArchivePage;
import com.ninemax.jpa.code.model.TBgk;
import com.ninemax.jpa.code.model.TCzjl;
import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.code.model.TQzsm;
import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.code.model.TSmrwsc;
import com.ninemax.jpa.code.model.TSmrwwc;
import com.ninemax.jpa.code.model.WXb;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.global.WsbzEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.FtpUtil;
import com.ninemax.jpa.util.ImageUtil;
import com.ninemax.jpa.util.ThamsActionUtils;
import com.ninemax.jpa.util.UserPropertiesData;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yanzh 扫描任务Action
 */
public class ScanTaskAction extends ActionSupport implements SessionAware {
	private static final String path = "/product/jsp/scanTask/";
	private static Logger log = Logger.getLogger(ScanTaskAction.class);

	private List<TJgdm> jgdms;
	private TJgdm jgdm;
	private TSmrw task;
	private List<TQzsm> qzsms;
	private TQzsm qzsm;
	private TSmrwwc taskwc;
	private List<TSmrw> tasks;
	private List<TSmrwwc> smrwwcs;
	private Page page;
	private Date startDate;
	private Date endDate;

	private Map<String, Object> session;
	private String currentPath;
	private String source;
	private String status;
	private String file;
	private String fileName;
	private String wdidbs;
	private String hidValue;
	private int imageCount;
	private Map<String, Map<String, List<Model>>> maps;
	protected String title;
	private String type;
	private String imageData;
	private String pics;
	private List<DFile0> dFiles;
	private DFile0 dfile;
	private EFile0 efile;
	private String message;
	private List<Byte> data;
	private FtpUtil ftpUtil;
	private String database;
	Map<String, String> zrxzqhMap;

	public ScanTaskAction() {
		ftpUtil = new FtpUtil();
	}

	/**
	 * 批量审核
	 * 
	 * @return
	 */
	public String audingAll() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				if (dfile.getAttr() == 0) {
					String sql = " from DFile0 model where  model.attr=1   ";
					if (dfile.getJgdm() != null && !dfile.getJgdm().equals("")) {
						sql += " and model.jgdm like '%" + dfile.getJgdm() + "%'";
					}
					if (dfile.getBzjgdm() != null && !"".equals(dfile.getBzjgdm())) {
						sql += " and model.bzjgdm ='" + dfile.getBzjgdm() + "'";
					}
					if (dfile.getNewdate() != null) {
						sql += " and model.newdate >='" + DateUtil.dateToStr(dfile.getNewdate()) + "'";
					}
					if (endDate != null) {
						sql += " and model.newdate <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
					}
					if (startDate != null) {
						sql += " and model.modifydate >='" + DateUtil.dateToStr(startDate) + "'";
					}
					if (dfile.getModifydate() != null) {
						sql += " and model.modifydate <'" + DateUtil.dateToStr(DateUtil.dayAfter(dfile.getModifydate(), 1)) + "'";
					}
					if (dfile.getArctype() != null && !"".equals(dfile.getArctype())) {
						for (Map.Entry<String, String> entry : SmTaskType.dTypes().entrySet()) {
							if (entry.getValue().equals(dfile.getArctype())) {
								dfile.setArctype(entry.getKey());
							}
						}
						sql += " and model.arctype ='" + dfile.getArctype() + "'";
					}

					dFiles = em.createQuery("select model " + sql).getResultList();
					for (int i = dFiles.size() - 1; i >= 0; i--) {
						DFile0 file = dFiles.get(i);
						file.setAttr(0);
						dFiles.remove(i);
					}
					em.flush();
				}
				message = "批量审核通过成功！";
				page = new Page();
				page.setOrderByField("modifydate");
				page.setOrderByType("desc");
				currentPath = path + "list_dfile.jsp";
			}
		}.template();
	}

	/**
	 * 前置扫描
	 * 
	 * @return
	 */

	public String list_qzsm() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				if (qzsm == null) {
					qzsm = new TQzsm();
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("createTime");
					page.setOrderByType("desc");

				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";
				String sql = " from  TQzsm model where " + (getUser().getUserName().contains("admin") ? " 1=1 " : sql());
				if (qzsm.getJgdm() != null && !qzsm.getJgdm().equals("")) {
					sql += " and model.jgdm like '%" + qzsm.getJgdm() + "%'";
				} else {
					if (qzsm.getJgmc() != null && !"".equals(qzsm.getJgmc())) {
						sql += " and model.jgmc like '%" + qzsm.getJgmc() + "%'";
					}
					if (qzsm.getType() != null && !"".equals(qzsm.getType())) {
						sql += " and model.type ='" + qzsm.getType().trim() + "'";
					}
					if (startDate != null) {
						sql += " and model.createTime >= '" + DateUtil.dateToStr(startDate) + "'";
					}
					if (qzsm.getCreateTime() != null) {
						Date end = DateUtil.dayAfter(qzsm.getCreateTime(), 1);
						sql += " and model.createTime < '" + DateUtil.dateToStr(end) + "'";
					}
					if (qzsm.getCompleTime() != null) {
						sql += " and model.compleTime >= '" + DateUtil.dateToStr(qzsm.getCompleTime()) + "'";
					}
					if (endDate != null) {
						Date end = DateUtil.dayAfter(endDate, 1);
						sql += " and model.compleTime < '" + DateUtil.dateToStr(end) + "'";
					}
				}
				qzsms = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
						.getResultList();
				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
				em.clear();
				currentPath = path + "list_qzsm.jsp";
			}
		}.template();
	}

	public String deleteRW() {

		return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				if (task == null || task.getId() == null) {
					throw new Exception("数据传输出错");
				}
				
				TSmrwsc tsmrwsc = new TSmrwsc();
				task = em.find(TSmrw.class, task.getId());
				message = "机构代码（" + task.getJgdm() + "）类型为" + SmTaskType.get(Integer.valueOf(task.getType())) + "扫描任务删除成功!";
				BeanUtilsEx.copyProperties(tsmrwsc, task);
				em.remove(task);
				tsmrwsc.setId(null);
				em.persist(tsmrwsc);
				em.flush();
				currentPath = path + "delsuc.jsp";
			}
		}.template();
	}

	public String show_qzsm() {

		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				if (qzsm == null || qzsm.getId() == null) {
					throw new Exception("数据传输出错");
				}

				qzsm = em.find(TQzsm.class, qzsm.getId());
				if (qzsm.getImagePath() != null) {
					String[] names = qzsm.getImagePath().split("(/|\\\\)");
					fileName = names[names.length - 1].split("\\.")[0];
					List<TArchivePage> pages = null;
					pages = em.createQuery("select model from TArchivePage model where model.archid=?1 order by model.pageno ").setParameter(1,
							fileName).getResultList();
					wdidbs = "";
					if (pages != null && !pages.isEmpty()) {
						for (TArchivePage page : pages) {
							// wdidbs += page.getPagetype() + ";";
							wdidbs += page.getPagetype() + "%";
						}
						if (wdidbs.length() > 0)
							wdidbs = wdidbs.substring(0, wdidbs.length() - 1);
					}
				}

				em.clear();
				// 获取图片数据,先从ftp服务器上下载图片到服务器本地文件夹，在读取生成base64加密数据流，传递到页面控件中。在删除服务器本地
				// 图片文件
				String filePath = qzsm.getImagePath();
				if (filePath != null && !"".equals(filePath)) {
					String imagePath = (filePath.substring(0, filePath.lastIndexOf("\\")));
					if (ftpUtil == null)
						ftpUtil = new FtpUtil();
					try {
						if (ftpUtil.connectServer(imagePath)) {

							File file1 = make(filePath.substring(filePath.lastIndexOf("\\") + 1));
							ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\") + 1), file1);
							// imageData =
							// ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\")
							// + 1));
							file1 = null;
						}

					} catch (Exception e) {
						log.error(ScanTaskAction.class, e);
						imageData = "";
					}
				}
				if ("old".equals(type)) {
					currentPath = path + "show_qzsm.jsp";
				} else
					currentPath = path + "showNew_qzsm.jsp";
			}
		}.template();
	}

	public String delete_qzsm() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {

				if (qzsm == null || qzsm.getId() == null) {
					throw new Exception("数据传输出错");
				}
				qzsm = em.find(TQzsm.class, qzsm.getId());
				if (qzsm.getImagePath() != null) {
					String[] names = qzsm.getImagePath().split("(/|\\\\)");
					fileName = names[names.length - 1].split("\\.")[0];
					em.createQuery("delete from TArchivePage model where model.archid='" + fileName + "'").executeUpdate();
				}
				em.remove(qzsm);
				em.flush();
				currentPath = path + "ok.jsp";
			}
		}.template();
	}

	/**
	 * 前置扫描
	 * 
	 * @return
	 */
	public String qzsm() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				currentPath = path + "qzsm.jsp";
			}
		}.template();
	}

	/**
	 * 检查前置扫描对应数据
	 * 
	 * @return
	 */
	public String qzsm_check() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				if (qzsm == null || qzsm.getType() == null) {
					message = "请重新输入扫描机构信息！";
					currentPath = path + "qzsm.jsp";
					return;
				}
				String type = qzsm.getType().trim();
				switch (Integer.valueOf(type)) {
				case 0:
				case 1:
				case 2:
				case 8: {
					currentPath = path + "edit_qzsm.jsp";
					em.persist(qzsm);
					return;
				}
				case 3:
				case 4:
				case 5:
				case 7:
				case 10:
				case 11:
				case 12:
				case 13: {
					TJgdm jgdm = em.find(TJgdm.class, qzsm.getJgdm());
					BeanUtilsEx.copyProperties(qzsm, jgdm);
					qzsm.setType(type);
					em.persist(qzsm);
					currentPath = path + "edit_qzsm.jsp";
					return;
				}

				case 6:
				case 9: {
					TQzjgdm qzjgdm = em.find(TQzjgdm.class, qzsm.getJgdm());
					BeanUtilsEx.copyProperties(qzsm, qzjgdm);
					qzsm.setType(type);
					em.persist(qzsm);
					currentPath = path + "edit_qzsm.jsp";
					return;
				}

				default: {
					message = "请重新输入扫描机构信息！";
					currentPath = path + "qzsm.jsp";
					return;
				}
				}

			}
		}.template();
	}

	/**
	 * 获取对应的扫描任务
	 * 
	 * @return
	 */
	public String list() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				if (task == null) {
					task = new TSmrw();
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("createTime");
					page.setOrderByType("desc");

				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";
				String sql = "";
				if (task.getStatus() == null || !task.getStatus()) {
					sql = " from  TSmrw model where " + (getUser().getUserName().contains("admin") ? " 1=1 " : sql());
				} else {
					sql = " from  TSmrwwc model where " + (getUser().getUserName().contains("admin") ? "  1=1  " : sql());
				}

				if (task.getJgdm() != null && !task.getJgdm().equals("")) {
					sql += " and model.jgdm like '%" + task.getJgdm() + "%'";
				} else {
					if (task.getJgmc() != null && !"".equals(task.getJgmc())) {
						sql += " and model.jgmc like '%" + task.getJgmc() + "%'";
					}
					if (task.getType() != null && !"".equals(task.getType())) {
						sql += " and model.type ='" + task.getType().trim() + "'";
					}
					if (task.getBzjgdm() != null && !"".equals(task.getBzjgdm())) {
						sql += " and model.bzjgdm ='" + task.getBzjgdm().trim() + "'";
					}
					if (task.getCzr() != null && !"".equals(task.getCzr())) {
						sql += " and model.czr like '%" + task.getCzr().trim() + "%'";
					}
					if (startDate != null) {
						sql += " and model.createTime >= '" + DateUtil.dateToStr(startDate) + "'";
					}
					if (task.getCreateTime() != null) {
						Date end = DateUtil.dayAfter(task.getCreateTime(), 1);
						sql += " and model.createTime < '" + DateUtil.dateToStr(end) + "'";
					}
					if (task.getCompleTime() != null) {
						sql += " and model.compleTime >= '" + DateUtil.dateToStr(task.getCompleTime()) + "'";
					}
					if (endDate != null) {
						Date end = DateUtil.dayAfter(endDate, 1);
						sql += " and model.compleTime < '" + DateUtil.dateToStr(end) + "'";
					}

				}
				if (task.getStatus() == null || !task.getStatus()) {
					tasks = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
							.getResultList();
				} else {
					smrwwcs = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
							.getResultList();
				}

				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
				em.clear();
				if (task.getStatus()) {
					setTitle("已完成扫描任务");
				} else {
					setTitle("扫描任务列表");
				}
				currentPath = path + "list.jsp";
			}
		}.template();
	}

	/**
	 * 获取对应的扫描任务
	 * 
	 * @return
	 */

	public String welcome_task() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");

				if (task == null) {
					task = new TSmrw();
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("createTime");
					page.setOrderByType("desc");
				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";
				String sql = "";
				int date = InitSysParams.system.getSmqx();
				if (date > 0) {
					sql = " from  TSmrw model where " + sql() + " and  (model.status=false or model.status is null ) and model.createTime<:date";
					date += InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim()).getSmyq() == null ? 0 : InitSysParams.zrxzqhMap2.get(
							user.getBzjgdm().trim()).getSmyq();

					page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).setParameter("date",
							DateUtil.dayBefore(new Date(), date)).getResultList().get(0)).intValue());
					if (page.getTotalRecord() > 0) {
						tasks = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(
								page.getPageSize()).setParameter("date", DateUtil.dayBefore(new Date(), date)).getResultList();
						currentPath = path + "welcome_task.jsp";
						setTitle("扫描任务列表");
						em.clear();
						return;
					}
				}

				date = InitSysParams.system.getDaqx();
				if (date > 0) {
					sql = " from DFile0 model where " + sql()
							+ " and  model.status!=-1 and  model.attr=2  and  model.errorflag<>-2 and model.edittime<?1  ";
					date += InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim()).getDayq() == null ? 0 : InitSysParams.zrxzqhMap2.get(
							user.getBzjgdm().trim()).getDayq();
					page.setTotalRecord(((Long) ThamsEntityManagerHelper.getEntityManager().createQuery("select count(model) " + sql).setParameter(1,
							DateUtil.dayBefore(new Date(), date)).getResultList().get(0)).intValue());
					ThamsEntityManagerHelper.closeEntityManager();
					if (page.getTotalRecord() > 0) {
						dFiles = ThamsEntityManagerHelper.getEntityManager().createQuery("select model " + sql).setParameter(1,
								DateUtil.dayBefore(new Date(), date)).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
								.getResultList();

						currentPath = path + "welcome_dfile.jsp";
						setTitle("需修改档案问题列表");
						em.clear();
						return;
					}
				}
				date = InitSysParams.system.getSjqx();
				if (date > 0) {
					sql = " from t_jgdm model where cast(model.memo_bak5 as datetime )  <?1 and " + sql() + " and model.wtbz=2 ";
					date += InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim()).getSjyq() == null ? 0 : InitSysParams.zrxzqhMap2.get(
							user.getBzjgdm().trim()).getSjyq();
					page.setTotalRecord(((Integer) em.createNativeQuery("select count(model.jgdm) " + sql).setParameter(1,
							DateUtil.dayBefore(new Date(), date)).getResultList().get(0)));
					if (page.getTotalRecord() > 0) {
						jgdms = em.createNativeQuery("select * " + sql, TJgdm.class).setParameter(1, DateUtil.dayBefore(new Date(), date))
								.setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize()).getResultList();
						currentPath = path + "welcome_wtsj.jsp";
						setTitle("问题数据修改");
						em.clear();
						return;
					}
				}
				em.clear();
				currentPath = path + "/redirct.jsp";
			}
		}.template();
	}

	public String list_jgdm() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				if (jgdm == null) {
					jgdm = new TJgdm();
					 page = new Page();
					 currentPath = path + "list_jgdm.jsp";
                     return;
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("lastdate");
					page.setOrderByType("desc");
				}
				if (database == null)
					database = TJgdm.class.getName();
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";
				String sql = " from  " + database + " model where " + sql() + " and  model.jgdm like '%"
						+ (jgdm.getJgdm() == null ? "" : jgdm.getJgdm()) + "%'";
				jgdms = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
						.getResultList();
				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
				em.clear();
				currentPath = path + "list_jgdm.jsp";
			}
		}.template();
	}

	public String add() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				tasks = em.createQuery("select model from  TSmrw model where model.jgdm =:jgdm and model.status is null").setParameter("jgdm",
						jgdm.getJgdm()).getResultList();
				if (tasks == null || tasks.isEmpty()) {
					task = new TSmrw();
					if (database == null || database.equals(TJgdm.class.getName())) {
						jgdm = em.find(TJgdm.class, jgdm.getJgdm());
						BeanUtilsEx.copyProperties(task, jgdm);
					} else if (database.equals(TQzjgdm.class.getName())) {
						TQzjgdm tQzjgdm = em.find(TQzjgdm.class, Integer.valueOf(jgdm.getJgdm().trim()));
						if (tQzjgdm != null) {
							BeanUtilsEx.copyProperties(task, tQzjgdm);
							task.setJgdm(tQzjgdm.getId().toString());
						}

					} else if (database.equals(TFzdm.class.getName())) {
						TFzdm fzdm = em.find(TFzdm.class, jgdm.getJgdm());
						if (fzdm != null) {
							BeanUtilsEx.copyProperties(task, fzdm);
						}
					} else if (database.equals(TBgk.class.getName())) {
						TBgk fzdm = em.find(TBgk.class, Long.valueOf(jgdm.getJgdm().trim()));
						if (fzdm != null) {
							BeanUtilsEx.copyProperties(task, fzdm);
							task.setJgdm(fzdm.getSn() + "");
						}
					}

					task.setBzjgdm(user.getBzjgdm());
					task.setId(null);
					task.setType(null);
					task.setStatus(false);
					task.setCreateTime(new Date());
					/*
					 * em.persist(task); em.flush();
					 */
				} else {
					task = tasks.get(0);
				}
				em.clear();
				xbclInfo();
				source = "list_jgdm";
				if ("old".equals(type)) {
					currentPath = path + "edit.jsp";
				} else
					currentPath = path + "editNew.jsp";
			}
		}.nSyTemplate();
	}

	public String edit() {
		return new ActionUtils() {
			private EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();

			@Override
			protected void excute() throws Exception {
				if (task == null || task.getId() == null) {
					throw new Exception("数据传输出错");
				}

				task = em.find(TSmrw.class, task.getId());
				if (task.getStatus() == null)
					task.setStatus(false);
				if (task.getImagePath() != null) {
					String[] names = task.getImagePath().split("(/|\\\\)");
					fileName = names[names.length - 1].split("\\.")[0];
					List<PFile0> pages = null;
					try {
						dfile = (DFile0) thamsManager.createQuery("select model from DFile0 model where model.docid=?1").setParameter(1, fileName)
								.getSingleResult();
						pages = thamsManager.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(1,
								dfile.getDid()).getResultList();
					} catch (Exception e) {
						log.error(ScanTaskAction.class, e);
					} finally {
						ThamsEntityManagerHelper.closeEntityManager();
					}
					wdidbs = "";
					hidValue = "";
					if (pages != null && !pages.isEmpty()) {
						for (PFile0 page : pages) {
							// wdidbs += page.getPagetype() + ";";
							wdidbs += page.getPagetype() + "%";
							/*
							 * for (ScPageKind kind : pageKinds) { if
							 * (page.getPagetype
							 * ().trim().equals(kind.getPagekindName().trim()))
							 * { hidValue += kind.getPagekindId().trim() + ";";
							 * } }
							 */
						}
						if (wdidbs.length() > 1) {
							wdidbs = wdidbs.substring(0, wdidbs.length() - 1);
						}
						if (hidValue.length() > 1) {
							hidValue = hidValue.substring(0, hidValue.length() - 1);
						}
					}

				}
				em.clear();
				// 获取图片数据,先从ftp服务器上下载图片到服务器本地文件夹，在读取生成base64加密数据流，传递到页面控件中。在删除服务器本地
				// 图片文件
				String filePath = task.getImagePath();
				if (filePath != null && !"".equals(filePath)) {
					String imagePath = (filePath.substring(0, filePath.lastIndexOf("\\")));
					String filename = (filePath.substring(filePath.lastIndexOf("\\") + 1));
					if (ftpUtil == null)
						ftpUtil = new FtpUtil();
					try {
						if (ftpUtil.connectServer(imagePath)) {
							File file1 = make(filename);
							ftpUtil.download(filename, file1);
						}
					} catch (Exception e) {
						log.error(ScanTaskAction.class, e);
						imageData = "";
					}
				} else {
					xbclInfo();
				}
				if ("old".equals(type)) {
					currentPath = path + "edit.jsp";
				} else
					currentPath = path + "editNew.jsp";
			}

		}.nSyTemplate();

	}

	private int chage(String type) {
		if (type == null || "".equals(type))
			return -1;
		switch (Integer.valueOf(type)) {
		case 0:
			return 0;
		case 5:
			return 1;

		case 3:
			return 2;
		case 4:
			return 3;

		case 12:
			return 6;
		default:
			return -1;
		}
	}

	private void xbclInfo() {
		EntityManager em = WsbzEntityManagerHelper.getEntityManager();
		// EntityManager wsbzManager =
		// WsbzEntityManagerHelper.getEntityManager();
		try {
			int type = chage(task.getType());
			if (type == -1)
				return;
			List<WXb> xbs = em.createQuery("select model from WXb model where model.jgdm=?1 and model.lb=?2 ").setParameter(1, task.getJgdm())
					.setParameter(2, type).getResultList();
			if (xbs != null && !xbs.isEmpty()) {
				String strXbcl = "";
				String strClmc = "";
				String strsql;
				wdidbs = "";
				List<Object[]> list;
				strsql = "select w_xbcl_wjm,w_xbcl_mc from w_xbcl where w_xbcl_bj = 0 and  w_xbcl_xbid = :xbid and w_xbcl_cllb = 4";
				list = em.createNativeQuery(strsql).setParameter("xbid", xbs.get(0).getDjh()).getResultList();
				if (list != null && list.size() > 0) {
					for (Object[] objects : list) {
						pics += "$" + objects[0].toString();
						wdidbs += ";" + objects[1].toString().substring(0, objects[1].toString().length() - 2);
					}
				}
				strsql = "select w_xbcl_wjm,w_xbcl_mc from w_xbcl where w_xbcl_bj = 0 and  w_xbcl_xbid = :xbid and w_xbcl_cllb <> 4";
				list = em.createNativeQuery(strsql).setParameter("xbid", xbs.get(0).getDjh()).getResultList();
				if (list != null && list.size() > 0) {
					for (Object[] objects : list) {
						pics += "$" + objects[0].toString();
						wdidbs += ";" + objects[1].toString().substring(0, objects[1].toString().length() - 2);
					}
				}
				if (!strXbcl.equals("")) {
					pics = pics.substring(1, pics.length());
					wdidbs = wdidbs.substring(1, strClmc.length());
				}
			}
		} catch (Exception e) {
		} finally {
			WsbzEntityManagerHelper.closeEntityManager();
		}
	}

	public String show() {

		return new ActionUtils() {
			private EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();

			@Override
			protected void excute() throws Exception {
				if (task == null || task.getId() == null) {
					throw new Exception("数据传输出错");
				}

				taskwc = em.find(TSmrwwc.class, task.getId());
				if (taskwc.getImagePath() != null) {
					String[] names = taskwc.getImagePath().split("(/|\\\\)");
					fileName = names[names.length - 1].split("\\.")[0];
					List<PFile0> pages = null;
					try {
						dfile = (DFile0) thamsManager.createQuery("select model from DFile0 model where model.docid=?1").setParameter(1, fileName)
								.getSingleResult();
						pages = thamsManager.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(1,
								dfile.getDid()).getResultList();
					} catch (Exception e) {
					} finally {
						ThamsEntityManagerHelper.closeEntityManager();
					}
					wdidbs = "";
					if (pages != null && !pages.isEmpty()) {
						for (PFile0 page : pages) {
							wdidbs += page.getPagetype() + "%";
						}
						if (wdidbs.length() > 0)
							wdidbs = wdidbs.substring(0, wdidbs.length() - 1);
					}
				}

				em.clear();
				// 获取图片数据,先从ftp服务器上下载图片到服务器本地文件夹，在读取生成base64加密数据流，传递到页面控件中。在删除服务器本地
				// 图片文件
				String filePath = taskwc.getImagePath();
				if (filePath != null && !"".equals(filePath)) {
					String imagePath = (filePath.substring(0, filePath.lastIndexOf("\\")));
					if (ftpUtil == null)
						ftpUtil = new FtpUtil();
					try {
						if (ftpUtil.connectServer(imagePath)) {

							File file1 = make(filePath.substring(filePath.lastIndexOf("\\") + 1));
							ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\") + 1), file1);
							// imageData =
							// ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\")
							// + 1));
							file1 = null;
						}

					} catch (Exception e) {
						log.error(ScanTaskAction.class, e);
						imageData = "";
					}
				}
				task = new TSmrw();
				BeanUtilsEx.copyProperties(task, taskwc);
				if ("old".equals(type)) {
					currentPath = path + "show.jsp";
				} else
					currentPath = path + "showNew.jsp";
			}
		}.nSyTemplate();
	}

	public String download() {
		try {

			File file = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + fileName);
			// File file = new
			// File(UserPropertiesData.getValueByPropertyName("tempPath") + "/"
			// + "111.tif");
			HttpServletResponse response = ServletActionContext.getResponse();
			FileInputStream inputStream = new FileInputStream(file);
			PrintWriter writer = response.getWriter();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] bytes = new byte[1024];
			int c;
			while ((c = inputStream.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
			BASE64Encoder encoder = new BASE64Encoder();
			writer.print(encoder.encode(os.toByteArray()));
			writer.flush();
			writer.close();
			os.flush();
			os.close();
			inputStream.close();
			boolean delete = file.delete();
		} catch (IOException e) {
			log.error(ScanTaskAction.class, e);
		}
		return null;
	}

	public String downloadDaily() {
		String re = null;
		HttpServletResponse response = ServletActionContext.getResponse();

		EntityManager em = ThamsEntityManagerHelper.getEntityManager();
		List<Integer> list = em.createQuery("select max(model.did) from DFile0  model  where model.jgdm=?1 ").setParameter(1, jgdm.getJgdm())
				.getResultList();
		Integer didMax = null;
		try {
			if (!(list == null || list.isEmpty() || list.size() <= 0 || list.get(0) == null)) {
			didMax = list.get(0);
		
		dfile = em.find(DFile0.class, didMax);
		efile = (EFile0) em.createQuery("select model from EFile0  model where model.pid=?1 ").setParameter(1, dfile.getDid()).getSingleResult();

		re = null;
		if (ftpUtil == null){
			ftpUtil = new FtpUtil();
		}
			if (ftpUtil.connectServer(efile.getPathname())) {
				File file1 = make(efile.getEfilename());
				ftpUtil.download(efile.getEfilename(), file1);
				// imageData =
				// ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\")
				// + 1));
				file1 = null;
			}

			// imageData = ftpUtil.download(efile.getEfilename());

			File file = new File(UserPropertiesData.getValueByPropertyName("tempPath") + "/" + efile.getEfilename());
			// File file = new
			// File(UserPropertiesData.getValueByPropertyName("tempPath") + "/"
			// + "111.tif");

			FileInputStream inputStream = new FileInputStream(file);
			PrintWriter writer = response.getWriter();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] bytes = new byte[1024];
			int c;
			while ((c = inputStream.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
			BASE64Encoder encoder = new BASE64Encoder();
			writer.print(encoder.encode(os.toByteArray()));
			writer.flush();
			writer.close();
			os.flush();
			os.close();
			inputStream.close();
			boolean delete = file.delete();
		}
		} catch (IOException e) {
			log.error(ScanTaskAction.class, e);
		} catch (Exception e) {
			log.error(ScanTaskAction.class, e);
		} finally {
			ThamsEntityManagerHelper.closeEntityManager();
		}
		return null;

	}

	public String downloadDailyTitle() {
		String re = null;
		HttpServletResponse response = ServletActionContext.getResponse();

		EntityManager em = ThamsEntityManagerHelper.getEntityManager();
		List<Integer> list = em.createQuery("select max(model.did) from DFile0  model  where model.jgdm=?1 ").setParameter(1, jgdm.getJgdm())
				.getResultList();
		Integer didMax = 0;
		System.out.println(list);
		//if (list!=null&&!list.isEmpty()) {
			if (!(list == null || list.isEmpty() || list.size() <= 0 || list.get(0) == null)) {
			didMax = list.get(0);

			dfile = em.find(DFile0.class, didMax);

			fileName = dfile.getDocid();
			efile = (EFile0) em.createQuery("select model from EFile0  model where model.pid=?1 ").setParameter(1, dfile.getDid()).getSingleResult();
			List<PFile0> pages = em.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(1,
					dfile.getDid()).getResultList();
			wdidbs = "";
			for (PFile0 page : pages) {
				// wdidbs += page.getPagetype() + ";";
				wdidbs += page.getPagetype() + "%";
			}
			if (wdidbs.length() > 1) {
				wdidbs = wdidbs.substring(0, wdidbs.length() - 1);
			}
		} else {
			wdidbs = "no";
		}
		ThamsEntityManagerHelper.closeEntityManager();
		currentPath = "/product/jsp/qualityManager/show_dfile.jsp";
		return SUCCESS;

	}

	private static Set<String> files(String urlName) throws IOException {
		URL url = new URL(urlName);
		URLConnection uc = url.openConnection();

		InputStreamReader is = new InputStreamReader(uc.getInputStream());
		String line;
		Set<String> files = new HashSet<String>();
		Pattern p = Pattern.compile("(/\\w+)+\\.(tif|jpg)");
		BufferedReader in = new BufferedReader(is);
		while ((line = in.readLine()) != null) {
			Matcher m = p.matcher(line);
			while (m.find()) {
				String filter = m.group();
				files.add(filter);
			}
		}
		in.close();
		is.close();
		return files;
	}

	public String loadData() {
		try {
			if (task == null || task.getJgdm() == null) {
				return null;
			}
			HttpServletResponse response = ServletActionContext.getResponse();

			PrintWriter writer = response.getWriter();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			String urlName = UserPropertiesData.getValueByPropertyName("GSIP");
			// + DateUtil.dateToStr(DateUtil.dayBefore(new Date(), 1),
			// "yyyyMMdd")+ task.getJgdm() + "/"
			TJgdm jgdm = EntityManagerHelper.getEntityManager().find(TJgdm.class, task.getJgdm());
			if (jgdm != null) {
				Set<String> files = files(urlName + "/" + (jgdm.getBak4() == null ? "" : jgdm.getBak4()) + "/");
				ImageUtil.margeTif(files, os);
				os.flush();
			}
			BASE64Encoder encoder = new BASE64Encoder();
			writer.print(encoder.encode(os.toByteArray()));
			writer.flush();
			writer.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
			log.error(ScanTaskAction.class, e);
		} catch (Exception e) {
			log.error(ScanTaskAction.class, e);
		}
		return null;
	}

	private File make(String fileName) throws IOException {
		String tempPath = UserPropertiesData.getValueByPropertyName("tempPath");
		File file = new File(tempPath);
		if (!file.exists())
			file.mkdir();

		file = new File(tempPath + "/" + fileName);
		if (!file.exists())
			file.createNewFile();
		return file;
	}

	public String delete_dfile() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {

				User user = (User) session.get("sysUser");
				if (dfile == null || dfile.getDid() == null) {
					throw new Exception("数据传输出错");
				}
				dfile = em.find(DFile0.class, dfile.getDid());
				em.clear();
				if (dfile != null) {
					EntityManager ems = EntityManagerHelper.getEntityManager();
					ems.getTransaction().begin();
					TCzjl czjl = new TCzjl();
					czjl.setJgdm(dfile.getJgdm());
					czjl.setMemo("电子档案删除");
					czjl.setName(user.getUserName());
					czjl.setType("D8");
					czjl.setDate(new Date());
					czjl.setXzqh(user.getBzjgdm());
					ems.persist(czjl);
					if (dfile.getAttr() == 1) {
						message = "机构代码(" + dfile.getJgdm() + ")电子档案删除操作成功";
						dfile.setStatus(-1);
					} else {
						message = "机构代码(" + dfile.getJgdm() + ")电子档案打回临时操作成功";
						dfile.setAttr(1);
					}
					em.merge(dfile);
					em.flush();
					ems.getTransaction().commit();
					EntityManagerHelper.closeEntityManager();
				}

				currentPath = path + "del_success.jsp";
			}
		}.template();
	}

	public String delete() {
		return new ActionUtils() {
			private EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();

			@Override
			protected void excute() throws Exception {
				if (task == null || task.getId() == null) {
					throw new Exception("数据传输出错");
				}
				task = em.find(TSmrw.class, task.getId());
				if (task.getImagePath() == null) {
					return;
				} else {
					String[] names = task.getImagePath().split("(/|\\\\)");
					fileName = names[names.length - 1].split("\\.")[0];
				}
				em.createQuery("delete from TArchivePage model where model.archid='" + fileName + "'").executeUpdate();
				em.flush();
				deleteFiles();
				deleteFile(task.getImagePath());
				task.setImagePath(null);
				currentPath = path + "ok.jsp";
			}

			private void deleteFiles() throws Exception {
				EntityTransaction thamsTransaction = thamsManager.getTransaction();
				if (!thamsTransaction.isActive()) {
					thamsTransaction.begin();
				}
				try {
					List<EFile0> file0s = thamsManager.createQuery("select model from EFile0 model where  model.efilename='" + fileName + "'")
							.getResultList();
					for (EFile0 file0 : file0s) {
						thamsManager.createQuery(
								String.format("delete  from PFile0 model  where  model.pid='%d' and model.did='%d'", file0.getPid(), file0.getDid()))
								.executeUpdate();
					}
					thamsManager.createQuery("delete  from EFile0 model where  model.efilename='" + fileName + "'").executeUpdate();
					thamsManager.flush();
					thamsTransaction.commit();
				} catch (Exception e) {
					thamsTransaction.rollback();
					log.error(ScanTaskAction.class, e);
					throw e;
				} finally {
					ThamsEntityManagerHelper.closeEntityManager();
				}
			}

			private void deleteFile(String filePath) throws IOException {
				File delfile = new File(filePath);
				delfile.deleteOnExit();
			}
		}.template();
	}

	public String uploadPkg() {
		try {
			if (fileName != null) {
				fileName = URLDecoder.decode(fileName, "UTF-8");
				String data = (String) session.get(fileName);
				if (data == null)
					session.put(fileName, file);
				else
					session.put(fileName, data + file);
			}
		} catch (Exception e) {
			log.error(ScanTaskAction.class, e);
		}

		currentPath = path + "ok.jsp";
		return SUCCESS;
	}

	public String count_jd() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				String xzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getXzqh();
				String ds = InitSysParams.scCenterMap.get(xzqh);
				if (ds != null) {
					ds = xzqh.substring(0, 2);
				} else {
					ds = xzqh.substring(0, 4);
				}
				String sql = "SELECT  CONVERT(VARCHAR(10),createTime,120) AS ties  ,bzjgdm,TYPE ,status,COUNT(1)  FROM t_smrw  WHERE  bzjgdm LIKE'"
						+ ds + "%'";
				if (startDate != null) {
					sql += " and createTime >='" + DateUtil.dateToStr(startDate) + "'";
				}
				if (endDate != null) {
					sql += " and createTime <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
				}
				sql += " GROUP BY  CONVERT(VARCHAR(10),createTime,120), bzjgdm,TYPE,status ORDER BY ties, bzjgdm";
				maps = new HashMap<String, Map<String, List<Model>>>();
				Map<String, List<Model>> modelMaps;
				List<Model> models;
				List<Object[]> cs = em.createNativeQuery(sql).getResultList();
				String time;
				String bzjg;
				for (Object[] objects : cs) {
					if (objects[0] == null) {
						continue;
					}
					Model model = new Model();
					time = objects[0].toString();
					bzjg = objects[1].toString();
					model.setColumn1(SmTaskType.valueOf(objects[2] == null ? "" : objects[2].toString().trim()).name());
					model.setColumn2(status(objects[3] == null ? false : Boolean.valueOf(objects[3].toString())));
					model.setCount1(objects[4] == null ? 0 : Integer.valueOf(objects[4].toString()));
					if (maps.containsKey(time)) {
						modelMaps = maps.get(time);
					} else {
						modelMaps = new HashMap<String, List<Model>>();
					}
					if (modelMaps.containsKey(bzjg + "")) {
						models = modelMaps.get(bzjg + "");
					} else {
						models = new ArrayList<Model>();
					}
					models.add(model);
					modelMaps.put(bzjg + "", models);
					maps.put(time, modelMaps);
				}
				em.clear();
				currentPath = path + "count_jd.jsp";
			}

			private String status(Boolean key) {
				if (key) {
					return "已扫描";
				}
				return "未扫描";
			}
		}.nSyTemplate();
	}

	public String count_ld() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				String xzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getXzqh();
				String ds = InitSysParams.scCenterMap.get(xzqh);
				if (ds != null) {
					ds = xzqh.substring(0, 2);
				} else {
					ds = xzqh.substring(0, 4);
				}
				String sql = "SELECT CONVERT(VARCHAR(10),compleTime,120)AS ties,bzjgdm, TYPE ,status,COUNT(1)  FROM t_smtask  WHERE  bzjgdm LIKE'"
						+ ds + "%'";
				if (startDate != null) {
					sql += " and compleTime >='" + DateUtil.dateToStr(startDate) + "'";
				}
				if (endDate != null) {
					sql += " and compleTime <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
				}
				sql += " GROUP BY  CONVERT(VARCHAR(10),compleTime,120), bzjgdm,TYPE,status ORDER BY ties, bzjgdm";
				maps = new HashMap<String, Map<String, List<Model>>>();
				Map<String, List<Model>> modelMaps;
				List<Model> models;
				List<Object[]> cs = em.createNativeQuery(sql).getResultList();
				String time;
				String bzjg;
				for (Object[] objects : cs) {
					if (objects[0] == null) {
						continue;
					}
					Model model = new Model();
					time = objects[0].toString();
					bzjg = objects[1].toString();
					model.setColumn1(type(objects[2] == null ? "" : objects[2].toString()));
					model.setColumn2(status(objects[3] == null ? false : Boolean.valueOf(objects[3].toString())));
					model.setCount1(objects[4] == null ? 0 : Integer.valueOf(objects[4].toString()));
					if (maps.containsKey(time)) {
						modelMaps = maps.get(time);
					} else {
						modelMaps = new HashMap<String, List<Model>>();
					}
					if (modelMaps.containsKey(bzjg + "")) {
						models = modelMaps.get(bzjg + "");
					} else {
						models = new ArrayList<Model>();
					}
					models.add(model);
					modelMaps.put(bzjg + "", models);
					maps.put(time, modelMaps);
				}
				em.clear();
				currentPath = path + "count_ld.jsp";
			}

			private String status(Boolean key) {
				if (key) {
					return "已扫描";
				}
				return "未扫描";
			}

			private String type(String key) {
				key = key.trim();
				if ("0".equals(key)) {
					return "新增";
				}
				if ("1".equals(key)) {
					return "其他赋码";
				}
				if ("2".equals(key)) {
					return "预赋码";
				}
				if ("3".equals(key)) {
					return "变更";
				}
				if ("4".equals(key)) {
					return "换证";
				}
				if ("5".equals(key)) {
					return "年检";
				}
				if ("6".equals(key)) {
					return "省间迁入";
				}
				return "";
			}
		}.nSyTemplate();
	}

	public String runTask() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				currentPath = path + "success.jsp";
			}
		}.nSyTemplate();
	}

	public String list_dfile() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				zrxzqhMap = new TreeMap<String, String>(new Comparator<String>() {
					public int compare(String obj1, String obj2) {
						if (obj1 == null)
							return -1;
						return obj1.compareTo(obj2);
					}
				});
				Pattern p = Pattern.compile("(.*[1-9]+)");
				Matcher m = p.matcher(user.getBzjgdm());
				String filter = m.find() ? m.group() : user.getBzjgdm();
				for (Map.Entry<String, String> entry : InitSysParams.zrxzqhMap.entrySet()) {
					if (entry.getKey().startsWith(filter)) {
						zrxzqhMap.put(entry.getKey(), entry.getValue());
					}
				}
				
				if (dfile == null) {
					dfile = new DFile0();
					dfile.setAttr(0);
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("modifydate");
					page.setOrderByType("desc");
				}
				if (dfile.getAttr() == 1 && page.getOrderByField().equals("modifydate"))
					page.setOrderByField("bzrq");
				final String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType())
						+ ",model.jgdm " : "";
				if (dfile.getAttr() == 0) {
					String sql = " from DFile0 model where model.status!=-1 and  model.attr=1   ";
					if (dfile.getJgdm() != null && !dfile.getJgdm().equals("")) {
						sql += " and model.jgdm like '%" + dfile.getJgdm() + "%'";
					}

					if (dfile.getBzjgdm() != null && !"".equals(dfile.getBzjgdm())) {
						sql += " and model.bzjgdm ='" + dfile.getBzjgdm() + "'";
					}else{
						sql += ((user.getUserName() != null && user.getUserName().contains("admin")) ? "" : " and model.bzjgdm='" + user.getBzjgdm() + "'");
					}
					if (dfile.getNewdate() != null) {
						sql += " and model.newdate >='" + DateUtil.dateToStr(dfile.getNewdate()) + "'";
					}
					if (endDate != null) {
						sql += " and model.newdate <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
					}
					if (startDate != null) {
						sql += " and model.modifydate >='" + DateUtil.dateToStr(startDate) + "'";
					}
					if (dfile.getModifydate() != null) {
						sql += " and model.modifydate <'" + DateUtil.dateToStr(DateUtil.dayAfter(dfile.getModifydate(), 1)) + "'";
					}
					if (dfile.getArctype() != null && !"".equals(dfile.getArctype())) {
						for (Map.Entry<String, String> entry : SmTaskType.dTypes().entrySet()) {
							if (entry.getValue().equals(dfile.getArctype())) {
								dfile.setArctype(entry.getKey());
							}
						}
						sql += " and model.arctype ='" + dfile.getArctype() + "'";
					}
					dFiles = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
							.getResultList();
					page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
				} else if (dfile.getAttr() == 2) {
					String sql = " from DFile0 model where  model.status!=-1 and model.attr=2  and model.errorflag<>-2  ";
					if (dfile.getJgdm() != null && !dfile.getJgdm().equals("")) {
						sql += " and model.jgdm like '%" + dfile.getJgdm() + "%'";
					}
					if (dfile.getBzjgdm() != null && !"".equals(dfile.getBzjgdm())) {
						sql += " and model.bzjgdm ='" + dfile.getBzjgdm() + "'";
					}
					if (dfile.getNewdate() != null) {
						sql += " and model.newdate >='" + DateUtil.dateToStr(dfile.getNewdate()) + "'";
					}
					if (endDate != null) {
						sql += " and model.newdate <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
					}
					if (startDate != null) {
						sql += " and model.modifydate >='" + DateUtil.dateToStr(startDate) + "'";
					}
					if (dfile.getModifydate() != null) {
						sql += " and model.modifydate <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
					}
					if (dfile.getArctype() != null && !"".equals(dfile.getArctype())) {
						for (Map.Entry<String, String> entry : SmTaskType.dTypes().entrySet()) {
							if (entry.getValue().equals(dfile.getArctype())) {
								dfile.setArctype(entry.getKey());
							}
						}
						sql += " and model.arctype ='" + dfile.getArctype() + "'";
					}
					dFiles = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
							.getResultList();
					page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
				} else {
					String sql = " from TJgdm model where  model.wtbz=2 ";
					if (dfile.getJgdm() != null && !dfile.getJgdm().equals("")) {
						sql += " and  model.jgdm like '%" + dfile.getJgdm() + "%'";
					}
					if (dfile.getBzjgdm() != null && !"".equals(dfile.getBzjgdm())) {
						sql += " and model.bzjgdm ='" + dfile.getBzjgdm() + "'";
					}
					if (dfile.getNewdate() != null) {
						sql += " and model.bzrq >='" + DateUtil.dateToStr(dfile.getNewdate()) + "'";
					}
					if (endDate != null) {
						sql += " and model.bzrq <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
					}
					if (startDate != null) {
						sql += " and model.lastdate >='" + DateUtil.dateToStr(startDate) + "'";
					}
					if (dfile.getModifydate() != null) {
						sql += " and model.lastdate <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
					}
					final String sql2 = sql;
					EntityManagerHelper.excute(new Runnable() {
						@Override
						public void run() {
							jgdms = EntityManagerHelper.getEntityManager().createQuery("select model " + sql2 + orderBy).setFirstResult(
									page.getStartRecord()).setMaxResults(page.getPageSize()).getResultList();
							page.setTotalRecord(((Long) EntityManagerHelper.getEntityManager().createQuery("select count(model) " + sql2)
									.getResultList().get(0)).intValue());
						}
					});

					jgdms = EntityManagerHelper.getEntityManager().createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord())
							.setMaxResults(page.getPageSize()).getResultList();
					page.setTotalRecord(((Long) EntityManagerHelper.getEntityManager().createQuery("select count(model) " + sql).getResultList().get(
							0)).intValue());
				}
				currentPath = path + "list_dfile.jsp";
			}
		}.nSyTemplate();
	}

	public String list_dfile_search() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				
				/*if (jgdm == null) {
					jgdm = new TJgdm();
					 page = new Page();
					 currentPath = path + "list_dfile_search.jsp";
                     return;
				}
				*/
				User user = (User) session.get("sysUser");
				zrxzqhMap = new TreeMap<String, String>(new Comparator<String>() {
					public int compare(String obj1, String obj2) {
						if (obj1 == null)
							return -1;
						return obj1.compareTo(obj2);
					}
				});
				Pattern p = Pattern.compile("(.*[1-9]+)");
				Matcher m = p.matcher(user.getBzjgdm());
				String filter = m.find() ? m.group() : user.getBzjgdm();
				for (Map.Entry<String, String> entry : InitSysParams.zrxzqhMap.entrySet()) {
					if (entry.getKey().startsWith(filter)) {
						zrxzqhMap.put(entry.getKey(), entry.getValue());
					}
				}
				if (dfile == null) {
					dfile = new DFile0();
					dfile.setAttr(2);
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("modifydate");
					page.setOrderByType("desc");
				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";

				String sql = " from DFile0 model where model.status!=-1  ";
				if (dfile.getJgdm() != null && !dfile.getJgdm().equals("")) {
					sql += "and model.jgdm like '%" + dfile.getJgdm() + "%'";
				}
				if (dfile.getJgmc() != null && !dfile.getJgmc().equals("")) {
					sql += "and model.jgmc like '%" + dfile.getJgmc() + "%'";
				}
				if (dfile.getBzjgdm() != null && !"".equals(dfile.getBzjgdm())) {
					sql += " and model.bzjgdm ='" + dfile.getBzjgdm() + "'";
				} else {
					sql += " and model.bzjgdm like '" + filter + "%'";
				}
				if (dfile.getNewdate() != null) {
					sql += " and model.newdate >='" + DateUtil.dateToStr(dfile.getNewdate()) + "'";
				}
				if (endDate != null) {
					sql += " and model.newdate <'" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'";
				}
				if (startDate != null) {
					sql += " and model.modifydate >='" + DateUtil.dateToStr(startDate) + "'";
				}
				if (dfile.getModifydate() != null) {
					sql += " and model.modifydate <'" + DateUtil.dateToStr(DateUtil.dayAfter(dfile.getModifydate(), 1)) + "'";
				}
				if (dfile.getArctype() != null && !"".equals(dfile.getArctype())) {
					for (Map.Entry<String, String> entry : SmTaskType.dTypes().entrySet()) {
						if (entry.getValue().equals(dfile.getArctype())) {
							dfile.setArctype(entry.getKey());
						}
					}
					sql += " and model.arctype ='" + dfile.getArctype() + "'";
				}
				dFiles = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
						.getResultList();
				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());

				currentPath = path + "list_dfile_search.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 问题档案修改 * @return
	 * 
	 * @since 2014-01-03 添加管理员 查看全部 不区分行政区划
	 */
	public String list_dfile_edit() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				if (dfile == null) {
					dfile = new DFile0();
					dfile.setAttr(0);
				}
				if (page == null) {
					page = new Page();
					page.setOrderByField("bzrq");
					page.setOrderByType("desc");
				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";

				String sql = " from DFile0 model where  model.status!=-1 and  model.attr=2   and  model.errorflag<>-2  ";
				sql += ((user.getUserName() != null && user.getUserName().contains("admin")) ? "" : " and model.bzjgdm='" + user.getBzjgdm() + "'");

				if (dfile.getJgdm() != null && !dfile.getJgdm().equals("")) {
					sql += " and model.jgdm like '%" + dfile.getJgdm() + "%'";
				}
				dFiles = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
						.getResultList();
				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());
				currentPath = path + "list_dfile_edit.jsp";
			}
		}.nSyTemplate();
	}

	public String edit_dfile() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				dfile = em.find(DFile0.class, dfile.getDid());
				fileName = dfile.getDocid();
				efile = (EFile0) em.createQuery("select model from EFile0  model where model.pid=?1 ").setParameter(1, dfile.getDid())
						.getSingleResult();
				List<PFile0> pages = em.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(1,
						dfile.getDid()).getResultList();
				wdidbs = "";
				hidValue = "";
				for (PFile0 page : pages) {
					// wdidbs += page.getPagetype() + ";";
					wdidbs += page.getPagetype() + "%";
					/*
					 * for (ScPageKind kind : pageKinds) { if
					 * (page.getPagetype()
					 * .trim().equals(kind.getPagekindName().trim())) { hidValue
					 * += kind.getPagekindId().trim() + ";"; } }
					 */
				}
				if (wdidbs.length() > 1) {
					wdidbs = wdidbs.substring(0, wdidbs.length() - 1);

				}
				if (hidValue.length() > 1) {
					hidValue = hidValue.substring(0, hidValue.length() - 1);

				}
				String filePath = efile.getPathname();
				if (filePath != null && !"".equals(filePath)) {
					FtpUtil ftpUtil = new FtpUtil();
					if (ftpUtil.connectServer(efile.getPathname())) {
						File file1 = make(efile.getEfilename());
						ftpUtil.download(efile.getEfilename(), file1);
					}
				}
				currentPath = path + "edit_dfile.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 历史电子档案编辑
	 * 
	 * @return
	 */
	public String edit_dfile_search() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {

				dfile = em.find(DFile0.class, dfile.getDid());
				fileName = dfile.getDocid();
				imageData = "";
				efile = (EFile0) em.createQuery("select model from EFile0 model where model.pid=?1 ").setParameter(1, dfile.getDid())
						.getSingleResult();
				List<PFile0> pages = em.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(1,
						dfile.getDid()).getResultList();
				wdidbs = "";
				hidValue = "";
				for (PFile0 page : pages) {
					// wdidbs += page.getPagetype() + ";";
					wdidbs += page.getPagetype() + "%";
					/*
					 * for (ScPageKind kind : pageKinds) { if
					 * (page.getPagetype()
					 * .trim().equals(kind.getPagekindName().trim())) { hidValue
					 * += kind.getPagekindId().trim() + ";"; } }
					 */
				}
				if (wdidbs.length() > 1) {
					wdidbs = wdidbs.substring(0, wdidbs.length() - 1);

				}
				/*
				 * if (hidValue.length() > 1) { hidValue = hidValue.substring(0,
				 * hidValue.length() - 1);
				 * 
				 * }
				 */
				if (ftpUtil == null)
					ftpUtil = new FtpUtil();
				try {
					if (ftpUtil.connectServer(efile.getPathname())) {
						File file1 = make(efile.getEfilename());
						ftpUtil.download(efile.getEfilename(), file1);
					}
					// imageData = ftpUtil.download(efile.getEfilename());
				} catch (Exception e) {
					log.error(ScanTaskAction.class, e);
				}
				setSource("list_dfile_search");
				currentPath = path + "edit_dfile_search.jsp";
			}
		}.nSyTemplate();
	}

	public String show_dfile() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				EntityManager entityManager2 = EntityManagerHelper.getEntityManager();

				try {
					if (dfile == null || dfile.getDid() == null) {
						jgdm = entityManager2.find(TJgdm.class, dfile.getJgdm());
						dFiles = em.createQuery("select model from DFile0 model  where model.jgdm=:jgdm  order by  model.createtime desc ")
								.setParameter("jgdm", dfile.getJgdm()).getResultList();
						if (!dFiles.isEmpty() && dFiles.size() > 0) {
							dfile = dFiles.get(0);
						}
					}
					if (dfile == null || dfile.getDid() == null) {
						dfile = new DFile0();
						BeanUtilsEx.copyProperties(dfile, jgdm);
						imageData = "";
					} else {
						dfile = em.find(DFile0.class, dfile.getDid());

						jgdm = entityManager2.find(TJgdm.class, dfile.getJgdm());
						if (jgdm == null) {
							List<TJgdmSave> jgdms = entityManager2.createQuery("select model from TJgdmSave model where   model.jgdm=:jgdm")
									.setParameter("jgdm", dfile.getJgdm()).getResultList();
							if (jgdms != null && !jgdms.isEmpty() && jgdms.size() > 0) {
								jgdm = new TJgdm();
								BeanUtilsEx.copyProperties(jgdm, jgdms.get(0));
							}
						}

						fileName = dfile.getDocid();
						efile = (EFile0) em.createQuery("select model from EFile0  model where model.pid=?1 ").setParameter(1, dfile.getDid())
								.getSingleResult();
						List<PFile0> pages = em.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(
								1, dfile.getDid()).getResultList();
						wdidbs = "";
						for (PFile0 page : pages) {
							// wdidbs += page.getPagetype() + ";";
							wdidbs += page.getPagetype() + "%";
						}
						if (wdidbs.length() > 1) {
							wdidbs = wdidbs.substring(0, wdidbs.length() - 1);
						}
						if (ftpUtil == null)
							ftpUtil = new FtpUtil();
						try {
							if (ftpUtil.connectServer(efile.getPathname())) {
								File file1 = make(efile.getEfilename());
								ftpUtil.download(efile.getEfilename(), file1);
								// imageData =
								// ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\")
								// + 1));
								file1 = null;
							}

							// imageData =
							// ftpUtil.download(efile.getEfilename());
						} catch (Exception e) {
							log.error(ScanTaskAction.class, e);
						}
					}
					if (jgdm == null) {
						jgdm = new TJgdm();
						BeanUtilsEx.copyProperties(jgdm, dfile);
					}
				} catch (Exception e) {
					log.error(ScanTaskAction.class, e);
				} finally {
					EntityManagerHelper.closeEntityManager();
				}
				currentPath = path + "show_dfile.jsp";
			}
		}.nSyTemplate();
	}

	public String show_dfile_search() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				dfile = em.find(DFile0.class, dfile.getDid());
				fileName = dfile.getDocid();
				imageData = "";
				efile = (EFile0) em.createQuery("select model from EFile0 model where model.pid=?1 ").setParameter(1, dfile.getDid())
						.getSingleResult();
				List<PFile0> pages = em.createQuery("select model from PFile0 model where model.pid=?1 order by model.pageno ").setParameter(1,
						dfile.getDid()).getResultList();
				wdidbs = "";
				hidValue = "";
				for (PFile0 page : pages) {
					// wdidbs += page.getPagetype() + ";";
					wdidbs += page.getPagetype() + "%";
				}
				if (wdidbs.length() > 1) {
					wdidbs = wdidbs.substring(0, wdidbs.length() - 1);
				}
				if (ftpUtil == null)
					ftpUtil = new FtpUtil();
				try {
					if (ftpUtil.connectServer(efile.getPathname())) {
						File file1 = make(efile.getEfilename());
						ftpUtil.download(efile.getEfilename(), file1);
						// imageData =
						// ftpUtil.download(filePath.substring(filePath.lastIndexOf("\\")
						// + 1));
						file1 = null;
					}
					// imageData = ftpUtil.download(efile.getEfilename());
				} catch (Exception e) {
					log.error(ScanTaskAction.class, e);
				}
				currentPath = path + "show_search.jsp";
			}
		}.nSyTemplate();
	}

	public String auditing() {
		return new ThamsActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				EntityManager entityManager3 = EntityManagerHelper.getEntityManager();
				try {
					int wtbz = 0;
					String wtType = "";
					for (int i = 0; i < data.size() - 1; i++) {
						if (data.get(i) != null && 1 == data.get(i)) {
							wtbz = 2;
							wtType += "1";
						} else {
							wtType += "0";
						}
					}

					entityManager3.getTransaction().begin();
					TJgdm jgdm1 = entityManager3.find(TJgdm.class, dfile.getJgdm());
					if (jgdm1 != null) {
						if (wtbz == 2) {
							jgdm1.setWtbz(2);
							jgdm1.setWtType(wtType);
							jgdm1.setBak5(DateUtil.dateToStr(new Date()));
						} else {
							jgdm1.setWtbz(0);
							jgdm1.setWtType(wtType);
						}

						entityManager3.merge(jgdm1);

					}

					if (dfile.getDid() != null && dfile.getDid() != 0) {
						DFile0 dfile1 = em.find(DFile0.class, dfile.getDid());
						if (wtbz == 2) {
							dfile1.setAttr(2);
							dfile1.setErrorflag(-2);
						}
						if (dfile.getErrorflag() != -1) {
							dfile1.setAttr(2);
							dfile1.setErrorflag(dfile.getErrorflag());
						} else {
							dfile1.setAttr(0);
							dfile1.setErrorflag(-1);
						}
						dfile1.setBz(dfile.getBz());
						dfile1.setEdittime(new Date());
						em.merge(dfile1);
						em.flush();
						dfile = dfile1;
					}
					TCzjl czjl = new TCzjl();
					czjl.setJgdm(dfile.getJgdm());
					czjl.setMemo("电子档案审核");
					czjl.setName(user.getUserName());
					czjl.setType("D7");
					czjl.setDate(new Date());
					czjl.setXzqh(user.getBzjgdm());
					entityManager3.persist(czjl);
					entityManager3.flush();
					entityManager3.getTransaction().commit();
					em.flush();
					if (dfile.getErrorflag() != -1 || wtbz == 2) {
						message = "机构代码（" + dfile.getJgdm() + "）电子档案数据审核未通过，数据状态为问题数据！";
					} else {
						message = "机构代码（" + dfile.getJgdm() + "）电子档案数据审核通过！";
					}
					currentPath = path + "au_success.jsp";
				} catch (Exception e) {
				} finally {
					EntityManagerHelper.closeEntityManager();
				}
			}
		}.template();
	}

	/**
	 * 档案同步 zx加
	 * 
	 * @return
	 */
	public String fileSyn() {
		log.info("用户同步档案:" + ((User) session.get("sysUser")).getUserName());
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				EntityManager thamsManager = ThamsEntityManagerHelper.getEntityManager();
				List<TSmrw> tasks = em.createQuery("select model from  TSmrw model ").getResultList();
				int count = tasks == null ? 0 : tasks.size();
				int error = 0;
				int tiaoguo = 0;
				em.clear();
				smrwwcs = new ArrayList<TSmrwwc>();
				if (count > 0) {
					for (TSmrw smrw : tasks) {
						if (smrw.getType() == null) {
							tiaoguo++;
							continue;
						}
						if (smrw.getCreateTime() == null) {
							tiaoguo++;
							continue;
						}
						Date createDate = DateUtil.strToDate(DateUtil.dateToStr(smrw.getCreateTime()));
						Date compareDate = DateUtil.dayAfter(createDate, InitSysParams.system.getSmqx());
						List<Object[]> objects = null;
						try {
							objects = thamsManager
									.createQuery(
											"select d,e from DFile0 d , EFile0 e  where e.pid=d.did and  d.jgdm=?1 and d.arctype=?2 and d.newdate >= ?3 and d.newdate <= ?4  order by  d.newdate desc ")
									.setParameter(1, smrw.getJgdm()).setParameter(2, SmTaskType.getDfileType(Integer.valueOf(smrw.getType())))
									.setParameter(3, createDate).setParameter(4, compareDate).getResultList();
						} catch (Exception e) {
						} finally {
							ThamsEntityManagerHelper.closeEntityManager();
						}
						if (objects != null && objects.size() > 0) {
							Object[] obs = objects.get(0);
							DFile0 dfile = (DFile0) obs[0];
							EFile0 eFile = (EFile0) obs[1];
							TSmrwwc tSmrwwc = new TSmrwwc();
							BeanUtilsEx.copyProperties(tSmrwwc, smrw);
							tSmrwwc.setId(null);
							tSmrwwc.setCompleTime(dfile.getModifydate());
							tSmrwwc.setImagePath(eFile.getPathname().trim() + "\\" + eFile.getEfilename().trim());
							try {
								em.persist(tSmrwwc);
								em.remove(em.getReference(TSmrw.class, smrw.getId()));
								smrwwcs.add(tSmrwwc);
							} catch (Exception e) {
								error++;
							}
						} else {
							tiaoguo++;
						}
					}
				}

				em.flush();
				source = "fileSyn";
				message = "同步执行完成：共有扫描任务" + count + "个，需要同步" + (count - tiaoguo) + "个，同步出错" + error + "个,未扫面的档案还有" + (tiaoguo) + "个.";
				currentPath = path + "fileSyn.jsp";

			}
		}.template();
	}

	/**
	 * 档案同步页面
	 * 
	 * @return
	 */
	public String fileSynPage() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				source = "fileSynPage";
				currentPath = path + "fileSyn.jsp";
			}
		}.nSyTemplate();
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TSmrw> getTasks() {
		return tasks;
	}

	public void setTasks(List<TSmrw> tasks) {
		this.tasks = tasks;
	}

	public TSmrw getTask() {
		return task;
	}

	public void setTask(TSmrw task) {
		this.task = task;
	}

	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getWdidbs() {
		return wdidbs;
	}

	public void setWdidbs(String wdidbs) {
		this.wdidbs = wdidbs;
	}

	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}

	public List<TJgdm> getJgdms() {
		return jgdms;
	}

	public void setJgdms(List<TJgdm> jgdms) {
		this.jgdms = jgdms;
	}

	public TJgdm getJgdm() {
		return jgdm;
	}

	public void setJgdm(TJgdm jgdm) {
		this.jgdm = jgdm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, Map<String, List<Model>>> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Map<String, List<Model>>> maps) {
		this.maps = maps;
	}

	public String getHidValue() {
		return hidValue;
	}

	public void setHidValue(String hidValue) {
		this.hidValue = hidValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public List<DFile0> getDFiles() {
		return dFiles;
	}

	public void setDFiles(List<DFile0> dFiles) {
		this.dFiles = dFiles;
	}

	public DFile0 getDfile() {
		return dfile;
	}

	public void setDfile(DFile0 dfile) {
		this.dfile = dfile;
	}

	public EFile0 getEfile() {
		return efile;
	}

	public void setEfile(EFile0 efile) {
		this.efile = efile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Byte> getData() {
		return data;
	}

	public void setData(List<Byte> data) {
		this.data = data;
	}

	public List<TSmrwwc> getSmrwwcs() {
		return smrwwcs;
	}

	public void setSmrwwcs(List<TSmrwwc> smrwwcs) {
		this.smrwwcs = smrwwcs;
	}

	public TSmrwwc getTaskwc() {
		return taskwc;
	}

	public void setTaskwc(TSmrwwc taskwc) {
		this.taskwc = taskwc;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public TQzsm getQzsm() {
		return qzsm;
	}

	public void setQzsm(TQzsm qzsm) {
		this.qzsm = qzsm;
	}

	public List<TQzsm> getQzsms() {
		return qzsms;
	}

	public void setQzsms(List<TQzsm> qzsms) {
		this.qzsms = qzsms;
	}

	public Map<String, String> getZrxzqhMap() {
		return zrxzqhMap;
	}

	public void setZrxzqhMap(Map<String, String> zrxzqhMap) {
		this.zrxzqhMap = zrxzqhMap;
	}

	public static void main(String[] args) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String urlName = UserPropertiesData.getValueByPropertyName("GSIP");
		// + DateUtil.dateToStr(DateUtil.dayBefore(new Date(), 1), "yyyyMMdd")+
		// task.getJgdm() + "/"

		Set<String> files = null;
		try {
			files = files(urlName + "/20140325/401201321/");
			ImageUtil.margeTif(files, os);
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (Exception e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

	}

}