package io.github.sucaizi.springioc.factory;

import io.github.sucaizi.springioc.BeanDefinition;

public interface BeanFactory {

	public Object getBean(String name);
	
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
