package io.github.sucaizi.springioc.beans;

public interface BeanDefinitionReader {
	
	void loadBeanDefinitions(String location) throws Exception;
}
