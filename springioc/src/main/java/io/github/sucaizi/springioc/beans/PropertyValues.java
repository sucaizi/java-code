package io.github.sucaizi.springioc.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	
	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

	public PropertyValues() {
		// TODO Auto-generated constructor stub
	}

	public List<PropertyValue> getPropertyValueList() {
		return propertyValueList;
	}
	
	public void addPropertyValue(PropertyValue pv) {
		this.propertyValueList.add(pv);
	}

}
