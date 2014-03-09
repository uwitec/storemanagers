package com.js.base.dao;

import java.util.List;

import com.js.base.vo.SysRoleBean;

public interface IRoleDao {
	public List<SysRoleBean> getRoleList(SysRoleBean bean) throws Exception;

	public SysRoleBean getRoleDetails(String user_no) throws Exception;

	public int updateRole(SysRoleBean user) throws Exception;

	public int insertRole(SysRoleBean user) throws Exception;

	public void deleteRole(SysRoleBean user) throws Exception;

	public String getMaxRoleNo() throws Exception;
}
