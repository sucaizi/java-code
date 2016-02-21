package io.github.sucaizi.springioc.factory;

import io.github.sucaizi.springioc.BeanDefinition;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	public AutowireCapableBeanFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) {
		try {
			Object bean = beanDefinition.getBeanClass().newInstance();
			return bean;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
