package com.js.base.vo;

import com.js.commons.paginator.Page;

public class SysUserBean {
	protected String user_no;
	protected String user_name;
	protected String pass_word;
	protected String org_no;
	protected String dep_no;
	protected String role_no;
	protected int pass_err;
	protected String pass_date;
	protected String tx_date;
	protected String user_sts;
	protected String op_no;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getOrg_no() {
		return org_no;
	}

	public void setOrg_no(String org_no) {
		this.org_no = org_no;
	}

	public String getDep_no() {
		return dep_no;
	}

	public void setDep_no(String dep_no) {
		this.dep_no = dep_no;
	}

	public String getRole_no() {
		return role_no;
	}

	public void setRole_no(String role_no) {
		this.role_no = role_no;
	}

	public int getPass_err() {
		return pass_err;
	}

	public void setPass_err(int pass_err) {
		this.pass_err = pass_err;
	}

	public String getPass_date() {
		return pass_date;
	}

	public void setPass_date(String pass_date) {
		this.pass_date = pass_date;
	}

	public String getTx_date() {
		return tx_date;
	}

	public void setTx_date(String tx_date) {
		this.tx_date = tx_date;
	}

	public String getUser_sts() {
		return user_sts;
	}

	public void setUser_sts(String user_sts) {
		this.user_sts = user_sts;
	}

	public String getOp_no() {
		return op_no;
	}

	public void setOp_no(String op_no) {
		this.op_no = op_no;
	}

}
