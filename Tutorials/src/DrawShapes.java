import java.awt.*;
import java.applet.*;

/*
<applet code="DrawShapes" width=300 height=200>
</applet>
*/

public class DrawShapes extends Applet {
   public void paint(Graphics g) {
      int x1 = 30;
      int y1 = 30;
      int x2 = 60;
      int y2 = 50;
      g.drawRect(x1,y1,x2,y2);
      x1 = 80;
      y1 = 80;
      x2 = 100;
      y2 = 100;
      g.drawOval(x1,y1,x2,y2);
      x1 = 200;
      y1 = 60;
      x2 = 60;
      y2 = 60;
      g.drawArc(x1,y1,x2,y2,0,180); 
   }
}