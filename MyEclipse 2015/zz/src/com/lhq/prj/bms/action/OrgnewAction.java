package com.lhq.prj.bms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.CreateKey;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.core.UUID;
import com.lhq.prj.bms.core.WriteImageData;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IOrgnewService;
import com.lhq.prj.bms.service.ITjgdmService;


/**
 * OrgnewAction.java Create on 2012-5-5
 * 机构管理
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
**/

@SuppressWarnings("serial")
public class OrgnewAction extends BaseAction {
	private IOrgnewService orgnewService;
	private ITjgdmService tjgdmService;
	private Map<String, Object> dataMap;
	private IZuserDao zuserDao;
	private Zuser zuser;
	private ITjgdmDao tjgdmDao;
	private Orgnew orgnew;
	private boolean success;
	private Page page;
	private Integer orgid;
	private File upload;// 上传的文件
	private String uploadContentType;// 上传问文件类型
	private String uploadFileName; // 上传文件名
	private String allowedTypes;// 允许上传的文件类型列表
	private String savePath;// 文件保存路径,通过ioc注入
	private float maxHeightSize;// 缩略图最大高度
	private float maxWidthSize;//缩略图最大宽度
	
	private String orderid;
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String jglxdm;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jjlxdm;
	private String jyfw;
	private String jjlx;

	private String jjlxOld;
	private String jjlxdmOld;
	private String jjhymcOld;
	private String jjhydmOld;
	private String jglxOld;
	private String jglxdmOld;
	
	private Date zcrq;
	private String zgdm;
	private String pzjgdm;
	private String xzqhCode;
	private String xzqhName;
	private String xzqhCode2;
	private String xzqhName2;
	private String jgdz;
	private String jgzcdz;
	private String yzbm;
	private String dhhm;
	private Date scbzrq;
	private Date bzrq;
	private Date zfrq;
	private String bzjgdm;
	private String zycp1;
	private String zycp2;
	private String zycp3;
	private BigDecimal zczj;
	private String wftzgb;
	private String wftzgbdm;
	private String hbzl;
	private String hbzldm;
	private Integer zgrs;
	private Integer fbsl;
	private String zslsh;
	private String bgbj;
	private Date bgrq;
	private String lry;
	private Date njrq;
	private String njr;
	private Date njqx;
	private String xgr;
	private Integer zbsl;
	private String zch;
	private String qzbz;
	private Date qzrq;
	private String zgmc;
	private String pzjgmc;
	private String gslsh;
	private String gstbr;
	private String wjwlsh;
	private String pzwh;
	private Date pwrq;
	private String wjwtbr;
	private String gk;
	private String fkbz;
	private Integer fksl;
	private String isxw;////
	private String dybz;
	private String email;
	private String weburl;
	private String mobile;
	private String djblx;
	private Date lastdate;
	private String czflag;
	private String yjflag;
	private String sjzt;
	private String jyjg;
	private Integer fz;
	private String njjhy;
	private String memo;
	private String njjlx;
	private String memo2;
	private String memo3;
	private String memo4;
	private String tbrxm;
	private String tbrzjlx;
	private String tbrsfzh;
	private String isca;
	private String tbrlxfs;
	private Date gsfzrq;
	private String jydz;
	private String jyyb;
	private String jydh;
	private String jfly;
	private String khyh;
	private String khzh;
	private Date zsbfrq;
	private Date zszfrq;
	private String jjhymc;
	private String jjhydm;
	
	private String moveoutAddrss;
	private String moveoutReason;
	private String moveoutNote;
	private String offPzjgmc;
	private String offPzwh;
	private String offReason;
	private String offNote;
	
	private String qyzclx;
	private String ywlx;
	private Integer userid;
	private String imageUrl;
	private String username;
	private String state;
	private String newState;
	private String newYwlx;
	private String docid;
	private String strNjqx;
	
