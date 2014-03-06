package com.js.base.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.js.base.dao.ISysOrgDao;
import com.js.base.vo.SysOrgBean;

@Repository("sysOrgDao")
public class SysOrgDao implements ISysOrgDao {
	private static Logger logger = Logger.getLogger(SysOrgDao.class);

	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	@Override
	public List<SysOrgBean> getSysOrgList(SysOrgBean bean) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("SysOrgDao.getSysDeptList()");
		List<SysOrgBean> list=sqlSession.selectList("SysOrg_getlist",bean);
		return list;
	}

	@Override
	public SysOrgBean getOrgDetails(String dept_no) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("SysOrgDao.getDeptDetails()");
		List<SysOrgBean> list=sqlSession.selectList("SysOrg_getByID",dept_no);
		SysOrgBean bean=new SysOrgBean();
		if(null!=list&&list.size()>0){
			bean=list.get(0);
		}
		return bean;
	}

	@Override
	public int updateOrg(SysOrgBean bean) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("SysOrgDao.updateDept()");
		int sum=sqlSession.update("SysOrg_update",bean);
		return sum;
	}
	
	@Override
	public int insertOrg(SysOrgBean bean) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("SysOrgDao.insertOrg()");
		int sum=sqlSession.insert("SysOrg_insert",bean);
		return sum;
	}

}
