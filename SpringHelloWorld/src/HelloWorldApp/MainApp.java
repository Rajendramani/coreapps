package HelloWorldApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext ctxt = 
             new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld hw = (HelloWorld) ctxt.getBean("helloWorld");
      hw.getMessage();
   }
}
