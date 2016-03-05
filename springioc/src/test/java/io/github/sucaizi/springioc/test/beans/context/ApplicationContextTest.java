package io.github.sucaizi.springioc.test.beans.context;

import io.github.sucaizi.springioc.context.ApplicationContext;
import io.github.sucaizi.springioc.context.ClassPathXmlApplicationContext;
import io.github.sucaizi.springioc.test.HelloWorldService;

import org.junit.Test;

public class ApplicationContextTest {

	@Test
	public void test() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

}
