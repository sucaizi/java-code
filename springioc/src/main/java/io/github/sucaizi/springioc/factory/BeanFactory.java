package io.github.sucaizi.springioc.factory;

import io.github.sucaizi.springioc.BeanDefinition;

public interface BeanFactory {

	public Object getBean(String name) throws Exception;
	
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
