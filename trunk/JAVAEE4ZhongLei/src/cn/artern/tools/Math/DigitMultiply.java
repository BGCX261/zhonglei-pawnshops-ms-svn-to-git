package cn.artern.tools.Math;

import java.text.DecimalFormat;

public class DigitMultiply {

	public static Double twoDigitMultiply(double x, double y) {
		DecimalFormat fnum = new DecimalFormat("##0.00");
		return Double.parseDouble(fnum.format(x * y));
	}

}
