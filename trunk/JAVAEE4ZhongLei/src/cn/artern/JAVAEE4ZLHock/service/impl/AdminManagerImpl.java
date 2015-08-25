package cn.artern.JAVAEE4ZLHock.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import cn.artern.JAVAEE4ZLHock.dao.ClerkDao;
import cn.artern.JAVAEE4ZLHock.dao.CustomerDao;
import cn.artern.JAVAEE4ZLHock.dao.GoodsDao;
import cn.artern.JAVAEE4ZLHock.dao.LoanDao;
import cn.artern.JAVAEE4ZLHock.dao.Loan_classDao;
import cn.artern.JAVAEE4ZLHock.dao.PawncheckDao;
import cn.artern.JAVAEE4ZLHock.dao.PawncheckNODao;
import cn.artern.JAVAEE4ZLHock.dao.RecordDao;
import cn.artern.JAVAEE4ZLHock.exception.JAVAEE4ZLException;
import cn.artern.JAVAEE4ZLHock.model.Clerk;
import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.Loan_class;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.JAVAEE4ZLHock.model.PawncheckNO;
import cn.artern.JAVAEE4ZLHock.model.Record;
import cn.artern.JAVAEE4ZLHock.service.AdminManager;
import cn.artern.tools.Date.EasyDate;
import cn.artern.tools.String.FillStringBetweenNum;

public class AdminManagerImpl implements AdminManager {

	static Logger log = Logger.getLogger(AdminManagerImpl.class.getName());
	private ClerkDao clerkDao;
	private CustomerDao customerDao;
	private GoodsDao goodsDao;
	private Loan_classDao loan_classDao;
	private LoanDao loanDao;
	private PawncheckDao pawncheckDao;
	private RecordDao recordDao;
	private PawncheckNODao pawncheckNODao;

	public void setPawncheckNODao(PawncheckNODao pawncheckNODao) {
		this.pawncheckNODao = pawncheckNODao;
	}

