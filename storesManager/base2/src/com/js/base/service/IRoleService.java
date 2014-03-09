package com.js.base.service;

import java.util.List;

import com.js.base.vo.SysRoleBean;

public interface IRoleService {
	public List<SysRoleBean> getRoleList(SysRoleBean role) throws Exception;

	public SysRoleBean getRoleDetails(String role_no) throws Exception;

	public int updateRole(SysRoleBean role) throws Exception;
	
	public int insertRole(SysRoleBean role) throws Exception;

	public void deleteRole(SysRoleBean role) throws Exception;
	
	public String getMaxRoleNo() throws Exception;
}
