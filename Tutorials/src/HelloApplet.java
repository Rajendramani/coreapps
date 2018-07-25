import java.awt.*;
import java.applet.*;

/*
<applet code="HelloApplet" width=200 height=100>
</applet>
*/

public class HelloApplet extends Applet {
   public void paint(Graphics g) {
      g.drawString("Hello, world!", 40,40);
   }
}