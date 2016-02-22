package io.github.sucaizi.springioc;

import io.github.sucaizi.springioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

	private final Map<String, BeanDefinition> registry;
	private ResourceLoader resourceLoader;
	
	public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		// TODO Auto-generated constructor stub
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
	
	
	

}
