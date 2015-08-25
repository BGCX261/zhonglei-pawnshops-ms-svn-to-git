package cn.artern.JAVAEE4ZLHock.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import cn.artern.JAVAEE4ZLHock.model.Clerk;

public class TestHibernate {
	public static void main(String args[]) {

		Clerk admin = new Clerk();
		admin.setName("Administra");
		admin.setPsw("Administrtern");
		admin.setPower("admin");
		admin.setChecks(("Administra" + "Administrtern" + "admin").hashCode()
				+ "");

		Session se = null;
		Transaction tx = null;
		SessionFactory sf = null;

		Configuration conf = new Configuration();
		conf.configure();

		sf = conf.buildSessionFactory();
		se = sf.openSession();
		tx = se.beginTransaction();

		se.save(admin);
		se.flush();
		tx.commit();
		System.out.println("success!!!!!!!!");
	}
}
