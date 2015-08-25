package cn.artern.JAVAEE4ZLHock.business;

import java.io.Serializable;

public class LoanBean implements Serializable {

	private int loan_id;
	private String loan_name;
	private String loan_unit;
	private String loan_accy;
	private String class_name;

	public LoanBean() {

	}

	public LoanBean(int loan_id, String loan_name, String loan_unit,
			String loan_accy, String class_name) {

		this.loan_accy = loan_accy;
		this.class_name = class_name;
		this.loan_id = loan_id;
		this.loan_name = loan_name;
		this.loan_unit = loan_unit;

	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_name() {
		return loan_name;
	}

	public void setLoan_name(String loan_name) {
		this.loan_name = loan_name;
	}

	public String getLoan_unit() {
		return loan_unit;
	}

	public void setLoan_unit(String loan_unit) {
		this.loan_unit = loan_unit;
	}

	public String getLoan_accy() {
		return loan_accy;
	}

	public void setLoan_accy(String loan_accy) {
		this.loan_accy = loan_accy;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
}
