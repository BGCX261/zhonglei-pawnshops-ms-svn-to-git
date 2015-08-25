package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.GoodsDao;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.tools.Date.EasyDate;

public class GoodsDaoHibernate extends HibernateDaoSupport implements GoodsDao {

	public void delete(Goods goods) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(goods);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(id);
	}

	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Goods");
	}

	public Goods get(Integer id) {
		// TODO Auto-generated method stub
		return (Goods) getHibernateTemplate().get(Goods.class, id);
	}

	public void save(Goods goods) {
		// TODO Auto-generated method stub
		goods.setIndate(EasyDate.getDateWithoutTime(new Date()));
		getHibernateTemplate().saveOrUpdate(goods);
	}

	public void update(Goods goods) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(goods);
	}

	public List<Goods> getGoodsByDate(Date date) {
		Date dateArry[] = EasyDate.getDateMonthMaxAndMinDate(date);
		return getHibernateTemplate()
				.find(
						"from Goods goods where  goods.indate <=? and  goods.indate>=?",
						new Object[] { dateArry[0], dateArry[1] });
	}

	public List<Goods> getGoodsByLoan(Loan loan) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from Goods goods where goods.loan=?", loan);
	}

	public List<Goods> getGoodsByStatus(String status) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from Goods goods where goods.status=?", status);
	}

	public List getGoodsByPawncheck(String id) {
		// TODO Auto-generated method stub
		final String q = "select goods.id,loan_name,status,total,rate,val,status,redate from goods,loan where check_id='"
				+ id + "' and loan.loan_id=goods.bname";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = s.createSQLQuery(q);
				List list = query.list();

				return list;
			}
		});
		return list;
	}

	public List<Goods> getGoodsByReDate(Date date) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"from Goods goods where goods.redate=?", date);
	}

	public List<Goods> getGoodsByDay(Date date) {
		return getHibernateTemplate().find(
				"from Goods goods where  goods.indate =?", date);
	}

}
