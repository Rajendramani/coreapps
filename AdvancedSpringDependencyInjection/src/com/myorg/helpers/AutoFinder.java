package com.myorg.helpers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myorg.beans.Car;

public class AutoFinder {
	private AutoSearcher as;
	private String make;
	
	public AutoFinder(AutoSearcher autoSearcher)
	{
		as = autoSearcher;
		make = "all";
	}
	
	public String getMake()
	{
		return make;
	}
	
	public void setMake(String m)
	{
		make = m;
	}
	
	public List<Car> carsByMake()
	{
		ArrayList<Car> theCars = as.getAutos();
		if (make.equalsIgnoreCase("all"))
		{
			return theCars.stream().collect(Collectors.toList());
		}
		return theCars.stream().filter(x -> x.getMake().equals(make)).collect(Collectors.toList());
	}
}
