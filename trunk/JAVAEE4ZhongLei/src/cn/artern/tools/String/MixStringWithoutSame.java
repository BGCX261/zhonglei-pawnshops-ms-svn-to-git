package cn.artern.tools.String;

public class MixStringWithoutSame {

	public static String execute(String string1, String string2) {

		String s = string1 + string2;
		int i;
		String tmp;
		for (i = 0; i <= s.length() / 2; i++) {
			tmp = s.charAt(i) + "";
			s = s.replaceFirst(tmp, "~");
			s = s.replaceAll(tmp, "");
			s = s.replaceFirst("~", tmp);
		}

		return s;
	}

}
