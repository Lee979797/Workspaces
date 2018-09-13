package com.lhq.prj.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IDfileDao;
import com.lhq.prj.bms.po.Dfile;

/**
 * DfileDao.java Create on 2012-5-12
 * 证书管理持久层实现
 */

public class DfileDao extends SqlMapClientDaoSupport implements IDfileDao {
	
	public List findDfileByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findDfileByPage",page);
	}
	public int findDfileByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findDfileByCount",page);
	}

	
	public List findDfileByGjPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findDfileByGjPage",page);
	}
	public int findDfileByGjCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findDfileByGjCount",page);
	}
	
	
	public List findArchiveByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findArchiveByPage",page);
	}
	public int findArchiveByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findArchiveByCount",page);
	}
	
	
	public List findArchiveByGjPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findArchiveByGjPage",page);
	}
	public int findArchiveByGjCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findArchiveByGjCount",page);
	}
	
	
	public List findAllByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findAllByPage",page);
	}
	public int findAllByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findAllByCount",page);
	}
	
	public List findAllByGjPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findAllByGjPage",page);
	}
	public int findAllByGjCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findAllByGjCount",page);
	}
	
	public List findAllByZuhePage(Page page) {
		return getSqlMapClientTemplate().queryForList("Dfile.findAllByZuhePage",page);
	}
	public int findAllByZuheCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findAllByZuheCount",page);
	}
	
	public Object saveDfile(Dfile dfile) {
		return getSqlMapClientTemplate().insert("Dfile.saveDfile", dfile);
	}

	public Object saveArchive(Dfile dfile) {
		return getSqlMapClientTemplate().insert("Dfile.saveArchive", dfile);
	}
	
	public Integer update(Dfile dfile) throws Exception {
	    return getSqlMapClientTemplate().update("Dfile.updateDfile", dfile);
	}

	public Integer updateDfileByDocid(Dfile dfile) throws Exception {
	    return getSqlMapClientTemplate().update("Dfile.updateDfileByDocid", dfile);
	}
	
	public Integer updateArchiveByDocid(Dfile dfile) throws Exception {
	    return getSqlMapClientTemplate().update("Dfile.updateArchiveByDocid", dfile);
	}
	public Integer deleteById(Integer orgid) {
		return getSqlMapClientTemplate().delete("Dfile.deleteByIdDfile", orgid);
	}
	
	public Dfile findByDfileId(Integer orgid) {
		return (Dfile) getSqlMapClientTemplate().queryForObject("Dfile.findByDfileId",orgid);
	}
	
	public Dfile findByArchiveId(Integer orgid) {
		return (Dfile) getSqlMapClientTemplate().queryForObject("Dfile.findByArchiveId",orgid);
	}
	
	public Dfile findByIdViewImg(Integer orgid){
		 return (Dfile) getSqlMapClientTemplate().queryForObject("Dfile.findByIdViewImg",orgid);
	}
	
	public Dfile findByArchiveIdViewImg(Integer orgid){
		 return (Dfile) getSqlMapClientTemplate().queryForObject("Dfile.findByArchiveIdViewImg",orgid);
	}

	public Dfile findArchiveByDocid(String docid) {
		return (Dfile) getSqlMapClientTemplate().queryForObject("Dfile.findArchiveByDocid",docid);
	}
	@Override
	public List findDfileByQxPage(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Dfile.findDfileByQxPage",page);
	}
	@Override
	public int findDfileByQxCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Dfile.findDfileByQxCount",page);
	}
}
