package com.myorg.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.myorg.beans.*;


public class SystemMessenger {
	public static void main(String[] args)
	{
		ApplicationContext ctxt = 
	             new ClassPathXmlApplicationContext("Beans.xml");

		HelloWorld hw = (HelloWorld) ctxt.getBean("helloWorld");
		hw.getMessage();
	      
		SystemMessage sm = (SystemMessage) ctxt.getBean("sm");
		System.out.println("SYSTEM: " + sm.getMessage());
		
		InjectableMessage im = (InjectableMessage) ctxt.getBean("im");
		System.out.println("Injected At Construction: " + im.getMessage());
		
		AnotherInjectionExample aie = (AnotherInjectionExample) ctxt.getBean("aie");
		System.out.println("Injected Using Setter: " + aie.getMessage());
		
		YetAnotherInjectionExample yaie = (YetAnotherInjectionExample) ctxt.getBean("yaie");
		System.out.println("Injected with default bean: " + yaie.getMessage());
	}
}
