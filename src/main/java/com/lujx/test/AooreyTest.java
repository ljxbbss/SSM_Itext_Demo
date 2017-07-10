package com.lujx.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.lujx.service.TestBean;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年6月22日
 */
public class AooreyTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"spring-applicationContext.xml"));
		TestBean bean = (TestBean) factory.getBean("testBean");
		bean.test();

	}

}
