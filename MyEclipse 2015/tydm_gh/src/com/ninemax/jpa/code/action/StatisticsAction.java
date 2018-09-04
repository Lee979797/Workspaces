/**
 *
 */
package com.ninemax.jpa.code.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import sun.jdbc.rowset.CachedRowSet;
//import sun.misc.BASE64Encoder;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.bus.TZrxzqhBus;
import com.ninemax.jpa.code.model.Field;
import com.ninemax.jpa.code.model.Model;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.ScXzqhdz;
import com.ninemax.jpa.code.model.TBgk;
import com.ninemax.jpa.code.model.TFddbr;
import com.ninemax.jpa.code.model.TFrjl;
import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TFzr;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.code.model.Ttable;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.ExcelUtils;
import com.ninemax.jpa.util.IDCardUtil;
import com.ninemax.jpa.util.UserPropertiesData;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yanzh
 */
public class StatisticsAction extends ActionSupport implements SessionAware {
	private static Logger log = Logger.getLogger(StatisticsAction.class);
	private static final String path = "/product/jsp/statistics/";
	private Map<String, Object> session;
	private String currentPath;
	private String fileName;
	private String message;
	private String title;
	private String source;
	private TJgdm jgdm;
	private TJgdm jgdm2;
	private String dmStatus;
	private List<TJgdm> jgdms;
	private List<Ttable> ttables;
	private Page page;
	private TFddbr fddbr;
	private TFrjl frjl;
	private String base64;
	private String tydm;

	private String sqlwhere;
	private String order;
	private Integer year;
	private Integer month;
	private Integer day;
	private String columnName;
	private Map<String, List<Model>> modelMaps;
	private Map<String, Map> mapMap;
	private List<Model> models;
	private List<Field> fields;
	private List<TBgk> bgks;
	private TBgk bgk;
	private TBgk bgk2;
	private String sns;
	private Date startDate;
	private Date endDate;
	private String str;
	private String database;
	private String ywlx;
	private Boolean type;
	private String json;

	private String zsbh;
	Map<String, String> bzjgdmMap;

	private TZrxzqhBus zrxzqhBus;

	private List<TFzr> listFzr;
	private TJgdmSaveBus saveBus;
	private String jglx;

	public StatisticsAction() {
		zrxzqhBus = new TZrxzqhBus();
		saveBus = new TJgdmSaveBus();
	}

