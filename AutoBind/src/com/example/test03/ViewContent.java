package com.example.test03;

import com.autobind.IViewContent;


public class ViewContent implements IViewContent{
	private String id;
	private String type;
	private Object value;
	private String desc;
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public String getType() {
		return this.type;
	}
	@Override
	public Object getValue() {
		return this.value;
	}
	@Override
	public String getDesc() {
		return this.desc;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
