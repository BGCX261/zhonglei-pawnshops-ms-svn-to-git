package cn.artern.tools.MD5;

import java.security.MessageDigest;
import cn.artern.tools.Interface.MD5;
import cn.artern.tools.Interface.SecString;

public class MD5Impl implements MD5 {

	/**
	 * @param args
	 */

	private SecString secString;

	public void setSecString(SecString secString) {
		this.secString = secString;
	}

	public String MD5Password(String rStr) {
		try {
			char hexDigits[] = secString.toString().toCharArray();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(rStr.getBytes());
			byte[] md1 = md.digest();
			int j = md1.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md1[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
