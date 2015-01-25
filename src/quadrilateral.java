import java.awt.*;
import java.applet.*;

import java.awt.event.*;
import java.net.*;

import javax.swing.Icon;

import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;
public class quadrilateral extends Applet implements ItemListener,ActionListener,MouseListener,MouseMotionListener{
	
equations eq=new equations();	
int nop=0,sd=0;
int move=0;
int curx,cury;


Image duster;
Image showdistance;
Image showperimeter;
Image showcentroid;
Image showarea;
Image showaltitude;
Image showequation;
Image showanglebisector;
Image showlengthbisector;

TextArea t=new TextArea("SSup Mahn");
double posx[]=new double[100];
double posy[]=new double[100];
Button b1=new Button("Submit");
CheckboxGroup chk=new CheckboxGroup();
Checkbox lc1=new Checkbox("Enter Length And Angle with X-axis",chk,false);
Checkbox lc2=new Checkbox("Enter Co-Ordinates of Next Point",chk,false);
TextField t1=new TextField("",3);
TextField t2=new TextField("",3);
TextField t3=new TextField("",3);
TextField t4=new TextField("",3);

Image back;
Checkbox si;
double d1[]=new double[3];
double allen[]=new double[3];
int s=0,l1=0;
qlength a=new qlength();
length b=new length();
qequations eqq=new qequations();
//centroid c=new centroid();
int width,height,mposx1,mposy1,mposx2,mposy2,mposx3,mposy3;
MediaTracker mt;
URL base;
Image my_gif;
public quadrilateral()
{
	
}
   public void init(){          
	   setLayout(null);
    setSize(1350,650);
    width=getSize().width/2;
    height=getSize().height;
    b1.setVisible(false);    
    b1.setBounds(700,300,100,30);
   lc1.setBounds(700,100,300,40);
   lc1.setVisible(false);
   t1.setBounds(700,150,50,20);
   t2.setBounds(750,150,50,20);
   lc2.setBounds(700,200,300,40);
   t3.setBounds(700,250,50,20); 
   t4.setBounds(750,250,50,20);
   t.setBounds(700, 100, 200, 100);
   add(lc1);
    add(lc2);
    add(t1);
    add(t2);
    add(t3);
    add(t4);
    //add(t);
    lc1.setVisible(false);
    lc2.setVisible(false);
    t1.setVisible(false);
    t2.setVisible(false);
    t3.setVisible(false);
    t4.setVisible(false);
    
    add(b1);
    lc2.addItemListener(this);
    lc1.addItemListener(this);
    b1.addActionListener(this);
    addMouseListener(this);
    addMouseMotionListener(this);
    mt = new MediaTracker(this);
    
    try { 
    	   // getDocumentbase gets the applet path. 
    	               base = getDocumentBase(); 
    	         } 
    	         catch (Exception e) {}

    my_gif = getImage(base,"background.JPG");
    showdistance=getImage(base,"showdistance.gif");
    showperimeter=getImage(base,"showperimeter.gif");
   showcentroid=getImage(base,"showdiagnals.gif");
   //showaltitude=getImage(base,"showaltitudes.gif");
   showequation=getImage(base,"showequation.gif");
   //showanglebisector=getImage(base,"showanglebisectors.gif");
   //showlengthbisector=getImage(base,"showlengthbisectors.gif");
   showarea=getImage(base,"showarea.gif");
   duster=getImage(base,"duster1.gif");
   back=getImage(base,"back.gif");
   mt.addImage(duster,1);
    mt.addImage(showdistance,1);
    mt.addImage(showperimeter,1);
    mt.addImage(showarea,1);
    mt.addImage(showcentroid,1);
    //mt.addImage(showaltitude,1);
    mt.addImage(showequation,1);
    //mt.addImage(showanglebisector,1);
   // mt.addImage(showlengthbisector,1);
    
  
    mt.addImage(my_gif,1);
   
    try { 
        mt.waitForAll(); 
   } 
   catch (InterruptedException  e) {}

  b1.setBackground(null);
   }
   public void paint(Graphics g)
   {
	   
	   
	  g.drawImage(my_gif,0,0,1350,650,this);
	  g.drawImage(duster,1200,500,50,60,this);
	  g.drawImage(back, 1150, 40, 150, 30,this);
    Color cl=new Color(100 ,150 ,100);
       
       g.setColor(cl);
           
     
     
     for(int i=60;i<=width;i=i+10)
     {
     g.drawLine(i,40,i,height-30);
     }
     for(int j=40;j<=height-30;j=j+10)
     {
     g.drawLine(60,j,width,j);
     }
     
     g.setColor(Color.yellow);
     for(int i=1;i<=nop;i++)
     g.drawString("("+posx[i]+","+posy[i]+")", (int)posx[i],(int)posy[i]);
     if(nop<1)
     {
    	 lc1.setVisible(false);
    	 lc2.setVisible(false);
     }
     if(nop>=1&&nop<4)
     {
    	 
    	 lc1.setVisible(false);
    	 lc2.setVisible(true);
    	 lc2.setLabel("Enter Co-Ordinates of Next Point");
		 lc1.setLabel("Enter Length And Angle with X-axis");
     }
     if(nop>=2)
     {
    	 if(nop==2)
    	 {
    		 lc1.setVisible(false);
    		 lc2.setVisible(true);
    		 lc2.setLabel("Enter The Co-Ordinates of Next Point");
    		 lc1.setLabel("Enter the length and angle in between");
    	 }
    	 if(nop==3)
    	 {
    		 lc1.setVisible(false);
    		 lc2.setVisible(true);
    		 lc2.setLabel("Enter The Co-Ordinates of Next Point");
    		 lc1.setLabel("Enter the length and angle in between");
    	 }
    	 
    	 for(int i=1;i<=nop&&i<=4;i++)
    	 {
    		  if(i!=1)
    		 {
    			 g.setColor(Color.red);
    			 g.drawLine((int)posx[i],(int)posy[i],(int)posx[i-1],(int)posy[i-1]);
    		 }
    		if(i==4)
    		{
    			g.setColor(Color.red);
    			 g.drawLine((int)posx[i],(int)posy[i],(int)posx[1],(int)posy[1]); 			 
    		}
    	 }
     }
     if(nop>=4)
     {
    	    lc1.setVisible(false);
    	    lc2.setVisible(false);
    	    b1.setVisible(false);
    	    t1.setVisible(false);
    	    t2.setVisible(false);
    	    t3.setVisible(false);
    	    t4.setVisible(false);
    	    g.drawImage(showdistance,700,100,220,50,this);
    	    g.drawImage(showperimeter,700,160,240,50,this);
    	    g.drawImage(showarea,700,200,220,50,this);
    	    g.drawImage(showcentroid,700,260,240,50,this);
    	    g.drawImage(showequation,700,320,240,50,this);
    	//    g.drawImage(showaltitude,700,380,260,50,this);
    	  //  g.drawImage(showanglebisector,700,440,320,50,this);
    	    //g.drawImage(showlengthbisector,700,500,340,50,this);
    	    
     }
     
   if(nop>0&&nop<=4)
   {
     if((si.getLabel()).equals("Enter Length And Angle with X-axis")||(si.getLabel()).equals("Enter the length and angle in between"))
     { b1.setVisible(false);
 	
    	 t3.setVisible(false);
    	 t4.setVisible(false);
    	 t1.setVisible(false);
    	 t2.setVisible(false);
    	 
     }
     if((si.getLabel()).equals("Enter Co-Ordinates of Next Point")||(si.getLabel()).equals("Enter Co-Ordinates of Next Point")||(si.getLabel()).equals("Enter Co-Ordinates of Next Point"))
     {
    	 b1.setVisible(true);
    	 t1.setVisible(false);
    	 t2.setVisible(false);
    	 t3.setVisible(true);
    	 t4.setVisible(true);
     }
   
   }
  
   if(sd==2)
   {
           g.setColor(Color.red);
           allen=a.calc_length(posx[1],posy[1],posx[2],posy[2],posx[3],posy[3],posx[4],posy[4]);
           g.setColor(Color.white);
           g.drawString(""+allen[0],(int)((posx[2]+posx[1])/2),(int)((posy[2]+posy[1])/2));
           g.drawString(""+allen[1],(int)((posx[2]+posx[3])/2),(int)((posy[2]+posy[3])/2));
           g.drawString(""+allen[2],(int)((posx[3]+posx[4])/2),(int)((posy[4]+posy[3])/2));
           g.drawString(""+allen[3],(int)((posx[4]+posx[1])/2),(int)((posy[1]+posy[4])/2));
           
   }
   
   /*
   if(sd==3)
   {
	   double centr[]=new double[2];
	   g.setColor(Color.red);
	  // centr=c.calc_centroid(posx[1], posy[1], posx[2], posy[2], posx[3], posy[3]);
	   g.setColor(Color.white);
       g.drawString("("+centr[0]+","+centr[1]+")",(int)centr[0],(int)centr[1]);
   }
   */
   if(sd==4)
   {
	  // double centr[]=new double[2];
	   //centr=c.calc_centroid(posx[1], posy[1], posx[2], posy[2], posx[3], posy[3]);
	   
	   allen=b.calc_length(posx[1],posy[1],posx[2],posy[2],posx[3],posy[3]);
	   double sum=allen[0]+allen[1]+allen[2];
	   sum=sum/2;
	   g.setColor(Color.red);
	   double ar2=Math.sqrt(sum*(sum-allen[0])*(sum-allen[1])*(sum-allen[2]));
	   g.setColor(Color.white);
	   //g.drawString("Area : "+ar,(int)centr[0],(int)centr[1]);
	   allen=b.calc_length(posx[3],posy[3],posx[4],posy[4],posx[1],posy[1]);
	   double sum1=allen[0]+allen[1]+allen[2];
	   sum1=sum1/2;
	   
	   double ar1=Math.sqrt(sum1*(sum1-allen[0])*(sum1-allen[1])*(sum1-allen[2]));
	  double ar=ar1+ar2;	  
	  g.drawString("Area : "+ar,265,60);
   }
   
   if(sd==5)
   {
	 //  double centr[]=new double[2];
	 //  centr=c.calc_centroid(posx[1], posy[1], posx[2], posy[2], posx[3], posy[3]);
	   allen=a.calc_length(posx[1],posy[1],posx[2],posy[2],posx[3],posy[3],posx[4],posy[4]);
	   double sum=allen[0]+allen[1]+allen[2]+allen[3];
	   g.setColor(Color.white);
	   g.drawString("Perimeter : "+sum,265,60);
   }
   if(sd==6)
   {
	   
	   String equation[]=eqq.get_equations(posx,posy);
	   g.setColor(Color.white);
	   g.drawString(equation[0],(int)(posx[1]+posx[2])/2,(int)(posy[1]+posy[2])/2);
	   g.drawString(equation[1],(int)(posx[2]+posx[3])/2,(int)(posy[2]+posy[3])/2);
	   g.drawString(equation[2],(int)(posx[3]+posx[4])/2,(int)(posy[3]+posy[4])/2);
	   g.drawString(equation[3],(int)(posx[4]+posx[1])/2,(int)(posy[4]+posy[1])/2);
	   
   }
   double t,l;
   double cnn[]=new double[10];
   if(sd==7)
   {   qdiag q= new qdiag();
   g.setColor(Color.yellow);
	
	  
   g.drawLine((int)posx[1],(int)posy[1],(int)posx[3],(int)posy[3]) ;
	   t=q.cal_length(posx[1],posy[1],posx[3],posy[3]);
	   g.setColor(Color.white);
	   g.drawString("The length of diagonal between("+posx[1]+","+posy[1]+"),("+posx[3]+","+posy[3]+")is ="+t,265,60);
	   g.setColor(Color.yellow);
		
	   g.drawLine((int)posx[2],(int)posy[2],(int)posx[4],(int)posy[4]) ;
	   l=q.cal_length(posx[2],posy[2],posx[4],posy[4]);
	   g.setColor(Color.white);
		
	   g.drawString("The length of diagonal between("+posx[2]+","+posy[2]+"),("+posx[4]+","+posy[4]+")is ="+l,265,100);
	   diag cn= new diag();
     cnn=cn.get_equations(posx,posy);		  
	   g.drawString("("+cnn[0]+","+cnn[1]+")",(int)cnn[0],(int)cnn[1]);
	   
	   
   }
   /*
   if(sd==8)
   {
	   anglebisector ang=new anglebisector();
	   double bis[]=new double[3];
	   bis=ang.getbisectors(posx, posy);
	   g.setColor(Color.yellow);
	   g.drawLine((int)posx[1],(int)posy[1],(int)bis[0],(int)bis[1]);
	   g.drawLine((int)posx[2],(int)posy[2],(int)bis[2],(int)bis[3]);
	   g.drawLine((int)posx[3],(int)posy[3],(int)bis[4],(int)bis[5]);
	   g.setColor(Color.white);
	   g.drawString("("+(Math.ceil(bis[0]*100)*0.01)+","+(Math.ceil(bis[1]*100)*0.01)+")",(int)bis[0]-2,(int)bis[1]-2);
	   g.drawString("("+(Math.ceil(bis[2]*100)*0.01)+","+(Math.ceil(bis[3]*100)*0.01)+")",(int)bis[2]-2,(int)bis[3]-2);
	   g.drawString("("+(Math.ceil(bis[4]*100)*0.01)+","+(Math.ceil(bis[5]*100)*0.01)+")",(int)bis[4]-2,(int)bis[5]-2);
   }*/
   /*
   if(sd==9)
   {
	   g.setColor(Color.yellow);
	   g.drawLine((int)posx[3],(int)posy[3],(int)(posx[1]+posx[2])/2,(int)(posy[1]+posy[2])/2);
	   g.drawLine((int)posx[2],(int)posy[2],(int)(posx[1]+posx[3])/2,(int)(posy[1]+posy[3])/2);
	   g.drawLine((int)posx[1],(int)posy[1],(int)(posx[3]+posx[2])/2,(int)(posy[3]+posy[2])/2);
	   g.setColor(Color.white);
       g.drawString("("+(posx[1]+posx[2])/2+","+(posy[1]+posy[2])/2+")",(int)(posx[1]+posx[2])/2,(int)(posy[1]+posy[2])/2);
       g.drawString("("+(posx[1]+posx[3])/2+","+(posy[1]+posy[3])/2+")",(int)(posx[1]+posx[3])/2,(int)(posy[1]+posy[3])/2);
       g.drawString("("+(posx[3]+posx[2])/2+","+(posy[3]+posy[2])/2+")",(int)(posx[3]+posx[2])/2,(int)(posy[3]+posy[2])/2);
   }*/
   if(move==1)
   {
	   g.setColor(Color.yellow);
	   g.drawString("("+curx+","+cury+")",curx,cury);
	   move=0;
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

	if(e.getX()<=1300&&e.getX()>=1150&&e.getY()<=70&&e.getY()>=40)
	{
		Frame f2=new MainFrame(new mainpage(),1350,650);
	}
	if(e.getX()>=1200&&e.getX()<=1250&&e.getY()>=500&&e.getY()<=560)
	{sd=0;
		if(nop==0)
		{ nop=0; sd=0;}
		nop--;
	}
  if(e.getX()>=60&&e.getX()<=675&&e.getY()>=40&&e.getY()<=620)
  {	nop++;
  posx[nop]=e.getX();
  posy[nop]=e.getY();
  }
  if(e.getX()>=700&&e.getX()<=900&&e.getY()>=100&&e.getY()<=150&&nop>=3)
  {
	sd=2;
  }
  if(e.getX()>=700&&e.getX()<=920&&e.getY()>=160&&e.getY()<=200&&nop>=3)
  {
	sd=5;
  }
  if(e.getX()>=700&&e.getX()<=900&&e.getY()>=205&&e.getY()<=250&&nop>=3)
  {
	sd=4;
  }
  if(e.getX()>=700&&e.getX()<=940&&e.getY()>=260&&e.getY()<=310&&nop>=3)
  {
	sd=7;
  }
  if(e.getX()>=700&&e.getX()<=940&&e.getY()>=320&&e.getY()<=370&&nop>=3)
  {
	sd=6;
  }
  if(e.getX()>=700&&e.getX()<=960&&e.getY()>=380&&e.getY()<=430&&nop>=3)
  {
	sd=7;
  }
  /*if(e.getX()>=700&&e.getX()<=1020&&e.getY()>=440&&e.getY()<=490&&nop>=3)
  {
	sd=8;
  }
  if(e.getX()>=700&&e.getX()<=1040&&e.getY()>=500&&e.getY()<=550&&nop>=3)
  {
	sd=9;
  }*/
  
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
	showStatus(""+e.getX()+","+e.getY()+"");
	
	if(e.getX()>=1200&&e.getX()<=1250&&e.getY()>=500&&e.getY()<=560)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	else if(e.getX()>=60&&e.getX()<=675&&e.getY()>=40&&e.getY()<=620)
	  {
		  setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	  }
	  else if(e.getX()<=1300&&e.getX()>=1150&&e.getY()<=70&&e.getY()>=40)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	else if(e.getX()>=700&&e.getX()<=900&&e.getY()>=100&&e.getY()<=150&&nop>=3)
	  {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//sd=2;
	  }
	else if(e.getX()>=700&&e.getX()<=920&&e.getY()>=160&&e.getY()<=200&&nop>=3)
	  {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//sd=5;
	  }
	else if(e.getX()>=700&&e.getX()<=900&&e.getY()>=205&&e.getY()<=250&&nop>=3)
	  {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//sd=4;
	  }
	else if(e.getX()>=700&&e.getX()<=940&&e.getY()>=260&&e.getY()<=310&&nop>=3)
	  {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//sd=7;
	  }
	else if(e.getX()>=700&&e.getX()<=940&&e.getY()>=320&&e.getY()<=370&&nop>=3)
	  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//sd=6;
	  }
	else if(e.getX()>=700&&e.getX()<=960&&e.getY()>=380&&e.getY()<=430&&nop>=3)
	  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//sd=7;
	  }
	else
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	 
  
