package cn.artern.JAVAEE4ZLHock.service;

import java.util.Date;
import java.util.List;

import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.Loan_class;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.JAVAEE4ZLHock.model.Record;

public interface AdminManager {
	/*
	 * 创建员工
	 * 
	 * @param name 员工名称
	 * 
	 * @param psw 密码
	 * 
	 * @param power 权限
	 */
	void addClerk(String name, String psw, String power)
			throws JAVAEE4ZLException;

	List<Clerk> findAllClerk() throws JAVAEE4ZLException;

	Clerk getClerkById(int id) throws JAVAEE4ZLException;

	Clerk getClerkByName(String name) throws JAVAEE4ZLException;

	/*
	 * 通过员工id查看当票
	 * 
	 * @param id 员工id
	 * 
	 * @return 该id所对应员工所接手的当票
	 */
	List<Pawncheck> getPawncheckByClerk(int id) throws JAVAEE4ZLException;

	/*
	 * 通过员工name查看当票
	 * 
	 * @param name 员工name
	 * 
	 * @return 该name所对应员工所接手的当票
	 */
	List<Pawncheck> getPawncheckByClerk(String name) throws JAVAEE4ZLException;

	/*
	 * 通过员工name查看续当
	 * 
	 * @param name 员工name
	 * 
	 * @return 该name所对应员工所接手的续当
	 */
	List<Record> getRecordByClerk(String name) throws JAVAEE4ZLException;

	/*
	 * 通过员工id查看续当
	 * 
	 * @param id 员工id
	 * 
	 * @return 该id所对应员工所接手的续当
	 */

	List<Record> getRecordByClerk(int id) throws JAVAEE4ZLException;

	/*
	 * 获取所有当票
	 * 
	 * @return 所有当票
	 */
	List<Pawncheck> findAllPawncheck() throws JAVAEE4ZLException;

	/*
	 * 获取所有续当
	 * 
	 * @return 所有续当
	 */
	List<Record> findAllRecord() throws JAVAEE4ZLException;

	/*
	 * 获取所指定月份的当票
	 * 
	 * @return 指定月份的当票
	 */
	List<Pawncheck> getPawncheckByMonth(Date date) throws JAVAEE4ZLException;

	/*
	 * 获取所指定月份的续当
	 * 
	 * @return 指定月份的续当
	 */
	List<Record> getRecordkByMonth(Date date) throws JAVAEE4ZLException;

	/*
	 * 获取所当月份的当票
	 * 
	 * @return 当月的当票
	 */
	List<Pawncheck> getPawncheckByMonth() throws JAVAEE4ZLException;

	/*
	 * 获取所指定当月的续当
	 * 
	 * @return 当月的续当
	 */
	List<Record> getRecordkByMonth() throws JAVAEE4ZLException;

	/*
	 * 获取所有物品
	 * 
	 * @return 所有物品
	 */
	List<Goods> findAllGoods() throws JAVAEE4ZLException;

	/*
	 * 通过状态获取物品
	 * 
	 * @param status 物品状态
	 * 
	 * @return 通过状态获取物品
	 */
	List<Goods> getGoodsByStatus(String status) throws JAVAEE4ZLException;

	/*
	 * 通过月份获取物品
	 * 
	 * @param date 年月
	 * 
	 * @return 通过月份获取物品
	 */
	List<Goods> getGoodsByDate(Date date) throws JAVAEE4ZLException;

	/*
	 * 获取当月的物品
	 * 
	 * @return 当月的物品
	 */
	List<Goods> getGoodsByDate() throws JAVAEE4ZLException;

	/*
	 * 获取物品大类
	 * 
	 * @return 物品大类
	 */
	List<Loan_class> findAllLoanClass() throws JAVAEE4ZLException;

	/*
	 * 通过大类获取小类
	 * 
	 * @param class_name
	 * 
	 * @return 物品小类
	 */
	List<Loan> getLoanByClass(String class_name) throws JAVAEE4ZLException;

	/*
	 * 通过小类获取物品
	 * 
	 * @param bname 物品小类的id
	 * 
	 * @return 该小类的全部物品
	 */
	List<Goods> getGoodsByLoan(Integer id) throws JAVAEE4ZLException;

	void addPawncheckNO(String start, String end) throws JAVAEE4ZLException;

	Customer getCustomerById(int id) throws JAVAEE4ZLException;

	Pawncheck getPawncheckById(String id) throws JAVAEE4ZLException;

	List getGoodsByPawncheckID(String id) throws JAVAEE4ZLException;

	void soldGoods(int id) throws JAVAEE4ZLException;

	List<Goods> getGoodsByReDate(Date date) throws JAVAEE4ZLException;

	List<Record> getRecordkByDay(Date date) throws JAVAEE4ZLException;

	List<Goods> getGoodsByDay(Date date) throws JAVAEE4ZLException;

	void setPawncheckBlack(String pawncheckno) throws JAVAEE4ZLException;

	void updateGoods(Goods g) throws JAVAEE4ZLException;

}
