package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {

	private Integer id;
	private Date operate_time;
	private double servetip;
	private Pawncheck pawncheck;
	private Clerk clerk;

	public Pawncheck getPawncheck() {
		return pawncheck;
	}

	public void setPawncheck(Pawncheck pawncheck) {
		this.pawncheck = pawncheck;
	}

	public Clerk getClerk() {
		return clerk;
	}

	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}

	public Record() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
