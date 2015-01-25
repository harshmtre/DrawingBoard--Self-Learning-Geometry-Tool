import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DrawingColor{
	int sd=0;
	Image backgroundImage;
	JButton s1=new JButton("Click");
  public static void main(String[] args) {
  DrawingColor d = new DrawingColor();
  }

  public DrawingColor(){
	  try{
		  backgroundImage = ImageIO.read(new File("background.jpg"));
		   }
		   catch(Exception e){}
	  JFrame frame = new JFrame("Drawing with Alpha");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new FlowLayout());
  //frame.setLayout(null);
  TextField t=new TextField("SSUp!!",3);  
  frame.add(t);
  frame.setSize(400,400);
  s1.setSize(200,50);
  t.setBounds(700,100,100,50);
  s1.setBorder(null);
  s1.setBackground(null);
  s1.setForeground(Color.WHITE);

  s1.setFont(new Font("squeaky chalk sound",Font.BOLD,30));
  
  frame.getContentPane().add(new MyComponent());



  frame.setVisible(true);  
  }

  public class MyComponent extends JPanel implements ActionListener{
	  public MyComponent()
	  {
		   
		 // setLayout(null);
		 // setOpaque(false);
		   	   s1.addActionListener(this);
	  }
  public void paint(Graphics g){
  int height = 200;
  int width = 120;
  g.drawImage(backgroundImage,0,0,1400,730,null);
  g.setColor(Color.red);
  g.drawRect(10,10,height,width);
  g.setColor(Color.gray);
  if(sd==0)
  g.fillRect(11,11,height,width); 
  g.setColor(Color.red);
  g.drawOval(250,20, height,width);
  g.setColor(Color.magenta);
  if(sd==1)
  g.fillOval(249,19,height,width); 
  }
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	sd=1;
	repaint();
}
  }
}