package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.PawncheckDao;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.tools.Date.EasyDate;

public class PawncheckDaoHibernate extends HibernateDaoSupport implements
		PawncheckDao {

	public void delete(Pawncheck pawncheck) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(pawncheck);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(this.get(id));
	}

	public List<Pawncheck> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Pawncheck");
	}

	public Pawncheck get(String id) {
		// TODO Auto-generated method stub
		return (Pawncheck) getHibernateTemplate().get(Pawncheck.class, id);
	}

	public void save(Pawncheck pawncheck) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(pawncheck);
	}

	public void update(Pawncheck pawncheck) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(pawncheck);
	}

	public List<Pawncheck> getPawncheckByClerk(Clerk clerk) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from Pawncheck pawncheck where pawncheck.clerk=?", clerk);
	}

	public List<Pawncheck> getPawncheckByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return getHibernateTemplate()
				.find("from Pawncheck pawncheck where pawncheck.customer=?",
						customer);
	}

	public List<Pawncheck> getPawncheckByMonth(Date date) {
		// TODO Auto-generated method stub
		Date dateArry[] = EasyDate.getDateMonthMaxAndMinDate(date);
		return getHibernateTemplate()
				.find(
						"from Pawncheck pawncheck where  pawncheck.opdate <=? and  pawncheck.opdate>=?",
						new Object[] { dateArry[0], dateArry[1] });
	}

	public Pawncheck getSimple(String id) {
		// TODO Auto-generated method stub

		List<Pawncheck> list = getHibernateTemplate()
				.find(
						"select new Pawncheck(pawncheck.id) from Pawncheck pawncheck where pawncheck.id=?",
						id);
		if (list.size() == 0)
			return null;
		else
			return (Pawncheck) list.get(0);
	}

}
