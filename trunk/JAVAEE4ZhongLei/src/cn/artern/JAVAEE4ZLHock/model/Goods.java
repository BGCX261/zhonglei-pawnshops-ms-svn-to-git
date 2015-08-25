package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {

	private Integer id;
	private Integer val;
	private String accessory;
	private String memo1;
	private String status;
	private Date indate;
	private Loan loan;
	private Pawncheck pawncheck;
	private double total;
	private Integer duration;
	private double rate;
	private Date redate;
	private double servetip;

	public Date getRedate() {
		return redate;
	}

	public void setRedate(Date redate) {
		this.redate = redate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Pawncheck getPawncheck() {
		return pawncheck;
	}

	public void setPawncheck(Pawncheck pawncheck) {
		this.pawncheck = pawncheck;
	}

	public Goods() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public double getServetip() {
		return servetip;
	}

	public void setServetip(double d) {
		this.servetip = d;
	}

}
