package cn.artern.JAVAEE4ZLHock.dao;

import java.util.Date;
import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;

public interface GoodsDao {

	Goods get(Integer id);

	void save(Goods goods);

	void update(Goods goods);

	void delete(Goods goods);

	void delete(Integer id);

	List<Goods> findAll();

	List<Goods> getGoodsByDate(Date date);

	List<Goods> getGoodsByLoan(Loan loan);

	List<Goods> getGoodsByStatus(String status);

	List<Goods> getGoodsByPawncheck(String id);

	List<Goods> getGoodsByReDate(Date date);

	List<Goods> getGoodsByDay(Date date);
}
