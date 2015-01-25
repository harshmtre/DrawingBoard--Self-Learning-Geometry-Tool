import java.awt.*;
import java.applet.*;

import java.awt.event.*;
import java.net.*;

import com.sun.j3d.utils.applet.MainFrame;

public class cube2d extends Applet implements MouseListener,MouseMotionListener{
	int cb1=0,cb2=0,cb3=0,cb4=0;
	Image duster;
	MediaTracker mt;
	URL base;
	Image cube,sphere,cylinder,cubef,spheref,cylinf,conef;
	Image cone;
	Image my_gif;
	Image submit;
	Image back;
	TextField cb=new TextField("side");
	TextField cn1=new TextField("radius");
	TextField cn2=new TextField("height");
	TextField sp=new TextField("radius");
	TextField cyht=new TextField("height");
	TextField cyrad=new TextField("radius");
	public cube2d()
	{

	}
	
	 public void init(){          
		   setLayout(null);
	    setSize(1350,650);
	    mt = new MediaTracker(this);
	    
	    try { 
	    	   // getDocumentbase gets the applet path. 
	    	               base = getDocumentBase(); 
	    	         } 
	    	         catch (Exception e) {}
	    	         back=getImage(base,"back.gif");
	    my_gif = getImage(base,"background.JPG");
        cube=getImage(base,"cube.gif");
	    cone=getImage(base,"cone.gif");
	    sphere=getImage(base,"sphere.gif");
	    cylinder=getImage(base,"cylinder.gif");
	    conef=getImage(base,"cne.gif");
	    cubef=getImage(base,"cbe.gif");
	    cylinf=getImage(base,"cylin.gif");
	    spheref=getImage(base,"sph.gif");
	    submit=getImage(base,"submit.gif");
	  cb.setBounds(370,180, 100, 30);
	  cn1.setBounds(360,400, 100,30);
	  cn2.setBounds(250,400, 100,30);
	  sp.setBounds(800,180, 100,30);
	  cyht.setBounds(1050, 400, 100,30);
	  cyrad.setBounds(1160, 400, 100,30);
	 add(cb);
	 add(cn1);
	 add(cn2);
	 add(sp);
	 add(cyht);
	 add(cyrad);
	 cyht.setVisible(false);
	 cyrad.setVisible(false);
	 cb.setVisible(false);
	 cn1.setVisible(false);
	 cn2.setVisible(false);
	 sp.setVisible(false);
	 addMouseListener(this);
	 addMouseMotionListener(this);
	 }
	 public void paint(Graphics g)
	 {
         
		 g.drawImage(my_gif,0,0,1350,650,this);
		 g.drawImage(back, 1150, 40, 150, 30,this);
		 g.drawImage(cube,60,40,300,300,this);
	     g.drawImage(cubef,0 ,40,400,400,this);
	     g.drawImage(cone, 400,300,300,300,this);
	     g.drawImage(conef, 350,280,400,400,this);
	     g.drawImage(sphere, 550, 40,300,300,this);
	     g.drawImage(spheref, 510, 40,400,400,this);
	     g.drawImage(cylinder,800,300,300,300,this);
	     g.drawImage(cylinf,760,300,400,400,this);
	     if(cb1==1)
	     {
	    	 cn1.setVisible(false);
	    	 cn2.setVisible(false);
	    	 sp.setVisible(false);
	    	 cb.setVisible(true);
	    	 cyht.setVisible(false);
	    	 cyrad.setVisible(false);
	    	 g.drawImage(submit, 340, 230,150,50,this);
	     }
	     if(cb2==1)
	     {
	    	 cyht.setVisible(false);
	    	 cyrad.setVisible(false);
	    	 sp.setVisible(false);
	    	 cb.setVisible(false);
	    	 cn1.setVisible(true);
	    	 cn2.setVisible(true);
	    	 g.drawImage(submit, 300, 450,150,50,this);
	     }
	     if(cb3==1)
	     {
	    	 cn1.setVisible(false);
	    	 cn2.setVisible(false);
	    	 sp.setVisible(true);
	    	 cb.setVisible(false);
	    	 cyht.setVisible(false);
	    	 cyrad.setVisible(false);
	    	 g.drawImage(submit,780,220,150,50,this);
	     }
	     if(cb4==1)
	     {
	    	 cn1.setVisible(false);
	    	 cn2.setVisible(false);
	    	 sp.setVisible(false);
	    	 cb.setVisible(false);
	    	 cyht.setVisible(true);
	    	 cyrad.setVisible(true);
	    	 g.drawImage(submit, 1100, 440,150,50,this);
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
		if(e.getX()>=60&&e.getX()<=360&&e.getY()>=40&&e.getY()<=340)
		{
			cb3=0;
			cb1=1;
			cb2=0;
			cb4=0;
		}
		if(e.getX()>=400&&e.getX()<=700&&e.getY()>=300&&e.getY()<=600)
		{
			cb3=0;
			cb1=0;
			cb2=1;
			cb4=0;
		}
		if(e.getX()>=550&&e.getX()<=850&&e.getY()>=40&&e.getY()<=340)
		{
			cb3=1;
			cb1=0;
			cb2=0;
			cb4=0;
		}
		if(e.getX()>=800&&e.getX()<=1100&&e.getY()>=300&&e.getY()<=600)
		{
			cb3=0;
			cb1=0;
			cb2=0;
			cb4=1;
			
		}
		if(e.getX()>=300&&e.getX()<=450&&e.getY()>=450&&e.getY()<=500)
		{
			float htf=Float.parseFloat(cn1.getText());
			float rad=Float.parseFloat(cn2.getText());
	           Frame f=new MainFrame(new cone(rad,htf),1350,1000);
	
		}
		if(e.getX()>=340&&e.getX()<=490&&e.getY()>=230&&e.getY()<=280)
		{
			float side=Float.parseFloat(cb.getText());
			Frame f1=new MainFrame(new cube(side),1350,1000);
		}
		if(e.getX()>=1100&&e.getX()<=1250&&e.getY()>=440&&e.getY()<=490)
		{
			float cylinht=Float.parseFloat(cyht.getText());
			float cylinrad=Float.parseFloat(cyrad.getText());
			Frame cylinf=new MainFrame(new cylin(cylinrad,cylinht),1350,1000);
		}
		if(e.getX()>=780&&e.getX()<=930&&e.getY()>=220&&e.getY()<=270)
		{
			float sphr=Float.parseFloat(sp.getText());
			Frame fsp=new MainFrame(new sphere(sphr),1350,1000);
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
