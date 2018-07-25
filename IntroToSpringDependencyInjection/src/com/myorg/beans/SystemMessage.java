package com.myorg.beans;

public class SystemMessage {
	private String message = "The System is up and running";
	
	public String getMessage(){
		return message;
	}

	public void setMessage(String msg) {
		message = msg;
	}
}
