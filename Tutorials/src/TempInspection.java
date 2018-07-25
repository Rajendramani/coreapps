import java.beans.*;

public class TempInspection {
   public static void main(String[] args) {
      try {
         Class cl = Class.forName("Temperature");
         BeanInfo beanInfo = Introspector.getBeanInfo(cl);
         System.out.println("Properties of Temperature class: ");
         PropertyDescriptor propertyDescriptor[] = 
            beanInfo.getPropertyDescriptors();
         for (int i = 0; i < propertyDescriptor.length; i++) {
            System.out.println(propertyDescriptor[i].getName());
         }
         System.out.println();
         System.out.println("Methods of Temperature class: ");
         MethodDescriptor methodDescriptor[] = 
            beanInfo.getMethodDescriptors();
         for (int i = 0; i < methodDescriptor.length; i++) {
            System.out.println(methodDescriptor[i].getName());
         }
      }
      catch (Exception e) {
         System.out.println("Exception thrown.");
      }
   }
}