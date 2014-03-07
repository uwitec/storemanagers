package com.js.base.service;

import java.util.List;

import com.js.base.vo.SysOrgBean;

public interface ISysOrgService {
	public List<SysOrgBean> getSysOrgList(SysOrgBean bean) throws Exception;
	
	public SysOrgBean getOrgDetails(String dept_no) throws Exception;
	
	public int updateOrg(SysOrgBean bean) throws Exception;
	
	public int insertOrg(SysOrgBean bean) throws Exception;
	
	public String getMaxOrgNo() throws Exception;
	
	public void deleteOrg(String org_no) throws Exception;
}
