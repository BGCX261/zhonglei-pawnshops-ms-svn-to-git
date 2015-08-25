package cn.artern.JAVAEE4ZLHock.dao;

import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Clerk;

public interface ClerkDao {

	Clerk get(Integer id);

	void save(Clerk clerk);

	void update(Clerk clerk);

	void delete(Clerk clerk);

	void delete(Integer id);

	List<Clerk> findAll();

	Clerk get(Integer id, String psw);

	int checkSecurity(Clerk clerk);

	Clerk get(String name);

	Clerk getSimple(int id);

}
