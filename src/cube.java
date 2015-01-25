import com.sun.j3d.*;
import com.sun.j3d.utils.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.vecmath.*;
import javax.media.j3d.*;

public class cube extends Applet implements MouseMotionListener,MouseListener {

	SimpleUniverse un;
	double vol,area,facediagnal,bodydiagnal;
	
	 float height;
	public cube()
	{
		
	}
	public cube(float height)
	{
		this.height=height;
	      vol=3.14*Math.pow(height,3);
           area=6*Math.pow(height, 2);
           facediagnal=Math.sqrt(2)*height;
           bodydiagnal=Math.sqrt(3)*height;
           vol=Math.ceil(vol*100)*0.01;
           area=Math.ceil(area*100)*0.01;
           facediagnal=Math.ceil(facediagnal*100)*0.01;
           bodydiagnal=Math.ceil(bodydiagnal*100)*0.01;
           
	}
     public void init()
     {
    	 
    	height=height/200;
    	
 		setLayout(null);
		Canvas3D cn=new Canvas3D(un.getPreferredConfiguration());
		cn.setBounds(0, 0, 1350,1000);
		add(cn);
		BranchGroup grp=new BranchGroup();
		un=new SimpleUniverse(cn);
		
		TransformGroup tr=new TransformGroup();
		Transform3D transform=new Transform3D();
		ColorCube con1=new ColorCube(height);
		Vector3f vect=new Vector3f(-0.3f,-0.1f,1.0f);
		transform.setTranslation(vect);
		tr.setTransform(transform);
		tr.addChild(con1);
		Text2D text2d = new Text2D("Body Diagonal :"+bodydiagnal, new Color3f(0.9f,
	            1.0f, 1.0f), "Helvetica", 24, Font.ITALIC);
	  grp.addChild(text2d);
	  TransformGroup txt1=new TransformGroup();
	  Transform3D txttransform=new Transform3D();
	  Vector3f v1=new Vector3f(0.0f,-0.1f,0.0f);
	  txttransform.setTranslation(v1);
	  txt1.setTransform(txttransform);
	  Text2D text2d2=new Text2D("Area :"+area, new Color3f(0.9f,
	            1.0f, 1.0f), "Helvetica", 24, Font.ITALIC);
   //   text2d2.setBoundsAutoCompute(true);
      txt1.addChild(text2d2);
	 grp.addChild(txt1);
	
	 
	 
	
	  TransformGroup txt2=new TransformGroup();
	  Transform3D txttransform2=new Transform3D();
	  Vector3f v2=new Vector3f(0.0f,-0.2f,0.0f);
	  txttransform2.setTranslation(v2);
	  txt2.setTransform(txttransform2);
	  Text2D text2d3=new Text2D("Face Diagonal :"+facediagnal, new Color3f(0.9f,
	            1.0f, 1.0f), "Helvetica", 24, Font.ITALIC);
     // text2d3.setBoundsAutoCompute(true);
      txt2.addChild(text2d3);
	  grp.addChild(txt2); 

	  TransformGroup txt3=new TransformGroup();
	  Transform3D txttransform3=new Transform3D();
	  Vector3f v3=new Vector3f(0.0f,-0.3f,0.0f);
	  txttransform3.setTranslation(v3);
	  txt3.setTransform(txttransform3);
	  Text2D text2d4=new Text2D("Volume :"+vol, new Color3f(0.9f,
	            1.0f, 1.0f), "Helvetica", 24, Font.ITALIC);
     // text2d3.setBoundsAutoCompute(true);
      txt3.addChild(text2d4);
	  grp.addChild(txt3); 
	  
	  TransformGroup txt4=new TransformGroup();
	  Transform3D txttransform4=new Transform3D();
	  Vector3f v4=new Vector3f(0.65f,0.15f,0.0f);
	  txttransform4.setTranslation(v4);
	  txt4.setTransform(txttransform4);
	  Text2D text2d5=new Text2D("Back", new Color3f(0.9f,
	            0.0f, 0.0f), "Helvetica", 20, Font.ITALIC);
     // text2d3.setBoundsAutoCompute(true);
      txt4.addChild(text2d5);
	  grp.addChild(txt4); 

	  
	  
		//grp.addChild(tr);
		 /*Appearance textAppear = new Appearance();
		    ColoringAttributes textColor = new ColoringAttributes();
		    textColor.setColor(1.0f, 0.0f, 0.0f);
		    textAppear.setColoringAttributes(textColor);
		    textAppear.setMaterial(new Material());
		    Font3D font3D = new Font3D(new Font("Helvetica", Font.PLAIN, 1),
		            new FontExtrusion());
		        Text3D textGeom = new Text3D(font3D, new String("Height"));
		        
		        
		    	QuadArray GFront = new QuadArray (4,QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);

		    	GFront.setCoordinate (0, new Point3d (0.85, 0.65, 0));
		    	GFront.setCoordinate (1, new Point3d (0.85, 0.0, 0));
		    	GFront.setCoordinate (2, new Point3d (0.0, 0.65, 0));
		    	GFront.setCoordinate (3, new Point3d (0.0, 0.0, 0));

		    	Shape3D textShape = new Shape3D(GFront,textAppear);
		        textShape.setGeometry(textGeom);
		        textShape.setAppearance(textAppear);
		        grp.addChild(textShape);
		   */     
       
		
		Color3f clr=new Color3f(-0.2f,1.4f,1.3f);
		BoundingSphere b=new BoundingSphere(new Point3d(0.0,0.0,0.0),100);
		Vector3f ldir=new Vector3f(4.0f,-7.0f,-15.0f);
		DirectionalLight ldir1=new DirectionalLight(clr,ldir);
		ldir1.setInfluencingBounds(b);
		grp.addChild(tr);
		grp.addChild(ldir1);
       un.getViewingPlatform().setNominalViewingTransform();
       un.addBranchGraph(grp);	
       cn.addMouseListener(this);
       cn.addMouseMotionListener(this);
     }
     public static void main(String args[])
     {
    	Frame f1=new MainFrame(new cube(),1350,1000); 
     }
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	showStatus(""+e.getX()+","+e.getY());	
	if(e.getX()>=1090&&e.getX()<=1195&&e.getY()<=80&&e.getY()>=40)
    {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   	 //Frame f2=new MainFrame(new cube2d(),1350,650);
    }
	else
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
     if(e.getX()>=1090&&e.getX()<=1195&&e.getY()<=80&&e.getY()>=40)
     {
    	 Frame f2=new MainFrame(new cube2d(),1350,650);
     }
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
