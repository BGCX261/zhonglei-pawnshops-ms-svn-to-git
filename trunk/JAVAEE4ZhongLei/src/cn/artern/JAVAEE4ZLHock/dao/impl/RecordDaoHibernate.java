package cn.artern.JAVAEE4ZLHock.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.artern.JAVAEE4ZLHock.dao.RecordDao;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Record;
import cn.artern.tools.Date.EasyDate;

public class RecordDaoHibernate extends HibernateDaoSupport implements
		RecordDao {

	public void delete(Record record) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(record);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(this.get(id));
	}

	public List<Record> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("form Record");
	}

	public Record get(Integer id) {
		// TODO Auto-generated method stub
		return (Record) getHibernateTemplate().get(Record.class, id);
	}

	public void save(Record record) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(record);
	}

	public void update(Record record) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(record);
	}

	public List<Record> getRecordByClerk(Clerk clerk) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(
				"form Record record where record.clerk=?", clerk);
	}

	public List<Record> getRecordkByMonth(Date date) {
		// TODO Auto-generated method stub
		Date dateArry[] = EasyDate.getDateMonthMaxAndMinDate(date);
		return getHibernateTemplate()
				.find(
						"from Record record where  record.operate_time <=? and  record.operate_time>=?",
						new Object[] { dateArry[0], dateArry[1] });
	}

	public List<Record> getRecordkByDay(Date date) {
		return getHibernateTemplate().find(
				"from Record record where  record.operate_time =? ", date);
	}
}
