package com.js.base.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.js.base.dao.IRoleAuthDao;
import com.js.base.vo.RoleMenuBean;
import com.js.base.vo.SysRoleBean;

@Repository("roleAuthDao")
public class RoleAuthDao implements IRoleAuthDao{
	private static Logger logger = Logger.getLogger(RoleAuthDao.class);
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	@Override
	public List<RoleMenuBean> getRoleMenuList(RoleMenuBean bean)
			throws Exception {
		logger.debug("roleAuthDao.getRoleMenuList(RoleMenuBean bean) beginning¡­¡­¡­¡­");
		List<RoleMenuBean> list=sqlSession.selectList("RoleMenu_getlist", bean);
		logger.debug("roleAuthDao.getRoleMenuList(RoleMenuBean bean) end¡­¡­¡­¡­");
		return list;
	}
	@Override
	public int updateRoleMenu(String role_no, String json) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("roleAuthDao.updateRoleMenu(String role_no, String json)  beginning¡­¡­¡­¡­");
		sqlSession.delete("RoleMenu_delete", role_no);
		String[] arrs=json.split(",");
		for(String i:arrs){
			RoleMenuBean bean=new RoleMenuBean();
			bean.setMenu_no(i);
			bean.setRole_no(role_no);
			sqlSession.insert("RoleMenu_insert",bean);
			
		}
		logger.debug("roleAuthDao.updateRoleMenu(String role_no, String json)  end¡­¡­¡­¡­");
		return 0;
	}
}
