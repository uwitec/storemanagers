package com.js.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.js.base.dao.IRoleDao;
import com.js.base.service.IRoleService;
import com.js.base.vo.SysRoleBean;

@Service("roleService")
public class RoleService implements IRoleService {
	@Autowired
	@Qualifier("roleDao")
	private IRoleDao roleDao;

	@Override
	public List<SysRoleBean> getRoleList(SysRoleBean bean) throws Exception {
		// TODO Auto-generated method stub
		List<SysRoleBean> list=roleDao.getRoleList(bean);
		return list;
	}

	@Override
	public SysRoleBean getRoleDetails(String user_no) throws Exception {
		// TODO Auto-generated method stub
		SysRoleBean user=roleDao.getRoleDetails(user_no);
		return user;
	}

	@Override
	public int updateRole(SysRoleBean role) throws Exception {
		// TODO Auto-generated method stub
		int count=roleDao.updateRole(role);
		return count;
	}
	
	@Override
	public int insertRole(SysRoleBean role) throws Exception {
		// TODO Auto-generated method stub
		int count=roleDao.insertRole(role);
		return count;
	}

	public void deleteRole(SysRoleBean role) throws Exception {
		roleDao.deleteRole(role);
	}

	public String getMaxRoleNo() throws Exception{
		
		String max_no=roleDao.getMaxRoleNo();
		return max_no;
	}

}
