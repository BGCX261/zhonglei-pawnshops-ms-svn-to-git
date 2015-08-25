package cn.artern.JAVAEE4ZLHock.dao;

import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.Loan_class;

public interface LoanDao {

	Loan get(Integer loan_id);

	void save(Loan loan);

	void update(Loan loan);

	void delete(Loan loan);

	void delete(Integer loan_id);

	List<Loan> findAll();

	List<Loan> getLoanByClass(Loan_class loan_class);

	Loan getLoanByName(String name);

}
