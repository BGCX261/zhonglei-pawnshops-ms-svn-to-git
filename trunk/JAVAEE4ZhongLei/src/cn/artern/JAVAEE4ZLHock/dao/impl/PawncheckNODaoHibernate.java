package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.PawncheckNODao;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.PawncheckNO;

public class PawncheckNODaoHibernate extends HibernateDaoSupport implements
		PawncheckNODao {

	public void delete(PawncheckNO pawncheckNO) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(pawncheckNO);
	}

	public PawncheckNO get() {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = s
						.createSQLQuery("select top 1 pawncheckNO,status from PawncheckNO  where status='Unused' order by pawncheckNO asc");
				List list = query.list();

				return list;
			}
		});
		Object[] o = (Object[]) list.get(0);

		PawncheckNO pawncheckNO = new PawncheckNO();

		pawncheckNO.setPawncheckNO((String) o[0]);

		pawncheckNO.setStatus((String) o[1]);

		return pawncheckNO;
	}

	public void save(PawncheckNO pawncheckNO) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(pawncheckNO);
	}

	public int validUnEmpty() {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = s
						.createSQLQuery("select count(*) from PawncheckNO where status!='Temp'");
				return query.list();
			}
		});
		Object o = list.get(0);
		return Integer.parseInt(o.toString());
	}

	public List<PawncheckNO> getPawncheckNOWaitPrint() {
		System.out.println("@@@@@@");
		return getHibernateTemplate().find(
				"from PawncheckNO p where p.status='Temp'");
	}

	public PawncheckNO get(String no) {
		// TODO Auto-generated method stub
		return (PawncheckNO) getHibernateTemplate().get(PawncheckNO.class, no);
	}

}
