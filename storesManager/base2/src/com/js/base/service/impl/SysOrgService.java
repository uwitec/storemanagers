package com.js.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.js.base.dao.ISysOrgDao;
import com.js.base.service.ISysOrgService;
import com.js.base.vo.SysOrgBean;

@Service("sysOrgService")
public class SysOrgService implements ISysOrgService {
	@Autowired
	@Qualifier("sysOrgDao")
	private ISysOrgDao sysOrgDao;

	@Override
	public List<SysOrgBean> getSysOrgList(SysOrgBean bean) throws Exception {
		// TODO Auto-generated method stub
		List<SysOrgBean> list=sysOrgDao.getSysOrgList(bean);
		return list;
	}

	@Override
	public SysOrgBean getOrgDetails(String dept_no) throws Exception {
		// TODO Auto-generated method stub
		SysOrgBean bean=sysOrgDao.getOrgDetails(dept_no);
		return bean;
	}

	@Override
	public int updateOrg(SysOrgBean bean) throws Exception {
		// TODO Auto-generated method stub
		int sum=sysOrgDao.updateOrg(bean);
		return sum;
	}
	
	@Override
	public int insertOrg(SysOrgBean bean) throws Exception {
		// TODO Auto-generated method stub
		int sum=sysOrgDao.updateOrg(bean);
		return sum;
	}

}
