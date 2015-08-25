package cn.artern.tools.test;

import cn.artern.tools.String.FillStringBetweenNum;

public class TestFillString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (String s : FillStringBetweenNum.fillFromStart2End("0090", "0105")) {
			System.out.println(s);
		}

	}

}
