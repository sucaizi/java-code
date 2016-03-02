package io.github.sucaizi.springioc.beans.factory;

import java.lang.reflect.Field;

import io.github.sucaizi.springioc.beans.BeanDefinition;
import io.github.sucaizi.springioc.BeanReference;
import io.github.sucaizi.springioc.beans.PropertyValue;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	public AutowireCapableBeanFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstance(beanDefinition);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
		return beanDefinition.getBeanClass().newInstance();
	}
	
	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		for(PropertyValue propertyValue: mbd.getPropertyValues().getPropertyValueList()) {
			Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
			declareField.setAccessible(true);
			
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference)value;
				value = getBean(beanReference.getName());
			}
			declareField.set(bean, value);
		}
	}
}
