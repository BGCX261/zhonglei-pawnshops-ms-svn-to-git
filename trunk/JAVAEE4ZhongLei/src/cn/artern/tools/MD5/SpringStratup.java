package cn.artern.tools.MD5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStratup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MD5Impl test = (MD5Impl) context.getBean("MD5");
		System.out.println(test.MD5Password("guest"));
	}

}
