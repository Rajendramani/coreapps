package com.myorg.beans;

public class InjectableMessage 
{
	private String message = null;
	
	public InjectableMessage(String msg) {
		message = msg;
	}
	
	public String getMessage(){
		return message;
	}

	public void setMessage(String msg) {
		message = msg;
	}
}
