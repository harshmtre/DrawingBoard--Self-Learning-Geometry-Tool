import javax.swing.*;
import java.awt.*;

public class IconButton{
  
  JFrame frame = new JFrame("Icon on button");
  JButton button = new JButton("Roseindia.net");
  
  public void paintComponent(Graphics g)
  {
	  g.drawString("hello",10,20);
  }
 
}