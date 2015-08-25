package cn.artern.JAVAEE4ZLHock.business;

import java.io.Serializable;
import java.util.Date;

public class GoodsBean implements Serializable {

	private int id;
	private String accessory;
	private String memo1;
	private String status;
	private Date indate;
	private double total;
	private int duration;
	private double rate;
	private String pawncheck_id;
	private int loan_id;

	public GoodsBean() {

	}

	public GoodsBean(int id, String accessory, String memo1, String status,
			Date indate, double total, double rate, int duration,
			String pawncheck_id, int loan_id) {

		this.id = id;
		this.accessory = accessory;
		this.memo1 = memo1;
		this.status = status;
		this.indate = indate;
		this.total = total;
		this.duration = duration;
		this.rate = rate;
		this.pawncheck_id = pawncheck_id;
		this.loan_id = loan_id;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getPawncheck_id() {
		return pawncheck_id;
	}

	public void setPawncheck_id(String pawncheck_id) {
		this.pawncheck_id = pawncheck_id;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

}
