package cn.artern.JAVAEE4ZLHock.AOP;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.service.AdminManager;

@Aspect
public class LoginAop {

	static Logger log = Logger.getLogger(LoginAop.class.getName());
	private AdminManager adminManager;

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	@Pointcut("execution(* cn.artern.JAVAEE4ZLHock.service.Login.validLogin(..))")
	public void loginAOP() {
	};

	@Before("loginAOP()&& args(id,..)")
	public void loginBefore(int id) {
		log.info("id 为" + id + "的员工试图登陆");
		try {
			List<Goods> gl = adminManager.getGoodsByStatus("BeforeEndDay");
			for (Goods g : gl) {
				if (!g.getRedate().after(new Date())) {
					g.setStatus("AfterEndDay");
					adminManager.updateGoods(g);
				}
			}
		} catch (JAVAEE4ZLException e) {
			e.printStackTrace();
		}
	}
}
