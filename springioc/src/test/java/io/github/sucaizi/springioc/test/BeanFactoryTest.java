package io.github.sucaizi.springioc.test;

import java.util.Map;

import io.github.sucaizi.springioc.beans.BeanDefinition;
import io.github.sucaizi.springioc.beans.PropertyValue;
import io.github.sucaizi.springioc.beans.PropertyValues;
import io.github.sucaizi.springioc.beans.factory.AbstractBeanFactory;
import io.github.sucaizi.springioc.beans.factory.AutowireCapableBeanFactory;
import io.github.sucaizi.springioc.beans.factory.BeanFactory;
import io.github.sucaizi.springioc.beans.io.ResourceLoader;
import io.github.sucaizi.springioc.beans.xml.XmlBeanDefinitionReader;

import org.junit.Before;
import org.junit.Test;


public class BeanFactoryTest {
	
	 	@Test
	    public void testLazy() throws Exception {
	        // 1.读取配置
	        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
	        xmlBeanDefinitionReader.loadBeanDefinitions("springioc.xml");
	
	        // 2.初始化BeanFactory并注册bean
	        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
	        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
	            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
	        }
	
	        // 3.获取bean
	        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
	        helloWorldService.helloWorld();
	    }

		@Test
		public void testPreInstantiate() throws Exception {
			// 1.读取配置
			XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
			xmlBeanDefinitionReader.loadBeanDefinitions("springioc.xml");

			// 2.初始化BeanFactory并注册bean
			AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
			for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
				beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
			}

	        // 3.初始化bean
	        beanFactory.preInstantiateSingletons();

			// 4.获取bean
			HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
			helloWorldService.helloWorld();
		}
}
