package io.github.sucaizi.springioc.beans;

public class PropertyValue {

	private final String name;
	private final Object value;
	
	public PropertyValue(String name, Object value) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	

}
