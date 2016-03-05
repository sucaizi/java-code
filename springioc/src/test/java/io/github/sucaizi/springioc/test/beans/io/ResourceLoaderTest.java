package io.github.sucaizi.springioc.test.beans.io;

import java.io.InputStream;

import io.github.sucaizi.springioc.beans.io.Resource;
import io.github.sucaizi.springioc.beans.io.ResourceLoader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResourceLoaderTest {

	@Test
	public void test() throws Exception {
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.getResource("springioc.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
	}

}
