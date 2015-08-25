package cn.artern.JAVAEE4ZLHock.action.operator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.PawncheckNO;
import cn.artern.JAVAEE4ZLHock.service.OperatorManager;
import cn.artern.tools.Date.EasyDate;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPawncheck extends ActionSupport {

	private OperatorManager operatorManager;
	private PawncheckNO pawncheckNO;
	private Customer customer;
	private String isnew;
	private Map map;
	private String loan_name;
	private Loan loan;
	private Goods goods;
	private Date endDate;
	private String afterAddGoods;
	private Map seCp;
	private List<Goods> goodsList;
	private int month;
	private List<Integer> loan_id;
	private Goods[] goodArr = new Goods[3];

	public Goods[] getGoodArr() {
		return goodArr;
	}

	public void setGoodArr(Goods[] goodArr) {
		this.goodArr = goodArr;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public List getGoodsList() {
		return goodsList;
	}

	public void setAfterAddGoods(String afterAddGoods) {
		this.afterAddGoods = afterAddGoods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Loan getLoan() {
		return loan;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public String getIsnew() {
		return isnew;
	}

	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	public PawncheckNO getPawncheckNO() {
		return pawncheckNO;
	}

	public void setPawncheckNO(PawncheckNO pawncheckNO) {
		this.pawncheckNO = pawncheckNO;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOperatorManager(OperatorManager operatorManager) {
		this.operatorManager = operatorManager;
	}

	public String execute() throws Exception {
		goodsList = new ArrayList<Goods>();
		loan_id = new ArrayList<Integer>();
		pawncheckNO = operatorManager.getPawncheckNO();

		Map session = ActionContext.getContext().getSession();
		session.put("pawncheckNO", pawncheckNO);

		if (pawncheckNO == null) {
			addActionError("没有当票号,请管理员设定");
			return SUCCESS;
		}

		if (isnew != null && (isnew.equals("旧") || isnew.equals("false"))) {
			customer = operatorManager.getCustomerById(customer.getIdcard());
			isnew = null;
		}
		return SUCCESS;
	}

	public String addCustomer() throws Exception {
		if (isnew != null && isnew.equals("旧")) {
			return "re";
		}
		return SUCCESS;
	}

	public String getTableByLoan() throws Exception {
		System.out.println(loan_name);
		loan = operatorManager.getLoanByName(loan_name);
		return SUCCESS;

	}

	public String addGoods() throws Exception {
		System.out.println(goods.getAccessory() + goods.getMemo1()
				+ goods.getTotal() + goods.getDuration() + goods.getRate()
				+ loan.getLoan_id() + pawncheckNO.getPawncheckNO()
				+ goods.getVal());
		goodsList.add(goods);
		loan_id.add(loan.getLoan_id());
		if (afterAddGoods.equals("物品添加完成")) {
			Map session = ActionContext.getContext().getSession();
			seCp = new HashMap(session);
			endDate = EasyDate.getEndDate(new Date(), goods.getDuration());
			int m = 0;
			for (Goods g : goodsList) {
				Goods gt = new Goods();
				gt = g;
				goodArr[m] = gt;
				m++;
			}
			return "addOver";
		} else
			goods = new Goods();
		goods.setDuration(goodsList.get(0).getDuration());
		return "addAlso";
	}

	public void setLoan_name(String loan_name) {
		this.loan_name = loan_name;
	}

	public Goods getGoods() {
		return goods;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String printPawncheck() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.putAll(seCp);
		goodsList.clear();
		for (int n = 0; n < goodArr.length; n++) {
			goodsList.add(goodArr[n]);
		}
		System.out.println(0);
		operatorManager.addCustomer(customer.getName(), customer.getIdcard(),
				customer.getPhone(), customer.getAddress());
		System.out.println(1);
		operatorManager
				.addPawncheck(pawncheckNO.getPawncheckNO(),
						(Integer) ActionContext.getContext().getSession().get(
								"userId"), customer.getIdcard());
		System.out.println(2);
		operatorManager.setTempToPawncheckNO(pawncheckNO);
		System.out.println(3);
		int index = 0;
		for (Goods goods : goodsList) {
			if (goods == null)
				break;
			operatorManager.addGoods(goods.getAccessory(), goods.getMemo1(),
					goods.getTotal(), goods.getDuration(), goods.getRate(),
					loan_id.get(index), pawncheckNO.getPawncheckNO(), goods
							.getVal());
			index++;
		}
		operatorManager.printPawncheck(pawncheckNO.getPawncheckNO());
		return SUCCESS;
	}

	public String perview() throws Exception {
		operatorManager.setPId(pawncheckNO.getPawncheckNO());
		return SUCCESS;
	}

}
