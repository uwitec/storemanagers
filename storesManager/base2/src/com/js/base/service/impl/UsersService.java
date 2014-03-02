package com.js.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.js.base.dao.IUsersDao;
import com.js.base.service.IUsersService;
import com.js.base.vo.SysUserBean;

@Service("usersService")
public class UsersService implements IUsersService {
	@Autowired
	@Qualifier("usersDao")
	private IUsersDao usersDao;

	@Override
	public List<SysUserBean> getUser(SysUserBean bean) throws Exception {
		// TODO Auto-generated method stub
		List<SysUserBean> list=usersDao.getUser(bean);
		return list;
	}

	@Override
	public SysUserBean getUserDetails(String user_no) throws Exception {
		// TODO Auto-generated method stub
		SysUserBean user=usersDao.getUserDetails(user_no);
		return user;
	}

	@Override
	public int updateUsers(SysUserBean user) throws Exception {
		// TODO Auto-generated method stub
		int count=usersDao.updateUser(user);
		return count;
	}



}
