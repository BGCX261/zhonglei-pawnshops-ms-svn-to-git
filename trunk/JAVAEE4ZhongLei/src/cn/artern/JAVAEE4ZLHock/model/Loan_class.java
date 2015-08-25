package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Loan_class implements Serializable {

	private String class_name;
	private String class_type;
	private Set<Loan> loan = new HashSet<Loan>();

	public Loan_class() {
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String classname) {
		this.class_name = classname;
	}

	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	public Set<Loan> getLoan() {
		return loan;
	}

	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}

}