	public void setClerkDao(ClerkDao clerkDao) {
		this.clerkDao = clerkDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setLoan_classDao(Loan_classDao loan_classDao) {
		this.loan_classDao = loan_classDao;
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

	public void setPawncheckDao(PawncheckDao pawncheckDao) {
		this.pawncheckDao = pawncheckDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public void addClerk(String name, String psw, String power)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			if (power.equals("admin") || power.equals("operator")) {
				Clerk clerk = new Clerk();
				clerk.setName(name);
				clerk.setPsw(psw);
				clerk.setPower(power);
				clerkDao.save(clerk);
			} else
				throw new JAVAEE4ZLException("请勿添加错误的工作人员类型");

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("添加员工/管理员失败");
		}
	}

	public List<Goods> findAllGoods() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return goodsDao.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取所有物品失败");
		}
	}

	public List<Pawncheck> findAllPawncheck() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return pawncheckDao.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取所有当票失败");
		}
	}

	public List<Record> findAllRecord() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return recordDao.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取所有续当失败");
		}
	}

	public List<Goods> getGoodsByDate(Date date) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return goodsDao.getGoodsByDate(date);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过给定月获取物品失败");
		}
	}

	public List<Goods> getGoodsByDate() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return goodsDao.getGoodsByDate(new Date());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取当月物品失败");
		}
	}

	public List<Goods> getGoodsByLoan(Integer id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			Loan loan = loanDao.get(id);
			return goodsDao.getGoodsByLoan(loan);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过小类获取物品失败");
		}
	}

	public List<Goods> getGoodsByStatus(String status)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return goodsDao.getGoodsByStatus(status);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过状态获取物品失败");
		}
	}

	public List<Loan> getLoanByClass(String class_name)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			Loan_class loan_class = loan_classDao.get(class_name);
			return loanDao.getLoanByClass(loan_class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过大类获得小类错误");
		}
	}

	public List<Loan_class> findAllLoanClass() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return loan_classDao.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取所有大类错误");
		}
	}

	public List<Pawncheck> getPawncheckByClerk(int id)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			Clerk clerk = clerkDao.get(id);
			return pawncheckDao.getPawncheckByClerk(clerk);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过员工获取当票错误");
		}
	}

	public List<Pawncheck> getPawncheckByClerk(String name)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			Clerk clerk = clerkDao.get(name);
			return pawncheckDao.getPawncheckByClerk(clerk);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过员工获取当票错误");
		}
	}

	public List<Pawncheck> getPawncheckByMonth(Date date)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return pawncheckDao.getPawncheckByMonth(date);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过给定日期获取当票失败");
		}
	}

	public List<Pawncheck> getPawncheckByMonth() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return pawncheckDao.getPawncheckByMonth(new Date());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过给定日期获取当票失败");
		}
	}

	public List<Record> getRecordByClerk(String name) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			Clerk clerk = clerkDao.get(name);
			return recordDao.getRecordByClerk(clerk);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过员工获取续当失败");
		}
	}

	public List<Record> getRecordByClerk(int id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			Clerk clerk = clerkDao.get(id);
			return recordDao.getRecordByClerk(clerk);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过员工获取续当失败");
		}
	}

	public List<Record> getRecordkByMonth(Date date) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return recordDao.getRecordkByMonth(date);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过月份获取续当失败");
		}
	}

	public List<Record> getRecordkByMonth() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return recordDao.getRecordkByMonth(new Date());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过当月获取续当失败");
		}
	}

	public List<Clerk> findAllClerk() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return clerkDao.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取全部员工失败");
		}
	}

	public Clerk getClerkById(int id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return clerkDao.get(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取全部员工失败");
		}
	}

	public Clerk getClerkByName(String name) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return clerkDao.get(name);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("获取全部员工失败");
		}
	}

	public void addPawncheckNO(String start, String end)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			PawncheckNO pawncheckNO = new PawncheckNO();
			pawncheckNO.setStatus("Unused");
			for (String s : FillStringBetweenNum.fillFromStart2End(start, end)) {
				pawncheckNO.setPawncheckNO(s);
				pawncheckNODao.save(pawncheckNO);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("添加该批当票号失败");
		}

	}

	public Customer getCustomerById(int id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return customerDao.get(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("目前没有该客户");
		}
	}

	public Pawncheck getPawncheckById(String id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return pawncheckDao.get(id);

	}

	public List getGoodsByPawncheckID(String id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			List list = goodsDao.getGoodsByPawncheck(id);
			if (list == null) {
				throw new JAVAEE4ZLException("没有该当票的记录,当票号可能输入错误");
			}
			return list;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过当票号获取物品异常,可能无该当票");
		}
	}

	public void soldGoods(int id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		Goods goods = goodsDao.get(id);
		goods.setStatus("BeSold");
		goods.setRedate(EasyDate.getDateWithoutTime(new Date()));
		goodsDao.save(goods);
	}

	public List<Goods> getGoodsByReDate(Date date) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByReDate(date);
	}

	public List<Record> getRecordkByDay(Date date) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return recordDao.getRecordkByDay(date);
	}

	public List<Goods> getGoodsByDay(Date date) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByDay(date);
	}

	public void setPawncheckBlack(String pawncheckno) throws JAVAEE4ZLException {
		PawncheckNO pn = pawncheckNODao.get(pawncheckno);
		if (pn != null && pn.getStatus().equals("Temp")) {
			Pawncheck p = pawncheckDao.get(pawncheckno);
			if (p != null) {
				Set<Goods> gs = p.getGoods();
				for (Goods g : gs) {
					g.setStatus("Blank");
					goodsDao.update(g);
				}
			}
		} else {
			pn.setStatus("Temp");
			pawncheckNODao.save(pn);
		}
	}

	public void updateGoods(Goods g) throws JAVAEE4ZLException {
		goodsDao.save(g);
	}

}