import java.awt.*;
import java.applet.*;

/*
<applet code="DrawGrid" width=500 height=500>
</applet>
*/

public class DrawGrid extends Applet {

   static void grid(Graphics g, int side) {
      for (int x = 0; x < side; ++x) {
         for (int y = 0; y < side; ++y) {
            g.drawRect(x*side, y*side, side, side);
         }
      }
   }

   public void paint(Graphics g) {
      int s = 30;
      grid(g, s);
   }
}

