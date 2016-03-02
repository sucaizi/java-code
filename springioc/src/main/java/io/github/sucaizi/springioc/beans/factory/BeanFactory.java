package io.github.sucaizi.springioc.beans.factory;

import io.github.sucaizi.springioc.beans.BeanDefinition;

public interface BeanFactory {

	public Object getBean(String name) throws Exception;
	
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
