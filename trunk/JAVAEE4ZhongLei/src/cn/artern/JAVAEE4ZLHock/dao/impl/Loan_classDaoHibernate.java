package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.Loan_classDao;
import cn.artern.JAVAEE4ZLHock.model.Loan_class;

public class Loan_classDaoHibernate extends HibernateDaoSupport implements
		Loan_classDao {

	public void delete(String class_name) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(this.get(class_name));
	}

	public void delete(Loan_class loan_class) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(loan_class);
	}

	public List<Loan_class> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Loan_class");
	}

	public Loan_class get(String class_name) {
		// TODO Auto-generated method stub
		return (Loan_class) getHibernateTemplate().get(Loan_class.class,
				class_name);
	}

	public void save(Loan_class loan_class) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(loan_class);
	}

	public void update(Loan_class loan_class) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(loan_class);
	}

}
