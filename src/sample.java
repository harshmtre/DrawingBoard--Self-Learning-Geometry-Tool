import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
public class sample extends JFrame {

	public sample()
	{
		try{
	JFrame frame = new JFrame("stackoverflow") { 
		
		
		  private Image backgroundImage = ImageIO.read(new File("background.jpg"));
		  public void paint( Graphics g ) { 
		    super.paint(g);
		    g.drawImage(backgroundImage, 0, 30,1400,720, null);
		  }
		
		
		};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		  frame.setVisible(true);
		
		}
		catch(Exception e)
		{}
     }
	public static void main(String args[])
	{
	      new sample();	
	}
}
