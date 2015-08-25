package cn.artern.JAVAEE4ZLHock.business;

import java.io.Serializable;
import java.util.Date;

public class RecordBean implements Serializable {

	private int id;
	private Date operate_time;
	private double servetip;
	private int clerk_id;
	private String pawncheck_id;

	public RecordBean() {

	}

	public RecordBean(int id, Date operate_time, double servertip,
			int clerk_id, String pawncheck_id) {

		this.clerk_id = clerk_id;
		this.id = id;
		this.operate_time = operate_time;
		this.pawncheck_id = pawncheck_id;
		this.servetip = servertip;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOperate_time() {
		return operate_time;
	}

	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}

	public double getServetip() {
		return servetip;
	}

	public void setServetip(double servetip) {
		this.servetip = servetip;
	}

	public int getClerk_id() {
		return clerk_id;
	}

	public void setClerk_id(int clerk_id) {
		this.clerk_id = clerk_id;
	}

	public String getPawncheck_id() {
		return pawncheck_id;
	}

	public void setPawncheck_id(String pawncheck_id) {
		this.pawncheck_id = pawncheck_id;
	}

}
