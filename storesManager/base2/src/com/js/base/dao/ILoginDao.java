package com.js.base.dao;

import com.js.base.vo.SysUserBean;

public interface ILoginDao {
	public SysUserBean getUser(SysUserBean userNo);
}
