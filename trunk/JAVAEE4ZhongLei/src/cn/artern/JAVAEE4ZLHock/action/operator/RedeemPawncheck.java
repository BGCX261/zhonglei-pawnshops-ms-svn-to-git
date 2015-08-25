package cn.artern.JAVAEE4ZLHock.action.operator;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.JAVAEE4ZLHock.service.OperatorManager;
import cn.artern.tools.Date.EasyDate;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RedeemPawncheck extends ActionSupport {
	private String status;
	private OperatorManager operatorManager;
	private String pawncheckNO;
	private List<Object[]> goods;
	private Date endDate;
	private Map<Integer, String> goodsMap = new HashMap();
	private Object[] value;
	private Map seCp;
	private int duration;
	private float sum;
	private float rate;
	private float si;
	private Customer customer;
	private List<Pawncheck> pawncheckSet;

	public List<Pawncheck> getPawncheckSet() {
		return pawncheckSet;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getSi() {
		si = sum * rate;
		return si;
	}

	public float getSum() {
		return sum;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Object[] getValue() {
		return value;
	}

	public void setValue(Object[] value) {
		this.value = value;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPawncheckNO() {
		return pawncheckNO;
	}

	public void setPawncheckNO(String pawncheckNO) {
		this.pawncheckNO = pawncheckNO;
	}

	public String getGoodsList() throws Exception {
		goodsMap.clear();
		goods = operatorManager.getGoodsByPawncheckID(pawncheckNO);
		sum = 0;
		for (Object[] o : goods) {
			goodsMap.put((Integer) o[0], (String) o[1] + "\t数量:"
					+ (Integer) o[5] + "\t总值:"
					+ String.format("%.2f", (Float) o[3]) + "\t\t折当率:"
					+ (Float) o[4] + "\t状态：" + (String) o[6] + "\t 截止当期："
					+ EasyDate.getDate((Date) o[7]));
			sum += (Float) o[3];
			rate = (Float) o[4];
		}
		value = goodsMap.keySet().toArray();
		return SUCCESS;
	}

	public void setGoods(List<Object[]> goods) {
		this.goods = goods;
	}

	public List<Object[]> getGoods() {
		return goods;
	}

	public void setOperatorManager(OperatorManager operatorManager) {
		this.operatorManager = operatorManager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String doRedeem() throws Exception {
		for (Object o : value) {
			operatorManager.redeemGoods(Integer.parseInt((String) o));
		}
		return "success";
	}

	public Map getGoodsMap() {
		return goodsMap;
	}

	public void setGoodsMap(Map goodsMap) {
		this.goodsMap = goodsMap;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		customer = new Customer();
		return SUCCESS;
	}

	public String addRecord() throws Exception {
		Map session = ActionContext.getContext().getSession();
		seCp = new HashMap(session);/*
									 * Set<Integer> goodsId = new HashSet(); for
									 * (Object o : value) {
									 * goodsId.add(Integer.parseInt((String)o));
									 * } operatorManager.addRecord(pawncheckNO,
									 * goodsId, endDate,
									 * (Integer)session.get("userId"));
									 */
		return SUCCESS;
	}

	public String printRecord() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Set<Integer> goodsId = new HashSet();
		for (Object o : value) {
			goodsId.add(Integer.parseInt((String) o));
		}
		operatorManager.addRecord(pawncheckNO, goodsId, duration,
				(Integer) seCp.get("userId"));
		operatorManager.printRecord(pawncheckNO);
		session.putAll(seCp);
		return SUCCESS;
	}

	public String perview() throws Exception {
		operatorManager.setPId(pawncheckNO);
		return SUCCESS;
	}

	public float getRate() {
		return rate;
	}

	public String getUserList() throws Exception {
		if (customer.getIdcard() != null)
			customer = operatorManager.getCustomerById(customer.getIdcard());
		else
			customer = operatorManager.getCustomerByName(customer.getName());
		pawncheckSet = operatorManager.getPawncheckByCustomerIDCard(customer);
		return SUCCESS;
	}
}
