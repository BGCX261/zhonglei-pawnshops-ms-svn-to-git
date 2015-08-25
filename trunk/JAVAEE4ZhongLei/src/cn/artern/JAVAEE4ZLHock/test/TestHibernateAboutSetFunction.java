package cn.artern.JAVAEE4ZLHock.test;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cn.artern.JAVAEE4ZLHock.dao.impl.ClerkDaoHibernate;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Record;

public class TestHibernateAboutSetFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));
		ClerkDaoHibernate clerkDao = (ClerkDaoHibernate) factory
				.getBean("clerkDao");
		Clerk clerk = clerkDao.get(9);
		Set<Record> recordSet = clerk.getRecord();
		Record record = null;
		if (recordSet == null)
			System.out.println("xxxxxx");
		for (Iterator<Record> it = recordSet.iterator(); it.hasNext();) {
			record = (Record) it.next();
			System.out.println(record.getServetip());
			System.out.println("asdfasdf");

		}
	}

}
