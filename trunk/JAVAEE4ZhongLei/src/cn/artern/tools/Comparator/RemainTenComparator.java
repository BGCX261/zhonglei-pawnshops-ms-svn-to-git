package cn.artern.tools.Comparator;

import java.util.Comparator;

public class RemainTenComparator implements Comparator<String[]> {

	public int compare(String[] o1, String[] o2) {
		// TODO Auto-generated method stub
		String pId1 = o1[0];
		String pId2 = o2[0];
		if (Integer.parseInt(pId1) % 10 > Integer.parseInt(pId2) % 10)
			return 1;
		else if (Integer.parseInt(pId1) % 10 < Integer.parseInt(pId2) % 10)
			return -1;
		else
			return 0;
	}

}
