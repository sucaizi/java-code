package io.github.sucaizi.springioc.context;

import io.github.sucaizi.springioc.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
	
	protected AbstractBeanFactory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public void refresh() throws Exception{
		
	}

	@Override
	public Object getBean(String name) throws Exception {
		return this.beanFactory.getBean(name);
	}
	
}
