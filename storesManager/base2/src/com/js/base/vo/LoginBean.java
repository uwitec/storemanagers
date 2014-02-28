package com.js.base.vo;

/**
 * 
 * 功能描述：登陆Bean
 * 
 * @author dhcc wangshanfang
 * @date Feb 20, 2014
 * @see
 * @修改日志：
 * 
 */
public class LoginBean {
	// 操作员名称
	private String userName;
	// 操作员号码
	private String userNo;
	// 密码
	private String passWord;
	// 角色
	private String roleNo;
	// 验证码
	private String checkMark;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCheckMark() {
		return checkMark;
	}

	public void setCheckMark(String checkMark) {
		this.checkMark = checkMark;
	}
}
