package cn.artern.tools.nativeSource;

import java.io.IOException;

public class GetPhysicalAddress {

	public static String execute() {
		try {
			return NetworkInfo.getMacAddress();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
