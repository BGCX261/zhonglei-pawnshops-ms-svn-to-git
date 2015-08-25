package cn.artern.JAVAEE4ZLHock.action.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.artern.JAVAEE4ZLHock.model.Customer;
import cn.artern.JAVAEE4ZLHock.model.Goods;
import cn.artern.JAVAEE4ZLHock.model.Loan;
import cn.artern.JAVAEE4ZLHock.model.Pawncheck;
import cn.artern.JAVAEE4ZLHock.model.Record;
import cn.artern.JAVAEE4ZLHock.service.AdminManager;
import cn.artern.tools.Comparator.RemainTenComparator;
import cn.artern.tools.Date.EasyDate;

import com.opensymphony.xwork2.Action;

public class GetTable implements Action {
	private AdminManager adminManager;
	private String date;
	private List<String[]> temp = new ArrayList<String[]>();
	private Map<String, String[]> temp_ = new HashMap<String, String[]>();
	private List<String> temp__ = new ArrayList<String>();
	private List<String[]> newGoods = new ArrayList<String[]>();
	private List<String[]> newRecode = new ArrayList<String[]>();
	private List<String[]> newOthers = new ArrayList<String[]>();
	private String choosDay;
	private String status;

	public List<String[]> getNewGoods() {
		return newGoods;
	}

	public List<String[]> getNewRecode() {
		return newRecode;
	}

