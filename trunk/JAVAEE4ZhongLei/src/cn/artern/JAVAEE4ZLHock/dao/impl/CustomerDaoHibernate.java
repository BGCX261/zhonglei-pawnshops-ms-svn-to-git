package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.CustomerDao;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Customer;

public class CustomerDaoHibernate extends HibernateDaoSupport implements
		CustomerDao {

	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(customer);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(this.get(id));
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Customer");
	}

	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		return (Customer) getHibernateTemplate().get(Customer.class, id);
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(customer);
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(customer);
	}

	public Customer get(String idCard) {
		// TODO Auto-generated method stub
		idCard = idCard.trim();
		List list = getHibernateTemplate().find(
				"select customer from Customer customer where idcard=?",
				new Object[] { idCard });
		if (list.size() == 0)
			return null;
		return (Customer) list.get(0);
	}

	public int isOnly(Customer customer) {
		// TODO Auto-generated method stub
		Customer cusTemp = get(customer.getIdcard());
		if (cusTemp == null)
			return 0;
		return cusTemp.getId();
	}

	public Customer getByName(String name) {
		// TODO Auto-generated method stub
		name = name.trim();
		List list = getHibernateTemplate().find(
				"select customer from Customer customer where name=?",
				new Object[] { name });
		if (list.size() == 0)
			return null;
		return (Customer) list.get(0);
	}

}
