package cn.artern.JAVAEE4ZLHock.dao;

import java.util.Date;
import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Record;

public interface RecordDao {

	Record get(Integer id);

	void save(Record record);

	void update(Record record);

	void delete(Record record);

	void delete(Integer id);

	List<Record> findAll();

	List<Record> getRecordByClerk(Clerk clerk);

	List<Record> getRecordkByMonth(Date date);

	List<Record> getRecordkByDay(Date date);

}
