package cn.artern.JAVAEE4ZLHock.dao;

import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Loan_class;

public interface Loan_classDao {

	Loan_class get(String class_name);

	void save(Loan_class loan_class);

	void update(Loan_class loan_class);

	void delete(String class_name);

	void delete(Loan_class loan_class);

	List<Loan_class> findAll();

}
