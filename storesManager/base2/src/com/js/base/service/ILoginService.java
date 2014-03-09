package com.js.base.service;

import com.js.base.vo.SysUserBean;

public interface ILoginService {
	public SysUserBean getUser(SysUserBean user) throws Exception;
}
