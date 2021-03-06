package com.js.base.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.js.base.dao.ILoginDao;
import com.js.base.vo.SysUserBean;

@Repository("loginDao")
public class LoginDao implements ILoginDao{
	private static Logger logger = Logger.getLogger(LoginDao.class);
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public SysUserBean getUser(SysUserBean user) {
		List<SysUserBean> list=sqlSession.selectList("login", user);
		SysUserBean userbean=null;
		if(list!=null&&list.size()>0){
			userbean=list.get(0);
		}
		logger.info("getUser......");
		
		return userbean;
	}
}