	public List<String[]> getNewOthers() {
		return newOthers;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, String[]> getTemp_() {
		return temp_;
	}

	public List<String[]> getTemp() {
		return temp;
	}

	public void setTemp(List<String[]> temp) {
		this.temp = temp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String getTable1() throws Exception {
		temp = new ArrayList<String[]>();
		List<Goods> list = adminManager.findAllGoods();
		for (int i = 0; i < list.size(); i++) {
			String stringArr[] = new String[5];
			if (list.get(i).getStatus().equals("BeforeEndDay"))
				stringArr[4] = "仍在当期";
			else if (list.get(i).getStatus().equals("AfterEndDay"))
				stringArr[4] = "已过当期";
			else
				continue;
			stringArr[1] = list.get(i).getLoan().getLoan_name();
			stringArr[0] = list.get(i).getPawncheck().getId();
			stringArr[2] = list.get(i).getVal().toString();
			stringArr[3] = list.get(i).getTotal() + "";
			temp.add(stringArr);
		}
		Comparator comp = new RemainTenComparator();
		Collections.sort(temp, comp);
		return SUCCESS;
	}

	public String getTable2() throws Exception {
		Pawncheck p;
		Customer c;
		temp = new ArrayList<String[]>();
		List<Goods> list = adminManager.findAllGoods();
		for (int i = 0; i < list.size(); i++) {
			String stringArr[] = new String[8];
			if (list.get(i).getStatus().equals("BeforeEndDay"))
				stringArr[7] = "仍在当期";
			else if (list.get(i).getStatus().equals("AfterEndDay"))
				stringArr[7] = "已过当期";
			else if (list.get(i).getStatus().equals("BeSold"))
				stringArr[7] = "绝当";
			else if (list.get(i).getStatus().equals("Redeemed"))
				stringArr[7] = "赎当";
			else if (list.get(i).getStatus().equals("Black"))
				stringArr[7] = "作废";
			else
				stringArr[7] = "数据错误";
			stringArr[5] = list.get(i).getLoan().getLoan_name();
			p = list.get(i).getPawncheck();
			System.out.println(p.getId());
			p = adminManager.getPawncheckById(p.getId());
			c = p.getCustomer();
			stringArr[1] = p.getId();
			stringArr[0] = EasyDate.getDate(list.get(i).getIndate());
			stringArr[2] = c.getName();
			stringArr[3] = c.getAddress();
			stringArr[4] = c.getIdcard();
			stringArr[6] = list.get(i).getTotal() + "";
			temp.add(stringArr);
		}
		return SUCCESS;
	}

	public String getTable3() throws Exception {

		temp_ = new HashMap<String, String[]>();
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Date date_;
		if (date != null && !date.equals(""))
			date_ = df.parse(date);
		else
			date_ = EasyDate.getDateWithoutTime(new Date());
		List<Goods> list = adminManager.getGoodsByDate(date_);
		int m[] = { 0, 0, 0, 0, 0, 0 };
		float n[] = { 0, 0, 0, 0, 0, 0 };
		int loan_class;
		for (int i = 0; i < list.size(); i++) {
			loan_class = Integer.parseInt(list.get(i).getLoan().getLoan_class()
					.getClass_type().split(" ")[0]);
			m[loan_class]++;
			n[loan_class] += list.get(i).getTotal();
		}
		String s1[] = { m[0] + "", n[0] + "" };
		String s2[] = { m[1] + "", n[1] + "" };
		String s3[] = { m[2] + "", n[2] + "" };
		String s4[] = { m[3] + "", n[3] + "" };
		String s5[] = { m[4] + "", n[4] + "" };
		String s6[] = { m[5] + "", n[5] + "" };
		temp_.put("饰品", s1);
		temp_.put("房产", s2);
		temp_.put("服装", s3);
		temp_.put("机动车", s4);
		temp_.put("其他", s5);
		temp_.put("五交", s6);
		return SUCCESS;
	}

	/*
	 * public String getTablex() throws Exception { temp__=new
	 * ArrayList<String>(); DateFormat df = new SimpleDateFormat("yyyy-MM");
	 * Date date_; if(date!=null&&!date.equals("")) date_=df.parse(date); else
	 * date_=new Date(); List<String> list= EasyDate.getEveryDayOfMonth(date);
	 * String tmp; List<Goods> goodsSet; int loan_class; if(!date.equals(""))
	 * date_=df.parse(date); else date_=new Date(); for(String s:list){
	 * tmp="<td>"+s+"</td>"; goodsSet=adminManager.getGoodsByReDate(date_);
	 * for(Goods g:goodsSet){ int m1[]={0,0,0,0,0,0}; float n1[]={0,0,0,0,0,0};
	 * int m2[]={0,0,0,0,0,0}; float n2[]={0,0,0,0,0,0}; float
	 * n3[]={0,0,0,0,0,0}; float n4[]={0,0,0,0,0,0};
	 * loan_class=Integer.parseInt(
	 * g.getLoan().getLoan_class().getClass_type().split(" ")[0]);
	 * if(g.getRedate().equals(g.getIndate())){ m1[loan_class]++;
	 * n1[loan_class]+=g.getTotal(); n3[loan_class]+=g.getTotal()g.getRate(); }
	 * else{ m2[loan_class]++; n2[loan_class]+=g.getTotal(); n3[loan_class]+=0;
	 * } } } return SUCCESS; }
	 */
	public String getTable4() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date_;
		if (!choosDay.equals(""))
			date_ = df.parse(choosDay);
		else
			date_ = EasyDate.getDateWithoutTime(new Date());
		List<Goods> list = adminManager.getGoodsByDay(date_);
		Pawncheck p;
		Loan l;
		Customer c;
		newGoods = new ArrayList<String[]>();
		for (Goods g : list) {
			String s[] = new String[8];
			l = g.getLoan();
			p = adminManager.getPawncheckById(g.getPawncheck().getId());
			c = p.getCustomer();
			s[0] = p.getId();
			s[1] = c.getName();
			s[2] = c.getIdcard();
			s[3] = EasyDate.getDate(g.getIndate());
			s[4] = String.format("%d月", g.getDuration());
			s[5] = EasyDate.getDate(g.getRedate());
			s[6] = String.format("%.2f", g.getTotal());
			s[7] = String.format("%.2f", g.getServetip());
			newGoods.add(s);
		}
		list = adminManager.getGoodsByReDate(date_);
		newOthers = new ArrayList<String[]>();
		for (Goods g : list) {
			String s[] = new String[8];
			l = g.getLoan();
			p = adminManager.getPawncheckById(g.getPawncheck().getId());
			c = p.getCustomer();
			s[0] = p.getId();
			s[1] = c.getName();
			s[2] = c.getIdcard();
			s[3] = EasyDate.getDate(g.getIndate());
			s[4] = String.format("%d月", g.getDuration());
			s[5] = EasyDate.getDate(g.getRedate());
			s[6] = String.format("%.2f", g.getTotal());
			if (g.getStatus().equals("AfterEndDay"))
				s[7] = "已过当期";
			else if (g.getStatus().equals("BeSold"))
				s[7] = "绝当";
			else if (g.getStatus().equals("Redeemed"))
				s[7] = "赎当";
			else if (g.getStatus().equals("BeforeEndDay"))
				s[7] = "仍在当期";
			else if (g.getStatus().equals("Black"))
				s[7] = "作废";
			else
				s[7] = "数据错误";
			newOthers.add(s);
		}
		newRecode = new ArrayList<String[]>();
		List<Record> list2 = adminManager.getRecordkByDay(date_);
		Goods g;
		for (Record r : list2) {
			String s[] = new String[4];
			p = r.getPawncheck();
			g = (Goods) p.getGoods().toArray()[0];
			s[0] = p.getId();
			s[1] = EasyDate.getDate(g.getRedate());
			s[2] = String.format("%.2f", g.getTotal());
			s[3] = String.format("%.2f", r.getServetip());
			newRecode.add(s);
		}
		return SUCCESS;
	}

	public void setChoosDay(String choosDay) {
		this.choosDay = choosDay;
	}

	public String getTable5() throws Exception {
		List<Goods> list = adminManager.getGoodsByStatus(status);
		Pawncheck p;
		Loan l;
		Customer c;
		temp = new ArrayList<String[]>();
		for (Goods g : list) {
			String s[] = new String[8];
			l = g.getLoan();
			p = adminManager.getPawncheckById(g.getPawncheck().getId());
			c = p.getCustomer();
			s[0] = p.getId();
			s[1] = c.getName();
			s[2] = c.getIdcard();
			s[3] = EasyDate.getDate(g.getIndate());
			s[4] = String.format("%d月", g.getDuration());
			s[5] = EasyDate.getDate(g.getRedate());
			s[6] = String.format("%.2f", g.getTotal());
			if (g.getStatus().equals("BeforeEndDay"))
				s[7] = "仍在当期";
			else if (g.getStatus().equals("AfterEndDay"))
				s[7] = "已过当期";
			else if (g.getStatus().equals("BeSold"))
				s[7] = "绝当";
			else if (g.getStatus().equals("Redeemed"))
				s[7] = "赎当";
			else if (g.getStatus().equals("Black"))
				s[7] = "作废";
			else
				s[7] = "数据错误";
			temp.add(s);
		}
		System.out.println(temp.size());
		return SUCCESS;
	}

	public String getChoosDay() {
		return choosDay;
	}
}
