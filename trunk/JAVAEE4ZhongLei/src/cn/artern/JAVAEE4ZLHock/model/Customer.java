package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable {

	private Integer id;
	private String name;
	private String idcard;
	private String phone;
	private String address;
	private Set<Pawncheck> pawncheck = new HashSet<Pawncheck>();

	public Set<Pawncheck> getPawncheck() {
		return pawncheck;
	}

	public void setPawncheck(Set<Pawncheck> pawncheck) {
		this.pawncheck = pawncheck;
	}

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
