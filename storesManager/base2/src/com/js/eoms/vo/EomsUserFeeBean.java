package com.js.eoms.vo;

public class EomsUserFeeBean {
	protected String fee_id;
	protected String user_no;
	protected String user_name;
	protected String fee_date;
	protected double fee_amt;
	protected double fee_back_amt;
	protected String fee_back_date;
	protected String fee_desc;

	public String getFee_id() {
		return fee_id;
	}

	public void setFee_id(String fee_id) {
		this.fee_id = fee_id;
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

	public String getFee_date() {
		return fee_date;
	}

	public void setFee_date(String fee_date) {
		this.fee_date = fee_date;
	}

	public double getFee_amt() {
		return fee_amt;
	}

	public void setFee_amt(double fee_amt) {
		this.fee_amt = fee_amt;
	}

	public double getFee_back_amt() {
		return fee_back_amt;
	}

	public void setFee_back_amt(double fee_back_amt) {
		this.fee_back_amt = fee_back_amt;
	}

	public String getFee_back_date() {
		return fee_back_date;
	}

	public void setFee_back_date(String fee_back_date) {
		this.fee_back_date = fee_back_date;
	}

	public String getFee_desc() {
		return fee_desc;
	}

	public void setFee_desc(String fee_desc) {
		this.fee_desc = fee_desc;
	}

}
