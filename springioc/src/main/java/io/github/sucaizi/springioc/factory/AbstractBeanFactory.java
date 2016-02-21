package io.github.sucaizi.springioc.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.github.sucaizi.springioc.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	public AbstractBeanFactory() {
	}

	@Override
	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}

	@Override
	public void registerBeanDefinition(String name,
			BeanDefinition beanDefinition) throws Exception{
		Object bean = doCreateBean(beanDefinition);
		beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);
	}
	// 创建bean的规则下放到子类具体实现
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
