package io.github.sucaizi.springioc.test.io;

import java.io.InputStream;

import io.github.sucaizi.springioc.io.Resource;
import io.github.sucaizi.springioc.io.ResourceLoader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResourceLoaderTest {
	
	private ResourceLoader resourceLoader; 

	@Before
	public void setUp() throws Exception {
		resourceLoader = new ResourceLoader();
	}

	@Test
	public void test() throws Exception {
		Resource resource = resourceLoader.getResource("springioc.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
	}

}
