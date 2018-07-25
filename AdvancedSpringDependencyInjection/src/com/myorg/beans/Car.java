package com.myorg.beans;

public class Car {
	private String make;
	private String model;
	
	public Car(String maker, String mod)
	{
		make = maker;
		model = mod;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public void setMake(String val)
	{
		make = val;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String mod)
	{
		model = mod;
	}
	
	public String toString()
	{
		return "Make: " + getMake() + "  Model: " + getModel();
	}
}
