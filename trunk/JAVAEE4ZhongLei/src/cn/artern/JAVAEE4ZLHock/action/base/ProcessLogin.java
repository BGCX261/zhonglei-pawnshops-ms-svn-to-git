package cn.artern.JAVAEE4ZLHock.action.base;

import java.util.Map;

import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.service.Login;
import cn.artern.JAVAEE4ZLHock.service.OperatorManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessLogin extends ActionSupport {

	private int id;
	private String password;

	private Login login;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		session.clear();
		int statue = login.validLogin(id, password);
		if (statue == 1) {
			session.put("userId", id);
			session.put("power", "operator");
			return "operator";
		}
		if (statue == 2) {
			session.put("userId", id);
			session.put("power", "admin");
			return "admin";
		}
		if (statue == 0) {
			addActionError("用户名/密码不匹配");
			return LOGIN;
		}
		throw new JAVAEE4ZLException("请不要更该软件运行环境或有其他不规范行为");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
