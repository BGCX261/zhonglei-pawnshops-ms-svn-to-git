package cn.artern.JAVAEE4ZLHock.service.impl;

import org.apache.log4j.Logger;

import cn.artern.JAVAEE4ZLHock.dao.ClerkDao;
import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.service.Login;

public class LoginImpl implements Login {

	static Logger log = Logger.getLogger(LoginImpl.class.getName());
	private ClerkDao clerkDao;
	private Clerk clerk;

	public int validLogin(Integer id, String psw) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			clerk = clerkDao.get(id, psw);
			if (clerk != null)
				if (clerkDao.checkSecurity(clerk) == 1) {
					if (clerk.getPower().equals("admin"))
						return 2;
					else
						return 1;
				} else
					return -1;
			else
				return 0;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("登陆失败");
		}
	}

	public ClerkDao getClerkDao() {
		return clerkDao;
	}

	public void setClerkDao(ClerkDao clerkDao) {
		this.clerkDao = clerkDao;
	}

	public Clerk getClerk() {
		return clerk;
	}

}
