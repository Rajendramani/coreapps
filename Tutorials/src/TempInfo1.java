import java.beans.*;

public class TempInfo extends SimpleBeanInfo {
   public PropertyDescriptor[] getPropertyDescriptors() {
      try {
         PropertyDescriptor temp = 
            new PropertyDescriptor("temp", Temperature.class);
         PropertyDescriptor pd[] = {temp};
         return pd;
      }
      catch (Exception e) {
         System.out.println("Exception thrown retrieving properties.");
      }
      return null;
   }
}