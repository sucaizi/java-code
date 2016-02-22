package io.github.sucaizi.springioc;

public interface BeanDefinitionReader {
	
	void loadBeanDefinitions(String location) throws Exception;

}
