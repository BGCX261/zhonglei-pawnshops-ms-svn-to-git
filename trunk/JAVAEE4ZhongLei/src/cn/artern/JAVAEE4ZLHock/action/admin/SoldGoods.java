package cn.artern.JAVAEE4ZLHock.action.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.JAVAEE4ZLHock.service.AdminManager;
import cn.artern.tools.Math.DigitMultiply;

import com.opensymphony.xwork2.Action;

public class SoldGoods implements Action {
	private AdminManager adminManager;
	private Map<Integer, String> goodsMap = new HashMap();
	private String pawncheck_id;

	public String getPawncheck_id() {
		return pawncheck_id;
	}

	public void setPawncheck_id(String pawncheck_id) {
		this.pawncheck_id = pawncheck_id;
	}

	public Map<Integer, String> getGoodsMap() {
		return goodsMap;
	}

	private Object[] value;

	public Object[] getValue() {
		return value;
	}

	public void setValue(Object[] value) {
		this.value = value;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		goodsMap.clear();
		return SUCCESS;
	}

	public String getByPawncheck() throws Exception {
		goodsMap.clear();
		List<Object[]> goods = adminManager.getGoodsByPawncheckID(pawncheck_id);
		for (Object[] o : goods) {
			goodsMap.put((Integer) o[0], (String) o[1] + "\t数量:"
					+ (Integer) o[5] + "\t总值:"
					+ DigitMultiply.twoDigitMultiply((Float) o[3], 1.00)
					+ "\t\t折当率:" + (Float) o[4] + "\t状态：" + (String) o[6]);
		}
		value = goodsMap.keySet().toArray();
		return SUCCESS;
	}

	public String getByStatus() throws Exception {
		goodsMap.clear();
		List<Goods> list = adminManager.getGoodsByStatus("AfterEndDay");
		for (int i = 0; i < list.size(); i++) {
			goodsMap.put(list.get(i).getId(), "当票号："
					+ list.get(i).getPawncheck().getId() + "\t\t当品："
					+ list.get(i).getLoan().getLoan_name() + "\t\t总值:"
					+ list.get(i).getTotal());
		}
		value = goodsMap.keySet().toArray();
		return SUCCESS;
	}

	public String doSold() throws Exception {
		for (Object v : value) {
			System.out.println(v.toString());
			adminManager.soldGoods(Integer.parseInt(v.toString()));
		}
		return SUCCESS;
	}

	public String blank() throws Exception {
		adminManager.setPawncheckBlack(pawncheck_id);
		return SUCCESS;
	}

}