  if(e.getSource()==showperimeter)
  {
	  sd=5;
  }
  if(e.getSource()==showarea)
  {
	  sd=4;
  }
	
  if(e.getSource()==showcentroid)
  {
	  sd=3;
  }
	
  if(e.getSource()==showdistance)
  {
   	 sd=2;   	   
  }
  if(e.getSource()==showequation)
  {
	  sd=6;
  }
  if(e.getSource()==showaltitude)
  {
	  sd=7;
  }
  if(e.getSource()==showanglebisector)
  {
	  sd=8;
  }
  if(e.getSource()==showlengthbisector)
  {
	  sd=9;
  }
  if(e.getSource()==b1)
  {
	if((si.getLabel()).equals("Enter Co-Ordinates of Next Point")||(si.getLabel()).equals("Enter The Co-Ordinates of Next Point"))
	 {
	String s1=t3.getText();
	String s2=t4.getText();
	posx[++nop]=Double.parseDouble(s1);
	posy[nop]=Double.parseDouble(s2);
	 }
	 double ang=0;
	 if((si.getLabel()).equals("Enter Length And Angle with X-axis"))
	 {
		 	String s1=t1.getText();
			String s2=t2.getText();
			double d=Double.parseDouble(s1);
			ang=Double.parseDouble(s2);
			double rad=Math.toRadians(ang);
					
			double valx=posx[nop]+(d*Math.cos(rad));
			double valy=posy[nop]+(d*Math.sin(rad));
	        valx=(Math.floor(valx*100))*0.01;
	        valy=(Math.floor(valy*100))*0.01;
			posx[++nop]=valx;
			posy[nop]=valy;
	 }
	 if((si.getLabel()).equals("Enter the length and angle in between"))
	 {
		 String s1=t1.getText();
			String s2=t2.getText();
			double d=Double.parseDouble(s1);
			double ang1a=Double.parseDouble(s2);
			double ang1=90-ang1a+ang;
			double rad=Math.toRadians(ang1);
			double valx=posx[nop]-(d*Math.sin(rad));
			double valy=posy[nop]+(d*Math.cos(rad));
	        valx=(Math.floor(valx*100))*0.01;
	        valy=(Math.floor(valy*100))*0.01;
			posx[++nop]=valx;
			posy[nop]=valy;
	 }
  } 
	 repaint();
}
@Override
public void itemStateChanged(ItemEvent ie) {
	// TODO Auto-generated method stub
	 si=chk.getSelectedCheckbox();
	repaint();
	
}

}
