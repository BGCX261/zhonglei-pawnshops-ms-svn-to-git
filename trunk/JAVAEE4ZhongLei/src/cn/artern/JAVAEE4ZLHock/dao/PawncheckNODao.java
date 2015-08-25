package cn.artern.JAVAEE4ZLHock.dao;

import java.util.List;

import cn.artern.JAVAEE4ZLHock.model.PawncheckNO;

public interface PawncheckNODao {

	PawncheckNO get();

	PawncheckNO get(String no);

	void save(PawncheckNO pawncheckNO);

	void delete(PawncheckNO pawncheckNO);

	int validUnEmpty();

	List<PawncheckNO> getPawncheckNOWaitPrint();

}
