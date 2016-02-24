package io.github.sucaizi.springioc.test.xml;

import static org.junit.Assert.*;

import java.util.Map;

import io.github.sucaizi.springioc.BeanDefinition;
import io.github.sucaizi.springioc.io.ResourceLoader;
import io.github.sucaizi.springioc.xml.XmlBeanDefinitionReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XmlBeanDefinitionReaderTest {
	
	private XmlBeanDefinitionReader xmlBeanDefinitionReader;

	@Before
	public void setUp() throws Exception {
		xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
	}

	@Test
	public void test() throws Exception {
		xmlBeanDefinitionReader.loadBeanDefinitions("springioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}

}
