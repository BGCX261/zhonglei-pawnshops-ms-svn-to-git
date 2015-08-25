package cn.artern.tools.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class EasyDate {

	public static String getDateAndTime(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(date);
	}

	public static String getDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	public static int getBetweenDayNumber(Date d1, Date d2) {
		long dayNumber = 0;
		long DAY = 24L * 60L * 60L * 1000L;
		try {
			dayNumber = (d2.getTime() - d1.getTime()) / DAY;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int) dayNumber + 1;
	}

	public static int getDays(Date d1, Date d2) {

		GregorianCalendar g1 = new GregorianCalendar();
		g1.setGregorianChange(d1);
		GregorianCalendar g2 = new GregorianCalendar();
		g1.setGregorianChange(d2);

		return getDays(g1, g2);

	}

	public static int getMonths(Date d1, Date d2) {
		GregorianCalendar g1 = new GregorianCalendar();
		g1.setGregorianChange(d1);
		GregorianCalendar g2 = new GregorianCalendar();
		g1.setGregorianChange(d2);
		return getMonths(g1, g2);
	}

	public static int getDays(GregorianCalendar g1, GregorianCalendar g2) {
		int elapsed = 0;
		GregorianCalendar gc1, gc2;

		if (g2.after(g1)) {
			gc2 = (GregorianCalendar) g2.clone();
			gc1 = (GregorianCalendar) g1.clone();
		} else {
			gc2 = (GregorianCalendar) g1.clone();
			gc1 = (GregorianCalendar) g2.clone();
		}

		gc1.clear(Calendar.MILLISECOND);

		gc1.clear(Calendar.SECOND);

		gc1.clear(Calendar.MINUTE);

		gc1.clear(Calendar.HOUR_OF_DAY);

		gc2.clear(Calendar.MILLISECOND);
		gc2.clear(Calendar.SECOND);
		gc2.clear(Calendar.MINUTE);
		gc2.clear(Calendar.HOUR_OF_DAY);

		while (gc1.before(gc2)) {

			gc1.add(Calendar.DATE, 1);
			elapsed++;
		}
		return elapsed;
	}

	public static int getMonths(GregorianCalendar g1, GregorianCalendar g2) {
		int elapsed = 0;
		GregorianCalendar gc1, gc2;

		if (g2.after(g1)) {
			gc2 = (GregorianCalendar) g2.clone();
			gc1 = (GregorianCalendar) g1.clone();
		} else {
			gc2 = (GregorianCalendar) g1.clone();
			gc1 = (GregorianCalendar) g2.clone();
		}

		gc1.clear(Calendar.MILLISECOND);
		gc1.clear(Calendar.SECOND);
		gc1.clear(Calendar.MINUTE);
		gc1.clear(Calendar.HOUR_OF_DAY);
		gc1.clear(Calendar.DATE);

		gc2.clear(Calendar.MILLISECOND);
		gc2.clear(Calendar.SECOND);
		gc2.clear(Calendar.MINUTE);
		gc2.clear(Calendar.HOUR_OF_DAY);
		gc2.clear(Calendar.DATE);

		while (gc1.before(gc2)) {
			gc1.add(Calendar.MONTH, 1);
			elapsed++;
		}
		if (elapsed == 0)
			elapsed = 1;
		return elapsed;
	}

	public static Date[] getDateMonthMaxAndMinDate(Date date) {

		java.text.SimpleDateFormat formater1 = new java.text.SimpleDateFormat(
				"yyyy-MM-01");

		String re1 = formater1.format(date);

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		java.text.SimpleDateFormat formater2 = new java.text.SimpleDateFormat(
				"yyyy-MM-" + maxDay);

		java.text.SimpleDateFormat formater3 = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");

		String re0 = formater2.format(date);

		return new Date[] { formater3.parse(re0, new ParsePosition(0)),
				formater3.parse(re1, new ParsePosition(0)) };

	}

	public static List<String> getEveryDayOfMonth(String date) throws Exception {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(
				"yyyy-MM");
		Date d = formater.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= maxDay; i++) {
			list.add(date + "-" + i);
		}
		return list;
	}

	public static Date getEndDate(Date date, int month) {
		Date dateTemp = date;
		Calendar cal = Calendar.getInstance();
		int maxDay;
		cal.setTime(dateTemp);
		for (int i = 1; i <= month; i++) {
			maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.add(Calendar.DAY_OF_MONTH, maxDay);
			System.out.println(maxDay);
			System.out.println(cal);
		}
		return cal.getTime();
	}

	public static Date getDateWithoutTime(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
