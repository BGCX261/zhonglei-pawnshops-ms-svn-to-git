package cn.artern.JAVAEE4ZLHock.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.Loan_class;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.JAVAEE4ZLHock.model.PawncheckNO;

public interface OperatorManager {
	void setPId(String id);

	/*
	 * 通过身份证获取客户信息
	 * 
	 * @param id 客户身份证号
	 * 
	 * @return 该客户的个人信息
	 */
	Customer getCustomerById(String id) throws JAVAEE4ZLException;

	/*
	 * 添加客户信息
	 * 
	 * @param name 客户名
	 * 
	 * @param idcard 客户的身份证号
	 * 
	 * @param phone 客户的电话
	 * 
	 * @param address 客户的住址
	 */
	void addCustomer(String name, String idcard, String phone, String address)
			throws JAVAEE4ZLException;

	/*
	 * 添加物品
	 * 
	 * @param accessory 附加信息
	 * 
	 * @param memo1 备注
	 * 
	 * @param duration 期限
	 * 
	 * @param rate 手续费率
	 * 
	 * @param loan_id 种类名称
	 * 
	 * @param check_id 当票号
	 */
	void addGoods(String accessory, String memo1, double total,
			Integer integer, double rate, Integer loan_id, String check_id,
			Integer val) throws JAVAEE4ZLException;

	/*
	 * 创立当票
	 * 
	 * @param id 当票号
	 * 
	 * @param clerk_id 操作员 id
	 * 
	 * @param customer_id 客户id
	 */
	void addPawncheck(String id, Integer clerk_id, String customerIdCard)
			throws JAVAEE4ZLException;

	/*
	 * 创立续当凭证
	 * 
	 * @param pawn_id 所续当票的id
	 * 
	 * @param goodsId 续当物品的id
	 * 
	 * @param endDate 续当的截止日期
	 * 
	 * @param operator 操作员号
	 */
	void addRecord(String pawn_id, Set<Integer> goodsId, Integer duration,
			Integer operator) throws JAVAEE4ZLException;

	/*
	 * 赎当
	 * 
	 * @param id 物品号
	 */
	void redeemGoods(Integer id) throws JAVAEE4ZLException;

	/*
	 * 根据当票号查询所当物品
	 * 
	 * @param id 当票号
	 */
	List getGoodsByPawncheckID(String id) throws JAVAEE4ZLException;

	/*
	 * 根据身份证查询当票
	 * 
	 * @param id 身份证号
	 */
	List<Pawncheck> getPawncheckByCustomerIDCard(Customer customer)
			throws JAVAEE4ZLException;

	/*
	 * 打印当票
	 * 
	 * @param id 当票号
	 */
	void printPawncheck(String id) throws JAVAEE4ZLException;

	PawncheckNO getPawncheckNO() throws JAVAEE4ZLException;

	Set<Pawncheck> getPawncheckNOWaitPaint() throws JAVAEE4ZLException;

	void setTempToPawncheckNO(PawncheckNO pawncheckNO)
			throws JAVAEE4ZLException;

	List<Loan_class> findAllLoanClass() throws JAVAEE4ZLException;

	List<Loan> getLoanByClass(Loan_class loan_class) throws JAVAEE4ZLException;

	Loan getLoanByName(String name) throws JAVAEE4ZLException;

	void printRecord(String id) throws JAVAEE4ZLException;

	Customer getCustomerByName(String name);
}
