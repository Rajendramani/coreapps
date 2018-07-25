package com.myorg.app;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myorg.beans.Car;
import com.myorg.helpers.AutoFinder;
import com.myorg.helpers.JSONAutoSearcher;
import com.myorg.helpers.PipeDelimitedTextAutoSearcher;

public class driver {

	public static String JSONPath = "G:\\DevArena\\EclipseLuna\\MoreSpringIOC\\src\\CarsOnTheLot.json";
	public static String txtPath = "G:\\DevArena\\EclipseLuna\\MoreSpringIOC\\src\\CarsOnTheLot.txt";
	public static void main(String[] args)
	{
		/*
		//test cars from both files - old way no Dependency Injection:
		JSONAutoSearcher jsas = new JSONAutoSearcher(JSONPath);
		AutoFinder af1 = new AutoFinder(jsas);
		af1.setMake("Ford");
		
		PipeDelimitedTextAutoSearcher pdt = new PipeDelimitedTextAutoSearcher(txtPath);
		AutoFinder af2 = new AutoFinder(pdt);
		af2.setMake("Chevy");
		*/
		
		//using IOC -> Dependency Injection
		ApplicationContext ctxt = 
	             new ClassPathXmlApplicationContext("Beans.xml");
		AutoFinder af1 = (AutoFinder) ctxt.getBean("af1");
		AutoFinder af2 = (AutoFinder) ctxt.getBean("af2");
		
		
		ArrayList<Car> cars1 = (ArrayList<Car>) af1.carsByMake();
		cars1.forEach(x -> System.out.println("Next Car: " + x));
		
		ArrayList<Car> cars2 = (ArrayList<Car>) af2.carsByMake();
		cars2.forEach(x -> System.out.println("Next Car: " + x));
	}
}
