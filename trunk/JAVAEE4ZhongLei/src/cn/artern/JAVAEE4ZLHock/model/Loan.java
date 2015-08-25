package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Loan implements Serializable {

	private Integer loan_id;
	private String loan_name;
	private String loan_unit;
	private String loan_accy;
	private Loan_class loan_class;
	private Set<Goods> goods = new HashSet<Goods>();

	public Loan(Integer loan_id, String loan_name, String loan_unit,
			String loan_accy) {
		this.loan_accy = loan_accy;
		this.loan_name = loan_name;
		this.loan_id = loan_id;
		this.loan_unit = loan_unit;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public Loan_class getLoan_class() {
		return loan_class;
	}

	public void setLoan_class(Loan_class loan_class) {
		this.loan_class = loan_class;
	}

	public Loan() {
	}

	public Integer getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(Integer loan_id) {
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

}
