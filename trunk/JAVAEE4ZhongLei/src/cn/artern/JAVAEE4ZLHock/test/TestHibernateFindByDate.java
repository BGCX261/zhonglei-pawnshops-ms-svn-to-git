package cn.artern.JAVAEE4ZLHock.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cn.artern.JAVAEE4ZLHock.dao.impl.GoodsDaoHibernate;
import cn.artern.JAVAEE4ZLHock.dao.impl.LoanDaoHibernate;
import cn.artern.JAVAEE4ZLHock.dao.impl.PawncheckDaoHibernate;
import cn.artern.JAVAEE4ZLHock.model.Goods;

public class TestHibernateFindByDate {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));

		PawncheckDaoHibernate pawncheckDao = (PawncheckDaoHibernate) factory
				.getBean("pawncheckDao");
		LoanDaoHibernate loanDao = (LoanDaoHibernate) factory
				.getBean("loanDao");
		Goods goods = new Goods();

		goods.setAccessory("");
		goods.setDuration(1);
		goods.setLoan(loanDao.get(3));
		goods.setMemo1("");
		goods.setPawncheck(pawncheckDao.get("01"));
		goods.setRate(2.1);
		goods.setStatus("");
		goods.setTotal(1);

		GoodsDaoHibernate goodsDao = (GoodsDaoHibernate) factory
				.getBean("goodsDao");
		goodsDao.save(goods);
		Calendar c = Calendar.getInstance();
		c.set(2008, 8, 16);
		List<Goods> goodsList = goodsDao.getGoodsByDate(new Date());

		for (Goods g : goodsList) {
			System.out.println(g.getIndate() + "2222222222");
		}

	}

}
