package cn.artern.JAVAEE4ZLHock.service.impl;

import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import cn.artern.JAVAEE4ZLHock.service.OperatorManager;
import cn.artern.tools.Date.EasyDate;
import cn.artern.tools.Interface.DrawCurrentPageText;
import cn.artern.tools.Interface.Printer;
import cn.artern.tools.Math.DigitMultiply;
import cn.artern.tools.String.FormatRMB;

/**
 * @author artern
 * 
 */
public class OperatorManagerImpl implements OperatorManager,
		DrawCurrentPageText {

	static Logger log = Logger.getLogger(OperatorManagerImpl.class.getName());

	private ClerkDao clerkDao;
	private CustomerDao customerDao;
	private GoodsDao goodsDao;
	private Loan_classDao loan_classDao;
	private LoanDao loanDao;
	private PawncheckDao pawncheckDao;
	private RecordDao recordDao;
	private PawncheckNODao pawncheckNODao;
	private String pId;
	private int statues;
	private Map<String, Object> ex = new HashMap<String, Object>();
	private Printer printer;

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public String getPId() {
		return pId;
	}

	public void setPId(String id) {
		pId = id;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#addCustomer(java
	 * .lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void addCustomer(String name, String idcard, String phone,
			String address) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {

			Customer customer = new Customer();
			customer.setAddress(address);
			customer.setIdcard(idcard);
			customer.setName(name);
			customer.setPhone(phone);
			System.out.println(customer.getName() + customer.getIdcard()
					+ customer.getPhone() + customer.getAddress());
			int id = customerDao.isOnly(customer);
			System.out.println(id + "@@@@@@@@");
			if (id != 0) {
				customer.setId(id);
				customerDao.update(customer);
			} else
				customerDao.save(customer);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("添加客户出现异常" + e.getMessage());
		}

	}// end

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#addGoods(java.lang
	 * .String, java.lang.String, java.lang.String, java.util.Date, double,
	 * java.lang.Integer, double, java.lang.Integer, java.lang.String)
	 */
	public void addGoods(String accessory, String memo1, double total,
			Integer month, double rate, Integer loan_id, String check_id,
			Integer val) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {

			Pawncheck pawncheck = pawncheckDao.getSimple(check_id);

			if (pawncheck == null) {
				throw new JAVAEE4ZLException("没有该当票的记录");
			}
			Goods goods = new Goods();
			goods.setAccessory(accessory);

			int duration = month;

			goods.setDuration(duration);
			goods.setIndate(EasyDate.getDateWithoutTime(new Date()));
			goods.setRedate(EasyDate.getEndDate(new Date(), duration));
			goods.setMemo1(memo1);
			goods.setRate(rate);
			goods.setStatus("BeforeEndDay");
			goods.setTotal(total);
			goods.setVal(val);
			goods.setServetip(total * rate * month);

			Loan loan = new Loan();
			loan.setLoan_id(loan_id);
			goods.setPawncheck(pawncheck);
			goods.setLoan(loan);
			goodsDao.save(goods);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException(
					"添加物品出现异常,重新进入后重试.或该订单已经打印,无法再次添加物品进入该订单" + e.getMessage());
		}

	}// end

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#addPawncheck(java
	 * .lang.String, java.util.Date, java.lang.Integer, java.lang.Integer)
	 */
	public void addPawncheck(String id, Integer clerk_id, String customerIdCard)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			if (pawncheckDao.getSimple(id) != null)
				throw new JAVAEE4ZLException("添加当票出现异常");
			Pawncheck pawncheck = new Pawncheck();
			pawncheck.setId(id);
			pawncheck.setOpdate(EasyDate.getDateWithoutTime(new Date()));

			Customer customer = customerDao.get(customerIdCard);
			Clerk clerk = clerkDao.getSimple(clerk_id);

			pawncheck.setClerk(clerk);
			pawncheck.setCustomer(customer);
			pawncheckDao.save(pawncheck);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("添加当票出现异常,次当票可能已经存在" + e.getMessage());
		}

	}// end

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#addRecord(java.lang
	 * .String, java.util.Date, int[], java.lang.Integer)
	 */
	public void addRecord(String pawn_id, Set<Integer> goodsId,
			Integer duration, Integer operator) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub

		try {

			Pawncheck pawncheck = pawncheckDao.get(pawn_id);
			if (pawncheck == null) {
				throw new JAVAEE4ZLException("没有该当票的记录,当票号可能输入错误");
			}
			Record record = new Record();
			record.setOperate_time(EasyDate.getDateWithoutTime(new Date()));
			Clerk clerk = clerkDao.getSimple(operator);
			double servetip = 0;
			Set<Goods> goodsSet = pawncheck.getGoods();
			Goods goods;
			Date startDate = null;
			Date endDate = new Date();
			double sum = 0;
			for (Iterator<Goods> it = goodsSet.iterator(); it.hasNext();) {
				goods = (Goods) it.next();
				if (!goodsId.contains(goods.getId())
						|| goods.getStatus().equals("BeSold"))
					throw new JAVAEE4ZLException("添加续当出现异常,可能当票号输入错误");
				servetip += goods.getRate() * goods.getTotal() * duration;
				ex.put("rate", goods.getRate() * 100);
				goods.setStatus("BeforeEndDay");
				startDate = goods.getRedate();
				endDate = EasyDate.getEndDate(goods.getRedate(), duration);
				goods.setRedate(endDate);
				goods.setDuration(goods.getDuration() + duration);
				sum += goods.getTotal();
				goodsDao.update(goods);
			}
			record.setServetip(servetip);
			record.setClerk(clerk);
			record.setPawncheck(pawncheck);
			ex.put("clerk", clerk.getId());
			ex.put("end", endDate);
			ex.put("start", startDate);
			ex.put("sum", DigitMultiply.twoDigitMultiply(1, sum) + "");
			ex.put("get", servetip + "");
			recordDao.save(record);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("添加续当出现异常,可能当票号输入错误");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#getCustomerById(
	 * java.lang.String)
	 */
	public Customer getCustomerById(String id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			return customerDao.get(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("目前没有该客户");
		}
	}// end

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#getGoodsByPawncheckID
	 * (java.lang.String)
	 */
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
	}// end

	/*
	 * (non-Javadoc)
	 * 
	 * @seecn.artern.JAVAEE4KaiFengHock.service.OperatorManager#
	 * getPawncheckByCustomerIDCard(java.lang.String)
	 */
	public List<Pawncheck> getPawncheckByCustomerIDCard(Customer customer)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			if (customer == null) {
				throw new JAVAEE4ZLException("通过身份证查找当票异常,没有该用户");
			}
			return pawncheckDao.getPawncheckByCustomer(customer);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("通过客户身份证获取当票错误,可能没有该客户");
		}
	}// end

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.JAVAEE4KaiFengHock.service.OperatorManager#redeemGoods(java
	 * .lang.Integer)
	 */
	public void redeemGoods(Integer id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		Goods goods = goodsDao.get(id);
		try {
			if (goods.getStatus().equals("BeforeEndDay")) {
				goods.setStatus("Redeemed");
				goods.setRedate(EasyDate.getDateWithoutTime(new Date()));
			} else
				throw new JAVAEE4ZLException(goods.getId() + "号物品绝当或过期");
			goodsDao.update(goods);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("赎当失败," + goods.getId()
					+ "物品需要续当或物品绝当");
		}
	}

	public void printPawncheck(String id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		setPId(id);
		statues = 1;
		// printer.setDrawCurrentPageText(this);
		printer.printWithoutAsk();

	}

	public void printRecord(String id) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		setPId(id);
		statues = 2;
		// printer.setDrawCurrentPageText(this);
		printer.printWithoutAsk();

	}

	public PawncheckNO getPawncheckNO() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			if (pawncheckNODao.validUnEmpty() == 0) {
				return null;
			} else {
				return pawncheckNODao.get();
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("自动获取当票号失败,请管理者指定");
		}
	}

	public void setTempToPawncheckNO(PawncheckNO pawncheckNO)
			throws JAVAEE4ZLException {
		try {
			pawncheckNO.setStatus("Temp");
			pawncheckNODao.save(pawncheckNO);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("setTempToPawncheckNO");
		}
	}

	public Set<Pawncheck> getPawncheckNOWaitPaint() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		try {
			List<PawncheckNO> pawncheckNOList = pawncheckNODao
					.getPawncheckNOWaitPrint();
			Set<Pawncheck> pawncheckSet = new HashSet<Pawncheck>();
			for (PawncheckNO p : pawncheckNOList) {
				System.out.println(p.getPawncheckNO());
				pawncheckSet.add(pawncheckDao.getSimple(p.getPawncheckNO()));
			}
			return pawncheckSet;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new JAVAEE4ZLException("取得还没有彻底完成打印的当票错误");
		}
	}

	public List<Loan_class> findAllLoanClass() throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return loan_classDao.findAll();
	}

	public List<Loan> getLoanByClass(Loan_class loan_class)
			throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return loanDao.getLoanByClass(loan_class);
	}

	public Loan getLoanByName(String name) throws JAVAEE4ZLException {
		// TODO Auto-generated method stub
		return loanDao.getLoanByName(name);
	}

	public void draw(Graphics2D g2, PageFormat pf, int page, Printer defP) {
		// TODO Auto-generated method stub
		Pawncheck pawncheck = pawncheckDao.get(getPId());
		Customer customer = pawncheck.getCustomer();
		DateFormat dfd = new SimpleDateFormat("yyyy    MM    dd");
		DateFormat dft = new SimpleDateFormat("HH:mm:ss");
		if (statues == 1) {
			Set<Goods> goodsSet = pawncheck.getGoods();
			g2.drawString("天津市众磊典当有限责任公司", 30, 47);
			g2.drawString("天津市河西区聚鑫园底商1号", 30, 61);
			g2.drawString("4006-116655", 325, 47);
			g2.drawString(customer.getName(), 30, 76);
			g2.drawString(customer.getPhone(), 325, 76);
			g2.drawString(customer.getAddress(), 30, 90);
			// g2.drawString(customer.getName(),325,90);
			g2.drawString("身份证", 30, 105);
			g2.drawString(customer.getIdcard(), 325, 105);
			g2.drawString(pawncheck.getClerk().getId() + "", 50, 312);
			g2.drawString(dfd.format(new Date()).toString(), 359, 306);
			g2.drawString(dft.format(new Date()).toString(), 359, 318);
			int h = 153;
			float sum = 0;
			double rate = 0;
			int k = 439;
			String AcM = "";
			Date endDate = new Date();
			if (goodsSet.size() <= 3) {

				for (Goods good : goodsSet) {
					rate = good.getRate();
					endDate = good.getRedate();
					g2.drawString(good.getLoan().getLoan_name(), 0, h);

					// String unit=good.getLoan().getLoan_unit();
					// if(unit.equals("克")){
					// int ke=select(good.getAccessory());
					// unit=ke+" "+unit;
					// }
					g2.drawString(good.getAccessory(), 100, h);
					g2.drawString(good.getVal() + "", 185, h);
					// g2.drawString(good.getTotal()+"", 200, h);
					// g2.drawString(good.getRate()*100+"", 255, h);
					sum += good.getTotal();
					String a = (int) (good.getTotal() * 100) + "";
					k = 439;
					char[] b = a.toCharArray();
					for (int bi = b.length - 1; bi >= 0; bi--) {
						g2.drawString(b[bi] + "", k, h);
						k = k - 16;
					}

					h += 15;
					AcM = AcM + good.getMemo1() + "\n";
				}
			}

			String a = (int) (sum * 100) + "";
			k = 439;

			char[] b2 = a.toCharArray();
			for (int bi = b2.length - 1; bi >= 0; bi--) {
				g2.drawString(b2[bi] + "", k, 199);
				k = k - 16;
			}

			g2.drawString(FormatRMB.formatRMB(sum + ""), 0, 199);

			g2.drawString(FormatRMB
					.formatRMB(String.format("%.2f", rate * sum)), 0, 214);
			g2.drawString(String.format("%.2f", rate * sum), 218, 214);
			g2.drawString(String.format("%.2f", rate * 100), 328, 214);

			g2.drawString(FormatRMB.formatRMB(String.format("%.2f", (1 - rate)
					* sum)), 0, 229);
			g2.drawString(String.format("%.2f", (1 - rate) * sum), 218, 229);

			g2.drawString(dfd.format(new Date()).toString(), 0, 244);
			g2.drawString(dfd.format(endDate).toString(), 140, 244);
			String PAcM[] = AcM.split("\n");
			int AcMlength = PAcM.length;
			if (AcMlength > 4) {
				PAcM[3] += "  (省略)";
				AcMlength = 4;
			}
			for (int i = 0; i < AcMlength; i++) {
				g2.drawString(PAcM[i], 0, 259 + i * 12);
			}
		} else {
			g2.drawString("天津市众磊典当有限责任公司", 60, 25);
			g2.drawString(getPId(), 330, 25);
			g2.drawString(customer.getName(), 60, 40);
			g2.drawString(customer.getName(), 330, 40);
			g2.drawString(FormatRMB.formatRMB((String) ex.get("sum")), 110, 55);
			g2.drawString(FormatRMB.formatRMB((String) ex.get("get")), 110, 70);
			g2.drawString(FormatRMB.formatRMB((String) ex.get("get")), 110, 98);
			g2.drawString((String) ex.get("sum"), 330, 55);
			g2.drawString((String) ex.get("get"), 330, 70);
			g2.drawString((String) ex.get("get"), 330, 98);
			g2.drawString(dfd.format(ex.get("start")).toString(), 30, 112);
			g2.drawString(dfd.format(ex.get("end")).toString(), 190, 112);
			g2.drawString(((Double) ex.get("rate")).toString(), 18, 128);
			g2.drawString(((Integer) ex.get("clerk")).toString(), 100, 152);
			g2.drawString(dfd.format(new Date()).toString(), 300, 146);
			g2.drawString(dft.format(new Date()).toString(), 300, 156);
		}
	}

	public int getPagesCount(String curStr, Printer defP) {
		// TODO Auto-generated method stub
		defP.setPAGES(1);
		return 1;
	}

	private static int select(String ss) {

		String s1;
		int j = 0;
		s1 = ss.trim();
		int[] ii = new int[s1.length()];
		int i;
		for (i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
				break;
			}
		}
		s1 = s1.substring(i);
		return Integer.parseInt(s1);
	}

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerDao.getByName(name);
	}

}
