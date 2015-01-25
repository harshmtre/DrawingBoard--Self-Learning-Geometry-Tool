import java.awt.*;
import java.net.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*; 

import com.sun.j3d.utils.applet.MainFrame;
public class circle extends Applet implements ItemListener,ActionListener,MouseListener,MouseMotionListener {
int mx,my,mix,miy;
int cnt=1;
	String ras;
 double frad;	
 int circom;
	double ra,cex,cey,ax,ay,cx1,cx2,cx3,cy1,cy2,cy3,mw1,mw2,mw3,the1,theta1,thehlf1,s1,the2,theta2,thehlf2;
	int hw1,hh1,count=0;
	double s2,c1,c2,mnx,mny,midx1,midy1,midx2,midy2;
	 Image my_gif;
	 URL base;
	 MediaTracker mt;
	 TextField rad=new TextField("Radius",100);
	TextField xcord=new TextField("X",100);
	TextField ycord=new TextField("Y",100);
	TextField xcord1=new TextField("X1",100);
	TextField ycord1=new TextField("Y1",100);
	TextField xcord2=new TextField("X2",100);
	TextField ycord2=new TextField("Y2",100);
	TextField xcord3=new TextField("X3",100);
	TextField ycord3=new TextField("Y3",100);
	CheckboxGroup sel=new CheckboxGroup();
	Checkbox radio2=new Checkbox("Click to make circle by clicking on Graph",sel,false);
	Checkbox radio1=new Checkbox("Click to make circle by entering values",sel,false);
	Checkbox radio3=new Checkbox("Click to make circle by entering 3-co-ordinate points",sel,false);
	Checkbox si;
int dust=1;
	int ar=0;
	Image back;
	Image cir,area,duster;
	Button submit=new Button("SUBMIT");
	 public circle()
	 {
		 
	 }
	public void init()
	{
		setLayout(null);
		mt = new MediaTracker(this);
		setSize(1350,650);
		hw1=getSize().width;
		hh1=getSize().height;
		add(rad);
		add(submit);
		add(xcord);
		add(ycord);
		add(xcord1);
		add(ycord1);
		add(xcord2);
		add(ycord2);
		add(xcord3);
		add(ycord3);
		
		
		
		add(radio1);
		add(radio2);
		add(radio3);
		 addMouseListener(this);
		 addMouseMotionListener(this);
		 radio1.addItemListener(this);
		 radio2.addItemListener(this);
		 radio3.addItemListener(this);
		submit.addActionListener(this);
		
		try { 
			   // getDocumentbase gets the applet path. 
			               base = getDocumentBase(); 
			         } 
			         catch (Exception e) {}

			  // Here we load the image. 
			  // Only Gif and JPG are allowed. Transparant gif also. 
			          my_gif = getImage(base,"background.jpg");
                      cir=getImage(base,"showcircumference.gif");
                      area=getImage(base,"showarea.gif");
                      duster=getImage(base,"duster1.gif");
                      back=getImage(base,"back.gif");       
                      // tell the MediaTracker to kep an eye on this image, and give it ID 1; 
			          // now tell the mediaTracker to stop the applet execution 
			          // (in this example don't paint) until the images are fully loaded. 
			          // must be in a try catch block.
			          mt.addImage(my_gif,1);
			          try { 
			               mt.waitForAll(); 
			          } 
			          catch (InterruptedException  e) {}
			       // when the applet gets here then the images is loaded.
		radio1.setBounds(750,50,300,20);
		xcord.setBounds(750,90,100,20);
		ycord.setBounds(870,90,100,20);
		rad.setBounds(990,90,100,20);
		radio2.setBounds(750,130,300,20);
		radio3.setBounds(750,170,380,20);
		xcord1.setBounds(750,210,100,20);
		ycord1.setBounds(870,210,100,20);
		xcord2.setBounds(750,250,100,20);
		ycord2.setBounds(870,250,100,20);
		xcord3.setBounds(750,290,100,20);
		ycord3.setBounds(870,290,100,20);
		
		submit.setBounds(750,350,75,25);
		xcord.setVisible(false);
		ycord.setVisible(false);
		rad.setVisible(false);
		submit.setVisible(false);
		xcord1.setVisible(false);
		ycord1.setVisible(false);
		xcord2.setVisible(false);
		ycord2.setVisible(false);
		xcord3.setVisible(false);
		ycord3.setVisible(false);
		
		
	}
	
