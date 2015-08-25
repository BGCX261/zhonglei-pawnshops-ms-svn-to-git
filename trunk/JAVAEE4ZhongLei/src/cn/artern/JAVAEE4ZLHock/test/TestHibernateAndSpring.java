package cn.artern.JAVAEE4ZLHock.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cn.artern.JAVAEE4ZLHock.dao.impl.ClerkDaoHibernate;
import cn.artern.JAVAEE4ZLHock.model.Clerk;

public class TestHibernateAndSpring {
	public static void main(String args[]) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));

		Clerk admin = new Clerk();
		admin.setId(5);
		admin.setName("artedddrn");
		admin.setPsw("Administrtern");
		admin.setPower("admin");
		admin.setChecks(("artern" + "Administrtern" + "admin").hashCode() + "");

		// Session se=null;
		// Transaction tx=null;
		// SessionFactory sf=null;
		// sf=(SessionFactory)factory.getBean("sessionFactory");

		// Configuration conf=new Configuration();
		// conf.configure();

		// sf=conf.buildSessionFactory();
		// se=sf.openSession();
		// tx=se.beginTransaction();

		// se.save(admin);
		// se.flush();
		// tx.commit();

		ClerkDaoHibernate clerkDao = (ClerkDaoHibernate) factory
				.getBean("clerkDao");
		System.out.println("!!!!!!!!!!!!!!!");

		clerkDao.save(admin);

		for (Clerk c : clerkDao.findAll()) {
			System.out.println(c.getName());
		}

		System.out.println("success!!!!!!!!");
	}
}
