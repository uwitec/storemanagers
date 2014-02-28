package com.js.base.service;

import com.js.base.vo.SysUserBean;

public interface ILoginService {
	public SysUserBean getUser(String userNo) throws Exception;
}
