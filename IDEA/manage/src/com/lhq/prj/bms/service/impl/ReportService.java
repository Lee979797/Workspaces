package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.dao.IBzjgDao;
import com.lhq.prj.bms.dao.IReportDao;
import com.lhq.prj.bms.dao.IXzqhDao;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.po.Report;
import com.lhq.prj.bms.service.IReportService;

public class ReportService implements IReportService {

	private IReportDao reportDao;
	private IBzjgDao bzjgDao;
	
	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}
	public void setBzjgDao(IBzjgDao bzjgDao) {
		this.bzjgDao = bzjgDao;
	}
	
	@Override
	public List findByHandleDate(Report report) {
		// TODO Auto-generated method stub
		List<Report> listNew = new ArrayList<Report>();
		//取bzjgdm、count(*)
		List listOld = reportDao.findByHandleDate(report);
		
		for(int i=0; i < listOld.size();i++){
			Report report1 = (Report) listOld.get(i);
			//System.out.println("跟踪数据：：："+zxt1.getBzjgdm()+" "+zxt1.getNum());
			Bzjg ba = bzjgDao.findByBzjgdm(report1.getBzjgdm());
			report1.setBzjgmc(ba.getBzjgName());
			report1.setBzjgjc(ba.getBzjgJcName());
			listNew.add(report1);
		}
		
		return listNew;
	}
	
	public List findXzqhYwReport(Report report) {
		//listNew 存放最终结果（行政区划+业务+数量）
		List<Report> listNew = new ArrayList<Report>();
		//查询对应 办证机构某个时间段内 的 行政区划
		List listXzqh = reportDao.findXzqhYwReport(report);
		for(int i=0; i < listXzqh.size();i++){
			Report r1 = (Report) listXzqh.get(i);
			r1.setBzjgdm(report.getBzjgdm());
			r1.setHd1(report.getHd1());
			r1.setHd2(report.getHd2());
			//String[] ywlx = {"新办","年检","变更","换证","补证","迁入","迁出","预赋码","注销","批量注销"};
			//查找对应的xzqh的各个业务+数量
			List ywlxNum = reportDao.findNumByXzqh(r1);
			for(int j=0;j<ywlxNum.size();j++){
				Report r2 = (Report) ywlxNum.get(j);
				String str = r2.getYwlx();
				int num = r2.getNum();
				if(str.equals("新办")){
					r1.setXbNum(num);
				}else if(str.equals("年检")){
					r1.setNjNum(num);
				}else if(str.equals("变更")){
					r1.setBgNum(num);
				}else if(str.equals("换证")){
					r1.setHzNum(num);
				}else if(str.equals("补证")){
					r1.setBzNum(num);
				}else if(str.equals("迁入")){
					r1.setQrNum(num);
				}else if(str.equals("迁出")){
					r1.setQcNum(num);
				}else if(str.equals("预赋码")){
					r1.setYfmNum(num);
				}else if(str.equals("注销")){
					r1.setZxNum(num);
				}else if(str.equals("批量注销")){
					r1.setPlzxNum(num);
				}
			}
			listNew.add(r1);
		}
		return listNew;
	}

}
