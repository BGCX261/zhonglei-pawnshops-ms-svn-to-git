package cn.artern.tools.String;

import java.util.ArrayList;
import java.util.List;

public class FillStringBetweenNum {

	public static List<String> fillFromStart2End(String start, String end) {

		int digit = start.length();

		long startL = Long.parseLong(start);
		long endL = Long.parseLong(end);

		ArrayList<String> list = new ArrayList<String>();

		String formater = "%0" + digit + "d";
		for (long i = startL; i <= endL; i++) {
			list.add(String.format(formater, i));
		}

		return list;

	}

}
