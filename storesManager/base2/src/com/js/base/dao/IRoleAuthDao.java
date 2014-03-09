package com.js.base.dao;

import java.util.List;

import com.js.base.vo.RoleMenuBean;

public interface IRoleAuthDao {
	public List<RoleMenuBean> getRoleMenuList(RoleMenuBean bean) throws Exception;

	public int updateRoleMenu(String role_no,String json) throws Exception;
}
