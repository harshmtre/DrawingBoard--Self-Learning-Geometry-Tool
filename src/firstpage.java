import java.awt.*;
import java.applet.*;

import java.awt.event.*;
import java.net.*;

import javax.swing.Icon;

import javax.swing.*;

import com.sun.j3d.utils.applet.MainFrame;


public class firstpage extends Applet implements MouseListener,MouseMotionListener {
Image finalback;
URL base;
public void init(){          
	   setLayout(null);
 setSize(1350,650);
 addMouseListener(this);
 addMouseMotionListener(this);
// mt = new MediaTracker(this);
 
 try { 
 	   // getDocumentbase gets the applet path. 
 	               base = getDocumentBase(); 
 	         } 
 	         catch (Exception e) {}

 finalback = getImage(base,"Mainbackground.JPG");
 addMouseListener(this);
 addMouseMotionListener(this);
 
}
public void paint(Graphics g)
{ 
	  g.drawImage(finalback,0,0,1350,650,this);

}
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	showStatus(e.getX()+","+e.getY());
	if(e.getX()<=1050&&e.getX()>=280&&e.getY()<=630&&e.getY()>=170)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	//	Frame f=new MainFrame(new mainpage(),1350,650);
	}
	else
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
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
	// TODO Auto-generated method stub
	if(e.getX()<=1050&&e.getX()>=280&&e.getY()<=630&&e.getY()>=170)
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Frame f=new MainFrame(new mainpage(),1350,650);
	}
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
