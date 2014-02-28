package com.js.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.js.base.dao.ILoginDao;
import com.js.base.service.ILoginService;
import com.js.base.vo.SysUserBean;

@Service("loginService")
public class LoginService implements ILoginService {
	@Autowired
	@Qualifier("loginDao")
	private ILoginDao loginDao;

	@Override
	public SysUserBean getUser(String userNo) throws Exception {
		SysUserBean bean = loginDao.getUser(userNo);
		return bean;
	}

}
