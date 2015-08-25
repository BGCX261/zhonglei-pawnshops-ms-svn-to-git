package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.LoanDao;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.Loan_class;

public class LoanDaoHibernate extends HibernateDaoSupport implements LoanDao {

	public void delete(Loan loan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(loan);
	}

	public void delete(Integer loan_id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(this.get(loan_id));
	}

	public List<Loan> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Loan");
	}

	public Loan get(Integer loan_id) {
		// TODO Auto-generated method stub
		return (Loan) getHibernateTemplate().get(Loan.class, loan_id);
	}

	public void save(Loan loan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(loan);
	}

	public void update(Loan loan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(loan);
	}

	public List<Loan> getLoanByClass(Loan_class loan_class) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from Loan loan where loan.loan_class=?", loan_class);
	}

	public Loan getLoanByName(String name) {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate()
				.find(
						"select new Loan(loan.loan_id,loan.loan_name,loan.loan_unit,loan.loan_accy)  from Loan loan where loan.loan_name=?",
						name);
		System.out.println(list);
		System.out.println(list.size() + " " + list.get(0)
				+ list.get(0).getClass());
		if (list.size() == 0)
			return null;
		else
			return (Loan) list.get(0);
	}

}
