package io.github.sucaizi.springioc.test;

import static org.junit.Assert.*;
import io.github.sucaizi.springioc.BeanDefinition;
import io.github.sucaizi.springioc.factory.AutowireCapableBeanFactory;
import io.github.sucaizi.springioc.factory.BeanFactory;

import org.junit.Before;
import org.junit.Test;


public class BeanFactoryTest {
	
    private BeanFactory beanFactory;
    private HelloWorldService helloWorldService;
	
	@Before
	public void setUp() {
		beanFactory = new AutowireCapableBeanFactory();
	}

	@Test
	public void test() {

		// 初始化一个bean
		// 首先创建一个空的bean
		BeanDefinition beanDefinition = new BeanDefinition();
		// 然后设置要实例化的bean的类
		beanDefinition.setBeanClassName("io.github.sucaizi.springioc.test.HelloWorldService");
		// 最后，实例化bean后，注入到hashmap中管理
	    beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
	    // 在hashmap中根据名字获取bean
	    HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
	    // 使用bean
	    helloWorldService.helloWorld();
	}

}
