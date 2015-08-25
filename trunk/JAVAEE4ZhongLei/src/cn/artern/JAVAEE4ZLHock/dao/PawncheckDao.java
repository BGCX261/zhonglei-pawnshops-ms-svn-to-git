package cn.artern.JAVAEE4ZLHock.dao;

import java.util.Date;
import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;

public interface PawncheckDao {

	Pawncheck get(String id);

	void save(Pawncheck pawncheck);

	void update(Pawncheck pawncheck);

	void delete(Pawncheck pawncheck);

	void delete(String id);

	List<Pawncheck> findAll();

	List<Pawncheck> getPawncheckByClerk(Clerk clerk);

	List<Pawncheck> getPawncheckByMonth(Date date);

	Pawncheck getSimple(String id);

	public List<Pawncheck> getPawncheckByCustomer(Customer customer);

}
