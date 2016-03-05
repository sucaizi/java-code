package io.github.sucaizi.springioc.test.beans.xml;

import static org.junit.Assert.*;

import java.util.Map;

import io.github.sucaizi.springioc.beans.BeanDefinition;
import io.github.sucaizi.springioc.beans.io.ResourceLoader;
import io.github.sucaizi.springioc.beans.xml.XmlBeanDefinitionReader;

import org.junit.Assert;
import org.junit.Test;

public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("springioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}

}