	public OrgnewAction() {
		//初始化Map对象
		dataMap = new HashMap<String, Object>();
	}
	/**
	* 添加
	* @return
	 * @throws Exception 
	*/
	public String saveOrgnew() throws Exception {
		
		String strOrderid = getRequest().getParameter("orderid");
		String newState = getRequest().getParameter("newState");
		String sorgid = getRequest().getParameter("orgid");
		String strNjqx = getRequest().getParameter("strNjqx");
		System.out.println(newState+":::::::::::::::::::::"+strNjqx);
		Orgnew orgnew = new Orgnew();
		
		docid=UUID.randomUUID().toString().toUpperCase();
		orgnew.setCenterid("420100");
		orgnew.setDocid(docid);
		orgnew.setOrgid(orgid);
		orgnew.setOrderid(strOrderid);
		orgnew.setJgdm(jgdm);
		orgnew.setJgmc(jgmc);
		orgnew.setJglx(jglx);
		orgnew.setJglxdm(jglxdm);
		orgnew.setZjlx(zjlx);
		orgnew.setZjhm(zjhm);
		orgnew.setFddbr(fddbr);
		orgnew.setJjlxdm(jjlxdm);
		orgnew.setJyfw(jyfw);
		orgnew.setJjlx(jjlx);
		orgnew.setZcrq(zcrq);
		orgnew.setZgdm(zgdm);
		orgnew.setPzjgdm(pzjgdm);
		orgnew.setJjhydm(jjhydm);
		orgnew.setJjhymc(jjhymc);
		orgnew.setXzqhCode(xzqhCode);
		orgnew.setXzqhName(xzqhName);
		orgnew.setBzjgdm(bzjgdm);
		orgnew.setXzqhCode2(xzqhCode2);
		orgnew.setXzqhName2(xzqhName2);

		orgnew.setJglxOld(jglxOld);
		orgnew.setJglxdmOld(jglxdmOld);
		orgnew.setJjlxOld(jjlxOld);
		orgnew.setJjlxdmOld(jjlxdmOld);
		orgnew.setJjhymcOld(jjhymcOld);
		orgnew.setJjhydmOld(jjhydmOld);
		
		orgnew.setJgdz(jgdz);
		orgnew.setYzbm(yzbm);
		orgnew.setDhhm(dhhm);
		
		orgnew.setZycp1(zycp1);
		orgnew.setZycp2(zycp2);
		orgnew.setZycp3(zycp3);
		orgnew.setZczj(zczj);
		
		orgnew.setWftzgb(wftzgb);
		orgnew.setWftzgbdm(wftzgbdm);
		
		orgnew.setHbzl(hbzl);
		orgnew.setHbzldm(hbzldm);
		
		orgnew.setZgrs(zgrs);
		orgnew.setFbsl(fbsl);
		orgnew.setZslsh(zslsh);
		orgnew.setBgbj(bgbj);
		orgnew.setBgrq(bgrq);
		orgnew.setLry(lry);
		
		orgnew.setNjr(njr);
		
		orgnew.setXgr(xgr);
		orgnew.setZbsl(zbsl);
		orgnew.setZch(zch);
		orgnew.setQzbz(qzbz);
		orgnew.setQzrq(qzrq);
		orgnew.setZgmc(zgmc);
		orgnew.setPzjgmc(pzjgmc);
		orgnew.setPzjgdm(pzjgdm);
		orgnew.setGslsh(gslsh);
		orgnew.setGstbr(gstbr);
		orgnew.setWjwlsh(wjwlsh);
		orgnew.setPzwh(pzwh);
		orgnew.setPwrq(pwrq);
		orgnew.setWjwtbr(wjwtbr);
		
		
		orgnew.setDybz(dybz);
		orgnew.setEmail(email);
		orgnew.setWeburl(weburl);
		orgnew.setMobile(mobile);
		orgnew.setDjblx(djblx);
		orgnew.setLastdate(lastdate);
		
		orgnew.setCzflag(czflag);
		orgnew.setYjflag(yjflag);
		orgnew.setSjzt(sjzt);
		orgnew.setJyjg(jyjg);
		orgnew.setFz(fz);
		orgnew.setNjjhy(njjhy);
		orgnew.setMemo(memo);
		orgnew.setNjjlx(njjlx);
		orgnew.setMemo2(memo2);
		orgnew.setMemo3(memo3);
		orgnew.setMemo4(memo4);
		orgnew.setTbrxm(tbrxm);
		orgnew.setTbrzjlx(tbrzjlx);
		orgnew.setTbrsfzh(tbrsfzh);
		orgnew.setIsca(isca);
		orgnew.setTbrlxfs(tbrlxfs);
		orgnew.setGsfzrq(gsfzrq);
		orgnew.setJydz(jydz);
		orgnew.setJyyb(jyyb);
		orgnew.setJydh(jydh);
		orgnew.setJfly(jfly);
		orgnew.setKhyh(khyh);
		orgnew.setKhzh(khzh);
		orgnew.setZsbfrq(zsbfrq);
		orgnew.setZszfrq(zszfrq);

		orgnew.setMoveoutAddrss(moveoutAddrss);
		orgnew.setMoveoutReason(moveoutReason);
		orgnew.setOffPzjgmc(offPzjgmc);
		orgnew.setOffPzwh(offPzwh);
		orgnew.setOffReason(offReason);
		orgnew.setOffNote(offNote);
		
		orgnew.setQyzclx(qyzclx);
		orgnew.setUserid(userid);
		//System.out.println("suername::::::::::"+username);
		orgnew.setUsername(username);
		
		
		/////////////////////////////////////////////////////////////////////
		String strYwlx=null;
		String strFddbr=orgnew.getFddbr();
		String strJglx=orgnew.getJglxdmOld();
		String strJgdz=orgnew.getJgdz();
		strJgdz = MyUtils.ToSBC(strJgdz);
		String strPzjgmc=orgnew.getPzjgmc();
		String strPzjgdm=orgnew.getPzjgdm();
		Date dateZfrq=new Date();
		
		if(jgdm!=null&&!jgdm.equals("")){
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setJgdm(jgdm);
			Tjgdm tjgdm3 = new Tjgdm();
			tjgdm3=(Tjgdm) tjgdmDao.findByJgdm(tjgdm);//tjgdmDao.findTjgdmByJgdm(jgdm).get(0);
			if(tjgdm3!=null){
				if(tjgdm3.getPzjgdm()==null || tjgdm3.getPzjgdm().trim().equals("")){
					
					if(strPzjgmc==tjgdm3.getPzjgmc() || strPzjgmc.equals(tjgdm3.getPzjgmc())){
						//打印相差天数
						boolean f = tjgdm3.getZfrq().before(dateZfrq);
						
						if(!f){
							if(MyUtils.daysBetween(dateZfrq,tjgdm3.getZfrq())<30 ){
								strYwlx="换证";
							}else{
								if(!strFddbr.equals(tjgdm3.getFddbr())||!strJglx.equals(tjgdm3.getJglxdmOld())||!strJgdz.equals(MyUtils.ToSBC(tjgdm3.getJgdz()))){
									strYwlx="变更";
								}else{
									strYwlx="年检";
								}
							}
						}else{
							strYwlx="换证";
							System.out.println("到期换证");
						}
					}else{
						strYwlx="迁入";
					}
				}else{
					if(strPzjgdm==tjgdm3.getPzjgdm() || strPzjgdm.equals(tjgdm3.getPzjgdm())){
						//打印相差天数
						boolean f = tjgdm3.getZfrq().before(dateZfrq);
						if(!f){
							System.out.println("还没到期");
							System.out.println(MyUtils.daysBetween(dateZfrq,tjgdm3.getZfrq()));
							if(MyUtils.daysBetween(dateZfrq,tjgdm3.getZfrq())<30 ){
								strYwlx="换证";
							}else{
								if(!strFddbr.equals(tjgdm3.getFddbr())||!strJglx.equals(tjgdm3.getJglxdmOld())||!strJgdz.equals(MyUtils.ToSBC(tjgdm3.getJgdz()))){
									strYwlx="变更";
								}else{
									strYwlx="年检";
								}
							}
						}else{
							strYwlx="换证";
							System.out.println("到期换证");
						}
					}else{
						strYwlx="迁入";
					}
				}
				
			}else{
				strYwlx="迁入";
			}
		}else{
			strYwlx="新办";
		}
		
		/**
		* 根据业务类型为 zfrq bzrq njqx njrq赋值
		* */
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)+1; 
		int month = cal.get(Calendar.MONTH)+1; 
		int date = cal.get(Calendar.DATE); 
		System.out.println("跟踪代码：：：：：："+year+"/"+month+"/"+date); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//当前时间字符串
		String str = sdf.format(dateZfrq);
		njrq = sdf.parse(str);
		bzrq = sdf.parse(str);
		zfrq = sdf.parse((year+3)+"-"+month+"-"+date);
		njqx = sdf.parse(year+"-"+"05-31");
		/*if(strYwlx.equals("迁入")||strYwlx.equals("换证")||strYwlx.equals("变更")){
			bzrq = sdf.parse(str);
			zfrq = sdf.parse((year+3)+"-"+month+"-"+date);
		}*/
		if(strYwlx.equals("新办")){
			scbzrq = sdf.parse(str);
		}
		orgnew.setScbzrq(scbzrq);
		orgnew.setBzrq(bzrq);
		orgnew.setZfrq(zfrq);
		orgnew.setNjrq(njrq);
		orgnew.setNjqx(njqx);
		
