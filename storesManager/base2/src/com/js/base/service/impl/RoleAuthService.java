package com.js.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.js.base.dao.IRoleAuthDao;
import com.js.base.service.IRoleAuthService;
import com.js.base.vo.RoleMenuBean;

@Service("roleAuthService")
public class RoleAuthService implements IRoleAuthService {
	@Autowired
	@Qualifier("roleAuthDao")
	private IRoleAuthDao roleAuthDao;

	@Override
	public List<RoleMenuBean> getRoleMenuList(RoleMenuBean bean) throws Exception {
		// TODO Auto-generated method stub
		List<RoleMenuBean> roleMenuList=roleAuthDao.getRoleMenuList(bean);
		return roleMenuList;
	}

	@Override
	public int updateRoleMenu(String role_no, String json) throws Exception {
		// TODO Auto-generated method stub
		roleAuthDao.updateRoleMenu(role_no, json);
		return 0;
	}


}
