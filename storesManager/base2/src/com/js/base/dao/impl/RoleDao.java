package com.js.base.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.js.base.dao.IRoleDao;
import com.js.base.vo.SysRoleBean;

@Repository("roleDao")
public class RoleDao implements IRoleDao{
	private static Logger logger = Logger.getLogger(RoleDao.class);
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	@Override
	public List<SysRoleBean> getRoleList(SysRoleBean bean)  throws Exception{
		return sqlSession.selectList("SysRole_getList", bean);
	}
	@Override
	public SysRoleBean getRoleDetails(String user_no)  throws Exception{
		// TODO Auto-generated method stubsqlSession
		List<SysRoleBean> list=sqlSession.selectList("SysRole_getByID",user_no);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return new SysRoleBean();
	}
	@Override
	public int updateRole(SysRoleBean role) throws Exception {
		// TODO Auto-generated method stub
		int i=sqlSession.update("SysRole_update",role);
		return i;
	}
	@Override
	public int insertRole(SysRoleBean role) throws Exception {
		// TODO Auto-generated method stub
		int i=sqlSession.insert("SysRole_insert",role);
		return i;
	}
	@Override
	public void deleteRole(SysRoleBean role) throws Exception {
		// TODO Auto-generated method stub
		int i=sqlSession.update("SysRole_delete",role);
	}
	
	@Override
	public String getMaxRoleNo() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("SysRoleDao.getMaxOrgNo()");
		List<String> list=sqlSession.selectList("SysRole_getMaxOrgNo");
		String role_no="0";
		if(null!=list&&list.size()>0){
			role_no=list.get(0);
		}
		return role_no;
	}
	
}
