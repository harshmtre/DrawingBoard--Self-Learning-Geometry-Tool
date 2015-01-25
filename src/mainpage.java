import java.awt.*;
import java.applet.*;

import java.awt.event.*;
import java.net.*;

import javax.swing.Icon;

import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;

public class mainpage extends Applet implements MouseListener,MouseMotionListener{
	Image backimg,geom2d,geom3d,quad,tri,cir,formulae;
	URL base;
	
	int drawdem=0;
	MediaTracker mt;
	public void init(){          
		   setLayout(null);
	    setSize(1350,650);
	    addMouseListener(this);
	    addMouseMotionListener(this);
	    mt = new MediaTracker(this);
	    
	    try { 
	    	   // getDocumentbase gets the applet path. 
	    	               base = getDocumentBase(); 
	    	         } 
	    	         catch (Exception e) {}

	    backimg = getImage(base,"Main.JPG");
	    geom2d=getImage(base,"2dgeom.gif");
	    geom3d=getImage(base,"3dgeom.gif");
	    quad=getImage(base,"Quadrilateral.gif");
	    tri=getImage(base,"Triangle.gif");
	    cir=getImage(base,"Circle.gif");
	    formulae=getImage(base,"Formulae1.gif");
	}
	   public void paint(Graphics g)
	   { 
		  g.drawImage(backimg,0,0,1350,650,this);
		  g.drawImage(geom2d,300,150,400,400,this);
            g.drawImage(geom3d,290, 250, 400, 400, this);
           g.drawImage(formulae, 330, 350, 400, 400, this);
            if(drawdem==1)
            {
            	g.drawImage(tri, 600, 150,400,400,this);
            	g.drawImage(quad, 600, 250,400,400,this);
            	g.drawImage(cir, 600, 350,400,400,this);
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
		
		if(e.getX()<=590&&e.getX()>=360&&e.getY()<=450&&e.getY()>=390)
		{
			drawdem=0;
	//		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Frame f=new MainFrame(new cube2d(),1350,650);
		}
		if(e.getX()<=600&&e.getX()>=370&&e.getY()<=350&&e.getY()>=290)
		{
			drawdem=1;
		}
		if(e.getX()>=720&&e.getX()<=850&&e.getY()<=355&&e.getY()>=280)
		{
			Frame f1=new MainFrame(new triangle(),1350,650);
		}
		if(e.getX()>=720&&e.getX()<=850&&e.getY()<=355&&e.getY()>=280)
		{
			Frame f1=new MainFrame(new triangle(),1350,650);
		}
		if(e.getX()>=690&&e.getX()<=900&&e.getY()<=430&&e.getY()>=380)
		{
			Frame f1=new MainFrame(new quadrilateral(),1350,650);
		}
		if(e.getX()>=740&&e.getX()<850&&e.getY()<=530&&e.getY()>=480)
		{
			Frame f1=new MainFrame(new circle(),1350,650);
		}
		if(e.getX()<=570&&e.getX()>=360&&e.getY()<=530&&e.getY()>=470)
		{
			Frame f1=new MainFrame(new formulae(),1350,650);
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
	showStatus(e.getX()+","+e.getY());	
	if(e.getX()<=590&&e.getX()>=360&&e.getY()<=450&&e.getY()>=390)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	}
	else if(e.getX()<=600&&e.getX()>=370&&e.getY()<=350&&e.getY()>=290)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	else if(e.getX()>=720&&e.getX()<=850&&e.getY()<=355&&e.getY()>=280)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	else if(e.getX()>=720&&e.getX()<=850&&e.getY()<=355&&e.getY()>=280)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//Frame f1=new MainFrame(new triangle(),1350,650);
	}
	else if(e.getX()>=690&&e.getX()<=900&&e.getY()<=430&&e.getY()>=380)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//Frame f1=new MainFrame(new quadrilateral(),1350,650);
	}
	else if(e.getX()>=740&&e.getX()<850&&e.getY()<=530&&e.getY()>=480)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//Frame f1=new MainFrame(new circle(),1350,650);
	}
	else if(e.getX()<=570&&e.getX()>=360&&e.getY()<=530&&e.getY()>=470)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//	Frame f1=new MainFrame(new formulae(),1350,650);
	}
	else
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
}	
	

	
}
