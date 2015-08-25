package cn.artern.JAVAEE4ZLHock.service;

import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.model.Clerk;

public interface Login {

	/*
	 * 验证操作员是否可以登陆
	 * 
	 * @param id 员工id
	 * 
	 * @param pswd 员工密码
	 * 
	 * @return 是否可以通过的指示代号 1 通过 0 用户名或密码错 -1该用户被恶意修改，要通知管理员
	 */
	int validLogin(Integer id, String pswd) throws JAVAEE4ZLException;

	Clerk getClerk();

}
