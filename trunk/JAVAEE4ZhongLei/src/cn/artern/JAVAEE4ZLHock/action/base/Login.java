package cn.artern.JAVAEE4ZLHock.action.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.artern.JAVAEE4ZLHock.dao.ClerkDao;
import cn.artern.JAVAEE4ZLHock.model.Clerk;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class Login implements Action {

	private ClerkDao clerkDao;

	private Clerk clerk;

	private Date date;

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		int id = (Integer) session.get("userId");
		clerk = clerkDao.getSimple(id);
		date = new Date();
		return SUCCESS;
	}

	public void setClerkDao(ClerkDao clerkDao) {
		this.clerkDao = clerkDao;
	}

	public Clerk getClerk() {
		return clerk;
	}

	public Date getDate() {
		return date;
	}

}