	public void paint(Graphics g)
	{
	
		 // now we are going to draw the gif on the screen 
		  // (image name,x,y,observer);

		          

		  // you can resize the image easily

		
		          g.drawImage(my_gif,0,0,1350,650,this); 
		          g.drawImage(duster,1200,500,50,60,this);
		
		          g.drawImage(back, 1150, 40, 150, 30,this);
		for(int i=60;i<=hw1/2;i=i+10)
		{
			
			
			Color s=new Color(119,136,153);
			g.setColor(s);
			
			g.drawLine(i,40,i,hh1-30);
			
			
			
	
		}
		for(int i=40;i<=hh1-30;i=i+10)
		{
			
			
			Color s=new Color(119,136,153);
			g.setColor(s);
			g.drawLine(60,i,hw1/2,i);
			
			
	
		}
		g.setColor(Color.yellow);
	if(dust==1)
	{
		if(si.getLabel().equals("Click to make circle by clicking on Graph"))
		{
		
		xcord.setVisible(false);
		ycord.setVisible(false);
		rad.setVisible(false);
		submit.setVisible(false);
		xcord1.setVisible(false);
		ycord1.setVisible(false);
		xcord2.setVisible(false);
		ycord2.setVisible(false);
		xcord3.setVisible(false);
		ycord3.setVisible(false);
		
		
		//g.drawString("("+(int)ax+","+(int)ay+")",(int)ax,(int)ay);
		
		if(cnt>=2)
		{
			
		g.drawString("("+(int)cex+","+(int)cey+")",(int)cex,(int)cey);
		}
	
		
		if(cnt>=3)
		{
			g.drawString("("+(int)mx+","+(int)my+")",(int)mx,(int)my);
			ra=Math.sqrt(Math.pow((mx-cex),2)+Math.pow((my-cey),2));
			g.drawArc((int)(cex-ra),(int)(cey-ra),(int)(ra*2),(int)(ra*2),0,360);
			g.drawLine((int)(cex),(int)(cey),mx,my);
			circom=1;
			mix=(int)(cex+mx)/2;
			miy=(int)(cey+my)/2;
			ra=0.01*Math.ceil((ra*100));
			g.drawString(""+ra,mix,miy);
			//cnt=1;
			xcord.setVisible(false);
			ycord.setVisible(false);
			rad.setVisible(false);
			submit.setVisible(false);
			xcord1.setVisible(false);
			ycord1.setVisible(false);
			xcord2.setVisible(false);
			ycord2.setVisible(false);
			xcord3.setVisible(false);
			ycord3.setVisible(false);
			radio1.setVisible(false);
			radio2.setVisible(false);
			radio3.setVisible(false);
		frad=ra;
			if(dust==1)
			{
		    g.drawImage(area, 700,100,220,50,this);
			g.drawImage(cir, 700,160,300,50, this);
			}
		}
		}
	}
	if(dust==1)
	{
		if(si.getLabel().equals("Click to make circle by entering values"))
		{
			if(count==1)
			{
				radio1.setVisible(false);
				radio2.setVisible(false);
				radio3.setVisible(false);
				xcord1.setVisible(false);
				ycord1.setVisible(false);
				xcord2.setVisible(false);
				ycord2.setVisible(false);
				xcord3.setVisible(false);
				ycord3.setVisible(false);
				xcord.setVisible(false);
				ycord.setVisible(false);
				rad.setVisible(false);
				submit.setVisible(false);
				if(dust==1)
				{
				g.drawImage(area, 700,100,220,50,this);
				g.drawImage(cir, 700,160,300,50, this);
				}
				circom=1;	
				
			}
			else
			{
			radio1.setVisible(true);
			xcord1.setVisible(false);
			ycord1.setVisible(false);
			xcord2.setVisible(false);
			ycord2.setVisible(false);
			xcord3.setVisible(false);
			ycord3.setVisible(false);
			xcord.setVisible(true);
			ycord.setVisible(true);
			rad.setVisible(true);
			submit.setVisible(true);
			
			}
			if(dust==1)
			{
			g.drawArc((int)(cex-ra),(int)(cey-ra),(int)(ra*2),(int)(ra*2),0,360);
			g.drawString("("+(int)cex+","+(int)cey+")",(int)cex,(int)cey);
			g.drawString("("+(int)(cex+ra)+","+(int)cey+")",(int)(cex+ra),(int)cey);
			g.drawLine((int)cex,(int)cey,(int)(cex+ra),(int)(cey));
			frad=ra;
			}
		}
	}
	if(dust==1)
	{
		if(si.getLabel().equals("Click to make circle by entering 3-co-ordinate points"))
		{
			if(count==1)
			{

				xcord1.setVisible(false);
				ycord1.setVisible(false);
				xcord2.setVisible(false);
				ycord2.setVisible(false);
				xcord3.setVisible(false);
				ycord3.setVisible(false);
				submit.setVisible(false);
				
				xcord.setVisible(false);
				ycord.setVisible(false);
				rad.setVisible(false);
				radio1.setVisible(false);
				radio2.setVisible(false);
				radio3.setVisible(false);
			    if(dust==1)
			    {
				g.drawImage(area, 700,100,220,50,this);
				g.drawImage(cir, 700,160,300,50, this);
			    }circom=1;		
			}
			
		else
		{
			xcord.setVisible(false);
			ycord.setVisible(false);
			rad.setVisible(false);
			
			xcord1.setVisible(true);
			ycord1.setVisible(true);
			xcord2.setVisible(true);
			ycord2.setVisible(true);
			xcord3.setVisible(true);
			ycord3.setVisible(true);
			submit.setVisible(true);
		}			
			mw1=(cy1-cy2)/(cx1-cx2);
			mw2=(cy1-cy3)/(cx1-cx3);
			mw3=(cy2-cy3)/(cx2-cx3);
			
			mw1=0.01*Math.ceil((mw1*100));
			mw2=0.01*Math.ceil((mw2*100));
			mw3=0.01*Math.ceil((mw3*100));
			
			
			midx1=(cx1+cx2)/2;
			midy1=(cy1+cy2)/2;
			
			midx1=0.01*Math.ceil((midx1*100));
			midy1=0.01*Math.ceil((midy1*100));
			
			s1=(-1)/mw1;
			
			
			
			
			midx2=(cx1+cx3)/2;
			midy2=(cy1+cy3)/2;
			
			midx2=0.01*Math.ceil((midx2*100));
			midy2=0.01*Math.ceil((midy2*100));
			
			s2=(-1)/mw2;
			
			
			c1=(midy1)-(s1*midx1);
			c2=(midy2)-(s2*midx2);
				
				c1=0.01*Math.ceil((c1*100));
				c2=0.01*Math.ceil((c2*100));
				
				
				mnx=(c1-c2)/(s2-s1);
				mny=c1+(s1*mnx);
				
				mnx=0.01*Math.ceil((mnx*100));
				mny=0.01*Math.ceil((mny*100));
				
				ra=Math.sqrt(Math.pow((cx1-mnx),2)+Math.pow((cy1-mny),2));
				ra=0.01*Math.ceil((ra*100));
			    if(dust==1)
			    {
				g.drawArc((int)(mnx-ra),(int)(mny-ra),(int)(ra*2),(int)(ra*2),0,360);
				g.drawString("("+(int)cx1+","+(int)cy1+")",(int)cx1,(int)cy1);
				g.drawString("("+(int)cx2+","+(int)cy2+")",(int)cx2,(int)cy2);
				g.drawString("("+(int)cx3+","+(int)cy3+")",(int)cx3,(int)cy3);
				g.drawString("("+(int)mnx+","+(int)mny+")",(int)mnx,(int)mny);
				g.drawLine((int)mnx,(int)mny,(int)cx1,(int)cy1);
				g.drawString(""+ra,(int)((cx1+mnx)/2),(int)(cy1+mny)/2);
		        frad=ra;
			    }
		        
		}
	}
		if(ar==1)
		{
			
			g.drawString("Area : "+(3.14*frad*frad), 100,100);
		}
		if(ar==2)
		{
			g.drawString("Circumference : "+(2*3.14*frad),100, 100);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(si.getLabel().equals("Click to make circle by entering 3-co-ordinate points"))
		{
			
			
			String azx1=xcord1.getText();
			String azy1=ycord1.getText();
			String azx2=xcord2.getText();
			String azy2=ycord2.getText();
			String azx3=xcord3.getText();
			String azy3=ycord3.getText();
			
			cx1=Double.parseDouble(azx1);
			cy1=Double.parseDouble(azy1);
			cx2=Double.parseDouble(azx2);
			cy2=Double.parseDouble(azy2);
			cx3=Double.parseDouble(azx3);
			cy3=Double.parseDouble(azy3);
			
count=1;			
			
			
			
			
			
		}
		if(si.getLabel().equals("Click to make circle by entering values"))
		{
			count=1;
		String asx=xcord.getText();
		String asy=ycord.getText();
		String asr=rad.getText();
		
		cex=Double.parseDouble(asx);
		cey=Double.parseDouble(asy);
		ra=Double.parseDouble(asr);
		
		
		}
		
		
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()<=1300&&e.getX()>=1150&&e.getY()<=70&&e.getY()>=40)
		{
			Frame f2=new MainFrame(new mainpage(),1350,650);
		}
		
		if(e.getX()>=1200&&e.getX()<=1250&&e.getY()>=500&&e.getY()<=560)
		{
			dust=0;
		cnt=1;
		radio1.setState(false);
	    si.setState(false);
	    //si.setLabel("");
		radio1.setVisible(true);
		radio2.setVisible(true);
		radio2.setState(false);
		radio3.setVisible(true);
		radio3.setState(false);
		//si.setLabel("");
		ra=0;
		frad=0;
		si=null;
		circom=0;
		ar=0;
		count=0;
		rad.setVisible(false);
		xcord.setVisible(false);
		xcord1.setVisible(false);
		xcord2.setVisible(false);
		xcord3.setVisible(false);
		ycord.setVisible(false);
		ycord1.setVisible(false);
		ycord2.setVisible(false);
		ycord3.setVisible(false);
		xcord.setText("");
		xcord1.setText("");
		xcord2.setText("");
		xcord3.setText("");
		ycord.setText("");
		ycord1.setText("");
		ycord2.setText("");
		ycord3.setText("");
		rad.setText("");
		mx=0;
		my=0;
		cex=0;
		cey=0;
		repaint();}
		
		
		if(e.getX()<=1000&&e.getX()>=700&&e.getY()<=210&&e.getY()>160&&circom==1)
		{
			ar=2;
		}
		if(e.getX()<=920&&e.getX()>=720&&e.getY()<=150&&e.getY()>=100&&circom==1)
		{
			ar=1;
		}
		if(si.getLabel().equals("Click to make circle by clicking on Graph"))
		{
		
		if(cnt==1)
		{dust=1;
		mx=e.getX();
		my=e.getY();
		cex=mx;
		cey=my;
		cnt=2;
		}
		else if(cnt==2)
		{
			mx=e.getX();
			my=e.getY();
			cnt=3;
		}

		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*ax=e.getX();
		ay=e.getY();
		repaint();
		*/
		showStatus("("+e.getX()+","+e.getY()+")");
		if(e.getX()<=1300&&e.getX()>=1150&&e.getY()<=70&&e.getY()>=40)
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		else if(e.getX()>=1200&&e.getX()<=1250&&e.getY()>=500&&e.getY()<=560)
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		else if(e.getX()<=1000&&e.getX()>=700&&e.getY()<=210&&e.getY()>160&&circom==1)
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			//ar=2;
		}
		else if(e.getX()<=920&&e.getX()>=720&&e.getY()<=150&&e.getY()>=100&&circom==1)
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			//ar=1;
		}
		else
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent is) {
		dust=1;
		si=sel.getSelectedCheckbox();
		repaint();
		
	}
}