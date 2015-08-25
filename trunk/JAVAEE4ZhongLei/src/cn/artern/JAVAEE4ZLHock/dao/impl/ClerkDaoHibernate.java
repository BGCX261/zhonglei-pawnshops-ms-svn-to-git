package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.ClerkDao;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.tools.Interface.MD5;
import cn.artern.tools.MD5.MD5Impl;

public class ClerkDaoHibernate extends HibernateDaoSupport implements ClerkDao {

	private MD5 md5;

	public void setMd5(MD5 md5) {
		this.md5 = md5;
	}

	public void delete(Clerk clerk) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(clerk);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(this.get(id));
	}

	public List<Clerk> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Clerk");
	}

	public Clerk get(Integer id) {
		// TODO Auto-generated method stub
		return (Clerk) getHibernateTemplate().get(Clerk.class, id);
	}

	public void save(Clerk clerk) {
		// TODO Auto-generated method stub
		clerk.setChecks(md5.MD5Password(clerk.getName() + clerk.getPsw()
				+ clerk.getPower()));
		getHibernateTemplate().saveOrUpdate(clerk);
	}

	public void update(Clerk clerk) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(clerk);
	}

	public int checkSecurity(Clerk clerk) {
		// TODO Auto-generated method stub
		if (md5
				.MD5Password(
						clerk.getName() + clerk.getPsw() + clerk.getPower())
				.equals(clerk.getChecks()))
			return 1;
		else
			return -1;
	}

	public Clerk get(Integer id, String psw) {
		// TODO Auto-generated method stub
		psw = psw.trim();
		List list = getHibernateTemplate().find(
				"from Clerk clerk where clerk.id=? and clerk.psw=?",
				new Object[] { id, psw });
		if (list.size() == 0)
			return null;
		return (Clerk) list.get(0);
	}

	public Clerk get(String name) {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().find(
				"from Clerk clerk where clerk.name=?", name);
		if (list.size() == 0)
			return null;
		return (Clerk) list.get(0);
	}

	public Clerk getSimple(int id) {
		List list = getHibernateTemplate().find(
				"from Clerk clerk where clerk.id=?", id);
		if (list.size() == 0)
			return null;
		return (Clerk) list.get(0);
	}

}
