package com.js.base.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.js.base.dao.IUsersDao;
import com.js.base.vo.SysUserBean;

@Repository("usersDao")
public class UsersDao implements IUsersDao{
	private static Logger logger = Logger.getLogger(UsersDao.class);
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	@Override
	public List<SysUserBean> getUser(SysUserBean bean)  throws Exception{
		return sqlSession.selectList("getList", bean);
	}
	@Override
	public SysUserBean getUserDetails(String user_no)  throws Exception{
		// TODO Auto-generated method stubsqlSession
		List<SysUserBean> list=sqlSession.selectList("getByID",user_no);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return new SysUserBean();
	}
	@Override
	public int updateUser(SysUserBean user) throws Exception {
		// TODO Auto-generated method stub
		int i=sqlSession.update("update",user);
		return i;
	}
	
}
