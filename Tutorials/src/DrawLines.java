import java.awt.*;
import java.applet.*;

/*
<applet code="DrawLines" width=300 height=200>
</applet>
*/

public class DrawLines extends Applet {
   public void paint(Graphics g) {
      int x1 = 0;
      int y1 = 100;
      int x2 = 300;
      int y2 = 100;
      g.drawLine(x1,y1,x2,y2);
      x1 = 150;
      y1 = 0;
      x2 = 150;
      y2 = 300;
      g.drawLine(x1,y1,x2,y2);
      x1 = 0;
      y1 = 0;
      x2 = 300;
      y2 = 200;
      g.drawLine(x1,y1,x2,y2);
   }
}