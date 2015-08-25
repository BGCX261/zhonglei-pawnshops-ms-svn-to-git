package cn.artern.JAVAEE4ZLHock.model;

import java.io.Serializable;

public class PawncheckNO implements Serializable {

	private String pawncheckNO;
	private String status;

	public String getPawncheckNO() {
		return pawncheckNO;
	}

	public void setPawncheckNO(String pawncheckNO) {
		this.pawncheckNO = pawncheckNO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
