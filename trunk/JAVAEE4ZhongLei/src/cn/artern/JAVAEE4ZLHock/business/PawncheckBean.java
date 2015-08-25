package cn.artern.JAVAEE4ZLHock.business;

import java.io.Serializable;
import java.util.Date;

public class PawncheckBean implements Serializable {

	private String id;
	private Date opdate;
	private int clerk_id;
	private int customer_id;

	public PawncheckBean() {

	}

	public PawncheckBean(String id, Date opdate, int clerk_id, int customer_id) {

		this.id = id;
		this.clerk_id = clerk_id;
		this.customer_id = customer_id;
		this.opdate = opdate;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOpdate() {
		return opdate;
	}

	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}

	public int getClerk_id() {
		return clerk_id;
	}

	public void setClerk_id(int clerk_id) {
		this.clerk_id = clerk_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

}
