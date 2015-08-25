package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pawncheck implements Serializable {

	private String id;
	private Date opdate;
	private Set<Goods> goods = new HashSet<Goods>();
	private Set<Record> record = new HashSet<Record>();
	private Clerk clerk;
	private Customer customer;

	public Pawncheck() {
	}

	public Pawncheck(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public Clerk getClerk() {
		return clerk;
	}

	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Record> getRecord() {
		return record;
	}

	public void setRecord(Set<Record> record) {
		this.record = record;
	}

	public Date getOpdate() {
		return opdate;
	}

	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}

}
