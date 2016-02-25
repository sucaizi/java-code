package io.github.sucaizi.springioc.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import io.github.sucaizi.springioc.AbstractBeanDefinitionReader;
import io.github.sucaizi.springioc.BeanDefinition;
import io.github.sucaizi.springioc.BeanReference;
import io.github.sucaizi.springioc.PropertyValue;
import io.github.sucaizi.springioc.io.ResourceLoader;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	@Override
	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}
	
	
	protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document doc = documentBuilder.parse(inputStream);
		registerBeanDefinitions(doc);
		inputStream.close();
		
	}
	
	protected void registerBeanDefinitions(Document doc){
		Element root = doc.getDocumentElement();
		parseBeanDefinitions(root);
	}
	
	protected void parseBeanDefinitions(Element root) {
		NodeList nl = root.getChildNodes();
		
		for(int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node instanceof Element) {
				Element element = (Element) node;
				processBeanDefinition(element);
			}
		}
	}
	
	protected void processBeanDefinition(Element element){
		String name = element.getAttribute("name");
		String className = element.getAttribute("class");
		
		BeanDefinition beanDefinition = new BeanDefinition();
		processProperty(element, beanDefinition);
		beanDefinition.setBeanClassName(className);
		getRegistry().put(name, beanDefinition);
	}
	
	private void processProperty(Element element, BeanDefinition beanDefinition) {
		NodeList propertyNode = element.getElementsByTagName("property");
		for (int i = 0; i < propertyNode.getLength(); i++) {
			Node node = propertyNode.item(i);
			
			if (node instanceof Element) {
				Element propertyElement = (Element)node;
				String name = propertyElement.getAttribute("name");
				String value = propertyElement.getAttribute("value");
				if (value != null && value.length() > 0) {
				    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				} else {
					String ref = propertyElement.getAttribute("ref");
					
					if (ref == null && ref.length() == 0) {
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
			}
		}
	}

}