	public String search() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				excutec(em);

			}
		}.template();
	}

	private void excutec(EntityManager em) {
		if ("bydm".equals(source)) {
			setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 按代码查询");
			setSource("_dm");
			currentPath = path + "search_dm.jsp";
		}
		if ("bymc".equals(source)) {
			setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 按名称查询");
			setSource("_mc");
			User user = (User) session.get("sysUser");
			bzjgdmMap = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			Pattern p = Pattern.compile("(.*[1-9]+)");
			Matcher m = p.matcher(user.getBzjgdm());
			String filter = m.find() ? m.group() : user.getBzjgdm();
			// 去除代码限制
			for (Map.Entry<String, String> entry : InitSysParams.bzjgdmMap
					.entrySet()) {
				// if (entry.getKey().startsWith(filter)) {
				bzjgdmMap.put(entry.getKey(), entry.getValue());
				// }
			}
			currentPath = path + "search_mc.jsp";
		}
		if ("multitype".equals(source)) {
			setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 多条件查询");
			setSource("_multi");
			ttables = em.createQuery(
					"select model from Ttable model  order by model.sn")
					.getResultList();
			/*
			 * ttables = em.createQuery(
			 * "select model from Ttable model where model.tablecode=:tablecode order by model.sn"
			 * ) .setParameter("tablecode", "t_jgdm").getResultList();
			 */fields = new ArrayList<Field>();
			for (Ttable ttable : ttables) {
				fields.add(new Field(ttable.getColumncode(), ttable
						.getColumnname(), false));
			}
			currentPath = path + "search_multi.jsp";
		}
		if ("export".equals(source)) {
			setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 ");
			setSource("_multi");
			ttables = em
					.createQuery(
							"select model from Ttable model where model.tablecode=:tablecode or model.tablecode='t_fzdm' order by model.sn")
					.setParameter("tablecode", "t_jgdm").getResultList();
			fields = new ArrayList<Field>();
			for (Ttable ttable : ttables) {
				fields.add(new Field(ttable.getColumncode(), ttable
						.getColumnname(), false));
			}
			currentPath = path + "export_search.jsp";
		}

		// ---zhaojunbo 2017-09-28---------start
		/*
		 * 扫描
		 */
		if ("sm".equals(source)) {
			setTitle("查询 &gt;&gt; 扫描管理 &gt;&gt; 数据扫描");
			setSource("_sm");
			User user = (User) session.get("sysUser");
			bzjgdmMap = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			Pattern p = Pattern.compile("(.*[1-9]+)");
			Matcher m = p.matcher(user.getBzjgdm());
			String filter = m.find() ? m.group() : user.getBzjgdm();
			// 去除代码限制
			for (Map.Entry<String, String> entry : InitSysParams.bzjgdmMap
					.entrySet()) {
				// if (entry.getKey().startsWith(filter)) {
				bzjgdmMap.put(entry.getKey(), entry.getValue());
				// }
			}
			currentPath = path + "search_sm.jsp";
		}
		/*
		 * 扫描
		 */
		if ("sm1".equals(source)) {
			setTitle("查询 &gt;&gt; 扫描管理 &gt;&gt; 数据查看");
			setSource("_sm1");
			User user = (User) session.get("sysUser");
			bzjgdmMap = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					if (obj1 == null)
						return -1;
					return obj1.compareTo(obj2);
				}
			});
			Pattern p = Pattern.compile("(.*[1-9]+)");
			Matcher m = p.matcher(user.getBzjgdm());
			String filter = m.find() ? m.group() : user.getBzjgdm();
			// 去除代码限制
			for (Map.Entry<String, String> entry : InitSysParams.bzjgdmMap
					.entrySet()) {
				// if (entry.getKey().startsWith(filter)) {
				bzjgdmMap.put(entry.getKey(), entry.getValue());
				// }
			}
			currentPath = path + "search_sm1.jsp";
		}
		// ---zhaojunbo 2017-09-28---------end
	}

	// ---zhaojunbo 2017-09-28---------start
	public String show_da() {
		return new ActionUtils() {
			@SuppressWarnings("unused")
			@Override
			protected void excute() throws Exception {

				System.out.println(database + "AAAAAAAAA");
				TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());
				// 机构代码表
				System.out.println(dm);
				TFzdm fzdm = null;
				fzdm = em.find(TFzdm.class, jgdm.getTyshxydm());
				TBgk tb = null;
				// tb =em.find(TBgk.class, jgdm.getTyshxydm());
				System.out.println(jgdm.getTyshxydm());
				String result = null;
				String bbh = null;
				// 通过用户的行政区划去查版本号
				User user = (User) session.get("sysUser");
				bbh = user.getMemo();
				String xq = null;
				xq = user.getBzjgdm();
				System.out.println(bbh);
				try {
					String sql1 = "select memo from sc_xzqhdz model  where  model.dm  like '%"
							+ xq + "%' ";
					DataAccess dataObject1 = new DataAccess();
					CachedRowSet cs1 = dataObject1.query(sql1);
					String memo = null;
					while (cs1.next()) {
						memo = cs1.getString("memo").toString();
						// 将版本号传入前台，前台进行处理
						ServletActionContext.getRequest().setAttribute("memo",
								memo);
						System.out.println(memo + "aaaaaaaaaaaa");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println();
				// System.out.println(user);

				// System.out.println(cs1.getString("memo").toString()+"aaaaaaaaaaaa");
				ServletActionContext.getRequest().setAttribute("bbh", bbh);
				if (dm != null) {
					try {
						String path = dm.getFilePach() + dm.getImageurl();
						System.out.println(path);
						FileInputStream is = new FileInputStream(path);
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						byte[] buffer = new byte[4098];
						int n = 0;
						while (-1 != (n = is.read(buffer))) {
							output.write(buffer, 0, n);
						}
						BASE64Encoder encoder = new BASE64Encoder();

						result = encoder.encode(output.toByteArray())
								.replaceAll("[\\s*\t\n\r]", "");
						System.out.println("返回页面数据：" + result);
						ServletActionContext.getRequest().setAttribute(
								"result", result);
						ServletActionContext.getRequest().setAttribute("bbh",
								bbh);
					} catch (Exception e) {
						e.printStackTrace();

					}
					setMessage("代码主表");
					em.clear();
				}
				if (dm == null) {
					// 机构代码临时表
					// 机构代码注销表
					if (fzdm != null) {
						try {
							String path = fzdm.getFilePach()
									+ fzdm.getImageurl();
							System.out.println(path);
							FileInputStream is = new FileInputStream(path);
							ByteArrayOutputStream output = new ByteArrayOutputStream();
							byte[] buffer = new byte[4098];
							int n = 0;
							while (-1 != (n = is.read(buffer))) {
								output.write(buffer, 0, n);
							}
							BASE64Encoder encoder = new BASE64Encoder();

							result = encoder.encode(output.toByteArray())
									.replaceAll("[\\s*\t\n\r]", "");
							System.out.println("返回页面数据：" + result);
							ServletActionContext.getRequest().setAttribute(
									"result", result);
							ServletActionContext.getRequest().setAttribute(
									"bbh", bbh);
						} catch (Exception e) {
							e.printStackTrace();

						}
					}
				}
				if (dm == null) {
					// 机构代码临时表
					if (fzdm == null) {

						String sql = "select jgdm,FilePach,Imageurl from t_bgk model  where  model.Tyshxydm like '%"
								+ jgdm.getTyshxydm() + "%' ";
						System.out.println(sql + "11111111111111");

						DataAccess dataObject = new DataAccess();
						CachedRowSet cs = dataObject.query(sql);
						while (cs.next()) {
							String FilePach = cs.getString("FilePach")
									.toString();
							String Imageurl = cs.getString("Imageurl")
									.toString();
							// System.out.println(cs.getString("jgdm").toString());
							try {
								String path = FilePach + Imageurl;
								System.out.println(path);
								FileInputStream is = new FileInputStream(path);
								ByteArrayOutputStream output = new ByteArrayOutputStream();
								byte[] buffer = new byte[4098];
								int n = 0;
								while (-1 != (n = is.read(buffer))) {
									output.write(buffer, 0, n);
								}
								BASE64Encoder encoder = new BASE64Encoder();

								result = encoder.encode(output.toByteArray())
										.replaceAll("[\\s*\t\n\r]", "");
								System.out.println("返回页面数据：" + result);
								ServletActionContext.getRequest().setAttribute(
										"result", result);
								ServletActionContext.getRequest().setAttribute(
										"bbh", bbh);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}

				List<TFddbr> fddbrList = em
						.createQuery(
								"from TFddbr model where model.tyshxydm=:tyshxydm")
						.setParameter("tyshxydm", jgdm.getTyshxydm())
						.getResultList();
				if (fddbrList.size() > 0) {
					fddbr = fddbrList.get(0);
					List<TFrjl> frjlList = em
							.createQuery(
									"from TFrjl model where model.frId=:frId")
							.setParameter("frId", fddbr.getLsh())
							.getResultList();
					if (frjlList.size() > 0) {
						frjl = frjlList.get(0);
					}
				}

				// listFzr= saveBus.fzrList(jgdm.getTyshxydm());

				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 代码详细");
				currentPath = path + "show1.jsp";

			}
		}.template();
	}

	// ---zhaojunbo 2017-11-09---------start
	public String show_sc() {
		return new ActionUtils() {
			@SuppressWarnings("unused")
			@Override
			protected void excute() throws Exception {
				System.out.println("ssssssss");
				TJgdm dm = em.find(TJgdm.class, tydm);
				// 机构代码表
				System.out.println(database + "AAAAAAAAA");
				System.out.println(dm);
				if (dm != null) {
					// String sql =
					// "select jgdm,FilePach,Imageurl from t_bgk model  where  model.Tyshxydm like '%"
					// + jgdm.getTyshxydm() + "%' " ;
					Date date = new Date();
					DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					String time = format.format(date);
					String img = time + ".tif";
					String fpach = "D:/efile/";
					String sql1 = "update T_jgdm set FilePach ='" + fpach
							+ "' ,Imageurl = '" + img
							+ "'  where  Tyshxydm = '" + tydm + " ' ";
					System.out.println(sql1 + "11111111111111");

					DataAccess dataObject = new DataAccess();
					CachedRowSet cs = dataObject.update(sql1);
					BASE64Decoder decoder = new BASE64Decoder();

					// Base64解码
					byte[] b = decoder.decodeBuffer(base64);
					for (int i = 0; i < b.length; ++i) {
						if (b[i] < 0) {// 调整异常数据
							b[i] += 256;
						}
					}
					// 生成tif图片
					String imgFilePath = fpach + img;// 新生成的图片
					OutputStream out = new FileOutputStream(imgFilePath);
					out.write(b);
					out.flush();
					out.close();

				}
				TFzdm fzdm = null;
				fzdm = em.find(TFzdm.class, tydm);
				TBgk tb = null;
				if (dm == null) {
					if (fzdm != null) {
						Date date = new Date();
						DateFormat format = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						String time = format.format(date);
						String img = time + ".tif";
						String fpach = "D:/efile/";
						String sql1 = "update T_fzdm set FilePach ='" + fpach
								+ "' ,Imageurl = '" + img
								+ "'  where  Tyshxydm = '" + tydm + " ' ";
						System.out.println(sql1 + "11111111111111");

						DataAccess dataObject = new DataAccess();
						CachedRowSet cs = dataObject.update(sql1);
						BASE64Decoder decoder = new BASE64Decoder();

						// Base64解码
						byte[] b = decoder.decodeBuffer(base64);
						for (int i = 0; i < b.length; ++i) {
							if (b[i] < 0) {// 调整异常数据
								b[i] += 256;
							}
						}
						// 生成tif图片
						String imgFilePath = fpach + img;// 新生成的图片
						OutputStream out = new FileOutputStream(imgFilePath);
						out.write(b);
						out.flush();
						out.close();
					}

				}

				if (dm == null) {
					if (fzdm == null) {
						Date date = new Date();
						DateFormat format = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						String time = format.format(date);
						String img = time + ".tif";
						String fpach = "D:/efile/";
						String sql1 = "update T_bgk set FilePach ='" + fpach
								+ "' ,Imageurl = '" + img
								+ "'  where  Tyshxydm = '" + tydm + " ' ";
						System.out.println(sql1 + "11111111111111");

						DataAccess dataObject = new DataAccess();
						CachedRowSet cs = dataObject.update(sql1);
						BASE64Decoder decoder = new BASE64Decoder();

						// Base64解码
						byte[] b = decoder.decodeBuffer(base64);
						for (int i = 0; i < b.length; ++i) {
							if (b[i] < 0) {// 调整异常数据
								b[i] += 256;
							}
						}
						// 生成tif图片
						String imgFilePath = fpach + img;// 新生成的图片
						OutputStream out = new FileOutputStream(imgFilePath);
						out.write(b);
						out.flush();
						out.close();

					}
				}

				currentPath = path + "chengg.jsp";

			}
		}.template();
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //boolean flag= false; try { FtpConfig ftp =new FtpConfig();
	 * ftp.setPort();
	 * 
	 * StatisticsAction.connectFtp(ftp);//连接ftp System.out.println("测试"); String
	 * parameter = "aaaaaaaaaaaaaaa" ; // 流 String efilename = "aaa.tif"; String
	 * imagepath = "D:/aa";
	 * 
	 * 
	 * boolean pict = StatisticsAction.upload(parameter, efilename, imagepath);
	 * System.out.println(pict); StatisticsAction.closeFtp();
	 * 
	 * } catch (Exception e) { System.out.println("失败"); }
	 * 
	 * 
	 * currentPath = path + "show1.jsp";
	 * 
	 * 
	 * 
	 * } }.template(); public static boolean connectFtp(FtpConfig f) throws
	 * Exception{ if (ftp==null) { ftp=new FTPClient(); } boolean flag=false;
	 * int reply; if (f.getPort()==0) { ftp.connect(f.getIp(),21); }else{
	 * ftp.connect(f.getIp(),f.getPort()); }
	 * 
	 * ftp.login(f.getUsername(), f.getPassword());
	 * ftp.setFileType(FTPClient.BINARY_FILE_TYPE); reply = ftp.getReplyCode();
	 * if (!FTPReply.isPositiveCompletion(reply)) { ftp.disconnect();
	 * 
	 * return flag; } if( ftp.login(f.getUsername(), f.getPassword())) {
	 * ftp.changeWorkingDirectory(f.getPath()); flag = true; } return flag; }
	 */

	/*   
    *//**
	 * 关闭ftp连接
	 */
	/*
	 * public static void closeFtp(){ if (ftp!=null && ftp.isConnected()) { try
	 * { ftp.logout(); ftp.disconnect(); } catch (IOException e) {
	 * e.printStackTrace(); } } }
	 * 
	 * 
	 * 
	 * private static FTPClient ftp;
	 * 
	 * public static boolean upload(String basestr,String filename ,String
	 * pathname) { boolean flag1=false; try { BASE64Decoder decoder = new
	 * BASE64Decoder(); //创建byte数组，流放入到数组中 byte[] b; b =
	 * decoder.decodeBuffer(basestr); //for 为解码必带的 for(int i=0;i<b.length;++i) {
	 * if(b[i]<0) {//调整异常数据 b[i]+=256; } } //无论是本地还是调用.net将加密后的接口，生成文件流保存
	 * ByteArrayInputStream input = new ByteArrayInputStream(b); String[] path1
	 * =pathname.split("\\\\\\\\");//拆分数组 System.out.println(path1); String path
	 * = "D:\test";//字符串路径 for(int i=0;i<path1.length;i++){//先创建文件夹 if(i==0){
	 * path=path1[i]; ftp.makeDirectory(path); System.out.println(path); }else{
	 * path+="\\\\"+path1[i];//再加入图片
	 * 
	 * } } ftp.makeDirectory(path); //ftp.makeDirectory(pathname);
	 * ftp.changeWorkingDirectory(pathname); ftp.storeFile(filename,input);
	 * input.close(); flag1=true; } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return flag1; }
	 */

	/**
	   * 
	   * 
	   * 
	   * ***/

	public String show_da1() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {

				System.out.println(database);
				TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());
				// 机构代码表
				System.out.println(dm);
				TFzdm fzdm = null;
				fzdm = em.find(TFzdm.class, jgdm.getTyshxydm());
				TBgk tb = null;
				// tb =em.find(TBgk.class, jgdm.getTyshxydm());
				System.out.println(jgdm.getTyshxydm());
				String result = null;
				String bbh = null;
				// 通过用户的行政区划去查版本号
				User user = (User) session.get("sysUser");
				bbh = user.getMemo();
				String xq = null;
				xq = user.getBzjgdm();
				System.out.println(bbh);
				try {
					String sql1 = "select memo from sc_xzqhdz model  where  model.dm  like '%"
							+ xq + "%' ";
					DataAccess dataObject1 = new DataAccess();
					CachedRowSet cs1 = dataObject1.query(sql1);
					String memo = null;
					while (cs1.next()) {
						memo = cs1.getString("memo").toString();
						// 将版本号传入前台，前台进行处理
						ServletActionContext.getRequest().setAttribute("memo",
								memo);
						System.out.println(memo + "aaaaaaaaaaaa");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (dm != null) {
					try {
						String path = dm.getFilePach() + dm.getImageurl();
						System.out.println(path);
						FileInputStream is = new FileInputStream(path);
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						byte[] buffer = new byte[4098];
						int n = 0;
						while (-1 != (n = is.read(buffer))) {
							output.write(buffer, 0, n);
						}
						BASE64Encoder encoder = new BASE64Encoder();

						result = encoder.encode(output.toByteArray())
								.replaceAll("[\\s*\t\n\r]", "");
						System.out.println("返回页面数据：" + result);
						ServletActionContext.getRequest().setAttribute(
								"result", result);
					} catch (Exception e) {
						e.printStackTrace();

					}
					setMessage("代码主表");
					em.clear();
				}
				if (dm == null) {
					// 机构代码临时表
					// 机构代码注销表
					if (fzdm != null) {
						try {
							String path = fzdm.getFilePach()
									+ fzdm.getImageurl();
							System.out.println(path);
							FileInputStream is = new FileInputStream(path);
							ByteArrayOutputStream output = new ByteArrayOutputStream();
							byte[] buffer = new byte[4098];
							int n = 0;
							while (-1 != (n = is.read(buffer))) {
								output.write(buffer, 0, n);
							}
							BASE64Encoder encoder = new BASE64Encoder();

							result = encoder.encode(output.toByteArray())
									.replaceAll("[\\s*\t\n\r]", "");
							System.out.println("返回页面数据：" + result);
							ServletActionContext.getRequest().setAttribute(
									"result", result);
						} catch (Exception e) {
							e.printStackTrace();

						}
					}
				}
				if (dm == null) {
					// 机构代码临时表
					if (fzdm == null) {
						String sql = "select jgdm,FilePach,Imageurl from t_bgk model  where  model.Tyshxydm like '%"
								+ jgdm.getTyshxydm() + "%' ";

						System.out.println(sql + "11111111111111");

						DataAccess dataObject = new DataAccess();
						CachedRowSet cs = dataObject.query(sql);
						while (cs.next()) {
							String FilePach = cs.getString("FilePach")
									.toString();
							String Imageurl = cs.getString("Imageurl")
									.toString();
							// System.out.println(cs.getString("jgdm").toString());
							try {
								String path = FilePach + Imageurl;
								System.out.println(path);
								FileInputStream is = new FileInputStream(path);
								ByteArrayOutputStream output = new ByteArrayOutputStream();
								byte[] buffer = new byte[4098];
								int n = 0;
								while (-1 != (n = is.read(buffer))) {
									output.write(buffer, 0, n);
								}
								BASE64Encoder encoder = new BASE64Encoder();

								result = encoder.encode(output.toByteArray())
										.replaceAll("[\\s*\t\n\r]", "");
								System.out.println("返回页面数据：" + result);
								ServletActionContext.getRequest().setAttribute(
										"result", result);
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					}
				}
				List<TFddbr> fddbrList = em
						.createQuery(
								"from TFddbr model where model.tyshxydm=:tyshxydm")
						.setParameter("tyshxydm", jgdm.getTyshxydm())
						.getResultList();
				if (fddbrList.size() > 0) {
					fddbr = fddbrList.get(0);
					List<TFrjl> frjlList = em
							.createQuery(
									"from TFrjl model where model.frId=:frId")
							.setParameter("frId", fddbr.getLsh())
							.getResultList();
					if (frjlList.size() > 0) {
						frjl = frjlList.get(0);
					}
				}

				// listFzr= saveBus.fzrList(jgdm.getTyshxydm());

				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 代码详细");
				currentPath = path + "show2.jsp";

			}
		}.template();
	}

	public String show_sm1() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				System.out.println(database);
				if (page == null) {
					page = new Page();
					page.setOrderByField("jgdm");
					page.setOrderByType("desc");
				}

				TJgdm dm = new TJgdm();
				if (TJgdm.class.getName().equals(database)) {
					jgdms = getList();
					page.setTotalRecord(getCount());
					setMessage("机构代码表");
				} else if (TFzdm.class.getName().equals(database)) {
					List<TFzdm> fzdms = getList();
					page.setTotalRecord(getCount());
					setMessage("代码注销表");
					jgdms = new ArrayList<TJgdm>();
					for (TFzdm bgk : fzdms) {
						dm = new TJgdm();
						BeanUtilsEx.copyProperties(dm, bgk);
						jgdms.add(dm);
					}
				} else if (TBgk.class.getName().equals(database)) {
					// 机构代码注销表
					List<TBgk> bgks = null;
					bgks = getList();
					page.setTotalRecord(getCount());
					setMessage("代码当日变更表");
					jgdms = new ArrayList<TJgdm>();
					for (TBgk bgk : bgks) {
						dm = new TJgdm();
						BeanUtilsEx.copyProperties(dm, bgk);
						dm.setLry(bgk.getLry());
						jgdms.add(dm);
					}
				}

				List<TFddbr> fddbrList = em
						.createQuery(
								"from TFddbr model where model.tyshxydm=:tyshxydm")
						.setParameter("tyshxydm", jgdm.getTyshxydm())
						.getResultList();
				if (fddbrList.size() > 0) {
					fddbr = fddbrList.get(0);
					List<TFrjl> frjlList = em
							.createQuery(
									"from TFrjl model where model.frId=:frId")
							.setParameter("frId", fddbr.getLsh())
							.getResultList();
					if (frjlList.size() > 0) {
						frjl = frjlList.get(0);
					}
				}

				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 档案查看");
				currentPath = path + "list_sm1.jsp";
				setSource("show_sm1");

			}

			private int getCount() {
				User user = (User) session.get("sysUser");
				String sql = "select  count (model) from " + database
						+ " model  where  model.jgmc like '%" + jgdm.getJgmc()
						+ "%' ";
				if (jgdm.getBzjgdm() != null && !jgdm.getBzjgdm().equals("")) {
					sql += "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
				}
				// ((jgdm.getBzjgdm() == null || jgdm.getBzjgdm().equals("*")) ?
				// "" : " and  model.bzjgdm='" + jgdm.getBzjgdm() + "' ");
				return ((Long) em.createQuery(sql).getResultList().get(0))
						.intValue();
			}

			private List getList() {
				User user = (User) session.get("sysUser");
				String yhm = user.getUserName().toString();
				user.getBzjgdm();
				System.out.println(user.getUserName().toString());
				String orderBy = (page.getOrderByField() != null && !""
						.equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType())
						: "";
				String sql = "";

				sql = "select model from " + database
						+ " model  where ( model.jgmc like '%" + jgdm.getJgmc()
						+ "%' or model.tyshxydm like '%" + jgdm.getJgmc()
						+ "%'   or  model.jgmc like '%" + jgdm.getJgmc()
						+ "%')";

				if (jgdm.getBzjgdm() != null && !jgdm.getBzjgdm().equals("")) {
					sql += "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
				}
				// database

				sql += orderBy;
				return em.createQuery(sql)
						.setFirstResult(page.getStartRecord())
						.setMaxResults(page.getPageSize()).getResultList();
			}
		}.template();
	}
	
	/*
	 * 扫描
	 */
	public String show_sm() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {

				if (page == null) {
					page = new Page();
					page.setOrderByField("jgdm");
					page.setOrderByType("desc");
				}
				TJgdm dm = new TJgdm();
				if (TJgdm.class.getName().equals(database)) {
					jgdms = getList();
					page.setTotalRecord(getCount());
					setMessage("机构代码表");
				} else if (TFzdm.class.getName().equals(database)) {
					List<TFzdm> fzdms = getList();
					page.setTotalRecord(getCount());
					setMessage("代码注销表");
					jgdms = new ArrayList<TJgdm>();
					for (TFzdm bgk : fzdms) {
						dm = new TJgdm();
						BeanUtilsEx.copyProperties(dm, bgk);
						jgdms.add(dm);
					}
				} else if (TBgk.class.getName().equals(database)) {
					// 机构代码注销表
					List<TBgk> bgks = null;
					bgks = getList();
					page.setTotalRecord(getCount());
					setMessage("代码当日变更表");
					jgdms = new ArrayList<TJgdm>();
					for (TBgk bgk : bgks) {
						dm = new TJgdm();
						BeanUtilsEx.copyProperties(dm, bgk);
						dm.setLry(bgk.getLry());
						jgdms.add(dm);
					}
				}

				List<TFddbr> fddbrList = em
						.createQuery(
								"from TFddbr model where model.tyshxydm=:tyshxydm")
						.setParameter("tyshxydm", jgdm.getTyshxydm())
						.getResultList();
				if (fddbrList.size() > 0) {
					fddbr = fddbrList.get(0);
					List<TFrjl> frjlList = em
							.createQuery(
									"from TFrjl model where model.frId=:frId")
							.setParameter("frId", fddbr.getLsh())
							.getResultList();
					if (frjlList.size() > 0) {
						frjl = frjlList.get(0);
					}
				}

				setTitle("查询 &gt;&gt; 扫描管理&gt;&gt; 数据扫描");
				currentPath = path + "list_sm.jsp";
				setSource("show_sm");

			}

			private int getCount() {
				User user = (User) session.get("sysUser");
				String sql = "select  count (model) from " + database
						+ " model  where  model.jgmc like '%" + jgdm.getJgmc()
						+ "%' ";
				if (jgdm.getBzjgdm() != null && !jgdm.getBzjgdm().equals("")) {
					sql += "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
				}
				// ((jgdm.getBzjgdm() == null || jgdm.getBzjgdm().equals("*")) ?
				// "" : " and  model.bzjgdm='" + jgdm.getBzjgdm() + "' ");
				return ((Long) em.createQuery(sql).getResultList().get(0))
						.intValue();
			}

			private List getList() {
				User user = (User) session.get("sysUser");
				String yhm = user.getUserName().toString();
				user.getBzjgdm();
				System.out.println(user.getUserName().toString());
				String orderBy = (page.getOrderByField() != null && !""
						.equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType())
						: "";
				String sql = "";
				if (yhm.equals("admin")) {
					sql = "select model from " + database
							+ " model  where ( model.jgmc like '%"
							+ jgdm.getJgmc() + "%' or model.tyshxydm like '%"
							+ jgdm.getJgmc() + "%'   or  model.jgmc like '%"
							+ jgdm.getJgmc() + "%')";
				} else {
					sql = "select model from " + database
							+ " model  where  ( model.jgmc like '%"
							+ jgdm.getJgmc() + "%' or model.tyshxydm like '%"
							+ jgdm.getJgmc() + "%'   or  model.jgmc like '%"
							+ jgdm.getJgmc() + "%') and  model.bzjgdm = '"
							+ user.getBzjgdm() + "'";
				}
				if (jgdm.getBzjgdm() != null && !jgdm.getBzjgdm().equals("")) {
					sql += "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
				}
				// database

				sql += orderBy;
				return em.createQuery(sql)
						.setFirstResult(page.getStartRecord())
						.setMaxResults(page.getPageSize()).getResultList();
			}
		}.template();
	}

	// ---zhaojunbo 2017-09-28---------end

	public String show_dm() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());
				// 机构代码表

				if (dm != null) {
					jglx = dm.getJglx();
					jgdm = dm;
				}

				setMessage("代码主表");
				em.clear();
				// 机构代码表
				if (dm == null) {
					if (database != null
							&& database.equals(TJgdmSave.class.getName())) {
						TJgdmSave dmsave = em.find(TJgdmSave.class,
								Integer.valueOf(jgdm.getJgdm().trim()));
						if (dmsave != null) {
							setMessage("代码临时表");
							BeanUtilsEx.copyProperties(jgdm, dmsave);
							setDmStatus("临时表");
							setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 代码详细");
							jglx = jgdm.getJglx();
						}
						currentPath = path + "show.jsp";
						return;
					}
					// 机构代码临时表
					TFzdm fzdm = null;
					fzdm = em.find(TFzdm.class, jgdm.getTyshxydm());

					// 机构代码注销表
					if (fzdm != null) {
						setMessage("代码注销表");
						BeanUtilsEx.copyProperties(jgdm, fzdm);
						jglx = jgdm.getJglx();
					} else {

						currentPath = path + "search_dm.jsp";
						message = "查无数据！";
						return;
					}

				}

				List<TFddbr> fddbrList = em
						.createQuery(
								"from TFddbr model where model.tyshxydm=:tyshxydm")
						.setParameter("tyshxydm", jgdm.getTyshxydm())
						.getResultList();
				if (fddbrList.size() > 0) {
					fddbr = fddbrList.get(0);
					List<TFrjl> frjlList = em
							.createQuery(
									"from TFrjl model where model.frId=:frId")
							.setParameter("frId", fddbr.getLsh())
							.getResultList();
					if (frjlList.size() > 0) {
						frjl = frjlList.get(0);
					}
				}

				// listFzr= saveBus.fzrList(jgdm.getTyshxydm());

				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 代码详细");
				currentPath = path + "show.jsp";
			}
		}.template();
	}

	/**
	 * 按照名称查询机构代码
	 *
	 * @return
	 */
	public String show_mc() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {

				if (page == null) {
					page = new Page();
					page.setOrderByField("jgdm");
					page.setOrderByType("desc");
				}
				TJgdm dm = new TJgdm();
				if (TJgdm.class.getName().equals(database)) {
					jgdms = getList();
					page.setTotalRecord(getCount());
					setMessage("机构代码表");
				} else if (TFzdm.class.getName().equals(database)) {
					List<TFzdm> fzdms = getList();
					page.setTotalRecord(getCount());
					setMessage("代码注销表");
					jgdms = new ArrayList<TJgdm>();
					for (TFzdm bgk : fzdms) {
						dm = new TJgdm();
						BeanUtilsEx.copyProperties(dm, bgk);
						jgdms.add(dm);
					}
				} else if (TBgk.class.getName().equals(database)) {
					// 机构代码注销表
					List<TBgk> bgks = null;
					bgks = getList();
					page.setTotalRecord(getCount());
					setMessage("代码当日变更表");
					jgdms = new ArrayList<TJgdm>();
					for (TBgk bgk : bgks) {
						dm = new TJgdm();
						BeanUtilsEx.copyProperties(dm, bgk);
						dm.setLry(bgk.getLry());
						jgdms.add(dm);
					}
				}

				List<TFddbr> fddbrList = em
						.createQuery(
								"from TFddbr model where model.tyshxydm=:tyshxydm")
						.setParameter("tyshxydm", jgdm.getTyshxydm())
						.getResultList();
				if (fddbrList.size() > 0) {
					fddbr = fddbrList.get(0);
					List<TFrjl> frjlList = em
							.createQuery(
									"from TFrjl model where model.frId=:frId")
							.setParameter("frId", fddbr.getLsh())
							.getResultList();
					if (frjlList.size() > 0) {
						frjl = frjlList.get(0);
					}
				}

				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 按名称查询");
				currentPath = path + "list_mc.jsp";
				setSource("show_mc");

			}

			private int getCount() {
				User user = (User) session.get("sysUser");
				String sql = "select  count (model) from " + database
						+ " model  where  model.jgmc like '%" + jgdm.getJgmc()
						+ "%' ";
				if (jgdm.getBzjgdm() != null && !jgdm.getBzjgdm().equals("")) {
					sql += "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
				}
				// ((jgdm.getBzjgdm() == null || jgdm.getBzjgdm().equals("*")) ?
				// "" : " and  model.bzjgdm='" + jgdm.getBzjgdm() + "' ");
				return ((Long) em.createQuery(sql).getResultList().get(0))
						.intValue();
			}

			private List getList() {
				User user = (User) session.get("sysUser");
				String orderBy = (page.getOrderByField() != null && !""
						.equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType())
						: "";
				String sql = "select model from " + database
						+ " model  where  model.jgmc like '%" + jgdm.getJgmc()
						+ "%'  or model.jgdm like '%" + jgdm.getJgmc() + "%' ";
				if (jgdm.getBzjgdm() != null && !jgdm.getBzjgdm().equals("")) {
					sql += "and model.bzjgdm='" + jgdm.getBzjgdm() + "' ";
				}
				sql += orderBy;
				return em.createQuery(sql)
						.setFirstResult(page.getStartRecord())
						.setMaxResults(page.getPageSize()).getResultList();
			}
		}.template();
	}

	/**
	 * 多条件查询
	 *
	 * @return
	 */
	public String show_multi() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 多条件查询");
				setSource("show_multi");
				String bzjgdm = user.getBzjgdm().trim();
				if (user.getBzjgdm().trim().endsWith("0000")) {
					bzjgdm = user.getBzjgdm().trim().substring(0, 2);
				} else if (user.getBzjgdm().trim().endsWith("00")) {
					bzjgdm = user.getBzjgdm().trim().substring(0, 4);
				}
				if (database != null && !"".equals(database)) {
					if (page == null)
						page = new Page();
					try {
						sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll(
								"&lt;", "<");
						List list = em
								.createQuery(
										"select model from "
												+ database
												+ " model  where  bzjgdm like ('"
												+ bzjgdm + "%') and ("
												+ sqlwhere + ") " + order)
								.setFirstResult(page.getStartRecord())
								.setMaxResults(page.getPageSize())
								.getResultList();
						List<Map<Object, Object>> dataMaps = new ArrayList<Map<Object, Object>>();
						for (Object obj : list) {
							dataMaps.add(BeanUtilsEx.describe(obj));
						}
						for (Field field : fields) {
							if (field != null && field.isSelect()) {
								page.makeShowAttribute(field.getDm(),
										field.getName(),
										Page.AttributeType.show);
							}

						}
						page.setDataMaps(dataMaps);
						page.setTotalRecord(((Long) em
								.createQuery(
										"select count(model)  from "
												+ database
												+ " model  where model.bzjgdm like ('"
												+ bzjgdm + "%') and ("
												+ sqlwhere + ")")
								.getResultList().get(0)).intValue());
					} catch (Exception e) {
						log.error(StatisticsAction.class, e);
						setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 多条件查询");
						setSource("_multi");
						setMessage("输入的查询语句有问题请重新输入！");
						ttables = em
								.createQuery(
										"select model from Ttable model where model.tablecode=:tablecode or model.tablecode='t_fzdm' order by model.sn")
								.setParameter("tablecode", "t_jgdm")
								.getResultList();
						fields = new ArrayList<Field>();
						for (Ttable ttable : ttables) {
							fields.add(new Field(ttable.getColumncode(), ttable
									.getColumnname(), false));
						}
						currentPath = path + "search_multi.jsp";
						return;
					}
				}
				currentPath = path + "list.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 多条件查询
	 *
	 * @return
	 */
	public String export_search() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt; 查询列表");
				setSource("show_multi");
				if (database != null && !"".equals(database)) {
					if (page == null)
						page = new Page();
					User user = (User) session.get("sysUser");
					String bzjgdm = user.getBzjgdm().trim();

					if (user.getBzjgdm().trim().endsWith("0000")) {
						bzjgdm = user.getBzjgdm().trim().substring(0, 2);
					} else if (user.getBzjgdm().trim().endsWith("00")) {
						bzjgdm = user.getBzjgdm().trim().substring(0, 4);
					}
					try {
						sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll(
								"&lt;", "<");

						List list = em
								.createQuery(
										"select model from "
												+ database
												+ " model  where model.bzjgdm like '"
												+ bzjgdm + "%' and " + sqlwhere
												+ " " + order)
								.setFirstResult(page.getStartRecord())
								.setMaxResults(page.getPageSize())
								.getResultList();
						List<Map<Object, Object>> dataMaps = new ArrayList<Map<Object, Object>>();
						for (Object obj : list) {
							dataMaps.add(BeanUtilsEx.describe(obj));
						}
						for (Field field : fields) {
							if (field != null && field.isSelect()) {
								page.makeShowAttribute(field.getDm(),
										field.getName(),
										Page.AttributeType.show);
							}

						}
						page.setDataMaps(dataMaps);
						page.setTotalRecord(((Long) em
								.createQuery(
										"select count(model)  from "
												+ database
												+ " model  where model.bzjgdm like '"
												+ bzjgdm + "%' and  "
												+ sqlwhere).getResultList()
								.get(0)).intValue());
					} catch (Exception e) {
						setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt;查询");
						setSource("_multi");
						setMessage("输入的查询语句有问题请重新输入！");
						ttables = em
								.createQuery(
										"select model from Ttable model where model.tablecode=:tablecode or model.tablecode='t_fzdm' order by model.sn")
								.setParameter("tablecode", "t_jgdm")
								.getResultList();
						fields = new ArrayList<Field>();
						for (Ttable ttable : ttables) {
							fields.add(new Field(ttable.getColumncode(), ttable
									.getColumnname(), false));
						}
						currentPath = path + "export_search.jsp";
						return;
					}
				}
				currentPath = path + "list_export.jsp";
			}
		}.nSyTemplate();
	}

	public String export() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				if (database != null && !"".equals(database)) {
					String bzjgdm;
					User user = (User) session.get("sysUser");
					if (user.getBzjgdm().trim().endsWith("0000")) {
						bzjgdm = user.getBzjgdm().trim().substring(0, 2);
					} else if (user.getBzjgdm().trim().endsWith("00")) {
						bzjgdm = user.getBzjgdm().trim().substring(0, 4);
					} else {
						bzjgdm = user.getBzjgdm().trim();
					}
					fileName = getUName();
					sqlwhere = sqlwhere.replaceAll("&gt;", ">").replaceAll(
							"&lt;", "<");
					if (ExcelUtils.export(
							UserPropertiesData
									.getValueByPropertyName("tempPath")
									+ "/"
									+ fileName, database, bzjgdm, sqlwhere,
							fields)) {
						setTitle("查询 &gt;&gt; 机构查询 &gt;&gt; 数据导出 &gt;&gt; 下载");
						currentPath = path + "download.jsp";
						return;
					}
				}
				setMessage("系统异常，请联系管理员！");
				currentPath = path + "download.jsp";
			}

		}.nSyTemplate();
	}

	public String download() {

		try {
			File file = new File(
					UserPropertiesData.getValueByPropertyName("tempPath") + "/"
							+ fileName);
			HttpServletResponse response = ServletActionContext.getResponse();
			OutputStream outputStream = null;
			outputStream = response.getOutputStream();
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);// 设定输出文件头
			response.setContentType("application/vnd.ms-excel; charset=GB2312");// 定义输出类型
			FileInputStream inputStream = new FileInputStream(file);
			response.setContentLength(Long.valueOf(file.length()).intValue());
			byte[] chars = new byte[4096];
			int len;
			while ((len = inputStream.read(chars)) != -1) {
				outputStream.write(chars, 0, len);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
			file.delete();
		} catch (IOException e) {
			log.error(StatisticsAction.class, e);
		}

		return null;
	}

	/**
	 * 新办卡量，查询
	 *
	 * @return
	 */
	public String list_kxxk() {
		return new ActionUtils(session) {

			@Override
			protected void excute() throws Exception {
				if (page == null) {
					page = new Page();
					page.setOrderByField("njrq");
					page.setOrderByType("desc");
				}
				if (startDate == null)
					startDate = DateUtil.getFormatedDate(DateUtil
							.dateToStr(new Date()));
				if (endDate == null)
					endDate = DateUtil.dayAfter(new Date(), 1);
				String sql = " from TJgdm model where model.jgdm in(select distinct kxxk.jgdm from TkKxxk kxxk where kxxk.haveDown='0' and kxxk.sqsj between ?1 and ?2 ) and bzjgdm =?3";
				String orderBy = (page.getOrderByField() != null && !""
						.equals(page.getOrderByField())) ? (" order by jgdm."
						+ page.getOrderByField() + " " + page.getOrderByType())
						: "";
				jgdms = em.createQuery("select model " + sql + orderBy)
						.setParameter(1, startDate).setParameter(2, endDate)
						.setParameter(3, getUser().getBzjgdm())
						.setFirstResult(page.getStartRecord())
						.setMaxResults(page.getPageSize()).getResultList();
				page.setTotalRecord(((Long) em
						.createQuery("select count(model) " + sql)
						.setParameter(1, startDate).setParameter(2, endDate)
						.setParameter(3, getUser().getBzjgdm()).getResultList()
						.get(0)).intValue());
				currentPath = path + "list_kxxk.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 历史记录查询
	 *
	 * @return
	 */
	public String list_frs() {
		return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				currentPath = path + "list_frs.jsp";
				if (page == null) {
					page = new Page();
					page.setOrderByField("lastdate");
					page.setOrderByType("desc");
				}
				String where = " ";
				if (jgdm != null) {
					if (jgdm.getFddbr() != null && !"".equals(jgdm.getFddbr())) {
						where += " and model.fddbr='" + jgdm.getFddbr() + "' ";
					}
					if (jgdm.getZjhm() != null && !"".equals(jgdm.getZjhm())) {
						String card = jgdm.getFddbr().trim();
						if (card.length() == 18)
							card = IDCardUtil.from18to15(card);
						if (card.length() == 15)
							card = IDCardUtil.from15to18(19, card);
						where += " and ( model.zjhm='" + jgdm.getFddbr().trim()
								+ "' or model.zjhm='" + card + "' )";
					}
				}
				if ("".equals(where.trim())) {
					return;
				}

				String orderBy = (page.getOrderByField() != null && !""
						.equals(page.getOrderByField())) ? (" order by jgdm."
						+ page.getOrderByField() + " " + page.getOrderByType())
						: "";
				jgdms = em
						.createQuery(
								"select model from TJgdm  model   where 1=1   "
										+ where + orderBy)
						.setFirstResult(page.getStartRecord())
						.setMaxResults(page.getPageSize()).getResultList();

				int count = ((Long) em
						.createQuery(
								"select count(model)   from TJgdm model where 1=1  "
										+ where).getResultList().get(0))
						.intValue();
				List<TQzjgdm> qzjgdms = null;
				if (jgdms.size() != 0 && jgdms.size() < page.getPageSize()) {
					qzjgdms = em
							.createQuery(
									"select model from TQzjgdm  model where model.qzbz <> '2' "
											+ where + orderBy)
							.setFirstResult(jgdms.size())
							.setMaxResults(page.getPageSize() - jgdms.size())
							.getResultList();
				} else if (jgdms.size() == 0) {
					qzjgdms = em
							.createQuery(
									"select model from TQzjgdm  model where model.qzbz <> '2' "
											+ where + orderBy)
							.setFirstResult(page.getStartRecord() - count)
							.setMaxResults(page.getPageSize() - jgdms.size())
							.getResultList();
				}
				if (qzjgdms != null) {
					for (TQzjgdm qzjgdm : qzjgdms) {
						TJgdm jgdm = new TJgdm();
						BeanUtilsEx.copyProperties(jgdm, qzjgdm);
						jgdms.add(jgdm);
					}
				}

				count += ((Long) em
						.createQuery(
								"select count(model)   from TQzjgdm  model where model.qzbz <> '2' "
										+ where).getResultList().get(0))
						.intValue();
				page.setTotalRecord(count);
			}
		}.nSyTemplate();
	}

	public String show_frs() {
		return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				if (sns != null && !"".equals(sns)) {
					String[] sn = sns.split(",");
					if (sn.length >= 1) {
						jgdm = em.find(TJgdm.class, sn[0].trim());
						if (jgdm == null) {
							List<TQzjgdm> qzjgdm = em
									.createQuery(
											"select model from TQzjgdm model where model.jgdm=?1")
									.setParameter(1, sn[0].trim())
									.getResultList();
							jgdm = new TJgdm();
							if (!qzjgdm.isEmpty())
								BeanUtilsEx.copyProperties(jgdm, qzjgdm.get(0));
						}

					}
					if (sn.length >= 2) {
						jgdm2 = em.find(TJgdm.class, sn[1].trim());
						if (jgdm2 == null) {
							List<TQzjgdm> qzjgdm = em
									.createQuery(
											"select model from TQzjgdm model where model.jgdm=?1")
									.setParameter(1, sn[1].trim())
									.getResultList();
							jgdm2 = new TJgdm();
							if (!qzjgdm.isEmpty())
								BeanUtilsEx
										.copyProperties(jgdm2, qzjgdm.get(0));
						}
					} else {
						currentPath = path + "show_fr.jsp";
						return;
					}
					currentPath = path + "show_frs.jsp";

				}

			}
		}.nSyTemplate();
	}

	/**
	 * 历史记录查询
	 *
	 * @return
	 */
	public String list_bgks() {
		return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				if (page == null) {
					page = new Page();
					page.setOrderByField("lastdate");
					page.setOrderByType("desc");
				}
				String orderBy = (page.getOrderByField() != null && !""
						.equals(page.getOrderByField())) ? (" order by jgdm."
						+ page.getOrderByField() + " " + page.getOrderByType())
						: "";
				bgks = em
						.createQuery(
								"select model from TBgk model "
										+ ((jgdm != null
												&& jgdm.getJgdm() != null && !""
													.equals(jgdm.getJgdm())) ? " where model.jgdm like '%"
												+ jgdm.getJgdm() + "%' "
												: "") + orderBy)
						.getResultList();
				currentPath = path + "list_bgks.jsp";
			}
		}.nSyTemplate();
	}

	public String show_diff() {
		return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				if (sns != null && !"".equals(sns)) {
					String[] sn = sns.split(",");
					if (sn.length >= 1) {
						if (sn[0].trim().length() == 9) {
							jgdm = em.find(TJgdm.class, sn[0].trim());
							bgk = new TBgk();
							BeanUtilsEx.copyProperties(bgk, jgdm);
						} else {
							bgk = em.find(TBgk.class, Long.valueOf(sn[0]));
							jgdm = new TJgdm();
							BeanUtilsEx.copyProperties(jgdm, bgk);
						}
						if (sn.length >= 2) {
							if (sn[1].trim().length() == 9) {
								jgdm = em.find(TJgdm.class, sn[1].trim());
								bgk2 = new TBgk();
								BeanUtilsEx.copyProperties(bgk2, jgdm);
							} else {
								bgk2 = em.find(TBgk.class, Long.valueOf(sn[1]));
							}
						} else {
							currentPath = path + "show_bgk.jsp";
							return;
						}
					}

					currentPath = path + "show_diff.jsp";
				}

			}
		}.nSyTemplate();
	}

	public String show_bgk() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				bgk = em.find(TBgk.class, bgk.getSn());
				jgdm = new TJgdm();
				BeanUtilsEx.copyProperties(jgdm, bgk);
				currentPath = path + "show_bgk.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 月统计机构类型
	 *
	 * @return
	 */
	public String monthCounsc_xzqh_jglx() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				if (source != null && "export".equals(source)) {
					export_type("jglx", jgdm == null ? null : jgdm.getJglx());
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按机构类型统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				excuteBy("jglx", jgdm == null ? null : jgdm.getJglx());

				setColumnName("机构类型");
				setSource("jglx");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按机构类型统计");
				currentPath = path + "monthCounsc_xzqh.jsp";
				getBzjgFenJiMap();

			}
		}.nSyTemplate();
	}

	private void getBzjgFenJiMap() {
		// ///////////////////////////////////////////////////
		User user = (User) session.get("sysUser");
		String bzjgdm = user.getBzjgdm();
		// String xzqhdm = InitSysParams.system.getXzqhdm();
		String xzqhdm = "";
		// Map<String, String> zrxzqhMap=zrxzqhBus.getMap();
		Map<String, String> zrxzqhMap = InitSysParams.bzjgdmMap;
		/*
		 * if(!bzjgdm.equals(xzqhdm)){ if(bzjgdm.endsWith("00")){
		 * Iterator<Map.Entry<String, String>> it =
		 * zrxzqhMap.entrySet().iterator(); while(it.hasNext()){
		 * Map.Entry<String, String> entry=it.next(); String key=entry.getKey();
		 * if(!key.startsWith(bzjgdm.substring(0,4))){ it.remove(); } } }else{
		 * Iterator<Map.Entry<String, String>> it =
		 * zrxzqhMap.entrySet().iterator(); while(it.hasNext()){
		 * Map.Entry<String, String> entry=it.next(); String key=entry.getKey();
		 * if(!key.equals(bzjgdm)){ it.remove(); } } } }
		 */
		ActionContext.getContext().put("bzjgMap", zrxzqhMap);
		// ////////////////////////////////////////////////////
	}

	public String monthCounsc_xzqh_jglx_tu() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				excuteForJson("jglx", jgdm == null ? null : jgdm.getJglx());
				setColumnName("机构类型");
				setSource("jglx");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按机构类型统计 &gt;&gt; 信息图");
				currentPath = path + "monthCounsc_xzqh_tu.jsp";
			}
		}.nSyTemplate();
	}

	public String monthCounsc_xzqh_jjlx2011() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				if (source != null && "export".equals(source)) {
					export_type("jglx",
							jgdm == null ? null : jgdm.getJjlx2011());
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济类型统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				excuteBy("jjlx2011", jgdm == null ? null : jgdm.getJjlx2011());
				setColumnName("机构类型");
				setSource("jjlx2011");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按登记类型统计");
				currentPath = path + "monthCounsc_xzqh.jsp";

				getBzjgFenJiMap();

			}
		}.nSyTemplate();
	}

	private void fenJi() {
		/*
		 * User user = (User) session.get("sysUser"); String
		 * bzjgdm=user.getBzjgdm(); String xzqhdm =
		 * InitSysParams.system.getXzqhdm(); if(jgdm==null){ jgdm=new TJgdm(); }
		 * if(!bzjgdm.equals(xzqhdm)){
		 * if(jgdm.getXzqh()==null||jgdm.getXzqh().equals("*")){
		 * if(bzjgdm.endsWith("00")){ jgdm.setXzqh(bzjgdm.substring(0,4));
		 * }else{ jgdm.setXzqh(bzjgdm); } } }
		 */
	}

	/**
	 * 按照行政区划 经济行业统计
	 *
	 * @return
	 */
	public String counsc_xzqh_jjhy() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				DataAccess dataObject = new DataAccess();
				String sql = "";
				int length = -1;
				if (jgdm == null)
					jgdm = new TJgdm();

				fenJi();
				getBzjgFenJiMap();
				if (year == null || year == 0) {
					year = Calendar.getInstance().get(Calendar.YEAR);
					month = Calendar.getInstance().get(Calendar.MONTH) + 1;
					day = Calendar.getInstance().get(Calendar.MONTH);
				}
				if (jgdm.getJjhy2011() != null
						&& !"".equals(jgdm.getJjhy2011())) {
					length = jgdm.getJjhy2011().length();
				}
				length = length + 2;
				CachedRowSet cs;
				models = new ArrayList<Model>();
				if (type != null && type) {
					sql = "select  xzqh,substring(njjhy, 1, "
							+ length
							+ ")  as jjhy, sum(num) as num,fl from  sc_jjhy "
							+ " where 1=1 "
							+ ((jgdm.getXzqh() == null
									|| "*".equals(jgdm.getXzqh()) || ""
										.equals(jgdm.getXzqh())) ? ""
									: (" and xzqh = '" + jgdm.getXzqh() + "' "))
							+
							// ((jgdm.getJjhy() == null ||
							// "*".equals(jgdm.getJjhy()) ||
							// "".equals(jgdm.getJjhy())) ? "" :
							(" and njjhy like '" + jgdm.getJjhy2011() + "%' ")
							+ ((jgdm.getJjhy2011() == null
									|| "*".equals(jgdm.getJjhy2011()) || ""
										.equals(jgdm.getJjhy2011())) ? ""
									: (" and fl = '" + jgdm.getJjhy2011() + "' "))
							+ " group by xzqh,fl,substring(njjhy, 1," + length
							+ ") order by xzqh,fl";
					cs = dataObject.query(sql);
					if (source != null && "export".equals(source)) {
						export_RowSet(cs, "xzqh", "fl");
						setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济行业统计 &gt;&gt; 下载");
						currentPath = path + "download.jsp";
						return;
					}

					while (cs.next()) {
						Model model = new Model();
						model.setColumn1(cs.getString("xzqh").trim());
						model.setColumn2(cs.getString("jjhy").trim());
						model.setColumn3(cs.getString("fl").trim());
						model.setCount1(cs.getInt("num"));
						models.add(model);
					}
				} else {
					sql = "select  xzqh, fl, sum(num) as num  from  sc_jjhy "
							+ " where 1=1 "
							+ ((jgdm.getXzqh() == null
									|| "*".equals(jgdm.getXzqh()) || ""
										.equals(jgdm.getXzqh())) ? ""
									: (" and xzqh like '" + jgdm.getXzqh() + "%' "))
							+
							// ((jgdm.getJjhy() == null ||
							// "*".equals(jgdm.getJjhy()) ||
							// "".equals(jgdm.getJjhy())) ? "" :
							(" and njjhy like '" + jgdm.getJjhy2011() + "%' ")
							+ ((jgdm.getJjhy2011() == null
									|| "*".equals(jgdm.getJjhy2011()) || ""
										.equals(jgdm.getJjhy2011())) ? ""
									: (" and fl = '" + jgdm.getJjhy2011() + "' "))
							+ " group by xzqh,fl  order by xzqh,fl";
					cs = dataObject.query(sql);
					if (source != null && "export".equals(source)) {
						export_RowSet(cs, "xzqh", "fl");
						setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济行业统计 &gt;&gt; 下载");
						currentPath = path + "download.jsp";
						return;
					}
					while (cs.next()) {
						Model model = new Model();
						model.setColumn1(cs.getString("xzqh").trim());
						model.setColumn3(cs.getString("fl").trim());
						model.setCount1(cs.getInt("num"));
						models.add(model);
					}
				}
				cs.close();
				setColumnName("行业类型");
				setSource("jjhy");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 按经济行业统计");
				currentPath = path + "counsc_xzqh_jjhy.jsp";

			}
		}.nSyTemplate();
	}

	/**
	 * 统计时间段内行政区划每个业务的业务量
	 *
	 * @return
	 */
	public String countDailyBus() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				// lvwei 2017-09-27 统计权限修改
				fenJi();
				getBzjgFenJiMap();
				if ((startDate == null) || (endDate == null)) {
					endDate = DateUtil
							.strToDate(DateUtil.dateToStr(new Date()));
					startDate = endDate;
				}

				Date end = DateUtil.dayAfter(endDate, 1);
				DataAccess dataObject = new DataAccess();
				modelMaps = new HashMap<String, List<Model>>();
				models = new ArrayList<Model>();
				String sql = "select b.xzqh,b.type,count(id) as num from "
						+ "(select bzjgdm as xzqh,type,id from t_czjl  where "
						+ getTydmJglx()
						+ "(date between '"
						+ DateUtil.dateToStr(startDate)
						+ "' and '"
						+ DateUtil.dateToStr(end)
						+ "')) c "
						+ "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id,czlxdm as type from sc_bzjgdm,t_operate_type where czlxdm in('1','1A','2','3','8','KP')) b on c.xzqh = b.xzqh and c.type = b.type  where 1=1 "
						+ xzqhSql()
						+ ((jgdm == null || jgdm.getXzqh() == null || "*"
								.equals(jgdm.getXzqh())) ? ""
								: (" and b.xzqh like '" + jgdm.getXzqh() + "%' "))
						+ "group by b.xzqh,b.type order by b.xzqh,b.type";
				CachedRowSet cs = dataObject.query(sql);
				if (source != null && "export".equals(source)) {
					export_RowSet(cs, "xzqh", "type");
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				while (cs.next()) {
					Model model = new Model();
					model.setColumn1(cs.getString("xzqh"));
					model.setColumn2(cs.getString("type"));
					model.setCount1(cs.getInt("num"));
					models.add(model);
				}
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务统计");
				currentPath = path + "countDailyBus.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 统计时间段内行政区划每个业务的业务量,及比例
	 *
	 * @return
	 */
	public String rateDailyBus() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				// lvwei 2017-09-27 修改统计权限 日常业务量统计
				if ((startDate == null) || (endDate == null)) {
					endDate = DateUtil
							.strToDate(DateUtil.dateToStr(new Date()));
					startDate = DateUtil.dayBefore(endDate, 10);
				}
				Date end = DateUtil.dayAfter(endDate, 1);
				DataAccess dataObject = new DataAccess();
				modelMaps = new HashMap<String, List<Model>>();
				models = new ArrayList<Model>();
				fenJi();
				getBzjgFenJiMap();
				String sql = "select c.xzqh,c.type,sum(num) as num,cast(cast(isnull(sum(num),0) as decimal(10,2))/cast(c.zong as decimal(10,2))*100 as decimal(10,2)) as rate from "
						+ "(select c.xzqh,c.type,count(id) as num,(select sum(1) from t_czjl where "
						+ getTydmJglx()
						+ "(date between '"
						+ DateUtil.dateToStr(startDate)
						+ "' and '"
						+ DateUtil.dateToStr(end)
						+ "') and xzqh in (SELECT bzjg_id as xzqh from sc_bzjgdm b where 1=1 "
						+ xzqhSql()
						+ ") ) as zong from "
						+ "(select * from t_czjl where "
						+ getTydmJglx()
						+ "(date between '"
						+ DateUtil.dateToStr(startDate)
						+ "' and '"
						+ DateUtil.dateToStr(end)
						+ "')) b right join "
						+ "(select bzjg_id as xzqh,sjbzjg_id,bzjg_id,czlxdm as type from sc_bzjgdm b,t_operate_type where czlxdm in('1','2','3','8','KP')) c on c.xzqh = b.bzjgdm and c.type = b.type  where 1=1 "
						+ xzqhSql().replace("b.", "c.")
						+ " group by c.xzqh,c.type) c "
						+ ((jgdm == null || jgdm.getXzqh() == null || "*"
								.equals(jgdm.getXzqh())) ? ""
								: (" where  c.xzqh like '" + jgdm.getXzqh() + "%' "))
						+ " group by c.xzqh,c.type,c.zong order by c.xzqh,c.type";
				CachedRowSet cs = dataObject.query(sql);
				if (source != null && "export".equals(source)) {
					export_RowSet(cs, "xzqh", "type", "rate");
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务率统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				while (cs.next()) {
					Model model = new Model();
					model.setColumn1(cs.getString("xzqh"));
					model.setColumn2(cs.getString("type"));
					model.setCount1(cs.getInt("num"));
					model.setRate1(cs.getDouble("rate"));
					models.add(model);
				}
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常业务率统计");
				// currentPath = path + "rateDailyBus.jsp";
				currentPath = path + "rateDailyBus.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 统计时间段内行政区划每个业务的业务量
	 *
	 * @return
	 */
	public String countYearDailyBus() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {

				User user = (User) session.get("sysUser");
				DataAccess dataObject = new DataAccess();
				models = new ArrayList<Model>();
				if (year == null) {
					month = Calendar.getInstance().get(Calendar.YEAR);
					year = month - 2;
				}
				if (jgdm == null) {
					jgdm = new TJgdm();
					jgdm.setXzqh(user.getBzjgdm());
				}

				fenJi();
				getBzjgFenJiMap();

				String sql = "select year ,xzqh,type, num  from tk_yw_year where "
						+ " year BETWEEN "
						+ year
						+ " and "
						+ month
						+ (jgdm.getXzqh() == null ? "" : " and xzqh like '"
								+ jgdm.getXzqh() + "%'");
				CachedRowSet cs = dataObject.query(sql);
				if (source != null && "export".equals(source)) {
					export_RowSet(cs, "xzqh", "type");
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常同期比统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				while (cs.next()) {
					Model model = new Model();
					model.setColumn1(cs.getString("xzqh"));
					model.setColumn2(cs.getString("type"));
					model.setColumn3(cs.getString("year"));
					model.setCount1(cs.getInt("num"));
					models.add(model);
				}
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常同期比统计");
				currentPath = path + "countYearDailyBus.jsp";
			}
		}.nSyTemplate();
	}

	public String countYearDailyBus_tu() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				User user = (User) session.get("sysUser");
				DataAccess dataObject = new DataAccess();
				models = new ArrayList<Model>();
				mapMap = new HashMap<String, Map>();
				if (year == null) {
					month = Calendar.getInstance().get(Calendar.YEAR);
					year = month - 2;
				}
				if (jgdm == null) {
					jgdm = new TJgdm();
					jgdm.setXzqh(user.getBzjgdm());
				}

				String sql = "select year ,xzqh,type, num  from tk_yw_year where "
						+ " year BETWEEN "
						+ year
						+ " and "
						+ month
						+ (jgdm.getXzqh() == null ? "" : " and xzqh='"
								+ jgdm.getXzqh() + "' order by year");
				CachedRowSet cs = dataObject.query(sql);
				String xzqh = "";
				String type = "";
				String year = "";
				while (cs.next()) {
					xzqh = cs.getString("xzqh").trim();
					type = cs.getString("type").trim();
					year = cs.getString("year").trim();
					Model model = new Model();
					model.setColumn1(xzqh);
					model.setColumn2(type);
					model.setColumn3(year);
					model.setCount1(cs.getInt("num"));
					if (mapMap.keySet().contains("" + xzqh)) {
						modelMaps = mapMap.get(xzqh);
					} else {
						modelMaps = new HashMap<String, List<Model>>();
					}
					if (modelMaps.keySet().contains("" + year)) {
						models = modelMaps.get(year);
					} else {
						models = new ArrayList<Model>();
					}
					models.add(model);
					modelMaps.put(year, models);
					mapMap.put(xzqh, modelMaps);
				}
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日常同期比统计 &gt;&gt; 信息图");
				currentPath = path + "countYearDailyBus_tu.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 日业务量统计
	 *
	 * @return
	 */
	public String dayBusCount() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				if (startDate == null) {
					startDate = Calendar.getInstance().getTime();
				}
				DataAccess dataObject = new DataAccess();
				modelMaps = new TreeMap<String, List<Model>>(
						new Comparator<Object>() {
							public int compare(Object obj1, Object obj2) {
								Integer v1 = Integer.valueOf(obj1.toString());
								Integer v2 = Integer.valueOf(obj2.toString());
								if (v1 == null)
									return -1;
								int s = v1.compareTo(v2);
								return s;
							}
						});

				fenJi();
				models = new ArrayList<Model>();
				String sql = "select c.type,count(id) as num from (select * from t_czjl where "
						+ getTydmJglx()
						+ ((jgdm == null || jgdm.getXzqh() == null || "*"
								.equals(jgdm.getXzqh())) ? "" : ("xzqh like '"
								+ jgdm.getXzqh() + "%' and "))
						+ " datediff(day,date,'"
						+ DateUtil.dateToStr(startDate)
						+ "')=0 and bzjgdm in (select bzjg_id from sc_bzjgdm b where 1=1 "
						+ xzqhSql()
						+ ")) b right join "
						+ "(select czlxdm as type from t_operate_type where czlxdm in('1','1A','2','3','8','KP')) c on c.type = b.type "
						+ " group by  c.type order by c.type";
				CachedRowSet cs = dataObject.query(sql);
				if (source != null && "export".equals(source)) {
					export_date(cs, "type", DateUtil.dateToStr(startDate) + "日");
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				while (cs.next()) {
					Model model = new Model();
					model.setColumn1(cs.getString("type"));
					model.setCount1(cs.getInt("num"));
					models.add(model);
				}
				setColumnName(DateUtil.dateToStr(startDate) + "日");
				setSource("day");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计");
				currentPath = path + "busCount.jsp";
			}
		}.nSyTemplate();
	}

	/**
	 * 周业务量统计
	 *
	 * @return
	 */
	public String weekBusCount() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				fenJi();
				if (startDate == null) {
					startDate = Calendar.getInstance().getTime();
				}
				DataAccess dataObject = new DataAccess();
				modelMaps = new TreeMap<String, List<Model>>(
						new Comparator<Object>() {
							public int compare(Object obj1, Object obj2) {
								Integer v1 = Integer.valueOf(obj1.toString());
								Integer v2 = Integer.valueOf(obj2.toString());
								if (v1 == null)
									return -1;
								int s = v1.compareTo(v2);
								return s;
							}
						});
				models = new ArrayList<Model>();

				String sql = "select  c.type,count(id) as num from (select * from t_czjl where "
						+ getTydmJglx()
						+ ((jgdm == null || jgdm.getXzqh() == null || "*"
								.equals(jgdm.getXzqh())) ? "" : ("xzqh like '"
								+ jgdm.getXzqh() + "%' and "))
						+ " datediff(week,date,'"
						+ DateUtil.dateToStr(startDate)
						+ "')=0 and bzjgdm in (select bzjg_id from sc_bzjgdm b where 1=1 "
						+ xzqhSql()
						+ ")) b right join "
						+ "(select czlxdm as type from t_operate_type where czlxdm in('1','1A','2','3','8','KP')) c on c.type = b.type "
						+ " group by c.type order by c.type";
				CachedRowSet cs = dataObject.query(sql);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(startDate);
				setColumnName(calendar.get(Calendar.YEAR) + "年第"
						+ calendar.get(Calendar.WEEK_OF_YEAR) + "周("
						+ DateUtil.dateToStr(startDate) + ")");

				if (source != null && "export".equals(source)) {
					export_date(cs, "type", getColumnName());
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				while (cs.next()) {
					Model model = new Model();
					model.setColumn1(cs.getString("type"));
					model.setCount1(cs.getInt("num"));
					models.add(model);
				}

				setSource("week");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 周业务统计");
				currentPath = path + "busCount.jsp";
			}
		}.template();
	}

	/**
	 * 月业务量统计
	 *
	 * @return
	 */
	public String monthBusCount() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				fenJi();
				if (year == null || year == 0) {
					year = Calendar.getInstance().get(Calendar.YEAR);
					month = Calendar.getInstance().get(Calendar.MONTH) + 1;
				}
				DataAccess dataObject = new DataAccess();
				modelMaps = new TreeMap<String, List<Model>>(
						new Comparator<Object>() {
							public int compare(Object obj1, Object obj2) {
								Integer v1 = Integer.valueOf(obj1.toString());
								Integer v2 = Integer.valueOf(obj2.toString());
								if (v1 == null)
									return -1;
								int s = v1.compareTo(v2);
								return s;
							}
						});
				models = new ArrayList<Model>();
				String sql = "select  c.type,count(id) as num from (select * from t_czjl where "
						+ getTydmJglx()
						+ ((jgdm == null || jgdm.getXzqh() == null || "*"
								.equals(jgdm.getXzqh())) ? "" : ("xzqh like '"
								+ jgdm.getXzqh() + "%' and "))
						+ " datediff(month,date,'"
						+ year
						+ "-"
						+ month
						+ "-01')=0 and bzjgdm in (select bzjg_id from sc_bzjgdm b where 1=1 "
						+ xzqhSql()
						+ ")) b right join "
						+ "(select czlxdm as type from t_operate_type where czlxdm in('1','1A','2','3','8','KP')) c on c.type = b.type "
						+ " group by c.type order by c.type";
				CachedRowSet cs = dataObject.query(sql);
				if (source != null && "export".equals(source)) {
					export_date(cs, "type", month + "月份");
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 日业务统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				while (cs.next()) {
					Model model = new Model();
					model.setColumn1(cs.getString("type"));
					model.setCount1(cs.getInt("num"));
					models.add(model);
				}
				setColumnName(month + "月份");
				setSource("month");
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 月业务统计");
				currentPath = path + "busCount.jsp";
			}
		}.template();
	}

	/**
	 * 统计库每个行政区划的业务量
	 *
	 * @return
	 */
	public String countCodeBase_xzqh() {
		return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				fenJi();
				getBzjgFenJiMap();

				DataAccess dataObject = new DataAccess();
				modelMaps = new HashMap<String, List<Model>>();
				if (database == null || "*".equals(database)) {
					modelMaps.put("t_jgdm", getModels(dataObject, "t_jgdm"));
					modelMaps.put("t_fzdm", getModels(dataObject, "t_fzdm"));
					// modelMaps.put("t_ljdm", getModels(dataObject, "t_ljdm"));
				} else {
					modelMaps.put(database, getModels(dataObject, database));
				}
				if (source != null && "export".equals(source)) {
					export_Map(modelMaps);
					setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 代码库数据统计 &gt;&gt; 下载");
					currentPath = path + "download.jsp";
					return;
				}
				setTitle("统计 &gt;&gt; 办证业务统计 &gt;&gt; 代码库数据统计");
				currentPath = path + "countCodeBase_xzqh.jsp";
			}
		}.nSyTemplate();
	}

	private List<Model> getModels(DataAccess dataObject, String database)
			throws Exception {
		// lvwei 2017-09-26 修改统计权限
		List<Model> models = new ArrayList<Model>();
		String gb = "  group by b.bzjg_id order by b.bzjg_id";
		String sql = "select b.bzjg_id as xzqh,count(1) as num from "
				+ database
				+ " c  right join sc_bzjgdm b on c.bzjgdm = b.bzjg_id "
				+ getJglx("and c.") + "  where 1=1 " + xzqhSql();
		CachedRowSet cs = null;
		if (jgdm == null || jgdm.getXzqh() == null
				|| "*".equals(jgdm.getXzqh())) {
			sql += gb;
		} else {
			sql += " where  b.bzjg_id like '" + jgdm.getXzqh() + "%' " + gb;

		}
		cs = dataObject.query(sql);
		while (cs.next()) {
			Model model = new Model();
			model.setColumn1(cs.getString("xzqh"));
			model.setCount1(cs.getInt("num") == 1 ? 0 : cs.getInt("num"));
			models.add(model);
		}
		cs.close();
		return models;
	}

	private void export_type(String tableColumn, String value) throws Exception {
		User user = (User) session.get("sysUser");
		if (jgdm == null) {
			jgdm = new TJgdm();
			jgdm.setXzqh(user.getBzjgdm());
		} else {
			if ("*".equals(jgdm.getXzqh())) {
				jgdm.setXzqh(null);
			}
			if ("*".equals(value)) {
				value = null;
			}
		}
		models = new ArrayList<Model>();
		if (year == null || year == 0) {
			year = Calendar.getInstance().get(Calendar.YEAR);
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			day = Calendar.getInstance().get(Calendar.MONTH);
		}
		DataAccess dataObject = new DataAccess();
		String sql = "select b.xzqh,b."
				+ tableColumn
				+ ",count(jgdm) as num from "
				+ "(select bzjgdm,"
				+ tableColumn
				+ ",jgdm from t_jgdm where datediff(month,lastdate,'"
				+ year
				+ "-"
				+ month
				+ "-1')=0) c "
				+ "right join (select bzjg_id as xzqh,dm as "
				+ tableColumn
				+ " from sc_bzjgdm,"
				+ ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'"
						: "sc_" + tableColumn)
				+ ") b on c.bzjgdm = b.xzqh and c."
				+ tableColumn
				+ " = b."
				+ tableColumn
				+ " where 1=1 "
				+ (jgdm.getXzqh() != null ? (" and c.bzjgdm='" + jgdm.getXzqh() + "' ")
						: "")
				+ (value == null ? ""
						: (" and c." + tableColumn + "='" + value + "' "))
				+ "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b."
				+ tableColumn;
		fileName = getUName();
		File file = get(fileName);
		WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
		String title = "机构代码-sheet"; // 标题
		CachedRowSet cs = dataObject.query(sql);
		int k = 0;
		int x = 0;
		int j = 0;
		Map<String, Integer> xzqhs = new HashMap<String, Integer>();
		Map<String, Integer> jglxs = new HashMap<String, Integer>();
		WritableCellFormat wcfFC = getCellFormat();
		WritableSheet sheet = book.createSheet(title, (short) 0);

		while (cs.next()) {
			String xzqh = cs.getString("xzqh").trim();
			String jglx = cs.getString(tableColumn).trim();
			Integer tempx = xzqhs.get(xzqh);
			Integer tempj = jglxs.get(jglx);
			if (tempx == null) {
				x += 1;
				tempx = x;
				xzqhs.put(xzqh, x);
				sheet.addCell(new Label(0, tempx, InitSysParams.bzjgdmMap
						.get(xzqh), wcfFC));
			}
			if (tempj == null) {
				j += 1;
				tempj = j;
				jglxs.put(jglx, j);
				if ("jjhy".equals(tableColumn)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap
							.get(jglx), wcfFC));
				}
				if ("jglx".equals(tableColumn)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap
							.get(jglx), wcfFC));
				}
				if ("jjlx".equals(tableColumn)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap
							.get(jglx), wcfFC));
				}

			}
			sheet.addCell(new Label(tempj, tempx, String.valueOf(cs
					.getInt("num"))));
		}
		book.write();
		book.close();
		cs.close();
	}

	private void export_RowSet(CachedRowSet cs, String column_x,
			String column_y, String... rate) throws Exception {
		fileName = getUName();
		File file = get(fileName);
		WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
		String title = "机构代码-sheet"; // 标题
		int k = 0;
		int x = 0;
		int j = 0;
		Map<String, Integer> xzqhs = new HashMap<String, Integer>();
		Map<String, Integer> jglxs = new HashMap<String, Integer>();
		WritableCellFormat wcfFC = getCellFormat();
		WritableSheet sheet = book.createSheet(title, (short) 0);
		while (cs.next()) {
			String xzqh = cs.getString(column_x).trim();
			String jglx = cs.getString(column_y).trim();
			Integer tempx = xzqhs.get(xzqh);
			Integer tempj = jglxs.get(jglx);
			if (tempx == null) {
				x += 1;
				tempx = x;
				sheet.addCell(new Label(0, tempx, InitSysParams.bzjgdmMap
						.get(xzqh), wcfFC));
				xzqhs.put(xzqh, x);
			}
			if (tempj == null) {
				j += 1;
				tempj = j;
				jglxs.put(jglx, j);
				if ("jjhy".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap
							.get(jglx), wcfFC));
				} else if ("jglx".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap
							.get(jglx), wcfFC));
				} else if ("jjlx".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap
							.get(jglx), wcfFC));
				} else if (type != null && type && "fl".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.njjhyBigMap
							.get(jglx), wcfFC));
				} else if ("type".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.optTypeMap
							.get(jglx), wcfFC));
				} else {
					sheet.addCell(new Label(tempj, 0, jglx, wcfFC));
				}

			}
			if (rate != null && rate.length >= 1) {
				Double data = cs.getDouble(rate[0]);

				sheet.addCell(new Label(tempj, tempx, data == 0 ? "0.0"
						: (String.valueOf(data) + "%")));
			} else {
				sheet.addCell(new Label(tempj, tempx, String.valueOf(cs
						.getInt("num"))));
			}

		}
		cs.close();
		book.write();
		book.close();

	}

	private String getUName() {
		return UUID.randomUUID().toString() + ".xls";
	}

	private File get(String fileName) throws IOException {
		String tempPath = UserPropertiesData.getValueByPropertyName("tempPath");
		File file = new File(tempPath);
		if (!file.exists())
			file.mkdir();

		file = new File(tempPath + "/" + fileName);
		if (!file.exists())
			file.createNewFile();
		return file;
	}

	private WritableCellFormat getCellFormat() throws WriteException {
		WritableFont font = new WritableFont(WritableFont.ARIAL, 16,
				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.BLACK);
		WritableCellFormat wcfFC = new WritableCellFormat(font);
		wcfFC.setBackground(Colour.AQUA);
		return wcfFC;
	}

	private void export_Map(Map<String, List<Model>> modelMaps)
			throws Exception {
		fileName = getUName();
		File file = get(fileName);
		WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
		String title = "机构代码-sheet"; // 标题
		int k = 0;
		int j = 0;
		Map<String, Integer> xzqhs = new HashMap<String, Integer>();
		WritableCellFormat wcfFC = getCellFormat();
		WritableSheet sheet = book.createSheet(title, (short) 0);
		for (Map.Entry<String, List<Model>> entry : modelMaps.entrySet()) {
			if ("t_jgdm".equals(entry.getKey())) {
				sheet.addCell(new Label(1, 0, "主库", wcfFC));
				k = 1;
			}
			if ("t_fzdm".equals(entry.getKey())) {
				sheet.addCell(new Label(2, 0, "注销库", wcfFC));
				k = 2;

			}
			if ("t_ljdm".equals(entry.getKey())) {
				sheet.addCell(new Label(3, 0, "无效库", wcfFC));
				k = 3;

			}
			for (Model model : entry.getValue()) {
				Integer xzqh = xzqhs.get(model.getColumn1());
				if (xzqh == null) {
					j += 1;
					xzqh = j;
					xzqhs.put(model.getColumn1(), j);
					sheet.addCell(new Label(0, xzqh, InitSysParams.xzqhMap
							.get(model.getColumn1()), wcfFC));
				}
				sheet.addCell(new Label(k, xzqh, String.valueOf(model
						.getCount1())));
			}
		}
		book.write();
		book.close();

	}

	private void export_date(CachedRowSet cs, String column_y, String name)
			throws Exception {
		fileName = getUName();
		File file = get(fileName);
		WritableWorkbook book = Workbook.createWorkbook(file); // 建立excel文件
		String title = "机构代码-sheet"; // 标题
		int j = 0;
		Map<String, Integer> jglxs = new HashMap<String, Integer>();
		WritableCellFormat wcfFC = getCellFormat();
		WritableSheet sheet = book.createSheet(title, (short) 0);
		sheet.addCell(new Label(0, 1, name));
		while (cs.next()) {
			String jglx = cs.getString(column_y).trim();
			Integer tempj = jglxs.get(jglx);
			if (tempj == null) {
				j += 1;
				tempj = j;
				if ("jjhy".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jjhyMap
							.get(jglx), wcfFC));
				} else if ("jglx".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jglxMap
							.get(jglx), wcfFC));
				} else if ("jjlx".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.jjlxMap
							.get(jglx), wcfFC));
				} else if (type != null && type && "fl".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.njjhyBigMap
							.get(jglx), wcfFC));
				} else if ("type".equals(column_y)) {
					sheet.addCell(new Label(tempj, 0, InitSysParams.optTypeMap
							.get(jglx), wcfFC));
				} else {
					sheet.addCell(new Label(tempj, 0, jglx, wcfFC));
				}
			}
			sheet.addCell(new Label(tempj, 1, String.valueOf(cs.getInt("num"))));
		}
		cs.close();
		book.write();
		book.close();

	}

	private void excuteBy(String tableColumn, String value) throws SQLException {
		User user = (User) session.get("sysUser");
		if (jgdm == null) {
			jgdm = new TJgdm();
			// jgdm.setXzqh(user.getBzjgdm());
		} else {
			if ("*".equals(jgdm.getXzqh())) {
				jgdm.setXzqh(null);
			}
			if ("*".equals(value)) {
				value = null;
			}
		}

		fenJi();
		models = new ArrayList<Model>();
		if (year == null || year == 0) {
			year = Calendar.getInstance().get(Calendar.YEAR);
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			day = Calendar.getInstance().get(Calendar.MONTH);
		}
		DataAccess dataObject = new DataAccess();
		String sql = "select b.xzqh,b."
				+ tableColumn
				+ ",count(jgdm) as num from "
				+ "(select bzjgdm,"
				+ tableColumn
				+ ",jgdm from t_jgdm where datediff(month,lastdate,'"
				+ year
				+ "-"
				+ month
				+ "-1')=0) c "
				+ "right join (select bzjg_id as xzqh,bzjg_id,sjbzjg_id , w.dm as "
				+ tableColumn
				+ " from sc_bzjgdm ,"
				+ ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'"
						: "sc_" + tableColumn.replace("jjlx2011", "lx"))
				+ " w "
				+ ("jjlx2011".equals(tableColumn) ? (" where   jglx='"
						+ (value == null ? "1" : value) + "' ") : "")
				+ " ) b on c.bzjgdm = b.xzqh and c." + tableColumn + " = b."
				+ tableColumn + " where 1=1 " + xzqhSql()
				+
				// (jgdm.getXzqh() != null ? (" and c.bzjgdm like '" +
				// jgdm.getXzqh() + "%' ") : "") + (value == null ? "" :
				// (" and c." + tableColumn + "='" + value + "' ")) +
				"group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b."
				+ tableColumn;
		CachedRowSet cs = dataObject.query(sql);
		while (cs.next()) {
			Model model = new Model();
			model.setColumn1(cs.getString("xzqh"));
			model.setColumn2(cs.getString(tableColumn));
			model.setCount1(cs.getInt("num"));
			models.add(model);
		}
		cs.close();

	}

	public String xzqhSql() throws SQLException {
		// lvwei 2017-09-27 修改统计权限
		User user = (User) session.get("sysUser");
		String meSql = "";
		DataAccess dataObject = new DataAccess();
		if ("100000".equals(user.getBzjgdm())) {// 判断是否为管理员账号
			return "";
		}
		String sql = "  select bzjg_id,bzjg_name,type,sjbzjg_id from sc_bzjgdm where bzjg_id='"
				+ user.getBzjgdm() + "'  ";
		CachedRowSet cs = dataObject.query(sql);
		Model model = new Model();
		while (cs.next()) {
			if ("0".equals(cs.getString("type"))) {// 省级
				meSql = " and  b.sjbzjg_id like'"
						+ cs.getString("bzjg_id").substring(0, 2) + "%' ";
			} else if ("1".equals(cs.getString("type"))) {// 市级
				meSql = " and  b.sjbzjg_id='" + cs.getString("sjbzjg_id")
						+ "' ";
			} else if ("2".equals(cs.getString("type"))) {// 县级
				meSql = "and  b.bzjg_id='" + cs.getString("bzjg_id") + "' ";
			}
		}
		cs.close();
		if (jgdm != null && jgdm.getJglx() != null) {
			// meSql=meSql+" and c.jglx='"+jgdm.getJglx()+"'";
		}
		return meSql;
	}

	public String getJglx(String parm) {
		if (jgdm != null && jgdm.getJglx() != null
				&& !"*".equals(jgdm.getJglx())) {
			return " " + parm + "jglx='" + jgdm.getJglx() + "'";
			// meSql=meSql+" and c.jglx='"+jgdm.getJglx()+"'";
		} else {
			return "";
		}
	}

	public String getTydmJglx() {
		if (jgdm != null && jgdm.getJglx() != null
				&& !"*".equals(jgdm.getJglx())) {
			return " " + "substring(tyshxydm,2,1)='" + jgdm.getJglx() + "'"
					+ " and ";
			// meSql=meSql+" and c.jglx='"+jgdm.getJglx()+"'";
		} else {
			return "";
		}
	}

	private void excuteForJson(String tableColumn, String value)
			throws SQLException {
		User user = (User) session.get("sysUser");
		if (jgdm == null) {
			jgdm = new TJgdm();
			jgdm.setXzqh(user.getBzjgdm());
		} else {
			if ("*".equals(jgdm.getXzqh())) {
				jgdm.setXzqh(null);
			}

			if ("*".equals(value)) {
				value = (null);
			}
		}
		models = new ArrayList<Model>();
		if (year == null || year == 0) {
			year = Calendar.getInstance().get(Calendar.YEAR);
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			day = Calendar.getInstance().get(Calendar.MONTH);
		}
		DataAccess dataObject = new DataAccess();
		String sql = "select b.xzqh,b."
				+ tableColumn
				+ ",count(jgdm) as num from "
				+ "(select bzjgdm,"
				+ tableColumn
				+ ",jgdm from t_jgdm where datediff(month,lastdate,'"
				+ year
				+ "-"
				+ month
				+ "-1')=0) c "
				+ "right join (select bzjg_id as xzqh,dm as "
				+ tableColumn
				+ " from sc_bzjgdm,"
				+ ("jjhy".equals(tableColumn) ? "t_jjhy where dm like'A01%'"
						: "t_" + tableColumn)
				+ ") b on c.bzjgdm = b.xzqh and c."
				+ tableColumn
				+ " = b."
				+ tableColumn
				+ " where 1=1 "
				+ (jgdm.getXzqh() != null ? (" and c.bzjgdm='" + jgdm.getXzqh() + "' ")
						: "")
				+ (value == null ? ""
						: (" and c." + tableColumn + "='" + value + "' "))
				+ "group by b.xzqh,b." + tableColumn + " order by  b.xzqh, b."
				+ tableColumn;
		CachedRowSet cs = dataObject.query(sql);
		StringBuilder Bjson = new StringBuilder("[");
		Map<String, String> jglxMap = InitSysParams.jglxMap;
		while (cs.next()) {
			String jglx = cs.getString(tableColumn).trim();
			Model model = new Model();
			model.setColumn1(cs.getString("xzqh"));
			model.setColumn2(jglx);
			model.setCount1(cs.getInt("num"));
			models.add(model);
			Bjson.append("{name:'" + jglx + "',value:'" + cs.getInt("num")
					+ "',chinese:'" + jglxMap.get(jglx).trim() + "'},");
		}
		json = Bjson.replace(Bjson.lastIndexOf(","), Bjson.length(), "]")
				.toString();
		cs.close();

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<TJgdm> getJgdms() {
		return jgdms;
	}

	public void setJgdms(List<TJgdm> jgdms) {
		this.jgdms = jgdms;
	}

	private String getMC() {
		String mc = "%";
		String[] mcs = jgdm.getJgmc().split("\\s+");

		for (String m : mcs) {
			mc += (m + "%");
		}
		return mc;
	}

	public List<Ttable> getTtables() {
		return ttables;
	}

	public void setTtables(List<Ttable> ttables) {
		this.ttables = ttables;
	}

	public String getSqlwhere() {
		return sqlwhere;
	}

	public void setSqlwhere(String sqlwhere) {
		this.sqlwhere = sqlwhere;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<Model> getModels() {
		return models;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Map<String, List<Model>> getModelMaps() {
		return modelMaps;
	}

	public void setModelMaps(Map<String, List<Model>> modelMaps) {
		this.modelMaps = modelMaps;
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

	public String getDatabase() {
		return database;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Map> getMapMap() {
		return mapMap;
	}

	public void setMapMap(Map<String, Map> mapMap) {
		this.mapMap = mapMap;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getJson() {

		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getZsbh() {
		return zsbh;
	}

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	public List<TBgk> getBgks() {
		return bgks;
	}

	public void setBgks(List<TBgk> bgks) {
		this.bgks = bgks;
	}

	public TBgk getBgk() {
		return bgk;
	}

	public void setBgk(TBgk bgk) {
		this.bgk = bgk;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getDmStatus() {
		return dmStatus;
	}

	public void setDmStatus(String dmStatus) {
		this.dmStatus = dmStatus;
	}

	public TBgk getBgk2() {
		return bgk2;
	}

	public void setBgk2(TBgk bgk2) {
		this.bgk2 = bgk2;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public TJgdm getJgdm2() {
		return jgdm2;
	}

	public void setJgdm2(TJgdm jgdm2) {
		this.jgdm2 = jgdm2;
	}

	public Map<String, String> getBzjgdmMap() {
		return bzjgdmMap;
	}

	public void setBzjgdmMap(Map<String, String> bzjgdmMap) {
		this.bzjgdmMap = bzjgdmMap;
	}

	public List<TFzr> getListFzr() {
		return listFzr;
	}

	public void setListFzr(List<TFzr> listFzr) {
		this.listFzr = listFzr;
	}

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public TFddbr getFddbr() {
		return fddbr;
	}

	public void setFddbr(TFddbr fddbr) {
		this.fddbr = fddbr;
	}

	public TFrjl getFrjl() {
		return frjl;
	}

	public void setFrjl(TFrjl frjl) {
		this.frjl = frjl;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getTydm() {
		return tydm;
	}

	public void setTydm(String tydm) {
		this.tydm = tydm;
	}

}