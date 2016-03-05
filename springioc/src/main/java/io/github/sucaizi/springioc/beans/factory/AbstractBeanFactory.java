package io.github.sucaizi.springioc.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.github.sucaizi.springioc.beans.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	private final List<String> beanDefinitionNames = new ArrayList<String>();

	@Override
	public Object getBean(String name) throws Exception {
		
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if (beanDefinition == null) {
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		}
		Object bean = beanDefinition.getBean();
		if (bean == null) {
			bean = doCreateBean(beanDefinition);
		}
		return bean;
	}

	public void registerBeanDefinition(String name,
			BeanDefinition beanDefinition) throws Exception{
		
		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);
	}
	
	public void preInstantiateSingletons() throws Exception {
		for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}
	// 创建bean的规则下放到子类具体实现
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
