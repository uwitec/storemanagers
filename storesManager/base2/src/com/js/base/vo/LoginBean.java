package com.js.base.vo;

/**
 * 
 * ������������½Bean
 * 
 * @author dhcc wangshanfang
 * @date Feb 20, 2014
 * @see
 * @�޸���־��
 * 
 */
public class LoginBean {
	// ����Ա����
	private String userName;
	// ����Ա����
	private String userNo;
	// ����
	private String passWord;
	// ��ɫ
	private String roleNo;
	// ��֤��
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
