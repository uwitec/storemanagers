package com.js.base.dao;

import java.util.List;

import com.js.base.vo.SysUserBean;

public interface IUsersDao {
	public List<SysUserBean> getUser(SysUserBean bean) throws Exception;
	
	public SysUserBean getUserDetails(String user_no) throws Exception;
	
	public int updateUser(SysUserBean user) throws Exception;
}
