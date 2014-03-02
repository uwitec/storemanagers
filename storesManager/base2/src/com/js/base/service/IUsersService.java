package com.js.base.service;

import java.util.List;

import com.js.base.vo.SysUserBean;

public interface IUsersService {
	public List<SysUserBean> getUser(SysUserBean bean) throws Exception;
	
	public SysUserBean getUserDetails(String user_no) throws Exception;
	
	public int updateUsers(SysUserBean user) throws Exception;
}
