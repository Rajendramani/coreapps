import java.awt.*;
import java.applet.*;

/*
<applet code="Colors" width=300 height=200>
</applet>
*/

public class Colors extends Applet {
   public void paint(Graphics g) {
      /*Color color1 = new Color(178,34,34);
      g.setColor(color1);
      int x1 = 0;
      int y1 = 100;
      int x2 = 300;
      int y2 = 100;
      g.drawLine(x1,y1,x2,y2);
      g.setColor(Color.red);
      int x1 = 30;
      int y1 = 30;
      int x2 = 60;
      int y2 = 50;
      g.fillRect(x1,y1,x2,y2);*/
      g.setColor(Color.green);
      int x1 = 80;
      int y1 = 80;
      int x2 = 100;
      int y2 = 100;
      g.fillOval(x1,y1,x2,y2);
      /*x1 = 200;
      y1 = 60;
      x2 = 60;
      y2 = 60;
      g.drawArc(x1,y1,x2,y2,0,180); */
   }
}