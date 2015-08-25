package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Clerk implements Serializable {

	public Clerk() {
	}

	private Integer id;
	private String name;
	private String psw;
	private String power;
	private String checks;
	private Set<Pawncheck> pawncheck = new HashSet<Pawncheck>();
	private Set<Record> record = new HashSet<Record>();

	public Set<Pawncheck> getPawncheck() {
		return pawncheck;
	}

	public void setPawncheck(Set<Pawncheck> pawncheck) {
		this.pawncheck = pawncheck;
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

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getChecks() {
		return checks;
	}

	public void setChecks(String checks) {
		this.checks = checks;
	}

	public Set<Record> getRecord() {
		return record;
	}

	public void setRecord(Set<Record> record) {
		this.record = record;
	}
}
