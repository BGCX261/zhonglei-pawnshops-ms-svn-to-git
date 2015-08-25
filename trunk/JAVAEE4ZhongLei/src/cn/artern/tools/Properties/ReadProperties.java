package cn.artern.tools.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class ReadProperties {

	public static Map readProperties(String path) throws IOException {
		Map M = new Hashtable();
		FileInputStream fileIn = null;
		Properties p = new Properties();
		fileIn = new FileInputStream(new File(ReadProperties.class
				.getResource("/")
				+ path));
		p.load(fileIn);
		Set<Entry<Object, Object>> set = p.entrySet();
		for (Map.Entry<Object, Object> m : set) {
			M.put(m.getKey(), m.getValue());
		}
		return M;
	}

}
