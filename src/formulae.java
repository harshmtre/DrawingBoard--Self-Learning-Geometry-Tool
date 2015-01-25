import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.sun.codemodel.internal.JLabel;
import com.sun.j3d.utils.applet.MainFrame;

public class formulae extends Applet implements ItemListener,ActionListener,MouseListener,MouseMotionListener

	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image back;
	Image triangle;
	Image quadrilateral;
	Image circle;
	Image cube;
	Image cone;
	Image cylinder;
    Image formulaback;
	Image distance1;
	int width,height;
	URL base;
	int sd;
	String distance,area,perimeter,centroid,equations,altitudes,abis,lbis,alt;
	public formulae()
	{
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		 
		

	
	}
	
	public void init(){          
		   setLayout(null);
	    setSize(1350,650);
	    
	    width=getSize().width/2;
	    height=getSize().height;
	    addMouseListener(this);
	    addMouseMotionListener(this);
	    MediaTracker mt;
	    mt = new MediaTracker(this);
	    try { 
	    	   // getDocumentbase gets the applet path. 
	    	               base = getDocumentBase(); 
	    	         } 
	    	         catch (Exception e) {}
	    	         distance1=getImage(base,"distance1.gif");
	    	 	    
	    triangle=getImage(base,"triangle1.gif");
	    quadrilateral=getImage(base,"quadrilateral1.gif");
	   circle=getImage(base,"circle1.gif");
	   cube=getImage(base,"cube1.gif");
	   cone=getImage(base,"cone1.gif");
	   cylinder=getImage(base,"cylinder1.gif");
	   formulaback=getImage(base,"Final!!!.jpg");
	   //title=getImage(base,"clkonfigure.gif");
	   back=getImage(base,"backformula.gif");
	   mt.addImage(triangle,1);
	    mt.addImage(quadrilateral,1);
	    mt.addImage(circle,1);
	    mt.addImage(cube,1);
	    mt.addImage(cone,1);
	    mt.addImage(cylinder,1);

	    mt.addImage(distance1,1);
	    try { 
	        mt.waitForAll(); 
	   } 
	   catch (InterruptedException  e) {}

	  
	  
	}
	 public void paint(Graphics g)
	   {  MediaTracker mt;
	    mt = new MediaTracker(this);

	  
	    
		//   g.drawString("Click on your Figure!!!!",584,20);
	       g.drawImage(formulaback,0, 0,1350,650,this);
	       g.drawImage(back, 1100, 600, 150,40,this);
		  g.drawImage(triangle,50,100,200,200,this);
		  g.drawString("TRIANGLE",127,330);
		  g.drawString("A",164,101);  g.drawString("(x1, ",179,96);  g.drawString("y1 )",197,97);
		 g.drawString("B",42,274);  g.drawString("(x2, ",40,290);  g.drawString("y2 )",63,290);
		 g.drawString("a",135,297);
		 g.drawString("c",87,175);
		 g.drawString("b",220,188);
				
		  g.drawString("C",248,306);g.drawString("(x3, ",231,323);  g.drawString("y3 )",251,323);
				 
		  g.drawImage(quadrilateral,300,100,200,200,this);
  	  g.drawString("QUADRILATERAL",354,330);
  	  g.drawString("A",404,97);  g.drawString("(x1, ",426,90);  g.drawString("y1)",444,90);
  	
  	
	  g.drawString("B",301,154);g.drawString("(x2, ",270,136);  g.drawString("y2)",290,136);
	  g.drawString("C",296,310);g.drawString("(x3, ",298,321);  g.drawString("y3)",325,321);
	  g.drawString("D",490,307);g.drawString("(x4, ",495,317);  g.drawString("y4)",524,317);
		
  	    g.drawImage(circle,500,100,200,200,this);
  	  g.drawString("CIRCLE",580,330);
  	  
  	  	
  	    g.drawImage(cube,700,100,200,200,this);
  	  g.drawString("CUBE",780,330);
  	    g.drawImage(cone,900,100,200,200,this);
  	  g.drawString("CONE",980,330);
  	    g.drawImage(cylinder,1100,100,200,200,this);
  	  g.drawString("CYLINDER",1180,330);
  	  
  	    Color cl=new Color(100 ,150 ,100);
  	    
  	    if(sd==1)
  	    { //triangle formulae
  	      g.setColor(Color.blue);
  	      distance="1) Length of the side= l(AB)^2=(x2-x1)^2+(y2-y1)^2";
  	      g.drawString(""+distance,40,360);
  	      area="2) Area of the triangle= area^2= (s*(s-a)*(s-b)*(s-c))";
  	    g.drawString(""+area,40,380);
  	  g.drawString("  where s=(a+b+c)/2",80,400);
  	  perimeter="3) Perimeter of triangle= l(AB)+l(BC)+l(CA)";
      g.drawString(""+perimeter,40,420);
    equations="4)Equation of line AB is y = mx + c";
    g.drawString(""+equations,40,440);
    g.drawString("    where m=slope and c=y-Intercept",40,460);
    
    centroid="5)Centroid(xc,yc) is xc=(x1+x2+x3)/3 yc=(y1+y2+y3)/3";
    g.drawString(""+centroid,40,480);
    altitudes="6) In geometry, an altitude of a triangle is a straight line";
    g.drawString(""+altitudes,40,520);
    
    String n="   through a vertex and perpendicular to a line containing";
    g.drawString(""+n,40,540);
    g.drawString("   the base (the opposite side of the triangle).",40,560);
    
g.drawString("7) An angle bisector divides the angle into",40,600);
g.drawString("   two angles with equal measures",40,620);
g.drawString("8) An length bisector divides the length of",390,360);
g.drawString("   the two sides with equal measures",390,380);
  	      	    	
  	  }
  	    if(sd==2)
  	    {//quadrilateral formulae
  	      g.setColor(Color.blue);
  	      distance="1) Length of the side= l(AB)^2=(x2-x1)^2+(y2-y1)^2";
  	      g.drawString(""+distance,290,360);
  	      area="2) Area of the quadrilateral= area of triangle ABD + area of triangle BCD";
  	    g.drawString(""+area,290,380);
  	  g.drawString("  where s=(a+b+c)/2",290,400);
  	  perimeter="3) Perimeter of triangle= l(AB)+l(BC)+l(CA)";
      g.drawString(""+perimeter,290,420);
    equations="4)Equation of line AB is y = mx + c";
    g.drawString(""+equations,290,440);
    g.drawString("    where m=slope and c=y-Intercept",290,460);
    String diagonal="5) Length of the diagonal= l(BD)^2=(x4-x2)^2+(y4-y2)^2";
      g.drawString(""+diagonal,290,490);
     
       	  	    	
  	    }
  	    if(sd==3)
  	    { //circle
  	    	g.drawString("C",580,190);
  	      g.drawLine(600,200,688,200);
  	    g.drawString("r",640,190);
  	
  	    	 g.setColor(Color.blue);
  	  	     area="1) Area of the circle= (3.142)*(radius^2)";
  	  	     g.drawString(""+area,533,360);
  	  	 perimeter="2) Circumference of the circle= 2*(3.142)*(radius)";
	  	     g.drawString(""+perimeter,533,380);
	    	
  	    }
  	    if(sd==4)
  	    {
  	    	//cube
  	      g.drawString("side",885,192);
  	   	 
 	    	 g.setColor(Color.blue);
  	  	     area="1) Surface Area of the Cube= 6*(side^2)";
  	  	     g.drawString(""+area,720,360);
  	  	 perimeter="2) Volume of the Cube= (side*side*side)";
	  	     g.drawString(""+perimeter,720,380);
		  	 String face="3) Face Diagonal of the Cube= 1.414*side";
	  	     g.drawString(""+face,720,400);
	  		 String body="4) Body Diagonal of the Cube= 1.732*side";
	  	     g.drawString(""+body,720,420);
	    	
	    	
  	    }
  	  if(sd==5)
	    {
	    	//cone
	    	 g.setColor(Color.blue);
	    	    g.drawLine(1000,120,1000,250);

	    	    g.drawLine(1000,250,1075,250);
	    	    g.drawString("h",990,197);
	    	    g.drawString("r",1035,245);
	    	  	
	  	     area="1) Surface Area of the Cone= 3.142*radius*(radius+height)";
	  	     g.drawString(""+area,920,360);
	  	 perimeter="2) Volume of the Cone= (1/3*base*height)";
	  	     g.drawString(""+perimeter,920,380);
	  	     
	    }
  	if(sd==6)
    {
    	//cylinder
    	 g.setColor(Color.blue);
    	 g.drawLine(1200,133,1258,133);
      	 
    	  g.drawLine(1200,133,1200,265);

  	    g.drawLine(1200,265,1258,265);
	    g.drawString("h",1184,205);
	    g.drawString("r",1225,125);
	    g.drawString("r",1226,249);

  	     area="1) Surface Area of the Cylinder= 2*3.142*radius*(radius+height)";
  	     g.drawString(""+area,850,360);
  	 perimeter="2) Volume of the Cylinder= 3.142*radius*radius*height";
  	     g.drawString(""+perimeter,850,380);
    }
	       
}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==triangle)
		  {
			  sd=1;
		  }
		  if(e.getSource()==quadrilateral)
		  {
			  sd=2;
		  }
			
		  if(e.getSource()==circle)
		  {
			  sd=3;
		  }
			
		  if(e.getSource()==cube)
		  {
		   	 sd=4;   	   
		  }
		  if(e.getSource()==cone)
		  {
			  sd=5;
		  }
		  if(e.getSource()==cylinder)
		  {
			  sd=6;
		  }
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()<=1250&&e.getX()>=1100&&e.getY()<=640&&e.getY()>=600)
		{
			Frame f=new MainFrame(new mainpage(),1350,650);
		}
		 if(e.getX()>=50&&e.getX()<=275&&e.getY()>=100&&e.getY()<=300)
		  {	
			 sd=1;
		  }
		  if(e.getX()>=300&&e.getX()<=475&&e.getY()>=100&&e.getY()<=300)
		  {
			sd=2;
		  }
		  if(e.getX()>=500&&e.getX()<=675&&e.getY()>=100&&e.getY()<=300)
		  {
			sd=3;
		  }
		  if(e.getX()>=700&&e.getX()<=875&&e.getY()>=100&&e.getY()<=300)
		  {
			sd=4;
		  }
		  if(e.getX()>=900&&e.getX()<=1075&&e.getY()>=100&&e.getY()<=300)
		  {
			sd=5;
		  }
		  if(e.getX()>=1100&&e.getX()<=1275&&e.getY()>=100&&e.getY()<=300)
		  {
			sd=6;
		  }

		  repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	}
