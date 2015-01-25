import java.awt.*;
import java.applet.*;

import java.awt.event.*;
import java.net.*;

import javax.swing.Icon;

import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;
public class triangle extends Applet implements ItemListener,ActionListener,MouseListener,MouseMotionListener{
	
equations eq=new equations();	
int nop=0,sd=0;
int move=0;
int curx,cury;

//Image backg = getImage(getCodeBase(),"background.JPEG");
Image duster;
Image showdistance;
Image showperimeter;
Image showcentroid;
Image showarea;
Image showaltitude;
Image showequation;
Image showanglebisector;
Image showlengthbisector;

//TextArea t=new TextArea("SSup Mahn");
double posx[]=new double[100];
double posy[]=new double[100];
Button b1=new Button("Submit");
CheckboxGroup chk=new CheckboxGroup();
Checkbox lc1=new Checkbox("Enter Length And Angle with X-axis",chk,false);
Checkbox lc2=new Checkbox("Enter Co-Ordinates of Second Point",chk,false);
TextField t1=new TextField("",3);
TextField t2=new TextField("",3);
TextField t3=new TextField("",3);
TextField t4=new TextField("",3);

/*
//Button showdistance=new Button("Show Distance");
Button showcentroid=new Button("Show Centroid");
Button showarea=new Button("Show Area");
//Button showperimeter=new Button("Show Perimeter");
Button getequations=new Button("Get Equations");
Button getaltitudes=new Button("Show Altitudes");
Button getbisectors=new Button("Show Angle Bisectors");
Button getlengthbisectors=new Button("Show Length Bisectors");
*/
Checkbox si;
double d1[]=new double[3];
double allen[]=new double[3];
int s=0,l1=0;
length a=new length();
centroid c=new centroid();
int width,height,mposx1,mposy1,mposx2,mposy2,mposx3,mposy3;
MediaTracker mt;
URL base;
Image my_gif;
Image back;
public triangle()
{
	
}
public void init(){          
    //Canvas c=new Canvas();
	setLayout(null);
	
    setSize(1350,650);
    width=getSize().width/2;
    height=getSize().height;
    b1.setVisible(false);    
    b1.setBounds(700,300,100,30);
   lc1.setBounds(700,100,300,40);
   t1.setBounds(700,150,50,20);
   t2.setBounds(750,150,50,20);
   lc2.setBounds(700,200,300,40);
   t3.setBounds(700,250,50,20); 
   t4.setBounds(750,250,50,20);
  /*
  // showdistance.setBounds(700,100,100,30);
   //showdistance.setActionCommand("showdistance");
   showcentroid.setBounds(700,150,100,30);
   showcentroid.setActionCommand("showcentroid");
   showarea.setBounds(700,200,100,30);
   showarea.setActionCommand("showarea");
  // showperimeter.setBounds(700,250,100,30);
   //showperimeter.setActionCommand("showperimeter");
   getequations.setBounds(700,300,100,30);
   getaltitudes.setBounds(700, 350, 100,30);
   getbisectors.setBounds(700,400,150, 30);
   getlengthbisectors.setBounds(700,450,150,30);
   */
 //  t.setBounds(700, 100, 200, 100);
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
    /*//showdistance.setVisible(false);
    showcentroid.setVisible(false);
    //showperimeter.setVisible(false);
    showarea.setVisible(false);
    getequations.setVisible(false);
    getaltitudes.setVisible(false);
    getbisectors.setVisible(false);
    getlengthbisectors.setVisible(false);
          
    //add(showdistance);
    add(showarea);
    //add(showperimeter);
    add(showcentroid);
    add(getequations);
    add(getaltitudes);
    add(getbisectors);
    add(getlengthbisectors); */
    add(b1);
    
    
    lc2.addItemListener(this);
    lc1.addItemListener(this);
    b1.addActionListener(this);
    /*
    //showdistance.addActionListener(this);
    showarea.addActionListener(this);
    showcentroid.addActionListener(this);
    //showperimeter.addActionListener(this);
    getequations.addActionListener(this);
    getaltitudes.addActionListener(this);
   getbisectors.addActionListener(this);
   getlengthbisectors.addActionListener(this); */
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
   showcentroid=getImage(base,"showcentroid.gif");
   showaltitude=getImage(base,"showaltitudes.gif");
   showequation=getImage(base,"showequation.gif");
   showanglebisector=getImage(base,"showanglebisectors.gif");
   showlengthbisector=getImage(base,"showlengthbisectors.gif");
   showarea=getImage(base,"showarea.gif");
   duster=getImage(base,"duster1.gif");
   back=getImage(base,"back.gif");
   mt.addImage(back, 1);
   mt.addImage(duster,1);
    mt.addImage(showdistance,1);
    mt.addImage(showperimeter,1);
    mt.addImage(showarea,1);
    mt.addImage(showcentroid,1);
    mt.addImage(showaltitude,1);
    mt.addImage(showequation,1);
    mt.addImage(showanglebisector,1);
    mt.addImage(showlengthbisector,1);
    
  
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
     if(nop>=1&&nop<3)
     {
    	 
    	 lc1.setVisible(true);
    	 lc2.setVisible(true);
    	 lc2.setLabel("Enter Co-Ordinates of Second Point");
		 lc1.setLabel("Enter Length And Angle with X-axis");
     }
     if(nop>=2)
     {
    	 if(nop==2)
    	 {
    		 lc1.setVisible(true);
    		 lc2.setVisible(true);
    		 lc2.setLabel("Enter The Co-Ordinates of Third Point");
    		 lc1.setLabel("Enter the length and angle in between");
    	 }
    	 
    	 for(int i=1;i<=nop&&i<=3;i++)
    	 {
    		 for(int j=i+1;j<=nop&&j<=3;j++)
    		 {
    			 //g.drawString("("+mposx2+","+mposy2+")", mposx2,mposy2);
    			 g.setColor(Color.red);
    			 g.drawLine((int)posx[i],(int)posy[i],(int)posx[j],(int)posy[j]);
    		 }
    	 }
     }
     if(nop>=3)
     {
    	    lc1.setVisible(false);
    	    lc2.setVisible(false);
    	    b1.setVisible(false);
    	    t1.setVisible(false);
    	    t2.setVisible(false);
    	    t3.setVisible(false);
    	    t4.setVisible(false);
    /*	 showdistance.setVisible(true);
    	 showcentroid.setVisible(true);
    	 showperimeter.setVisible(true);
    	 showarea.setVisible(true);
    	 getequations.setVisible(true);
     	 getaltitudes.setVisible(true);
     	 getbisectors.setVisible(true);
     	getlengthbisectors.setVisible(true); */
    	    g.drawImage(showdistance,700,100,220,50,this);
    	    g.drawImage(showperimeter,700,160,240,50,this);
    	    g.drawImage(showarea,700,200,220,50,this);
    	    g.drawImage(showcentroid,700,260,240,50,this);
    	    g.drawImage(showequation,700,320,240,50,this);
    	    g.drawImage(showaltitude,700,380,260,50,this);
    	    g.drawImage(showanglebisector,700,440,320,50,this);
    	    g.drawImage(showlengthbisector,700,500,340,50,this);
    	    
     }
     
   if(nop>0&&nop<3)
   {
     if((si.getLabel()).equals("Enter Length And Angle with X-axis")||(si.getLabel()).equals("Enter the length and angle in between"))
     {
    	 b1.setVisible(true);
    	 t3.setVisible(false);
    	 t4.setVisible(false);
    	 t1.setVisible(true);
    	 t2.setVisible(true);
     }
     if((si.getLabel()).equals("Enter Co-Ordinates of Second Point")||(si.getLabel()).equals("Enter The Co-Ordinates of Third Point"))
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
           allen=a.calc_length(posx[1],posy[1],posx[2],posy[2],posx[3],posy[3]);
           g.setColor(Color.white);
           g.drawString(""+allen[0],(int)((posx[2]+posx[1])/2),(int)((posy[2]+posy[1])/2));
           g.drawString(""+allen[1],(int)((posx[3]+posx[1])/2),(int)((posy[1]+posy[3])/2));
           g.drawString(""+allen[2],(int)((posx[2]+posx[3])/2),(int)((posy[2]+posy[3])/2));
   }
   if(sd==3)
   {
	   double centr[]=new double[2];
	   g.setColor(Color.red);
	   centr=c.calc_centroid(posx[1], posy[1], posx[2], posy[2], posx[3], posy[3]);
	   g.setColor(Color.white);
       g.drawString("("+centr[0]+","+centr[1]+")",(int)centr[0],(int)centr[1]);
   }
   if(sd==4)
   {
	   double centr[]=new double[2];
	   centr=c.calc_centroid(posx[1], posy[1], posx[2], posy[2], posx[3], posy[3]);
	   allen=a.calc_length(posx[1],posy[1],posx[2],posy[2],posx[3],posy[3]);
	   double sum=allen[0]+allen[1]+allen[2];
	   sum=sum/2;
	   g.setColor(Color.red);
	   double ar=Math.sqrt(sum*(sum-allen[0])*(sum-allen[1])*(sum-allen[2]));
	   g.setColor(Color.white);
	   g.drawString("Area : "+ar,(int)centr[0],(int)centr[1]);
   }
   if(sd==5)
   {
	   double centr[]=new double[2];
	   centr=c.calc_centroid(posx[1], posy[1], posx[2], posy[2], posx[3], posy[3]);
	   allen=a.calc_length(posx[1],posy[1],posx[2],posy[2],posx[3],posy[3]);
	   double sum=allen[0]+allen[1]+allen[2];
	   g.setColor(Color.white);
	   g.drawString("Perimeter : "+sum,(int)centr[0],(int)centr[1]);
   }
   if(sd==6)
   {
	   
	   String equation[]=eq.get_equations(posx,posy);
	   g.setColor(Color.white);
	   g.drawString(equation[0],(int)(posx[1]+posx[2])/2,(int)(posy[1]+posy[2])/2);
	   g.drawString(equation[1],(int)(posx[1]+posx[3])/2,(int)(posy[1]+posy[3])/2);
	   g.drawString(equation[2],(int)(posx[3]+posx[2])/2,(int)(posy[3]+posy[2])/2);
   }
   if(sd==7)
   {
	   altitude al=new altitude();
	   double alt[]=al.getaltitude(posx,posy);
	   g.setColor(Color.yellow);
	   //g.drawString("hi",10, 20);
	   //g.drawString(""+alt[0]+","+alt[1]+","+alt[2]+","+alt[3]+","+alt[4]+","+alt[5],100,100);
	   g.drawLine((int)posx[3],(int)posy[3],(int)alt[0],(int)alt[1]);
	   g.drawLine((int)posx[2],(int)posy[2],(int)alt[2],(int)alt[3]);
	   g.drawLine((int)posx[1],(int)posy[1],(int)alt[4],(int)alt[5]);
	   g.setColor(Color.white);
	   g.drawString("("+(Math.ceil(alt[0]*100)*0.01)+","+(Math.ceil(alt[1]*100)*0.01)+")",(int)alt[0]-2,(int)alt[1]-2);
	   g.drawString("("+(Math.ceil(alt[2]*100)*0.01)+","+(Math.ceil(alt[3]*100)*0.01)+")",(int)alt[2]-2,(int)alt[3]-2);
	   g.drawString("("+(Math.ceil(alt[4]*100)*0.01)+","+(Math.ceil(alt[5]*100)*0.01)+")",(int)alt[4]-2,(int)alt[5]-2);
          
   }
   if(sd==8)
   {
	   anglebisector ang=new anglebisector();
	   double bis[]=new double[3];
	   bis=ang.getbisectors(posx, posy);
	   g.setColor(Color.yellow);
	  // g.drawString(""+bis[0]+","+bis[1]+","+bis[2]+","+bis[3]+","+bis[4]+","+bis[5], 100,200);
	   g.drawLine((int)posx[1],(int)posy[1],(int)bis[0],(int)bis[1]);
	   g.drawLine((int)posx[2],(int)posy[2],(int)bis[2],(int)bis[3]);
	   g.drawLine((int)posx[3],(int)posy[3],(int)bis[4],(int)bis[5]);
	   g.setColor(Color.white);
	   g.drawString("("+(Math.ceil(bis[0]*100)*0.01)+","+(Math.ceil(bis[1]*100)*0.01)+")",(int)bis[0]-2,(int)bis[1]-2);
	   g.drawString("("+(Math.ceil(bis[2]*100)*0.01)+","+(Math.ceil(bis[3]*100)*0.01)+")",(int)bis[2]-2,(int)bis[3]-2);
	   g.drawString("("+(Math.ceil(bis[4]*100)*0.01)+","+(Math.ceil(bis[5]*100)*0.01)+")",(int)bis[4]-2,(int)bis[5]-2);
   }
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
   }
   if(move==1)
   {
	   g.setColor(Color.yellow);
	   g.drawString("("+curx+","+cury+")",curx,cury);
	   move=0;
   }
   /*if(s==3)
     {
    	 g.drawString("("+mposx3+","+mposy3+")", mposx3,mposy3);
    	 g.drawLine(mposx2,mposy2,mposx3,mposy3);
    	 g.drawLine(mposx1,mposy1,mposx3,mposy3);
       s=4;
    	
    	 
         
    	 g.setColor(Color.black);
    	 int cnt[]=new int[2];
    	 cnt=c.calc_centroid(mposx1, mposy1, mposx2, mposy2, mposx3, mposy3);
    	 g.drawString("Centroid("+cnt[0]+","+cnt[1]+")",cnt[0],cnt[1]);
    	 
     }
     if(l1==1)
     {
    	 g.drawString(""+d1[0],(mposx1+mposx2)/2,(mposy1+mposy2)/2);
    	 g.drawString(""+d1[1],(mposx1+mposx3)/2,(mposy1+mposy3)/2 );
    	 g.drawString(""+d1[2],(mposx2+mposx3)/2,(mposy2+mposy3)/2);
     }
     */
    	 
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
	if(e.getX()>=1200&&e.getX()<=1250&&e.getY()>=500&&e.getY()<=560)
	{sd=0;
		if(nop==0)
		{ nop=0; sd=0;}
		nop--;
		b1.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		
	}
	if(e.getX()<=1300&&e.getX()>=1150&&e.getY()<=70&&e.getY()>=40)
	{
		Frame f2=new MainFrame(new mainpage(),1350,650);
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
	sd=3;
  }
  if(e.getX()>=700&&e.getX()<=940&&e.getY()>=320&&e.getY()<=370&&nop>=3)
  {
	sd=6;
  }
  if(e.getX()>=700&&e.getX()<=960&&e.getY()>=380&&e.getY()<=430&&nop>=3)
  {
	sd=7;
  }
  if(e.getX()>=700&&e.getX()<=1020&&e.getY()>=440&&e.getY()<=490&&nop>=3)
  {
	sd=8;
  }
  if(e.getX()>=700&&e.getX()<=1040&&e.getY()>=500&&e.getY()<=550&&nop>=3)
  {
	sd=9;
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
	/*move=1;
 curx=e.getX();
 cury=e.getY();
 repaint();
 */
	showStatus("("+e.getX()+","+e.getY()+")");


	if(e.getX()>=1200&&e.getX()<=1250&&e.getY()>=500&&e.getY()<=560)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	else if(e.getX()<=1300&&e.getX()>=1150&&e.getY()<=70&&e.getY()>=40)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//	Frame f2=new MainFrame(new mainpage(),1350,650);
	}
	else  if(e.getX()>=60&&e.getX()<=675&&e.getY()>=40&&e.getY()<=620)
  {	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }
  else if(e.getX()>=700&&e.getX()<=900&&e.getY()>=100&&e.getY()<=150&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=2;
  }
  else if(e.getX()>=700&&e.getX()<=920&&e.getY()>=160&&e.getY()<=200&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=5;
  }
  else if(e.getX()>=700&&e.getX()<=900&&e.getY()>=205&&e.getY()<=250&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=4;
  }
  else if(e.getX()>=700&&e.getX()<=940&&e.getY()>=260&&e.getY()<=310&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=3;
  }
  else if(e.getX()>=700&&e.getX()<=940&&e.getY()>=320&&e.getY()<=370&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=6;
  }
  else if(e.getX()>=700&&e.getX()<=960&&e.getY()>=380&&e.getY()<=430&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=7;
  }
  else if(e.getX()>=700&&e.getX()<=1020&&e.getY()>=440&&e.getY()<=490&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=8;
  }
  else if(e.getX()>=700&&e.getX()<=1040&&e.getY()>=500&&e.getY()<=550&&nop>=3)
  {setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//sd=9;
  }
  else
  {
	  setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }




}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	// d1=a.calc_length(mposx1,mposy1,mposx2, mposy2, mposx3,mposy3);
      ///  l1=1;
	 
  
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
	if((si.getLabel()).equals("Enter Co-Ordinates of Second Point")||(si.getLabel()).equals("Enter The Co-Ordinates of Third Point"))
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
			double theta=(posy[2]-posy[1])/(posx[2]-posx[1]);
			theta=Math.atan(theta);
			
			double d=Double.parseDouble(s1);
			double ang1a=Double.parseDouble(s2);
			ang1a=Math.toRadians(ang1a);
			double alpha=0,valx=0,valy=0;
			if(theta>=0)
			{alpha=theta-ang1a;
			valx=posx[1]+(d*Math.cos(alpha));
			valy=posy[1]+(d*Math.sin(alpha));
			}
			else
			{
				alpha=theta+ang1a;
				valx=posx[1]-(d*Math.cos(alpha));
				valy=posy[1]-(d*Math.sin(alpha));
			}
			//double ang1=90-ang1a+ang;
			//double rad=Math.toRadians(ang1);
			//double valx=posx[nop]-(d*Math.sin(rad));
			//double valy=posy[nop]+(d*Math.cos(rad));
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