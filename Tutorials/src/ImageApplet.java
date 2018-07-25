import java.awt.*;
import java.applet.*;

/*
<applet code="ImageApplet" width=400 height=350>
</applet>
*/

public class ImageApplet extends Applet {

   private Image anImage;

   public void init() {
      anImage = Toolkit.getDefaultToolkit().getImage("Java.jpg");
   }

   public void paint(Graphics g) {
      g.drawImage(anImage, 50, 25, this);
      showStatus("image loaded");
   }
}