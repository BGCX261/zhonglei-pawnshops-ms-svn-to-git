package cn.artern.JAVAEE4ZLHock.action.admin;

import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.service.AdminManager;

import com.opensymphony.xwork2.Action;

public class AddUser implements Action {

	private Clerk clerk = new Clerk();
	private AdminManager adminManager;
	private String start;
	private String end;

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	public Clerk getClerk() {
		return clerk;
	}

	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String addUser() throws Exception {
		adminManager
				.addClerk(clerk.getName(), clerk.getPsw(), clerk.getPower());
		clerk = adminManager.getClerkByName(clerk.getName());
		return SUCCESS;
	}

	public String addPawncheck() throws Exception {
		adminManager.addPawncheckNO(start, end);
		return SUCCESS;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
