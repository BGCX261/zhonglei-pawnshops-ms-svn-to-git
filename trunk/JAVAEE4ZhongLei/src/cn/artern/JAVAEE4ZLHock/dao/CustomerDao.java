package cn.artern.JAVAEE4ZLHock.dao;

import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Customer;

public interface CustomerDao {

	Customer get(Integer id);

	Customer get(String idCard);

	void save(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	void delete(Integer id);

	List<Customer> findAll();

	int isOnly(Customer customer);

	Customer getByName(String name);

}
