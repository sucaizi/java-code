package io.github.sucaizi.springioc.test;

import static org.junit.Assert.*;
import io.github.sucaizi.springioc.BeanDefinition;
import io.github.sucaizi.springioc.BeanFactory;

import org.junit.Before;
import org.junit.Test;


public class BeanFactoryTest {
	
    private BeanFactory beanFactory = null;
    private HelloWorldService helloWorldService = null;
	
	@Before
	public void setUp() {
		beanFactory = new BeanFactory();
	}

	@Test
	public void test() {

		// 初始化一个bean
		BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
		// 注入bean
	    beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
	    // 获取bean
	    HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
	    // 使用bean
	    helloWorldService.helloWorld();
	}

}
