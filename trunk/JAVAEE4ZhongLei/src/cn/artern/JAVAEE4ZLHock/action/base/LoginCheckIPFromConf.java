package cn.artern.JAVAEE4ZLHock.action.base;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.artern.JAVAEE4ZLHock.service.impl.OperatorManagerImpl;

import com.opensymphony.xwork2.Action;

public class LoginCheckIPFromConf implements Action {

	static Logger log = Logger.getLogger(LoginCheckIPFromConf.class.getName());

	private String clientIp = "";

	private Set allowedIp;

	private String errMsg;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getClientIp() {
		return clientIp;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		clientIp = request.getRemoteAddr();
		if (allowedIp.contains(clientIp))
			return LOGIN;
		else {
			setErrMsg("IP 限制，请不要非法进入");
			log.error(getClientIp() + "企图非法进入");
			return ERROR;
		}
	}

	public Set getAllowedIp() {
		return allowedIp;
	}

	public void setAllowedIp(Set allowedIp) {
		this.allowedIp = allowedIp;
	}

}
