package cn.artern.tools.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cn.artern.tools.MD5.MD5Impl;

public class TestMD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));

		MD5Impl test = (MD5Impl) factory.getBean("MD5");
		System.out.println(test.MD5Password("adminadminadmin"));
		System.out.println(test.MD5Password("guest"));
		System.out.println(test.MD5Password("guest"));
		System.out.println(test.MD5Password("guest"));

	}

}