		orgnew.setState(newState);
		orgnew.setYwlx(strYwlx);
		orgnew.setLastdate(njrq);
		orgnew.setLrDate(njrq);
		////////////////////////////////////////////////////////////////////////
		
		if(sorgid != null && sorgid!="" && !"".equals(sorgid) ){
			//如果不是新录入的，则更新
			docid=getRequest().getParameter("docid");
			orgnew.setDocid(docid);
			orgnewService.updateOrgnew(orgnew);	
			orgid=Integer.parseInt(sorgid);
		}else{
			docid=UUID.randomUUID().toString().toUpperCase();
			orgnew.setDocid(docid);
			//否则插入一条数据，保存
			
			orgid = (Integer) orgnewService.saveOrgnew(orgnew);		
		}
		getRequest().setAttribute("currentOrgid", orgid);
		getRequest().setAttribute("currentDocid", docid);
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",docid:'"+docid+"',success:true,imageUrl:'" + orgnew.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
		
	}
	

	/**
	* 查找新办用户所属机构
	* @return
	*/
	public String findUsernameOrgnew() {
		
		String username = getRequest().getParameter("username");
		String strStateCondition = getRequest().getParameter("stateConditions");
		
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setUsername(username);
		page.setStateConditions(stateConditions);
		page.setRoot(orgnewService.findUsernameOrgnew(page));
		return SUCCESS;
	}
	
	public String findJgdmOrgnew() {
		
		String strCondition = getRequest().getParameter("jgdm");
		String strStateCondition = getRequest().getParameter("stateConditions");
		
		List stateConditions = new ArrayList();
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		page.setStateConditions(stateConditions);
		page.setRoot(orgnewService.findJgdmOrgnew(page));
		return SUCCESS;
	}
	public String findConditionsOrgnew(){
		
		List conditions = new ArrayList();
		List ls = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(jgdm, " ,"));
		
		page = new Page();
		page.setConditions(conditions);
		ls = orgnewService.findConditionsOrgnew(page);
		
		page.setRoot(ls);
		return SUCCESS;
	}
	public String findConditionsTjgdm(){
		List ls = new ArrayList();
		Tjgdm tjgdm = new Tjgdm();
		tjgdm.setJgdm(jgdm);
		ls = tjgdmDao.findConditionsTjgdm(tjgdm);
		
		page = new Page();
		page.setRoot(ls);
		return SUCCESS;
	}
	
	/**
	* 加载ORGID所属机构
	* @return
	*/
	public String findOrgidOrgnew() {
		
		Integer orgid = Integer.valueOf(getRequest().getParameter("orgid"));		
		page = new Page();
		page.setRoot(orgnewService.findOrgidOrgnew(orgid));
		return SUCCESS;
	}
	
	
	/**
	* 查找全部机构
	* @return
	*/
	public String findAllOrgnew() {
		//int categoryid = Integer.valueOf(getRequest().getParameter("categoryid"));
		//String username = getRequest().getParameter("username");
		//int userid = Integer.valueOf(getRequest().getParameter("userid"));
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		page.setStateConditions(stateConditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgnewService.findByPage(page);
		return SUCCESS;
	}
	

	/**
	 * 删除图书
	 * 
	 * @return
	 */
	public String deleteOrgnew() {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			success = orgnewService.deleteOrgnew(getSession().getServletContext().getRealPath("/"), Integer.valueOf(strOrgid));
		}
		return SUCCESS;
	}
	
	/**
	 * 修改信息
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateOrgnew() throws Exception{
		
		String strOrderid = getRequest().getParameter("orderid");
		String newState = String.valueOf(getRequest().getParameter("newState"));
		String newYwlx = String.valueOf(getRequest().getParameter("newYwlx"));
		
		
		Orgnew orgnew = new Orgnew();
		
		orgnew.setOrgid(orgid);
		orgnew.setOrderid(strOrderid);
		orgnew.setJgdm(jgdm);
		orgnew.setJgmc(jgmc);
		orgnew.setJglx(jglx);
		orgnew.setZjlx(zjlx);
		orgnew.setZjhm(zjhm);
		orgnew.setFddbr(fddbr);
		orgnew.setJjlxdm(jjlxdm);
		orgnew.setJyfw(jyfw);
		orgnew.setJjlx(jjlx);
		orgnew.setZcrq(zcrq);
		orgnew.setZgdm(zgdm);
		orgnew.setPzjgdm(pzjgdm);
		
		orgnew.setXzqhCode(xzqhCode);
		orgnew.setXzqhName(xzqhName);
		
		///////////
		orgnew.setXzqhCode2(xzqhCode2);
		orgnew.setXzqhName2(xzqhName2);
		
		orgnew.setJgdz(jgdz);
		orgnew.setYzbm(yzbm);
		orgnew.setDhhm(dhhm);
		orgnew.setScbzrq(scbzrq);
		orgnew.setBzrq(bzrq);
		orgnew.setZfrq(zfrq);
		orgnew.setBzjgdm(bzjgdm);
		orgnew.setZycp1(zycp1);
		orgnew.setZycp2(zycp2);
		orgnew.setZycp3(zycp3);
		orgnew.setZczj(zczj);
		
		orgnew.setWftzgb(wftzgb);
		orgnew.setWftzgbdm(wftzgbdm);
		orgnew.setHbzl(hbzl);
		orgnew.setHbzldm(hbzldm);
		
		orgnew.setZgrs(zgrs);
		orgnew.setFbsl(fbsl);
		orgnew.setZslsh(zslsh);
		orgnew.setBgbj(bgbj);
		orgnew.setBgrq(bgrq);
		orgnew.setLry(lry);
		orgnew.setNjrq(njrq);
		orgnew.setNjr(njr);
		orgnew.setNjqx(njqx);
		orgnew.setXgr(xgr);
		orgnew.setZbsl(zbsl);
		orgnew.setZch(zch);
		orgnew.setQzbz(qzbz);
		orgnew.setQzrq(qzrq);
		orgnew.setZgmc(zgmc);
		orgnew.setPzjgmc(pzjgmc);
		orgnew.setPzjgdm(pzjgdm);
		orgnew.setGslsh(gslsh);
		orgnew.setGstbr(gstbr);
		orgnew.setWjwlsh(wjwlsh);
		orgnew.setPzwh(pzwh);
		orgnew.setPwrq(pwrq);
		orgnew.setWjwtbr(wjwtbr);
		orgnew.setGk(gk);
		orgnew.setFkbz(fkbz);
		
		orgnew.setFksl(fksl);
		orgnew.setDybz(dybz);
		orgnew.setEmail(email);
		orgnew.setWeburl(weburl);
		orgnew.setMobile(mobile);
		orgnew.setDjblx(djblx);
		orgnew.setLastdate(lastdate);
		orgnew.setCzflag(czflag);
		orgnew.setYjflag(yjflag);
		orgnew.setSjzt(sjzt);
		orgnew.setJyjg(jyjg);
		orgnew.setFz(fz);
		orgnew.setNjjhy(njjhy);
		orgnew.setMemo(memo);
		orgnew.setNjjlx(njjlx);
		orgnew.setMemo2(memo2);
		orgnew.setMemo3(memo3);
		orgnew.setMemo4(memo4);
		orgnew.setTbrxm(tbrxm);orgnew.setTbrzjlx(tbrzjlx);
		orgnew.setTbrsfzh(tbrsfzh);
		orgnew.setIsca(isca);
		orgnew.setTbrlxfs(tbrlxfs);
		orgnew.setGsfzrq(gsfzrq);
		orgnew.setJydz(jydz);
		orgnew.setJyyb(jyyb);
		orgnew.setJydh(jydh);
		orgnew.setJfly(jfly);
		orgnew.setKhyh(khyh);
		orgnew.setKhzh(khzh);
		orgnew.setZsbfrq(zsbfrq);
		orgnew.setZszfrq(zszfrq);

		orgnew.setMoveoutAddrss(moveoutAddrss);
		orgnew.setMoveoutReason(moveoutReason);
		orgnew.setOffPzjgmc(offPzjgmc);
		orgnew.setOffPzwh(offPzwh);
		orgnew.setOffReason(offReason);
		orgnew.setOffNote(offNote);
		
		orgnew.setQyzclx(qyzclx);
		orgnew.setYwlx(newYwlx);
		orgnew.setUserid(userid);
		orgnew.setUsername(username);
		orgnew.setState(newState);
		
		orgnew = this.upload(orgnew);  
		/*1.如果图书本来没有图片则不用删除原来图片
		 *2.如果原来有图片并且修改后的图片不一样则删除原来图片
		 */
		if(imageUrl != null && null != orgnew.getImageUrl() && !imageUrl.equals(orgnew.getImageUrl())){
			MyUtils.delFile(getSession().getServletContext().getRealPath("/")+ imageUrl);
		}
		if(upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) && orgnewService.updateOrgnew(orgnew) ){
			this.jsonString = "{success:true,imageUrl:'" + orgnew.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}else if(upload == null && orgnewService.updateOrgnew(orgnew)){
			this.jsonString = "{success:true,imageUrl:'" + imageUrl + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	
	
	
	private Orgnew upload(Orgnew orgnew){  //上传文件到指定文件夹中
		String _imageUrl = null;
		if (upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(","))) {
			String rootPath = getSession().getServletContext().getRealPath("/");
			String savePath = rootPath + getSavePath();
			MyUtils.mkDirectory(savePath); //建立文件夹
			String newFileName = MyUtils.upload(getUploadFileName(), savePath, getUpload());
			_imageUrl = getSavePath() + newFileName;
			try {
				MyUtils.createMiniPic(new File(savePath + newFileName), maxWidthSize,maxHeightSize);
			} catch (IOException e) {
				e.printStackTrace();
			}
			orgnew.setImageUrl(_imageUrl);
		}
		return orgnew;
	}
	
	/*替换字符串中的字符*/
	public static String str_replace(String strSource, String strFrom, String strTo) {    
	     if (strSource == null) {        
	       return null;    
	     }  
	     int i = 0;
	     if ((i = strSource.indexOf(strFrom, i)) >= 0) {
	       char[] cSrc = strSource.toCharArray();
	       char[] cTo = strTo.toCharArray();
	       int len = strFrom.length();  
	       StringBuffer buf = new StringBuffer(cSrc.length);  
	       buf.append(cSrc, 0, i).append(cTo);
	       i += len;    
	       int j = i;       
	       while ((i = strSource.indexOf(strFrom, i)) > 0) {  
	         buf.append(cSrc, j, i - j).append(cTo);   
	         i += len;  
	         j = i;        
	       }        
	       buf.append(cSrc, j, cSrc.length - j); 
	       return buf.toString(); 
	     } 
	     return strSource;
	   }

	
	/**
	 * 上传扫描数据到文件服务器efile目录下
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveImageOrgnew() throws Exception{

	  	String strOrgid = "";
	  	String strDocid = "";
		String savePath = "";  //根目录
		String saveFileName = ""; //文件名
		StringBuffer strBuffer = null;
		String strBzjgdm="";
		String imageUrl;


		if ((getRequest().getParameter("orgid")!=null)&& (!getRequest().getParameter("orgid").equals(""))){
	  		strOrgid=getRequest().getParameter("orgid");  
	  		strDocid=getRequest().getParameter("docid");  
	  		strBzjgdm=getRequest().getParameter("bzjgdm");
	  	}
		
		Calendar  now  =  Calendar.getInstance();  
		String  year  =  String.valueOf(now.get(Calendar.YEAR));
		String strDqrq=new SimpleDateFormat("yyyyMMdd").format(now.getTime());
		
		//savePath = getSession().getServletContext().getRealPath("/")+"efile";  //上传的临时路劲
		savePath = getSavePath()+"efile";
		//savePath = savePath.replace("\\", "/");   //上传的临时路劲 saveTmpPath，如E:/zzjgdmzx/Tomcat5.0/webapps/manage/WebRoot/efile
		//savePath = savePath.replace("/zz/", "/manage/");
		String imageData=getRequest().getParameter("imageData"); //单个数据包内容
		String packindex=getRequest().getParameter("packindex");  //为数据包编码
		String pageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		String lastpack=getRequest().getParameter("lastpack");  //true为最后一个包
		
		if(lastpack=="false" || "false".equals(lastpack)){
			if(packindex=="0" || "0".equals(packindex)){
				strBuffer=new StringBuffer();
				strBuffer.append(imageData);
				getSession().setAttribute("strBuffer", strBuffer);
			}else{
				strBuffer = (StringBuffer) getSession().getAttribute("strBuffer");
				strBuffer.append(imageData);
			}
			success=true;
		}else{
			if(packindex=="0" || "0".equals(packindex)){
				strBuffer=new StringBuffer();
				strBuffer.append(imageData);
				getSession().setAttribute("strBuffer", strBuffer);
			}else{
				strBuffer = (StringBuffer) getSession().getAttribute("strBuffer");
				strBuffer.append(imageData);
			}
			
			saveFileName=strDocid+".tif";  //以DOCID作为临时文件名字 saveFileName，如74EE219F-A17D-4BDB-9FB0-F0CB87888301.tif
			imageUrl = year+"/"+strBzjgdm+"/"+strDqrq+"/"+saveFileName;
			saveFileName=savePath+"/"+imageUrl;  //临时文件的路径和文件名，如E:/zzjgdmzx/Tomcat5.0/webapps/manage/WebRoot/efile/admin.tmp
			
			
			strBuffer = (StringBuffer)getSession().getAttribute("strBuffer");
			WriteImageData.WriteImageByStream(saveFileName, strBuffer.toString());
			
			pageTypeStr=str_replace(pageTypeStr,"|","%"); 
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			orgnew.setPageTypeStr(pageTypeStr);
			orgnew.setImageUrl(saveFileName);
			success = orgnewService.saveImageOrgnew(orgnew);
		}
		return SUCCESS;
	
	}
	
	

	/**
	 * 提交申请
	 * 
	 * @return
	 * @throws Exception
	 */
	public String returnOrgnew() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			//此处处理年检时候的状态
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.returnOrgnew(orgnew);
		}
		return SUCCESS;
	}
	
	/**
	* 单个加载原文
	* @return
	*/
	
	public String orgnewViewImg() {
		
		String systemPath = "";
		String imageData="";
		String imageUrl="";
		
		Integer orgid =  Integer.valueOf(getRequest().getParameter("orgid"));
		//systemPath = getSession().getServletContext().getRealPath("/")+"efile\\";  //上传的临时路劲
		systemPath = getSavePath()+"efile\\";
		//systemPath = systemPath.replace("\\zz\\", "\\manage\\");
		Orgnew orgnew = new Orgnew();
		orgnew=(Orgnew) orgnewService.orgnewViewImg(orgid);
		//imageUrl=systemPath+orgnew.getImageUrl();
		imageUrl=orgnew.getImageUrl();
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imageUrl);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		sun.misc.BASE64Encoder encoder=new sun.misc.BASE64Encoder();
		imageData=encoder.encode(data);// 返回Base64编码过的字节数组字符串
		//System.out.println("imageData="+imageData);
		page = new Page();
		page.setImageData(imageData);
		page.setPageTypeStr(orgnew.getPageTypeStr());
		page.setSuccess(true);
		return SUCCESS;
	}	
	

	
	public void createKey(){	
		CreateKey createKey = new CreateKey();
		try {
			System.out.println(createKey.executeProcdure("z_MakePrimaryKey", "my_table"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public String checkUsernameByJgdm(){
		String strJgdm = getRequest().getParameter("jgdm");
		String strUsername = getRequest().getParameter("username");
		
		success = orgnewService.checkUsernameByJgdm(strJgdm,strUsername);
		
		return SUCCESS;
	}
	

	public Orgnew getOrgnew() {
		return orgnew;
	}

	public void setOrgnew(Orgnew orgnew) {
		this.orgnew = orgnew;
	}

	public Integer getOrgid() {
		return orgid;
	}
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public float getMaxHeightSize() {
		return maxHeightSize;
	}
	public void setMaxHeightSize(float imageMaxSize) {
		this.maxHeightSize = imageMaxSize;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setOrgnewService(IOrgnewService orgnewService) {
		this.orgnewService = orgnewService;
	}
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getAllowedTypes() {
		return allowedTypes;
	}
	public void setAllowedTypes(String allowedTypes) {
		this.allowedTypes = allowedTypes;
	}

	public float getMaxWidthSize() {
		return maxWidthSize;
	}
	public void setMaxWidthSize(float maxWidthSize) {
		this.maxWidthSize = maxWidthSize;
	}
    
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJglx() {
		return jglx;
	}
	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}
	public String getJjlxdm() {
		return jjlxdm;
	}
	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}
	public String getJjlx() {
		return jjlx;
	}
	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}
	public Date getZcrq() {
		return zcrq;
	}
	public void setZcrq(Date zcrq) {
		this.zcrq = zcrq;
	}
	public String getZgdm() {
		return zgdm;
	}
	public void setZgdm(String zgdm) {
		this.zgdm = zgdm;
	}
	public String getPzjgdm() {
		return pzjgdm;
	}
	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}
	public String getXzqhCode() {
		return xzqhCode;
	}
	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}
	public String getXzqhName() {
		return xzqhName;
	}
	public void setXzqhName(String xzqhName) {
		this.xzqhName = xzqhName;
	}
	public String getJgdz() {
		return jgdz;
	}
	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}
	public String getYzbm() {
		return yzbm;
	}
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	public String getDhhm() {
		return dhhm;
	}
	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}
	public Date getScbzrq() {
		return scbzrq;
	}
	public void setScbzrq(Date scbzrq) {
		this.scbzrq = scbzrq;
	}
	public Date getBzrq() {
		return bzrq;
	}
	public void setBzrq(Date bzrq) {
		this.bzrq = bzrq;
	}
	public Date getZfrq() {
		return zfrq;
	}
	public void setZfrq(Date zfrq) {
		this.zfrq = zfrq;
	}
	public String getBzjgdm() {
		return bzjgdm;
	}
	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}
	public String getZycp1() {
		return zycp1;
	}
	public void setZycp1(String zycp1) {
		this.zycp1 = zycp1;
	}
	public String getZycp2() {
		return zycp2;
	}
	public void setZycp2(String zycp2) {
		this.zycp2 = zycp2;
	}
	public String getZycp3() {
		return zycp3;
	}
	public void setZycp3(String zycp3) {
		this.zycp3 = zycp3;
	}
	public BigDecimal getZczj() {
		return zczj;
	}
	public void setZczj(BigDecimal zczj) {
		this.zczj = zczj;
	}
	public String getHbzl() {
		return hbzl;
	}
	public void setHbzl(String hbzl) {
		this.hbzl = hbzl;
	}

	public String getWftzgb() {
		return wftzgb;
	}
	public void setWftzgb(String wftzgb) {
		this.wftzgb = wftzgb;
	}
	public Integer getZgrs() {
		return zgrs;
	}
	public void setZgrs(Integer zgrs) {
		this.zgrs = zgrs;
	}
	public Integer getFbsl() {
		return fbsl;
	}
	public void setFbsl(Integer fbsl) {
		this.fbsl = fbsl;
	}
	public String getZslsh() {
		return zslsh;
	}
	public void setZslsh(String zslsh) {
		this.zslsh = zslsh;
	}
	public String getBgbj() {
		return bgbj;
	}
	public void setBgbj(String bgbj) {
		this.bgbj = bgbj;
	}
	public Date getBgrq() {
		return bgrq;
	}
	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}
	public String getLry() {
		return lry;
	}
	public void setLry(String lry) {
		this.lry = lry;
	}
	public Date getNjrq() {
		return njrq;
	}
	public void setNjrq(Date njrq) {
		this.njrq = njrq;
	}
	public String getNjr() {
		return njr;
	}
	public void setNjr(String njr) {
		this.njr = njr;
	}
	public Date getNjqx() {
		return njqx;
	}
	public void setNjqx(Date njqx) {
		this.njqx = njqx;
	}
	public String getXgr() {
		return xgr;
	}
	public void setXgr(String xgr) {
		this.xgr = xgr;
	}
	public Integer getZbsl() {
		return zbsl;
	}
	public void setZbsl(Integer zbsl) {
		this.zbsl = zbsl;
	}
	public String getZch() {
		return zch;
	}
	public void setZch(String zch) {
		this.zch = zch;
	}
	public String getQzbz() {
		return qzbz;
	}
	public void setQzbz(String qzbz) {
		this.qzbz = qzbz;
	}
	public Date getQzrq() {
		return qzrq;
	}
	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
	}
	public String getZgmc() {
		return zgmc;
	}
	public void setZgmc(String zgmc) {
		this.zgmc = zgmc;
	}
	public String getPzjgmc() {
		return pzjgmc;
	}
	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}
	public String getGslsh() {
		return gslsh;
	}
	public void setGslsh(String gslsh) {
		this.gslsh = gslsh;
	}
	public String getGstbr() {
		return gstbr;
	}
	public void setGstbr(String gstbr) {
		this.gstbr = gstbr;
	}
	public String getWjwlsh() {
		return wjwlsh;
	}
	public void setWjwlsh(String wjwlsh) {
		this.wjwlsh = wjwlsh;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public Date getPwrq() {
		return pwrq;
	}
	public void setPwrq(Date pwrq) {
		this.pwrq = pwrq;
	}
	public String getWjwtbr() {
		return wjwtbr;
	}
	public void setWjwtbr(String wjwtbr) {
		this.wjwtbr = wjwtbr;
	}
	public String getGk() {
		return gk;
	}
	public void setGk(String gk) {
		this.gk = gk;
	}
	public String getFkbz() {
		return fkbz;
	}
	public void setFkbz(String fkbz) {
		this.fkbz = fkbz;
	}
	public Integer getFksl() {
		return fksl;
	}
	public void setFksl(Integer fksl) {
		this.fksl = fksl;
	}
	public String getDybz() {
		return dybz;
	}
	public void setDybz(String dybz) {
		this.dybz = dybz;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeburl() {
		return weburl;
	}
	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDjblx() {
		return djblx;
	}
	public void setDjblx(String djblx) {
		this.djblx = djblx;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getCzflag() {
		return czflag;
	}
	public void setCzflag(String czflag) {
		this.czflag = czflag;
	}
	public String getYjflag() {
		return yjflag;
	}
	public void setYjflag(String yjflag) {
		this.yjflag = yjflag;
	}
	public String getSjzt() {
		return sjzt;
	}
	public void setSjzt(String sjzt) {
		this.sjzt = sjzt;
	}
	public String getJyjg() {
		return jyjg;
	}
	public void setJyjg(String jyjg) {
		this.jyjg = jyjg;
	}
	public Integer getFz() {
		return fz;
	}
	public void setFz(Integer fz) {
		this.fz = fz;
	}
	public String getNjjhy() {
		return njjhy;
	}
	public void setNjjhy(String njjhy) {
		this.njjhy = njjhy;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getNjjlx() {
		return njjlx;
	}
	public void setNjjlx(String njjlx) {
		this.njjlx = njjlx;
	}
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	public String getMemo3() {
		return memo3;
	}
	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}
	public String getMemo4() {
		return memo4;
	}
	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}
	public String getTbrsfzh() {
		return tbrsfzh;
	}
	public void setTbrsfzh(String tbrsfzh) {
		this.tbrsfzh = tbrsfzh;
	}
	public String getIsca() {
		return isca;
	}
	public void setIsca(String isca) {
		this.isca = isca;
	}
	public String getTbrlxfs() {
		return tbrlxfs;
	}
	public void setTbrlxfs(String tbrlxfs) {
		this.tbrlxfs = tbrlxfs;
	}
	public Date getGsfzrq() {
		return gsfzrq;
	}
	public void setGsfzrq(Date gsfzrq) {
		this.gsfzrq = gsfzrq;
	}
	public String getJydz() {
		return jydz;
	}
	public void setJydz(String jydz) {
		this.jydz = jydz;
	}
	public String getJyyb() {
		return jyyb;
	}
	public void setJyyb(String jyyb) {
		this.jyyb = jyyb;
	}
	public String getJydh() {
		return jydh;
	}
	public void setJydh(String jydh) {
		this.jydh = jydh;
	}
	public String getJfly() {
		return jfly;
	}
	public void setJfly(String jfly) {
		this.jfly = jfly;
	}

	public String getKhyh() {
		return khyh;
	}
	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}
	
	public String getKhzh() {
		return khzh;
	}
	public void setKhzh(String khzh) {
		this.khzh = khzh;
	}
	public Date getZsbfrq() {
		return zsbfrq;
	}
	public void setZsbfrq(Date zsbfrq) {
		this.zsbfrq = zsbfrq;
	}
	public Date getZszfrq() {
		return zszfrq;
	}
	public void setZszfrq(Date zszfrq) {
		this.zszfrq = zszfrq;
	}
	
	public String getQyzclx() {
		return qyzclx;
	}
	public void setQyzclx(String qyzclx) {
		this.qyzclx = qyzclx;
	}
	
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setWftzgbdm(String wftzgbdm) {
		this.wftzgbdm = wftzgbdm;
	}
	public String getWftzgbdm() {
		return wftzgbdm;
	}
	public void setHbzldm(String hbzldm) {
		this.hbzldm = hbzldm;
	}
	public String getHbzldm() {
		return hbzldm;
	}
	
	public String getMoveoutAddrss() {
		return moveoutAddrss;
	}
	public void setMoveoutAddrss(String moveoutAddrss) {
		this.moveoutAddrss = moveoutAddrss;
	}
	public String getMoveoutReason() {
		return moveoutReason;
	}
	public void setMoveoutReason(String moveoutReason) {
		this.moveoutReason = moveoutReason;
	}
	public String getMoveoutNote() {
		return moveoutNote;
	}
	public void setMoveoutNote(String moveoutNote) {
		this.moveoutNote = moveoutNote;
	}
	
	public String getOffPzjgmc() {
		return offPzjgmc;
	}
	public void setOffPzjgmc(String offPzjgmc) {
		this.offPzjgmc = offPzjgmc;
	}
	public String getOffReason() {
		return offReason;
	}
	public void setOffReason(String offReason) {
		this.offReason = offReason;
	}
	public String getOffPzwh() {
		return offPzwh;
	}
	public void setOffPzwh(String offPzwh) {
		this.offPzwh = offPzwh;
	}
	public String getOffNote() {
		return offNote;
	}
	public void setOffNote(String offNote) {
		this.zjlx = offNote;
	}
	public void setNewYwlx(String newYwlx) {
		this.newYwlx = newYwlx;
	}
	public String getNewYwlx() {
		return newYwlx;
	}
	public void setNewState(String newState) {
		this.newState = newState;
	}
	public String getNewState() {
		return newState;
	}
	public String getJgzcdz() {
		return jgzcdz;
	}
	public void setJgzcdz(String jgzcdz) {
		this.jgzcdz = jgzcdz;
	}
	public String getXzqhCode2() {
		return xzqhCode2;
	}
	public void setXzqhCode2(String xzqhCode2) {
		this.xzqhCode2 = xzqhCode2;
	}
	public String getXzqhName2() {
		return xzqhName2;
	}
	public void setXzqhName2(String xzqhName2) {
		this.xzqhName2 = xzqhName2;
	}
	public String getTbrzjlx() {
		return tbrzjlx;
	}
	public void setTbrzjlx(String tbrzjlx) {
		this.tbrzjlx = tbrzjlx;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getJglxdm() {
		return jglxdm;
	}
	public void setJglxdm(String jglxdm) {
		this.jglxdm = jglxdm;
	}
	public String getJjlxOld() {
		return jjlxOld;
	}
	public void setJjlxOld(String jjlxOld) {
		this.jjlxOld = jjlxOld;
	}
	public String getJjlxdmOld() {
		return jjlxdmOld;
	}
	public void setJjlxdmOld(String jjlxdmOld) {
		this.jjlxdmOld = jjlxdmOld;
	}
	public String getJjhymcOld() {
		return jjhymcOld;
	}
	public void setJjhymcOld(String jjhymcOld) {
		this.jjhymcOld = jjhymcOld;
	}
	public String getJjhydmOld() {
		return jjhydmOld;
	}
	public void setJjhydmOld(String jjhydmOld) {
		this.jjhydmOld = jjhydmOld;
	}
	public String getJglxOld() {
		return jglxOld;
	}
	public void setJglxOld(String jglxOld) {
		this.jglxOld = jglxOld;
	}
	public String getJglxdmOld() {
		return jglxdmOld;
	}
	public void setJglxdmOld(String jglxdmOld) {
		this.jglxdmOld = jglxdmOld;
	}
	public String getJjhymc() {
		return jjhymc;
	}
	public void setJjhymc(String jjhymc) {
		this.jjhymc = jjhymc;
	}
	public String getJjhydm() {
		return jjhydm;
	}
	public void setJjhydm(String jjhydm) {
		this.jjhydm = jjhydm;
	}
	public String getIsxw() {
		return isxw;
	}
	public void setIsxw(String isxw) {
		this.isxw = isxw;
	}
	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}
	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	public Zuser getZuser() {
		return zuser;
	}
	public void setZuser(Zuser zuser) {
		this.zuser = zuser;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStrNjqx() {
		return strNjqx;
	}
	public void setStrNjqx(String strNjqx) {
		this.strNjqx = strNjqx;
	}
	
}
