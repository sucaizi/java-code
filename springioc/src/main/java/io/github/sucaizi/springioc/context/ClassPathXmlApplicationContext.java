package io.github.sucaizi.springioc.context;

import java.util.Map.Entry;

import io.github.sucaizi.springioc.beans.BeanDefinition;
import io.github.sucaizi.springioc.beans.factory.AbstractBeanFactory;
import io.github.sucaizi.springioc.beans.factory.AutowireCapableBeanFactory;
import io.github.sucaizi.springioc.beans.io.ResourceLoader;
import io.github.sucaizi.springioc.beans.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;
	
	public ClassPathXmlApplicationContext(String configLocation) throws Exception{
		this(configLocation, new AutowireCapableBeanFactory());
	}
	
	public ClassPathXmlApplicationContext(String configLocation, 
			AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}

	@Override
	public void registerBeanDefinition(String name,
			BeanDefinition beanDefinition) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
