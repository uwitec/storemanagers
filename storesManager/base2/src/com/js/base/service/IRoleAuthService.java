package com.js.base.service;

import java.util.List;

import com.js.base.vo.RoleMenuBean;

public interface IRoleAuthService {
	public List<RoleMenuBean> getRoleMenuList(RoleMenuBean bean) throws Exception;

	public int updateRoleMenu(String role_no,String json) throws Exception;
}
