package com.autobind;

public class Control {
	public Control(Integer id,ControlHandler handler)
	{
		ID = id;
		Handler = handler;
	}
	
	public Integer ID;
	
	public ControlHandler Handler;
}
