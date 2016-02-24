package io.github.sucaizi.springioc.test;

import java.util.Map;

import io.github.sucaizi.springioc.BeanDefinition;
import io.github.sucaizi.springioc.PropertyValue;
import io.github.sucaizi.springioc.PropertyValues;
import io.github.sucaizi.springioc.factory.AutowireCapableBeanFactory;
import io.github.sucaizi.springioc.factory.BeanFactory;
import io.github.sucaizi.springioc.io.ResourceLoader;
import io.github.sucaizi.springioc.xml.XmlBeanDefinitionReader;

import org.junit.Before;
import org.junit.Test;


public class BeanFactoryTest {
	
    private BeanFactory beanFactory;
    private HelloWorldService helloWorldService;
    private XmlBeanDefinitionReader xmlbeanDefinitionReader;
	
	@Before
	public void setUp() throws Exception {
		xmlbeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());		
		beanFactory = new AutowireCapableBeanFactory();		
	}

	@Test
	public void test() throws Exception {

		xmlbeanDefinitionReader.loadBeanDefinitions("springioc.xml");
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlbeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	    HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");    
	    helloWorldService.helloWorld();
	}

}
