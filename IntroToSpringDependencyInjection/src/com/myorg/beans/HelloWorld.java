package com.myorg.beans;

public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("From Hello World: " + message);
   }
}
